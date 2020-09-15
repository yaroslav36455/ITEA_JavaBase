package ua.itea.lesson11;

public class Employee {
	private String name;
	private double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void getInfo() {
		System.out.println("Name: " + name
						   + "; Salary: " + getSalary());
	}
}
