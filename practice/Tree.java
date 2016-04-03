import java.util.*;

class Node{
	Node left;
	Node right;
	int data;

	public Node(Node l, Node r, int d){
		left = l;
		right = r;
		data = d;
	}

	public String toString(){
		return "" + data;
	}
}

public class Tree{
	Node root;

	public Tree(Node root){
		this.root = root;
	}

	/*

	Tree 1:
               +-----+
               |  1  |
               |     |
          +----+-----+----+
          |               |
       +--v---+      +----v--+
       |      |      |       |
       |  2   |      |   3   +-----------+
       |      |      |       |           |
   +---+------+-+    +-----+-+           |
   |            |          |             |
+--v---+    +---v---+    +-v-----+   +---v--+
|      |    |       |    |       |   |      |
|  4   |    |   5   |    |   7   |   |   8  |
|      |    |       |    |       |   |      |
+------+    +-------++   +----+--+   +------+
                     |        |
                +----v--+ +---v---+
                |       | |       |
                |   6   | |   9   |
                |       | |       |
                +-------+ +-------+

	
	Tree 2:

	     +-----+
         |  1  |
         |     |
   +-----+-----+--------+
   |                    |
+--v--+              +--v--+
| 2   |              |  4  |
|     |              |     +----+
+--+--+              +-----+    |
   |    +-----+              +--v--+
   |    |  3  |              |   5 +-----+
   +---->     |              |     |     |
        +-----+              +-----+     |
                                      +--v--+
                                      |  6  |
                                      |     |
                                      +--+--+
                             +------+    |
                             |  7   <----+
                             |      |
                             +------+





	*/

	public static void main(String[]args){
		Node a6 = new Node(null, null, 6);
		Node a9 = new Node(null, null, 9);
		Node a4 = new Node(null, null, 4);
		Node a5 = new Node(null, a6, 5);
		Node a2 = new Node(a4, a5, 2);
		Node a7 = new Node(a9, null, 7);
		Node a8 = new Node(null, null, 8);
		Node a3 = new Node(a7, a8, 3);
		Node a1 = new Node(a2, a3, 1);

		Tree t1 = new Tree(a1);
		t1.findLCA(a4, a6);
		t1.findLCA(a4, a9);
		t1.findLCA(a5, a7);
		t1.findLCA(a7, a8);

		a3 = new Node(null, null, 3);
		a2 = new Node(null, a3, 2);
		a7 = new Node(null, null, 7);
		a6 = new Node(a7, null, 6);
		a5 = new Node(null, a6, 5);
		a4 = new Node(null, a5, 4);
		a1 = new Node(a2, a4, 1);

		Tree t2 = new Tree (a1);
		t2.findLCA(a2, a3);
		t2.findLCA(a2, a5);
		t2.findLCA(a7, a5);
		t2.findLCA(a3, a7);
	}
	// Find the lowest common ancestor of 2 nodes
	void findLCA(Node a, Node b){
		Stack<Node> q1 = new Stack<Node>();
		Stack<Node> q2 = new Stack<Node>();
		updateDadList(this.root, a, q1);
		updateDadList(this.root, b, q2);
		System.out.println(q1);
		System.out.println(q2);
		Node last = this.root;
		
		while (!q1.isEmpty() && !q2.isEmpty()){
			Node cur1 = q1.pop();
			Node cur2 = q2.pop();

			if (cur1.data == cur2.data){
				last = cur1;
			}else{
				break;
			}
		}

		System.out.println(last);
	}	

	// Find all the dads of a given node and put it into Queue
	boolean updateDadList(Node cur, Node a, Stack<Node> DadList){
		if (cur == null){
			return false;
		}
		if (cur.data == a.data){
			DadList.push(cur);
			return true;
		}
		if (updateDadList(cur.left, a, DadList) || updateDadList(cur.right, a, DadList)){
			DadList.push(cur);
			return true;
		}
		return false;
	}
}