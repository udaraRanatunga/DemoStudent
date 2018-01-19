/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.StudentManagementApplication.Database;
import com.StudentManagementApplication.View.UpdateStudent;
import com.StudentManagementApplication.Entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Udara Ranatunga
 */
public class DatabaseStudent {
private Connection con;
private PreparedStatement pst;
private Statement st;
private ResultSet rs; 

public void getConnection()
{
    DatabaseConnection connect = new DatabaseConnection();
    con = connect.connection();
}
public int insert(Student student)
{
int result=0;
this.getConnection();
String query="insert into Student(Student_Name,Student_Address,Grade)values(?,?,?)";
        try {
                pst=con.prepareStatement(query);
                pst.setString(1,student.getName());
		pst.setString(2,student.getAddress());
                pst.setString(3,student.getGrade());
                result =pst.executeUpdate();				
		con.close();
	    }
catch(SQLException e){
		System.out.println("My SQL Error in insert method"+"\n"+e.getMessage());
	    }
return result;
}
public int update(Student student, int studentid)
{
int result=0; 
this.getConnection();
try{
                st=con.createStatement();
		result =st.executeUpdate(" update Student set Student_Name ='"+student.getName()+"', Student_Address='"+student.getAddress()+"', Grade='"+student.getGrade()+"' where Student_Id ='"+studentid+"'");
		
                con.close();
}
catch(SQLException e){

    System.out.println("SQL Error in update method"+"\n"+e.getMessage());
}
catch(Exception er){
    System.out.println("Error in update method"+"\n" +er.getMessage());
}

        return result;
}
public int delete(int studentid)
{
int rs=0;
this.getConnection();
	try{
		st=con.createStatement();
		rs= st.executeUpdate("delete from Student where Student_Id='"+studentid+"'");		
		con.close();
	    }
catch(SQLException e){
		System.out.println("SQL Error in delete method"+"\n"+e.getMessage());
	    }
return rs;
}
public Student search(int studentid)
{
    this.getConnection();
    Student student=new Student();
	try{
		st=con.createStatement();
		rs=st.executeQuery("select * from Student where Student_Id='"+studentid+"'");
                
			while(rs.next()){
			student.setId(rs.getInt(1));
			student.setName(rs.getString(2));
			student.setAddress(rs.getString(3));
                        student.setGrade(rs.getString(4));
                        }
               
		con.close();
            }
catch(SQLException e){
		System.out.println("SQL Error in search method"+"\n"+e.getMessage());
	    }
	return student;	
}
public ResultSet select()
{
    this.getConnection();
    Student student = new Student();
    try{
        st= con.createStatement();
        rs=st.executeQuery("select Student_Id from Student");
        
    }
    catch(SQLException e){
		System.out.println("SQL Error in search method"+"\n"+e.getMessage());

    }
    return rs;
}
}
