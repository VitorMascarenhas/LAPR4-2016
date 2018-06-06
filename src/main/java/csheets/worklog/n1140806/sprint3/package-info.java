/**
 * Technical documentation regarding the work of the team member (1140806) Pedro Costa during week3.
 *
 * <p>
 * <b>Scrum Master: no</b>
 * </p>
 * <p>
 * <b>Area Leader: yes</b>
 * Resume about LANG area
 * <p>All implementations accomplish requirements and feedback of demonstration was very good. Despite that,
 * in sprint review client suggest new improvements on feature LANG-08.2 done by Sara Ramos(1140411).
 * The suggestions were accepted and implemented for new demonstration on Tuesday  </p>
 * </p>
 * <p>
 *
 * <h2>2. Use Case/Feature: LANG01.2 Monetary Language</h2>
 *
 * <p>
 * Issue in JIRA: <a>http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-28</a>
 * </p>
 *
 * <h2>3. Requirements</h2>
 *
 * <b>Add new formulas language to do only calculations related to currencies</b>
 *  <ul>
 *      <li>The character that begins the formula should be "#";</li>
 *      <li>The formula should only accept the addition, subtraction, multiplication and division operators;</li>
 *      <li>Expressions should be contained within brackets with the currency prefix in which we want the result. Ex: "#euro{10.32$ + 12.89£}"</li>
 *      <li>Three types of currencies: Euros, Pounds and Dollars</li>
 *  </ul>
 *  <b>Provide a way for setting exchange rates</b>
 *  <ul>
 *      <li>Implementation a configuration;</li>
 *      <li>Should avoid the use of numbers in floating point representation (e.g., float, double) in order to avoid precision problems;</li>
 *   </ul>
 *
 * </br></br>
 * <b>Uses Cases</b></br>
 *
 * </br><b>A) User makes a monetary formula</b></br>
 *
 * </br>
 * 1. The user write formula in cleanSheet with start character '#'.</br>
 * 2. The system retrieve the result of formula.</br>
 * </br><img src="doc-files/usecase.png" alt="new monetary formula use case"></br>
 * </br>
 * </br><b>B) User updates exchange rates</b></br>
 * </br>
 * 1. The user updates exchange rates in xml file.</br>
 * 2. The system uses the new values in the next execution of monetary formula.</br>
 * </br>
 *
 * <h2>4. Analysis</h2>
 *
 * <p>To prevent float pointing problem exchanging rates we used Big Decimal Class to save values.</p>
 * <p>Created new grammar from the existing one that uses a new start character and only supports the operations required: sum, subtraction, multiplication and division.</p>
 * <p>Some formula examples supported:</p>
 * <ul>
 *    <li>#euros{2&#8364*3$}</li>
 *    <li>#dollar{(2&#8364-4&#8364)*5&pound}</li>
 *    <li>#pound{2&#8364-3&#8364-4&#8364}</li>
 *    <li>#euros{1&#163}</li>
 * </ul>
 * <h3>Parser Tree examples</H3>
 * <p>Example 1</p>
 * </br><img style="border: 2px;" src="doc-files/tree.jpg" alt="tree monetary formula">
 * <p>Example 2</p>
 * </br><img src="doc-files/tree2.jpg" alt="tree monetary formula">
 * <p>Example 3</p>
 * </br><img src="doc-files/ast.jpg" alt="ast monetary formula">
 * <p>Example 4</p>
 * </br><img src="doc-files/ast2.jpg" alt="ast monetary formula"></br></br>
 *
 * <h3>Xml Exchange Rates file</h3>
 * </br><img src="doc-files/xml.png" alt="ast monetary formula"></br>
 *
 * <h2>5. Design</h2>
 * <p>The existing architecture makes necessary implement only a new few classes: MonetaryExpression, LiteralCurrency and classes used to load
 * exchange rates from XML File;</p>
 * <p>Implemented strategy pattern to read xml files and factory pattern to create exchange rates objects.</p>
 * <h3>Formula compiler design</h3>
 * </br><img src="doc-files/compiler.png" alt="ast monetary formula"></br></br></br>
 * <h3>Implementation of exchange rates in new class Literal Currency</h3></br>
 * </br><img src="doc-files/literalcurrency.png" alt="ast monetary formula"></br>
 * <h2>7. Integration/Demonstration</h2>
 *
 *
 * Test Packages:
 *
 * <p>
 * {@link csheets.core.monetaryformula} </br>
 * {@link csheets.core.monetaryformula.exchangerates} </br>
 * </p>
 * <h2>8. Work Log</h2>
 *
 *  IMPORTANT NOTE: Daily scrum has been made at last class of each day.
 *
 * <p>
 * <b>Friday - 10 of June</b></br>
 * Requirements Analysis;</br>
 * knowledge transfer from previous LANG developer: Bernardo Meira (1140809);
 * <p>
 * <b>Saturday - 11 of June</b></br>
 * Current code check and analysis;</br>
 * <p>
 * <b>Sunday -  12 of June</b></br>
 * Design;</br>
 * <p>
 * <b>Monday -  13 of June</b></br>
 * Grammar implementation;</br>
 * Daily Scrum;</br>
 * <p>
 * <b>Tuesday -  14 of June</b></br>
 * Tests and implementation;</br>
 * Daily Scrum;</br>
 * <p>
 * <b>Wednesday - 15 of June</b></br>
 * Finished of implementation;</br>
 * Daily Scrum;</br>
 * <p>
 * <b>Thursday -  16 of June</b></br>
 * Demo;</br>
 * Sprint Review and Planning;</br>
 * <p>
 *
 *
 *
 * <p>
 * <b>Evidences of Work:</b>
 * <p>
 * - url of commits:
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/7a9206f592e743ad151719ac9ac614dc42dfa4fb">Commit Analysis</a>
 *
 *
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/5993acbe54b8257945b4d26d38e9aec55da0fd8a">Design Implementation 1 </a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/f85d4da23c1b0964bb78753befafb4634a69d26b">Design Implementation 2 </a>
 * <p>
 *
 *
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/83f03b307646071c9c7c392162d2547dd0caf6e2">Commit Implementation 3 </a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/ec878fbaeffd273dbd5de3cf5ab20925eae4a7bd">Commit Implementation 4 </a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/34244ccdd062e731cb27a658880b3795f3fddb00">Commit Implementation 5 </a>
 * <p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/e4144ee001064e8b3478d99807842e0653d09ce4">Commit Implementation 6 </a>
 * <p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/2e27539ff9d9af4d3f2b82b18c72a0af041b33bd">Commit Implementation 7 </a>
 * <p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/1f347789f88a805570e3e42552f67b1c928e5a10">Commit Implementation 8 </a>
 * <p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/8f860ddb9c4f6c39c4610d369daeacf64c548264">Commit Implementation 9 </a>
 * <p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/2b36880259e9844f6c36e17129e4a94a9165c1c3">Commit Implementation 10 </a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/b407a6402435865f4f528d90f5e36f55230717da">Commit Tests 1 </a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/a5756ab9dbb979137e56fbee10ee3a4d43139835">Commit Tests 2 </a>
 *
 *
 * <div>
 * <h3>9. Results screen shoots</h3>
 * </br><img src="doc-files/ss1.png" alt="Screen shoot 1"></br>
 * </br><img src="doc-files/ss2.png" alt="Screen shoot 2"></br>
 * </br><img src="doc-files/ss3.png" alt="Screen shoot 3"></br>
 * </br><img src="doc-files/ss4.png" alt="Screen shoot 4"></br>
 * </div>
 *
 * <h2>Identified Bugs</h2>
 *
 * @author Pedro Costa
 */

package csheets.worklog.n1140806.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
class _Dummy_ {}
