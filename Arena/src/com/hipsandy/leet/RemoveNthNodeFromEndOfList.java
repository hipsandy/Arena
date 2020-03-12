package src.com.hipsandy.leet;

public class RemoveNthNodeFromEndOfList {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {

    RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();
//    obj.removeNthFromEnd()

  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null || head.next == null) {
      head = null;
      return head;
    }

    ListNode endPointer = head;
    ListNode oneBeforeTarget = head;
    int diff = n;
    while (diff > 0) {
      endPointer = endPointer.next;
      diff--;
    }

    // This means n is equal to the number of nodes in the list
    if (endPointer == null) {
      head = head.next;
      oneBeforeTarget.next = null;
      return head;
    }

    // Advance the endPointer till it reaches the last node
    while (endPointer.next != null) {
      endPointer = endPointer.next;
      oneBeforeTarget = oneBeforeTarget.next;
    }

    // Remove the target node;
    ListNode target = oneBeforeTarget.next;
    oneBeforeTarget.next = target.next;

    return head;

  }

}
