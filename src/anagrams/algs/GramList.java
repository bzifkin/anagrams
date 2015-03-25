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
public class GramList {

    public GramNode[] theList = new GramNode[26];
    GramNode[] bigs = new GramNode[100];
    int bigSize = 0;
    int totalGrams = 0;

    //public GramNode root;
    public void insert(Word w) {
        if (w.key == null || w.key.length() == 0) {
            return;
        }
        GramNode temp = theList[w.key.charAt(0) - 97];
        for (int i = 0; i <= w.key.length() - 1; i++) {
            temp = temp.getLink(w.key.charAt(i));

        }
        if (temp.numGrams == 0) {
            totalGrams++;
        }
         if (temp.numGrams >= 5) {
            bigs[bigSize] = temp;
            bigSize++;
        }
        

        temp.anagrams[temp.numGrams] = w;
        System.out.println(w.value + " -> " + w.key + " inserted. Class Size: " + temp.numGrams);
        temp.numGrams = temp.numGrams + 1;

       
        

        temp.checkAndExpand();
    }

    public void initializeList() {
        for (int i = 0; i <= theList.length - 1; i++) {
            theList[i] = new GramNode();
        }
    }

}
