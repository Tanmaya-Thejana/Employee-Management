package com.example.EmpManage.dao;
import com.example.EmpManage.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDaoMsAccess {
    List<Employee> employees = new ArrayList();
    public boolean addEmployee(Employee emp){
        return employees.add(emp);
    }

    public List<Employee> getAllEmployees(){
        return employees;
    }



    public boolean deleteEmployee(String  emailId){
        for(Employee e : employees){
            if(e.getEmailId().equals(emailId)){
                employees.remove(e);
                return true;
            }
        }
        return false;
    }

    public boolean updateEmployee(long id, Employee employee){
        for(Employee e:employees){
            if(e.getId()==(id)){
                e.setEmailId(employee.getEmailId());
                e.setLastName(employee.getLastName());
                e.setFirstName(employee.getFirstName());
return true;
            }

        }
        return false;
    }

    public Employee getEmployee(long id){
        for(Employee e:employees){
            if(e.getId()==id){
                return e;
            }
        }
        return null;
    }

}
