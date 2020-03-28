package src.com.hipsandy.leet;

public class UniquePaths {

  public static void main(String[] args) {
    System.out.println("number of unique paths: " + new Solution().uniquePaths(3, 3));
  }

  static class Solution {

    int maxRowIdx;
    int maxColIdx;

    public int uniquePaths(int m, int n) {
      this.maxRowIdx = m - 1;
      this.maxColIdx = n -1;
      return findPaths(0, 0);

    }

    public int findPaths(int r, int c) {
      if (r > maxRowIdx || c > maxColIdx) {
        // can't go further
        return 0;
      }

      if (maxRowIdx == r && maxColIdx == c) {
        //base case
        return 1;
      }

      // Explore options
      return findPaths(r, c+1) + findPaths(r+1, c);
    }
  }

}