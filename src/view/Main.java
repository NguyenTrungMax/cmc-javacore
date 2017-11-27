package view;

import dao.PersonDAO;

public class Main {
	public static void main(String[] args) {
		PersonDAO person = new PersonDAO();
		
		// List of person
		System.out.println("List of person:");
		person.getAllPersons();
		person.input();
	}
}
