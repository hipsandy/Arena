package src.com.hipsandy.leet;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {


  public static void main(String[] args) {
    LongestSubStringWithoutRepeatingCharacters solution = new LongestSubStringWithoutRepeatingCharacters();
    solution.lengthOfLongestSubstring("abcabcbb");
    solution.lengthOfLongestSubstring("bbbbb");
    solution.lengthOfLongestSubstring("pwwkew");
    solution.lengthOfLongestSubstring("bba");
    solution.lengthOfLongestSubstring("c");
    solution.lengthOfLongestSubstring("");
    System.out.println("=========================");
    solution.slidingFor("abcabcbb");
//    solution.slidingWhile("abcabcbb");
    solution.slidingFor("bbbbb");
    solution.slidingFor("pwwkew");
    solution.slidingFor("bba");
    solution.slidingFor("c");
    solution.slidingFor("");



  }



  public int slidingWhile(String s) {
    int n = s.length();
    Set<Character> set = new HashSet<>();
    int max = 0, i = 0, j = 0;
    while (i < n && j < n) {
      // try to extend the range [i, j]
      if (!set.contains(s.charAt(j))){
        set.add(s.charAt(j++));
        max = Math.max(max, j - i);
      }
      else {
        set.remove(s.charAt(i++));
      }
    }
    return max;
  }


  public int slidingFor(String s) {
    int max = 0;
    int n = s.length();
    Set<Character> set = new HashSet<>();
    outer: for (int i = 0; i < n; i++) {
      inner: for (int j = 0; j < n; j++) {
        char ch = s.charAt(j);
        if (!set.contains(ch)){
          set.add(ch);
          max = Math.max(max, j - i);
          continue inner;
        } else {
          set.remove(ch);
          continue outer;
        }
      }
    }
    System.out.println("Input String:" + s + " size: " + max);

    return max;
  }

  //// Sliding Window Efficient  ////
  public int slidingLengthEff(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int max = 1;
    Set<Character> lookUp = new HashSet<>();

    for (int i = 0; i < s.length(); i++) {
      lookUp.add(s.charAt(i));

      for (int j = i + max; j < s.length(); j++) {
        if (lookUp.contains(s.charAt(j))) {
          break;
        } else {
          lookUp.add(s.charAt(j));
          max = Math.max(max, j - i + 1);
        }
      }
    }
    System.out.println("Input String:" + s + " size: " + max);
    return max;
  }

  //// End Sliding Window Efficient  ////

  //// Sliding Window  ////
  public int slidingLength(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int max = 1;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + max; j <= s.length(); j++) {
        if (!isUnique(s.substring(i, j))){
          break;
        } else {
          max = Math.max(max, j - i);
        }
      }
    }
    System.out.println("Input String:" + s + " size: " + max);
    return max;
  }

  private boolean isUnique(String s) {
    HashSet<Character> lookUp = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      if (lookUp.contains(s.charAt(i))) {
        return false;
      }

      lookUp.add(s.charAt(i));
    }

    return true;
  }

  //// End Sliding Window  ////


  //// Brute Force  ////
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.trim().length() == 0) {
      return 0;
    }

    String largestSub = null;

    for (int i = 0; i < s.length(); i++) {
      int j = i + 1;
      if (largestSub == null) {
        largestSub = s.substring(i, j);
      }
      while (j < s.length()) {
        String sub = s.substring(i, j);
        if (largestSub == null) {
          largestSub = sub; //initialize it
        }
        if (!containsCharacter(sub, s.charAt(j))) {
          sub = s.substring(i, j + 1);
          if (largestSub == null || largestSub.length() < sub.length()) {
            largestSub = sub;
          }
        } else {
          break;
        }
        j++;
      }

    }

    System.out.println("subString: " + largestSub + " size: " + largestSub.length());

    return largestSub.length();

  }


  public boolean containsCharacter(String s, char c) {
    return s.indexOf(c) == -1 ? false : true;
  }

  //// End of Brute Force  ////


}
