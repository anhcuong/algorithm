import java.util.*;

class parenthesis{

	public static void main(String[]args){
		// Check if given string is balanced parenthesis
		// System.out.println(isBalance(")("));
		// System.out.println(isBalance("()"));
		// System.out.println(isBalance("())("));
		// System.out.println(isBalance("(()())("));
		// System.out.println(isBalance("()()()())("));
		// System.out.println(isBalance("[()(()()())]"));
		// System.out.println(isBalance("[({})]"));
		// System.out.println(isBalance("[({)}]"));
		// System.out.println(isBalance("[{(1)}]"));

		// Print all valid n-pairs balanced parenthesis 
		printBalanceParenthesis(2);
		printBalanceParenthesis(3);
		printBalanceParenthesis(1);
		printBalanceParenthesis(4);
	}

	public static boolean isBalance(String a){
		// Setup symbol lookup 
		HashMap<Character, Character> dict = new HashMap<Character, Character>();
		dict.put('(', ')');
		dict.put('[', ']');
		dict.put('{', '}');
		Stack<Character> s = new Stack<Character>();
		int n = a.length();
		for (int i=0; i<n; i++){
			char cur_char = a.charAt(i);						
			if (dict.containsKey(cur_char)){
				s.push(cur_char);
			}else{
				if (s.isEmpty())
					return false;
				else{					
					if (!dict.containsValue(cur_char)) continue;
					char popped = s.pop();
					if (dict.containsKey(popped)){
						if (dict.get(popped) != cur_char)
							return false;
					}
				}
			}
		}		
		return s.isEmpty();
	}

	public static void printBalanceParenthesis(int n){
		System.out.println("====="+n+"=====");
		char[] result = new char[2*n];
		printParenthesis(n, n, 0, result);
	}

	public static void printParenthesis(int open, int close, int count, char[] result){

		if (open<0)
			return;
		if (close<open)
			return;
		if (open==0 && close ==0){
			System.out.println(result);
		}else{
			if (open>0){
				result[count] = '(';
				printParenthesis(open-1, close, count+1, result);
			}
			if (close>0){
				result[count]=')';
				printParenthesis(open, close-1, count+1, result);
			}
		}
	}
}