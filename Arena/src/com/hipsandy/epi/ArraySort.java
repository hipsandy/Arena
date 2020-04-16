package src.com.hipsandy.epi;

import com.sun.deploy.util.ArrayUtil;

public class ArraySort {

  public static void main(String[] args) {
    print(quickSort(new int[]{2, 3, 6, 1, 8, 9}, 2));

    print(quickSort(new int[]{8, 9, 6, 6, 2, 3}, 2));
    print(quickSort(new int[]{8, 9, 6, 10, 20, 1,  5, 2, 3}, 2));
    print(quickSort(new int[]{5, 5, 5, 5, 5, 5}, 3));
    print(quickSort(new int[]{ 1, 3, 4, 5, 6, 8, 9}, 6));
  }


  public static int[] quickSort(int[] arr, int p) {
    int l = 0;
    int r = arr.length - 1;
    while (l <= r) {

      while (arr[l] < arr[p] && l < p) {
        l++;
      }

      while(arr[r] > arr[p] && r > p) {
        r--;
      }


      swap(arr, l, r);
      // if l < p and r > p, swap left and right of pivot
      if (l < p  && p < r) {
        l++;
        r--;
      } else if (l == p) { //left side of pivot has in order
        p = r; // make pivot point to the new location of pivot --> left side of pivot now is out of whack. so move l pointer
        l++;
      } else if (r == p) { //left side of pivot has in order
        p = l; // make pivot point to the new location of pivot --> right side of pivot now is out of whack. so move r pointer
        r--;
      }

    }

    return arr;
  }

  public static void swap(int[] arr, int l, int r) {
    int t = arr[l];
    arr[l] = arr[r];
    arr[r] = t;
  }


  public static void print(int[] arr) {
    String value = " ";
    for (int i : arr) {
      value += i + ", ";
    }
    System.out.println(value);
  }
}
