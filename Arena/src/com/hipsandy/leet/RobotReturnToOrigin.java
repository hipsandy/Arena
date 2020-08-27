package src.com.hipsandy.leet;

public class RobotReturnToOrigin {


  public static void main(String[] args) {
    Solution sol = new RobotReturnToOrigin.Solution();
    System.out.println("UDUDUDUDUD: " + sol.judgeCircle("UDUDUDUDUD"));
    System.out.println("LLRL: " + sol.judgeCircle("LLRL"));
  }

  static class Solution {
    public boolean judgeCircle(String moves) {
      int x = 0, y = 0;

      for (int i = 0; i < moves.length(); i++) {
        switch (moves.charAt(i)) {
          case 'U': {
            y++;
            break;
          }
          case 'D': {
            y--;
            break;
          }
          case 'R': {
            x++;
            break;
          }
          case 'L': {
            x--;
            break;
          }
          default: {
            throw new IllegalArgumentException("Invalid move");
          }
        }
      }

      return (x == 0) && (y == 0);
    }

  }

}

//      Map<String, Integer> moveMap = loadMoveMap();


//    private Map<String, Integer> loadMoveMap() {
//      Map<String, Integer> moveMap = new HashMap<>();
//      moveMap.put("U", 1);
//      moveMap.put("D", -1);
//      moveMap.put("R", 1);
//      moveMap.put("L", -1);
//    }