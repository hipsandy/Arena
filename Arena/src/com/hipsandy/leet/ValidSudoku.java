package src.com.hipsandy.leet;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

  public static void main(String[] args) {
    Solution solution = new Solution();


    char[][] b1 = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    System.out.println(solution.isValidSudoku(b1));

    char[][] b2 = {
        {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
        {'.', '4', '.', '3', '.', '.', '.', '.', '.'}, 
        {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
        {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
        {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
        {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
        {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
        {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
    };
    System.out.println(solution.isValidSudoku(b2));


  }

  static class Solution {


    public boolean isValidSudoku(char[][] board) {
      // validate if the rows have unique values
      for (int r = 0; r < board.length; r++) {
        if (!isValid(board[r])) {
          return false;
        }
      }


      // validate if the columns have unique values
      // Create an array from the column elements
      for (int c = 0; c < board[0].length; c++) {
        char[] arr = new char[board.length];
        for (int r = 0; r < board.length; r++) {
          arr[r] = board[r][c];
        }
        if (!isValid(arr)) {
          return false;
        }
      }

      // validate if the 3x3 sub boards have unique values
      // Create an array from the elements of the 3 x 3 blocks
      // startIndex (si) and endIndex (ei) is used to jump from the top-left element of one 3x3 to the top-left
      // element of the next 3x3 - increments by 3
      for (int si = 0; si < 9; si = si + 3) {
        for (int ei = 0; ei < 9; ei = ei + 3) {
          char[] arr = new char[9];
          int i = 0;
          // r and c keep is used to go through each element of the 3x3 matrix - increments by 1
          for (int r = si; r < si + 3; r++) {
            for (int c = ei; c < ei + 3; c++) {
              arr[i++] = board[r][c];
            }
          }
          if (!isValid(arr)) {
            return false;
          }

        }
      }

      return true;

    }

    private boolean isValid(char[] arr) {
      Set<Character> charSet = new HashSet<>();
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] != '.') {
          if (charSet.contains(arr[i])) {
            return false;
          } else {
            charSet.add(arr[i]);
          }
        }
      }
      return true;
    }


  }

}
