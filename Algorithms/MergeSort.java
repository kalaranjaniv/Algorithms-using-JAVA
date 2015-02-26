import java.util.Arrays;

class MergeSort {
	   public static void main(String[] args)
	      {
	    	int n=Integer.parseInt(args[0]);
	        int a[] = new int[n];       
	        addingarrayelements(a);
	        System.out.println("Before Sorting(input): ");
	        printarrayelements(a);
	        long startTime = System.nanoTime();
	        // sort the array
	        MergeSort_function(a, 0, (a.length - 1));
	        long endTime = System.nanoTime();
	        System.out.println("\nAfter Sorting(output): ");
	        printarrayelements(a);
	        System.out.println("Time taken for"+" "+n+" "+"inputs "+(endTime - startTime)+" ns");	      
	    }
	   public static void printarrayelements(int[] b) {
	        System.out.println(Arrays.toString(b));
	    }
	 
	    public static void addingarrayelements(int[] b) {
	        for (int i = 0; i < b.length; i++) {
	            b[i] = (int) (Math.random() * 1000);
	        }
	    }
	    static public void MergeSort_function(int [] n, int p, int r)
	    {
	      int q;	    
	      if (r > p)
	      {
	        q = (r + p) / 2;
	        MergeSort_function(n, p, q);
	        MergeSort_function(n, (q + 1), r);
	    
	        Merge(n, p, (q+1), r);
	      }
	    }	 
 
      static public void Merge(int [] n, int p, int q, int r)
      {
        int [] newarr = new int[n.length];
        int i, left_end, num_elements, pos;
    
        left_end = (q - 1);
        pos = p;
        num_elements = (r - p + 1);
    
        while ((p <= left_end) && (q <= r))
        {
            if (n[p] <= n[q])
                newarr[pos++] = n[p++];
            else
                newarr[pos++] = n[q++];
        }
    
        while (p <= left_end)
            newarr[pos++] = n[p++];
 
        while (q <= r)
            newarr[pos++] = n[q++];
 
        for (i = 0; i < num_elements; i++)
        {
            n[r] = newarr[r];
            r--;
        }
    }
 

 
}
