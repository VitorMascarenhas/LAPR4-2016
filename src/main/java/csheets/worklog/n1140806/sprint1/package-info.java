/**
 * Technical documentation regarding the work of the team member (1140806) Pedro Costa during week1.
 *
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- yes</b>
 *
 * <h2>1. Notes</h2>
 *
 * -Notes about the week's work.-
 * <p>
 *
 * <h2>2. Use Case/Feature: CRM01.1- Contact Edition</h2>
 *
 * Issue in Jira: http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-75
 * <p>
 * -Include the identification and description of the feature-
 *
 * <h2>3. Requirement</h2>
 * A sidebar window that provides functionalities for creating, editing and removing contacts. Each contact
 * should have a first and last name and also a photograph. Each contact should also have one agenda in
 * which events related to the contact should be displayed. For the moment, events have only a due date
 * (i.e., timestamp) and a textual description. It should be possible to create, edit and remove events. The
 * agenda may be displayed in a different sidebar. This sidebar should display a list of all events: past, present
 * and future. One of the contacts should be the user of the session in the computer where Cleansheets is
 * running. If this user has events then, when their due date arrives, Cleansheets should display a popup
 * window notifying the user about the events. This popup window should automatically disappear after a
 * small time interval (e.g., 5 seconds).
 *
 * <p>
 * <b>Use Case "Contact Edition":</b> The user selects the contact edition feature.
 * The system displays the current contacts, if exists.
 * The user select a contact or create/edit/remove a contact.
 * The system displays current agenda of select contact.
 * The user selects an event or create/edit/remove an event.
 * The system saves the contact(s) and event(s).
 *
 * <h2>4. Analysis</h2>
 *
 * <h3>First "analysis" sequence diagram</h3>
 *
 * According the interpretation of the problem will be necessary to develop a new extension.
 * In terms of the existing code, the class responsible for loading the extensions is the Extension Manager.
 * It was also interpreted that will be necessary to create the following classes: Contact, Calendar and Event.
 * The sidebar contacts will have the functionality to add, edit and remove through buttons as well as the sidebar calendar that will allow through the same functionality buttons.
 * Sidebar Example:
 *
 * <p>
 * <img src="doc-files/sidebar_example.png" alt="image">
 *
 * <p>
 * The following diagram depicts a proposal for the realization of the previously described use case.
 *
 * <p>
 * <img src="doc-files/ssd_crm_contact_editions.png" alt="image">
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. UC Realization</h3>
 * To realize this user story we will need 3 aditional classes (Contact, Agenda and Event). We will also need to create a subclass of UIExtension. For the sidebar we need to implement a JPanel. In the code of the extension <code>csheets.ext.style</code> we can find examples that illustrate how to implement these technical requirements.
 * The following diagrams illustrate core aspects of the design of the solution for this use case.
 * <p>
 *
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "contact" extension.
 * <p>
 * <img src="doc-files/sequence_diagram_extension.png" alt="image">
 *
 *
 * <h3>User Creates a Contact</h3>
 * The following diagram illustrates what happens when the user creates a contact.
 * <p>
 * <img src="doc-files/sequence_diagram_create_contact.png" alt="image">
 *
 * <h3>User Edit a Contact</h3>
 * The following diagram illustrates what happens when the user edits a contact.
 * <p>
 * <img src="doc-files/sequence_diagram_edit_contact.png" alt="image">
 *
 * <h3>Remove a Contact</h3>w
 * The following diagram illustrates what happens when the user removes a contact.
 * <p>
 * <img src="doc-files/sequence_diagram_remove_contact.png" alt="image">
 *
 * <h3>Create an Event</h3>
 * The following diagram illustrates what happens when the user creates an Event
 * <p>
 * <img src="doc-files/sequence_diagram_create_event.png" alt="image">
 *
 * <h3>Edit an Event</h3>
 * The following diagram illustrates what happens when the user edits an Event
 * <p>
 * <img src="doc-files/sequence_diagram_edit_event.png" alt="image">
 *
 * <h3>Remove an Event</h3>
 * The following diagram illustrates what happens when the user removes an Event
 * <p>
 * <img src="doc-files/sequence_diagram_remove_event.png" alt="image">
 *
 * @author Pedro Costa
 */

package csheets.worklog.n1140806.sprint1;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
class _Dummy_ {}