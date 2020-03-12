package src.com.hipsandy.leet;

public class ContainerWithMaxWater {

  public static void main(String[] args) {
    ContainerWithMaxWater containerWithMaxWater = new ContainerWithMaxWater();
    System.out.println("Max: [1,8,6,2,5,4,8,3,7]: " + containerWithMaxWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    System.out.println("Max: []: " + containerWithMaxWater.maxArea(new int[]{}));
    System.out.println("Max: [1,8,6,2,5,4,8,3,0]: " + containerWithMaxWater.maxArea(new int[]{1,8,6,2,5,4,8,3,0}));

    System.out.println("===================");

    System.out.println("Max: [1,8,6,2,5,4,8,3,7]: " + containerWithMaxWater.maxAreaWhile(new int[]{1,8,6,2,5,4,8,3,7}));
    System.out.println("Max: [1, 1, 9, 1]: " + containerWithMaxWater.maxAreaWhile(new int[]{1, 1, 9, 1}));
    System.out.println("Max: [1,8,6,2,5,4,8,3,0]: " + containerWithMaxWater.maxAreaWhile(new int[]{1,8,6,2,5,4,8,3,0}));
  }

  public int maxArea(int[] height) {
    int max = 0;
    int n = height.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int h = Math.min(height[i], height[j]);
        int area = h * (j - i);
        max = Math.max(max, area);
      }
    }
    return max;
  }

  public int maxAreaWhile(int[] height) {
    int max = 0;
    int i = 0; int j = height.length - 1;
    while (i < j && i != j) {
      int h = Math.min(height[i], height[j]);
      int a = h * (j - i);
      max = Math.max(max, a);
      if (height[i] > height[j]) {
        j--;
      } else {
        i++;
      }

    }
    return max;
  }

}
