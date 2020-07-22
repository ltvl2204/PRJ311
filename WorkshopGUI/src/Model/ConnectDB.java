
package Model;

import static Model.DatabaseInfor.dbURL;
import static Model.DatabaseInfor.driverName;
import static Model.DatabaseInfor.passDB;
import static Model.DatabaseInfor.userDB;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Viet Long
 */
public class ConnectDB {
    public static Connection conn = null;
    public static Connection getConnection() {
        try{
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbURL, userDB, passDB);
            
        } catch (Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
            
        }
        return  conn;
        
    }
}
