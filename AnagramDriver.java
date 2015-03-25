package anagrams.algs;

//import java.util.*;
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
        dict.initializeBigs();
        String w;
        while ((w = in.readLine()) != null) {

            dict.insert(new Word(w));

        }

        for (GramNode gn : dict.bigs) {
            if (gn != null) {
                out.write("----------\n");
                }
            else
                break;
                for (Word wo : gn.anagrams) {
                    if (wo != null) {
                       // System.out.print(wo.value + " ");
                        out.write(wo.value + " ");
                        out.write("\n");
                    }

                }
                //System.out.println("----------");
                
             
            
        }
out.flush();
out.close();
        System.out.println("total anagram classes " + dict.totalGrams);
    }
}
