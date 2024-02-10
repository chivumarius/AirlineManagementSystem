package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    Connection c;
    Statement s;

    public DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///airline_management_system","root","");
            s = c.createStatement();

        } catch(SQLException e){
            // Handle SQLException separately
            System.out.println("SQL Exception: " + e.getMessage());
        } catch(ClassNotFoundException e){
            // Handle ClassNotFoundException separately
            System.out.println("Class Not Found Exception: " + e.getMessage());
        } catch(Exception e){
            // Handle other exceptions separately
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}