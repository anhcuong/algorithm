import java.util.*;
import java.io.*;

class merge_sort{
	
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

				mergesort(input, 0, num-1, output);
				//print output after sorting
				System.out.println("Output: " + Arrays.toString(output));
			}
		}catch(Exception e){

		}
	}
	//merge sort
	static void mergesort(int[] input, int start, int end, int[] output){
		//System.out.println("in ra cho bo may");

		//in case there is less or equal than 1 item in list, just return
		if (start >= end){
			return;
		}

		//when have more than 1
		int mid = start + (end - start)/2;
		mergesort(output, start, mid, input);
		mergesort(output, mid+1, end, input);
		// merge the array start->mid and mid+1->end into 1 sorted array output from start->end
		merge(input, start, mid, end, output);
	}

	//merge 2 array into 1 in sorted order
	static void merge(int[] input, int start, int mid, int end, int[] output){

		int i = start, j = mid+1;
		int cur = start;
		
		while(i <= mid && j <=end){
			if (input[i] <= input[j]){
				output[cur] = input[i];
				i = i + 1;
			}else{
				output[cur] = input[j];
				j = j + 1;
			}
			cur = cur + 1;
		}

		while (i <= mid){
			output[cur] = input[i];
			cur = cur + 1;
			i = i + 1;
		}

		while (j <= end){
			output[cur] = input[j];
			cur = cur + 1;
			j = j + 1;
		}
	}
}