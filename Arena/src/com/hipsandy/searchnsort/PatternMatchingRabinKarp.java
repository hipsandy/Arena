package src.com.hipsandy.searchnsort;


import java.util.ArrayList;
import java.util.List;

public class PatternMatchingRabinKarp {

  List<Object> list;

  public static void main(String[] args) {

    List<Object> list = new ArrayList<>();
    list.add(new PatternMatchingRabinKarp());

    String text =
        "helloWorldisjustaroundthecorner";
    String pattern = "ner";

    System.out.println("match found? " + findPattern(text, pattern));
  }

  public static boolean findPattern(String text, String pattern) {
    int p = pattern.length();
    int t = text.length();
    if (p > t) return false;

    // generate hash of the pattern
    long patternHash = rollingHash(0, pattern, 0, p);

    // for i = 0 to i <= (t - p), [t = text.length ; p = pattern.length], generate rolling hash for the first p  letters of text
    long prevHash = 0;
    for (int i = 0; i <= t - p; i++) {
      long subTextHash = rollingHash(i, text, prevHash, p);
      System.out.println(String.format("Comparing patternHash: %d and subTextHash: %d", patternHash, subTextHash));
      if (patternHash == subTextHash) {
        return true;
      }
      prevHash = subTextHash;
    }

    return false;

  }


  public static long rollingHash(int s, String text, long prevHash, int patternLength) {
    // e should be less than text.length

    int prime = 37;
    long hash = 0;

    int e = s + patternLength;

    if (s == 0 || prevHash == 0) {
      // calculate hash for the first time
      for (int i = s; i < e; i++) {
        int val = text.charAt(i);
        hash += val * (Math.pow(prime, i));
      }
      return hash;
    }

    // hash = (prevHash - firstCharOfPrevHash) / prime  +   nextCharAfterPrevHash * (prime ^ patternLeng
    hash = ((prevHash) - text.charAt(s - 1)) / prime + (long)(text.charAt(e - 1) * Math.pow(prime, patternLength - 1));
    return hash;
  }

}

