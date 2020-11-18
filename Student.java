public class Student extends Person {

	String facultyNumber;

	public Student(String firstName, String lastName, String facultyNumber) {
		super(firstName, lastName);
		setFacultyNumber(facultyNumber);
	}

	public String getFacultyNumber() {
		return facultyNumber;
	}

	public void setFacultyNumber(String facultyNumber) {
		if (!isLetterOrDigit(facultyNumber)) {
			System.err.println("Faculty number needs to have numbers and letters only.");
			System.exit(0);
		}

		if (isValidFacultyNumber(facultyNumber)) {
			this.facultyNumber = facultyNumber;
		} else {
			System.err.println("Faculty number must be in range of 5 - 10 symbols");
			System.exit(0);
		}
	}

	public boolean isValidFacultyNumber(String string) {
		return string.length() >= 5 && string.length() <= 10;

	}

	public boolean isLetterOrDigit(String string) {
		char[] charArray = string.toCharArray();
		for (char c : charArray) {
			if (!Character.isLetterOrDigit(c)) {
				return false;
			}

		}
		return true;
	}

	public String toString() {
		return "Name: " + firstName + " " + lastName + "\n" + "FacultyNumber: " + facultyNumber;

	}
}