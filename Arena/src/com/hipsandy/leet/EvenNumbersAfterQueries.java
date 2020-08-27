package src.com.hipsandy.leet;

public class EvenNumbersAfterQueries {

  public static void main(String[] args) {
    Solution sol = new EvenNumbersAfterQueries.Solution();
    int[] ans = sol.sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}});


    // Print
    for (int i = 0; i < ans.length; i++) {
      System.out.print(ans[i] + ", ");
    }
    System.out.println();

  }


  static class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
      int r = queries.length;
      int[] ans = new int[r];

      int sum = sumOfEven(A);

      for (int i = 0; i < r; i++) {
        int idx = queries[i][1];
        int val = queries[i][0];

        if (isEven(A[idx])) {
          sum -= A[idx];
        }

        A[idx] += val;

        if (isEven(A[idx])) {
          sum += A[idx];
        }

        ans[i] = sum;
      }

      return ans;
    }

    private boolean isEven(int num) {
      return (num % 2) == 0;
    }

    private int sumOfEven(int[] a) {
      int sum = 0;
      for (int i = 0; i < a.length; i++) {
        if (a[i] % 2 == 0) {
          sum += a[i];
        }
      }
      return sum;
    }
  }



}


