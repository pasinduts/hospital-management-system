package Hospital_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class hospitalDetails {

	public Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/healthcare", "root", "root");

			System.out.println("Successfully connected");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertHospital(String company, String contact, String email, String address, String service,
			String uName, String password) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database";
			}
			// create a prepared statement
			String query = " insert into hospitalregister(`Hid`,`companyName`,`contact`,`email`,`address`,`services`,`userName`,`password`)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, company);
			preparedStmt.setInt(3, Integer.parseInt(contact));
			preparedStmt.setString(4, email);
			preparedStmt.setString(5, address);
			preparedStmt.setString(6, service);
			preparedStmt.setString(7, uName);
			preparedStmt.setString(8, password);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readHospital() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Company Name</th>" + "<th>contact</th><th>email</th>"
					+ "<th>Company Address</th><th>Services</th><th>User Name</th><th>Password</th>" + "<th>Update</th><th>Remove</th></tr>";
			String query = "select * from hospitalregister";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String Hid = Integer.toString(rs.getInt("Hid"));
				String companyName = rs.getString("companyName");
				String contact = Integer.toString(rs.getInt("contact"));
				String email = rs.getString("email");
				String address = rs.getString("address");
				String services = rs.getString("services");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				// Add into the html table

				output += "<tr><td>" + companyName + "</td>";
				output += "<td>" + contact + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + services + "</td>";
				output += "<td>" + userName + "</td>";
				output += "<td>" + password + "</td>";
				// buttons
				output += "<td><input name=\"btnUpdate\" " + " type=\"button\" value=\"Update\"></td>"
						+ "<td><form method=\"post\" action=\"HotelRegisteration.jsp\">" + "<input name=\"btnRemove\" "
						+ " type=\"submit\" value=\"Remove\">" + "<input name=\"itemID\" type=\"hidden\" " + " value=\""
						+ Hid + "\">" + "</form></td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the details.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateHospital(String hid, String company, String contact, String email, String address, String service,
			String uName, String password) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE hospitalregister SET companyName=?,contact=?,email=?,address=?,services=?,userName=?,password=? WHERE Hid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, company);
			preparedStmt.setInt(2, Integer.parseInt(contact));
			preparedStmt.setString(3, email);
			preparedStmt.setString(4, address);
			preparedStmt.setString(5, service);
			preparedStmt.setString(6, uName);
			preparedStmt.setString(7, password);
			preparedStmt.setInt(8, Integer.parseInt(hid));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the details.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteHospital(String Hid) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from hospitalregister where Hid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(Hid));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the details.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	
}
