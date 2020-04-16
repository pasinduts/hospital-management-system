package connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection getConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost/healthcare";
		//?verifyServerCertificate=false&useSSL=true
		String email = "root";
		String password = "root";

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, email, password);
				
				if (con != null)
					System.out.println("connection sucess");
								

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
