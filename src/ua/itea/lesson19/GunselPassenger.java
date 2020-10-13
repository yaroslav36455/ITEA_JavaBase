package ua.itea.lesson19;

public class GunselPassenger {
	private String firstName;
	private String lastName;
	private String birthday;
	private String docNumber;
	private String ticketNumber;
	
	
	
	public GunselPassenger(String firstName,
						   String lastName,
						   String birthday,
						   String docNumber,
						   String ticketNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.docNumber = docNumber;
		this.ticketNumber = ticketNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getDocNumber() {
		return docNumber;
	}
	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	@Override
	public String toString() {
		return "GunselPassenger [firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday
				+ ", docNumber=" + docNumber + ", ticketNumber=" + ticketNumber + "]";
	}
	
}
