package com.example.EmpManage.controller;

import com.example.EmpManage.model.Employee;
import com.example.EmpManage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ems")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	/*@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}*/

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {

		if(employeeService.addEmployee(employee)){
			return employee;
		}
		return null;
	}



	@DeleteMapping("/employees/{emailId}")
	public String deleteEmployee(@PathVariable(value="emailId") String emailId) {

		if(employeeService.deleteEmployee(emailId)){
			return "Success";
		}
		return null;
	}

@PutMapping("/employees/{id}")
	public String updateEmployee(@PathVariable(value = "id") long id,@RequestBody Employee employee){

		if(employeeService.updateEmployee(id, employee)){
			return "success";
		}
		return null;
}

@GetMapping("/employees/{id}")
public Employee getEmployee(@PathVariable(value="id") long id){

		return employeeService.getEmployee(id);
}



	/*@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}*/

	/*@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}*/
}
