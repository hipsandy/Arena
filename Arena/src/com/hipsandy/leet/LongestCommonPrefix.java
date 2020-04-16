package src.com.hipsandy.leet;

import java.util.*;

public class LongestCommonPrefix {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(" {\"flower\", \"flight\", \"flow\"} : " + solution.longestCommonVerticalScanning(new String[]{"flower", "flight", "flow"}));
    System.out.println(" {\"dog\",\"racecar\",\"car\"} : " + solution.longestCommonVerticalScanning(new String[]{"dog","racecar","car"}));
  }

  static class Solution {

    public String longestCommonVerticalScanning (String[] strs) {
      if (strs == null || strs.length == 0) {
        return "";
      }
      int i = 0;
      String prefix = "";
      while (i < strs[0].length()) {
        char c = strs[0].charAt(i);
        for (String str : strs) {
          if (i == str.length() || c != str.charAt(i)) {
            return prefix;
          }
        }
        prefix = prefix + c;
        i++;
      }

      return prefix;
    }

    // This approach is quite unnecessary. Creating that tree map to get the smallest string in the array wasn't quite
    // needed if we did vertical scanning of the strings. However, for long strings it is noted that the memory used to
    // iterate over the strings to do vertical scanning can take quite a lot of space
    public String longestCommonPrefixUsingASortedTree(String[] strs) {

      // Sort to find strings with the smallest size
      Map<Integer, List<String>> sizeToStringMap = new TreeMap<>();
      for (String str : strs) {
        if (!sizeToStringMap.containsKey(str.length())) {
          sizeToStringMap.put(str.length(), new ArrayList<>());
        }
        sizeToStringMap.get(str.length()).add(str);
      }

      // Look at the each character at index i. The moment it differs or goes out of range for a given str, we have the longest prefix
      int i = 0;
      String prefix = "";
      int smallesStringSize = ((TreeMap<Integer, List<String>>) sizeToStringMap).firstKey();
      while (i < smallesStringSize) {
        char c = strs[0].charAt(i);
        for (String str : strs) {
          if (c != str.charAt(i)) {
            return prefix;
          }
        }
        prefix = prefix + c;
        i++;
      }
      return prefix;
    }

  }



}
