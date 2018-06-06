/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files;

import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Sara Ramos
 */
public class ParseXMLFile
{
    private UIController uiController;
    private String fileName;
    private String spreadsheetName; //tag of spreadsheets
    private String cellName; //tag of cells
    private Document doc;
    private List<Integer> idsSpreadsheetList; //ids of spreadsheets at the file

    /**
     * Constructor
     *
     * @param uiController
     * @param fileName
     */
    public ParseXMLFile(UIController uiController, String fileName)
    {
        this.uiController = uiController;
        this.fileName = fileName;
    }
    /**
     * Replace the actual workbook with the data imported from the file
     * @return true if success and false otherwise
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws FormulaCompilationException 
     */
    public boolean importXMLReplaceWorkbook() throws ParserConfigurationException, SAXException, IOException, FormulaCompilationException
    {
        //creates a new workbook
        Workbook workbook = new Workbook();
        uiController.setActiveWorkbook(workbook);

        // Spreadsheet list
        NodeList spreadsheetList = this.doc.getElementsByTagName(this.spreadsheetName);

        //all spreadsheets in the file
        for (int i = 0; i < spreadsheetList.getLength(); i++) {
            Node node = spreadsheetList.item(i);

            if (node instanceof Element) {
                Element spreadsheet = (Element) node;
                //find the id of the spreadsheet
                int id = Integer.parseInt(spreadsheet.getAttribute("id"));
                importXMLReplaceSpreadsheet(id);
            }

        }
        return true;
    }

