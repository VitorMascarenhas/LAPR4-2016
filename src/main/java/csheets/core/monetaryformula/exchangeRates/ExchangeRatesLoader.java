package csheets.core.monetaryformula.exchangerates;

import csheets.CleanSheets;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pedro Costa
 */
public class ExchangeRatesLoader implements ExchangeRatesRead {

    public static final String DEFAULT_XML_FILE_NAME ="ext/exchangeRates/exchangeRates.xml";

    private static final String EXCHANGE_RATE_ROOT_TAG_NAME= "ExchangeRate";
    private static final String EXCHANGE_RATE_TAG_NAME= "Value";
    private static final String EXCHANGE_FROM_TAG_NAME="From";
    private static final String EXCHANGE_FROM_TO_TAG_NAME="To";

    /**
     * Read a xml file and extract all tags professionName.
     *
     * @return Set with unique professions
     */
    @Override
    public List<IExchangeRate> readExchangeRates(String file)
    {
        //String of current currency, assuming that we will convert to euros
        List<IExchangeRate> exchangeRates = new ArrayList<>();

        InputStream xmlFile = CleanSheets.class.getResourceAsStream(file);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        org.w3c.dom.Document doc;

        try {

            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);

        } catch (ParserConfigurationException | SAXException | IOException e) {

            e.printStackTrace();

            return exchangeRates;
        }

        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName(EXCHANGE_RATE_ROOT_TAG_NAME);

        Node node;
        Node fromNode;
        Node amountNode;
        Node toNode;
        Element element;
        String from;
        String to;
        String amount;

        for (int i = 0; i < nList.getLength(); i++)
        {
            node = nList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                element = (Element) node;
                toNode = element.getElementsByTagName(EXCHANGE_FROM_TO_TAG_NAME).item(0);
                fromNode = element.getElementsByTagName(EXCHANGE_FROM_TAG_NAME).item(0);
                amountNode = element.getElementsByTagName(EXCHANGE_RATE_TAG_NAME).item(0);

                from = fromNode.getTextContent();
                to = toNode.getTextContent();
                amount = amountNode.getTextContent();

                ExchangeRatesFactory factory = new ExchangeRatesFactory();
                exchangeRates.add(factory.generateExchangeRate(from,to,amount));
            }
        }
        return exchangeRates;
    }

}
