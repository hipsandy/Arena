package src.com.hipsandy.pramp;

import java.io.*;
import java.util.*;

public class RootOfNumber {

  static class Solution {

    static double root(double x, int n) {

      double low = 0;
      double high = x;

      while (low < high) {
        double mid = (low + high) / 2;
        double val = power(mid, n);
        if (val == x || (Math.abs(x - val) <= 0.001)) {
          return mid;
        } else if (val < x) {
          low = mid;
        } else {
          high = mid;
        }
      }

      return -1;
    }

    static double power (double x, int n) {
      double val = 1;
      while (n > 0) {
        val = val * x;
        n--;
      }
      return val;
    }

    public static void main(String[] args) {

      System.out.println(root(7, 3));
      System.out.println(root(9, 2));

    }

  }

}

