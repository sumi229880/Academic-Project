package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Sumeet
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        //Initialization to the eccosystem model to add some netowrk and enterprice and subsets of the same.
        Employee employee = new Employee();
        employee.setName("Sumeet");
        employee.setPhone("9987567890");
        employee.setAddress("Parker Street");
        employee.setDOJ("09/01/2013");
        employee.setEmail("sumeet@gmail.com");
        employee.setSsn("1876384765");
        system.getEmployeeDirectory().addEmployee(employee);
        system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        return system;
    }
    
}
