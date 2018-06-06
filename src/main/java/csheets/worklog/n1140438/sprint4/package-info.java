/**
 * Technical documentation regarding the work of the team member (1140438) André Oliveira during week4. 
 * 
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.-
 *
 * <h2>2. Use Case/Feature: LANG01.3 - Eval and While Loops</h2>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-29">Issue in Jira</a>
 * <p>
 * -Include the identification and description of the feature-
 * 
 * <h2>3. Requirement</h2>
 * Add the 'Eval' function. This function has a single parameter that is a string. 
 * When executed, this function will 'compile' the formula contained in the only 
 * parameter and execute the resulting expression. The result of 'Eval' is the 
 * result of the execution of the compiled expression. 
 * For example, if we write the following formula '=“ 2 + 3 “' we get the string “2 + 3“ in the cell. 
 * However, if we write the formula '= eval (“ 2 + 3 “)' the value obtained in the cell is '5'. 
 * Add the following two loop functions: 'DoWhile' and 'WhileDo'. The 'DoWhile' executes the first 
 * expression in loop while the second expression evaluates to true. In each iteration of the loop 
 * the the first expression is the first to be evaluated. The 'WhileDo' executes the second expression 
 * in loop while the first evaluates to true. In each iteration of the loop the the first expression 
 * is the first to be evaluated. Example: '= {@Counter:=1; WhileDo(Eval( “A“&@Counter)> 0;
 * {C1:=C1+Eval(“B“&@Counter); @Counter:=@Counter+1 }) }'. 
 * In this example, the cell C1 will get the sum of all the values of column B 
 * in that the corresponding values in column A are greater than zero.
 * 
 * <p>
 * These requirements must be organized in three use cases showed in the following diagram.
 * <p>
 * <b>Implementation of Eval Function</b>
 * <p>
 * <b>Implementation of WhileDo loop</b>
 * <p>
 * <b>Implementation of DoWhile loop</b>
 * <p>
 * <img src="doc-files/lan013.png" alt="image"> 
 * 
 * <p>
 * <b>Use Case "Use Eval Function":</b> 
 * The user select the cell
 * The System asks for the expression.
 * The user introduce the expression and the values.
 * The System returns the assigned value to the cell.
 * 
 * <p>
 * <img src="doc-files/ssd_eval.png" alt="image">
 * 
 * <p>
 * <b>Use Case "Use WhileDo Function":</b> 
 * The user select the cells.
 * The System asks for the expression.
 * The user introduce the expression and the values.
 * The System returns the assigned value to the cells.
 * 
 * <p>
 * <img src="doc-files/ssd_whiledo.png" alt="image">
 * 
 * <p>
 * <b>Use Case "Use DoWhile Function":</b> 
 * The user select the cells.
 * The System asks for the expression.
 * The user introduce the expression and the values.
 * The System returns the assigned value to the cells.
 * 
 * <p>
 * <img src="doc-files/ssd_dowhile.png" alt="image">
 *  
 * <h2>4. Analysis</h2>
 * 
 * <h3>First "analysis" sequence diagram</h3>
 * 
 * According the interpretation of the probleam, this feature has relationships
 * with Lang02 feature but also have additional requirements like the implementation
 * of the eval function and the "while do" and "do while" loops.
 * Will be necessary the implementation of a grammar file to use in the eval function.
 * This grammar final must discern a string ("=" 2 + 3 "") from a formula ("=eval (" 2 + 3")").
 * Must be genrated with the grammar file, a parser and a lexer java files.
 * The Eval, WhileDo and DoWhile functions must have a java file too, to be possible the
 * interaction with the cell listeners. The WhileDo and DoWhile are similar to the For already
 * implemented. The proprietes file "language.props" must be updated with these new funcions
 * 
 * <p>
 * 1.Eval Function Preview Example
 * <p>
 * <img src="doc-files/eval_example.png" alt="image"> 
 * 
 * <p>
 * 2.DoWhile Function Preview Example
 * 
 * <p>
 * <img src="doc-files/DoWhile_example.png" alt="image">
 * 
 * <p>
 * 3.WhileDo Function Preview Example
 * 
 * <p>
 * <img src="doc-files/WhileDo_example.png" alt="image"> 
 * 
 * <h3>Analysis of Core Technical Problem</h3>
 * 
 * The existing code must be updated to permit multiple operations:
 * <pre>
 * 
 * {@code 
 *      function_call
            :	FUNCTION^ LPAR! 
		( comparison ( SEMI! comparison )* )?
		RPAR!
            |   FUNCTION^ LBRA! ( assignment SEMI! comparison SEMI! assignment ( SEMI! operation )* )? RBRA!
            ;
 * }
 * 
 * </pre>
 * 
 * <h2>5. Design</h2>
 *
 * <h3>5.1. UC Realization</h3>
 * <h3>User interaction GUI when puts a formula in a cell</h3>
 * The following diagram shows the user interaction GUI when puts a formula in a cell
 * <p>
 * <img src="doc-files/sequence_diagram_user_gui_interaction.png" alt="image">
 * 
 * <h3>Interaction with function lexer and parsers</h3>
 * The following diagram shows the user interaction when a funcion needs to be executed
 * <p>
 * <img src="doc-files/sequence_diagram_general_formula_compiler.png" alt="image">
 * 
 * <h3>User of Eval Function</h3>
 * The following diagram shows the use of Eval function
 * <p>
 * <img src="doc-files/sequence_diagram_eval.png" alt="image">
 * <p>
 * The following image represents the eval tree generated on ANTLRWORKS
 * <p>
 * <img src="doc-files/eval_tree.jpg" alt="image">
 * <p>
 * The following image represents the eval sintax/parser tree generated on ANTLRWORKS
 * <p>
 * <img src="doc-files/eval_sintax_tree.jpg" alt="image">
 * 
 * <h3>User of While Do Function</h3>
 * The following diagram shows the use of While Do function
 * <p>
 * <img src="doc-files/sequence_diagram_whiledo.png" alt="image">
 * <p>
 * The following image represents the while do tree generated on ANTLRWORKS
 * <p>
 * <img src="doc-files/whiledo_tree.jpeg" alt="image">
 * <p>
 * The following image represents the while do sintax/parser tree generated on ANTLRWORKS
 * <p>
 * <img src="doc-files/whiledo_sintax_tree.jpg" alt="image">
 * 
 * <h3>User of Do While Function</h3>
 * The following diagram shows the use of Do While function
 * <p>
 * <img src="doc-files/sequece_diagram_dowhile.png" alt="image">
 * <p>
 * The following image represents the do while tree generated on ANTLRWORKS
 * <p>
 * <img src="doc-files/dowhile_tree.jpg" alt="image">
 * <p>
 * The following image represents the while do sintax/parser tree generated on ANTLRWORKS
 * <p>
 * <img src="doc-files/dowhile_sintax_tree.jpg" alt="image">
 * 
 * <h2>6. Implementation</h2>
 * 
 * <p>
 * <b>Code in Formula.g updated to permit multiple operations:</b>
 * <pre>
 * 
 * {@code 
    function_call
	: WHILE^ LPAR! 
		( operation ( SEMI! operation )* )?
		RPAR!
	| FUNCTION^ LPAR! 
		( comparison ( SEMI! comparison )* )?
		RPAR!	
	| FUNCTION^ LBRA! ( assignment SEMI! comparison SEMI! assignment ( SEMI! operation )* )? RBRA!		
	;
 * }
 * 
 * {@code
 *      WHILE	: 'dowhile' | 'whiledo' | 'DoWhile' | 'WhileDo' | 'DOWHILE' | 'WHILEDO'
	;
 * }
 * 
 * Expression sintax:
 * <p>
 * <img src="doc-files/function_call_sintax.png" alt="image">
 * 
 * </pre>
 * 
 * Code elements should be found in in the classes Eval, WhileDo, DoWhile:
 * <p>
 * {@link csheets.core.formula.lang}
 * 
 * <h2>7. Integration/Demonstration</h2>
 * 
 * The tests can be found in the Test Packages folder's for the classes EvalTest, WhileDoTest, DoWhileTest:
 * <p>
 * {@link csheets.core.formula.lang}
 * 
 * <p>
 * Example of some expressions that was tested:
 * 
 * <pre>
 * {@code 
 * 
 * =WhileDo(A1<5;{B1:=B1+2;A1:=A1+1})
 * =WhileDo(eval("A"&1)<5;{B1:=B1+2;A1:=A1+1})
 * =DoWhile(B1:=B1+2;A1=1)
 * =DoWhile(B1:=B1+2;B1<5)
 * =eval("euro{2$+2$}")
 * ={_c:=1;WhileDo(A1<5;{A1:=A1+1;_c:=_c+1})}
 * ={_c:=1;WhileDo(eval("B"&_c)<6;A1:=A1+1;_c:=_c+1)}
 * ={_c:=1;WhileDo(eval("B"&_c)<6;C2:=C2+eval("B"&_c);A1:=A1+1;_c:=_c+1)}
 * ={_c:=1;DoWhile(_c:=_c+1;A1:=A1+1;eval("B"&_c)<6)}
 * ={_c:=1;DoWhile(_c:=_c+1;C2:=C2+eval("B"&_c);eval("B"&_c)<6)}
 * 
 * }
 * 
 * </pre>
 * 
 * <h2>8. Work Log</h2> 
 * 
 * <b>Saturday -  18 of June</b>
 * <p>
 * Analysis/Design of the feature.
 * <p>
 * Blocking: Jenkins build failure
 * <p>
 * <b>Sunday -  19 of June</b>
 * <p>
 * Analysis/Design of the feature.
 * <p>
 * Blocking: Problems in AntlrWorks. My laptop has problems when the antlrWork jar is executed. The java cannot be executed.
 * <p>
 * <b>Monday -  20 of June</b>
 * <p>
 * Implementation and Tests. Reajust analysis.
 * <p>
 * Blocking: Problems in assigment function. There are some problems in assigment function when the cell value is updated
 * <p>
 * <b>Tuesday -  21 of June</b>
 * <p>
 * Implementation and Tests. Diagrams Desgign Reajustment. Some manual tests
 * <p>
 * Blocking: Problems in assigment function. There are some problems in assigment function when the cell value is updated
 * <p>
 * <b>Tuesday -  22 of June</b>
 * <p>
 * Implementation Ajustments. Digrams Desgign Reajustment. Some manual tests
 * <p>
 * Blocking: Problems in assigment function. There are some problems in assigment function when the cell value is updated
 * <p>
 * <b>Evidences of Work:</b>
 * <p>
 * - url of commits: 
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/fff34f060a849cca37bd692a8f21b49083e5dbe1">Commit Analysis 1</a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/ec6299ea86ece5eaebe835ad80cf1151d56cadbf">Commit Analysis 2</a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/38888b41490e13e391c44946e433a6e912545575">Commit Design 1</a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/911a7e8ac88e3895177f73f8d7f6ddeda4f1b017">Commit Design 2</a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/9ae8204957bdc69b5598f23a262ebd5cb549599e">Commit Implementation 1 </a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/8f196576c46897298e53a9ce64b6a3f88058c03f">Commit Implementation 2 </a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/85652e452442c06834a906845a5121d0f9f50d8d">Commit Test 1 </a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/95a5c34f8f3cd8d56699c4a14f34e45c8d4342b0">Commit Test 2 </a>
 * 
 * <h3>8.1. Teamwork: </h3>
 * Bernardo Meira (1140809) help me a lot with in the implementation. He gave me a lot of support understating funcions component
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-234">Issue for Implementation Support</a>
 * <p>
 * Pedro Costa (1140806) help me in ANTLRWORKS use because the running problem in my laptop
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-253">Issue for ANTLRWORKS Support</a>
 * <p>
 * Sara Ramos (1140411) help me manual tests with function expression of (Eval, WhileDo and DoWhile) and problems with Math in loop
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-254">Issue for Expression Support</a>
 * 
 * @author André Oliveira
 */

package csheets.worklog.n1140438.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author alexandrebraganca
 */
class _Dummy_ {}

