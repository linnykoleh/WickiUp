package patterns._3_behavioral._6_memento;

/**
 * @author LinnykOleh
 */
public class Demo {

	public static void main(String[] args) {
		final Caretaker caretaker = new Caretaker();

		final Employee employee = new Employee();

		employee.setName("John Wick");
		employee.setAddress("111 Main Street");
		employee.setPhone("888-4456-1122");

		System.out.println("Before save: " + employee);

		caretaker.save(employee);

		employee.setPhone("444-555-6666");

		caretaker.save(employee);

		System.out.println("After changed phone: " + employee);

		employee.setPhone("333-999-6666");

		caretaker.revert(employee);

		System.out.println("Revert to last save: " + employee);

		caretaker.revert(employee);

		System.out.println("Revert to original: " + employee);
	}
}
