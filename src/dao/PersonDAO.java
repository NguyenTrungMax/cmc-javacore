package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import model.Person;
import connection.SqlQuery;
import connection.connection;

/**
 * @author User
 *
 */
public class PersonDAO {
	/**
	 * @Parameter: No 
	 * @Return: list of person 
	 * @modifier:
	 */
	public void getAllPersons() {
		Connection con = connection.connectDb();
		ResultSet rs = null;
		try {
			PreparedStatement ps = con.prepareStatement(SqlQuery.SELECT_All);
			// Execute query
			rs = ps.executeQuery();
			
			//Return list of person if table has value
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + 
						rs.getString(3) + "\t" + rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}
	
	public void input() {
		Scanner sc= new Scanner(System.in);
		Person person = new Person();
		
		System.out.println("Input account:");
		person.setAccount(sc.nextLine());
		
		System.out.println("Input first name:");
		person.setFirstName(sc.nextLine());
		
		System.out.println("Input last name:");
		person.setLastName(sc.nextLine());
		
		System.out.println("Input name:");
		person.setEmail(sc.nextLine());
		sc.close();
		
	}
}
