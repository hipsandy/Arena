package src.com.hipsandy.cracking;

public class ZeroArray {

    public static void main(String[] args) {
      int [][] m = new int[3][4];
      m[0] = new int[]{7, 2, 4, 13};
      m[1] = new int[]{12, 6, 0, 2};
      m[2] = new int[]{1, 3, 9, 18};

      int[][] exp = new int[3][4];
      exp[0] = new int[]{7, 2, 0, 13};
      exp[1] = new int[]{0, 0, 0, 0};
      exp[0] = new int[]{1, 3, 0, 18};

      int[][] out = transform(m);
      for (int i = 0; i < out.length; i++) {
        for (int n = 0; n < out[0].length; n++) {
          System.out.print(out[i][n] + " ");
          }
        System.out.println();
        }
    }

    public static int[][] transform(int[][] in) {
      int row = -999, col = -999;

      outer: for (int m = 0; m < in.length; m++) {
        for (int n = 0; n < in[0].length; n++) {
          if (in[m][n] == 0) {
            row = m;
            col = n;
            break outer;
          }
        }
      }

      if (row < 0 && col < 0) {
        System.out.println("Couldn't find an element with 0");
        return null;
      }

      for (int m = 0; m < in.length; m++) {
        if (m != row) {
          in[m][col] = 0;
        } else {
          for (int n = 0; n < in[0].length; n++) {
              in[m][n] = 0;
            }
          }
        }

      return in;
    }



}
