package com.example.orgApp.objects;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="employees")
public class Manager extends Employee {
    private List<Employee> myEmployees;
    private List<Report> reports;


    public Manager(String id, String firstName, String lastName, String position, String directManagerId) {
        super(id, firstName, lastName, position, directManagerId);
        myEmployees = new ArrayList<Employee>();
        reports = new ArrayList<Report>();
    }

    public void addReportToManager(Report report) {
        reports.add(report);
    }

    public boolean isDirectManager (Employee employee) {
        if (myEmployees.contains(employee))
            return true;
        return false;
    }


    @Override
    public String toString() {
        return "Manager{" + super.toString() +
                "myEmployees=" + myEmployees +
                ", reports=" + reports +
                "} ";
    }
}
