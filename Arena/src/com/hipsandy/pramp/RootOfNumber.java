package src.com.hipsandy.pramp;

import java.io.*;
import java.util.*;

public class RootOfNumber {

  static class Solution {

    static double root(double x, int n) {

      int low = 0;

      // first fine upper and lower limit integers
      for (int i = 1; i < x; i++) {
        if (power(i, n) < x) {
          low = i;
        }
      }
      // iterate in increments of .001 and find the closest approximation

      return 0;
    }

    static double power (double i, int n) {
      if (n == 1) {
        return i;
      }
      int c = 0;
      double val = 0.0;
      while (c < n - 1) {
        val = i * i;
        c++;
      }
      return val;
    }

    public static void main(String[] args) {
      root(7, 3);
      root(9, 2);

    }

  }

}

