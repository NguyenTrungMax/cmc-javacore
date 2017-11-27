package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Person;
import connection.SqlQuery;
import connection.connection;

/**
 * @author User
 *
 */
public class PersonDAO {
	/**
	 * @throws SQLException 
	 * @Parameter: No 
	 * @Return: list of person 
	 * @modifier:
	 */
	public void getAllPersons() throws SQLException, ClassNotFoundException {
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
		finally {
			con.close();
		}
	}
	
	/**
	 * @throws SQLException 
	 * @Parameter: person
	 * @Return: 
	 * @description: update data of person
	 * @modifier:
	 */
	public void updatePerson(Person person) throws SQLException {
		Connection con = connection.connectDb();
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(SqlQuery.UPDATE);
			ps.setString(1, person.getFirstName());
			ps.setString(2, person.getLastName());
			ps.setString(3, person.getEmail());
			ps.setString(4, person.getAccount());
			
			int i = ps.executeUpdate();
			if (i > 0) System.out.println("Update succesfully"); else
				System.err.println("Update failed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
	}
	/**
	 * @throws SQLException 
	 * @Parameter: person
	 * @Return: 
	 * @description: insert data person
	 * @modifier:
	 */
	public void insertPerson(Person person) throws SQLException {
		Connection con = connection.connectDb();
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(SqlQuery.INSERT);
			
			ps.setString(1, person.getAccount());
			ps.setString(2, person.getFirstName());
			ps.setString(3, person.getLastName());
			ps.setString(4, person.getEmail());
			
			int i = ps.executeUpdate();
			if (i > 0) System.out.println("Insert succesfully"); else
				System.err.println("Insert failed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
	}
}
