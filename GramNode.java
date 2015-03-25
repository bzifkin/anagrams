    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author user
 */
public class GramNode {
    boolean inBigs = false; 
   // int capacity = 100;
   // Word[] anagrams = new Word[capacity];
    int numGrams = 0;
    char alpha;
    GramNode[] links = new GramNode[('z' - alpha) + 1];
     
    
    public GramNode() {}
    
    public GramNode(char alpha) {
        this.alpha = alpha;
    }

    public GramNode getLink(char alpha) {
        if (links[alpha - 97] == null) {
            links[alpha - 97] = new GramNode(alpha);
        }
        return links[alpha - 97];
    }

   
/*
    public int checkAndExpand() {
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
*/
}
