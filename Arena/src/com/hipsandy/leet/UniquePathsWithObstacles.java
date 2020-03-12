package src.com.hipsandy.leet;

import java.util.ArrayList;
import java.util.List;

public class UniquePathsWithObstacles {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    // go all the way to the right and then go down
    // go all the way down and then go right


    // Graph
    // each square is a node. Each node can have upto 4 edges.
    // At any edge only if you go right or down you can go towards the finish.
    // If there is no more way to go right, you go down. And if you can't go down further you go right.

    // Store the paths in a an array of positions (matrix index). Use equality to verify uniqueness of path.

    List<String> path = new ArrayList<>();

    int i =0, j = 0;

    while (i < obstacleGrid.length && j < obstacleGrid[0].length) {
      path.add(i + "" + j);
      if (j < obstacleGrid[0].length) {
        j++;
      } else {
        i++;
      }

      // if this path has already

    }


    return -1;
  }

}
