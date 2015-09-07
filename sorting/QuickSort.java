import java.util.*;

public class QuickSort{	
	static int[] input = {17, 1, 2, 1, 2, 2, 2, 1, 1, 3, 3, 3, 1, 2, 2, 2, 2, 0};

	public static void main(String[]args){		
		System.out.println("Input: " + Arrays.toString(input));		
		quicksort(0, input.length-1);
		System.out.println("QuickSort: " + Arrays.toString(input));
	}

	public static void quicksort(int low,int high){		
		int random_index = (int)(low + new Random().nextInt(high-low));		
		int pivot = input[random_index];		
		int i = low;
		int j = high;

		while(i<=j){
			while(input[i]<pivot){
				i++;
			}
			while(input[j]>pivot){
				j--;
			}
			if (i<=j){
				swap(i, j);			
				i ++;
				j --;
			}
		}

		if (j>low){
			quicksort(low, j);
		}

		if (i<high){
			quicksort(i, high);
		}

	}

	public static void swap(int i, int j){
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}