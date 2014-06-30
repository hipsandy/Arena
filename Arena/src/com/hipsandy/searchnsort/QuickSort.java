package com.hipsandy.searchnsort;

import java.util.Arrays;

public class QuickSort {

	public int[] sort(int[] in) {
		return sort(in, 0, in.length - 1);
		
	}
	
	private int[] sort(int[] in, int l, int r) {
		if (l == r) {
			return in;
		}
		
		// Remember the left and right pointers provided
		int left = l;
		int right = r;
		
		// Make the last index as the pivot and move 'r' pointer to the left 
		int p = r; 
		r--;
		
		while (l < r) {
			// If the value at the 'l' pointer is smaller than the pivot, the element is in the correct part of 
			// the array -> move on to next element i.e. increment the 'l' pointer.
			while((in[l] < in[p]) && l < r) {
				l++;
			}
			
			// If the value at the 'r' pointer is greater than the pivot, the element is in the correct part of
			// the array -> move on to the next element i.e. decrement the 'r' pointer.
			while((in[r] > in[p]) && l < r){
				r--;
			}
			
			
			// If the code execution reached this point and (l < r) then exchange the elements at the 'l' and 'r'.
			// The reason this is done is because if (l < r), then :
			// 'l' pointer found an element that was bigger than the pivot and the
			// 'r' pointer found an element that was smaller than the pivot.
			if (l < r) {
				// exchange
				int t = in[l];
				in[l] = in[r];
				in[r] = t;
				// move pointers
				l++; r--;
			}
		}
		
		// The execution reaches this part when (l NOT LESS THAN r), which means (l == r) i.e the pointers have
		// coincided at the same index which will be used to divide the array in two parts - one containing
		// values lesser or equals to the pivot and the other side containing values greater than the pivot.
		// To ensure this we check the point-of-coincidence with the pivot and exchange, if value at the
		// point-of-coincidence IS GREATER THAN pivot value.
		if (in[l] > in[p]) {
			int t = in[l];
			in[l] = in[p];
			in[p] = t;
		}
		
		// Recursively call this method for both the parts of the input
		sort(in, left, l);
		sort(in, l + 1, right);
		return in;
	}
	
	public static void main(String[] args) {
		QuickSort qc = new QuickSort();
		System.out.println(Arrays.toString(qc.sort(new int[]{7, 2, 4, 3, 10, 6})));
	}

}
