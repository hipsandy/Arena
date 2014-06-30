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
	
	
	public void solve(int[] input, int sum) {
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
		System.out.println("2-sum solution for: " + sum);
		for (String res : result) {
			System.out.println(res);
		}
	}
	
	
	public static void main(String[] args) {
		TwoSumProblem prob = new TwoSumProblem();
		prob.solve(new int[]{-1, 4, 2, 7, -8, 5, 3, -4, 9}, 5);
		prob.solve(new int[]{-1, 4, 2, 7, -8, 5, 3, -4, 9}, 9);
		prob.solve(new int[]{-1, -4, -5, 55, 4, -3, -2, -9, -23, -11}, -12);
		prob.solve(new int[]{-1, -4, -5, 55, 4, -3, -2, -9, -23, -11}, 10);
	}

}
