import java.util.*;

public class BinarySearch{

	static int[] input = {1, 1, 2, 8, 28, 34, 291, 293, 999};

	public static void main(String[]args){
		System.out.println(find(34, 0, input.length-1));
		System.out.println(find(30, 0, input.length-1));
		System.out.println(find(10, 0, input.length-1));
	}

	static int find(int x, int low, int high){				
		if (low<high){
			int mid = low + (high-low)/2;
			if (x == input[mid]){
				return mid;
			}
			if(x<input[mid]){
				return find(x, low, mid);
			}else{
				return find(x, mid+1, high);
			}
		}
		return -1;
	}		
}