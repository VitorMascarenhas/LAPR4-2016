/**
 * Technical documentation regarding the work of the team member (1140411) Sara Ramos during week1. 
 * Team partner: Bernardo Meira, 1140809
 * 
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 * 
 * <h2>1. Notes</h2>
 * This week:
 * <p>
 * - Study and analysis of the problem were made in order to the fully understand of it.
 * <p>
 * - The apllication CleanSheets was explored and studied.
 * <p>
 * - The problem was described and diagrams illustrating the knowledge of the problem were made.
 * <p>
 * - Spend some time helping the area leader programming the team 2NA schedule for the next three weeks.
 *
 * <h2>2. Use Case/Feature: Lang01.1</h2>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-27">Issue in Jira</a>
 * <p>
 * Add the possibility of writing blocks (or sequences) of instructions. A block must be delimited by curly
 * braces and its instructions must be separated by ";". The instructions of a block are executed sequentially
 * and the block "result" is the result of the last statement of the block. For example, the formula "= {1+
 * 2; sum (A1:A10), B3 + 4 }" must result in the sequential execution of all expressions and the result
 * is the value of the expression "B3 + 4". Add the assign operator (its symbol is ":="). This operator
 * assigns to its left the result of the right expression. At the moment the left of the assign operator can only
 * be a cell reference. The FOR loop should also be implemented based on instruction blocks. For example,
 * the formula "= FOR {A1: = 1 ; A1&lt;10; A2: = A2 + A1; A1: = A1 + 1 }" executes a for loop in
 * which: the first expression is the initialization, the second term is the boundary condition, all other
 * expressions are performed for each iteration of the loop.
 * 
 * <p>
 * These requirements must be organized in three use cases showed in the following diagram.
 * <p>
 * <img src="doc-files/UCLang01.1.png" alt="Use Cases - Lang 01.1"> 
 * 
 * <h2>3. Requirement</h2>
 * Changes in the grammar must be made in order to recognize sequences of expressions and a for loop based on instructions.
 * The assign operator must be defined.
 * 
 * <p>
 * <b>Use Case "Block of Instructions":</b> 
 * The user selects the cell where he/she wants to enter a sequence of expressions or a for loop based on instructions or an assignment operation.
 * The system displays the result on cell. 
 *  
 * <h2>4. Analysis</h2>

 * <h3>First "analysis" sequence diagram</h3>
 * The following diagrams depicts a proposal for the realization of the previously described use cases. 
 * <p>
 * <b>Insert sequence expressions in the cells </b>
 * <p>
 * <img src="doc-files/SequenceExpressions.png" alt="Diagram 1"> 
 * <p>
 * 
 * <b>Insert for loop of expressions in the cells </b>
 * <p>
 * <img src="doc-files/ForLoopExpressions.png" alt="Diagram 2"> 
 * <p>

 * <b>Assign to a cell an expression</b>
 * <p>
 * <img src="doc-files/AssignToCell.png" alt="Diagram 3"> 
 * <p>
 * 
 * From the study made of the existing classes to implement the requirements, it is necessary to add in <code>language.props</code> at the topic "pseudo-statements" the functions FOR and Block and at "Miscellaneous binary operator" the operator Assignment.
 * Three new classes must be create {@link csheets.core.formula.lang.Assignment}; {@link csheets.core.formula.lang.Block} and {@link csheets.core.formula.lang.For}.
 * Language must be redefined in order to accept the sequence of instructions (see <code>Formula.g</code>).
 * 
 * 
 * <h3>Analysis of Core Technical Problem</h3>
 * 
 * The changes in language are expressed in the code:
 * <pre>
 * {@code 
 * 	block
            : LBRA^ operation (SEMI! operation)+  RBRA!
            ;
 * }
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
 * {@code 
 * 	Comparison operators
 *         ASSIGN  : ':=';
 * }
 * 
 *  
 * {@code 
 *      Miscellaneous operators
 *          LBRA	: '{' ;
 *          RBRA	: '}' ;
 * }
 * </pre>
 * 
 * <h2>5. Design</h2>
 * 
 * <h3>5.1. Functional Tests</h3>
 * Tests using the <code>antlrworks-1.5.2</code> were made in order to see the abstract structure tree (see the images below). Other manual tests were implemented.
 *
 * <p>
 * <b>Block sequence tree</b>
 * <p>
 * <img src="doc-files/blockSequenceTree.png" alt="Diagram 3"> 
 * <p>
 * 
 * <b>For loop tree</b>
 * <p>
 * <img src="doc-files/forLoopTree.png" alt="Diagram 3"> 
 * <p>
 * 
 * <b>Assignment tree</b>
 * <p>
 * <img src="doc-files/assignmentTree.png" alt="Diagram 3"> 
 * 
 * <h3>5.2. UC Realization</h3>
 * -  
 * 
 * <h3>5.3. Classes</h3>
 * - 
 * 
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * Not necessary to implement in this feature.
 * 
 *  
 * <h2>6. Implementation</h2>
 * 
 * Code elements should be found in:
 * <p>
 * {@link csheets.core.formula.lang.Assignment}
 * <p>
 * {@link csheets.core.formula.lang.Block}
 * <p>
 * {@link csheets.core.formula.lang.For}
 * <p>
 * <code>Formula.g</code>
 * <p>
 * <code>language.props</code>
 * 
 * <h2>7. Integration/Demonstration</h2>
 * - 
 * 
 * <h2>8. Final Remarks</h2>
 * -
 * 
 * <h2>9. Work Log</h2> 
 * - 
 * 
 * <h2>10. Self Assessment</h2> 
 * -
 * 
 * <h3>10.1. Design and Implementation:</h3>
 *
 * 
 * <h3>10.2. Teamwork: </h3>
 * 
 * <h3>10.3. Technical Documentation: ...</h3>
 * 
 * @author Sara Ramos
 */

package csheets.worklog.n1140411.sprint1;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author alexandrebraganca
 */
class _Dummy_ {}

