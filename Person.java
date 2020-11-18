abstract class Person {
	String firstName;
	String lastName;

	public Person(String firstName, String lastName) {
		setFirstName(capitalizeFirstLetter(firstName));
		setLastName(capitalizeFirstLetter(lastName));
	}

	public String capitalizeFirstLetter(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.length() > 2) {
			this.firstName = firstName;
		}
		else {
			System.err.println("First Name : should be more than 2 symbols");
			System.exit(0);
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.length() > 3) {
			this.lastName = lastName;
		}
		else {
			System.err.println("Last Name : should be more than 3 symbols");
			System.exit(0);
		}
	}
}
