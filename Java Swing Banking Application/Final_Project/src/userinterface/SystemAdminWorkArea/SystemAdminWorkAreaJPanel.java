/*
 * AdminWorkAreaJPanel.java
 *
 * Created on April 10, 2016, 8:50 AM
 */
package UserInterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Network.Network;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sumeet
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    EcoSystem system;

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        enableAll();
        addBackground();
        this.setSize(1020, 720);
        this.userProcessContainer = userProcessContainer;
        this.system = system;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        pageSplitter = new javax.swing.JSplitPane();
        rightSplitPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        buttonManageNetwork = new javax.swing.JButton();
        buttonManageEnterprise = new javax.swing.JButton();
        buttonAddNetwork = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtAddNetwork = new javax.swing.JTextField();
        buttonClose = new javax.swing.JButton();

        jToolBar1.setRollover(true);

        setLayout(new java.awt.BorderLayout());

        pageSplitter.setBackground(new java.awt.Color(204, 255, 0));
        pageSplitter.setDividerLocation(270);
        pageSplitter.setDividerSize(2);

        rightSplitPanel.setLayout(new java.awt.CardLayout());
        pageSplitter.setRightComponent(rightSplitPanel);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        buttonManageNetwork.setBackground(new java.awt.Color(255, 255, 255));
        buttonManageNetwork.setText("Manage Networks");
        buttonManageNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonManageNetworkActionPerformed(evt);
            }
        });
        jPanel2.add(buttonManageNetwork);
        buttonManageNetwork.setBounds(20, 250, 230, 29);

        buttonManageEnterprise.setBackground(new java.awt.Color(255, 255, 255));
        buttonManageEnterprise.setText("Manage Enterprises");
        buttonManageEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonManageEnterpriseActionPerformed(evt);
            }
        });
        jPanel2.add(buttonManageEnterprise);
        buttonManageEnterprise.setBounds(20, 400, 230, 29);

        buttonAddNetwork.setBackground(new java.awt.Color(255, 255, 255));
        buttonAddNetwork.setText("Add Network");
        buttonAddNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddNetworkActionPerformed(evt);
            }
        });
        jPanel2.add(buttonAddNetwork);
        buttonAddNetwork.setBounds(20, 110, 230, 29);

        jLabel4.setText("Create new Network");
        jLabel4.setEnabled(false);
        jPanel2.add(jLabel4);
        jLabel4.setBounds(60, 40, 170, 20);

        txtAddNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddNetworkActionPerformed(evt);
            }
        });
        jPanel2.add(txtAddNetwork);
        txtAddNetwork.setBounds(20, 70, 230, 26);

        buttonClose.setText("Close");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });
        jPanel2.add(buttonClose);
        buttonClose.setBounds(90, 480, 93, 29);

        pageSplitter.setLeftComponent(jPanel2);

        add(pageSplitter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonManageNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonManageNetworkActionPerformed

        ManageNetworksJPanel manageEnterpriseJPanel = new ManageNetworksJPanel(userProcessContainer, system);
        rightSplitPanel.removeAll();
        rightSplitPanel.add(manageEnterpriseJPanel);
        disableAll();
    }//GEN-LAST:event_buttonManageNetworkActionPerformed

    private void buttonManageEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonManageEnterpriseActionPerformed
        // TODO add your handling code here:
        ManageEnterpriseManagerJPanel manageEnterpriseAdminJPanel = new ManageEnterpriseManagerJPanel(userProcessContainer, system);
        rightSplitPanel.removeAll();

        rightSplitPanel.add(manageEnterpriseAdminJPanel);
        disableAll();
    }//GEN-LAST:event_buttonManageEnterpriseActionPerformed

    private void buttonAddNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddNetworkActionPerformed
        String name = txtAddNetwork.getText();
        if (name.equalsIgnoreCase("") || name.length() > 30){
            JOptionPane.showMessageDialog(this, "Network name not valid!", "Network creation failed", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        List<Network> networkList = system.getNetworkList();
        for (Network network : networkList) {
            if (network.getName().equalsIgnoreCase(name)) {
                JOptionPane.showMessageDialog(this, "Network already exists!", "Network creation failed", JOptionPane.ERROR_MESSAGE);
                txtAddNetwork.setText("");
                return;
            }
        }

        Network network = system.createAndAddNetwork();
        network.setName(name);
        JOptionPane.showMessageDialog(this, "Network Added Successfully");
        txtAddNetwork.setText("");
    }//GEN-LAST:event_buttonAddNetworkActionPerformed

    private void txtAddNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddNetworkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddNetworkActionPerformed


    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        addBackground();
        enableAll();
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void enableAll() {
        txtAddNetwork.setEditable(true);
        buttonAddNetwork.setEnabled(true);
        buttonManageNetwork.setEnabled(true);
        buttonManageEnterprise.setEnabled(true);
        buttonClose.setVisible(false);
    }

    private void disableAll() {
        txtAddNetwork.setEditable(false);
        buttonAddNetwork.setEnabled(false);
        buttonManageNetwork.setEnabled(false);
        buttonManageEnterprise.setEnabled(false);
        buttonClose.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddNetwork;
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonManageEnterprise;
    private javax.swing.JButton buttonManageNetwork;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JSplitPane pageSplitter;
    private javax.swing.JPanel rightSplitPanel;
    private javax.swing.JTextField txtAddNetwork;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel labelBackground = new javax.swing.JLabel();

    private void addBackground() {
        rightSplitPanel.removeAll();
        labelBackground.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sumeet\\Desktop\\Assignments\\AED Assignments\\Final\\9.jpg")); // NOI18N
        rightSplitPanel.add(labelBackground);
        rightSplitPanel.repaint();
    }
}
