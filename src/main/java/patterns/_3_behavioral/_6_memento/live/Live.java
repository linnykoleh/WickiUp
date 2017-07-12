package patterns._3_behavioral._6_memento.live;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author LinnykOleh
 */
public class Live {

	public static void main(String[] args) {
		final Employee employee = new Employee();
		employee.setName("Bryan");
		employee.setAddress("111 E Code Street");
		employee.setPhone("888-512-1212");
		System.out.println("Hashcode before: " + employee.hashCode());

		serialize(employee);

		final Employee newEmployee = deserialize();
		System.out.println(newEmployee);
		System.out.println("Hashcode after: " + newEmployee.hashCode());

	}

	private static Employee deserialize(){
		Employee emp = null;
		try{
			final FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
			final ObjectInputStream out = new ObjectInputStream(fileIn);
			emp =(Employee)out.readObject();
			out.close();
			fileIn.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		return emp;
	}

	private static void serialize(Employee employee){
		try{
			final FileOutputStream fileOut = new FileOutputStream("/tmp/employee.ser");
			final ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(employee);
			out.close();
			fileOut.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

class Employee implements Serializable{

	private String name;
	private String address;
	private String phone;

	String getName() {
		return name;
	}

	String getAddress() {
		return address;
	}

	String getPhone() {
		return phone;
	}

	void setName(String name) {
		this.name = name;
	}

	void setAddress(String address) {
		this.address = address;
	}

	void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				'}';
	}
}
