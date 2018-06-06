/**
 * Technical documentation regarding the work of the team member 1950689 Nuno Mota during week3. 
 * 
 * <p>
 * <b>-Note: this is a template/example of the individual documentation that each team member must produce each week/sprint. Suggestions on how to build this documentation will appear between '-' like this one. You should remove these suggestions in your own technical documentation-</b>
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.-
 * <p>
 * -In this section you should register important notes regarding your work during the week.
 * For instance, if you spend significant time helping a colleague or if you work in more than a feature.-
 *
 * <h2>2. Use Case/Feature: LANG03.1 - Conditional formatting of cells</h2>
 * 
 * Issue in Jira: http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-33
 * <p>
 * Issue identification: LPFOURNA-33
 * 
 * 
 * <h2>3. Requirement</h2>
 * 
 * <p>
 * <b>Use Case/Feature: LANG03.1 - Conditional formatting of cells</b>
 *  
 * <h2>4. Analysis</h2>
 * 
 * 
 * 
 * <h3>System Sequence Diagram</h3>
 * <p>
 * <img src="doc-files/lang03_01_conditional_formating_SSD.png" alt="image"> 
 * 
 * 
 * <h3>Analysis of Core Technical Problem</h3>
 * 
 * <h2>5. Design</h2>
 *
 * <h3>Sequence Diagram</h3>
 * <p>
 * <img src="doc-files/lang03_01_conditional_formating_SD.png" alt="image"> 
 * <p>
 * <h3>5.1. Functional Tests</h3>
 * <p>
 * <b>class CondFrmtEscuta</b> -> i did 4 basic tests out of 12. Some need a cell i can´t create outside the cleansheets app.
 * <p>
 * <b>class ConditionalFormatController</b> -> i did zero tests out of 4. i needed to create a cell to test and i didn't manage to do that outside the cleansheets app.
 * <p>
 * <b>class ConditionalFormat</b> -> i did 14 basic tests out of 18. Some need to create a cell or the active cell and i didn't manage to do that outside the cleansheets app.
 * <p>
 * 
 * <h3>5.2. UC Realization</h3>
 * 
 * <h3>5.3. Classes</h3>
 * 
 * <p>
 * <img src="doc-files/lang03_01_conditional_formating_CD.png" alt="image"> 
 * 
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * 
 * There was no need to use patterns, the problem was solved with a 'Listner'
 * <p>
 * 
 * <h2>6. Implementation</h2>
 * 
 * <b>classes created:</b>
 * <p>
 * CondFrmtEscuta
 * <p>
 * ConditionalFormat
 * <p>
 * ConditionalFormatController
 * <p>
 * ConditionalFormatExtension
 * <p>
 * ConditionalFormatPanel
 * <p>
 * UIExtensionConditionalFormat
 * <p>
 * 
 * <h2>7. Integration/Demonstration</h2>
 * I improved the use case from the sprint2 and concluded this week sprint3 use case.
 * <p>
 * <h2>8. Final Remarks</h2>
 * 
 * <p>
 * 
 * <h2>9. Work Log</h2> 
 * 
 * <p>
 * <b>Saturday</b>
 * <p>
 * 1. I am initializing sprint3 javadoc
 * <p>
 * 2. I am initializing sprint3 analysis and design
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Sunday</b>
 * <p>
 * 1. I did sprint3 analysis and design
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Monday</b>
 * <p>
 * 1. I am doing sprint2 javadoc
 * <p>
 * 2. I doing a review on sprint3 analysis and design
 * <p>
 * 3. I have improved sprint2 use case
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * 1. I have improved sprint2 use case
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Wednesday</b>
 * <p>
 * 1. I implemented the use case.
 * <p>
 * 2. I did tests.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Thursday</b>
 * <p>
 * 1. I did implementation and tests
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <h2>10. Self Assessment</h2> 
 * 
 * -Insert here your self-assessment of the work during this sprint.-
 * 
 * <h3>10.1. Design and Implementation:3</h3>
 * 
 * 3- bom: os testes cobrem uma parte significativa das funcionalidades (ex: mais de 50%) e apresentam código que para além de não ir contra a arquitetura do cleansheets segue ainda as boas práticas da área técnica (ex: sincronização, padrões de eapli, etc.)
 * <p>
 * <b>Evidences:</b>
 * <p>
 * - url of commit: ... - description: this commit is related to the implementation of the design pattern ...-
 * 
 * <h3>10.2. Teamwork: ...</h3>
 * 
 * <h3>10.3. Technical Documentation: ...</h3>
 * 
 * 
 * @author 1950689 Nuno Mota
 */

package csheets.worklog.n1950689.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author 1950689 Nuno Mota
 */

class _Dummy_ {}
