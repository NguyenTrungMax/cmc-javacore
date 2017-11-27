package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import connection.SqlQuery;
import connection.connection;
import dao.PersonDAO;
import model.Person;

public class PersonBus {
	
	
	// return all person
	public void getAllPersons() throws SQLException, ClassNotFoundException {
		PersonDAO personDao = new PersonDAO();
		personDao.getAllPersons();
	}
	
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @Parameter: No
	 * @Return: 
	 * @description: Input information of person
	 * @modifier:
	 */
	public void input() throws SQLException, ClassNotFoundException {
		Scanner sc= new Scanner(System.in);
		Person person = new Person();
		
		// check input data validate
		while (true) {
			System.out.println("Input account:");
			String account = sc.nextLine();
			if (isValidate(account)) {
				person.setAccount(account);
				break;
			}
		}
		
		// check input data validate
		while (true) {
			System.out.println("Input first name:");
			String firstName = sc.nextLine();
			if (isValidate(firstName)) {
				person.setFirstName(firstName);
				break;
			}
		}
		
		// check input data validate
		while (true) {
			System.out.println("Input last name:");
			String lastName = sc.nextLine();
			if (isValidate(lastName)) {
				person.setLastName(lastName);
				break;
			}
		}
		
		// check email validate
		while (true) {
			System.out.println("Input email:");
			String email = sc.nextLine();
			if (isValidateEmail(email)) {
				person.setEmail(email);
				break;
			} else {
				System.err.println("Email Error. Please input again");
			}
		}
		sc.close();
		
		//create pDao from PsersonDAO to insert or update data
		PersonDAO pDao = new PersonDAO();
		if (isExist(person)) {
			pDao.updatePerson(person);
			System.out.println("_____________________________________________");
			pDao.getAllPersons();
		} else {
			pDao.insertPerson(person);
			System.out.println("_____________________________________________");
			pDao.getAllPersons();
		}
	}
	
	/**
	 * @Parameter: person
	 * @Return: boolean. check person exits to update or insert
	 * @modifier:
	 */
	public boolean isExist(Person person) throws ClassNotFoundException{
		Connection con = connection.connectDb();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(SqlQuery.SELECT_BY_ACCOUNT);
			ps.setString(1, person.getAccount());
			rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * @Parameter: str
	 * @Return: boolean. check validate email
	 * @modifier:
	 */
	public boolean isValidateEmail(String str) {
		String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	/**
	 * @Parameter: str
	 * @Return: boolean. check validate
	 * @modifier:
	 */
	public boolean isValidate(String str) {
		if (str.length() > 0 && str != null) return true; else {
			System.err.println("Please input again. Can't not empty!");
			return false;
		}
			
	}
}
