/**
 * Query.java - class for executing queries on the database for verse 
 * CSIS 505 - B01
 * @author Kore Woody
 */
package ReferenceTheSpirit;

import java.sql.Connection;         // program uses class Connection
import java.sql.ResultSet;          // program uses class ResultSet
import java.sql.ResultSetMetaData;  // program uses class ResultSetMetaData
import java.sql.SQLException;       // program uses class SQL Exception
import java.sql.Statement;          // program uses class Statement
import java.util.ArrayList;         // program uses class ArrayList
import java.util.List;              // program uses class List

public class Query
{
    int numberOfColumns;
    String[][] data; 
    String[] chapterText;
    
    /**
     * setData method for executing a SELECT query on the database and setting 
     * the results and meta data from the query
     * @param query SELECT SQL string query
     */
    public void setData(String query)
    {
        // instantiate new Database object
        Database db = new Database();
        
        final String QUERY = query;// set query to final
        
        // try to connect to database and execute query
        try (
            Connection connection = db.Database();// connect to database
            Statement statement = connection.createStatement();// create statement
            // get resultSet from query
            ResultSet resultSet = statement.executeQuery(QUERY);) {
            
            // get resultSet meta data and number of columns
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            this.numberOfColumns = numberOfColumns;
            
            // instantiate new List object for row data
            List<String[]> dataList = new ArrayList<>();
            
            // get each data value within row and add to dataList
            while (resultSet.next()) 
            {
                // instantiate new String array for each row
               String[] d = new String[numberOfColumns];
               // get each value within row
               for (int i = 0; i < numberOfColumns; i++)
               {
                   d[i] = String.valueOf(resultSet.getObject(i+1));
               }
               dataList.add(d); // add row data to list
            }
            // check for empty list
            if (dataList.size()>0)
            {
                // convert data list to string array
                String[][] data = new String[dataList.size()][numberOfColumns];
                for (int i = 0; i < dataList.size(); i++)
                {
                    data[i] = dataList.get(i);
                }
                this.data = data;
            }
            else // list is empty
            {
                this.data = null;
            }
        }
        catch (SQLException e) // exception thrown
        {
            e.printStackTrace();
        }
        catch (Exception e) // exception thrown
        {}
    }// end setData mehtod   
    
    /**
     * setChapter text method for querying data base for all the verses within 
     * a given book and chapter
     * @param text      
     * @param translation   text translation
     * @param book          text book
     * @param chapter       book chapter
     */
    public void setChapterText(String text,String translation, String book, int chapter)
    {
        // instantiate new Database object
        Database db = new Database();
        // create query for chapter verses
        final String SELECT_QUERY =
            "SELECT "+translation+
                " FROM "+text+   
                " WHERE Book = '"+book+"' AND Chapter = "+chapter+" ";
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
            List<String> verses = new ArrayList();
            
            // get each data value within row and add to dataList
            while (resultSet.next()) 
            {
               // get each value within row
               for (int i = 0; i < numberOfColumns; i++)
               {
                   verses.add(String.valueOf(resultSet.getObject(i+1)));
               }
            }
            // check for empty list
            if (verses.size()>0)
            {
                // convert data list to string array
                String[] chapterText = new String[verses.size()];
                for (int i = 0; i < verses.size(); i++)
                {
                    chapterText[i] = verses.get(i);
                }
                this.chapterText = chapterText;
            }
        }
        catch (SQLException e) // exception thrown
        {
            e.printStackTrace();
        }
        catch (Exception e) // exception thrown
        {}
    }// end setChapterText method
    
    /**
     * getNumberOfColumns method for getting the number of columns from the 
     * database meta data
     * @return number of columns
     */
    public int getNumberOfColumns()
    {
        return numberOfColumns;
    }// end getNumberOfColumns method
    
    /**
     * getData method for getting the data from the result set in a table format.
     * Used for updating each row of the tables in the GUI.
     * @return data in row format
     */
    public String[][] getData()
    {
        return data;
    }// end getData method
    
    /**
     * getChapterText method for returning the chapter text
     * @return chapterText
     */
    public String[] getChapterText()
    {
        return chapterText;
    }// end getChapterText method
    
}// end Query class