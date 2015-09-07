import java.util.*;

public class MergeSort{

	static int[] input = {17, 1, 2, 1, 2, 2, 2, 1, 1, 3, 3, 3, 1, 2, 2, 2, 2, 0};
	static int[] output = new int[input.length];

	public static void main(String[]args){
		System.out.println("Input: " + Arrays.toString(input));		
		mergesort(0, input.length-1);
		System.out.println("MergeSort: " + Arrays.toString(input));
	}

	public static void mergesort(int low, int high){
		if (low<high){
			int mid = low + (high-low)/2;
			mergesort(low, mid);
			mergesort(mid+1, high);
			merge(low, mid, high);
		}
	}

	public static void merge(int low, int mid, int high){
		for (int i=low; i<high+1; i++){
			output[i] = input[i];
		}		
		int index = low;
		int i = low;
		int j = mid+1;

		while(i<=mid && j<=high){
			if (output[i] < output[j]){
				input[index] = output[i];
				i++;
			}else{
				input[index] = output[j];
				j++;
			}
			index++;
		}

		while(i<=mid){
			input[index] = output[i];
			index++;
			i++;
		}

		while(j<=high){
			input[index] = output[j];
			index++;
			j++;
		}
	}
}