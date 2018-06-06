package csheets.ext.manager;

import csheets.CleanSheets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author André Oliveira
 */
public class MetadataManager implements MetadataFilesBehavior {

    /**
     * The singleton instance
     */
    private static final MetadataManager instance = new MetadataManager();

    /**
     * The name of the files in which extension auto-description are stored
     */
    private static final String METADATA_FILENAME = "metadata.props";

    /**
     * The name of the files in which extension properties are stored
     */
    private static String PROPERTIES_FILENAME = "extensions.props";

    /**
     * Metadata Files location
     */
    private static final String METADATA_FILES_LOCATION = "res/metadata/";

    /**
     * Metadata Files location
     */
    private static final String METADATA_USER_LOCATION = System.getProperty("user.home") + "cleansheet/metadata/";

    /**
     * The metadada files names that have been loaded
     */
    private Set<String> metadataFiles;

    /**
     * Creates a metadata manager for the extension description
     */
    public MetadataManager() {

        metadataFiles = new HashSet<>();

        File userProprietes = new File(System.getProperty("user.home") + "/cleansheet/metadata/" + METADATA_FILENAME);
        try {
            if (!userProprietes.exists()) {
                InputStream defaultStream = CleanSheets.class.getResourceAsStream("res/" + METADATA_FILENAME);

                Files.createDirectories(Paths.get(System.getProperty("user.home"), "cleansheet/metadata/"));

                Files.copy(defaultStream, Paths.get(System.getProperty("user.home"), "cleansheet/metadata/", METADATA_FILENAME));
            }

            Properties metProps = new Properties();
            InputStream stream = null;
            try {
                stream = new FileInputStream(userProprietes);
            } catch (FileNotFoundException ex) {
                System.out.println("Cannot access to " + System.getProperty("user.home")
                        + "/cleansheet/metadata/" + METADATA_FILENAME);
            }

            if (stream != null) {
                try {
                    metProps.load(stream);
                } catch (IOException ex) {
                    System.err.println("Could not load default metadata properties from: "
                            + METADATA_FILENAME);
                } finally {
                    if (stream != null) {
                        stream.close();
                    }
                }

                for (Map.Entry<Object, Object> entry : metProps.entrySet()) {
                    String metFile = (String) entry.getKey();
                    this.metadataFiles.add(metFile);
                }
            }
        } catch (IOException ex) {
            System.out.println("Cannot read metadata.props file!");

        }
    }

    /**
     * Funcion to read Metadata file.
     *
     * XML parser. Read the content of a file with a name at parameter
     *
     * @param fileName File name
     * @param description Description of extension
     * @param versions
     * @return false if occurs a Exeption. True if the xml file was sucefully
     * read.
     */
    @Override
    public boolean readXml(String fileName, List<String> description, List<String> versions) {

        description.clear();
        versions.clear();

        InputStream xmlFile = CleanSheets.class.getResourceAsStream(fileName);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        org.w3c.dom.Document doc;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("The file " + fileName + " file is empty or the file not found!");

            return false;
        }

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("Extension");

        Node node = nList.item(0);

        Element element = (Element) node;

        nList = doc.getElementsByTagName("Versions");

