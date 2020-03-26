
package searchandsort;

import java.util.ArrayList;
import java.util.Random;
    
   /**Various methods for graded exercise 0
    * 
    * @author Kaelin Miller
    * @Version March 26th, 2020
    */
public class SearchAndSort {
    
    private static final Random RNG = new Random();
    
    /**Generates a list of random integers.
     * 
     * This is just to make life easier for testing all these algorithms that use lists.
     * @param size: The number of items in the list
     * @param range: The largest number the RNG will generate; the smallest is always 0.
     * @return An ArrayList of random integers
     */
    public static ArrayList<Integer> randomList(int size, int range) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int r = RNG.nextInt(range);
            result.add(r);
        } // for

        return result;
    } // randomList
    
    /**Finds the first appearance of a given integer in a list
     * 
     * @param data: An ArrayList of integers
     * @param target: The number the method is looking for
     * @return The index of the target
     */
    public static Integer sequentialSearch( ArrayList<Integer> data, int target ){
        
        for (int i = 0; i < data.size(); i ++){
            if ( data.get(i) == target){
                return i;
            } //if
            else if( i + 1 == data.size() ){
                return -1;
            } //else if
        } //for
        
        return null;
    } //sequentialSearch
    
    // TO-DO: Define a method that determines
    // the index of the first integer in a list
    // of integers that matches a given integer.
    // The method should return -1 if no match is found.
    // Use the binary search algorithm.
    
    // TO-DO: Define a method that sorts a list
    // of integers using the selection sort algorithm.
    
    // TO-DO: Define a method that sorts a list
    // of integers using the insertion sort algorithm.
    
    // TO-DO: Define a method that sorts a list
    // of integers using the merge sort algorithm.
    
    public static void main( String [] args ) {
        
        ArrayList<Integer> testList = randomList(50, 101);
        
        System.out.println( testList );
        System.out.println( "Sequential Search: " + sequentialSearch(testList, 100));
        
        // TO-DO: Add code that tests the searching and sorting
        // methods.
        
    } // main( String [] )
} // SearchAndSort
