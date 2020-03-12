package src.com.hipsandy.ds;

import java.util.Arrays;
import java.util.List;

public class BasicLinkedList {

  Node head;



  public BasicLinkedList() {
    this.head = null;
  }

  public BasicLinkedList(String value) {
    this.head = new Node(value);
  }

  public BasicLinkedList(List<String> values) {
    for (String val : values) {
      add(val);
    }
  }

  public void add(String value) {
    if (head == null) {
      head = new Node(value);
      return;
    }

    Node node = head;
    while (node.next != null) {
      node = node.next;
    }

    node.next = new Node(value);
  }

  public void printAll() {
    Node node = head;

    while (node != null) {
      System.out.print(node.value + " > ");
      node = node.next;
    }

    System.out.println("null");
  }

  public void reverse() {
    Node p1 = null;
    Node p2 = head;
    if (head == null) {
      return;
    }

    Node p3 = p2.next;
    while (p3 != null) {
      p2.next = p1;
      p1 = p2;
      p2 = p3;
      p3 = p2.next;
    }
    p2.next = p1;
    head = p2;

  }

  class Node {
    String value;
    Node next;


    public Node(String value) {
      this.value = value;
      this.next = null;
    }
  }


  public static void main(String[] args) {
    BasicLinkedList list = new BasicLinkedList(Arrays.asList("1", "2", "3", "4"));
    list.add("5");
    list.printAll();

    BasicLinkedList list2 = new BasicLinkedList();
    list2.add("5");
    list2.printAll();

    System.out.println("==============");

    BasicLinkedList emptyList = new BasicLinkedList();
    emptyList.reverse();
    emptyList.printAll();

    BasicLinkedList singleValue = new BasicLinkedList("69");
    singleValue.reverse();
    singleValue.printAll();

    BasicLinkedList multiValue = new BasicLinkedList(Arrays.asList("1", "2"));
    multiValue.reverse();
    multiValue.printAll();

    BasicLinkedList biValue = new BasicLinkedList(Arrays.asList("1", "2", "3", "4"));
    biValue.reverse();
    biValue.printAll();




  }


}
