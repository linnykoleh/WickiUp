package patterns._2_structural._1_adapter;

/**
 * @author LinnykOleh
 */
public class EmployeeAdapterLdap implements Employee{

	private final EmployeeLdap employeeLdap;

	public EmployeeAdapterLdap(EmployeeLdap employeeLdap) {
		this.employeeLdap = employeeLdap;
	}

	@Override
	public String getId() {
		return employeeLdap.getCn();
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
		return employeeLdap.getMail();
	}

	@Override
	public String toString() {
		return "EmployeeAdapterLdap{" +
				"employeeLdap=" + employeeLdap +
				'}';
	}
}
