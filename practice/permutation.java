import java.util.*;

public class permutation{
	
	static HashSet<String> permuDict = new HashSet<String>();

	public static void main(String[]args){
		// Check whether 2 strings are permutation
		System.out.println(isPermu("abc", "cba"));
		System.out.println(isPermu("abc", "cba1"));
		System.out.println(isPermu("abc", "bca"));
		System.out.println(isPermu("abc", "aba"));
		System.out.println(isPermu("abcc", "cbca"));

		// Print all permuatation of a given string, without duplicate		
		// Using hashmap
		printPermuHash("abc");
		printPermuHash("aa");
		printPermuHash("aac");
		// Not using hashmap
		printPermu("abc");
		printPermu("aa");
		printPermu("aac");
		printPermu("132");
		printPermu("112");
	}

	public static boolean isPermu(String a, String b){
		int n = a.length();
		int m = b.length();

		if (n!=m)
			return false;
		// Compare frequency of unique characters in string a and b
		HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
		// Count number of occurences in string a
		for (int i=0; i<n; i++){
			char cur_char = a.charAt(i);
			if (dict.containsKey(cur_char)){
				dict.put(cur_char, dict.get(cur_char)+1);
			}else{
				dict.put(cur_char, 1);
			}

		}
		// Remove number of occurences from dict a when counting string b
		for (int i=0; i<n; i++){
			char cur_char = b.charAt(i);
			if (!dict.containsKey(cur_char)){
				return false;
			}else{
				if (dict.get(cur_char) == 0){
					return false;
				}else{
					dict.put(cur_char, dict.get(cur_char)-1);
				}
			}
		}
		return true;
	}

	public static void printPermu(String a){
		// Sort the string first
		char[] chars = a.toCharArray();
		Arrays.sort(chars);
		String sorted = new String(chars);
		System.out.println(a + ":====" + sorted + "====: Without HashMap");
		printPermuWithoutHash("", sorted);
	}

	public static void printPermuHash(String a){
		System.out.println("========" + a + "========");
		printPermuWithHash("", a);
		for (String result: permuDict){
			System.out.println(result);			
		}
		permuDict = new HashSet<String>();		
	}

	public static void printPermuWithHash(String prefix, String postfix){
		int n = postfix.length();
		if (n==0 && !permuDict.contains(prefix)){
			//Added the result
			permuDict.add(prefix);
		}else{
			for (int i=0; i<n; i++){
				char cur_char = postfix.charAt(i);
				String new_prefix = prefix + cur_char;
				String new_postfix = postfix.substring(0, i) + postfix.substring(i+1, n);
				printPermuWithHash(new_prefix, new_postfix);
			}
		}
	}

	public static void printPermuWithoutHash(String prefix, String postfix){
		int n = postfix.length();
		if (n==0){
			//Print the result
			System.out.println(prefix);
		}else{
			for (int i=0; i<n; i++){
				char cur_char = postfix.charAt(i);
				if (i>0 && cur_char == postfix.charAt(i-1)) continue;
				String new_prefix = prefix + cur_char;
				String new_postfix = postfix.substring(0, i) + postfix.substring(i+1, n);
				printPermuWithoutHash(new_prefix, new_postfix);
			}
		}
	}


}