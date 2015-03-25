package anagrams.algs;

import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Ben Zifkin
 */
public class AnagramDriver {
 
  
    public static void main(String[] args) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("firstPass.txt"));
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\user\\Documents\\NetBeansProjects\\Anagrams-Algs\\dict1.txt\\"));
       
       GramList dict = new GramList();
       dict.initializeList();
       String w;
        while ((w = in.readLine()) != null)  {
           
                dict.insert(new Word(w));
            
        }
        /*
        for(int i=0; i<=dict.bigs.length-1; i++){
            for(int j=0; j<=dict.bigs[i].anagrams.length-1; j++){
         System.out.println(dict.bigs[i].anagrams[j].value);
            }
            System.out.println("----------");
        }
                */
        System.out.println("total anagram classes " + dict.totalGrams);
}
}
