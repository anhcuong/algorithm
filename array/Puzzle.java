import java.util.*;

public class Puzzle {
	
	public static void main(String[]args){
		int[] input = {2, 3, 10, 6, 4, 8, 1};				
		int[] input2 = {7, 9, 5, 6, 3, 2};		
		int[] input3 = {16, 17, 4, 3, 5, 2};
		int[] input4 = {3, 2, 7, 10};
		int[] input5 = {3, 2, 5, 10, 7};
		int[] input6 = {3, 4, 5, 1, 2};
		int[] input7 = {2, 4, 5, 6, 7, 1, 2};

		System.out.println("Max Diff Input 1: ");
		System.out.println(max_diff(input));				
		
		System.out.println("Max Diff Input 2: ");
		System.out.println(max_diff(input2));

		System.out.println("Max Diff Input 3: ");
		System.out.println(max_diff(input3));

		System.out.println("Leader Input 1: ");
		print_leaders(input);

		System.out.println("Leader Input 2: ");
		print_leaders(input2);

		System.out.println("Leader Input 2: ");
		print_leaders(input3);

		System.out.println("max_sum_no_adj Input 1: ");
		System.out.println(max_sum_no_adj(input));				
		
		System.out.println("max_sum_no_adj Input 2: ");
		System.out.println(max_sum_no_adj(input2));

		System.out.println("max_sum_no_adj Input 3: ");
		System.out.println(max_sum_no_adj(input3));

		System.out.println("max_sum_no_adj Input 4: ");
		System.out.println(max_sum_no_adj(input4));

		System.out.println("max_sum_no_adj Input 5: ");
		System.out.println(max_sum_no_adj(input5));

		System.out.println("search_in_sorted_and_pivoted Input 6: ");
		System.out.println(search_in_sorted_and_pivoted(input6, 2));

		System.out.println("search_in_sorted_and_pivoted Input 7: ");
		System.out.println(search_in_sorted_and_pivoted(input7, 2));
	}
	
	/*
	Maximum difference between two elements such that larger element 
	appears after the smaller number
	*/
	static int max_diff(int[] input){
		int n = input.length;
		int max_dif_so_far = 0;
		int min_so_far = input[0];

		for (int i=0; i<n; i++){
			int cur = input[i];			
			max_dif_so_far = Math.max(max_dif_so_far, cur - min_so_far);
			min_so_far = Math.min(min_so_far, cur);
		}

		return max_dif_so_far;
	}

	/*
	Write a program to print all the LEADERS in the array. 
	An element is leader if it is greater than all the elements to its right side. And the rightmost element is always a leader. 
	For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
	*/

	static void print_leaders(int[] input){
		int n = input.length;
		if (n==0) return;
		int max_so_far = Integer.MIN_VALUE;
		for (int i=n-1; i>=0; i--){
			if (input[i] > max_so_far){
				//this is the leader
				System.out.print(input[i]+" ");
				max_so_far = input[i];
			}
		}
		System.out.println();
	}

	/*Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers 
	in the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or
	 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.
	*/

	static int max_sum_no_adj(int[] input){
	 	int max_sum = Integer.MIN_VALUE;
	 	int n = input.length;
	 	if (n ==0 ) return -1;
	 	int max_include = input[0];
	 	int max_exclude = 0;
	 	int tmp = 0;

	 	for (int i=1; i<n; i++){
	 		tmp = max_include;
	 		max_include = max_exclude + input[i];
	 		max_exclude = Math.max(max_exclude, tmp);	 		
	 	}
	 	max_sum = Math.max(max_exclude, max_include);
	 	return max_sum;
	 }

	 /*
	Search an element in a sorted and pivoted array
	So for instance, 1 2 3 4 5 might become 3 4 5 1 2
	 */
	static int search_in_sorted_and_pivoted(int[] input, int target){
		int index = 0;
		int pivot = find_pivot(input, 0, input.length-1);
		System.out.println(pivot);
		return index;
	}	

	static int find_pivot(int[] input, int l, int h){
		
	}
}