package patterns._2_structural._4_facade;

import java.util.List;

/**
 * @author LinnykOleh
 */
public class Demo {

    public static void main(String[] args) {
        final JDBCFacade jdbcFacade = new JDBCFacade();

        jdbcFacade.createTable();
        System.out.println("Table created");

        jdbcFacade.insertIntoTable();
        System.out.println("Record inserted");

        final List<Address> addresses = jdbcFacade.getAddresses();
        for(Address address : addresses){
            System.out.println(address);
        }
    }
}
