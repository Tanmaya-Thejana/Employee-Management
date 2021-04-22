package com.example.EmpManage.service;

import com.example.EmpManage.dao.EmployeeDaoMsAccess;
import com.example.EmpManage.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {
    @Autowired
    EmployeeDaoMsAccess dao;

    public boolean addEmployee(Employee emp){
        return dao.addEmployee(emp);
    }

    public List<Employee> getAllEmployees(){
        return dao.getAllEmployees();
    }

public boolean deleteEmployee(String emailId){
       return  dao.deleteEmployee(emailId);
}

public boolean updateEmployee(long id, Employee employee){
        return dao.updateEmployee(id,employee);
}
public Employee getEmployee(long id)
{
    return dao.getEmployee(id);
}


}


