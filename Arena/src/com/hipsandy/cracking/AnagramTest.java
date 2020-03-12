package src.com.hipsandy.cracking;

import com.sun.tools.javac.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class AnagramTest {

  public static void main(String[] args) {

    System.out.println(isAnagram("boomshaka", "shakaboom"));
    System.out.println(isAnagram("123", "sdfsf"));
    System.out.println(isAnagram("kumar", "kumar"));
  }

  public static boolean isAnagram(String s, String t) {

    Map<Character, Integer> charMap = new HashMap<>();
    for (char c : s.toCharArray()) {
      if (charMap.containsKey(c)) {
        charMap.put(c, charMap.get(c) + 1);
      } else {
        charMap.put(c, 1);
      }
    }

    for (char c : t.toCharArray()) {
      if (!charMap.containsKey(c)) {
        return false;
      } else {
        Integer count = charMap.get(c);
        if (count == 1) {
          charMap.remove(c);
        } else {
          charMap.put(c, --count);
        }
      }
    }

    return  (charMap.isEmpty()) ? true : false;

  }

}
