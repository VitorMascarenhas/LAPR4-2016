/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.manager.ui;

import csheets.ext.manager.MetadataManager;
import csheets.ext.manager.controller.AutoDescriptionController;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author André Oliveira
 */
public class AutoDescriptionPanel extends javax.swing.JDialog {

    private AutoDescriptionController controller;
    private Set<String> files;
    private List<String> currentDescription;
    private List<String> currentVersions;
    private List<String> extensionsToBeLoaded;

    /**
     * Creates new form AutoDescriptionPanel
     */
    public AutoDescriptionPanel() {

        super((JFrame) null, true);

        this.files = new HashSet<>();
        this.currentDescription = new ArrayList<>();
        this.currentVersions = new ArrayList<>();
        this.extensionsToBeLoaded = new ArrayList<>();

        initComponents();

        setTitle("Auto-description of Extensions");
        setLocationRelativeTo(null);

        this.controller = new AutoDescriptionController();

        MetadataManager metadata = this.controller.getMetadataManager();

        this.files = metadata.getMetadataFiles();

        //put the files names in the comboxBox of Extensions
        comboExtensions();

        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxVersion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDescription = new javax.swing.JTextArea();
        labelVersion = new javax.swing.JLabel();
        labelDescription = new javax.swing.JLabel();
        labelExtension = new javax.swing.JLabel();
        comboBoxExtension = new javax.swing.JComboBox<>();
        btnRemove = new javax.swing.JButton();
        btnLoadApplication = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        comboBoxVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxVersionActionPerformed(evt);
            }
        });

        textAreaDescription.setEditable(false);
        textAreaDescription.setColumns(20);
        textAreaDescription.setRows(5);
        jScrollPane1.setViewportView(textAreaDescription);

        labelVersion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelVersion.setText("Version Info");

        labelDescription.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelDescription.setText("Description");

        labelExtension.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelExtension.setText("Metadata Extension File");

        comboBoxExtension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxExtensionActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove Extension");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnLoadApplication.setText("Load Application");
        btnLoadApplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadApplicationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxExtension, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelExtension)
                        .addGap(0, 49, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelVersion)
                    .addComponent(comboBoxVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLoadApplication))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDescription))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVersion)
                    .addComponent(labelDescription)
                    .addComponent(labelExtension))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxExtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove)
                    .addComponent(btnLoadApplication))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

        int index = this.comboBoxExtension.getSelectedIndex();
        String extension = this.comboBoxExtension.getItemAt(index).substring(0,
                this.comboBoxExtension.getItemAt(index).indexOf("."));

        boolean result = this.controller.removeExtension(extension);
        
        int versionIndex = this.comboBoxVersion.getSelectedIndex();
        String version = this.comboBoxVersion.getItemAt(versionIndex);

        if (result) {
            JOptionPane.showMessageDialog(null, "Extension " + extension +" "+ version + " was removed.",
                    "Successful", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cannot remove extension "+ extension +" "+ version +"!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void comboBoxExtensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxExtensionActionPerformed

        StringBuilder builder = new StringBuilder();

        int currentPosition = this.comboBoxExtension.getSelectedIndex();

        builder.append(MetadataManager.getMETADATA_FILES_LOCATION());
        builder.append(this.comboBoxExtension.getItemAt(currentPosition));

        boolean validation = this.controller.readMetadataInfo(builder.toString(),
                this.currentDescription, this.currentVersions);

        if (!validation) {
            JOptionPane.showMessageDialog(null, "Could not open the file "
                    + this.comboBoxExtension.getItemAt(currentPosition),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            comboBoxVersion.removeAllItems();

            for (int i = 0; i < this.currentVersions.size(); i++) {

                comboBoxVersion.addItem(this.currentVersions.get(i));

            }

        }
    }//GEN-LAST:event_comboBoxExtensionActionPerformed

    private void comboBoxVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxVersionActionPerformed

        int index = comboBoxVersion.getSelectedIndex();

        if (!currentVersions.isEmpty() && index >= 0) {

            String description = currentDescription.get(index);

            this.textAreaDescription.setText(description);

        }

    }//GEN-LAST:event_comboBoxVersionActionPerformed

    private void btnLoadApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadApplicationActionPerformed

        boolean result = this.controller.loadExtensions(this.extensionsToBeLoaded);

        if (!result) {
            JOptionPane.showMessageDialog(null, "Could not open extensions.props file ",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            
            StringBuilder builder = new StringBuilder();
            
            for (String extension : this.extensionsToBeLoaded) {
                builder.append(extension.substring(extension.lastIndexOf(".") + 1, extension.length()));
                builder.append("\n");
            }

            JOptionPane.showMessageDialog(null, "Extension that will be loaded:\n\n "+builder.toString(),
                    "Information", JOptionPane.INFORMATION_MESSAGE);

            dispose();
        }

    }//GEN-LAST:event_btnLoadApplicationActionPerformed

    public void comboExtensions() {

        for (String file : this.files) {
            this.comboBoxExtension.addItem(file);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadApplication;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<String> comboBoxExtension;
    private javax.swing.JComboBox<String> comboBoxVersion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelExtension;
    private javax.swing.JLabel labelVersion;
    private javax.swing.JTextArea textAreaDescription;
    // End of variables declaration//GEN-END:variables

}