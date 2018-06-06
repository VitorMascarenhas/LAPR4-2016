package csheets.ext.contacts.domain.tags;

import csheets.CleanSheets;
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
 * Class that implements the strategy for reading tags from xml file.
 *
 * @author José Vilela
 */
public class TagsManagerXml implements ITagsOperationRead
{
    private static final String XML_FILE_NAME="ext/ContactsWithTags/tags.xml";
    private static final String TAGS_ROOT_TAG_NAME= "Tag";
    private static final String TAGS_TAG_NAME= "TagName";

    /**
     * Read a xml file and extract all tags tagName.
     * - OBSELET (for testing purposes)
     * @return Set with unique tags
     */
    @Override
    public Set<ITag> read()
    {
        Set<ITag> tags = new HashSet<>();
        
        InputStream xmlFile = CleanSheets.class.getResourceAsStream(XML_FILE_NAME);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        org.w3c.dom.Document doc;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();

            return tags;
        }

        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName(TAGS_ROOT_TAG_NAME);

        Node node;
        Element element;
        TagFactory factory = new TagFactory();
        ITag tag;

        for (int i = 0; i < nList.getLength(); i++)
        {
            node = nList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                element = (Element) node;
                tag = factory.newTag(element.getElementsByTagName(TAGS_TAG_NAME).item(0).getTextContent());

                tags.add(tag);
            }
        }
        return tags;
    }
}
