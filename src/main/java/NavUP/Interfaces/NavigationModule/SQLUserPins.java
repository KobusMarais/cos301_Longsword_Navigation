/**
 * @author Duart Breedt
 * @version 1
 *
 */

package NavUP.Interfaces.NavigationModule;

import org.json.JSONObject;

import java.sql.*;

/**
 * Class to manage user pins in the SQL database
 */
public class SQLUserPins {

    /**
     * Variables to connect to the DB
     */
    private final static String DB_URL = "jdbc:mysql://localhost/";
    private final static String USERNAME = "admin";
    private final static String PASSWORD = "root";
    private final static String myDriver = "org.gjt.mm.mysql.Driver";
    private Connection connection;

    /**
     * The SQLUserPins constructor which connects to the SQL database
     */
    public SQLUserPins() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Class.forName(myDriver);
            System.out.println("Connected to Database");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Adds a pin to the SQL users pin table
     * @param pin The JSON string specifying the pin and user information
     */
    public void dropPin(String pin) {
        try {

            JSONObject json = new JSONObject(pin);

            String userIdVar = json.getString("userID");
            Double latVar = json.getDouble("lat");
            Double lonVar = json.getDouble("long");
            String pinNameVar = json.getString("customName");

            String query = "INSERT INTO `userpins`(userID, lat, lon, customName) VALUE (?, ?, ?, ?)";
            PreparedStatement insert = connection.prepareStatement(query);
            insert.setString(1, userIdVar);
            insert.setDouble(2, latVar);
            insert.setDouble(3, lonVar);
            insert.setString(4, pinNameVar);
            insert.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
