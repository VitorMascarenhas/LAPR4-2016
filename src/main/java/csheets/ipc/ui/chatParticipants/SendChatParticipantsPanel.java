/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.ui.chatParticipants;

import csheets.ipc.ChatMessage;
import csheets.ipc.ChatParticipantsMessage;
import csheets.ipc.persistence.chatParticipantsMessage.ChatUser;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author ASUS
 */
public class SendChatParticipantsPanel extends javax.swing.JPanel {

    private UIController uiController;

    private final SendChatParticipantsController controller;

    private final DefaultListModel<String> availableServersListModel;
    private final DefaultListModel<String> connectedServersListModel;

    private final DefaultMutableTreeNode rootNode;
    private final DefaultTreeModel treeModel;

    private static final int TIME_VISIBLE = 3000;

    /**
     * Creates new form SendChatMessagePanel
     *
     * @param uiController The uiController
     */
    public SendChatParticipantsPanel(UIController uiController) {
        setName(SendChatParticipantsExtension.NAME);
        rootNode = new DefaultMutableTreeNode(new ChatUser(System.getProperty("user.name"), true));
        treeModel = new DefaultTreeModel(rootNode);
        initComponents();
        jLabel1.setText(System.getProperty("user.name"));

        tree.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);

        availableServersListModel = new DefaultListModel<>();
        connectedServersListModel = new DefaultListModel<>();

        btnDisconnect.setEnabled(true);
        btnSend.setEnabled(false);

        this.controller = new SendChatParticipantsController(uiController, this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnDisconnect = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tree = new JTree(treeModel);

        btnDisconnect.setText("Disconnect");
        btnDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisconnectActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jLabel2.setText("You'r nick name is:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDisconnect)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDisconnect)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSend))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );

        jScrollPane1.setViewportView(tree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        btnSendAction(evt);
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisconnectActionPerformed
        btnDisconnectAction(evt);
    }//GEN-LAST:event_btnDisconnectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDisconnect;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree tree;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables

    protected void enableConnect() {

    }

    protected void enableDisconnect() {
        btnDisconnect.setEnabled(true);
    }

    protected void enableSend() {
        btnSend.setEnabled(true);
    }

    protected synchronized void addRemoteAddress(Set<String> remoteInstances) {

        //add new ip address to jlist
        for (String a : remoteInstances) {
            if (!availableServersListModel.contains(a) && !connectedServersListModel.contains(a)) {
                availableServersListModel.addElement(a);
            }
        }
    }

    private void btnDisconnectAction(ActionEvent evt) {
        try {
            this.controller.disConnectFrom();
        } catch (IOException ex) {
            Logger.getLogger(SendChatParticipantsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnSendAction(ActionEvent evt) {

        if (txtMessage.getText().length() != 0) {
            try {
                this.controller.sendChatParticipantsMessage(txtMessage.getText(), jLabel1.getText());
                txtMessage.setText("");
            } catch (IOException ex) {
                Logger.getLogger(SendChatParticipantsPanel.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {

        }
    }

    private void replyToMessage(ChatMessage msg, int selectedRow, int threads) {
//        JDialog dlg = new MessageDialog(null, false, controller, msg, selectedRow, threads);
//        dlg.setLocationRelativeTo(null);
//        dlg.setVisible(true);
    }

    protected void displayPopup(ChatParticipantsMessage message) {
        //http://stackoverflow.com/questions/25103186/java-joptionpane-which-automatically-closes-after-few-seconds
        JOptionPane pane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = pane.createDialog(null, "New Messenger message");
        dialog.setModal(false);
        dialog.setVisible(true);

        new javax.swing.Timer(TIME_VISIBLE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        }).start();

        addParticipantsMessage(message);
    }

    protected void addParticipantsMessage(ChatParticipantsMessage message) {
        DefaultMutableTreeNode node = searchNickNode(message.getnick());

        if (node != null) {
            addObject(node, message, true);
        } else {
            addObject(message);
        }
    }

    public DefaultMutableTreeNode searchNode(String parentId) {
        DefaultMutableTreeNode node = null;
        Enumeration e = ((DefaultMutableTreeNode) treeModel.getRoot()).breadthFirstEnumeration();

        while (e.hasMoreElements()) {
            node = (DefaultMutableTreeNode) e.nextElement();
            ChatUser c = (ChatUser) (node.getUserObject());

            if (c.getNick().equalsIgnoreCase(parentId)) {
                return node;
            }
        }
        return null;
    }

    public DefaultMutableTreeNode searchNickNode(String nick) {
        DefaultMutableTreeNode node = null;
        Enumeration e = ((DefaultMutableTreeNode) treeModel.getRoot()).breadthFirstEnumeration();

        while (e.hasMoreElements()) {

            node = (DefaultMutableTreeNode) e.nextElement();

            if (node.getUserObject() instanceof ChatUser) {
                ChatUser c = (ChatUser) (node.getUserObject());

                if (c.getNick().equalsIgnoreCase(nick)) {
                    return node;
                }
            }
            else{
                ChatParticipantsMessage m = (ChatParticipantsMessage)node.getUserObject();
                
                if(m.getnick().equalsIgnoreCase(nick)){
                    return node;
                }
            }
            

        }
        return null;
    }

    //http://www.java2s.com/Tutorial/Java/0240__Swing/DynamicTree.htm
    public DefaultMutableTreeNode addObject(Object child) {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = tree.getSelectionPath();

        if (parentPath == null) {
            parentNode = rootNode;
        } else {
            parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
        }

        return addObject(parentNode, child, true);
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
            Object child, boolean shouldBeVisible) {
        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);

        if (parent == null) {
            parent = rootNode;
        }

        // It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
        treeModel.insertNodeInto(childNode, parent, parent.getChildCount());

        // Make sure the user can see the lovely new node.
        if (shouldBeVisible) {
            tree.scrollPathToVisible(new TreePath(childNode.getPath()));
        }
        return childNode;
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
            Object child) {
        return addObject(parent, child, false);
    }

    public void setUser(ChatUser u) {
        DefaultMutableTreeNode node = searchNickNode(u.getNick());

        if (node != null) {
            addObject(node, u, true);
        } else {
            addObject(u);
        }
    }

    class MyTreeModelListener implements TreeModelListener {

        @Override
        public void treeNodesChanged(TreeModelEvent e) {
            DefaultMutableTreeNode node;
            node = (DefaultMutableTreeNode) (e.getTreePath().getLastPathComponent());

            /*
       * If the event lists children, then the changed node is the child of the
       * node we've already gotten. Otherwise, the changed node and the
       * specified node are the same.
             */
            int index = e.getChildIndices()[0];
            node = (DefaultMutableTreeNode) (node.getChildAt(index));

            System.out.println("The user has finished editing the node.");
            System.out.println("New value: " + node.getUserObject());
        }

        public void treeNodesInserted(TreeModelEvent e) {
        }

        public void treeNodesRemoved(TreeModelEvent e) {
        }

        public void treeStructureChanged(TreeModelEvent e) {
        }
    }
}
