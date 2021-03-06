/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.manager.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author 1950689 Nuno Mota
 */
public class ExtensionManagerPanel extends javax.swing.JPanel {

    
    private UIController uiController;
    private JFrame jframe;

    /**
     * Creates new form ExtensionManagerPanel
     */
    public ExtensionManagerPanel(UIController uic, JFrame jf) {
        this.uiController = uic;
        this.jframe = jf;
        initComponents(jf);

//        getChecked();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    /*
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
*/
    private void initComponents(JFrame jf) {
        for (UIExtension uiExt : this.uiController.getExtensions()) {
            String extPropKey = uiExt.getExtension().getPropertyKey();
            if(!uiExt.getExtension().getName().equalsIgnoreCase("extension manager"))
            if( (uiExt.getEnabledProperty(extPropKey) == null)
                    || (uiExt.getEnabledProperty(extPropKey) == false) 
                    || (extPropKey == null))
                this.add(new JCheckBox(uiExt.getExtension().getName(), false));
            else
                this.add(new JCheckBox(uiExt.getExtension().getName(), true));
            if(uiExt.getExtension().getName().equalsIgnoreCase("extensions manager")){
                String s=uiExt.getExtension().getPropertyKey();
                uiExt.setEnabledProperty(s, true);
            }
        }
        
        JButton btnOk;
        btnOk = new JButton("Ok");
        this.add(btnOk);
        JButton btnC;
        btnC = new JButton("Cancel");
        this.add(btnC);

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    selectionOkPressed();
                    getChecked();
                } catch (Throwable ex) {
                    Logger.getLogger(ExtensionManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            private void selectionOkPressed() throws Throwable {
                jf.dispose();
            }
            
        });

        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    selectionCancelPressed();
                } catch (Throwable ex) {
                    Logger.getLogger(ExtensionManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            private void selectionCancelPressed() throws Throwable {
                jf.dispose();
            }

        });
    }

    protected void getChecked() {
        for(Component c : this.getComponents()){
                if(c instanceof  javax.swing.JCheckBox){
                     JCheckBox jcb = (JCheckBox) c;
                     if(jcb.isSelected()){
                         for(UIExtension uie : this.uiController.getExtensions()){
                             if(uie.getExtension().getName().equalsIgnoreCase(jcb.getText())){
                                uie.setEnabledProperty(uie.getExtension().getPropertyKey(), true);
                                if(uie.getMenu()!= null){
                                    uie.getMenu().setEnabled(true);
                                }
                                if(uie.getToolBar()!= null){
                                    for(Component comp : uie.getToolBar().getComponents()){
                                        comp.setEnabled(true);
                                    }
                                    
                                }
                             }
                         }
                     }else{
                         for(UIExtension uie : this.uiController.getExtensions()){
                             if(uie.getExtension().getName().equalsIgnoreCase(jcb.getText())){
                                uie.setEnabledProperty(uie.getExtension().getPropertyKey(), false);
                                 if(uie.getMenu()!= null){
                                     uie.getMenu().setEnabled(false);
                                }
                                 if(uie.getToolBar()!= null){
                                    for(Component comp : uie.getToolBar().getComponents()){
                                        comp.setEnabled(false);
                                    }
                                    
                                }
                             }
                         }
                     }
                }
            }
    }
    
    
    
}
