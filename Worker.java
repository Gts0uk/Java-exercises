import java.text.DecimalFormat;

public class Worker extends Person {

	double weeklySalary;
	int calculateWorkingHours;
	double salaryPerHour;
	int dailyHours;
	static int counter = 0;
	private DecimalFormat df = new DecimalFormat(".##");

	public Worker(String firstName, String lastName, double weeklySalary, int dailyHours, double salaryPerHour) {
		super(firstName, lastName);
		this.dailyHours = dailyHours;
		setWeeklySalary(weeklySalary);
		setSalaryPerHour(salaryPerHour);
		counter++;
	}

	public static int getCounter() {
		return counter;
	}

	
	public double weeklySalary() {
		return calculateWorkingHours * salaryPerHour;
	}

	public void setWeeklySalary(double weeklySalary) {
		if (weeklySalary > 10) {
			this.weeklySalary = weeklySalary;
		}
		else {
			System.err.println("Should be more than 10");
			System.exit(0);
		}
	}

	public int workingHours() {
		return calculateWorkingHours * 5;
	}

	public void setWorkingHours(int workingHours) {
		if (workingHours >= 1 && workingHours <= 12) {
			this.calculateWorkingHours = workingHours;
		}
		else {
			System.err.println("Working hours should be in range 1 to 12");
			System.exit(0);
		}
	}

	public double salaryPerHour() {
		return weeklySalary / (dailyHours*5);
	}

	public void setSalaryPerHour(double salaryPerHour) {
		this.salaryPerHour = salaryPerHour;
	}

	public String toString() {
		return "Name: " + firstName + " " + lastName + "\n" + "Weekly Salary: " + df.format(weeklySalary) + "\n"
				+ "Salary Per Hour: " + df.format(salaryPerHour) + "\n" + "Hours Per Day :" + df.format(workingHours());
	}
}
