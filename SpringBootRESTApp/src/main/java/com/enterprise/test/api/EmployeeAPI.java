package com.enterprise.test.api;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.test.api.exceptions.DuplicateEmployeeIDException;
import com.enterprise.test.api.exceptions.EmployeeNotFoundException;
import com.enterprise.test.api.model.Employee;


@RestController
public class EmployeeAPI {
	
	private static final Map<Integer, Employee> map = new LinkedHashMap<>();
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeAPI.class);
	
	@GetMapping(path="/employee", produces="application/json",consumes="application/json")
	public ResponseEntity<List<Employee>> getEmployees(){
		
		LOGGER.info("fetching employees...");
		List<Employee> employees = new LinkedList<Employee>();
		
		for(int key : map.keySet()) {
			employees.add(map.get(key));
		}		
		ResponseEntity<List<Employee>> responseEntity = new  ResponseEntity<>(employees,HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(path="/employee/{id}", produces="application/json",consumes="application/json")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) throws Exception{

		if(!map.containsKey(id)) {
			throw new EmployeeNotFoundException("Employee with id="+id+" is not found in the system");
		}
		
		LOGGER.info("fetching employee details...");
		ResponseEntity<Employee> responseEntity = new ResponseEntity<>(map.get(id),HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping(path="/employee", produces="application/json",consumes="application/json"  )
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee) throws Exception{
		
		if(map.containsKey(employee.getId())) {
			throw new DuplicateEmployeeIDException("Employee ID Already exists in the System. Kindly input New Employee ID");					
		}

		LOGGER.info("creating employee...");
		
		map.put(employee.getId(), employee);
		ResponseEntity<?> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PostMapping(path="/employee/{id}", produces="application/json",consumes="application/json"  )
	public ResponseEntity<?> deleteEmployee(@PathVariable int id){
		
		LOGGER.info("deleting employee...");
		map.remove(id);
		ResponseEntity<?> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	@PutMapping(path="/employee/{id}", produces="application/json",consumes="application/json"  )
	public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody Employee employee) throws Exception{
		
		ResponseEntity<?> responseEntity = null;
		
		if(!map.containsKey(id)) {
			throw new EmployeeNotFoundException("Employee with id="+id+" is not found in the system hence update cannot be done");
		}

		if(employee.getId()!=0) {
			responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			LOGGER.info("updating employee...");
			responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
			map.put(id, employee);
		}
		return responseEntity;
	}
}
