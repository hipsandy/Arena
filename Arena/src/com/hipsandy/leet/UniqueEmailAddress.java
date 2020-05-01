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
        StringBuilder sb = new StringBuilder();
        int length = email.length();
        for (int i = 0; i < length; i++) {
          char c = email.charAt(i);

          if (c == '@') {
            sb.append(email.substring(i, length));
            break;
          }

          if (plusFound || c == '.') {
            continue;
          }

          if (c == '+') {
            plusFound = true;
            continue;
          }

          sb.append(c);
        }
        uniqueSet.add(sb.toString());
      }
      System.out.println("Result - " + uniqueSet);
      return uniqueSet.size();
    }
  }
}
