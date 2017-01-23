/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.BankEmployeeRole;

import Business.Enterprise.Enterprise;
import Business.Organization.CoreBankingOrganization;
import Business.Organization.Organization;
import Business.Organization.WorkAreaJPanel;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.NewCustomerWorkRequest;
import Business.WorkQueue.CoreBankingWorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Sumeet
 */
public class EscalationPageJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private WorkAreaJPanel nextPage = null;

    private List<JRadioButton> radioButtons = new ArrayList<>();

    private NewCustomerWorkRequest newUserWorkRequest;

    /**
     * Creates new form RequestLabTestJPanel
     */
    EscalationPageJPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, WorkAreaJPanel parentPage, NewCustomerWorkRequest newUserWorkRequest) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.nextPage = parentPage;
        this.newUserWorkRequest = newUserWorkRequest;

        radioButtons.add(jRadioButton1);
        radioButtons.add(jRadioButton2);
        radioButtons.add(jRadioButton3);
        radioButtons.add(jRadioButton4);
        radioButtons.add(jRadioButton5);
        radioButtons.add(jRadioButton6);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioButtonGroup = new javax.swing.ButtonGroup();
        requestTestJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        messageJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestTestJButton.setBackground(new java.awt.Color(255, 255, 255));
        requestTestJButton.setText("Escalate to Core Banking Team");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Message");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, -1, -1));

        messageJTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                messageJTextFieldMouseEntered(evt);
            }
        });
        messageJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageJTextFieldActionPerformed(evt);
            }
        });
        add(messageJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 250, -1));

        backJButton.setBackground(new java.awt.Color(255, 255, 255));
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, -1, -1));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        radioButtonGroup.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton1.setText("PI details do not match with bank records");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        radioButtonGroup.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton2.setText("Invalid Address");
        add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, -1, -1));

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        radioButtonGroup.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton3.setText("SSN History has bad remarks");
        add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, -1, -1));

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        radioButtonGroup.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton4.setText("Others (Specify below)");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, -1, -1));

        jRadioButton5.setBackground(new java.awt.Color(255, 255, 255));
        radioButtonGroup.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton5.setText("Involved in illegal activites in past");
        add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        jRadioButton6.setBackground(new java.awt.Color(255, 255, 255));
        radioButtonGroup.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton6.setText("Criminal Background");
        add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Escalation Page");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sumeet\\Desktop\\Assignments\\AED Assignments\\Final\\9.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, -20, 1190, 860));
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed

        JRadioButton selectedRadioButton = getSelectedRadioButton();

        if (null == selectedRadioButton) {
            JOptionPane.showMessageDialog(this, "Select reason for escalation", "Error processing request", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String message = null;
        if (selectedRadioButton.getText().equalsIgnoreCase("Others (Specify below)")) {
            message = messageJTextField.getText();
            if (message == null || message.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please add your comment for escalation.", "Error processing request", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            message = selectedRadioButton.getText();
        }

        CoreBankingWorkRequest request = new CoreBankingWorkRequest();
        request.setMessage(message);
        request.setSender(userAccount);
        request.setTestRequestStatus(CoreBankingWorkRequest.TestRequestStatus.INITIATED);
        request.setNewUserRequest(newUserWorkRequest);
        request.setTestResult(CoreBankingWorkRequest.TestResult.UNKNOWN);
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof CoreBankingOrganization) {
                org = organization;
                break;
            }
        }

        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(request);
            newUserWorkRequest.setStatus(NewCustomerWorkRequest.NewCustomerRequestStatus.ESCALATED);
            userProcessContainer.removeAll();
            nextPage.populateRequestTable();
            userProcessContainer.add("bankPersonPage", nextPage);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private JRadioButton getSelectedRadioButton() {
        Iterator<JRadioButton> iterator = radioButtons.iterator();

        while (iterator.hasNext()) {
            JRadioButton button = iterator.next();
            if (button.isSelected()) {
           //     System.out.println("Text :: " + button.getText());
                return button;
            }
        }
        return null;
    }

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_backJButtonActionPerformed

    private void messageJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageJTextFieldActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void messageJTextFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageJTextFieldMouseEntered
        // TODO add your handling code here:
        messageJTextField.setToolTipText("Please enter valid comments before you escalate");
    }//GEN-LAST:event_messageJTextFieldMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.ButtonGroup radioButtonGroup;
    private javax.swing.JButton requestTestJButton;
    // End of variables declaration//GEN-END:variables

}
