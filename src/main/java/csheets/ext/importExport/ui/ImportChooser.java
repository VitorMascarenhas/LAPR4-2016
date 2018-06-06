package csheets.ext.importExport.ui;

import csheets.ext.importExport.controller.ImportAction;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.importExport.ImportExportTextStrategy;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A component which allows the user to select a text file to import data.
 * @author Einar Pehrson
 * @author José Vilela 1010500
 */
@SuppressWarnings("serial")
public class ImportChooser extends JComponent{
    
    private JTextField fileName = new JTextField();
    private JTextField header = new JTextField();
    private JTextField delimiter = new JTextField();
    private JTextField dir = new JTextField();
    
    /** The checkbox that indicates whether or not the 1st line is a Header */
    private JCheckBox headerBox = new JCheckBox("1st line is a Header");
    private JButton open = new JButton("Choose File"); 
    
    /**
    * Creates a new import selection panel.
    */
    public ImportChooser () {
           
        fileName.setEditable(false);
        delimiter.setPreferredSize(
                new Dimension(80, 5));

        // Creates and configures containers
        
        JPanel filePanel = new JPanel(new BorderLayout(5,2));
        open.addActionListener(new OpenAction());
        filePanel.add(open, BorderLayout.CENTER);
        filePanel.add(fileName, BorderLayout.SOUTH);
        filePanel.setBorder(BorderFactory.createTitledBorder("File"));
        
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(headerBox);
        headerPanel.setBorder(BorderFactory.createTitledBorder("Header"));
        
        JPanel delimiterPanel = new JPanel(new BorderLayout());
        delimiterPanel.add(delimiter);
        delimiterPanel.setBorder(BorderFactory.createTitledBorder("Delimiter"));
                
        // Configures layout and adds components
        setLayout(new BorderLayout(5, 5));
        add(headerPanel, BorderLayout.CENTER);
        add(delimiterPanel, BorderLayout.EAST);
        add(filePanel, BorderLayout.SOUTH);
    }
    
    /**
    * Lets the user select a delimiter and a file from a chooser
    * @param parent the parent component of the dialog
    * @param title the title of the dialog
    * @param focusOwner a SpreadsheetTable with the Selected Cells
    * @param uiController controller of app to refreshed the active cells
    * @throws java.io.FileNotFoundException if the file does not exist
     * @throws csheets.core.formula.compiler.FormulaCompilationException
    */
    public static void showDialog(Component parent, String title, SpreadsheetTable focusOwner, UIController uiController) throws FileNotFoundException, FormulaCompilationException {
        ImportChooser chooser = new ImportChooser();
        int returnValue  = JOptionPane.showConfirmDialog(
                parent,
                chooser,
                title,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                (Icon)null);
        if (returnValue == JOptionPane.OK_OPTION){
            if(chooser.delimiter.getText().equalsIgnoreCase("") || chooser.fileName.getText().equalsIgnoreCase("")){

                 JOptionPane.showMessageDialog(null, "Enter the missing data!", "Info Box " + "", JOptionPane.INFORMATION_MESSAGE);
                     try {
                             ImportChooser.showDialog(null,"Import from Text file",focusOwner, uiController);
                         } catch (FileNotFoundException | FormulaCompilationException ex) {
                             Logger.getLogger(ImportAction.class.getName()).log(Level.SEVERE, null, ex);
                         }
                 return;
             }

             String temp = chooser.delimiter.getText();
              // escapes special characteres
              if (temp.equals("\\"))
                  temp = temp.replace("\\", "\\\\");

              if (temp.equals("*"))
                  temp = temp.replace("*", "\\*");

              if (temp.equals("+"))
                  temp = temp.replace("+", "\\+");
              
             ImportExportTextStrategy textStrategy = new ImportExportTextStrategy(temp,chooser.dir.getText(),chooser.fileName.getText(),chooser.headerBox.isSelected());
             textStrategy.importFromFile(focusOwner, uiController);
        }
   }
    
    class OpenAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser openJFileChooser = new JFileChooser();
            int returnVal = openJFileChooser.showOpenDialog(ImportChooser.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                fileName.setText(openJFileChooser.getSelectedFile().getName());
                dir.setText(openJFileChooser.getCurrentDirectory().toString());
            }
            if (returnVal == JFileChooser.CANCEL_OPTION) {
                fileName.setText("You pressed cancel");
                dir.setText("");
            }
        }
    }
        
}
