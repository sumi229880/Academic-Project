/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.BankEmployeeRole;

import Business.Enterprise.Enterprise;
import Business.NewUser.NewUser;
import Business.Organization.WorkAreaJPanel;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.NewCustomerWorkRequest;
import Business.WorkQueue.NewCustomerWorkRequest.Result;
import Business.WorkQueue.CoreBankingWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import userinterface.CoreBankingTeamRole.NewUserDocumentJPanel;

/**
 *
 * @author Sumeet
 */
public class CustomerDetails extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;

    private WorkRequest workRequest;
    private WorkAreaJPanel parentPage;

    /**
     * Creates new form CustomerDetails
     */
    public CustomerDetails(JPanel container, WorkRequest workRequest, UserAccount userAccount, WorkAreaJPanel parentPage, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = container;
        this.parentPage = parentPage;
        this.workRequest = workRequest;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        populateNewUserDetails();
        showHideButtons();
    }

    void populateNewUserDetails() {

        NewUser newUserDetails = null;
        if (userAccount.getRole().getRoleType().equals(Role.RoleType.BankPerson)) {
            NewCustomerWorkRequest request = (NewCustomerWorkRequest) workRequest;
            newUserDetails = request.getNewUserInfo();
        } else {
            // Assuming role security
            CoreBankingWorkRequest request = (CoreBankingWorkRequest) workRequest;
            newUserDetails = request.getNewUserRequest().getNewUserInfo();
        }

        this.txtCity.setText(newUserDetails.getCity());
        this.txtState.setText(newUserDetails.getState());
        this.txtFirstName.setText(newUserDetails.getFirstName());
        this.txtLastName.setText(newUserDetails.getLastName());
        this.txtMobile.setText(Long.toString(newUserDetails.getMobile()));
        this.txtStreet.setText(newUserDetails.getStreetName());
        this.txtZip.setText(Integer.toString(newUserDetails.getZipCode()));
        this.txtCountry.setText(newUserDetails.getCountry());
        this.txtEmail.setText(newUserDetails.getEmail());
        this.txtHouseNumber.setText(newUserDetails.getBuildingNo());
        this.txtSSN.setText(newUserDetails.getSSN());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtZip = new javax.swing.JTextField();
        txtStreet = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtHouseNumber = new javax.swing.JTextField();
        txtMobile = new javax.swing.JTextField();
        txtState = new javax.swing.JTextField();
        txtCountry = new javax.swing.JTextField();
        txtSSN = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnPass = new javax.swing.JButton();
        btnFail = new javax.swing.JButton();
        btnViewDocument = new javax.swing.JButton();
        btnEscalate = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("First Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 166, 35));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Last Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, 35));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Street");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 166, 35));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("House Number");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 123, 35));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("City");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 126, 35));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("State");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 59, 35));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Country");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 166, 35));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Zip Code");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 166, 35));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("Email");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 166, 35));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setText("Mobile Number");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, 35));

        txtFirstName.setEnabled(false);
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });
        add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 236, 41));

        txtZip.setEnabled(false);
        add(txtZip, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 236, 41));

        txtStreet.setEnabled(false);
        add(txtStreet, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 236, 41));

        txtEmail.setEnabled(false);
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 236, 41));

        txtCity.setEnabled(false);
        add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 236, 41));

        txtLastName.setEnabled(false);
        add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 236, 41));

        txtHouseNumber.setEnabled(false);
        add(txtHouseNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, 236, 41));

        txtMobile.setEnabled(false);
        add(txtMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, 236, 41));

        txtState.setEnabled(false);
        add(txtState, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 236, 41));

        txtCountry.setEnabled(false);
        add(txtCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 236, 41));

        txtSSN.setEnabled(false);
        add(txtSSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 236, 41));

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, 125, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setText("SSN");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee Inputs"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPass.setBackground(new java.awt.Color(255, 255, 255));
        btnPass.setText("Pass Request");
        btnPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPassMouseEntered(evt);
            }
        });
        btnPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPassActionPerformed(evt);
            }
        });
        jPanel1.add(btnPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 143, -1));

        btnFail.setBackground(new java.awt.Color(255, 255, 255));
        btnFail.setText("Fail Request");
        btnFail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFailMouseEntered(evt);
            }
        });
        btnFail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFailActionPerformed(evt);
            }
        });
        jPanel1.add(btnFail, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 146, -1));

        btnViewDocument.setBackground(new java.awt.Color(255, 255, 255));
        btnViewDocument.setText("View Document");
        btnViewDocument.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnViewDocumentMouseEntered(evt);
            }
        });
        btnViewDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDocumentActionPerformed(evt);
            }
        });
        jPanel1.add(btnViewDocument, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        btnEscalate.setBackground(new java.awt.Color(255, 255, 255));
        btnEscalate.setText("Escalate");
        btnEscalate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEscalateMouseEntered(evt);
            }
        });
        btnEscalate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscalateActionPerformed(evt);
            }
        });
        jPanel1.add(btnEscalate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 143, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 718, 129));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel15.setText("New Customer Details");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sumeet\\Desktop\\Assignments\\AED Assignments\\Final\\9.jpg")); // NOI18N
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 620));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEscalateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscalateActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestLabTestJPanel", new EscalationPageJPanel(userProcessContainer, userAccount, enterprise, parentPage, (NewCustomerWorkRequest) workRequest));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnEscalateActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void btnPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPassActionPerformed
        processPassFailRequest(true);
    }//GEN-LAST:event_btnPassActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDocumentActionPerformed
        CoreBankingWorkRequest securityTestRequest = (CoreBankingWorkRequest) workRequest;
        NewUser newUserInfo = securityTestRequest.getNewUserRequest().getNewUserInfo();
        NewUserDocumentJPanel documentContainer = new NewUserDocumentJPanel(newUserInfo.getFilePath());
        pageTitle = "Attached document for " + newUserInfo.getFirstName() + " " + newUserInfo.getLastName();
        documentContainer.loadPage(pageTitle);
    }//GEN-LAST:event_btnViewDocumentActionPerformed
    private String pageTitle;

    private void btnFailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFailActionPerformed
        processPassFailRequest(false);
    }//GEN-LAST:event_btnFailActionPerformed

    private void btnPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPassMouseEntered
        // TODO add your handling code here:
        //System.err.println("hi");
        btnPass.setToolTipText("Recheck before passing the request");
    }//GEN-LAST:event_btnPassMouseEntered

    private void btnFailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFailMouseEntered
        // TODO add your handling code here:
        btnFail.setToolTipText("Recheck before failing the request");
    }//GEN-LAST:event_btnFailMouseEntered

    private void btnEscalateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEscalateMouseEntered
        // TODO add your handling code here:
        btnEscalate.setToolTipText("For 2-tier validation request");
    }//GEN-LAST:event_btnEscalateMouseEntered

    private void btnViewDocumentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewDocumentMouseEntered
        // TODO add your handling code here:
        btnViewDocument.setToolTipText("Click to view the document submitted by New User");
    }//GEN-LAST:event_btnViewDocumentMouseEntered

    private void processPassFailRequest(boolean pass) {
        if (userAccount.getRole().getRoleType().equals(Role.RoleType.BankPerson)) {
            NewCustomerWorkRequest newUserRequest = (NewCustomerWorkRequest) workRequest;
            newUserRequest.setStatus(NewCustomerWorkRequest.NewCustomerRequestStatus.COMPLETED);
            if (pass) {
                newUserRequest.setResult(Result.PASS);
            } else {
                newUserRequest.setResult(Result.FAIL);
            }

        } else {
            // Assuming the role to be security
            CoreBankingWorkRequest securityTestRequest = (CoreBankingWorkRequest) workRequest;
            if (pass) {
                securityTestRequest.setTestResult(CoreBankingWorkRequest.TestResult.PASS);
            } else {
                securityTestRequest.setTestResult(CoreBankingWorkRequest.TestResult.FAIL);
            }
            securityTestRequest.setTestRequestStatus(CoreBankingWorkRequest.TestRequestStatus.COMPLETED);

            NewCustomerWorkRequest newUserRequest = securityTestRequest.getNewUserRequest();
            if (pass) {
                newUserRequest.setResult(Result.PASS);
            } else {
                newUserRequest.setResult(Result.FAIL);
            }
        }

        userProcessContainer.remove(this);
        parentPage.populateRequestTable();
        userProcessContainer.add("parentPage", parentPage);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEscalate;
    private javax.swing.JButton btnFail;
    private javax.swing.JButton btnPass;
    private javax.swing.JButton btnViewDocument;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtHouseNumber;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtSSN;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtStreet;
    private javax.swing.JTextField txtZip;
    // End of variables declaration//GEN-END:variables

    private void showHideButtons() {
        Role userRole = this.userAccount.getRole();

        if (userRole.getRoleType().equals(Role.RoleType.BankPerson)) {
            btnEscalate.setVisible(true);
            btnViewDocument.setVisible(false);

            NewCustomerWorkRequest newUserRequest = (NewCustomerWorkRequest) workRequest;
            NewCustomerWorkRequest.NewCustomerRequestStatus status = newUserRequest.getStatus();
            if (status.equals(NewCustomerWorkRequest.NewCustomerRequestStatus.COMPLETED) || status.equals(NewCustomerWorkRequest.NewCustomerRequestStatus.ESCALATED)) {
                btnPass.setEnabled(false);
                btnFail.setEnabled(false);
                btnEscalate.setEnabled(false);
            }
        } else {
            // Assuming the role is security
            btnEscalate.setVisible(false);
            btnViewDocument.setVisible(true);

            CoreBankingWorkRequest securityTestRequest = (CoreBankingWorkRequest) workRequest;
            CoreBankingWorkRequest.TestRequestStatus status = securityTestRequest.getTestRequestStatus();
            if (status.equals(CoreBankingWorkRequest.TestRequestStatus.COMPLETED)) {
                btnPass.setEnabled(false);
                btnFail.setEnabled(false);
            }
        }

    }
}
