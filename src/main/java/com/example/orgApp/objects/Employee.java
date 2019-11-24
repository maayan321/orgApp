package com.example.orgApp.objects;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection="employees")
public class Employee {

    @Id
    @NotBlank
    private String id;
    private String firstName;
    private String lastName;
    private String position;
    private String directManagerId;
    private List<Task> taskList;

    public Employee(String id, String firstName, String lastName,String position, String directManagerId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.directManagerId = directManagerId;
        this.taskList = new ArrayList<Task>();;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getDirectManager() {
        return directManagerId;
    }

    // Assign task to employee, add to his task list.
    public void assignTaskToEmployee(Task task) {
        this.taskList.add(task);
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", directManager=" + directManagerId +
                ", taskList=" + taskList +
                '}';
    }
}
