package view;

import business.PersonBus;

public class Main {
	public static void main(String[] args) {
		PersonBus personBus = new PersonBus();
		
		// List of person
		System.out.println("List of person:");
		personBus.getAllPersons();
		System.out.println("_________________________________________________________");
		personBus.input();
	}
}
