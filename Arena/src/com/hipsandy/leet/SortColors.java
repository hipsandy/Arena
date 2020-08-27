package src.com.hipsandy.leet;

public class SortColors {

  public static void main(String[] args) {
    new Solution().sortColors(new int [] {0, 2, 2, 1, 0, 2});
    new Solution().sortColors(new int [] {2, 2, 2, 2, 1, 1, 1, 0, 0, 0});
    new Solution().sortColors(new int [] {2, 2, 2, 2, 1, 1, 1});
  }

  static class Solution {
    public void sortColors(int[] nums) {
      // Create the counter
      int _0Counter = 0;
      int _1Counter = 0;
      int _2Counter = 0;

      // Pass through and update the counter
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
          _0Counter++;
        } else if (nums[i] == 1) {
          _1Counter++;
        } else if (nums[i] == 2) {
          _2Counter++;
        } else {
          throw new IllegalArgumentException("Found an unexpected color in the input");
        }
      }

      // Refer the counter and update the array
      int idx = 0;
      int limit = _0Counter;
      for (; idx < limit; idx++) {
        nums[idx] = 0;
      }

      limit = idx + _1Counter;
      for (; idx < limit; idx++) {
        nums[idx] = 1;
      }

      limit = idx + _2Counter;
      for (; idx < limit; idx++) {
        nums[idx] = 2;
      }

      // Print
      for (int i = 0; i < nums.length; i++) {
        System.out.print(nums[i] + ", ");
      }
      System.out.println();

    }
  }
}

