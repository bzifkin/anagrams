//package anagrams.algs;

/**
 *
 * @author Ben Zifkin
 * 
 * 
 * $$$$$ In this file lines 12,13, 34-46 should be commented out to run on dict2
 */
public class GramNode {
    boolean inBigs = false; 
    int capacity = 35;
    Word[] anagrams = new Word[capacity]; //list of anagrams in this node
    int numGrams = 0;
    char alpha;
    GramNode[] links = new GramNode[('z' - alpha) + 1]; //map to other links. 
                                                        // the 'z'-alpha is there to ensure that we don't make a needlessly large array
                                                        // e.g. if we are in 'f' we know that we will not be seeing a-e, so we have the map
    public GramNode() {}                                // reflect that
    
    public GramNode(char alpha) {
        this.alpha = alpha;
    }

    public GramNode getLink(char alpha) {
        if (links[alpha - 97] == null) { //-97 b/c 'a' is 97 in ASCII so subtracting gets us the proper index
            links[alpha - 97] = new GramNode(alpha);
        }
        return links[alpha - 97];
    }

   

    public int checkAndExpand() {       //just in case there are too many words in a certain node we can increase the size of the array
        if (numGrams +5 >= capacity) {
            Word[] old = anagrams;
		capacity = capacity *2;
            anagrams = new Word[capacity];

            for (int i = 0; i <= old.length-1; i++) {
                anagrams[i] = old[i];
            }

        }
        return anagrams.length;
    }

}
