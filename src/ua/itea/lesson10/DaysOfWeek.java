package ua.itea.lesson10;

public enum DaysOfWeek {	
	MONDAY(1, "monday"),
	TUESDAY(2, "tuesday"),
	WEDNESDAY(3, "wednesday"),
	THURSDAY(4, "thursday");
	
	private int field1;
	private String field2;
	
	private DaysOfWeek(int field1, String field2) {
		this.field1 = field1;
		this.field2 = field2;
	}
	
	public int getField1() {
		return field1;
	}
	
	public String getField2() {
		return field2;
	}
}
