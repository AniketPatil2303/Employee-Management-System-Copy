package com.aniket.employee.service;
import com.aniket.employee.entity.Employee;
import com.aniket.employee.exception.ResourceNotFoundException;
import com.aniket.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service @Transactional
public class EmployeeService {
 private final EmployeeRepository repo;
 public EmployeeService(EmployeeRepository repo){this.repo=repo;}
 public List<Employee> findAll(){return repo.findAll();}
 public Employee findById(Long id){return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found: "+id));}
 public Employee create(Employee e){
  if(repo.existsByEmail(e.getEmail()))throw new IllegalArgumentException("Email already exists");
  e.setId(null); return repo.save(e);
 }
 public Employee update(Long id,Employee input){
  Employee e=findById(id);
  repo.findByEmail(input.getEmail()).ifPresent(existing->{if(!existing.getId().equals(id))throw new IllegalArgumentException("Email already exists");});
  e.setName(input.getName());e.setEmail(input.getEmail());e.setDepartment(input.getDepartment());e.setSalary(input.getSalary());
  return repo.save(e);
 }
 public void delete(Long id){repo.delete(findById(id));}
}
