package src.com.hipsandy.ds;

import java.util.Arrays;

public class Sorting {

  public static void main(String[] args) {
    QuickSort quickSort = new QuickSort();
//    quickSort.sort(new int[]{3, -2, 9, 4, 0, 7, 1, 5});
//    quickSort.sort(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
    quickSort.sort(new int[]{7, 1, 2, 5, 4, 3, 6, 7});
//    quickSort.sort(new int[]{2, 2, 2, 2, 2, 2, 2, 2});
//    quickSort.sort(new int[]{2});
  }

  /**
   * QuickSort - Random-pivot VALUE + divide-n-conquer
   * 1. Pick a random element (choose to go with the first one in all cases) and make that the pivot value
   * 2. Use 2 pointers (start and end) that put all elements smaller than pivot-value onto the left side and all elements
   * larger than the pivot-value to the right side. This is done by -
   * a. Comparing values to the pivot-value
   * b. Exchanging elements
   * c. Advancing the pointers towards each other
   * 3. At the point in the array where the 2 pointers cross each other, the array is now divided into left half containing
   * elements smaller than pivot-value and right half containing elements larger than pivot-value. The position of the pivot
   * element is immaterial to this algo.
   * 4. Apply the above steps to the left and right sections of the array.
   * 5. Repeat until
   *
   */
  static class QuickSort {
    public int[] sort(int[] a) {
      partition(a, 0, a.length - 1);
      print(a);
      return a;
    }

    private void partition(int[] a, int s, int e) {
      // base condition
      if (s >= e || s >= a.length || e >= a.length) {
        return;
      }

      int i = s, j = e;

      // Choose first element as the pivot-value
      int p = a[s];
      i++;

      // Advance till exchange is possible
      while (i < j) {

        while (i < a.length && a[i] <= p) {
          i++;
        }

        while (a[j] >= p) {
          j--;
        }

        // it's possible to do an exchange if i and j haven't crossed each other
        if (i < j) {
          int t = a[i];
          a[i] = a[j];
          a[j] = t;
        }
      }

      // If i and j have crossed (i.e i >= j), we have partitioned the array
      partition(a, s, i);
      partition(a, i + 1, e);
    }
  }

  public static void print(int[] a) {
    // Print
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + ", ");
    }
    System.out.println();
  }
}
