package com.hipsandy.problems;

import com.hipsandy.ds.BinSearchTree;

public class ArrayTreeConverter {
	
	public BinSearchTree<Integer> convertArrayToTree(int[] in) {
		BinSearchTree.Node<Integer> root = null;
		for (int i = 0; i < in.length / 2 - 1; i++) {
			BinSearchTree.Node<Integer> node = new BinSearchTree.Node<Integer>(in[i]);
			if (root == null) {
				root = node;
			}
			node.setLeft(new BinSearchTree.Node<Integer>(in[2 * i + 1]));
			node.setRight(new BinSearchTree.Node<Integer>(in[2 * i + 2]));
		}
		BinSearchTree<Integer> tree = new BinSearchTree<>(root);
		return tree;
	}

}
