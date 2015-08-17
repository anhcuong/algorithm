import java.util.*;
import java.io.*;

class quick_sort{
	
	/* main function */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("testcases"));
			int test_case = sc.nextInt();

			for (int j = 0; j < test_case; j++){
				
				int num = sc.nextInt();
				int[] input = new int[num];
				//read input
				for (int i = 0; i < num; i++){
					input[i] = sc.nextInt();
				}

				System.out.println("Input: " + Arrays.toString(input));
				//sort input using quicksort
				int[] output = new int[num];

				quicksort(input, 0, num-1, output);
				//print output after sorting
				System.out.println("Output: " + Arrays.toString(output));
			}
		}catch(Exception e){

		}
	}
	//merge sort
	static void quicksort(){
		
	}
}