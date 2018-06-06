package csheets.core.formula.compiler;

import csheets.core.Cell;
import csheets.core.formula.*;
import csheets.core.formula.lang.Language;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

/**
 * Implements the monetary formulas in cleanSheets.
 * @author Pedro Costa
 */
public class MonetaryExpressionCompiler implements ExpressionCompiler
{
    /** The character that signals that a cell's content is a Monetary Formula ('#') */
    public static final char FORMULA_STARTER = '#';

    /**
     * Returns monetary formula start character.
     *
     * @return char
     */
    @Override
    public char getStarter()
    {
        return MonetaryExpressionCompiler.FORMULA_STARTER;
    }

    /**
     * Compile a string from an expression and to a cell.
     * @param cell the cell for which the expression is to be compiled
     * @param source a string representing the expression to be compiled
     * @return Expression
     * @throws FormulaCompilationException
     */
    public Expression compile(Cell cell, String source) throws FormulaCompilationException
    {

        // Creates the lexer and parser
        ANTLRStringStream input = new ANTLRStringStream(source);

        // Create the buffer of tokens between the lexer and parser
        MonetaryFormulaLexer lexer = new MonetaryFormulaLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        MonetaryFormulaParser parser = new MonetaryFormulaParser(tokens);

        CommonTree tree;

        try {
            tree=(CommonTree)parser.expression().getTree();
        }
        catch (RecognitionException e) {

            StringBuilder errorMsg = new StringBuilder();
            errorMsg.append("At (").append(e.line).append(";").append(e.charPositionInLine).append("): ");
            errorMsg.append(parser.getErrorMessage(e, parser.tokenNames));
            throw new FormulaCompilationException(errorMsg.toString());

        } catch (Exception e) {
            String message="Other exception : " + e.getMessage();
            throw new FormulaCompilationException(message);
        }

        // Converts the expression and returns it
        return convert(cell, tree);
    }

    /**
     * Converts the given ANTLR AST to an expression.
     * @param cell cell
     * @param node the abstract syntax tree node to convert
     * @return the result of the conversion
     * @throws csheets.core.formula.compiler.FormulaCompilationException exception
     */
    protected Expression convert(Cell cell, Tree node) throws FormulaCompilationException
    {
        String currency;
        String outputCurrency;
        BinaryOperator operator;
        Tree outputCurrencyNode;

        //Final value
        if(node.getChildCount() == 0 && node.getType() == MonetaryFormulaLexer.NUMBER)
        {
            currency = node.getParent().getChild(node.getChildIndex()+1).getText();

            outputCurrencyNode = getTopNode(node);
            outputCurrency = outputCurrencyNode.getText();

            return new LiteralCurrency(node.getText(), currency, outputCurrency);
        }

        //Operator, amount and currency symbol
        if(node.getChildCount() == 3)
        {

            outputCurrencyNode = getTopNode(node);
            outputCurrency = outputCurrencyNode.getText();
            operator = Language.getInstance().getBinaryOperator(node.getText());

            if(node.getChild(1).getType() == MonetaryFormulaLexer.NUMBER)
            {
                return new BinaryOperation(convert(cell, node.getChild(0)), operator,
                        new LiteralCurrency(node.getChild(1).getText(), node.getChild(2).getText(), outputCurrency));
            }
            else
            {
                return new BinaryOperation(
                    new LiteralCurrency(node.getChild(0).getText(),
                            node.getChild(1).getText(), outputCurrency), operator,convert(cell, node.getChild(2)));
            }
        }

        //Root with return currency
        if(node.getChildCount() == 1)
        {
            return convert(cell, node.getChild(0));
        }

        //Two values and two coin types
        if(node.getChildCount() == 4)
        {
            operator = Language.getInstance().getBinaryOperator(node.getText());
            return new BinaryOperation(convert(cell, node.getChild(0)), operator, convert(cell, node.getChild(2)));
        }

        if(node.getChildCount()==2 && node.getChild(0).getType() == MonetaryFormulaLexer.NUMBER &&
                this.isCurrencySymbol(node.getChild(1)))
        {
            outputCurrencyNode = getTopNode(node);
            return new LiteralCurrency(node.getChild(0).getText(), node.getChild(1).getText(), outputCurrencyNode.getText());
        }

        throw new FormulaCompilationException("MonetaryExpressionCompilerException");
    }

    /**
     * Get the top node of the tree.
     * @param node The node from which we want the top node
     *
     * @return Tree Node
     */
    protected Tree getTopNode(Tree node)
    {
        Tree outputNode = node.getParent();

        if(outputNode == null)
            return node;

        while(outputNode.getParent() != null)
            outputNode = outputNode.getParent();

        return outputNode;
    }

    /**
     * Check if node is of currency symbol type.
     *
     * @param node Node to check
     *
     * @return boolean true if is currency symbol type, false otherwise
     */
    protected boolean isCurrencySymbol(Tree node)
    {
        return node.getType() == MonetaryFormulaLexer.EUR_SYM || node.getType() == MonetaryFormulaLexer.POUND_SYM ||
            node.getType() == MonetaryFormulaLexer.DOLLAR_SYM;
    }
}
