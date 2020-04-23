package src.com.hipsandy.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {

  public static void main(String[] args) {
    long before = Runtime.getRuntime().freeMemory();
    System.out.println("Memory Before: " + before);

    System.out.println("number of unique paths: ");

    long after = Runtime.getRuntime().freeMemory();
    System.out.println("Memory After: " + after);
    System.out.println("Memory Used: " + (after - before) / 1000.0);

    Solution solution = new Solution();

    int[][] matrix = {
        {1, 2, 2, 3, 5},
        {3, 2, 3, 4, 4},
        {2, 4, 5, 3, 1},
        {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}
    };
    System.out.println("Result: " + solution.pacificAtlantic(matrix));

    int[][] second = {
        {1, 2, 3},
        {8, 9, 4},
        {7, 6, 5}};
    System.out.println("2nd: " + solution.pacificAtlantic(second));

    int[][] thrid = {
        {1, 2, 3, 4},
        {12, 13, 14, 5},
        {11, 16, 15, 6},
        {10, 9, 8, 7}};
    System.out.println("3rd: " + solution.pacificAtlantic(thrid));
  }

  static class Solution {

    /*
    1. In order to populate pacific or atlantic array, It is not enough to set the value of the current cell by just comparing left & top (pacific)
    and right & bottom (atlantic). Water is allowed to flow in any four direction as long as it satisfies the height rule.
    2. Every time the value of a cell is set, it can affect the value of it's surrounding cell. And the value of the surrounding cell can affect it's
    surrounding cells .... and so on. That's a repeatable task and recursion can be used here.
    3. Base condition would be - if the value of a given cell is already set, simply return from the function.
     */


    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
      if (matrix.length == 0 || matrix[0].length == 0) {
        return new ArrayList<>();
      }
      int colSize = matrix[0].length;
      int rowSize = matrix.length;
      int[][] pacific = new int[rowSize][colSize];
      int[][] atlantic = new int[rowSize][colSize];

      // initialize pacific and atlantic
      for (int r = 0; r < rowSize; r++) {
        pacific[r][0] = 1;
        atlantic[r][colSize - 1] = 1;
      }
      for (int c = 0; c < colSize; c++) {
        pacific[0][c] = 1;
        atlantic[rowSize - 1][c] = 1;
      }

      // set value of cell if it can flow to the pacific
      for (int r = 1; r < rowSize; r++) {
        for (int c = 1; c < colSize; c++) {
          setCellValue(matrix, colSize, rowSize, pacific, true, r, c);
        }
      }

      // set value of cell if it can flow to the atlantic
      for (int r = rowSize - 2; r >= 0; r--) {
        for (int c = colSize - 2; c >= 0; c--) {
          setCellValue(matrix, colSize, rowSize, atlantic, false, r, c);
        }
      }

      // Find all the cells that have value 1 in the pacifc and atlantic matrix is the solution
      List<List<Integer>> result = new ArrayList<>();
      for (int r = 0; r < rowSize; r++) {
        for (int c = 0; c < colSize; c++) {
          if (pacific[r][c] == 1 && atlantic[r][c] == 1) {
            result.add(Arrays.asList(r, c));
          }
        }
      }

      return result;
    }

    private void setCellValue(int[][] matrix, int colSize, int rowSize, int[][] arr, boolean isPacific, int r, int c) {
      if (arr[r][c] == 1) {
        return;
      }

      boolean setCurrentCell = false;
      if (isPacific) {
        if (matrix[r][c] >= matrix[r][c - 1] && arr[r][c - 1] == 1) {
          setCurrentCell = true;
        } else if (matrix[r][c] >= matrix[r - 1][c] && arr[r - 1][c] == 1) {
          setCurrentCell = true;
        }
      } else {
        // atlantic - calculate using right and bottom
        if (matrix[r][c] >= matrix[r][c + 1] && arr[r][c + 1] == 1) {
          setCurrentCell = true;
        } else if (matrix[r][c] >= matrix[r + 1][c] && arr[r + 1][c] == 1) {
          setCurrentCell = true;
        }
      }

      if (setCurrentCell) {
        // Everytime you set the value of a cell, attempt to set the value of surrounding cells as well
        arr[r][c] = 1;
        setSurroundingCellValue(matrix, colSize, rowSize, arr, isPacific, r, c);
      }
    }

    private void setSurroundingCellValue(int[][] matrix, int colSize, int rowSize, int[][] arr, boolean isPacific, int r, int c) {
      if (c < colSize - 1 && arr[r][c + 1] != 1 && matrix[r][c] <= matrix[r][c + 1]) {
        setCellValue(matrix, colSize, rowSize, arr, isPacific, r, c + 1);
      }
      if (r < rowSize - 1 && arr[r + 1][c] != 1 && matrix[r][c] <= matrix[r + 1][c]) {
        setCellValue(matrix, colSize, rowSize, arr, isPacific, r + 1, c);
      }

      if (c > 0 && arr[r][c - 1] != 1 && matrix[r][c] <= matrix[r][c - 1]) {
        setCellValue(matrix, colSize, rowSize, arr, isPacific, r, c - 1);
      }

      if (r > 0 && arr[r - 1][c] != 1 && matrix[r][c] <= matrix[r - 1][c]) {
        setCellValue(matrix, colSize, rowSize, arr, isPacific, r - 1, c);
      }
    }

//    private void setCellValue(int[][] matrix, int colSize, int rowSize, int[][] arr, int r, int c) {
//      if (arr[r][c] == 1) {
//        return;
//      }
//
//      arr[r][c] = 1;
//      setSurroundingCellValue(matrix, colSize, rowSize, arr, r, c);
//    }

//    private void setSurroundingCellValue(int[][] matrix, int colSize, int rowSize, int[][] arr, int r, int c) {
//      if (c < colSize - 1 && arr[r][c + 1] != 1 && matrix[r][c] <= matrix[r][c + 1]) {
//        setCellValue(matrix, colSize, rowSize, arr, r, c + 1);
//      }
//      if (r < rowSize - 1 && arr[r + 1][c] != 1 && matrix[r][c] <= matrix[r + 1][c]) {
//        setCellValue(matrix, colSize, rowSize, arr, r + 1, c);
//        ;
//      }
//      if (c > 0 && arr[r][c - 1] != 1 && matrix[r][c] <= matrix[r][c - 1]) {
//        setCellValue(matrix, colSize, rowSize, arr, r, c - 1);
//
//      }
//
//      if (r > 0 && arr[r - 1][c] != 1 && matrix[r][c] <= matrix[r - 1][c]) {
//        setCellValue(matrix, colSize, rowSize, arr, r - 1, c);
//      }
//    }

  }

}