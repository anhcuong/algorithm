import java.util.*;

class Interval{
	int start;
	int end;

	public Interval(int start, int end){
		this.start = start;
		this.end = end;
	}

	public String toString(){
		return "[" + this.start + "," + this.end + "]";
	}
}

class MergeInterval{

	public static void main (String []args){
		Interval i1 = new Interval (1, 3);
		Interval i2 = new Interval (2, 4);
		Interval i3 = new Interval (5, 7);
		Interval i4 = new Interval (6, 8);

		Interval[] input = {i1, i3, i2, i4};
		print_merged_interval(input);
	}

	public static void print_merged_interval(Interval[] input){
		System.out.println("Input: " + Arrays.toString(input));
		Arrays.sort(input, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				return i1.start - i2.start;
			}
		}
		);
		System.out.println("Sorted Input: " + Arrays.toString(input));

		Stack<Integer> s = new Stack<Integer>();		

		for (int i = 0; i < input.length; i++){
			Interval cur = input[i];

			if (s.isEmpty()){
				s.push(cur.start);
				s.push(cur.end);
			}else{
				if (cur.start > s.peek()){
					s.push(cur.start);
					s.push(cur.end);	
				}else{
					int prev_end = s.pop();
					s.push(Math.max(prev_end, cur.end));
				}
			}
		}
		String result = "";
		while(!s.isEmpty()){
			result = s.pop() + " " + result;
		}
		System.out.println("Result: " + result);
	}

}