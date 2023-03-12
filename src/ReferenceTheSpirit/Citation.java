/**
 * Citation.java - creates and returns verses in selected citation format
 * @author NoFac3
 */
package ReferenceTheSpirit;

import java.time.Year;      // program uses class year
import java.util.ArrayList; // program uses class ArrayList

public class Citation 
{
    String translation, citeYear, verseNumbers;
    String source, text, book, chapter;
    String verses, citation, format, citationFormat;
    
    /**
     * Citation constructor method sets citation values and initiates formatting 
     * methods
     * @param format        selected format (APA,MLA,Turabian)
     * @param chapterText   selected chapter text
     * @param source        selected source 
     * @param text          selected source text
     * @param translation   selected text translation
     * @param book          selected text book
     * @param chapter       chapter number
     * @param strVerseRange verse start
     * @param intVerseRange verse end
     */
    public Citation(String format, String chapterText, String source, String text, String translation, String book, String chapter, String[] strVerseRange, int[] intVerseRange)
    {
        this.source = source;
        this.text = text;
        this.translation = translation;
        this.book = book;
        this.chapter = chapter;
        this.format = format;
        setTranslation(translation);
        setBook();
        setVerses(chapterText, strVerseRange, intVerseRange);
        setVerseRange(strVerseRange[0],strVerseRange[1]);
        setCitationFormat();   
    }// end Citation constructor method 
    
    
    /**
     * setTranslation method determines the format of the translation and the 
     * publishing year
     * @param translation text translation
     */
    public void setTranslation(String translation)
    {
        int yearPub = 0;
        Year year = Year.now();// get current year
        
        if (source.matches("Christianity"))// source is Christianity
        {
            if (format.matches("APA"))
            {
                if (translation=="AKJV")
                {
                    translation = "American King James Bible";
                    yearPub = 1769;
                }    
                if (translation=="ASV")
                {
                    translation = "American Standard Bible";
                    yearPub = 1901;
                }
                if (translation=="ERV")
                {
                    translation = "English Revised Bible";
                    yearPub = 1987;
                }
                if (translation=="KJV")
                {
                    translation = "King James Bible";
                    yearPub = 1769;
                }
                if (translation=="YLT")
                {
                    translation = "Young\'s Literal Translation Bible";
                    yearPub = 1862;
                }
                if (translation == "CPDV")
                {
                    translation = "Catholic Public Domain Version";
                    yearPub = 2009;
                }
                if (translation == "DBT")
                {
                    translation = "Darby Bible Translation";
                    yearPub = 1890;
                }
                if (translation == "DRB")
                {
                    translation = "Douay-Rheims Bible";
                    yearPub = 1610;
                }
                if (translation == "JPS_WEY")
                {
                    translation = "JPS Tanakh OT/Weymouth NT";
                    yearPub = 1917;
                }
                if (translation == "NHEB")
                {
                    translation = "New Heart English Bible";
                    yearPub = 2008;
                }
                if (translation == "SLT")
                {
                    translation = "Smith\'s Literal Translation";
                    yearPub = 1830;
                }
                if (translation == "WBT")
                {
                    translation = "Webster Bible Translation";
                    yearPub = 1611;
                }
                if (translation == "WEB")
                {
                    translation = "World English Bible";
                    yearPub = 1994;
                }
                if (translation == "BSB")
                {
                    translation = "Berean Study Bible";
                    yearPub = 2016; 
                }
            }
        }
        if (source.matches("Islam"))// source is Islam
        {
            translation = "A Contemporary Translation";
            yearPub = 1994;
        }
        if (source.matches("Hinduism"))// source is Hinduism
        {
            translation = "Ralph T.H. Griffith";
            yearPub = 1896;
        }
        this.translation = translation;
        setYear(yearPub,year);// format year
    }// end setTranslation method
    
    /**
     * getTranslation method returns the translation
     * @return text translation
     */
    public String getTranslation()
    {
        return translation;
    }// end getTranslation method
    
