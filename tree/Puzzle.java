import java.util.*;

public class Puzzle{

	public static void main(String[]args){
		Node a0 = new Node(0, null, null);
		Node a1 = new Node(4, null, null);
		Node a2 = new Node(5, null, null);
		Node a3 = new Node(6, null, null);
		Node a4 = new Node(7, null, null);
		Node b1 = new Node(2, a1, a2);
		Node b2 = new Node(3, a3, a4);
		Node c1 = new Node(1, b1, b2);

		Node a5 = new Node(6, null, null);
		Node a6 = new Node(5, null, a5);
		Node a7 = new Node(4, null, a6);		
		Node b3 = new Node(2, null, a7);
		Node b4 = new Node(3, null, null);
		Node c2 = new Node(1, b3, b4);

		lowest_common_parent(a1, a3, c1);
		System.out.println();
		lowest_common_parent(a0, a3, c1);
		System.out.println();
		lowest_common_parent(a7, a5, c2);
		System.out.println();
	}

	public static void lowest_common_parent (Node a, Node b, Node root){
		Stack<Node> parent_list_a = new Stack<Node>();	
		Stack<Node> parent_list_b = new Stack<Node>();	

		is_parent(a, root, parent_list_a);
		is_parent(b, root, parent_list_b);

		if (parent_list_a.isEmpty() || parent_list_b.isEmpty()){
			// There is no node a or b in the tree
			System.out.println("BOO!");
			return;
		}

		Node last_match = null;

		while(!parent_list_a.isEmpty() && !parent_list_b.isEmpty()){
			Node cur_a = parent_list_a.pop();
			Node cur_b = parent_list_b.pop();
			if ( cur_a == cur_b ){
				last_match = cur_a;
			}
			else{
				break;
			}
		}

		System.out.println("Lowest Common Parent: " + last_match.data);
	}

	// return the curent is parent of noda data
	public static boolean is_parent (Node data, Node cur, Stack<Node> parent_list){
		if (cur == null)
			return false;
		if (cur == data){
			parent_list.push(cur);
			return true;
		}
		boolean result = is_parent(data, cur.left, parent_list) || is_parent(data, cur.right, parent_list);
		if (result){
			parent_list.push(cur);
		}
		return result;
	}

}