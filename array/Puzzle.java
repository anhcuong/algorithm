import java.util.*;

public class Puzzle {
	
	public static void main(String[]args){
		int[] input = {2, 3, 10, 6, 4, 8, 1};				
		
		System.out.println("Max Diff Input 1: ");
		System.out.println(max_diff(input));

		int[] input2 = {7, 9, 5, 6, 3, 2};				
		
		System.out.println("Max Diff Input 2: ");
		System.out.println(max_diff(input2));

		
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
}