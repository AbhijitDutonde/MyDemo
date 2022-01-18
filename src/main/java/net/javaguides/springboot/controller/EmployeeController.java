package net.javaguides.springboot.controller;

import lombok.Getter;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")


@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
        }

    @PostMapping
        public Employee createEmployee(@RequestBody Employee employee)
        {
            return employeeRepository.save(employee);
        }
        @GetMapping("{id}")
        public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)
        {
            Employee employee =employeeRepository.findById(id).orElseThrow(()  ->  new ResourceNotFoundException("Emplyee Not Exixt with id=" +id));
return ResponseEntity.ok(employee);
        }

        @PutMapping("{id}")
        public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails)
        {

            Employee updateemployee = employeeRepository.findById(id).orElseThrow(()  ->  new ResourceNotFoundException("Emplyee Not Exixt with id=" +id));

            updateemployee.setFirstname(employeeDetails.getFirstname());
            updateemployee.setLastname(employeeDetails.getLastname());
            updateemployee.setEmailId(employeeDetails.getEmailId());

            employeeRepository.save(updateemployee);

            return ResponseEntity.ok(updateemployee);
        }
@DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id)
    {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee is not exit with id=" +id));
        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
