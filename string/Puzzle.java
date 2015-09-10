import java.util.*;

public class Puzzle{

	public static void main(String[]args){
		System.out.println("longest substring without repeating characters: ");
		System.out.println("Input: ABDEFGABEF");
		System.out.println(longest_substr_without_repeat("ABDEFGABEF"));
		System.out.println("Input: AAAAAAAAAA");
		System.out.println(longest_substr_without_repeat("AAAAAAAAAA"));
		System.out.println("Input: ABBDEFG");
		System.out.println(longest_substr_without_repeat("ABBDEFG"));
		System.out.println("Input: ABDEFG");
		System.out.println(longest_substr_without_repeat("ABDEFG"));
	}

	//Given a string, find the longest substring without repeating characters
	static int longest_substr_without_repeat(String s){
		int n = s.length();
		int max_length_so_far = 0;
		int cur_len = 0;
		// store the previous position of given character 
		HashMap <Character, Integer> map = new HashMap<Character, Integer>();

		for (int i=0; i<n; i++){
			char cur = s.charAt(i);
			
			if (!map.containsKey(cur)){
				//1st time character 
				cur_len ++;
			}else {
				// not the first time
				int last_appear = map.get(cur);
				if (last_appear < i - cur_len){
					//not in the considering substring
					cur_len ++;
				}else{
					// in considering substring
					// shift the considering substring by 1
					max_length_so_far = Math.max(cur_len, max_length_so_far);
					cur_len = i - last_appear;
				}
			}
			// update last index visit
			map.put(cur, i);
			max_length_so_far = Math.max(cur_len, max_length_so_far);
		}
		return max_length_so_far;
	}
}