package java.com.hipsandy.ds;

public class MyLinkedList {
	
	private Node head;
	private int size;
	
	MyLinkedList(int val) {
		this.head = new Node(val);
		this.size = 1;
	}
	
	public void add(int x) {
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = new Node(x);
		size += 1;
	}
	
	public Node find(int x) {
		Node n = head;
		while (n != null) {
			if (n.val == x) {
				return n;
			}
			n = n.next;
		}
		return null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean remove(int x) {
		if (head == null) {
			throw new IllegalStateException("Uninitialized linked-list. Nothing to remove ! ");
		} else {
			if (head.val == x) {
				head = head.next;
				return true;
			}
		}
		
		Node prev = head;
		Node curr = prev.next;
		while (curr != null) {
			if (curr.val == x) {
				prev.next = curr.next;
				return true;
			}
			prev = curr;
			curr = curr.next;
		}
		return false;
	}

}

class Node {
	int val;
	Node next;
	
	Node(int val) {
		this.val = val;
		this.next = null;
	}
	
	Node() {
		this.val = -9999;
		this.next = null;
	}
}
