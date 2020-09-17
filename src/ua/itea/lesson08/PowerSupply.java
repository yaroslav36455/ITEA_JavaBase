package ua.itea.lesson08;

public class PowerSupply {
	private boolean state;
	private int inputVoltage;
	private int outputVoltageFirst;
	private int outputVoltageSecond;
	private String message = "";
	
	public void setInputVoltage(int newVoltage) {
		inputVoltage = newVoltage;
		if (inputVoltage >= 200 && inputVoltage <= 250) {
			state = true;
			outputVoltageFirst = 5;
			outputVoltageSecond = 12;
			message = "";
		} else {
			state = false;
			outputVoltageFirst  = 0;
			outputVoltageSecond = 0;
			if (inputVoltage < 200) {
				message = "Low voltage; ";	
			} else {
				message = "Hight voltage; ";
			}
		}
	}
	
	public void printInfo() {
		System.out.println(message
				+"power: " + (state ? "ON " : "OFF")
			    + "; input voltage: " + inputVoltage
			    + "; output voltage first: " + outputVoltageFirst
			    + "; output voltage second: " + outputVoltageSecond);

	}
}
