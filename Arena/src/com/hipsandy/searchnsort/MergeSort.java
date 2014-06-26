package com.hipsandy.searchnsort;

import java.util.Arrays;

public class MergeSort {
	
	
	public int[] sort(int[] in) {
		if(in.length == 1) {
			return in;
		}
		
		int m = in.length / 2;
		int[] left = Arrays.copyOfRange(in, 0, m);
		int[] right = Arrays.copyOfRange(in, m, in.length);
		left = sort(left);
		right = sort(right);
		return merge(left, right, in);
	}

	private int[] merge(int[] left, int[] right, int[] in) {
		int i = 0, j = 0, r = 0;
		while (i < left.length || j < right.length) {
			if(j >= right.length || (i < left.length && left[i] < right[j])) {
				in[r++] = left[i++];
			} else if (i >= left.length || (j < right.length && left[i] >= right[j])) {
				in[r++] = right[j++];
			}
		}
		return in;
	}

	public static void main(String[] args) {
		MergeSort sorter = new MergeSort();
		int[] out = sorter.sort(new int[]{8, 7, 1, 5, 2});
		System.out.println(Arrays.toString(out));

	}

}
