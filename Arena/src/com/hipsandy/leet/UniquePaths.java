package src.com.hipsandy.leet;

import com.sun.tools.javac.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {

  public static void main(String[] args) {
    long before = Runtime.getRuntime().freeMemory();
    System.out.println("Memory Before: " + before);

    System.out.println("number of unique paths: " + new Solution().uniquePaths(3, 3));

    long after = Runtime.getRuntime().freeMemory();
    System.out.println("Memory After: " + after);
    System.out.println("Memory Used: " + (after - before) / 1000.0);
  }

  static class Solution {

    int maxRowIdx;
    int maxColIdx;
    Map<Pair<Integer, Integer>, Integer> lookUp = new HashMap<>();

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

      // Do a lookup to see if the information was already calculated, then no need to do the work again
      Integer prevCalculatedValue = lookUp.get(new Pair<>(r, c));
      if (prevCalculatedValue != null ) {
        return prevCalculatedValue;
      }

      // Explore options since this has not been calculated before
      int noOfPaths = findPaths(r, c + 1) + findPaths(r + 1, c);
      lookUp.put(new Pair<>(r, c), noOfPaths);
      return noOfPaths;
    }

  }

}