/**
 * Technical documentation regarding the work of the team member (1140438) André Oliveira during week2. 
 * 
 * <p>
 * <b>Scrum Master: -(yes/no)- yes</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- yes</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.-
 *
 * <h2>2. Use Case/Feature: CORE01.2 - Auto-description of Extension</h2>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-2">Issue in Jira</a>
 * <p>
 * -Include the identification and description of the feature-
 * 
 * <h2>3. Requirement</h2>
 * Extensions should have associated metadata. Particularly, extensions should have a version number, a
 * name and a description. Cleansheets should display to the user the metadata of the extensions before
 * loading them. The user should be able to cancel the loading of an extension and also to select the version
 * of the extension to be loaded (if there are more than one).
 * 
 * <p>
 * <b>Use Case "Auto-description of Extension":</b> The user initialize the cleansheets.
 * The system show all avaiable extensions.
 * The user select an extension.
 * The system displays all existing version of the selected extension.
 * The user selects the version of extensions that he wants to load.
 * The system display all the info about the extension.
 *  
 * <h2>4. Analysis</h2>
 * 
 * <h3>First "analysis" sequence diagram</h3>
 * 
 * According the interpretation of the probleam, metada is a XML file with all the necessary information about
 * the extensions. According with the manual the metadata file should contains the extension name, the version number
 * and a description.
 * In terms of the existing code, the class responsible for loading the extensions is the Extension Manager.
 * Will be necessary a new class to load the Metadata extension info. The name of this class will be MetadataManager.
 * When the Cleansheets is started and the user select the extension, the metadata file is read is read and the info is loaded.
 * For the correct funcion of this use case the extensions.props file the XML file (matadata file) must be updated.
 * Gui interface Example:
 * 
 * <p>
 * <img src="doc-files/extension_metadata_information.png" alt="image"> 
 * 
 * <p>
 * XML metadata file code example for an extension:
 * 
 * <p>
 * <pre>
 * {@code 
 * <?xml version="1.0" encoding="UTF-8"?>
 *
 * <Extension>
 *    <Name>StyleExtension</Name>
 *    <Versions>
 *        <VersionNumber>1.0</VersionNumber>
 *        <Description>StyleExtension for text/font style</Description>
 *    </Versions>
 *    <Versions>
 *        <VersionNumber>1.1</VersionNumber>
 *        <Description>StyleExtension for text/font style. Contains blue color in this version</Description>
 *    </Versions>
 * </Extension>
 * }
 * </pre>
 * 
 * <p>
 * The following diagram depicts a proposal for the realization of the previously described use case. 
 * 
 * <p>
 * <img src="doc-files/ssd.png" alt="image"> 
 * 
 * <h2>5. Design</h2>
 *
 * <h3>5.1. UC Realization</h3>
 * 
 * <h3>Extension Manager Menu</h3>
 * The following diagram shows the loading of Extension Manager Menu (The same was used in the Issue Core01.1)
 * <p>
 * <img src="doc-files/sequence_diagram_ui.png" alt="image">
 *
 * <h3>GUI User Interection</h3>
 * The following diagram shows the loading of Auto-Description JDialog
 * <p>
 * <img src="doc-files/sequence_diagram_gui_interaction.png" alt="image">
 * 
 * <h3>Read Metadata XML file and Load extension information</h3>
 * The following diagram illustrates what happens when the XML file of metadata info is read/loaded
 * <p>
 * <img src="doc-files/sequence_diagram_metadata_read.png" alt="image">
 * 
 * <h3>Prevent and Extension from Load</h3>
 * The following diagram illustrates what happens when the Extension prevented from load.
 * <p>
 * <img src="doc-files/sequence_diagram_metadata_remove.png" alt="image">
 * 
 * <h2>6. Implementation</h2>
 * 
 * Code elements should be found in:
 * <p>
 * {@link csheets.ext.manager.ui}
 * <p>
 * {@link csheets.ext.manager}
 * <p>
 * {@link csheets.ext}
 * 
 * <h2>7. Integration/Demonstration</h2>
 * 
 * Were been tests to the MetadataManager. This class contains the methods reponsable to
 * load/remove data from files.
 * 
 * Test Package:
 * 
 * <p>
 * {@link csheets.ext.manager}
 * 
 * <h2>8. Work Log</h2> 
 * 
 * <p>
 * <b>Saturday - 4 of June</b>
 * Analysis of the feature
 * <p>
 * Blocking: nothing
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Sunday -  5 of June</b>
 * <p>
 * Design of the feature.
 * As scrum master I assigned to all elemnts an issue.
 * <p>
 * Blocking: permissions on JIRA
 * <p>
 * <b>Monday -  6 of June</b>
 * <p>
 * Readjust Roadmap and send it to the client.
 * Tests/Implementation
 * <p>
 * Blocking: nothing
 * <p>
 * <b>Tuesday -  7 of June</b>
 * <p>
 * Tests/Implementation
 * <p>
 * Blocking: nothing
 * <p>
 * <b>Wesnesday -  8 of June</b>
 * <p>
 * Tests/Implementation
 * <p>
 * Blocking: nothing
 * 
 *<h2>8.1 Evidences of Work</h2> 
 * 
 * - url of commits: 
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/2cd911b11cba3e09cfe6ecdcd31a6ad84acb667b">Example of commit for Analysis</a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/35485b96a951f8798f18f71b38a08be35f85a700">Example of commit for Design</a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/3f3e21f39ddf7fdbfefd037606af25fea6bcabdf">Example of commit for Tests</a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/3771fbdd11e4e8d36853bb5bb4a6ac27d1df7784">Example of commit for Implementation</a>
 * 
 * @author André Oliveira
 */

package csheets.worklog.n1140438.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author alexandrebraganca
 */
class _Dummy_ {}

