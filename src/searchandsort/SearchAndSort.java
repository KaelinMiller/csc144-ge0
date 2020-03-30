package searchandsort;

import java.util.ArrayList;
import java.util.Random;

/**
 * Various methods for graded exercise 0
 *
 * @author Kaelin Miller
 * @Version March 30th, 2020
 */
public class SearchAndSort {

    private static final Random RNG = new Random();

    /**
     * Generates a list of random integers.
     *
     * This is just to make life easier for testing all these algorithms that
     * use lists.
     *
     * @param size: The number of items in the list
     * @param range: The largest number the RNG will generate; the smallest is
     * always 0.
     * @return An ArrayList of random integers
     */
    public static ArrayList<Integer> randomList(int size, int range) {
        ArrayList<Integer> result = new ArrayList();

        for (int i = 0; i < size; i++) {
            int r = RNG.nextInt(range);
            result.add(r);
        } // for

        return result;
    } // randomList

    /**
     * Finds the index of the first appearance of a given integer in a list
     * using a sequential search algorithm
     *
     * @param data: An ArrayList of integers
     * @param target: The number the method is looking for
     * @return The index of the target
     */
    public static Integer sequentialSearch(ArrayList<Integer> data, int target) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == target) {
                return i;
            } //if
            else if (i + 1 == data.size()) {
                return -1;
            } //else if
        } //for

        return null;
    } //sequentialSearch

    /**
     * Finds the index of the first appearance of a given value in an ordered
     * list using a binary search algorithm
     *
     * @param values: an ArrayList of integers
     * @param target: the number to be found
     * @return
     */
    public static int binarySearch(ArrayList<Integer> values,
            int target) {
        int result = -1;

        int lo = 0;
        int hi = values.size() - 1;

        while (lo < hi && result < 0) {
            int mid = (lo + hi) / 2;
            if (target == values.get(lo)) {
                result = lo;
            } // if
            else if (target == values.get(mid)) {
                result = mid;
            } // else if
            else if (target == values.get(hi)) {
                result = hi;
            } // else if
            else if (target < values.get(mid)) {
                hi = mid - 1;
            } // else if
            else {
                lo = mid + 1;
            } // else
        } // while

        return result;
    } // binarySearch( List<Integer>, int )

    /**
     * Sorts an ArrayList of integers using a selection sort algorithm
     *
     * @param data: an ArrayList of integers
     * @return a sorted ArrayList
     */
    public static ArrayList<Integer> selectionSort(ArrayList<Integer> data) {

        for (int min = 0; min < data.size(); min++) {
            for (int i = min; i < data.size(); i++) {
                if (data.get(i) < data.get(min)) {
                    int x = data.get(i);
                    data.set(i, data.get(min));
                    data.set(min, x);
                } //if
            } //for
        } //for

        return data;
    } //selectionSort

    /**
     * swaps the values of two indices in an ArrayList
     *
     * @param values: the full list
     * @param i: an index on the list
     * @param j: the index with which index i will swap values
     */
    public static void swap(ArrayList<Integer> values, int i, int j) {
        int temp = values.get(i);
        values.set(i, values.get(j));
        values.set(j, temp);
    } // swap( List<Integer>, int, int )

    /**
     * puts a given integer in its proper place in an ordered list of integers
     *
     * @param values: a list of integers
     * @param next: the integer to be sorted
     */
    public static void insert(ArrayList<Integer> values, int next) {

        int i = next;
        while (i > 0 && values.get(i) < values.get(i - 1)) {
            swap(values, i, i - 1);
            i = i - 1;
        } // while

    } // insert( List<Integer>, int )

    /**
     * sorts an ArrayList of integers using an insertion sort algorithm
     *
     * @param values: the ArrayList to be sorted
     * @return a sorted ArrayList
     */
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> values) {
        for (int i = 1; i < values.size(); i++) {
            insert(values, i);
        } // for
        return values;
    } // insertionSort( List<Integer> )

    /**
     * additional logic for the merge sort algorithm
     *
     * @param values: an ArrayList of integers
     * @param prefixStart
     * @param suffixStart
     * @param suffixEnd
     */
    public static void merge(ArrayList<Integer> values, int prefixStart,
            int suffixStart, int suffixEnd) {
        ArrayList<Integer> temp = new ArrayList<>();

        int i = prefixStart;
        int j = suffixStart;

        while (i < suffixStart && j < suffixEnd) {
            if (values.get(i) < values.get(j)) {
                temp.add(values.get(i));
                i++;
            } // if
            else {
                temp.add(values.get(j));
                j++;
            } // else
        } // while

        while (i < suffixStart) {
            temp.add(values.get(i));
            i++;
        } // while

        while (j < suffixEnd) {
            temp.add(values.get(j));
            j++;
        } // while

        i = prefixStart;
        for (int index = 0; index < temp.size(); index++) {
            values.set(i, temp.get(index));
            i++;
        } // for
    } // merge( List<Integer>, int, int, int )

    /**
     * Sorts an ArrayList of integers using a merge sort algorithm
     *
     * @param values: the ArrayList to be sorted
     * @return the sorted ArrayList
     */
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> values) {
        for (int stepSize = 2; stepSize < values.size(); stepSize *= 2) {
            for (int i = 0; i < values.size(); i += stepSize) {
                int prefixStart = i;
                int suffixStart = i + stepSize / 2;
                int suffixEnd = Math.min(values.size(), i + stepSize);
                merge(values, prefixStart, suffixStart, suffixEnd);
            } // for
            if (stepSize > values.size() / 2) {
                int prefixStart = 0;
                int suffixStart = stepSize;
                int suffixEnd = values.size();
                merge(values, prefixStart, suffixStart, suffixEnd);
            } // if
            //printList(values);
        } // for
        return values;
    } // mergeSort( List<Integer> )

    // TO-DO: Define a method that sorts a list
    // of integers using the merge sort algorithm.
    public static void main(String[] args) {

        System.out.println("Sequential Search for the number 15:");
        ArrayList<Integer> sSearchTest = randomList(15, 20);
        System.out.println(sSearchTest);
        System.out.println(sequentialSearch(sSearchTest, 15));
        System.out.println();

        System.out.println("binary Search for the number 15:");
        ArrayList<Integer> bSearchTest = mergeSort(randomList(15, 20));
        System.out.println(bSearchTest);
        System.out.println(binarySearch(bSearchTest, 15));
        System.out.println();

        System.out.println("Selection Sort:");
        ArrayList<Integer> ssTest = randomList(15, 101);
        System.out.println(ssTest);
        System.out.println(selectionSort(ssTest));
        System.out.println();

        System.out.println("Insertion Sort:");
        ArrayList<Integer> isTest = randomList(15, 101);
        System.out.println(isTest);
        System.out.println(insertionSort(isTest));
        System.out.println();

        System.out.println("Merge Sort:");
        ArrayList<Integer> msTest = randomList(15, 101);
        System.out.println(msTest);
        System.out.println(mergeSort(msTest));
        System.out.println();

        // TO-DO: Add code that tests the searching and sorting
        // methods.
    } // main( String [] )
} // SearchAndSort
