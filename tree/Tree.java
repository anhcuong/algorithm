import java.util.*;

public class Tree {

	public static void main (String[]args){
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

		System.out.println("Print Verticle Order c1");
		print_verticle_order(c1);
		System.out.println();
		System.out.println("Print Verticle Order c2");
		print_verticle_order(c2);
		System.out.println();
		print_top_view(c1);
		System.out.println();
		print_top_view(c2);

		System.out.println();
		System.out.println("InOrder c1: ");
		InOrder(c1);

		System.out.println();
		System.out.println("InOrder c2: ");
		InOrder(c2);

		System.out.println();
		System.out.println("iter_inOrder c1:");
		iter_inOrder(c1);

		System.out.println();
		System.out.println("Iter InOrder 2: ");
		iter_inOrder(c2);

		System.out.println();
		System.out.println("PostOrder: ");
		PostOrder(c1);

		System.out.println();
		System.out.println("Iter PostOrder: ");
		iter_PostOrder(c1);

		System.out.println();
		System.out.println("Pre Order:");
		PreOrder(c1);

		System.out.println();
		System.out.println("Iter PreOrder: ");
		iter_PreOrder(c1);

		System.out.println();
		System.out.println("Print 3 Ancestor: ");
		ancestor(3, c1);
		System.out.println();
		System.out.println("Print 5 Ancestor: ");
		ancestor(5, c1);		

		System.out.println();
		System.out.println("Print 5 Ancestor: ");
		iter_ancestor(5, c1);

		System.out.println();
		System.out.println("Print 6 Ancestor : ");
		ancestor(6, c1);

		System.out.println();
		System.out.println("Print 6 Ancestor c2: ");
		ancestor(6, c2);

		System.out.println();
		System.out.println("Print 5 Ancestor c2: ");
		iter_ancestor(5, c2);

	}

	static void InOrder(Node cur){
		if (cur == null)
			return;
		InOrder(cur.left);
		System.out.print(cur.data+" ");
		InOrder(cur.right);
	}

	static void PostOrder(Node cur){
		if (cur == null)
			return;
		PostOrder(cur.left);		
		PostOrder(cur.right);
		System.out.print(cur.data+" ");
	}

	static void PreOrder(Node cur){
		if (cur == null)
			return;
		System.out.print(cur.data+" ");
		PreOrder(cur.left);		
		PreOrder(cur.right);		
	}

	static void iter_inOrder(Node cur){

		Stack <Node> s = new Stack<Node>();
		boolean done = false;

		while(!done){
			if (cur != null){
				s.push(cur);
				cur = cur.left;
			}else{
				if (s.isEmpty()){
					done = true;
				}
				else{
					Node backtrack = s.pop();
					System.out.print(backtrack.data + " ");
					cur = backtrack.right;
				}
			}
		}
	}

	static void iter_PreOrder(Node root){
		Stack <Node> s = new Stack<Node>();
		s.push(root);
		while(!s.isEmpty()){
			Node cur = s.pop();
			System.out.print(cur.data+" ");
			if (cur.right!= null) s.push(cur.right);
			if (cur.left != null) s.push(cur.left);			
		}
	}
	

	static void iter_PostOrder(Node root){
		Stack <Node> s1 = new Stack<Node> ();
		Stack <Node> s2 = new Stack<Node> ();
		s1.push(root);

		while(!s1.isEmpty()){
			Node cur = s1.pop();
			s2.push(cur);
			if (cur.left != null) s1.push(cur.left);
			if (cur.right != null) s1.push(cur.right);			
		}
		while(!s2.isEmpty()){
			System.out.print(s2.pop().data+" ");
		}		
	}

	static void print_verticle_order(Node root){
		Queue <Node> q = new LinkedList<Node>();
		HashMap <Node, Integer> map = new HashMap<Node, Integer>();
		q.add (root);
		map.put(root, 0);
		
		while(!q.isEmpty()){
			Node cur = q.remove();
			int d = map.get(cur);
			if (cur.left != null) {
				q.add(cur.left);
				map.put(cur.left, d-1);
			}
			if (cur.right != null) {
				q.add(cur.right);
				map.put(cur.right, d+1);
			}
		}
		HashSet <Integer> s = new HashSet<Integer>();
		for (int value: map.values()){			
			if (s.contains(value))
				continue;
			s.add(value);			
			for (Node node: map.keySet()){
				if (map.get(node) == value){
					System.out.print(node.data+" ");					
				}
			}
			System.out.println();
		}
	}

	static void print_top_view(Node cur){

	}

	static boolean ancestor(int data, Node root){
		if (root == null)
			return false;
		if (root.data == data)			
			return true;
		boolean result = ancestor(data, root.left) || ancestor (data, root.right);
		if (result)
			System.out.print(root.data + " ");
		return result;
	}

	static void iter_ancestor(int data, Node root){
		Stack <Node> s = new Stack<Node>();
		Node cur = root;
		
		while(true){
			while(cur != null || cur.data != data){
				//Push until see the target or reach end of branch
				s.push(cur);
				cur = cur.left;
			}

			//either see target or end of branch
			
			if (cur !=null && cur.data == data){
				//see target
				break;
			}

			//cur is null
			if (!s.isEmpty()){
				if (s.peek().right == null){
					//left is null, now right also null, keep for what
					s.pop();
				}
			} 

		}

		//print the result from stack
		if (s.isEmpty()){
			System.out.println("No item in tree");
		}else{
			while(!s.isEmpty()){
				System.out.print(s.pop()+" ");
			}
		}
	}

}