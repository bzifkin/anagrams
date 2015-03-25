    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagrams.algs;

/**
 *
 * @author user
 */
public class GramNode {
    boolean inBigs; 

    Word[] anagrams = new Word[10];
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

   

    public int checkAndExpand() {
        if (numGrams + 1 >= anagrams.length) {
            Word[] old = anagrams;

            anagrams = new Word[15];

            for (int i = 0; i <= old.length; i++) {
                anagrams[i] = old[i];
            }

        }
        return anagrams.length;
    }

}
