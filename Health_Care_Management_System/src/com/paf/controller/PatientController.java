package com.paf.controller;

//import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.paf.model.PatientModel;
import com.paf.util.DBConnection;
import java.util.List;

public class PatientController {

	private static Connection connection;
	private static PreparedStatement ps;
	private static ResultSet rs;
	

//******************************************DATA INSERT*************************************************************
	
	public String AddPatient(PatientModel Patient) {
		String output = "";
		try {
			connection = DBConnection.getConnection();
			 if (connection == null)
			 {return "Error while connecting to the database for inserting."; } 
			
			ps = connection.prepareStatement(
					"INSERT INTO  Patient(PID,Pname,Gender,Age,Blood_group,Pcontact) "
							+ "	VALUES (?,?,?,?,?,?)");

			ps.setInt(1, 0);
			ps.setString(2, Patient.getPname());
			ps.setString(3, Patient.getGender());
			ps.setInt(4, Patient.getAge());
			ps.setString(5, Patient.getBlood_group());
			ps.setString(6, Patient.getPcontact());
			

			ps.execute();
			 connection.close();
			 output = "Inserted successfully"; 

		}
		 catch (Exception e)
		 {
		 output = "Error while inserting the item.";
		 System.err.println(e.getMessage());
		 }
		 return output; 

		
	}


	
//******************************************Read DATA*************************************************************
	
	
	public List<PatientModel> readPatient() {
		List<PatientModel> patients = new ArrayList<>();
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				System.err.println("connecting failed.");
			}
			// Prepare the html table to be displayed
			

			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from Patient");
			

			// iterate through the rows in the result set
			while (rs.next()) {
				PatientModel ptnt = new PatientModel();
				ptnt.setPID(rs.getInt("PID"));
				ptnt.setPname(rs.getString("Pname"));
				ptnt.setGender(rs.getString("Gender"));
				ptnt.setAge(rs.getInt("Age"));
				ptnt.setBlood_group(rs.getString("Blood_group"));
				ptnt.setPcontact(rs.getString("Pcontact"));

				patients.add(ptnt);
			}
			connection.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return patients;
	}

	
	
//******************************************UPDATE DATA*************************************************************
	
	
	public String updatePatient(PatientModel Patient) {
		String output = "";
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			ps = connection.prepareStatement(
					"UPDATE Patient SET Pname=?,Gender=?,Age=?,Blood_group=?,Pcontact=? WHERE PID=?");

			// binding values
			ps.setInt(1, 0);
			ps.setString(2, Patient.getPname());
			ps.setString(3, Patient.getGender());
			ps.setInt(4, Patient.getAge());
			ps.setString(5, Patient.getBlood_group());
			ps.setString(6, Patient.getPcontact());
			
			// execute the statement
			ps.execute();
			connection.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}



//******************************************DELETE Patient*************************************************************
	
	
	public String deletePatient(String PID) {
		String output = "";
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			connection = DBConnection.getConnection();
			ps = connection.prepareStatement("delete from Patient where PID=?");
			// binding values
			ps.setInt(1, Integer.parseInt(PID));
			// execute the statement
			ps.execute();
			connection.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the item. -"+ e.getMessage();
			System.err.println(e.getMessage());
		}
		return output;
	}
}


