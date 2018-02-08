package spelling;

import java.util.TreeSet;

/**
 * @author UC San Diego Intermediate MOOC team
 * @author tanmay
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;
   private int size;
    // TODO: Implement the dictionary interface using a TreeSet.  
 	// You'll need a constructor here
	
    public DictionaryBST(){
        dict = new TreeSet<>();
    }
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
        if(!isWord(word)){
            word = word.toLowerCase();
            dict.add(word);
            size++;
            return true;
        }
        return false;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
    	// TODO: Implement this method
        return size;
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	//TODO: Implement this method
        String word = s.toLowerCase();
        if(dict.contains(word)){
            return true;
        }
        return false;
    }

}
