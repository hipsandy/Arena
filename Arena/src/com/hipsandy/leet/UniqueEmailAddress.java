package src.com.hipsandy.leet;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.findUniqueEmails_usingStringLibrary(new String[]{"test.email+alex@gmail.com", "test.em.ail+alex@gmail.com", "test.email@gmail.test.com"});
    solution.findUniqueEmails_characterInspection(new String[]{"test.email+alex@gmail.com", "test.em.ail+alex@gmail.com", "test.email@gmail.test.com"});
  }

  static class Solution {
    public int findUniqueEmails_usingStringLibrary(String[] emails) {
      Set uniqueSet = new HashSet();
      for (String email : emails) {
        int indexOfAt = email.indexOf('@');
        String lhs = email.substring(0, indexOfAt);
        String rhs = email.substring(indexOfAt);

        int indexOfPlus = lhs.indexOf('+');
        String localName = lhs;
        if (indexOfPlus != -1) {
          localName = lhs.substring(0, indexOfPlus);
        }


        // Remove the dots
        String localNameWithoutDots = String.join("", localName.split("\\."));

        // create the email
        String uniqueEmail = localNameWithoutDots + rhs;

        uniqueSet.add(uniqueEmail);
      }

      System.out.println("Result - " + uniqueSet);
      return uniqueSet.size();
    }

    public int findUniqueEmails_characterInspection(String[] emails) {
      Set uniqueSet = new HashSet();
      for (String email : emails) {
        boolean plusFound = false;
        boolean atFound = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < email.length(); i++) {
          char c = email.charAt(i);
          if (atFound) {
            stringBuilder.append(c);
            continue;
          }

          if (plusFound) {
            if (c == '@') {
              atFound = true;
              stringBuilder.append(c);
            }
            continue;
          }

          if (c == '.') {
            continue;
          }

          if (c == '+') {
            plusFound = true;
            continue;
          }

          if (c == '@') {
            atFound = true;
            stringBuilder.append(c);
            continue;
          }

          stringBuilder.append(c);
        }
        uniqueSet.add(stringBuilder.toString());
      }
      System.out.println("Result - " + uniqueSet);
      return uniqueSet.size();
    }
  }
}