    /**
     * setBook method formats book based on selected citation format standards
     */
    public void setBook()
    {
        if (text.matches("Quran"))// text is Quran
        {
            book = "Al-Qur\'an";
        }
        if (text.matches("RigVeda"))// text is Rig-Veda
        {
            book = "Rig-Veda Book I";
        }
        // MLA or Turabian format: abbreviate book
        if (format.matches("MLA") || format.matches("Turabian"))
        {
            if (source.matches("Christianity"))// for Bible and Apocrypha
            {
                // check for book name
                if (book.matches("Amos")) 
                {
                    book = "Amos";
                }
                if (book.matches("1 Chronicles")) 
                {
                    book = "1 Chron.";
                }
                if (book.matches("2 Chronicles")) 
                {
                    book = "2 Chron.";
                }
                if (book.matches("Daniel")) 
                {
                    book = "Dan.";
                }
                if (book.matches("Deuteronomy")) 
                {
                    book = "Deut.";
                }
                if (book.matches("Ecclesiastes")) 
                {
                    book = "Eccles.";
                }
                if (book.matches("Esther")) 
                {
                    if (text.matches("Apocrypha")) // additions to Esther
                    {
                        book = "Esth. (Appocr.)";
                    }
                    else// from Bible
                    {
                        book = "Esth.";
                    }
                }
                if (book.matches("Exodus")) 
                {
                    book = "Exod.";
                }
                if (book.matches("Ezekiel")) 
                {
                    book = "Ezek.";
                }
                if (book.matches("Ezra")) 
                {
                    book = "Ezra";
                }
                if (book.matches("Genesis")) 
                {
                    book = "Gen.";
                }
                if (book.matches("Habakkuk")) 
                {
                    book = "Hab.";
                }
                if (book.matches("Haggai")) 
                {
                    book = "Hag.";
                }
                if (book.matches("Hosea")) 
                {
                    book = "Hosea";
                }
                if (book.matches("Isaiah")) 
                {
                    book = "Isa.";
                }
                if (book.matches("Jeremiah")) 
                {
                    book = "Jer.";
                }
                if (book.matches("Job")) 
                {
                    book = "Job";
                }
                if (book.matches("Joel")) 
                {
                    book = "Joel";
                }
                if (book.matches("Jonah")) 
                {
                    book = "Jon.";
                }
                if (book.matches("Joshua")) 
                {
                    book = "Josh.";
                }
                if (book.matches("Judges")) 
                {
                    book = "Judg.";
                }
                if (book.matches("1 Kings")) 
                {
                    book = "1 Kings";
                }
                if (book.matches("2 Kings")) 
                {
                    book = "2 Kings";
                }
                if (book.matches("Lamentations")) 
                {
                    book = "Lam.";
                }
                if (book.matches("Leviticus")) 
                {
                    book = "Lev.";
                }
                if (book.matches("Malachi")) 
                {
                    book = "Mal.";
                }
                if (book.matches("Micah")) 
                {
                    book = "Mic.";
                }
                if (book.matches("Nahum")) 
                {
                    book = "Nah.";
                }
                if (book.matches("Nehemiah")) 
                {
                    book = "Neh.";
                }
                if (book.matches("Numbers")) 
                {
                    book = "Num.";
                }
                if (book.matches("Obadiah")) 
                {
                    book = "Obad.";
                }
                if (book.matches("Proverbs")) 
                {
                    book = "Prov.";
                }
                if (book.matches("Psalms")) 
                {
                    book = "Ps.";
                }
                if (book.matches("Ruth")) 
                {
                    book = "Ruth";
                }
                if (book.matches("1 Samuel")) 
                {
                    book = "1 Sam.";
                }
                if (book.matches("2 Samuel")) 
                {
                    book = "2 Sam. ";
                }
                if (book.matches("Song of Solomon")) 
                {
                    book = "Song of Sol.";
                }
                if (book.matches("Songs of Songs")) 
                {
                    book = "Song of Sol.";
                }
                if (book.matches("Zechariah")) 
                {
                    book = "Zech.";
                }
                if (book.matches("Zephaniah")) 
                {
                    book = "Zeph.";
                }
                if (book.matches("Acts")) 
                {
                    book = "Acts";
                }
                if (book.matches("Apocalypse")) 
                {
                    book = "Apoc.";
                }
                if (book.matches("Colossians")) 
                {
                    book = "Col.";
                }
                if (book.matches("1 Corinthians")) 
                {
                    book = "1 Cor.";
                }
                if (book.matches("2 Corinthians")) 
                {
                    book = "2 Cor.";
                }
                if (book.matches("Ephesians")) 
                {
                    book = "Eph.";
                }
                if (book.matches("Galatians")) 
                {
                    book = "Gal.";
                }
                if (book.matches("Hebrews")) 
                {
                    book = "Heb.";
                }
                if (book.matches("James")) 
                {
                    book = "James";
                }
                if (book.matches("John")) 
                {
                    book = "John";
                }
                if (book.matches("1 John")) 
                {
                    book = "1 John";
                }
                if (book.matches("2 John")) 
                {
                    book = "2 John";
                }
                if (book.matches("3 John")) 
                {
                    book = "3 John";
                }
                if (book.matches("Jude")) 
                {
                    book = "Jude";
                }
                if (book.matches("Luke")) 
                {
                    book = "Luke";
                }
                if (book.matches("Mark")) 
                {
                    book = "Mark";
                }
                if (book.matches("Matthew")) 
                {
                    book = "Matt.";
                }
                if (book.matches("1 Peter")) 
                {
                    book = "1 Pet.";
                }
                if (book.matches("2 Peter")) 
                {
                    book = "2 Pet.";
                }
                if (book.matches("Philemon"))
                {
                    book = "Philem.";
                }
                if (book.matches("Philippians")) 
                {
                    book = "Phil.";
                }
                if (book.matches("Revelation")) 
                {
                    book = "Rev.";
                }
                if (book.matches("Romans")) 
                {
                    book = "Rom.";
                }
                if (book.matches("1 Thessalonians")) 
                {
                    book = "1 Thess.";
                }
                if (book.matches("2 Thessalonians")) 
                {
                    book = "2 Thess.";
                }
                if (book.matches("1 Timothy")) 
                {
                    book = "1 Tim.";
                }
                if (book.matches("2 Timothy")) 
                {
                    book = "2 Tim.";
                }
                if (book.matches("Titus")) 
                {
                    book = "Titus";
                }
                if (book.matches("Baruch")) 
                {
                    book = "Bar.";
                }
                if (book.matches("Bel and the Dragon")) 
                {
                    book = "Bel.";
                }
                if (book.matches("Sirach/Ecclesiasticus")) 
                {
                    book = "Ecclus.";
                }
                if (book.matches("Ecclesiasticus")) 
                {
                    book = "Ecclus.";
                }
                if (book.matches("Sirach"))
                {
                    book = "Sir.";
                }
                if (book.matches("1 Esdras")) 
                {
                    book = "1 Esd.";
                }
                if (book.matches("2 Esdras"))
                {
                    book = "2 Esd. ";
                }
                if (book.matches("Judith")) 
                {
                    book = "Jth.";
                }
                if (book.matches("1 Maccabees")) 
                {
                    book = "1 Macc.";
                }
                if (book.matches("2 Maccabees")) 
                {
                    book = "2 Macc.";
                }
                if (book.matches("Prayer of Manasseh")) 
                {
                    book = "Pr. of Man.";
                }
                if (book.matches("Prayer of Manasses (Manasseh)"))
                {
                    book = "Pr. of Man.";
                }
                if (book.matches("Prayer of Azariah")) {
                    book = "Pr. of Azar.";
                }
                if (book.matches("Song of the Three Holy Children"))
                {
                    book = "Song of Three Children";
                }
                if (book.matches("Susanna")) 
                {
                    book = "Sus.";
                }
                if (book.matches("Tobit")) 
                {
                    book = "Tob.";
                }
                if (book.matches("Wisdom"))
                {
                    book = "Wisd.";
                }
            }
        }
    }// end setBook method
    
