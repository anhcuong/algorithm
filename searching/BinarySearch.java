import java.util.*;

public class BinarySearch{

	static int[] input = {1, 1, 2, 8, 28, 34, 291, 293, 299, 999};

	public static void main(String[]args){
		System.out.println(find(34, 0, input.length-1));
		System.out.println(find(30, 0, input.length-1));
		System.out.println(find(10, 0, input.length-1));

		System.out.println(onesided_find(34));
		System.out.println(onesided_find(30));
		System.out.println(onesided_find(10));
		System.out.println(onesided_find(291));
		System.out.println(onesided_find(999));
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

	static int onesided_find(int x){

		int m = 0;
		int index = 0;
		while(true){
			try{
				//try get the item at 2^m
				index = (int)Math.pow(2, m);				
				int cur = input[index];
				if (cur == x){
					return index;
				}else if (cur > x){
					// search from 2^(m-1) -> 2^m					
					return find_with_care(x, (int)Math.pow(2, m-1), index);
				}else{
					m = m + 1;
				}
			}catch(ArrayIndexOutOfBoundsException e){
				//if got error -> alredy exceed the limit
				// search from 2^(m-1) -> 2^, with care of null pointer
				return find_with_care(x, (int)Math.pow(2, m-1), index);
			}	
		}		
	}

	static int find_with_care(int x, int low, int high){				
		if (low<high){			
			try{
				int mid = low + (high-low)/2;
				if (x == input[mid]){
					return mid;
				}
				if(x<input[mid]){
					return find_with_care(x, low, mid);
				}else{
					return find_with_care(x, mid+1, high);
				}
			}catch(ArrayIndexOutOfBoundsException e){
				return find_with_care(x, low, high-1);
			}
		}
		return -1;
	}
}