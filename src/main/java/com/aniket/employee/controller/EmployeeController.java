package com.aniket.employee.controller;
import com.aniket.employee.entity.Employee;
import com.aniket.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/employees") @CrossOrigin
public class EmployeeController {
 private final EmployeeService service;
 public EmployeeController(EmployeeService service){this.service=service;}
 @GetMapping public List<Employee> all(){return service.findAll();}
 @GetMapping("/{id}") public Employee one(@PathVariable Long id){return service.findById(id);}
 @PostMapping public ResponseEntity<Employee> create(@Valid @RequestBody Employee e){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(e));}
 @PutMapping("/{id}") public Employee update(@PathVariable Long id,@Valid @RequestBody Employee e){return service.update(id,e);}
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){service.delete(id);return ResponseEntity.noContent().build();}
}