    /**
     * strVerses method formats the verse text based on the selected citation 
     * format standards
     * @param chapterText   chapter text
     * @param strVerseRange verse number start
     * @param intVerseRange verse number end
     */
    public void setVerses(String chapterText, String[] strVerseRange, int[] intVerseRange)
    {
        String[] Verses = chapterText.split("\n");
        ArrayList<String> verses = new ArrayList<>();
        
        String strVerseStart = strVerseRange[0];
        String strVerseEnd = strVerseRange[1];
        
        // convert values to integers
        int verseStart = intVerseRange[0];
        int verseEnd = intVerseRange[1];
        
        String verseText = "";
        boolean verseRange = false;
        
        ArrayList<String> citedVerses = new ArrayList<>();
        
        // append chapter verses to array
        for (String v: Verses)
        {
            verses.add(v);
        }
        
        // format verses
        for (String verse: verses)
        {
            String[] words = verse.split(" ");
            if (words.length > 1)// check for null values
            {
                if (words[0].matches(strVerseStart))
                {   
                    // replace verse numbers and append to array
                    citedVerses.add(verse.replaceAll("[0-9]", "").replaceAll("\\[", "").replaceAll("\\]", ""));
                    if (strVerseStart!=strVerseEnd)
                    {
                        verseRange = true;// there is more than one verse
                    }
                }
                else if (verseRange==true)// more than one verse
                {
                    if (words[0].matches(strVerseEnd))// reached last verse
                    {
                        citedVerses.add(verse.replaceAll("[0-9]", "")
                                .replaceAll("\\[", "")
                                .replaceAll("\\]", ""));
                        verseRange=false;// stop loop
                    }
                    else// hasn't reached last verse
                    {
                        citedVerses.add(verse.replaceAll("[0-9]", "")
                                .replaceAll("\\[", "")
                                .replaceAll("\\]", ""));
                    }
                }
            }    
        }
        verseText = "";
        //append formatted verses to string
        for (String v : citedVerses)
        {
            verseText = verseText + v;
        }
        this.verses = verseText;
    }// end setVerses method
    
