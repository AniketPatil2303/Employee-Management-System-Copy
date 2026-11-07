package com.aniket.employee.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
@Entity @Table(name="employees")
public class Employee {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Size(max=80) private String name;
 @NotBlank @Email @Column(unique=true) private String email;
 @NotBlank @Size(max=80) private String department;
 @NotNull @DecimalMin("0.0") private BigDecimal salary;
 public Employee() {}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getDepartment(){return department;} public void setDepartment(String v){department=v;}
 public BigDecimal getSalary(){return salary;} public void setSalary(BigDecimal v){salary=v;}
}
