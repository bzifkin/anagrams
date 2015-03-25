//package anagrams.algs;


/**
 *
 * @author Ben Zifkin
 * 
 * $$$$$$$$$$$ In this file lines 13,14,33,34, 39-44, and 54-58 should be commented out to run on dict2
 */
public class GramList {

    public GramNode[] theList = new GramNode[26]; //contains a list of all possible letters
   public GramNode[] bigs = new GramNode[40];   //contains only those nodes who have 5 or more anagrams
   int bigSize = 0;                             //help where to insert
    int totalGrams = 0;

   //in this method for each character in a key we check and see if the path already exists
    //if not we create a new node and return it
    // when the final level has been found we assign the key/value pair to the final nodes' list of anagrams
    public void insert(Word w) {
        if (w.key == null || w.key.length() == 0 ) {
            return;
        }
        //cycle through
        GramNode temp = theList[w.key.charAt(0) - 97];
        for (int i = 0; i <= w.key.length() - 1; i++) {
            temp = temp.getLink(w.key.charAt(i));

        }
        if (temp.numGrams == 0) { //this is how we count the number of classes
            totalGrams++;         //in the final node we check if it contains any anagrams already and if not we increment our count
        }
        
        

        temp.checkAndExpand();
        temp.anagrams[temp.numGrams] = w; //adding the key,value pair to the final node
        temp.numGrams = temp.numGrams + 1; //incrementing number of nodes to help w/ insertion and to ensure proper 
                                           // notation of new anagram classes
        
        
         if (temp.numGrams >= 5 && temp.inBigs ==false) { //same process as the block above but only as it applies to 
            temp.inBigs = true;                           // classes larger than 5
            bigs[bigSize] = temp;
            bigSize++;
        }

    }

    public void initializeList() {
        for (int i = 0; i <= theList.length - 1; i++) {
            theList[i] = new GramNode();
        }
    }
   
      public void initializeBigs() {
        for (int i = 0; i <= bigs.length - 1; i++) {
            bigs[i] = new GramNode();
        }
    }

}
