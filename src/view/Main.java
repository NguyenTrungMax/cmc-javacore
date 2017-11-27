package view;

import java.sql.SQLException;

import business.PersonBus;

public class Main {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		PersonBus personBus = new PersonBus();
		
		// List of person
		System.out.println("List of person:");
		personBus.getAllPersons();
		System.out.println("_________________________________________________________");
		personBus.input();
	}
}
