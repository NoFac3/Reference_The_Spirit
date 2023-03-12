/**
 * Database.java -- class for connecting to the database
 * CSIS 505 - B01
 * @author Kore Woody
 */
package ReferenceTheSpirit;


import java.sql.Connection;     // program uses class Connection
import java.sql.DriverManager;  // program uses class DriverManager
import java.sql.SQLException;   // program uses class SQLException
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Database 
{
    /**
     * Database method for establishing the connection to the database
     * @return connection to database 
     */
    public Connection Database()
    {
        // set url for database
        final String DATABASE_URL = "jdbc:derby://localhost:1527/books;";
        // instantiate new Connection object
        Connection connection = null;
        
        // try to connect to database
        try 
        {
            connection = DriverManager.getConnection(       
               DATABASE_URL, "app", "deitel");
        }
        catch (SQLException e) // exception thrown
        {
            e.printStackTrace();
        }
        return connection;
    }// end Database method
  
} // end Database method
