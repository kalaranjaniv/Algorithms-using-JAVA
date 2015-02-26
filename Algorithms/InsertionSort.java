import java.util.Arrays;
 
public class InsertionSort {
 
    public static void main(String[] args) {
    	int n=Integer.parseInt(args[0]);
        int a[] = new int[n];       
        addingarrayelements(a);
        System.out.println("Before Sorting(input): ");
        printarrayelements(a);
        long startTime = System.nanoTime();
        // sort the array
        insertionSort(a);
        long endTime = System.nanoTime();
        System.out.println("\nAfter Sorting(output): ");
        printarrayelements(a);
        System.out.println("Time taken for"+" "+n+" "+"inputs "+(endTime - startTime) + " ns"); 
    }
 
    /*
     * This method will sort the given integer array using insertion sort algorithm
     */
    private static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i;
            while (j > 0 && a[j - 1] > key) //to make it as descending change the a[j-1] < key
            {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = key;
        }
    }
 
    public static void printarrayelements(int[] b) {
        System.out.println(Arrays.toString(b));
    }
 
    public static void addingarrayelements(int[] b) {
        for (int i = 0; i < b.length; i++) {
            b[i] = (int) (Math.random() * 1000);
        }
    }
}