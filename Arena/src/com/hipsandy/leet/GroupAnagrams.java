package src.com.hipsandy.leet;

import java.util.*;

public class GroupAnagrams {

  public static void main(String[] args) {
    long startMem = Runtime.getRuntime().freeMemory();
    Solution sol = new Solution();
    sol.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat", "blah", "blooh", "dfssf", "adf", "dokd", "fdhdk", "fjksil", "safd", "fhkdh", "fuki", "fhjj", "ciso"});
    System.out.println("Memory required: " + (startMem - Runtime.getRuntime().freeMemory())/1000.0);
  }



  static class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> map = new HashMap<>();
      for (String str : strs) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);

        if (!map.containsKey(sorted)) {
          map.put(sorted, new ArrayList<>());
        }

        map.get(sorted).add(str);
      }

      List<List<String>> result = new ArrayList<>();
//    Iterating using for-loop uses lesser memory than using the map.forEach
      for (String key : map.keySet()) {
        result.add(map.get(key));
      }
//    map.forEach((s, strings) -> result.add(strings));
      return result;

    }
  }
}


