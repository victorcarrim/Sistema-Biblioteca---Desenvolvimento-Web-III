package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection conn = null;

	public static Connection getConnection() {
		if(conn == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "database");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return conn;
	}
	
	public static void close() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e.getMessage());
			}
		}
	}
}
