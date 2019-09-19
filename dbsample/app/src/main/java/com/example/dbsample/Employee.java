package com.example.dbsample;

public class Employee {
    int id;
    String name, dept;
    double salary;

    public Employee( String name, String dept, double salary) {
    //    this.id = id;
        this.name = name;
        this.dept = dept;
        //this.joiningDate = joiningDate;
        this.salary = salary;
    }


   // public int getId() {
     //   return id; }


    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }


    public double getSalary() {
        return salary;
    }



}