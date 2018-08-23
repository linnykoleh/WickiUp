package edu.jpa;

import edu.jpa.entity.Company;
import edu.jpa.service.CompanyService;
import org.apache.log4j.PropertyConfigurator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 01.02.15
 */
public class Launcher {
    public static void main(String[] args) {
        PropertyConfigurator.configure(Launcher.class.getResource("/log4j.properties"));

        CompanyService service = new CompanyService();
        Company company = service.getCompany(1);

        company.setName("Internation Business Machines (IBM)");
        service.saveCompany(company);
    }
}
