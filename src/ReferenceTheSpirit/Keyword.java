/**
 * Keyword.java - class searches database for verses containing the given
 * keyword.
 * CSIS 505 - B01
 * @author Kore Woody
 */
package ReferenceTheSpirit;

public class Keyword 
{
    String keyword;
    String text,translation;
    String[] verses;
    String[][] data; 
    
    /**
     * Keyword Default constructor
     * Null input
     */
    public Keyword()
    {}// end Keyword constructor method
    
    /**
     * Keyword constructor method for setting the keyword, text, and translation
     * then initiating the query
     * @param keyword   word being searched
     * @param text      text to search in
     * @param translation   text translation
     */
    public Keyword(String keyword,String text,String translation)
    {           
        this.keyword = keyword;
        this.text = text;
        this.translation = translation;
        // initiate word search
        wordSearch();
    }// end Keyword constructor method

    /**
     * getKeyword method returns keyword
     * @return keyword
     */
    public String getKeyword()
    {
        return keyword;
    }// end getKeyword method

    /**
     * wordSearch method queries database for verses that contain the keyword
     */
    public void wordSearch()
    {
        // instantiate new Query object
        Query query = new Query();
        
        // create and execute query
        query.setData("SELECT Book,Chapter,Verse,"+translation+" "+
                 "FROM "+text+" "+
                 "WHERE "+translation+" LIKE '%"+keyword+"%' ");
        
        // get query result
        String[][] data = query.getData();
        this.data = data;
        
        int columns = query.getNumberOfColumns();// get number of columns
        
        // instantiante new String for verses
        String[] verses = new String[data.length];
        
        // append data to array
        for (int i = 0; i < data.length; i++)
        {
            verses[i] = data[i][0]+" "+data[i][1]+":"+data[i][2]+"--"+data[i][3];
        }
        this.verses = verses;
    }// end wordSearch method
    
    /**
     * getVerses method returns the matching verses
     * @return verses
     */
    public String[] getVerses() 
    {
        return verses;
    }// end getVerses method
    
    /**
     * getData method returns the table data from the query
     * @return 
     */
    public String[][] getData() 
    {
        return data;
    }// end getFata method
}// end Keyword class
