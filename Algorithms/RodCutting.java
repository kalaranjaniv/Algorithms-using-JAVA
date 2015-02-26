
import java.util.Arrays;
import java.util.Scanner;

public class RodCutting {
	public static int n;
	public static int pricelength,i,j;	
	public static int cost[]= new int[100];
	private static  int [] max_cost = new int[100];
	
	private static void inputmethod()
	{
	Scanner in = new Scanner(System.in);
    System.out.println("Prices for how many rods had to be entered ?");
    pricelength = in.nextInt();

    for(i=0;i<pricelength;i++)
    {
    	System.out.println("Enter the price of rod length " + (i+1)+":");
    	cost[i]= in.nextInt();
    }
	System.out.println("The given prices are: ");
	for(j=0;j<pricelength;j++)
	{
    System.out.print(cost[j]);
    System.out.print("\t");
    }
	System.out.println("\n");
    System.out.println("Enter the length of the given rod : ");
    n=in.nextInt();
	}

private static int maxPrice(int n1){

    if(n1 == 1 ){
        return cost[0];
    }
    if(n1 == 0){
        return 0;
    }
    int currentVal = 0;
    int maxVal = 0;
    for(int i = 0; i <= n1 - 1 ; i++ ){
        if(max_cost[n1  - 1 - i] == -1){
            max_cost[n1 - 1 - i] = maxPrice(n1-i-1);

        }
        currentVal = cost[i] + max_cost[n1 - i -1];
        if(currentVal > maxVal){
                     maxVal = currentVal;
        }
    }

    return maxVal;

}

public static void main(String[] args) {
	
	inputmethod();
    Arrays.fill(max_cost, -1);    
    System.out.print("The maximum amount that can be got with this rod will be :");
    System.out.println(maxPrice(n));
}
}

