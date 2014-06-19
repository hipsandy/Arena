package java.com.hipsandy.ds;

public class MyLinkedList<T> {
	
	private class Node {
		T val;
		Node next;
		
		Node(T val) {
			this.val = val;
			this.next = null;
		}
		
		Node(T val, Node next) {
			this.val = val;
			this.next = next;
		}
		
		Node() {
			this.val = null;
			this.next = null;
		}
	}
	
	private Node head;
	private int size;
	
	MyLinkedList(T val) {
		this.head = new Node(val);
		this.size = 1;
	}
	
	
	public void insertAtTail(T x) {
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = new Node(x);
		size += 1;
	}
	
	public void insertAtHead(T x) {
		head = new Node(x, head);
		size += 1;
	}
	
	public Node find(T x) {
		Node n = head;
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
	
	public void insertAt(int index, T value) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Invalid index provided");
		}
		
		if (index == 0) {
			insertAtHead(value);
		} else {
			Node n = head;
			Node nextNode = null;
			
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
				nextNode = n.next;
			}
			n.next = new Node(value, nextNode);
			size += 1;
		}
	}
	
	public boolean remove(T x) {
		if (head == null) {
			throw new IllegalStateException("Uninitialized linked-list. Nothing to remove ! ");
		} else {
			if (head.val.equals(x)) {
				head = head.next;
				size -= 1;
				return true;
			}
		}
		
		Node prev = head;
		Node curr = prev.next;
		while (curr != null) {
			if (curr.val.equals(x)) {
				prev.next = curr.next;
				size -= 1;
				return true;
			}
			prev = curr;
			curr = curr.next;
		}
		return false;
	}
	
	public T removeFrom(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Invalid index provided");
		}
		
		if (index == 0) {
			Node removed = head;
			head = head.next;
			size -= 1;
			return removed.val;
		}
		
		Node n = head;
		for (int i = 0; i < index - 1; i++) {
			n = n.next;
		}
		Node removed = n.next;
		n.next = n.next.next;
		return removed.val;
	}
	
	public void print() {
		Node n = head;
		while(n.next != null) {
			System.out.print(n.val.toString() + " > ");
		}
		System.out.print("null");
	}
	
	

}