    /**
     * getVerses method returns the citation verses
     * @return verses
     */
    public String getVerses()
    {
        return verses;
    }//end getVerses Method
    
    /**
     * setVerseRange method formats the single or range of verses in the 
     * selected citation format standards
     * @param verseStart verse number start
     * @param verseEnd  verse number end
     */
    public void setVerseRange(String verseStart, String verseEnd)
    {
        String verseNumbers = "";
        String verseSeparator = "";
        
        
        if (verseStart.matches(verseEnd))// one verse
        {
            verseNumbers = verseStart;
        }
        else// more than one verse
        {
            verseNumbers = verseStart + "-" + verseEnd;
        }
        this.verseNumbers = verseNumbers;
    }// end setVerseRange method
    
    /**
     * getVerseRange method returns the formatted verses
     * @return formatted verse range
     */
    public String getVerseRange()
    {
        return verseNumbers;
    }// end getVerse Range method
    
    /**
     * setYear method formats the published year
     * @param yearPub   published year
     * @param year      current year
     */
    public void setYear(int yearPub, Year year)
    {   
        String citeYear = yearPub + "/" + year;
        this.citeYear = citeYear;
    }// end setYear method
    
    /**
     * getYear method returns the formatted year
     * @return 
     */
    public String getYear()
    {
        return citeYear;
    }// end getYear method
    
    /**
     * setCitationFormat method formats the final citation based on the selected
     * citation format for all the formatted verse values
     */
    public void setCitationFormat()
    {
        String citationFormat = "";
        // check for chosen format
        if (format.matches("APA"))// APA format
        {
            if (source.matches("Christianity"))// for Bible and Apocrypha
            {
                citationFormat = getTranslation() + ", " + getYear() + ", " + book + " "
 + chapter + ":" + getVerseRange();
            }
            else// all other text
            {
                citationFormat = book + "," + getYear() + ", " + chapter + ":" + getVerseRange();
            }
        }
        if (format.matches("MLA"))// MLA format
        {
            if (source.matches("Christianity"))// for Bible and Apocrypha
            {
                citationFormat = translation + " " + text + ", " + book + " " + chapter + "." + getVerseRange();
            }
            else// all other text
            {
                citationFormat = book + " " + chapter + "." + getVerseRange();
            }
        }
        if (format.matches("Turabian"))// Turabian format
        {
            if (source.matches("Christianity"))// For Bible and Apocrypha
            {
                citationFormat = book + " " + chapter + ":" + getVerseRange() + " [" + getTranslation() + "]";
            }
            else// all other text
            {
                citationFormat = book + " " + chapter + ":" + getVerseRange();
            }
        }
        
        this.citationFormat = citationFormat;
    }
    public String getCitationFormat()
    {
        return citationFormat;
    }
    
    /**
     * toString method returns the formatted citation
     * @return citation
     */
    @Override// indicated this method overides the toString method
    public String toString()
    {
        String citation = "\"" + getVerses() + "\" (" + getCitationFormat() + ").";
            citation = citation.replace("\" ", "\"");
            citation = citation.replace("\" ", "\"");
            citation = citation.replace("\"(", "\" (");
            citation = citation.replace(".\"", "\"");
            
        return String.format("%s", citation);
    }// end toString method
}// end Citation CLass
