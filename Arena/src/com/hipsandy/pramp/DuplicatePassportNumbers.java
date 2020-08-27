package src.com.hipsandy.pramp;

import java.util.ArrayList;
import java.util.List;

public class DuplicatePassportNumbers {

  public static void main(String[] args) {

    Solution sol = new Solution();

    print(sol.findDuplicatesUnbalanced(new int[]{0, 3, 5, 13}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));

    print(sol.findDuplicatesBalanced(new int[]{1, 2, 5, 9}, new int[]{ 3, 5, 7, 9}));
    print(sol.findDuplicatesBalanced(new int[]{1, 2, 5, 9}, new int[]{ 3, 8, 9, 12}));

  }

  static class Solution {


    static int[] findDuplicatesUnbalanced(int[] arr1, int[] arr2) {
      List<Integer> res = new ArrayList();
      for (int i = 0; i < arr1.length; i++) {
        if (binSearch(arr1[i], arr2)) {
          res.add(arr1[i]);
        }
      }

      int[] resArray = new int[res.size()];
      for (int i = 0; i < res.size(); i++) {
        resArray[i] = res.get(i);
      }
      return resArray;

    }

    static boolean binSearch(int x, int[] arr) {
      // bin search implementation
      int low = 0, high = arr.length - 1;
      if (low == high) {
        return x == arr[low];
      }

      while(low < high) {

        int mid = (low + high) / 2;
        if (x == arr[mid]) {
          return true;
        } else if (x < arr[mid]) {
          high = mid - 1;
        } else if (x > arr[mid]) {
          low = mid + 1;
        }
      }

      return false;
}

    static int[] findDuplicatesBalanced(int[] arr1, int[] arr2) {
      int i = 0, j = 0;
      List<Integer> res = new ArrayList();
      while (i < arr1.length && j < arr2.length) {
        if (arr1[i] == arr2[j]) {
          res.add(arr1[i]);
          i++;
          j++;
        } else if (arr1[i] < arr2[j]) {
          i++;
        } else {
          j++;
        }
      }
      int[] resArray = new int[res.size()];
      for (int k = 0; k < res.size(); k++) {
        resArray[k] = res.get(k);
      }
      return resArray;

    }

  }

  static void print(int[] arr) {
    // Print
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println();
  }

}