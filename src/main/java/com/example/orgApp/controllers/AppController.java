package com.example.orgApp.controllers;

import com.example.orgApp.objects.*;
import com.example.orgApp.repositories.EmployeeRepository;
import com.example.orgApp.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
/* The @CrossOrigin annotation is used to enable Cross-Origin requests.
This is required because we’ll be accessing the apis from angular’s frontend server */
@CrossOrigin("*")
public class AppController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ManagerRepository managerRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/managers")
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        return employeeRepository.findById(id)
                .map(employee -> ResponseEntity.ok().body(employee))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/managers/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable String id) {
        return managerRepository.findById(id)
                .map(manager -> ResponseEntity.ok().body(manager))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> assignTaskToEmployee(@RequestBody Task task, @PathVariable String id) {

        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.assignTaskToEmployee(task);
                    Employee updatedEmployee = employeeRepository.save(employee);
                    return ResponseEntity.ok().body(updatedEmployee);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/managers/{id}")
    public ResponseEntity<Manager> addReportToManager(@RequestBody Report report, @PathVariable String id) {

        return managerRepository.findById(id)
                .map(manager -> {
                    manager.addReportToManager(report);
                    Manager updatedManager = managerRepository.save(manager);
                    return ResponseEntity.ok().body(updatedManager);
                }).orElse(ResponseEntity.notFound().build());
    }


    /*

    // extra functions, not needed for the application
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PostMapping("/managers")
    public Manager createManager(@RequestBody Manager manager) {
        return managerRepository.save(manager);
    }


    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        list.addAll(employeeRepository.findAll());
        list.addAll(managerRepository.findAll());
        return list;
    }
*/
}

