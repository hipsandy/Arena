package src.com.hipsandy.leet;

import java.util.Arrays;

public class CoinChange {

  public static void main(String[] args) {
    Solution solution = new Solution();
//    System.out.println("{1, 2, 5}, 11): " + solution.coinChange(new int[]{1, 2, 5}, 11));
//    System.out.println("{2, 5}, 1): " + solution.coinChange(new int[]{2, 5}, 1));
//    System.out.println("{1, 2, 5}, 19): " + solution.coinChange(new int[]{1, 2, 5}, 19));
//    System.out.println("{1}, 0): " + solution.coinChange(new int[]{1}, 0));
    System.out.println("{186,419,83,408}, 6249): " + solution.coinChange(new int[]{186,419,83,408}, 6249));
  }

  static class Solution {

    public int coinChange(int[] coins, int amount) {
      // sort input
      Arrays.sort(coins);

      // find largest number smaller than amount - coin
      int coin = -1;
      for (int i = 0; i < coins.length; i++) {
        if (coins[i] == amount) {
          return 1;
        } else if (coins[i] < amount)  {
          coin = coins[i];
        } else {
          break;
        }
      }

      if (coin == -1) {
        System.out.println("The amount is smaller than the smallest coin available");
        return -1;
      }

      // find number of coins needed to make value closest to the amount - n
      int n = 1;
      while ((n * coin) <= amount) {
          n++;
      }
      n--;

      // find remainder that is needed to complete the amount value - r
      int r = amount - (n * coin);

      // return n + coinChange(coins, r)
      if (r == 0) {
        return n;
      } else {
        int rem = coinChange(coins, r);
        return (rem == -1) ? -1 : (n + rem);
      }
    }
  }

}
