package ua.itea.lesson11;

public class Boss extends Employee {
	private double bonus;

	public Boss(String name, double salary, double bonus) {
		super(name, salary);
		this.bonus = bonus;
	}
	
	@Override
	public double getSalary() {
		return super.getSalary() + bonus;
	}
	
//	@Override
//	public void getInfo() {
//		System.out.println("Name: " + name
//						   + "; Salary: " + (salary + bonus));
//	}
}
