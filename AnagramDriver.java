
//package anagrams.algs;

//import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author Ben Zifkin
 * 
 * $$$$$$$ In order to run this on dict2 lines 25, and 34-49 must be commented out.
 * This is true in GramNode and GramList as well
 *
 *
 */
public class AnagramDriver {

    public static void main(String[] args) throws IOException {

//Take in the files as arguements from command line in format: readfile writefile
         BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));
        BufferedReader in = new BufferedReader(new FileReader(args[0]));

        GramList dict = new GramList();
        dict.initializeList(); //initialize and populate both lists w/ nulls
        dict.initializeBigs(); 
        String w;
        while ((w = in.readLine()) != null) {

            dict.insert(new Word(w));

        }

out.write("total anagram classes for " + args[0] + " : " + dict.totalGrams);
       for (GramNode gn : dict.bigs) { //loop through the nodes we know to have more than five anagrams
           if (gn != null) {             //loop through the words in the node and print them if they aren't null
               out.write("----------\n");
               }
          else
              break;
    
              for (Word wo : gn.anagrams) {
                   if (wo != null) {
                       out.write(wo.value + " ");
                       out.write("\n");
                   }

               }
                     
       }

out.flush();
out.close();
   
    }
}
