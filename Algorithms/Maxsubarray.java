
	import java.util.*;

	public class Maxsubarray {
		 public static void main(String[] args) {
		    	int n=Integer.parseInt(args[0]);
		        int a[] = new int[n];       
		        addingarrayelements(a);
		        System.out.println("Max-Array Elements(input): ");
		        printarrayelements(a);
		        long startTime = System.nanoTime();
		        // sort the array
		       int b[] =maxSubarray(a);
		        long endTime = System.nanoTime();
		        System.out.println("\nMax Sub Array in the given Array of elements:(output): ");
		        printarrayelements(b);
		        System.out.println("Time taken for"+" "+n+" "+"inputs "+(endTime - startTime) + " ns"); 
		    }
		 public static void printarrayelements(int[] b) {
		        System.out.println(Arrays.toString(b));
		    }
		 
		    public static void addingarrayelements(int[] b) {
		        for (int i = 0; i < b.length; i++) {
		            b[i] = -1000+ (int)( Math.random()*((2000-(-1000))+1));
		        }
		    }
	  static int[] maxSubarray(int[] a) {

	    double max_so_far = 0;
	    double max_ending = 0;
	    int max_start_index = 0;
	    int startIndex = 0;
	    int max_end_index = -1;

	    for(int i = 0; i < a.length; i++) {
	      if(0 > max_ending +a[i]) {
	        startIndex = i+1;
	        max_ending = 0;
	      }
	      else {
	        max_ending += a[i];
	      }

	      if(max_ending > max_so_far) {
	        max_so_far = max_ending;
	        max_start_index = startIndex;
	        max_end_index = i;
	      }
	    }

	    if(max_start_index <= max_end_index) {
	      System.out.println("Array start index : "+max_start_index);
	      System.out.println("Array start index : "+(max_end_index));
	      return Arrays.copyOfRange(a, max_start_index, max_end_index+1);      
	    }

	    return null;

	  }

	}
