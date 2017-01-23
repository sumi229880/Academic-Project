/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CyberSecurity;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.CyberSecurityOrganization;
import Business.Organization.Organization;
import Business.UserAccount.LoginDetails;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Sumeet
 */
public class CyberSecurityJPanel extends javax.swing.JPanel {

    private JPanel container;
    private UserAccount userAccount;
    private CyberSecurityOrganization corganization;
    private Enterprise enterprise;
    private static final int ID_COLUMN_INDEX = 1;

    /**
     * Creates new form CyberSecurityJPanel
     */
    public CyberSecurityJPanel(JPanel userProcessContainer, UserAccount account, CyberSecurityOrganization organization, Enterprise enterprise) {
        initComponents();
        this.container = userProcessContainer;
        this.userAccount = account;
        this.corganization = organization;
        this.enterprise = enterprise;
        init();
    }

    private void init() {

        employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        populateOrganizationComboBox();
        populateEmployeeInfo();

        organizationComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });

        btnLoadAllEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadAllEmployeesActionPerformed(evt);
            }
        });
        initPage();
    }

    private void btnLoadAllEmployeesActionPerformed(ActionEvent evt) {
        initPage();
        populateEmployeeInfo();
    }

    private void organizationJComboBoxActionPerformed(ActionEvent evt) {
        initPage();
        populateEmployeeInfo();
    }

    private void initPage() {
        btnLogs.setVisible(false);
        initTextFields();
        removeChart();
    }

    private void removeChart() {
        chartContainer.removeAll();
        chartContainer.repaint();
    }

    private void initTextFields() {
        textNameField.setText("");
        textAddressField.setText("");
        textSSNField.setText("");
        textEmailField.setText("");
        textPhoneField.setText("");
        txtSearchField.setText("");
        textDOJField.setText("");
    }

    private void populateEmployeeInfo() {
        DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
        employeeTable.removeAll();
        model.setRowCount(0);

        Organization organization = (Organization) organizationComboBox.getSelectedItem();
        UserAccountDirectory userAccountDirectory = organization.getUserAccountDirectory();

        if (null == userAccountDirectory) {
            return;
        }

        int serialNumber = 0;
        for (UserAccount userAccount : userAccountDirectory.getUserAccountList()) {
            LoginDetails latestLoginDetails = userAccount.getLatestLoginDetails();
            Employee employee = userAccount.getEmployee();
            List<Object> row = new ArrayList<>();
            row.add(++serialNumber);
            row.add(employee.getId());
            row.add(employee.getName());
            if (null != latestLoginDetails) {
                row.add(latestLoginDetails.getLoginDate() + " " + LoginDetails.getFormattedTime(latestLoginDetails.getLoginTime()));
                row.add(latestLoginDetails.getLoginDate() + " " + LoginDetails.getFormattedTime(latestLoginDetails.getLogoutTime()));
            } else {
                row.add("N/A");
                row.add("N/A");
            }
            model.addRow(row.toArray());
        }
    }

    private void populateOrganizationComboBox() {
        organizationComboBox.removeAllItems();
        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            organizationComboBox.addItem(org);
        }

        System.out.println(organizationComboBox.getItemCount());
        for (int i = 0; i < organizationComboBox.getItemCount(); i++) {
            System.err.println(" Item : " + organizationComboBox.getItemAt(i));
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        viewDetailsButton = new javax.swing.JButton();
        txtSearchField = new javax.swing.JTextField();
        btnLoadAllEmployees = new javax.swing.JButton();
        organizationComboBox = new javax.swing.JComboBox();
        employeeDetailsPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textSSNField = new javax.swing.JTextField();
        textPhoneField = new javax.swing.JTextField();
        textDOJField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textAddressField = new javax.swing.JTextField();
        textEmailField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textNameField = new javax.swing.JTextField();
        chartContainer = new javax.swing.JPanel();
        btnLogs = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setText("Organisations");
        add(jLabel1);
        jLabel1.setBounds(340, 20, 105, 20);

        employeeTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(153, 204, 0), new java.awt.Color(153, 204, 0)));
        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.No", "Id", "Name", "Login Time", "Logout Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(employeeTable);
        if (employeeTable.getColumnModel().getColumnCount() > 0) {
            employeeTable.getColumnModel().getColumn(0).setResizable(false);
            employeeTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            employeeTable.getColumnModel().getColumn(1).setResizable(false);
            employeeTable.getColumnModel().getColumn(1).setPreferredWidth(5);
            employeeTable.getColumnModel().getColumn(2).setResizable(false);
            employeeTable.getColumnModel().getColumn(3).setResizable(false);
            employeeTable.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(100, 60, 830, 140);

        viewDetailsButton.setBackground(java.awt.Color.white);
        viewDetailsButton.setText("View Details");
        viewDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailsButtonActionPerformed(evt);
            }
        });
        add(viewDetailsButton);
        viewDetailsButton.setBounds(100, 210, 171, 29);

        txtSearchField.setText("Search by name");
        txtSearchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtSearchFieldMouseEntered(evt);
            }
        });
        txtSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchFieldActionPerformed(evt);
            }
        });
        add(txtSearchField);
        txtSearchField.setBounds(760, 210, 171, 29);

        btnLoadAllEmployees.setBackground(java.awt.Color.white);
        btnLoadAllEmployees.setText("Load All Employees");
        btnLoadAllEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoadAllEmployeesMouseEntered(evt);
            }
        });
        add(btnLoadAllEmployees);
        btnLoadAllEmployees.setBounds(430, 210, 171, 29);

        organizationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationComboBoxActionPerformed(evt);
            }
        });
        add(organizationComboBox);
        organizationComboBox.setBounds(460, 20, 200, 26);

        employeeDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));
        employeeDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee Personal Details"));

        jLabel3.setText("Name");

        jLabel5.setText("SSN");

        jLabel6.setText("Phone Number");

        jLabel7.setText("Email");

        textSSNField.setEditable(false);
        textSSNField.setEnabled(false);

        textPhoneField.setEditable(false);
        textPhoneField.setEnabled(false);

        textDOJField.setEditable(false);
        textDOJField.setEnabled(false);

        jLabel4.setText("Address");

        textAddressField.setEditable(false);
        textAddressField.setEnabled(false);

        textEmailField.setEditable(false);
        textEmailField.setEnabled(false);

        jLabel8.setText("Date of Joining");

        textNameField.setEditable(false);
        textNameField.setEnabled(false);

        chartContainer.setBackground(new java.awt.Color(255, 255, 255));

        btnLogs.setText("View Logs");
        btnLogs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogsMouseEntered(evt);
            }
        });
        btnLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout employeeDetailsPanelLayout = new javax.swing.GroupLayout(employeeDetailsPanel);
        employeeDetailsPanel.setLayout(employeeDetailsPanelLayout);
        employeeDetailsPanelLayout.setHorizontalGroup(
            employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeeDetailsPanelLayout.createSequentialGroup()
                        .addGroup(employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(94, 94, 94)
                        .addGroup(employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textSSNField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDOJField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(chartContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(employeeDetailsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225)
                        .addComponent(btnLogs)))
                .addGap(22, 22, 22))
        );
        employeeDetailsPanelLayout.setVerticalGroup(
            employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeDetailsPanelLayout.createSequentialGroup()
                .addGroup(employeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeeDetailsPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(textNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(textSSNField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(textAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(textPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(textEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(textDOJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(employeeDetailsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(chartContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogs)
                .addGap(0, 16, Short.MAX_VALUE))
            .addGroup(employeeDetailsPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(employeeDetailsPanel);
        employeeDetailsPanel.setBounds(100, 250, 830, 320);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sumeet\\Desktop\\Assignments\\AED Assignments\\Final\\9.jpg")); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 0, 1050, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void viewDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailsButtonActionPerformed
        Organization organization = (Organization) organizationComboBox.getSelectedItem();
        UserAccountDirectory userAccountDirectory = organization.getUserAccountDirectory();

        if (null == userAccountDirectory) {
            JOptionPane.showMessageDialog(this, organization.getName() + " does not have employees to view details!", "No employees found", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int selectedRowIndex = employeeTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            // no row selected
            JOptionPane.showMessageDialog(this, "Please select employee to view details.", "No employee selected!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String employeeId = getEmployeeIDFromTable(selectedRowIndex);
        UserAccount userAccount = findUserAccountByID(employeeId, userAccountDirectory);
        if (null == userAccount) {
            JOptionPane.showMessageDialog(this, "Employee details not found!", "Not found", JOptionPane.WARNING_MESSAGE);
            return;
        }
        initPage();
        viewEmployeeDetails(userAccount.getEmployee());
        btnLogs.setVisible(true);
    }//GEN-LAST:event_viewDetailsButtonActionPerformed

    private void txtSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchFieldActionPerformed
        Organization organization = (Organization) organizationComboBox.getSelectedItem();
        UserAccountDirectory userAccountDirectory = organization.getUserAccountDirectory();

        if (null == userAccountDirectory) {
            JOptionPane.showMessageDialog(this, organization.getName() + " does not have employees to view details!", "No employees found", JOptionPane.WARNING_MESSAGE);
            employeeTable.removeAll();
            return;
        }

        String input = txtSearchField.getText();
        if (null == input || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter valid characters for the search operation.", "Invalid input.", JOptionPane.WARNING_MESSAGE);
            employeeTable.removeAll();
            return;
        }

        List<UserAccount> userAccounts = filterUserAccountByName(input, userAccountDirectory);
        if (null == userAccounts || userAccounts.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No matching employee records found. Please try again!", "No records found.", JOptionPane.WARNING_MESSAGE);
            employeeTable.removeAll();
            return;
        }

        initPage();
        populateEmployeeTable(userAccounts);
    }//GEN-LAST:event_txtSearchFieldActionPerformed

    private void btnLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogsActionPerformed
        Organization organization = (Organization) organizationComboBox.getSelectedItem();
        UserAccountDirectory userAccountDirectory = organization.getUserAccountDirectory();

        if (null == userAccountDirectory) {
            JOptionPane.showMessageDialog(this, organization.getName() + " does not have employees to view details!", "No employees found", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int selectedRowIndex = employeeTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            // no row selected
            JOptionPane.showMessageDialog(this, "Please select employee to view details.", "No employee selected!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String employeeId = getEmployeeIDFromTable(selectedRowIndex);
        UserAccount userAccount = findUserAccountByID(employeeId, userAccountDirectory);
        if (null == userAccount) {
            JOptionPane.showMessageDialog(this, "Employee details not found!", "Not found", JOptionPane.WARNING_MESSAGE);
            return;
        }

        LoginDetails latestLoginDetails = userAccount.getLatestLoginDetails();
        if (null == latestLoginDetails) {
            JOptionPane.showMessageDialog(this, "No logs to display charts", "Charts cannot be displayed", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ChartPanel chart = ChartFactory.createChart(userAccount);
        chart.setBackground(Color.WHITE);
        chartContainer.removeAll();
        chartContainer.add(chart, BorderLayout.CENTER);
        chart.setSize(chartContainer.getSize());
        chartContainer.setBackground(Color.WHITE);
        chartContainer.add(chart);
        chart.setVisible(true);
        chartContainer.repaint();
    }//GEN-LAST:event_btnLogsActionPerformed

    private void organizationComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationComboBoxActionPerformed

    }//GEN-LAST:event_organizationComboBoxActionPerformed

    private void btnLogsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogsMouseEntered
        // TODO add your handling code here:
        btnLogs.setToolTipText("Click to view login details in chart");
    }//GEN-LAST:event_btnLogsMouseEntered

    private void btnLoadAllEmployeesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoadAllEmployeesMouseEntered
        // TODO add your handling code here:
        btnLoadAllEmployees.setToolTipText("Click to refresh table");
    }//GEN-LAST:event_btnLoadAllEmployeesMouseEntered

    private void txtSearchFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchFieldMouseEntered
        // TODO add your handling code here:
        txtSearchField.setToolTipText("Type name and hit enter to search");
    }//GEN-LAST:event_txtSearchFieldMouseEntered

    private void populateEmployeeTable(List<UserAccount> userAccounts) {
        DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
        employeeTable.removeAll();
        model.setRowCount(0);

        int serialNumber = 0;
        for (UserAccount userAccount : userAccounts) {
            LoginDetails latestLoginDetails = userAccount.getLatestLoginDetails();
            Employee employee = userAccount.getEmployee();
            List<Object> row = new ArrayList<>();
            row.add(++serialNumber);
            row.add(employee.getId());
            row.add(employee.getName());
            if (null != latestLoginDetails) {
                row.add(latestLoginDetails.getLoginDate() + " " + LoginDetails.getFormattedTime(latestLoginDetails.getLoginTime()));
                row.add(latestLoginDetails.getLoginDate() + " " + LoginDetails.getFormattedTime(latestLoginDetails.getLogoutTime()));
            } else {
                row.add("N/NA");
                row.add("N/A");
            }
            model.addRow(row.toArray());
        }
    }

    private String getEmployeeIDFromTable(int rowIndex) {
        final TableModel modelView = employeeTable.getModel();
        return (String) modelView.getValueAt(rowIndex, ID_COLUMN_INDEX);
    }

    private void viewEmployeeDetails(Employee employee) {
        textNameField.setText(employee.getName());
        textAddressField.setText(employee.getAddress());
        textSSNField.setText(employee.getSsn());
        textEmailField.setText(employee.getEmail());
        textPhoneField.setText(employee.getPhone());
        textDOJField.setText(employee.getDOJ());
    }

    private List<UserAccount> filterUserAccountByName(String employeeName, UserAccountDirectory userAccountDirectory) {
        List<UserAccount> userAccounts = new ArrayList<>();

        String lowerCasedName = employeeName.toLowerCase();
        for (UserAccount userAccount : userAccountDirectory.getUserAccountList()) {
            Employee employee = userAccount.getEmployee();
            if (employee.getName() == null) {
                continue;
            }
            if (employee.getName().toLowerCase().startsWith(lowerCasedName)) {
                userAccounts.add(userAccount);
            }
        }

        return userAccounts;
    }

    private UserAccount findUserAccountByID(String employeeId, UserAccountDirectory userAccountDirectory) {
        for (UserAccount userAccount : userAccountDirectory.getUserAccountList()) {
            Employee employee = userAccount.getEmployee();
            if (employee.getId() == null) {
                continue;
            }

            if (employee.getId().equals(employeeId)) {
                return userAccount;
            }
        }
        return null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadAllEmployees;
    private javax.swing.JButton btnLogs;
    private javax.swing.JPanel chartContainer;
    private javax.swing.JPanel employeeDetailsPanel;
    private javax.swing.JTable employeeTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox organizationComboBox;
    private javax.swing.JTextField textAddressField;
    private javax.swing.JTextField textDOJField;
    private javax.swing.JTextField textEmailField;
    private javax.swing.JTextField textNameField;
    private javax.swing.JTextField textPhoneField;
    private javax.swing.JTextField textSSNField;
    private javax.swing.JTextField txtSearchField;
    private javax.swing.JButton viewDetailsButton;
    // End of variables declaration//GEN-END:variables

}
