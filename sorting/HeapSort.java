import java.util.*;

public class HeapSort{

	// static int[] input = {17, 1, 2, 1, 2, 2, 2, 1, 1, 3, 3, 3, 1, 2, 2, 2, 2, 0};	
	static int[] input = {8, 999, 293, 291, 28, 1, 2, 34, 1};
	public static void main(String[]args){
		System.out.println("Input: " + Arrays.toString(input));		
		heapsort();
		System.out.println("HeapSort: " + Arrays.toString(input));
	}

	public static void heapsort(){
		int n = input.length;
		buildHeap();
		for (int i=n-1; i>=0;i--){
			System.out.println(Arrays.toString(input));
			swap(0, i);			
			maxheap(0, i-1);
		}
	}

	public static void swap(int i, int j){
		int temp = input[j];
		input[j] = input[i];
		input[i] = temp;
	}

	public static void buildHeap(){
		int n = input.length;
		for (int i=n/2; i>=0; i--){			
			maxheap(i, n-1);
		}
	}

	public static void maxheap(int start, int end){
		int parent = start;
		int left = 2*parent + 1;
		int right = 2*parent + 2;
		int max = parent;

		if (left <= end && input[parent]<input[left]){			
			max = left;
		}

		if (right <= end && input[max]<input[right]){			
			max = right;
		}

		if (max != parent){
			swap(parent, max);
			maxheap(max, end);
		}
	}
}