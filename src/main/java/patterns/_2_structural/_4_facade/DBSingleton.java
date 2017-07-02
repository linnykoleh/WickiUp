package patterns._2_structural._4_facade;

import java.sql.Connection;

/**
 * @author LinnykOleh
 */
public class DBSingleton {

    private static DBSingleton dbInstance;

    private DBSingleton() {
    }

    public static DBSingleton getInstance(){
        if(dbInstance == null){
            dbInstance = new DBSingleton();
        }
        return dbInstance;
    }

    public Connection getConnection(){
        return null;
    }
}
