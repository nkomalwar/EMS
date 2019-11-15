package com.example.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ems.model.EmployeeDetail;
import com.example.ems.service.EmployeeDetailService;

@RestController
public class EmployeeController {

   @Autowired
   private EmployeeDetailService employeeDetailService;

   /*---Add new employee---*/
   @PostMapping("/employee")
   public ResponseEntity<?> save(@RequestBody EmployeeDetail employee) {
      long id = employeeDetailService.save(employee);
      return ResponseEntity.ok().body("New EmployeeDetail has been saved with ID:" + id);
   }

   /*---Get a employee by id---*/
   @GetMapping("/employee/{id}")
   public ResponseEntity<EmployeeDetail> get(@PathVariable("id") long id) {
      EmployeeDetail employee = employeeDetailService.get(id);
      return ResponseEntity.ok().body(employee);
   }

   /*---get all employees---*/
   @GetMapping("/employee")
   public ResponseEntity<List<EmployeeDetail>> list() {
      List<EmployeeDetail> employees = employeeDetailService.list();
      return ResponseEntity.ok().body(employees);
   }

   /*---Delete a employee by id---*/
   @DeleteMapping("/employee/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      EmployeeDetail emp = employeeDetailService.delete(id);
      return ResponseEntity.ok().body("EmployeeDetail has been deleted successfully." + emp);
   }
}