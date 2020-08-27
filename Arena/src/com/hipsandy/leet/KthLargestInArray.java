package src.com.hipsandy.leet;

import java.util.Arrays;

public class KthLargestInArray {

  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
    sol.findKthLargest(new int[]{3,2,1,5,6,4}, 2);
  }

  static class Solution {
    public int findKthLargest(int[] nums, int k) {
      Arrays.sort(nums);
      int kthLargest = nums[nums.length - k];
      System.out.println(k + "th largest element: " + kthLargest);
      return kthLargest;
    }
  }
}
