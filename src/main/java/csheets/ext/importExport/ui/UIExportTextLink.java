package csheets.ext.importExport.ui;

import csheets.ext.importExport.controller.ExportTextLinkController;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author André Oliveira
 */
public class UIExportTextLink extends JComponent {

    private JTextField fileName = new JTextField();
    private JTextField header = new JTextField();
    private JTextField delimiter = new JTextField();
    private JTextField dir = new JTextField();
    private ExportTextLinkController controller;

    /**
     * The checkbox that indicates whether or not the 1st line is a header
     */
    private JCheckBox headerBox = new JCheckBox("1st line is a Header");
    private JButton open = new JButton("Choose File");

    public UIExportTextLink() {

        fileName.setEditable(false);
        delimiter.setPreferredSize(
                new Dimension(80, 5));

        // Creates and configures containers
        JPanel filePanel = new JPanel(new BorderLayout(5, 2));
        open.addActionListener(new UIExportTextLink.saveAction());
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
     *
     * @param parent the parent component of the dialog
     * @param title the title of the dialog
     * @param focusOwner a SpreadsheetTable with the Selected Cells
     */
    public void showDialog(Component parent, String title, SpreadsheetTable focusOwner) {
        UIExportTextLink chooser = new UIExportTextLink();
        int returnValue = JOptionPane.showConfirmDialog(
                parent,
                chooser,
                title,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                (Icon) null);
        if (returnValue == JOptionPane.OK_OPTION) {
            if (chooser.delimiter.getText().equalsIgnoreCase("") || chooser.fileName.getText().equalsIgnoreCase("")) {

                JOptionPane.showMessageDialog(null, "Enter the missing data!", "Info Box " + "", JOptionPane.INFORMATION_MESSAGE);
                showDialog(this, "Export from Text Link file", focusOwner);
                return;
            } else {

                this.controller = new ExportTextLinkController(chooser.delimiter.getText(),
                        chooser.dir.getText(), chooser.fileName.getText(),
                        chooser.headerBox.isSelected(), focusOwner);

                //first time that the data is saved
                this.controller.runExport();

                JOptionPane.showMessageDialog(null, "File successfully exported! "
                        + "In the next change the selection will be linked!",
                        "Import", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

    /**
     * Method that is executed when choose file button is pressed. Open a
     * JFileChooser that allows to save a text file.
     */
    class saveAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser saveJFileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt", "text");
            saveJFileChooser.setFileFilter(filter);
            int returnVal = saveJFileChooser.showSaveDialog(UIExportTextLink.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String name = saveJFileChooser.getSelectedFile().getName();
                if (!name.substring(name.length() - 4).equals(".txt")) {
                    name += (".txt");
                }
                fileName.setText(name);
                dir.setText(saveJFileChooser.getCurrentDirectory().toString());
            }
            if (returnVal == JFileChooser.CANCEL_OPTION) {
                fileName.setText("You pressed cancel");
                dir.setText("");
            }
        }
    }

}
