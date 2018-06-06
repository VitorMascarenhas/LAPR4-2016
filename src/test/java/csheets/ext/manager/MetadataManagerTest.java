package csheets.ext.manager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author André Oliveira
 */
public class MetadataManagerTest {

    private String metadata_file_location;
    private String metadata_file;
    private Set<String> metadataFiles;
    private List<String> descriptions;
    private List<String> versions;
    private List<String> extensions;

    public MetadataManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        this.metadata_file_location = "res/metadata/";
        this.metadata_file = "src/test/java/csheets/ext/manager/metadataTest.props";
        this.metadataFiles = new HashSet<>();
        this.descriptions = new ArrayList<>();
        this.versions = new ArrayList<>();

        this.extensions = new ArrayList<>();
        
        //add metadata files example

        this.metadataFiles.add("DependencyTreeExtension.xml");
        this.metadataFiles.add("StartSharingExtension.xml");
        this.metadataFiles.add("SendChatMessageExtension.xml");
        this.metadataFiles.add("AgendaExtension.xml");
        this.metadataFiles.add("ExtensionManager.xml");
        this.metadataFiles.add("ExtensionExample.xml");
        this.metadataFiles.add("StyleExtension.xml");
        this.metadataFiles.add("ContactsExtension.xml");
        this.metadataFiles.add("CommentsExtension.xml");
        this.metadataFiles.add("ImportExportExtension.xml");
        this.metadataFiles.add("FindWorkbooksExtension.xml");
        this.metadataFiles.add("ConditionalFormatExtension.xml");
        
        //add extensions files example
        this.extensions.add("StyleExtension");
        this.extensions.add("DependencyTreeExtension");
        this.extensions.add("ExtensionExample");
        this.extensions.add("CommentsExtension");
        this.extensions.add("ExtensionManager");

    }

    @After
    public void tearDown() {
    }
    
    /**
     * Test of readXml method, of class MetadataManager.
     */
    @Test
    public void testReadXml() {
        System.out.println("readXml");
        String fileName = "ext/manager/ExtensionExampleTest.xml";

        MetadataManager instance = new MetadataManager();
        boolean expResult = true;
        boolean result = instance.readXml(fileName, this.descriptions, this.versions);
        assertEquals(expResult, result);

    }
    //TODO - Erro na sincronização do jenkins.
    //Quando ficou sem espaço em disco criou um ficheiro metadata.props que não se consegue sincronizar
    //com o do perfil do utilizador que executa a aplicação
//    /**
//     * Test of getMetadataFiles method, of class MetadataManager.
//     */
//    @Test
//    public void testGetMetadataFiles() {
//        System.out.println("getMetadataFiles");
//        MetadataManager instance = new MetadataManager();
//        Set<String> result = instance.getMetadataFiles();
//        assertEquals(this.metadataFiles, result);
//
//    }

    /**
     * Test of getMETADATA_FILES_LOCATION method, of class MetadataManager.
     */
    @Test
    public void testGetMETADATA_FILES_LOCATION() {
        System.out.println("getMETADATA_FILES_LOCATION");

        String result = MetadataManager.getMETADATA_FILES_LOCATION();

        assertEquals(this.metadata_file_location, result);

    }

    /**
     * Test of getMETADATA_FILES_LOCATION method, of class MetadataManager.
     */
    @Test
    public void testGetMETADATA_FILES_LOCATION_NOT_EQUALS() {

        String result = MetadataManager.getMETADATA_FILES_LOCATION();

        assertNotEquals(" ", result);

    }

    /*
     * Test of loadExtension method, of class MetadataManager.
     */
    @Test
    public void testLoadExtension_Not_Found() {
        System.out.println("loadExtension File Not Found");
        MetadataManager instance = new MetadataManager();
        
        String fileName = " ";
        
        MetadataManager.setPROPERTIES_FILENAME(fileName);
        
        boolean expResult = false;
        boolean result = instance.loadExtension(this.extensions);
        assertEquals(expResult, result);

    }

}
