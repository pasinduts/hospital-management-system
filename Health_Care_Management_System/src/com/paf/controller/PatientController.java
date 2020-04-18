package com.paf.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.paf.util.DBConnection;

public class PatientController {

	private static Connection connection;
	private static PreparedStatement ps;
	private static ResultSet rs;

//******************************************DATA INSERT*************************************************************
	
	public String insertItem(String id, String name, String gender, String bg, String contact) {
		String output = "";
		try {
			connection = DBConnection.getConnection();

			if (connection == null)

			{
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into Patient('PID','Pname','Gender','Age','Blood_group','Pcontact')"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, id);
			preparedStmt.setString(2, name);
			preparedStmt.setString(3, gender);
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(5, bg);
			preparedStmt.setString(5, contact);

			// execute the statement
			preparedStmt.execute();
			connection.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}


	
//******************************************Read DATA*************************************************************
	
	
	public String readItems()
	 {
	 String output = "";
	 try
	 {
		 connection = DBConnection.getConnection();
	 
	 if (connection == null)
	 	{return "Error while connecting to the database for reading."; }
	 // Prepare the html table to be displayed
	 
	 output = "<table border=\"1\"><tr><th>Patient ID</th><th>Name</th><th>Gender</th><th>Age</th><th>Blood Group</th><th>Contact Number</th><th>Update</th><th>Remove</th></tr>";
	 String query = "select * from Patient";
	 Statement stmt = connection.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
	 String patientID = rs.getString("PID");
	 String patientname = rs.getString("Pname");
	 String patientgender = rs.getString("Gender");
	 String patientage = Integer.toString(rs.getInt("Age"));
	 String patientbg = rs.getString("Blood_group");
	 String patientcontact = rs.getString("Pcontact");
	 
	 // Add into the html table
	 output += "<tr><td>" + patientID + "</td>";
	 output += "<td>" + patientname + "</td>";
	 output += "<td>" + patientgender + "</td>";
	 output += "<td>" + patientage + "</td>";
	 output += "<td>" + patientbg + "</td>";
	 output += "<td>" + patientcontact + "</td>";
	 
	 // buttons
	 output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>" + "<td><form method=\"post\" action=\"items.jsp\">" + "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
	 + "<input name=\"PID\" type=\"hidden\" value=\"" + patientID + "\">" + "</form></td></tr>";
	 }
	 connection.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the Patient.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }

	
	
//******************************************UPDATE DATA*************************************************************
	
	
	public String updateItem(String id, String name, String gender, String bg, String contact)
	 {
	 String output = "";
	 try
	 {
		 connection = DBConnection.getConnection();
	 if (connection == null)
	 {return "Error while connecting to the database for updating."; }
	 // create a prepared statement
	 String query = "UPDATE Patient SET patientID=?,patientname=?,patientgender=?,patientage=?,patientbg=?,patientcontact=?	 WHERE itemID=?";
	 PreparedStatement preparedStmt = connection.prepareStatement(query);
	 // binding values
		preparedStmt.setString(1, id);
		preparedStmt.setString(2, name);
		preparedStmt.setString(3, gender);
		preparedStmt.setInt(1, 0);
		preparedStmt.setString(5, bg);
		preparedStmt.setString(5, contact);
	 // execute the statement
	 preparedStmt.execute();
	 connection.close();
	 output = "Updated successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while updating the Patient.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }

	public String deleteItem(String PID) {
		String output = "";
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from items where itemID=?";
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(PID));
			// execute the statement
			preparedStmt.execute();
			connection.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}


