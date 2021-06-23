package com.nagarro.controller;
/*
 * @Author Bhumika_Arora   
 */
import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.exception.RecordNotFound;
import com.nagarro.model.Employee;
import com.nagarro.repository.EmpRepository;

@RestController
@RequestMapping("/api/Employees")
public class EmpController {
	
		public static final String EMPLOYEE_NOT_FOUND_WITH_ID = "Employee not found with id :";
	
		@Autowired 
		EmpRepository empRepo;
		
		@GetMapping
	 	public List <Employee> getAllEmployees() {
	        return this.empRepo.findAll();
	    }
	 
	 	 @GetMapping("/{id}")
	     public Employee getEmployeeById(@PathVariable(value = "id") final long id) {
	         return  this.empRepo.findById(id).orElseThrow(()->new RecordNotFound(EMPLOYEE_NOT_FOUND_WITH_ID + id));
	     }
	 	 
	 	 @PostMapping
	     public Employee createEmp(@RequestBody final Employee emp) {
	         return this.empRepo.save(emp);
	     }
	 	
	 	@PutMapping("/{id}")
	    public Employee updateEmp(@RequestBody final Employee emp, @PathVariable("id") final long id) {
	 		final Employee existEmp = this.empRepo.findById(id).orElseThrow(()-> new RecordNotFound(EMPLOYEE_NOT_FOUND_WITH_ID + id));
	 		
	        existEmp.setEmpCode(emp.getEmpCode());
	        existEmp.setEmpName(emp.getEmpName());
	        existEmp.setEmpLoc(emp.getEmpLoc());
	        existEmp.setEmpMail(emp.getEmpMail());
	        existEmp.setEmpDOB(emp.getEmpDOB());
	        
	        return this.empRepo.save(existEmp);
	    }
	 	
	    @DeleteMapping("/{id}")
	    public ResponseEntity <Employee> deleteEmp(@PathVariable("id") final long id) {
	    	final Employee existingEmp = this.empRepo.findById(id).orElseThrow(()-> new RecordNotFound(EMPLOYEE_NOT_FOUND_WITH_ID + id));
	        this.empRepo.delete(existingEmp);
	        return ResponseEntity.ok().build();
	    }

}
