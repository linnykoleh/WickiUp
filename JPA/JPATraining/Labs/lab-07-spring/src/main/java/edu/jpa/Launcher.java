package edu.jpa;

import edu.jpa.entity.Company;
import edu.jpa.service.CompanyService;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 01.02.15
 */
public class Launcher {
    @Autowired
    private CompanyService service;

    public static void main(String[] args) {
        PropertyConfigurator.configure(Launcher.class.getResource("/log4j.properties"));
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        context.getBean(Launcher.class).execute();
    }

    public void execute() {
        service.init();

        Company company = service.getCompany(1);
        System.out.println(
                String.format(
                        "===> {'company.id'='%1$s', 'company.name'='%2$s'}",
                        company.getId(),
                        company.getName()));
    }
}
