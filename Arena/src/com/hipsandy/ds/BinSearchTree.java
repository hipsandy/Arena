package com.hipsandy.ds;


public class BinSearchTree<T extends Comparable<T>> {
	
	public static class Node<T> {
		T val;
		Node<T> right;
		Node<T> left;
		
		Node<T> parent;
		
		public Node(T val, Node<T> left, Node<T> right) {
			this.val = val;
			this.left = left;
			this.right = right;
			
			this.left.parent = (left == null) ? null : this;
			this.right.parent = (right == null) ? null : this;
		}
		
		public Node(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
		
		public T getVal() {
			return val;
		}

		public void setVal(T val) {
			this.val = val;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setRight(Node<T> right) {
			this.right = right;
			this.right.parent = (right == null) ? null : this;
		}

		public Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
			this.left.parent = (left == null) ? null : this;
		}
	}
	
	private Node<T> root;
	
	public BinSearchTree(Node<T> root) {
		this.root = root;
	}
	
	// BST methods
	
	public void insert(T val) {
		Node<T> n = insert(root, val);
		if (root == null) {
			root = n;
		}
	}
	
	public Node<T> find(T val) {
		return find(root, val);
	}
	
	public Node<T> delete(T val) {
		return delete(root, val);
	}
	
	public Node<T> next(Node<T> n) {
		if (n == null) {
			throw new IllegalArgumentException("Invalid entry");
		}
		if (n.right != null) {
			return findMin(n.right);
		} else {
//			Node<T> currNode = n;
//			while(n.parent != null && n.parent.val.compareTo(currNode.val) <= 0) {
//				n = n.parent;
//			}
//			return n.parent;
			
			Node<T> p = n.parent;
			while(p != null && p.val.compareTo(n.val) <= 0) {
				p = p.parent;
			}
			return p;
		}
	}
	
	private Node<T> delete(Node<T> n, T val) {
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
				Node<T> newNode = findMin(n.right);
				delete(n.right, newNode.val);
				newNode.left = n.left;
				newNode.right = n.right;
				return newNode;
			}
		}
		return null;
	}
	
	private Node<T> findMin(Node<T> n) {
		if (n == null) {
			throw new IllegalArgumentException("null value not acceptable");
		}
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}
	
	
	
	
	
	private Node<T> find(Node<T> n, T val) {
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
	
	private Node<T> insert(Node<T> n, T val) {
		if (n == null) {
			return new Node<T>(val);
		}
		
		if (val.compareTo(n.val) < 0) {
			n.left = insert(n.left, val);
		} else {
			n.right = insert(n.right, val);
		}
		return n;
	}

}


