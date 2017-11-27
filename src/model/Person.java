package model;

public class Person {
	
	/** Account of persons  */
	private String account;
	
	/** Firstname of persons */
	private String firstName;
	
	/** Lastname of persons */
	private String lastName;
	
	/**  Email of persons */
	private String email;

	public Person() {
		
	}
	
	
	/**
	 * @param accouont
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public Person(String accouont, String firstName, String lastName,
			String email) {
		super();
		account = accouont;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	/**
	 * @return the accouont
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param accouont the accouont to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
