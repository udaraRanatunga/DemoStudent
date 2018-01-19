/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.StudentManagementApplication.Entity;

/**
 *
 * @author Udara Ranatunga
 */
public class Student {

    private int Student_Id;
    private String Student_Name, Student_Address, Grade;
    
    public int getId()
    {
        return Student_Id;
    }
    public void setId(int Student_Id)
    {
        this.Student_Id= Student_Id;
    }
    public String getName()
    {
        return Student_Name;
    }
    public void setName(String Student_Name)
    {
        this.Student_Name = Student_Name;
    }
    public String getAddress()
    {
        return Student_Address;
    }
    public void setAddress(String Student_Address)
    {
        this.Student_Address = Student_Address;
    }
    public String getGrade()
    {
        return Grade;
    }
    public void setGrade(String Grade)
    {
        this.Grade = Grade;
    }
}
