import java.util.*;

class Node{
	/*
	 * This class is using in question 2
	 * */
	int value;
	Node left;
	Node right;
	public Node(int value, Node left, Node right){
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class BitTitan {
	
	/*
	 * Main function load the test cases and execute the solution 
	 * Method one, two, three are corresponding to solution for questions 1, 2, 3 in coding practice
	 * Please refer to question comment for solution and complexity explanation 
	 * */
	public static void main (String[]args){
		BitTitan question = new BitTitan();
		question.one();
		question.two();
		question.three();		
	}
	
	/*
	 * Run test cases for question 1
	 * */
	void one(){		
		System.out.println("===Test cases for question 1 (Check Permutation):");
		System.out.println("1.0 Success case 'abc' and 'bac' : " + isPermutation("abc", "bac"));
		System.out.println("1.0 Success case: 'ab1c' and '1bac' :" + isPermutation("ab1c", "1bac"));
		System.out.println("1.0 Success case: 'abc11' and 'ba11c' :" + isPermutation("abc11", "ba11c"));
		System.out.println("1.1 One input is null 'abc' and null: " + isPermutation("abc", null));
		System.out.println("1.2 Two inputs have different length 'abc' and 'abcd': " + isPermutation("abc", "abcd"));
		System.out.println("1.3 Two inputs have same length but different characters 'abc' and 'ab1' : " + isPermutation("abc", "ab1"));
	}
	/*
	 * Run test cases for question 2
	 * */
	void two(){		
		System.out.println("===Test cases for question 2 (Create minimal height BST):");
		int[] input1 = {1,2,3,4,5};
		System.out.print("1.0 Pre Order tree from (1, 2, 3, 4, 5): ");
		printTree(BSTNode(input1, 0, input1.length-1));
		System.out.println();
		
		int[] input2 = {10, 25, 30, 31, 32, 33, 36, 99};
		System.out.print("1.1 Pre Order tree from (10, 25, 30, 31, 32, 33, 36, 99): ");
		printTree(BSTNode(input2, 0, input2.length-1));
		System.out.println();
	}
	
	/*
	 * Run test cases for question 3
	 * */
	void three(){		
		System.out.println("===Test cases for question 3 (Number ways of coin change):");
		int[] input1 = {1,2,3};
		System.out.println("1.0 Number of ways to change 4 coins from {1,2,3}: " + coinWaysChange(4, input1));
		int[] input2 = {2,3};
		System.out.println("1.1 Number of ways to change 4 coins from {2,3}: " + coinWaysChange(4, input2));
	}
	
	/*
	 * Given two strings, write a method to decide if one is a permutation of the other.
	 * 	 
	 * * 
	 * Solution:
	 * 1. Two String must have same length, otherwise they are not permutation of each other.
	 * 2. Total number of each unique characters in two string are equal. Eg: 2'a', 4'b'
	 * 	- Can use array if limited characters is presented. Eg: ASCII, ...
	 *  - Better use HashMap since we there is no limitation for the character in string.    
	 * *
	 * Complexity:
	 * - O(n) for complexity since we need to read all n characters from s1 and s2.
	 * - O(n) for space since we need to store all characters, in case all characters are unique.
	 * - n is the length of the input string
	 * */
	boolean isPermutation(String s1, String s2){
		// handle exception
		if (s1 == null || s2 == null)
			return false;
		// different length
		if (s1.length() != s2.length())
			return false;		
		// same length
		// store all s1 characters into hashmap dictionary, format <key, total occurrence>
		HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
		for (int i=0; i<s1.length(); i++){
			char cur = s1.charAt(i);
			// if the current character is not in dictionary
			if (!dict.containsKey(cur)){
				dict.put(cur, 1);
			}else{
				// if the current character is already in dictionary
				// plus one to the total occurrence
				int old_value = dict.get(cur);
				dict.put(cur, old_value + 1);
			}
		}
		// travel to each character in s2, reduce one when meet the character in the dictionary
		// if meet new character in dictionary, return false
		for (int i=0; i<s2.length(); i++){
			char cur = s2.charAt(i);
			// if the current character is not in dictionary
			if (!dict.containsKey(cur)){
				return false;
			}else{
				// if the current character is already in dictionary
				int old_value = dict.get(cur);
				if (old_value == 1){
					// remove the character from dictionary
					dict.remove(cur);
				}else{
					// reduce 1 in total occurrences
					dict.put(cur, old_value - 1);
				}				
			}
		}
		return true;
	}
	
	/*
	 * Given a sorted (in increasing order) array with unique integer elements
	 * write an algorithm to create a binary search tree with minimal height.
	 * 
	 * * Solution:
	 * BST with minimal height: 
	 * 1. Make sure in one node we have both node right and left => Always choose the middle element in sorted array
	 * 2. left < node < right => All the element in the left of middle element will be node left, right elements will be node right
	 * 3. Unique Integer elements => in BST node, we don't need to have other pointer to keep track identical elements
	 * 
	 * * Complexity
	 * O(n), cause we need to transverse the whole arrays
	 * left elements of the middle to the left
	 * right elements of the middle to the right      
	 * */
	 Node BSTNode(int[] sorted, int start, int end){
		 if (start > end)
			 return null;
		 int mid = start + (end-start)/2;
		 int cur_value = sorted[mid];
		 Node left = BSTNode(sorted, start, mid-1);
		 Node right = BSTNode(sorted, mid+1, end);
		 Node cur_root = new Node(cur_value, left, right);
		 return cur_root;
	 }
	 
	 /*
	  * This function is to print the tree Pre Order, for debugging
	  * */
	 void printTree(Node root){
		 if (root == null)
			 return;
		 System.out.print(root.value+" ");
		 printTree(root.left);		 
		 printTree(root.right);
	 }
	 /*Given a value N, if we want to make change for N cents, and we have infinite 
	  * supply of each of S = {S1, S2, .. , Sm} valued coins, how many ways can we make the change? 
	  * The order of coins doesn’t matter.
	  *
	  * * Solution
	  * for a given coin 0..N, a set of coins from 0..m
	  * we can either use the coin mth to exchange or not using it 
	  * so the number of way to exchange = (not use mth coin) + (use mth coin)
	  * * Complexity
	  * O(mN)since we need to compute for each coin set and each value from 0...N
	  * O(mN) space too 
	  * */
	 int coinWaysChange(int N, int[] coins){		 
		 int m = coins.length;
		 int[][] number_ways_change = new int[N+1][m];
		 
		 for (int i=0; i<m; i++){
			 // there is always a way to exchange 0 money with whatever set of coins 
			 number_ways_change[0][i] = 1;
		 }
		
		 for (int i=1; i<N+1; i++){
			 //for each given coin: i
			 for (int j=0; j<m; j++){
				 // for each coin set from 0...m-1: j
				 int use_this_coin = 0;
				 // can only exchange with coin has greater value than i
				 // if using jth coin-> go back to problem with i - jth coins value and coin set from 0...j
				 if (coins[j] <= i)				
					 use_this_coin = number_ways_change[i-coins[j]][j];				 
				 // if not using jth coin -> go back to problem with i coins value and coin set from 0...j-1
				 int not_use_this_coin = 0;
				 if (j>0)
					 not_use_this_coin = number_ways_change[i][j-1];
				 // get the result
				 number_ways_change[i][j] =  use_this_coin + not_use_this_coin;
			 }
		 }		 
		 return number_ways_change[N][m-1];
	 }
}
