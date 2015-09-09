import java.util.*;

class Node{
	int data;
	Node next;
	public Node(int data){
		this.data = data;
	}
}

public class Puzzle {
	
	public static void main(String[]args){
		Node head = new Node(1);
		Node a2 = new Node(2);
		Node a3 = new Node(3);
		Node a4 = new Node(4);
		Node a5 = new Node(5);
		Node a6 = new Node(6);
		Node a7 = new Node(7);
		Node a8 = new Node(8);
		head.next = a2;
		head.next.next = a3;
		head.next.next = a4;
		head.next.next.next = a5;
		head.next.next.next.next = a6;
		head.next.next.next.next.next = a7; 
		head.next.next.next.next.next.next = a8;


		System.out.println("Reverse every 2 nodes: ");
		reverse_every_kth_node(head, 2);
		System.out.println("Reverse every 3 nodes: ");
		reverse_every_kth_node(head, 3);
	}

	static Node reverse_every_kth_node(Node head, int k){
		if (head == null) return;
		Node cur = head;		
		Node before = null;
		Node next = null;
		int count = 0;
		
		while (cur != null & count < k)			
			next = cur.next;
			cur.next = before;
			before = cur;
			cur = next;
		}
		
		if (cur != null){
			head.next = reverse_every_kth_node(cur, k);
		}

		return before;
	}


}