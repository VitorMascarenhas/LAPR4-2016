/**
 * Technical documentation regarding the work of the team member (1060708) Eduardo Silva during week1. 
 * 
 * <p>
 * 
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Analysis, Design, Tests and Implementation of lang02.01 issue-
 * <p>
 * -In this section you should register important notes regarding your work during the week.
 * For instance, if you spend significant time helping a colleague or if you work in more than a feature.-
 *
 * <h2>2. Use Case/Feature: Lang02.1</h2>
 * 
 * Issue in Jira: http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-30
 * <p>
 * Lang02.1- Temporary Variables
 * 
 * <h2>3. Requirement</h2>
 * 
 *Add support for temporary variables. The name of temporary variables must start with the '_' sign. When a variable is referred in a formula for the first time it is created. To set the value of a variable it must be used on the left of the assign operator (':='). Temporary variables are variables that only exist in the context of the execution of a formula. Therefore, it is possible for several formulas to use temporary variables with the same name and they will be different instances. Example: '= {_Counter:=1; WhileDo(Eval( “A“&_Counter)> 0;
 *{C1:=C1+Eval(“B“&_Counter); _Counter:=_Counter+1 }
 *
 *) }' . In this example, the cell C1 will get the sum of all the values of column B in that the corresponding values in column A are greater than zero.
 *
 * <p>
 * <b>Use Case "Enable and Disable Extensions":</b> Add support for temporary variables. The name of temporary variables must start with the '_' sign. When a variable is referred in a formula for the first time it is created. To set the value of a variable it must be used on the left of the assign operator (':='). Temporary variables are variables that only exist in the context of the execution of a formula. Therefore, it is possible for several formulas to use temporary variables with the same name and they will be different instances. Example: '= {_Counter:=1; WhileDo(Eval( “A“&_Counter)> 0;{C1:=C1+Eval(“B“&_Counter); _Counter:=_Counter+1 }}' . In this example, the cell C1 will get the sum of all the values of column B in that the corresponding values in column A are greater than zero.
 * 
 *  
 * <h2>4. Analysis</h2>
 * Need to study how Temporal Variables can be used, similar as a cell Reference
 * 
 * 
 * 
 * <h3>First "analysis" diagram</h3>
 * <p>
 * <img src="doc-files/lang02_01_analysis.png" alt="image"> 
 * <p>
 * 
 * <h3>Analysis of The Language to be used</h3>
 * It is defined that the langugage of TemporalVariables starts with an "_".
 * <p>
 * 
 * <p>
 * <img src="doc-files/Lang02.1-TemporalVariableGrammar.jpg" alt="image"/>
 * 
 * <p>Initialy was thought to be implemente without of the reference, because it as the method to get cells. Since it was easier to use implementing the Reference, the implementation started like the next picture</p>
 * <img src="doc-files/lang02_01_analysis_v2.png" alt="image"> 
 * <p>
 * It was to check the tree that was in need to be parsed, and if it was an Temporal Variable, how to save the information and convert. The next sample of code shows some of the code implemente, but not submited
 * <pre>
 * {@code 
       **
         * receives a variable node and creates the variable if it doesn't exists
         * @param cell
         * @param node
         * @return 
         *
*        public Expression variableCompile(Cell cell, Tree node) throws UnknownElementException {
*           BinaryOperator op = Language.getInstance().getBinaryOperator(node.getText());
*            if(op instanceof Assignment){
*                TemporalVariable tempV = ((CellImpl) cell).getTempVariableFromList(node.getChild(0).getText());
*                if(node.getChild(1).getChildCount()>0){
*                    System.out.println("asdasdasdaddasdasdasd " + node.getChild(1).getChild(0).getText());
*                }
*                if(tempV==null){
*                    if(node.getChild(1).getChildCount()==0){
*                        tempV = new TemporalVariable(node.getChild(0).getText(), Value.parseValue(node.getChild(1).getText()), cell, cell.getSpreadsheet());
*                        tempV.addTempVariableToList();
*                        System.out.println("(2)(2) "+ node.getChild(0).getText());
*                        System.out.println("(2)(2) "+ node.getChild(1).getText());
*                        //System.out.println("(2)(2) "+ node.getChild(2).getText());
*                        System.out.println("(2)Temp name "+ tempV.getName());
*                        System.out.println("(2)Temp value "+ tempV.getValue());
*                        return tempV;
*                    }else{
*                        System.out.println("ENTROUUUUUUU");
*                        try {
*                            tempV = new TemporalVariable(node.getChild(0).getText(), Value.parseValue(node.getChild(1).getText()), cell, cell.getSpreadsheet());
*                            tempV.addTempVariableToList();
*                            Literal myLiteral = new Literal(Value.parseValue(tempV.getValue().toString()));
*                            return new BinaryOperation(myLiteral, op, convert(cell, node.getChild(1)));
*                        } catch (FormulaCompilationException ex) {
*                            Logger.getLogger(ExcelExpressionCompiler.class.getName()).log(Level.SEVERE, null, ex);
*                        }
*                    }
*                }else{
*                    if(node.getChild(1).getChildCount()==0){
*                        System.out.println("asd--" + node.getChild(0).getText());
*                        System.out.println("asd---" + Value.parseValue(node.getChild(1).getText()));
*                        tempV.setValue(Value.parseValue(node.getChild(1).getText()));
*                        tempV.addTempVariableToList();
*                        System.out.println("(3)Temp name "+ tempV.getName());
*                        System.out.println("(3)Temp value "+ tempV.getValue());
*                        return tempV;
*                    }else{
*                        System.out.println("ENTROUUUUUUU");
*                        try {
*                            tempV = new TemporalVariable(node.getChild(0).getText(), Value.parseValue(node.getChild(1).getText()), cell, cell.getSpreadsheet());
*                            tempV.addTempVariableToList();
*                            Literal myLiteral = new Literal(Value.parseValue(tempV.getValue().toString()));
*                            return new BinaryOperation(myLiteral, op, convert(cell, node.getChild(1)));
*                        } catch (FormulaCompilationException ex) {
*                            Logger.getLogger(ExcelExpressionCompiler.class.getName()).log(Level.SEVERE, null, ex);
*                        }
*                    }
*                }                
*            }else{
*                System.out.println("ENTROUUUUUUU3");
*                try {
*                    TemporalVariable tempV = ((CellImpl) cell).getTempVariableFromList(node.getChild(0).getText());
*                    Literal myLiteral = new Literal(Value.parseValue(tempV.getValue().toString()));
*                    return new BinaryOperation(myLiteral, op, convert(cell, node.getChild(2)));
*                } catch (FormulaCompilationException ex) {
*                 Logger.getLogger(ExcelExpressionCompiler.class.getName()).log(Level.SEVERE, null, ex);
*              }
*           }
*         
*             return null;
*       }
 * }
 * </pre>
 * 
 * <pre>
 * 
 * {@code
*public class TemporalVariable implements Reference{
*    String name;
*    Value value;
*    static int cont = 0;
*    private Spreadsheet spreadsheet;
*    Cell cell;
*    private SortedSet<Cell> cells = new TreeSet<Cell>();
*    private static final Pattern PATTERN = Pattern.compile(
*            "_([a-zA-Z])(a-zA-Z|[1-9])*"
*    );
*    
*    
*    public TemporalVariable(String name, Value value, Cell cell, Spreadsheet spreadsheet){
*        this.name = name;
*        this.value = value;
*        this.cell = cell;
*        this.spreadsheet = spreadsheet;
*        this.cont++;
*        System.out.println("conta " + this.cont);
*        System.out.println("value" + this.value);
*        //addTempVariableToList();
*    }
*    
*    public TemporalVariable(String name, Value value, Cell cell){
*        this.name = name;
*        this.value=value;
*        this.cell = cell;
*    }
*    
*    @Override
*    public Value evaluate(){
*        return this.value;
*    }
*
*    @Override
*    public Object accept(ExpressionVisitor visitor) {
*        System.out.println("visitor  " + visitor.visitReference((Reference)this).toString());
*        return visitor.visitReference((Reference)this);
*    }
*    
*    public void setValue(Value value){
*      this.value = value;
*    }
*    
*    public Value getValue(){
*      return this.value;
*    }
*    
*    public String getName(){
*        return this.name;
*    }
*    
*    public Cell getCellImpl(){
*        return this.cell;
*    }
*
*    public void addTempVariableToList(){
*        ((CellImpl) cell).addTempVariableToList(this);
*    }
*    
*    @Override
*    public int compareTo(Reference reference) {
*        TemporalVariable var = (TemporalVariable) reference;
*        if(var.getName().compareTo(this.getName())==0){
*            return var.getValue().compareTo(this.getValue());
*        }else{
*            return -1;
*        }
*    }
*
*    @Override
*    public SortedSet<Cell> getCells() {
*        return this.cells;
*    }
*    
*    @Override
*    public String toString(){
*        return this.getValue().toString();
*    }
*
*}
*
 * }
 * </pre>
 * As we can see from the code, if we are requesting a extension that is not already present in the cell, it is applied at the moment and then returned. The extension class (that implements the <code>Extension</code> interface) what will do is to create a new instance of its cell extension class (this will be the <b>delegator</b> in the pattern). The constructor receives the instance of the cell to extend (the <b>delegate</b> in the pattern). For instance, <code>StylableCell</code> (the delegator) will delegate to <code>CellImpl</code> all the method invocations regarding methods of the <code>Cell</code> interface. Obviously, methods specific to <code>StylableCell</code> must be implemented by it.
 * Therefore, to implement a cell that can have a associated comment we need to implement a class similar to <code>StylableCell</code>.
 * 
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * Basically, from requirements and also analysis, we see that the core functionality of this use case is to be able to add an attribute to cells to be used to store a comment/text. We need to be able to set and get its value.
 * Following this approach we can start by coding a unit test that uses a subclass of <code>CellExtension</code> with a new attribute for user comments with the corresponding method accessors (set and get). A simple test can be to set this attribute with a simple string and to verify if the get method returns the same string.
 * As usual, in a test driven development approach tests normally fail in the beginning. The idea is that the tests will pass in the end. 
 * <p>
 * see: <code>csheets.ext.comments.CommentableCellTest</code>
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to create a map in CellImpl class. We will also need to create a class of TemporalVariable. For the sidebar we need to implement a JPanel. In the code of the extension <code>csheets.ext.style</code> we can find examples that illustrate how to implement these technical requirements.
 * The following diagrams illustrate core aspects of the design of the solution for this use case.
 * <p>
 * <b>Note:</b> It is very important that in the final version of this technical documentation the elements depicted in these design diagrams exist in the code!
 * 
 * <h3>5.3. Classes</h3>
 * 
 * 
 * <h2>7. Integration/Demonstration</h2>
 * 
 * -In this section document your contribution and efforts to the integration of your work with the work of the other elements of the team and also your work regarding the demonstration (i.e., tests, updating of scripts, etc.)-
 * 
 * <h2>8. Final Remarks</h2>
 * 
 * -In this section present your views regarding alternatives, extra work and future work on the issue.-
 * <p>
 * As an extra this use case also implements a small cell visual decorator if the cell has a comment. This "feature" is not documented in this page.
 * 
 * 
 * <h2>9. Work Log</h2> 
 * 
 * -Insert here a log of you daily work. This is in essence the log of your daily standup meetings.-
 * <p>
 * <p>
 * <b>Tuesday</b>
 * <p>
 * <p>
 * Today
 * <p>
 * 1. -Analysis of the issue lang02_01-
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Wednesday</b>
 * <p>
 * 
 * <p>
 * 1. -Implementation of the issue lang02_01-
 * <p>
 * Blocking:
 * <p>
 * 1. -cannot parse elements like _var:05+3. Continues to add the '+' sign as value-
 * 
 * <h2>10. Self Assessment</h2> 
 * 
 * -Insert here your self-assessment of the work during this sprint.-
 * 
 * <h3>10.1. Design and Implementation:3</h3>
 * 
 * 3-Still blocked on parsing the values.
 * <p>
 * <b>Evidences:</b>
 * <p>
 * - https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/cb080f4891c43ee5aeb25da112ab77529c2eb729: ... - description: this commit is related to the to the analisys/design of the methos and grammar and the close of the sub-task-
 * - https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/2c58b5d88563c0a8e38ea8a2a7f13548bacd53d3: ... - description: this commit is related to the analisys/design of the methos and grammar-
 * - https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/b5da55a2826be9f60780b4c5743c259dee99fab0: ... - description: this commit is related to the implementation of the grammar and some necessary classes ...-
 * 
 * <h3>10.2. Teamwork: </h3>
 * 
 * <h3>10.3. Technical Documentation: <img src="doc-files/lang02_01_analysis_v2.png" alt="image"> <img src="doc-files/lang02_01_analysis.png" alt="image"> </h3>
 * 
 * @author alexandrebraganca
 */

package csheets.worklog.n1060708.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author alexandrebraganca
 */
class _Dummy_ {}

