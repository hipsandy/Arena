package general;

import java.util.Arrays;
import java.util.List;

public class CyclicArrays {
	
	public static void main(String[] args) {
		testPointOfRotation();
	}
	
	private static void testPointOfRotation() {
		CyclicArrays ca = new CyclicArrays();
		Integer[] test = new Integer[]{3, 4, 5, 6, 1, 2};
//		Integer[] test = new Integer[]{3, 4, 5, 6, 7, 8};
//		Integer[] test = new Integer[]{6, 7, 8, 3, 4, 5};
		int res = ca.findPointOfRotation(Arrays.asList(test));
		System.out.println("Point of rotation: " + res);
		
	}

	public int findPointOfRotation(List<Integer> arr) {
		int l = 0, r = arr.size() - 1;

		while (l < r) {
			int m = l + ((r - l) >> 1);
			if (arr.get(m) < arr.get(m - 1) && arr.get(m) < arr.get(m + 1)) {
				return m;
			}
			if (arr.get(m) > arr.get(l)) { // left portion is sorted. rotation point is to right
				l = m;
			} else {
				r = m;
			}
		}
		return -1;
	}

	// 378, 478, 550, 631, 103, 203 , 220, 234, 279, 368, 369, 370
	public int findInCyclicArray(int[] arr, int key) {
		return findInCyclicArray(arr, 0, arr.length - 1, key);
	}

	private int findInCyclicArray(int[] arr, int l, int r, int key) {
		while (l <= r) {
			int m = l + ((r - l) >>> 1);

			if (arr[m] == key) {
				return m;
			}

			if (arr[m] >= arr[l]) { // left side of m is sorted
				if (arr[l] <= key && key <= arr[m]) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			} else { // right side is sorted
				if (arr[m] <= key && key <= arr[r]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
		}
		return -1;
	}

}
