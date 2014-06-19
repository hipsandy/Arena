package java.com.hipsandy.ds;

import java.util.Comparator;

public class BinSearchTree<T extends Comparable<T>> {
	
	private class Node {
		T val;
		Node right;
		Node left;
		
		Node(T val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
		Node(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	private Node root;
	
	public BinSearchTree(Node root) {
		this.root = root;
	}
	
	// BST methods
	
	public void insert(T val) {
		Node n = insert(root, val);
		if (root == null) {
			root = n;
		}
	}
	
	public Node find(T val) {
		return find(root, val);
	}
	
	public Node delete(T val) {
		return delete(root, val);
	}
	
	private Node delete(Node n, T val) {
		if (n == null) {
			return null;
		}
		
		if (val.compareTo(n.val) < 0) {
			n.left = delete(n.left, val);
		} else if (val.compareTo(n.val) > 0) {
			n.right = delete(n.right, val);
		} else {
			// When a match occurs
			if(n.left == null) {
				return n.right;
			} else if (n.right == null) {
				return n.left;
			} else {
				// If both right and left child exist
				Node newNode = findMin(n.right);
				delete(n.right, newNode.val);
				newNode.left = n.left;
				newNode.right = n.right;
				return newNode;
			}
		}
		return null;
	}
	
	private Node findMin(Node n) {
		if (n == null) {
			throw new IllegalArgumentException("null value not acceptable");
		}
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}
	
	
	
	
	
	private Node find(Node n, T val) {
		while(n != null) {
			if (val.compareTo(n.val) > 0) {
				n = n.right;
			} else if (val.compareTo(n.val) < 0) {
				n = n.left;
			} else {
				return n; //matching
			}
		}
		return null;
	}
	
	private Node insert(Node n, T val) {
		if (n == null) {
			return new Node(val);
		}
		
		if (val.compareTo(n.val) < 0) {
			n.left = insert(n.left, val);
		} else {
			n.right = insert(n.right, val);
		}
		return n;
	}

}


