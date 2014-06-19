package java.com.hipsandy.ds;

public class MyLinkedList<T> {
	
	private Node<T> head;
	private int size;
	
	MyLinkedList(T val) {
		this.head = new Node<T>(val);
		this.size = 1;
	}
	
	public void add(T x) {
		Node<T> n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = new Node<T>(x);
		size += 1;
	}
	
	public Node<T> find(T x) {
		Node<T> n = head;
		while (n != null) {
			if (n.val.equals(x)) {
				return n;
			}
			n = n.next;
		}
		return null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean remove(T x) {
		if (head == null) {
			throw new IllegalStateException("Uninitialized linked-list. Nothing to remove ! ");
		} else {
			if (head.val.equals(x)) {
				head = head.next;
				return true;
			}
		}
		
		Node<T> prev = head;
		Node<T> curr = prev.next;
		while (curr != null) {
			if (curr.val.equals(x)) {
				prev.next = curr.next;
				return true;
			}
			prev = curr;
			curr = curr.next;
		}
		return false;
	}

}

class Node<T> {
	T val;
	Node<T> next;
	
	Node(T val) {
		this.val = val;
		this.next = null;
	}
	
	Node() {
		this.val = null;
		this.next = null;
	}
}
