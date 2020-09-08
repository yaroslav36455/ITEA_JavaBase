package ua.itea.lesson8.tasks;

public class Angle {
	private double angle;
	
	public void setRadians(double angle) {
		this.angle = angle;
	}
	
	public void setDegree(double angle) {
		this.angle = angle * Math.PI / 180;
	}
	
	public double getRadians() {
		return angle;
	}
	
	public double getDegree() {
		return angle * 180 / Math.PI;
	}
}
