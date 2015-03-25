/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author user
 */
public class Word {

    String value;
    String key;
 

    public Word(String value) {
        
        if(value!=null){
        this.value = value;
        key = sorted(value);
        }
    }

    public String sorted(String value) {
        char[] c = value.toCharArray();
        sort(c);
        return new String(c);
    }

    /**
     * ******************************************************************************************
     * Return a String representation of a Word.
*******************************************************************************************
     */
    public String toString() {
        return value;
    }

    /**
     * ******************************************************************************************
     * Public helper method to hide the implementation details of the sorting.
*******************************************************************************************
     */
    public static void sort(char[] c) {
        quicksort(c, 0, c.length - 1);
    }

    /**
     * ******************************************************************************************
     * Sort the word lexicographically using quicksort.
*******************************************************************************************
     */
    private static void quicksort(char[] arr, int start, int end) {
        if (start <= end) {
            int pivot = choosePivot(arr, start, end);
            pivot = partition(arr, start, end, pivot);
            quicksort(arr, start, pivot - 1);
            quicksort(arr, pivot + 1, end);
        }
    }

    /**
     * ******************************************************************************************
     * Returns a random pivot, ensuring the worst case runtime is O(n log n).
*******************************************************************************************
     */
    private static int choosePivot(char[] arr, int start, int end) {
        return (int) (Math.random() * (end - start + 1)) + start;
    }

    /**
     * ******************************************************************************************
     * Returns a random pivot, ensuring the worst case runtime is O(n log n).
*******************************************************************************************
     */
    private static int partition(char[] arr, int start, int end, int pivot) {
        char pivotValue = arr[pivot];
        swap(arr, pivot, end);
        int storeIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, end);
        return storeIndex;
    }

    /**
     * ******************************************************************************************
     * Swap two characters.
*******************************************************************************************
     */
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
 public int makeHashKey(String value) {

 int temp = 1;
 for (int i = 0; i <= value.length() - 1; i++) {
 char ch = value.charAt(i);

 switch (ch) {
 case 'a':
 temp = temp * 3;
 break;
 case 'b':
 temp = temp * 5;
 break;
 case 'c':
 temp = temp * 7;
 break;
 case 'd':
 temp = temp * 11;
 break;
 case 'e':
 temp = temp * 13;
 break;
 case 'f':
 temp = temp * 17;
 break;
 case 'g':
 temp = temp * 19;
 break;
 case 'h':
 temp = temp * 23;
 break;
 case 'i':
 temp = temp * 29;
 break;
 case 'j':
 temp = temp * 31;
 break;
 case 'k':
 temp = temp * 37;
 break;
 case 'l':
 temp = temp * 41;
 break;
 case 'm':
 temp = temp * 43;
 break;
 case 'n':
 temp = temp * 47;
 break;
 case 'o':
 temp = temp * 53;
 break;
 case 'p':
 temp = temp * 59;
 break;
 case 'q':
 temp = temp * 61;
 break;
 case 'r':
 temp = temp * 67;
 break;
 case 's':
 temp = temp * 71;
 break;
 case 't':
 temp = temp * 73;
 break;
 case 'u':
 temp = temp * 79;
 break;
 case 'v':
 temp = temp * 83;
 break;
 case 'w':
 temp = temp * 97;
 break;
 case 'x':
 temp = temp * 101;
 break;
 case 'y':
 temp = temp * 103;
 break;
 case 'z':
 temp = temp * 107;
 break;
 }   
 }
 return temp;
 }   


  public static class MyComparator implements java.util.Comparator<String> {

        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }

 */
