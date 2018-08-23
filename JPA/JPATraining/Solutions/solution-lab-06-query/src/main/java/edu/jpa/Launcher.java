package edu.jpa;

import edu.jpa.entity.Employee;
import edu.jpa.service.*;
import edu.jpa.service.EntityService1;
import edu.jpa.service.EntityService;
import org.apache.log4j.PropertyConfigurator;

import java.util.List;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 01.02.15
 */
public class Launcher {
    public static void main(String[] args) {
        PropertyConfigurator.configure(Launcher.class.getResource("/log4j.properties"));
        sample(new EntityService1());
        sample(new EntityService2());
    }

    private static void sample(EntityService service) {
        final List<Employee> employees = service.getEmployeesByDepartmentName("IT");
        for (Employee employee : employees) {
            System.out.println(
                    String.format(
                            "===> {'employee.name'='%1$s', 'department.name'='%2$s', 'company.name'='%3$s'}",
                            employee.getName(),
                            employee.getDepartment().getName(),
                            employee.getDepartment().getCompany().getName()));
        }

        List<DepartmentInfo> infos = service.getDepartmentsInfo();
        for (DepartmentInfo info : infos) {
            System.out.println(
                    String.format(
                            "===> 'departmentName'='%1$s', 'employeesCount'='%2$s'",
                            info.getDepartmentName(),
                            info.getEmployeesCount())
            );
        }
    }
}
