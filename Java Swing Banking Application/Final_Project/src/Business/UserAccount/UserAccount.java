/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Sumeet
 */
public class UserAccount {

    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
    private Map<String, LoginDetails> loginDetails = null;

    public UserAccount() {
        loginDetails = new TreeMap<>();
        workQueue = new WorkQueue();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    @Override
    public String toString() {
        return username;
    }

    public void addLoginDetails() {
        String date = LoginDetails.constructLoginDate(new Date());
        System.out.println(date);

        if (loginDetails.containsKey(date)) {
            return;
        }
        this.loginDetails.put(date, new LoginDetails());
    }

    public LoginDetails getLatestLoginDetails() {
        if (loginDetails.isEmpty()) {
            return null;
        }
        return loginDetails.entrySet().iterator().next().getValue();
    }

    public Map<String, LoginDetails> getLoginDetails() {
        return loginDetails;
    }

}
