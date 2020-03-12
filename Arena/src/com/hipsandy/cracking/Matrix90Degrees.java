package src.com.hipsandy.cracking;

public class Matrix90Degrees {

  public static void main(String[] args) {
    int [][] input = new int[3][3];
    input[0] = new int[]{7, 2, 4};
    input[1] = new int[]{12, 6, 0};
    input[2] = new int[]{1, 3, 9};

    int[][] exp = new int[3][3];
    exp[0] = new int[]{1, 12, 7};
    exp[1] = new int[]{3, 6, 2};
    exp[0] = new int[]{9, 0, 4};

    int[][] out = transform(input);
    for (int i = 0; i < out.length; i++) {
      for (int n = 0; n < out[0].length; n++) {
        System.out.print(out[i][n] + " ");
      }
      System.out.println();
    }
  }

  public static int[][] transform(int[][] in) {
    int N = in.length;
    int [][] output = new int[N][N];
    for (int i = 0; i < in.length; i++) {
      for (int j = 0; j < in[0].length; j++) {
        int colIndex = in.length - 1 - i;
        output[j][colIndex] = in[i][j];
      }
    }
    return output;
  }


}