    /**
     * Replace the the spreadsheet at the index ssOption with the data imported from the file
     * @param ssOption
     * @return true if success and false otherwise
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    public boolean importXMLReplaceSpreadsheet(int ssOption) throws ParserConfigurationException, SAXException, IOException, FormulaCompilationException
    {
        Spreadsheet selectedSpreadsheet = spreadsheetById(ssOption);

        NodeList spreadsheetList = this.doc.getElementsByTagName(this.spreadsheetName);

        for (int i = 0; i < spreadsheetList.getLength(); i++) {

            Node node = spreadsheetList.item(i);
            if (node instanceof Element) {
                Element spreadsheet = (Element) node;
                //find the node which is the selected spreadsheet by the user
                if (spreadsheet.getAttribute("id").equals(Integer.toString(ssOption))) {
                    selectedSpreadsheet.setTitle(spreadsheet.getAttribute("title"));
                    //method to fill the cells
                    return fillCells(selectedSpreadsheet, spreadsheet);
                }
            }
        }
        return false;

    }
    
    /* Replace a range of cells in the spreadsheet in the index ssOption with
     * the data imported from the file
     * @param ssOption
     * @return true if success and false otherwise
     * @throws FormulaCompilationException 
     */
    public boolean importXMLReplaceRange(int ssOption) throws FormulaCompilationException
    {
        Spreadsheet selectedSpreadsheet = spreadsheetById(ssOption);

        NodeList spreadsheetList = this.doc.getElementsByTagName(this.spreadsheetName);

        for (int i = 0; i < spreadsheetList.getLength(); i++) {

            Node node = spreadsheetList.item(i);
            if (node instanceof Element) {
                Element spreadsheet = (Element) node;
                //find the node which is the selected spreadsheet by the user
                if (spreadsheet.getAttribute("id").equals(Integer.toString(ssOption))) {

                    //"read" all the cells from the selected spreadsheet and copy to the actual cell in the selected spreadsheet
                    NodeList cellsList = spreadsheet.getChildNodes();
                    for (int k = 0; k < cellsList.getLength(); k++) {

                        Node nodeCell = cellsList.item(k);
                        if (nodeCell instanceof Element) {

                            Element cell = (Element) nodeCell;
                            int row = Integer.parseInt(cell.getAttribute("row"));
                            int column = Integer.parseInt(cell.getAttribute("column"));
                            
                            selectedSpreadsheet.getCell(row, column).setContent(cell.getTextContent());
                        }
                    }
                    selectedSpreadsheet.setTitle(spreadsheet.getAttribute("title"));
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Selects a spreadsheet according to its id (index in the workbook)in the file, 
     * creating blanks spreadsheets between the last spreadsheet in workbook and the 
     * spreadsheet sent by ssOption
     * @param ssOption id of the spreadsheet to replace
     * @return a spreadsheet
     */
    private Spreadsheet spreadsheetById(int ssOption)
    {
        //Spreadsheet to where the spreadsheet from the file should be imported
        int controlSpreadsheetsInWorkbook = this.uiController.getActiveWorkbook().getSpreadsheetCount();

        //add new spreedsheets to save the import data
        if (controlSpreadsheetsInWorkbook < ssOption + 1) {
            for (int i = controlSpreadsheetsInWorkbook; i < ssOption + 1; i++) {
                this.uiController.getActiveWorkbook().addSpreadsheet();
            }
        }
        //selects the spreadsheet at the index (id) selected by the user     
        return this.uiController.getActiveWorkbook().getSpreadsheet(ssOption);
    }

    /**
     * Fills the cells according to the data present in the Element spreadsheet
     * @param selectedSpreadsheet actual spreadsheet in the workbook, in which the data
     * should be changed according to the file data
     * @param spreadsheet an Element from doc which represents the selected spreadsheet
     * from the file. 
     * @return true if success and false otherwise
     * @throws FormulaCompilationException 
     */
    private boolean fillCells(Spreadsheet selectedSpreadsheet, Element spreadsheet) throws FormulaCompilationException
    {
        //"read" all the cells from the selected spreadsheet and copy to the actual spreadsheet in the workbook
        NodeList cellsList = spreadsheet.getChildNodes();

        List<Integer> listMax = getMaxRowColumn(cellsList, selectedSpreadsheet);
        String[][] cells = new String[listMax.get(0)][listMax.get(1)];
        //Preenche a matriz com os dados
        for (int i = 0; i < cellsList.getLength(); i++) {

            Node node = cellsList.item(i);
            if (node instanceof Element) {

                Element cell = (Element) node;
                cells[Integer.parseInt(cell.getAttribute("row"))][Integer.parseInt(cell.getAttribute("column"))] = cell.getTextContent();
            }
        }
        for (int row = 0; row < listMax.get(0); row++) {
            for (int column = 0; column < listMax.get(1); column++) {
                if(cells[row][column]==null){
                    selectedSpreadsheet.getCell(row, column).clear();
                }else{
                    selectedSpreadsheet.getCell(row, column).setContent(cells[row][column]);
                }
            }
        }
        
        return true;
    }

    /**
     * Initial parsing file using DOM parser. Tags in xml file aree extracted and 
     * elements from the file are constructed.
     * @throws ParserConfigurationException
     * @throws UnsupportedEncodingException
     * @throws SAXException
     * @throws IOException 
     */
    public void parseXML() throws ParserConfigurationException, UnsupportedEncodingException, SAXException, IOException
    {
        File xmlFile = new File(this.fileName);
        //Create a document builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Create a document from a file
        try{
            this.doc = builder.parse(xmlFile);
        } catch(SAXException ex){
            throw new IllegalArgumentException("File is not well formated!");
        }
        //Puts all Text nodes in the full depth of the sub-tree underneath this Node where only structure separates Text nodes
        this.doc.getDocumentElement().normalize(); 
        //Extract tag names
        extractTagNames(doc);
    }

    /**
     * Responsible method to extract tag names. XML tags are configure by the
     * user. The first tag refers to the workbook, the second tag refers to
     * cellsheets and the third tag refers to cells.
     *
     * @param doc doc created by DOM parser
     */
    protected void extractTagNames(Document doc)
    {
        //Extract the root element - worksheet tag
        Node root = doc.getDocumentElement();
  
        //extract the spreadsheet tag
        NodeList spreadTagList = root.getChildNodes();
        Element child = null;
        for (int i = 0; i < spreadTagList.getLength(); i++) {
            if (spreadTagList.item(i) instanceof Element) {
                child = (Element) spreadTagList.item(i);
            }
        }

        this.spreadsheetName = child.getTagName();

        //extract the cell tag
        NodeList cellTagList = child.getChildNodes();
        for (int i = 0; i < cellTagList.getLength(); i++) {
            if (cellTagList.item(i) instanceof Element) {
                child = (Element) cellTagList.item(i);
            }
        }

        this.cellName = child.getTagName();

    }

    /**
     * Constructs a list with all the id's of spreadsheets in the file. Important to know
     * the position of them in the workbook when imported.
     * @return a list with all the id's of spreadsheets in the file
     */
    protected List<Integer> extractIdsSpreadsheets()
    {
        this.idsSpreadsheetList = new ArrayList<>();

        NodeList spreadsheetList = this.doc.getElementsByTagName(this.spreadsheetName);

        //percorre todas as spreadsheets existentes no ficheiro XML
        for (int i = 0; i < spreadsheetList.getLength(); i++) {
            Node node = spreadsheetList.item(i);

            if (node instanceof Element) {
                Element spreadsheet = (Element) node;
                //find the id of the spreadsheet
                String id = spreadsheet.getAttribute("id");
                idsSpreadsheetList.add(Integer.parseInt(id));
            }
        }
        return idsSpreadsheetList;
    }
    
    /**
     * Obtains the max number of rows and columns between the exiting data in the 
     * selected spreadsheet and the new data to import
     * @param cellsList a list with the cells to import
     * @param spreadsheet spreadsheet to compare the number of rows and columns
     * @return index 0 - max number of rows; index 1 - max number of columns 
     */
    private List<Integer> getMaxRowColumn(NodeList cellsList, Spreadsheet spreadsheet){
        
        List<Integer> listMax = new ArrayList<>();
        int maxRow = spreadsheet.getRowCount();
        int maxColumn = spreadsheet.getColumnCount();
        
        for (int i = 0; i < cellsList.getLength(); i++) {

            Node node = cellsList.item(i);
            if (node instanceof Element) {

                Element cell = (Element) node;
                int numRow = Integer.parseInt(cell.getAttribute("row"));
                int numColumn = Integer.parseInt(cell.getAttribute("column"));
                if(numRow > maxRow){
                    maxRow = numRow;
                }
                if(numColumn > maxColumn){
                 maxColumn = numColumn;   
                }
            }
        }
        listMax.add(maxRow+1);
        listMax.add(maxColumn+1);
        return listMax;
    }
    
    protected List<Integer> getIdsSpreadsheetList(){
        return this.idsSpreadsheetList;
    }
    
    protected String getCellName(){
        return this.cellName;
    }
    
    protected String getSpreadsheetName(){
        return this.spreadsheetName;
    }

    protected Document getDoc()
    {
        return doc;
    }
    
}
