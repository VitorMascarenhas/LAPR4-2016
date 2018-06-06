package csheets.ext.contacts.domain.Professions;

import csheets.CleanSheets;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.*;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Class that implements the strategy for reading professions from xml file.
 *
 * @author Pedro Costa
 */
public class ProfessionsManagerXml implements IProfessionsOperationRead
{
    private static final String XML_FILE_NAME="ext/professionsXml/professions.xml";
    private static final String PROFESSIONS_ROOT_TAG_NAME= "Profession";
    private static final String PROFESSIONS_TAG_NAME= "ProfessionName";

    /**
     * Read a xml file and extract all tags professionName.
     *
     * @return Set with unique professions
     */
    @Override
    public Set<IProfession> read()
    {
        Set<IProfession> professions = new HashSet<>();
        
        InputStream xmlFile = CleanSheets.class.getResourceAsStream(XML_FILE_NAME);

        //File xmlFile = new File(XML_FILE_NAME);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        org.w3c.dom.Document doc;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();

            return professions;
        }

        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName(PROFESSIONS_ROOT_TAG_NAME);

        Node node;
        Element element;
        ProfessionsFactory factory = new ProfessionsFactory();
        IProfession profession;

        for (int i = 0; i < nList.getLength(); i++)
        {
            node = nList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                element = (Element) node;
                profession = factory.newProfession(element.getElementsByTagName(PROFESSIONS_TAG_NAME).item(0).getTextContent());

                professions.add(profession);
            }
        }
        return professions;
    }
}
