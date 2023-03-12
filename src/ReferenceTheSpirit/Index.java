/**
 * Index.java - class used to set and get the list values for Sources, texts, 
 * translations, books, chapters, and verses from the database
 * CSIS 505 - B01
 * @author Kore Woody
 */
package ReferenceTheSpirit;

import java.sql.Connection;         // program uses class Connection
import java.sql.ResultSet;          // program uses class ResultSet
import java.sql.ResultSetMetaData;  // program uses class ResultSetMetaData
import java.sql.SQLException;       // program uses class SQL Exception
import java.sql.Statement;          // program uses class Statement
import java.sql.PreparedStatement;  // program uses class PreparedStatement
import java.util.ArrayList;         // program uses class ArrayList
import java.util.List;              // program uses class List

public class Index 
{
    int numberOfColumns;
    String[] list;
    String value;
    
    /**
     * setList method handles the database queries for the various book values
     * @param query SELECT query to execute
     */
    public void setList(String query)
    {
        // instantiate new Database object
        Database db = new Database();
        
        // set query to final
        final String SELECT_QUERY = query;
        
        try (
            Connection connection = db.Database();// connect to database
            Statement statement = connection.createStatement();// create statement
            // get resultSet from query
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);) {
            
            // get resultSet meta data and number of columns
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            this.numberOfColumns = numberOfColumns;
            
            // instantiate new List object for row data
            List<String> data = new ArrayList();
            
            // get each data value within row and add to dataList
            while (resultSet.next()) 
            {
               // get each value within row
               for (int i = 0; i < numberOfColumns; i++)
               {
                   //data.add(String.valueOf(resultSet.getObject(i+1)));
                   String[] results = resultSet.getObject(i+1)
                           .toString().split(":");
                   for (String result: results)
                   {
                       data.add(result);
                   }
               }
            }
            // check for empty list
            if (data.size()>0)
            {
                // convert data list to string array
                String[] list = new String[data.size()];
                for (int i = 0; i < data.size(); i++)
                {
                    list[i] = data.get(i);
                }
                this.list = list;
            }
        }
        catch (SQLException e) // exception thrown
        {
            e.printStackTrace();
        }
        catch (Exception e) // exception thrown
        {}
    }// end setList method
    
    /**
     * setThemeList method for handing the theme database search
     * @param query 
     */
    public void setThemeList(String query)
    {        
        // instantiate new Database object
        Database db = new Database();
        // set query to final
        final String SELECT_QUERY = query;
        
        try (
            Connection connection = db.Database();// connect to database
            Statement statement = connection.createStatement();// create statement
            // get resultSet from query
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);) {
            
            // get resultSet meta data and number of columns
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            this.numberOfColumns = numberOfColumns;
            
            // instantiate new List object for row data
            List<String> data = new ArrayList();
            
            // get each data value within row and add to dataList
            while (resultSet.next()) 
            {
                String[] results = resultSet.getObject(1)
                           .toString().split(":");
               for (String result: results)
               {
                   data.add(result);
               }
            }
            // check for empty list
            if (data.size()>0)
            {
                // convert data list to string array
                String[] list = new String[data.size()];
                for (int i = 0; i < data.size(); i++)
                {
                    list[i] = data.get(i);
                }
                this.list = list;
            }
        }
        catch (SQLException e) // exception thrown
        {
            e.printStackTrace();
        }
        catch (Exception e) // exception thrown
        {}
    }
    
    /**
     * getList method returns the list from the query
     * @return list
     */
    public String[] getList()
    {
        return list;
    }//end getList method
    
    /**
     * setValue method for querying the database for a single value 
     * @param query SELECT query to be executed
     */
    public void setValue(String query)
    {
        // instantiate new Database object
        Database db = new Database();
        // set query to final
        final String SELECT_QUERY = query;
        
        try (
            Connection connection = db.Database();// connect to database
            Statement statement = connection.createStatement();// create statement
            // get resultSet from query
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);) {
            
            // get resultSet meta data and number of columns
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            this.numberOfColumns = numberOfColumns;
            
            // instantiate new List object for row data
            List<String> data = new ArrayList();
            
            String results = "";
            // get each data value within row and add to dataList
            while (resultSet.next()) 
            {
               // get the result
               for (int i = 0; i < numberOfColumns; i++)
               {
                   results = resultSet.getObject(i+1).toString();
               }
            }
            this.value = results;
        }
        catch (SQLException e) // exception thrown
        {
            e.printStackTrace();
        }
        catch (Exception e) // exception thrown
        {}
    }// end setValue method
    
    /**
     * getValueMethod returns a single value from the query
     * @return value
     */
     public String getValue()
     {
         return value;
     }// end getValue method
     
     /**
     * getNumberOfColumns method for getting the number of columns from the 
     * database meta data
     * @return number of columns
     */
    public int getNumberOfColumns()
    {
        return numberOfColumns;
    }// end getNumberOfColumns method
}
