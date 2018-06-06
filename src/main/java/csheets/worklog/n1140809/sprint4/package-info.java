/**
 * Technical documentation regarding the work of the team member (1140809) Bernardo Meira during week4.
 *
 * <b>Scrum Master: - Yes</b>
 * <p>
 * <b>Area Leader: - Yes</b>
 *
 * <h2>1. Notes</h2>
 *
 * -Notes about the week's work.-
 * <p>
 *     In this week some time was spent supporting:
 *     - Pedro Costa (1140806): Knowledge transfer on the file search mechanism and design
 *     - André Oliveira (1140438): Compiler independent implementation design. Work around for the known assign system bug (Looping calls due to Cell#setContent(String)).  <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-234">Support</a>
 *
 *     Some help was requested from other colleagues but due to time constraints I was not successful in assisting them completely.
 *     - Carlos Lopes (1120013): Generation of bar chart for <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-24">Chart Wizard</a>
 *     - Sérgio Oliveira (1121060): Mockito framework for test simulation.
 *
 * <h2>2. Use Case/Feature: Lang02.2</h2>
 *
 * Issue in Jira: <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-31">LPFOURNA-31</a>
 * <p>
 *     Lang02.2- Global Variables
 *
 *     -Add support for global variables. Global variables are variables that exist in the context of the workbook and are persisted with the workbook.
 *     The name of global variables must start with the '@' sign. When a variable is referred in a formula for the first time it is created.
 *     To set the value of a variable it must be used on the left of the assign operator (':='). Attention should be given to synchronization problems.
 *
 * <h2>3. Requirement</h2>
 *
 *     Create the global variable language concept. It should persist on save.
 * <p>
 *
 * <h2>4. Analysis</h2>
 *
 * <b>Use Case "Global Variables":</b>
 *
 * <p>The target of this use case is to give the user a new type of data concept which will retain it's value anywhere on a workbook. The list of created variables should be persisted with the workbook.
 * The main issue in this use case is the update of every cell which uses the global variable. To answer this, it was determined that the safest method would be to only update on user input within the desired cell.
 *
 * <p>Since I previously implemented the Lang01.1 increment I already had a good grasp of the parsing system. Further upon inspecting the Lang2.1 increment which focused on the {@link csheets.core.formula.variables.TempVariable} I ascertained the required steps for the implementation:
 * 1- Creating a object that represents a GlobalVariable; 2- Create a variable managing system; 3- Insert the new rules in the language file (Formula.g).
 *
 * <p>In general all the implementation surrounding this use case is already documented, except for the variable managing system. The strategy pattern should be used here as any and all variables can have their own managers to handle their global behaviour.
 * An interface would be required ({@link csheets.core.formula.variables.managers.VariableManager}) as well as an abstract implementation ({@link csheets.core.formula.variables.managers.AbstractVariableManager}). See 5-Design for a more visual design representation.
 *
 * <p>The variable control system should be easy to maintain through the Observer design pattern. {@link csheets.core.formula.variables.managers.GlobalVariableManager} will implement {@link java.util.Observer} and {@link csheets.core.formula.variables.GlobalVariable} will be an extension of {@link java.util.Observable}.
 * Using this pattern we can really on the manager to handle all the updates necessary surrounding the a global variable.
 *
 * <p>Lastly, it was identified that the {@link csheets.core.formula.variables.GlobalVariable}, {@link csheets.core.formula.lang.CellReference} and {@link csheets.core.formula.variables.TempVariable} had similar behaviours which should be extracted to and interface.
 * In this particular case, it was observed that the {@link csheets.core.formula.lang.Assignment} operator was being treated differently for each one through the use of the "instance of" operator. This is considered bad design, and to solve this issue an {@link csheets.core.formula.variables.Assignable} interface was created.
 * This interface was implemented in the aforementioned classes, and now each class can handle their implementation of the assign operator without damaging the code.
 *
 * <p>In terms of language updates the only thing required would be the inclusion of a new rule to represent global variables:
 * <p>
 * <pre>
 * {@code
 *
 * atom
 *  :	function_call
 *  |	reference
 *  |   TEMP_VAR
 *  |   GLOBAL_VAR
 *  |	literal
 *  |	LPAR! comparison RPAR!
;
 * GLOBAL_VAR : AT(LETTER | DIGIT)+;
 *
 * AT : '@';
 *}
 * </pre>
 * <p>And the insertion in the assignable operands.
 * <p>
 * <pre>
 * {@code
 *  assignment
 *      : (CELL_REF | TEMP_VAR | GLOBAL_VAR) ASSIGN^ comparison;
 *}
 * </pre>
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 *
 *  <p> The full TDD (Test Driven Development) work method was followed. Tests where previously designed and implemented in parallel with their corresponding classes. As such the first implementation had to be the {@link csheets.core.formula.variables.GlobalVariable} object as it was the least complex and dependent of the new classes.
 *  Since the {@link csheets.core.formula.variables.GlobalVariable} implements the {@link csheets.core.formula.Expression} interface, testing was done to the evaluate and accept methods. Also as a global variable has some uniqueness to it besides the intance reference the equals and hashcode methods were implemented and tested.
 *  see: <code>csheets.core.formula.variables.GlobalVariableTest</code>
 *
 * <p>When the {@link csheets.core.formula.variables.GlobalVariable} was done the tests around the {@link csheets.core.formula.variables.managers.GlobalVariableManager} could be completed. These were based on the @GlobalVariableManager#addVariable(String) method and since it implements the {@link java.util.Observer} interface, the @Observer#update(Observable, Object) method.
 * see: <code>csheets.core.formula.variables.managers.GlobalVariableManagerTest</code>
 *
 * <h3>5.2. UC Realization</h3>
 * The language rules to generate viable abstract syntax trees have to be generated. This results in updates to the language parsers, lexers and compilers.
 * To realize this user story it was necessary to implement a {@link csheets.core.formula.variables.GlobalVariable} class to encapsulate the global variable concept.
 * A variable managing system was put in place via the {@link csheets.core.formula.variables.managers.VariableManager} interface and {@link csheets.core.formula.variables.managers.AbstractVariableManager} class.
 * This sould be extended to create a {@link csheets.core.formula.variables.managers.GlobalVariableManager} class, that will serve as a factory and handler of global variables. It will also implement the {@link java.util.Observer} pattern.
 *
 * <p>
 *   <img src="doc-files/SimpleAssignAST.png" alt="image">
 * <p>
 * <p>
 *   <img src="doc-files/SimpleAssignParseTree.png" alt="image">
 * <p>
 * <p>
 *   <img src="doc-files/ComplexAssignAST.png" alt="image">
 * <p>
 * <p>
 *   <img src="doc-files/ComplexAssignParseTree.png" alt="image">
 * <p>
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 *
 * <p>
 *   <img src="doc-files/GlobalVarDesign.png" alt="image">
 * <p>
 *
 * Observer: {@link csheets.core.formula.variables.managers.GlobalVariableManager} and {@link csheets.core.formula.variables.GlobalVariable} - was user to handle the updates to a global variables value.
 * Strategy: {@link csheets.core.formula.variables.managers.VariableManager}, {@link csheets.core.formula.variables.managers.AbstractVariableManager}, {@link csheets.core.formula.variables.managers.GlobalVariableManager} - was used to suply the application with a centralized system to handle each variables behaviour.
 *
 * <h2>6. Implementation</h2>
 * <p>
 * see:<p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/d3884e448a5970e5d271ad468754581840b6e2ec">Class structure design</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/ef341cdccbd4ffe435d4a87c3d2b730adddb7514">Formula.g: Rules implementation</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/5a7dbe1a1e6ad9533a133ba2213ed37450a27409">Core design</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/f8149766f037020e11569c1f220d6df4feeaf5ee">Global variable test suit</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/082496628f4ac386767ad72ac6def74f9e9f3714">Global variable implementation</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/84ff005cf5381baa44cdb4d3cffb3fe3998b33a8">Assignable design implementation</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/562a090fc85336a3db99d348b64fcf1b687555d2">Global variable Manager test suit</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/e889a45c203daa085ec2a219ccf091c15557f793>Global variable manager implementation</a><p>
 *
 * <h2>7. Integration/Demonstration</h2>
 *
 * Demonstration went without any problems. All functional increments where tested on a deployed jar generated previously at 17:00. And a demonstration jar was built at 18 to be run outside a development environment.
 * All executions where made from de console using the java -jar command, so console support was active and displayed no major issues.
 *
 * <h2>8. Final Remarks</h2>
 *
 * An improvement could be done to automatically update all dependent cells on a change of a global variable. This at the moment was not possible because of a previously underlying problem with the assign feature, which could cause infinite looping.
 *
 * @author 1140809
 */

package csheets.worklog.n1140809.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 *
 * @author 1140809
 */
class _Dummy_ {}

