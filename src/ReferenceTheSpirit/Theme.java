/**
 * Theme.java - class queries themes database for a given theme's corresponding
 * verses
 * CSIS 505 - B01
 * @author Kore Woody
 */
package ReferenceTheSpirit;

public class Theme 
{    
    String theme;
    String text,translation;
    String[] verses;
    String[][] data;    
    
    /**
     * Theme default constructor method
     * Null input
     */
    public Theme()
    { }// end Theme constructor method
    
    /**
     * Theme constructor method for setting the search values and initiating the 
     * theme search.
     * @param theme word being searched for 
     * @param text  resulting verse location
     * @param translation  version of the text
     */
    public Theme(String theme,String text,String translation)
    {   
        this.theme = theme;
        this.text = text;
        this.translation = translation;
        // initiate word search
        wordSearch();
    }// end Theme constructor method
    
    /**
     * getTheme method for getting the theme word
     * @return theme
     */
    public String getTheme()
    {
        return theme;
    }// end getTheme method

    /**
     * wordSearch method for querying database for verse list with matching 
     * theme
     */
    public void wordSearch()
    {
        // instantiate new Index object
        Index index = new Index();
        // create and execute query
        index.setThemeList("SELECT Verses "+
                 "FROM Themes "+
                 "WHERE theme LIKE '%"+theme+"%' ");
        // get query results
        String[] verseRef = index.getList();
        // get column count
        int columns = index.getNumberOfColumns();
        
        String[][] bookChapterVerseText = new String[verseRef.length/2][4];
        
        // split query results and search for each verse
        
        for (int i = 0; i<verseRef.length/2; i++)
        {
            // split results and set book values
            String[] ref = verseRef[i].split("\\.");
            String book = ref[0];
            String chapter = ref[1];
            String verse = ref[2];
            // if more than one verse convert range to first number
            if (verse.indexOf("-")!=-1 || verse.indexOf('-')!=1 )
            {
                String[] range = verse.split("-");
                verse = range[0];
            }
            // create and execute query for each verse
            index.setValue("SELECT "+translation+" "+
                    "FROM "+text+" "+
                    "WHERE Book = '"+book+"' AND "+
                    "Chapter = "+chapter+" AND "+
                    "Verse = "+verse+" ");
            // set verse values
            bookChapterVerseText[i][0] = book;// set book
            bookChapterVerseText[i][1] = chapter;// set chapter
            bookChapterVerseText[i][2] = verse;// set verse number
            bookChapterVerseText[i][3] = index.getValue();// get/set verse text
            
        }
        this.data = bookChapterVerseText;
        
    }// end wordSearch method
    
    /**
     * getVerses method returns the array of verses from query
     * @return verse list, combined string of verses with their book, chapter.
     * and verse number.
     */
    public String[] getVerses() 
    {
        return verses;
    }// end getVerses method
    
    /**
     * getData method returns queried verses
     * @return verses with Book, Chapter, and verse number
     */
    public String[][] getData() 
    {
        return data;
    }// end getData method
    
    /**
     * wordSearch method for querying database for verse list with matching 
     * theme
     */
    public void getThemes()
    {
        // instantiate new Index object
        Index index = new Index();
        // create and execute query
        index.setThemeList("SELECT Themes "+
                 "FROM Themess "+
                 "WHERE theme = '"+theme+"' ");
        // get query results
        String[] verseRef = index.getList();
        // get column count
        int columns = index.getNumberOfColumns();
        
        String[][] bookChapterVerseText = new String[verseRef.length/2][4];
        
        // split query results and search for each verse
        
        for (int i = 0; i<verseRef.length/2; i++)
        {
            // split results and set book values
            String[] ref = verseRef[i].split("\\.");
            String book = ref[0];
            String chapter = ref[1];
            String verse = ref[2];
            // if more than one verse convert range to first number
            if (verse.indexOf("-")!=-1 || verse.indexOf('-')!=1 )
            {
                String[] range = verse.split("-");
                verse = range[0];
            }
            // create and execute query for each verse
            index.setValue("SELECT "+translation+" "+
                    "FROM "+text+" "+
                    "WHERE Book = '"+book+"' AND "+
                    "Chapter = "+chapter+" AND "+
                    "Verse = "+verse+" ");
            // set verse values
            bookChapterVerseText[i][0] = book;// set book
            bookChapterVerseText[i][1] = chapter;// set chapter
            bookChapterVerseText[i][2] = verse;// set verse number
            bookChapterVerseText[i][3] = index.getValue();// get/set verse text
            
        }
        this.data = bookChapterVerseText;
    }
}// end Theme class