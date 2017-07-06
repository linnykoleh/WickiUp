package patterns._2_structural._5_facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LinnykOleh
 */
public class JDBCFacade {

    DBSingleton instance = null;

    public JDBCFacade() {
        this.instance = DBSingleton.getInstance();
    }

    public int createTable(){
        int count = 0;
        try{
            final Connection connection = instance.getConnection();
            final Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE ADDRESS (ID VARCHAR, STREENAME VARCHAR, CITY VARCHAR )");
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    public int insertIntoTable() {
        int count = 0;
        try{
            final Connection conn = instance.getConnection();
            final Statement stat = conn.createStatement();
            stat.executeUpdate("INSERT INTO TABLE ADDRESS");

            stat.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    public List<Address> getAddresses(){
        List<Address> addresses = new ArrayList<>();
        try{
            final Connection conn = instance.getConnection();
            final Statement stat = conn.createStatement();
            final ResultSet resultSet = stat.executeQuery("SELECT * FROM Address");
            while (resultSet.next()){
                final Address address = new Address();
                address.setId(resultSet.getString(1));
                address.setStreetName(resultSet.getString(2));
                address.setCity(resultSet.getString(3));

                addresses.add(address);
            }
            stat.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return addresses;
    }
}