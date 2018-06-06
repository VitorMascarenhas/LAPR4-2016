/**
 * Technical documentation regarding the work of the team member (1010500) José Vilela during week3. 
 * 
 * <p>
 * <p>
 * <b>Scrum Master: - no</b>
 * 
 * <p>
 * <b>Area Leader: - no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * 
 *
 * <h2>2. Use Case/Feature: LANG02.1</h2>
 * 
 * Issue in Jira: 
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-30" >Lang02.1- Temporary Variables</a>
 * 
 * <h2>3. Requirement</h2>
 * <p>
 * Add support for temporary variables. The name of temporary variables must start with the "_" sign.
 * When a variable is referred in a formula for the first time it is created. To set the value of a variable it
 * must be used on the left of the assign operator (":="). Temporary variables are variables that only exist
 * in the context of the execution of a formula. Therefore, it is possible for several formulas to use temporary
 * variables with the same name and they will be different instances.
 * </p>
 * 
 * <b>Use Case "Enter a temporary variable in a formula":</b> 
 * <p>1.The user selects cell.</p>
 * <p>1.the user enters a formula which creates and uses a temporary variable.</p>
 * <p>2.The System show the result with a temporary variable evaluated on Cell.</p>
 * 
 * <p><b>SSD UC "Enter a temporary variable in a formula"</b></p>
 * 
 * <img src="doc-files/lang02_01_req.png" alt="SSD_Req"> 
 *
 * <h2>4. Analysis</h2>
 * 
 * 
 * <h3>Analysis of Core Technical Problem</h3>
 * 
 *<p> As the grammar of cleansheats will have to be changed to recognize the temporary variables, we need to study that grammar and how it is integrated in the system.
 *<p>We Need to study how Temp Variables can be used, similar as a cell Reference</p>
 *<p>We also need to keep a list of all variables in the scope
 * 
 *<p><img src="doc-files/lang02_01_analysis.png" alt="analysis"></p>
 * 
 *<p>The changes in language are expressed in the code: </p>
 *<pre>{@code assignment : 
 *                          (CELL_REF | TEMP_VAR) ASSIGN^ comparison
 *                          ;}
 * 
 * {@code atom
                :	function_call
                |	reference
                |       TEMP_VAR
                |	literal
                |	LPAR! comparison RPAR!
                ;}
 * 
 *{@code TEMP_VAR : 
*                          UNDERSCORE(LETTER | DIGIT)+
*                          ;}
 *{@code UNDERSCORE 
*                          : '_'
*                          ;}
*</pre>
 *
 * 
 * <h2>5. Design</h2>
 * 
 * <h3>5.1. Functional Tests</h3>
 * <p>Tests using the antlrworks-1.5.2 were made in order to see the abstract structure tree.</p>
 * <p>Other manual tests were implemented.</p> 
 * 
 * <p>Unit Texts:</p>
 * see: <code>csheets.core.formula.TempVariableTest</code>
 * 
 * <h3>5.2. Syntax diagram for recursive expression generation</h3>
 * 
 * <p><img src="doc-files/temp_var_syntax_diagram.jpg" alt="TempVar Syntax Diagram"></p>
 * 
 * <p><img src="doc-files/atom_syntax_diagram.jpg" alt="Atom Syntax Diagram"></p>
 * 
 * <h3>5.. Sequence Diagram</h3>
 * 
 * <p><img src="doc-files/lang02_01_design01.png" alt="Sequence Diagram"></p>
 * 
 * <h3>5.4. Classes</h3>
 * 
 * From the study made of the existing classes to implement the requirements, 
 * it is necessary to create a new classe {@link csheets.core.formula.variables.TempVariable}
 * and add a tempVariablesList atribute and two methods(setVarValue and getTempVariablesList) to {@link csheets.core.CellImpl}.
 * Is also necessary to refine the compile method of {@link csheets.core.formula.compiler.ExcelExpressionCompiler}.
 * 
 * <p><img src="doc-files/lang02_01_classDiagram.png" alt="Class Diagram"></p>
 * 
 * 
 * 
 * <h2>6. Implementation</h2>
 * commits of my work:<p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/99f21a5bbded9d6c2f7d6a1771f5c9add446b03b">analysis of LANG02_1 Temporary variables</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/afd9c28cdef671673b0c65f80ccba10167c57fee">design of LANG02_1 Temporary variables</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/530744294586947320ae2dfed0ad08f5a658062d">implementation of LANG02_1 Temporary variables</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/e22864a21a795f240449b11c51a6e60a0c672f97">minor fix MetadataManagerTest</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/73bdafee1fedd434220101c9142d337dc05ebb2b">Unit Tests of LANG02_1 Temporary variables</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/48258c46b63626e8fb35023706f8f3ee22b16041">worklog</a><p>
 * <p>
 * <h2>7. Integration/Demonstration</h2>
 * 
 * I tried to integrate the new code into existing software as smooth as possible.<p>
 * I used / reused the maximum of elements that could , including classes and interfaces.
 * 
 * <h2>8. Final Remarks</h2>
 * 
 * <p>
 * 
 * <h2>9. Work Log</h2> 
 * 
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday i plan the work for the rest of the week and start the analysis
 * 
 * <p>
 * Today
 * <p>
 * 1. Analysys of LANG02_01 - Temporary Variables</p>
 * <p>2. Start Design and implementation</p>
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * <p>1. Analysys of LANG02_01 - Temporary Variables</p>
 * <p>2. Start Design and implementation</p>
 * <p>
 * Today
 * <p>
 * <p>1. complete of Design</p>
 * <p>2. implementation of the solution</p>
 * <p>3. technical documentation</p>
 * 3.
 * <p>
 * Blocking:
 * <p>
 * 1. nothing
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * <p>1. complete of Design</p>
 * <p>2. implementation of the solution</p>
 * <p>
 * Today
 * <p>
 * 1. <p>implementation of unit tests</p>
 * 2. <p>fix minor bugs ni MetadataManagerTest that cause build instable</p>
 * 3. <p>conclusion technical documentation</p>
 * <p>
 * Blocking:
 * <p>
 * 1. nothing
 * <p>
 * <b>Thursday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. <p>implementation of unit tests</p>
 * 2. <p>fix minor bugs ni MetadataManagerTest that cause build instable</p>
 * 3. <p>conclusion technical documentation</p>
 * <p>
 * Today
 * <p>
 * 1. Nothing
 * <p>
 * Blocking:
 * <p>
 * 1. 
 * <p>
 * <b>Friday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Nothing
 * <p>
 * Today
 * <p>
 * 1. Nothing
 * <p>
 * Blocking:
 * <p>
 * 1. 
 * 
 * @author jose Vilela 1010500
 */

package csheets.worklog.n1010500.sprint3;
class _Dummy_ {}