import java.util.*;

public class PreInPostfix{

	public static void main (String[]args){
		String infix1 = "(a+b-c)*(d-e)/(f-g+h)";
		String infix2 = "3+4*5/6";
		String infix3 = "(300+23)*(43-21)/(84+7)";
		String infix4 = "a+b*c-d";
		String infix5 = "a+b*c-d)";

		String postfix1_test = "a b + c - d e - * f g - h + / ";
		String postfix2_test = "3 4 5 * 6 / + ";
		String postfix3_test = " 300 23 + 43 21 - * 84 7 + / ";
		String postfix4_test = "a b c * + d - ";
		String postfix5_test = "CLGT";

		System.out.println(InfixToPostfix(infix1).equals(postfix1_test));
		System.out.println(InfixToPostfix(infix2).equals(postfix2_test));
		// System.out.println(InfixToPostfix(infix3) == postfix3_test);
		System.out.println(InfixToPostfix(infix4).equals(postfix4_test));
		System.out.println(InfixToPostfix(infix5).equals(postfix5_test));

		System.out.println(PostfixToInfix(postfix1_test) == infix1);
		System.out.println(PostfixToInfix(postfix2_test) == infix2);
		// System.out.println(PostfixToInfix(postfix3_test) == infix3);
		System.out.println(PostfixToInfix(postfix4_test) == infix4);


	}

	public static String InfixToPostfix(String infix){
		StringBuffer postfix = new StringBuffer();
		HashMap<Character, Integer> priority = new HashMap<Character, Integer>();
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('^', 3);
		priority.put('(', -1);						
		
		Stack<Character> s = new Stack<Character>();

		int n = infix.length();
		for (int i=0; i<n; i++){
			char cur = infix.charAt(i);
			if (cur == '('){
				// open bracket, push to stack
				s.push(cur);
			}else if (priority.containsKey(cur)){
				// this is operator
				int pri = priority.get(cur);
				while (!s.isEmpty() && priority.get(s.peek()) >= pri){
					postfix.append(s.pop() + " ");
				}
				s.push(cur);
			}else if (cur == ')'){
				// close bracket, pop the stack until get the open bracket				
				char popped = ' ';
				while (!s.isEmpty()){
					popped = s.pop();
					// stop when popped item is open bracket
					if (popped == '(') break;
					postfix.append(popped + " ");
				}
				// Cant find any open
				if (popped != '(')
					System.out.println("CL");
					return "FUCKING SHIT";
			}else{
				// this is operand
				// add to result string anw
				postfix.append(cur + " ");
			}			
		}

		while (!s.isEmpty()){
			// print all the contents in the stack
			postfix.append(s.pop()+" ");
		}

		System.out.println(postfix.toString());

		return postfix.toString();
	}

	public static String PostfixToInfix(String postfix){
		StringBuffer infix = new StringBuffer();
		HashSet<Character> operator = new HashSet<Character>();
		operator.add('+');
		operator.add('-');
		operator.add('*');
		operator.add('/');
		operator.add('^');		
		Stack<String> s = new Stack<String>();
		int n = postfix.length();
		for (int i=0; i<n; i++){
			char cur = postfix.charAt(i);
			if (cur == ' '){
				continue;
			}
			else if (operator.contains(cur)){
				// character is operator
				// check top 2 element of stack
				if (s.size() < 2){
					System.out.println("NCL");
					return "SHIT";
				}

				String right = s.pop();
				String left = s.pop();
				String rewrite = '(' + left + cur + right + ')';
				s.push(rewrite);
			}else{
				s.push(cur+"");
			}
		}

		while (!s.isEmpty()){
			infix.append(s.pop());
		}

		System.out.println("Infix: " + infix.toString());

		return infix.toString();
	}

}