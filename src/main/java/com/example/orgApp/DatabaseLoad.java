package com.example.orgApp;

import com.example.orgApp.objects.Employee;
import com.example.orgApp.repositories.EmployeeRepository;
import com.example.orgApp.objects.Employee;
import com.example.orgApp.repositories.EmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoad {


    void initDatabase(EmployeeRepository repository) {
        repository.save(new Employee("4", "Angelica", "Spencer", "System Programmer", null));
    }
}
