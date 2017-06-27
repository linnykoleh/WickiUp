package patterns._2_structural._1_adapter;

/**
 * @author LinnykOleh
 */
public class EmployeeCVS {

	private int id;
	private String givenName;
	private String surName;
	private String emailAddress;

	public EmployeeCVS(int id, String givenName, String surName, String emailAddress) {
		this.id = id;
		this.givenName = givenName;
		this.surName = surName;
		this.emailAddress = emailAddress;
	}

	public int getId() {
		return id;
	}

	public String getGivenName() {
		return givenName;
	}

	public String getSurName() {
		return surName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public String toString() {
		return "EmployeeCVS{" +
				"id='" + id + '\'' +
				", givenName='" + givenName + '\'' +
				", surName='" + surName + '\'' +
				", emailAddress='" + emailAddress + '\'' +
				'}';
	}
}