        for (int i = 0; i < nList.getLength(); i++) {

            node = nList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                element = (Element) node;

                versions.add(element.getElementsByTagName("VersionNumber").item(0).getTextContent());
                description.add(element.getElementsByTagName("Description").item(0).getTextContent());

            }

        }

        return true;
    }

    /**
     * Remove line of extension that don't need to be loaded
     *
     * @param lineToRemove
     * @return
     */
    public boolean removeExtensionFromFile(String lineToRemove) {

        File userProprietes = new File(System.getProperty("user.home") + "/cleansheet/" + PROPERTIES_FILENAME);

        try {
            if (!userProprietes.exists()) {
                InputStream defaultStream = CleanSheets.class.getResourceAsStream("res/" + PROPERTIES_FILENAME);

                Files.createDirectories(Paths.get(System.getProperty("user.home"), "cleansheet/"));

                Files.copy(defaultStream, Paths.get(System.getProperty("user.home"), "cleansheet/", PROPERTIES_FILENAME));
            }
        } catch (IOException ex) {
            System.out.println("Cannot read extensions.props file!");
            return false;

        }

        Properties proProps = new Properties();
        InputStream stream = null;
        try {
            stream = new FileInputStream(userProprietes);
        } catch (FileNotFoundException ex) {
            System.out.println("Cannot access to " + System.getProperty("user.home")
                    + "/cleansheet/" + PROPERTIES_FILENAME);
        }

        boolean successful = false;

        if (stream != null) {

            File tempFile = new File(System.getProperty("user.home") + "/cleansheet/extensionsTemp.props");

            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(tempFile));
            } catch (IOException ex) {
                System.out.println("Error openning extensionsTemp.props file!");
                return false;
            }

            String currentLine;

            try {
                while ((currentLine = reader.readLine()) != null) {

                    String line = currentLine.trim();
                    if (line.contains(lineToRemove)) {
                        continue;
                    }
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            } catch (IOException ex) {
                System.out.println("Error reding or writing a file!");
                return false;
            }
            try {
                writer.close();
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(MetadataManager.class.getName()).log(Level.SEVERE, null, ex);
            }

            //rename to the original file name
            userProprietes.delete();

            successful = tempFile.renameTo(userProprietes);

            try {
                proProps.load(stream);
            } catch (IOException ex) {
                System.err.println("Could not load default metadata properties from: "
                        + METADATA_FILENAME);
            } finally {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException ex) {
                        System.out.println("Cannot close file!");
                    }
                }
            }

        }

        return successful;
    }

    /**
     * Check the extensions.props file to know to know which extensions have not
     * been removed yet and will be loaded at program startup.
     *
     * @param extensions List to save the extensions
     * @return True if was sucefully read the extesions.props file. False if
     * occur an error.
     */
    public boolean loadExtension(List<String> extensions) {

        Properties proProps = new Properties();
        InputStream defaultStream = null;

        File userProprietes = new File(System.getProperty("user.home") + "/cleansheet/" + PROPERTIES_FILENAME);

        if (!userProprietes.exists()) {

            defaultStream = CleanSheets.class.getResourceAsStream("res/" + PROPERTIES_FILENAME);

            if (defaultStream != null) {

                try {
                    proProps.load(defaultStream);
                } catch (IOException ex) {
                    System.err.println("Could not load default extensions.props properties from: "
                            + PROPERTIES_FILENAME);
                    return false;
                } finally {
                    try {
                        if (defaultStream != null) {
                            defaultStream.close();
                        }
                    } catch (IOException e) {
                        return false;
                    }
                }

                for (Map.Entry<Object, Object> entry : proProps.entrySet()) {

                    String metFile = (String) entry.getKey();
                    extensions.add(metFile);

                }

            } else {
                return false;
            }

        } else {

            defaultStream = CleanSheets.class.getResourceAsStream(System.getProperty("user.home") 
                    + "/cleansheet/" + PROPERTIES_FILENAME);

            try {
                defaultStream = new FileInputStream(userProprietes);
            } catch (FileNotFoundException ex) {
                System.out.println("Cannot access to " + System.getProperty("user.home")
                        + "/cleansheet/" + PROPERTIES_FILENAME);
            }

            if (defaultStream != null) {

                try {
                    proProps.load(defaultStream);
                } catch (IOException ex) {
                    System.err.println("Could not load default extensions.props properties from: "
                            + PROPERTIES_FILENAME);
                    return false;
                } finally {
                    try {
                        if (defaultStream != null) {
                            defaultStream.close();
                        }
                    } catch (IOException e) {
                        return false;
                    }
                }

                for (Map.Entry<Object, Object> entry : proProps.entrySet()) {

                    String metFile = (String) entry.getKey();
                    extensions.add(metFile);

                }

            } else {
                return false;
            }

        }

        return true;

    }

    /**
     * Return the metadataFiles Names
     *
     * @return Set with the metadataFiles Names
     */
    public Set<String> getMetadataFiles() {
        return metadataFiles;
    }

    /**
     * Partial path of metadata Files
     *
     * @return String with the partial Location
     */
    public static String getMETADATA_FILES_LOCATION() {
        return METADATA_FILES_LOCATION;
    }

    /**
     * Just to use in a unitary test
     *
     * @param PROPERTIES_FILENAME File path to change
     */
    protected static void setPROPERTIES_FILENAME(String PROPERTIES_FILENAME) {
        MetadataManager.PROPERTIES_FILENAME = PROPERTIES_FILENAME;
    }

}
