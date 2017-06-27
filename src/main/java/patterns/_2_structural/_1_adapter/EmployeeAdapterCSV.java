package patterns._2_structural._1_adapter;

/**
 * @author LinnykOleh
 */
public class EmployeeAdapterCSV implements Employee{

	private final EmployeeCVS employeeLdap;

	public EmployeeAdapterCSV(EmployeeCVS employeeLdap) {
		this.employeeLdap = employeeLdap;
	}

	@Override
	public String getId() {
		return employeeLdap.getId() + "";
	}

	@Override
	public String getFirstName() {
		return employeeLdap.getGivenName();
	}

	@Override
	public String getLastName() {
		return employeeLdap.getSurName();
	}

	@Override
	public String getEmail() {
		return employeeLdap.getEmailAddress();
	}

	@Override
	public String toString() {
		return "EmployeeAdapterCSV{" +
				"employeeLdap=" + employeeLdap +
				'}';
	}
}
