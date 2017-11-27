package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	public static Connection connectDb(){
		  try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=Employee;user=sa;password=123456";
			Connection con = DriverManager.getConnection(dbUrl);
			return con;
		} catch (ClassNotFoundException e) {
			System.err.println("Can't not connect to sql server");
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			System.err.println("Loi roi k chay dc dau");
			e.printStackTrace();
			return null;
		}
	  }
}
