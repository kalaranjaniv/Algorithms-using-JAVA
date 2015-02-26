import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
 
abstract class HuffmanTree implements Comparable<HuffmanTree> {
    public final int frequency; // the frequency of this tree
    public HuffmanTree(int freq) { frequency = freq; }
 
    // compares on the frequency
    public int compareTo(HuffmanTree tree) {
        return frequency - tree.frequency;
    }
}
 
class HuffmanLeaf extends HuffmanTree {
    public final char value; // the character this leaf represents
 
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        value = val;
    }
}
 
class HuffmanNode extends HuffmanTree {
    public final HuffmanTree left, right; // subtrees
 
    public HuffmanNode(HuffmanTree l, HuffmanTree r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}
 
public class Huffman {
	public static char[] characters= new char[1000];
	public static String[] codes=new String[1000];
	static int i=0;
    // input is an array of frequencies, indexed by character code
    public static HuffmanTree buildTree(int[] charFreqs) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char)i));
 
        assert trees.size() > 0;
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();
 
            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }
 
    public static void printCodes(HuffmanTree tree, StringBuffer prefix) {
    	
    	
        assert tree != null;
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;            
            // print out character, frequency, and code for this leaf (which is just the prefix)
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + prefix);
            characters[i]=leaf.value;
            codes[i]=prefix.toString();
            i++;
 
        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;
 
            // traverse left
            prefix.append('1');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);
 
            // traverse right
            prefix.append('0');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
 
    public static void main(String[] args) throws Exception {
    	int j=0;
    	String result;
        int[] charFreqs = new int[10000];
        char c[] = new char[100000];
        FileReader fr = new FileReader("kala.txt");
        BufferedReader br = new BufferedReader(fr);
        br.read(c);
        FileWriter fw1=new FileWriter("result.txt");
        fw1.write("");
        fw1.close();
       
        for(int i = 0; i < c.length; i++)
        {
        	if(c[i]!='\0')
        	
        	 charFreqs[c[i]]++;
             //Do stuff here
        	
        }
        // we will assume that all our characters will have
        // code less than 256, for simplicity
       
        // read each character and record the frequencies            
        // build tree
        HuffmanTree tree = buildTree(charFreqs);
        System.out.println("CHAR\tFREQ\tHUFFMAN CODE");
        printCodes(tree, new StringBuffer()); 
        FileReader fr1 = new FileReader("kala.txt");
        BufferedReader br1 = new BufferedReader(fr1);
        br1.read(c);
       
        for(int i = 0; i < c.length; i++)
        {
        	if(c[i]!='\0')
        	{
        		for(int k=0;k<characters.length;k++)
        		{
        			if(c[i]==characters[k])
        			{
        				j=k;       	
        				
        			}
        		}
        		result=codes[j];       		
        		try
        		{
        		    String filename= "result.txt";
        		    FileWriter fw = new FileWriter(filename,true);
        		    BufferedWriter bw= new BufferedWriter(fw);//the true will append the new data
        		    bw.write(result.toString());
        		     bw.close();//appends the string to the file
        		    fw.close();
        		}
        		catch(IOException ioe)
        		{
        		    System.err.println("IOException: " + ioe.getMessage());
        		}
        	}
}

    }
}