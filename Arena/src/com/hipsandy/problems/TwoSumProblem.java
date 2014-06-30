package com.hipsandy.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an input array/list of numbers and 'sum'. Find all the elements of the array 'x' and 'y' such that
 * x + y = sum
 * 
 * @author sivaraman
 */
public class TwoSumProblem {
	
	int[] input = null;
	int sum;
	
	
	TwoSumProblem(int[] input, int sum) {
		this.input = input;
		this.sum = sum;
	}
	
	public void solve() {
		Set<Integer> lookup = new HashSet<>();
		List<String> result = new ArrayList<>();
		for (int i : input) {
			if (lookup.contains(
					sum - i)) {
				result.add(i + " , " + (sum - i));
				lookup.remove(sum - i);
			} else {
				lookup.add(i);
			}
		}
		// Print result
		for (String res : result) {
			System.out.println(res);
		}
	}
	
	
	public static void main(String[] args) {
		TwoSumProblem prob = new TwoSumProblem(new int[]{-1, 4, 2, 7, -8, 5, 3, -4, 9}, 5);
		prob.solve();
	}

}
