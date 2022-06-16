package ajain5.HW4;

import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.StdRandom;

/** Copy to your USERID.hw4 package and make changes. */
public class Counting {
	
	/**
	 * This skeletal structure needs to be modified to solve this problem. Feel free to add code anywhere...
	 */
	public static void main(String[] args) {
		System.out.println("N\tMaxAVHt\tMaxAVDp\tMaxAVZr\tAVZero%\tMaxRBHt\tMaxRBDp\tMaxRBZr\tRBZero%");
		
		
		for (int N = 32; N <= 262144; N*= 2) {
			
			int NUMTRIAL= 100;
			
			int MaxZAVL = 0;
			int MaxZRB = 0;
			int MaxdepthdiffAVL = 0;
			int MaxdepthdiffRB = 0;
			int MaxheightAVL = 0;
			int MaxheightRB = 0;
			double percentAVL = 0.0;
			double percentRB = 0.0;
					
			for (int T = 0; T < NUMTRIAL; T++) {
				
				// This constructs the array of N-1 values (where N is a power of 2) and 
				// it uses StdRandom.setSeed() to ensure all students will get the same result
				int[] vals = new int[N-1];
				for (int i = 0; i < N-1; i++) {
					vals[i] = i+1;
				}
				StdRandom.setSeed(T);
				StdRandom.shuffle(vals);
				
				int heightDiffZeroAVL = 0;
				int depthDiffAVL = 0;
				
				int heightDiffZeroRB = 0;
				int depthDiffRB = 0;
				
				int heightAVL = 0;
				int heightRB = 0;
				
				SeparateChainingHashST<Integer, Integer> htAVL = new SeparateChainingHashST<>();
				SeparateChainingHashST<Integer, Integer> htRB = new SeparateChainingHashST<>();
			//	AVL<Integer> x = new AVL<>();
				
				// note: Insert the integers in vals into a new AVL or RedBlack Tree in order from left to right
				
				// MORE TO DO HERE...
				AVL Avltree = new AVL();
				
				for(int i = 0;i < vals.length; i++) {
					Avltree.insert(vals[i]);
				}
				
				
				//heightAVL
				heightAVL = Avltree.height();
				
				if(heightAVL > MaxheightAVL) {
					MaxheightAVL = heightAVL;
				}
				
				//zero count AVL
				htAVL = Avltree.counts(); 
				heightDiffZeroAVL = htAVL.get(0);
				
				if(heightDiffZeroAVL > MaxZAVL) {
					MaxZAVL = heightDiffZeroAVL;
				}
				//depth diff AVL
				depthDiffAVL = Avltree.height()- Avltree.minDepth();
				if(depthDiffAVL > MaxdepthdiffAVL) {
					MaxdepthdiffAVL = depthDiffAVL;
				}
				
				RedBlackBST RBBST = new RedBlackBST();
				
				for(int i = 0;i < vals.length; i++) {
					RBBST.put(vals[i],vals[i]);
				}
				
				
				//height RB
				heightRB = RBBST.height();
				
				if(heightRB > MaxheightRB) {
					MaxheightRB = heightRB;
				}
				
				//zero count RB
				htRB = RBBST.counts(); 
				heightDiffZeroRB = htRB.get(0);
				
				if(heightDiffZeroRB > MaxZRB) {
					MaxZRB = heightDiffZeroRB;
				}
				//depth diff RB
				depthDiffRB = RBBST.height()- RBBST.minDepth();
				if(depthDiffRB > MaxdepthdiffRB) {
					MaxdepthdiffRB = depthDiffRB;
				}
			}
			percentAVL = ((double) (MaxZAVL)) / (N-1) *100;
			percentRB = ((double) (MaxZRB) / (double) (N-1)) *100;
			
			String PercentAVL = String.format("%.3f", percentAVL);
			String PercentRB = String.format("%.3f", percentRB);
			
			System.out.print(N-1 + "\t"+ MaxheightAVL + "\t" + MaxdepthdiffAVL + "\t" + MaxZAVL + "\t" + PercentAVL+ 
					"\t"+ MaxheightRB + "\t" + MaxdepthdiffRB + "\t" + MaxZRB + "\t" + PercentRB);
			System.out.println();
					
		}
	}
}


