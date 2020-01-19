/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessobjects;

import databeans.EmployeeDL;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author monal
 */
@Named(value="employeeBean")
@SessionScoped
public class EmployeeBackingBean implements Serializable {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
      @Inject
    private Employee employee;
    
    EmployeeDL stDL = EmployeeDL.getInstance();

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeBackingBean(Employee employee) {
        this.employee = employee;
    }

    public EmployeeBackingBean() {
    }
    public Employee GetEmployee(int id) {
       Employee e = stDL.FetchEmployeeId(id);
       
       return e;
   }
    public String Validate(){
        
       boolean validate=stDL.FetchEmployee(employee.getUserName(),employee.getPassword());
       if(validate){
       return "AdminPage.xhtml";
       }
       else{
           return "Employee.xhtml";
       }
    }
    
    
}
