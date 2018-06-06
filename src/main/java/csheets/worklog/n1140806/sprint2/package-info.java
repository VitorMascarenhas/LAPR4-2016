/**
 * Technical documentation regarding the work of the team member (1140806) Pedro Costa during week2.
 *
 * <p>
 * <b>Scrum Master: no</b>
 * </p>
 * <p>
 * <b>Area Leader: yes</b>
 * </p>
 * <p>
 * <h2>1. Notes</h2>
 * <p>This week, besides the stuff produced in this user feature, I'm also have worked in the implementation
 * of CRM01.1 Contact Edition (not finished in first week).
 * This implementation consumes a lot of effort of sprint and refer to the following requirements:
 * </p>
 *   <ul>
 *      <li>Update Contact</li>
 *      <li>Delete Contact</li>
 *      <li>Add Event</li>
 *      <li>Edit Event</li>
 *      <li>Delete Event</li>
 *      <li>General improvements on code
 *      (like new interfaces: "IContact", "IEvent", "ISchedulable" or Factories: ContactFactory, EventFactory )</li>
 *      <li>New tests (about 20 unit tests but with many asserts each one)</li>
 *      <li>Improvements on UI (very poor in the first week)</li>
 *      <li>Improvements on JPA Persistence (Important to note that some code for this system persistence were reused from EAPLI Class. The
 *      persistence system is also prepared to use in other entities or user features.</li>
 *  </ul>
 *
 * <h2>2. Use Case/Feature: CRM01.2- Company Contact</h2>
 *
 * <p>
 * Issue in Jira: <a>http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-76</a>
 * </p>
 *
 * <h2>3. Requirements</h2>
 *
 * <b>New type of contact: Company Contact:</b>
 *  <ul>
 *      <li>Company Contact only have a name unlike contact (first and last);</li>
 *      <li>Company Contact have events of each person contact related;</li>
 *  </ul>
 *  </ul>
 *  <b>New requirements on Person Contact:</b>
 *  <ul>
 *      <li>A person contact may be related with a company;</li>
 *      <li>A person contact may have a profession;</li>
 *      <li>The profession should be selected from a list of professions loaded from a xml file or a configuration file;</li>
 *      <li>The window for company contacts should display all person contacts related;</li>
 *      <li>The company contacts also have an agenda (readonly) and display all events of personal contacts related;</li>
 *   </ul>
 *
 *
 * </br>
 * <b>Uses Cases</b></br>
 *
 * </br><b>A) Create contact</b></br>
 * <img src="doc-files/new_contact.png" alt="image">
 * <img src="doc-files/new_company_contact.png" alt="image">
 * </br>The user selects contacts extension.
 * The system display all contacts information and, for the company contacts, also display the person contacts related.
 * The user click in the button for creating a Personal Contact or Company Contact.
 * The user insert all information required for the contact type selected. For personal contact this includes First Name,
 * Last Name, Picture, and Profession. For Company Contact a name and contacts related.
 * </br>
 * </br><b>B) Update contact</b></br>
 * <img src="doc-files/sd_edit_contact.png" alt="image">
 * </br>The user selects contacts extension.
 * The system display all contacts information and, for the company contacts, also display the person contacts related.
 * The user click in contact.
 * The user click on edit contact.
 * The system show current contact information in form.
 * The user update fields desired and click on update.
 * The system update the contact in DB and inform user.
 * </br>
 * </br><b>C) Remove contact</b></br>
 * <img src="doc-files/delete_contact.png" alt="image">
 * </br>The user selects contacts extension.
 * The system display all contacts information and, for the company contacts, also display the person contacts related.
 * The user click in contact.
 * The user click on remove contact.
 * The system remove the contact in DB and inform user.
 * </br>
 * </br><b>D) Show contact events</b></br>
 * <img src="doc-files/list_events.png" alt="image">
 * </br>The user selects contact in agenda window.
 * The system display all contacts.
 * The user click in contact.
 * The system show all the events of contact.
 *
 * </br><b>E) Create event</b></br>
 * </br><img src="doc-files/new_event.png" alt="image">
 * </br>The user selects contact in agenda window.
 * The system display all contacts.
 * The user insert description of event.
 * The user insert due date of event.
 * The user confirm event.
 * The system saves the new event and inform user.
 *
 * </br>
 * </br><b>F) Remove event</b></br>
 * <img src="doc-files/delete_event.png" alt="image">
 * </br>The user selects contact in agenda window.
 * The system display all contacts.
 * The user click in contact.
 * The system show all the events of contact.
 * The user select a event and click remove.
 * The system remove event.
 * </br>
 * </br><b>G) Update event</b></br>
 * <img src="doc-files/sd_edit_event.png" alt="image">
 * </br>The user selects contact in agenda window.
 * The system display all contacts.
 * The user click in contact.
 * The system show all the events of contact.
 * The user select a event and click edit.
 * The system shows current information of event.
 * The user edit the information and confirm.
 * The system remove event.
 *
 *
 *
 * <h2>4. Analysis</h2>
 *
 * <h3>Analysis</h3>
 *
 * According to the interpretation of the problem will be necessary the implementation of a new Contact Class. Since we already
 * have an interface called "ICONTACT" this new class should implement it. The Company class to create also have an agenda
 * so needs to implement interface ISchedulable (means all classes with Agenda). With this, a huge part of code produced for
 * Personal Contact Agenda can be reused.
 * In the case of the Personal Contact Class we need to add new optional properties (profession and company) and give support
 * to load list of professions from a XML file. For this requirement we can use Strategy Pattern. For creation of contacts and
 * events we use also the Factory Pattern centering the creation of contacts and events in two factories.
 *
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. UC Realization</h3>

 * <div>
 * <h3>Create contact</h3>
 * <p>By mistake two class names are wrong in this SSD. Where we read "ProfessionsManager"
 * we should read "ProfessionsManagerXml" and were we read "IProfessions"Strategy" we should read "IProfessionsOperationRead".</p>
 * <img src="doc-files/add_contact.png" alt="image">
 * </div>
 *
 * <div>
 * <h3>Remove contact</h3>
 * <img src="doc-files/remove_contact.png" alt="image">
 * </div>
 *
 * <div>
 * <h3>Edit contact</h3>
 * <img src="doc-files/edit_contact.png" alt="image">
 * </div>
 *
 * <div>
 * <h3>Create event</h3>
 * <img src="doc-files/add_event.png" alt="image">
 * </div>
 *
 * <div>
 * <h3>Edit event</h3>
 * <img src="doc-files/edit_event.png" alt="image">
 * </div>
 *
 * <div>
 * <h3>Remove event</h3>
 * <img src="doc-files/remove_event.png" alt="image">
 * </div>
 *
 * <h2>6. Implementation</h2>
 *
 * Code elements should be found in:
 * <p>
 * {@link csheets.ext.contacts}
 * <p>
 * <p>
 * {@link csheets.ext.agenda}
 * <p>
 * {@link csheets.persistence}
 * <p>
 *
 * <h2>7. Integration/Demonstration</h2>
 *
 *
 * Test Package:
 *
 * <p>
 * {@link csheets.ext.contacts}
 * {@link csheets.ext.agenda}
 *
 * <h2>8. Work Log</h2>
 *
 *  IMPORTANT NOTE: Daily scrum has been made at last class of each day.
 *
 * <p>
 * <b>Friday - 3 of June</b></br>
 * CRM01.1 Contact Edition implementation (jpa persistence improvements and tests)
 * <p>
 * <b>Saturday - 4 of June</b></br>
 * CRM01.1 Contact Edition implementation (domain model improvements)</br>
 * <b>Blocked in JPA Configuration solved after two hours of code review with Bernardo Meira (1140809) </b>
 * <p>
 * <b>Sunday -  5 of June</b></br>
 * CRM01.1 Contact Edition implementation (domain model improvements and ui improvements)
 * </br><b> Worked with André Oliveira developing xml read method since he had a similiar use case before. (1140438) </b>
 * <p>
 * <b>Monday -  6 of June</b></br>
 * CRM01.1 Contact Edition implementation (controller for use case improvements and ui improvements)
 * Daily Scrum
 * <p>
 * <b>Tuesday -  7 of June</b></br>
 * CRM01.2- Company Contact Analysis
 * Daily Scrum
 * <p>
 * <b>Wednesday -  8 of June</b></br>
 * CRM01.2- Company Contact Analysis, implementation and tests
 * Daily Scrum
 * <p>
 * <p>
 * <b>Thursday -  9 of June</b></br>
 * Demo
 * Sprint Review and Planning
 * <p>
 * 
 *<h2>9. Results</h2>
 *
 *
 * <div>
 * <h3>Screen shoots</h3>
 * <img src="doc-files/ss1.png" alt="image">
 * <img src="doc-files/ss2.png" alt="image">
 * <img src="doc-files/ss3.png" alt="image">
 * </div>
 *
 * <h2>Identified Bugs</h2>
 *
 * <p>Edit event not working properly, bug opened: http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-157</p>
 * <p>Contacts list in agenda window not updating when we add in contact window until restart app:
 * http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-158</p>
 *
 *
 *
 * @author Pedro Costa
 */

package csheets.worklog.n1140806.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
class _Dummy_ {}
