package src.com.hipsandy.ds;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class GraphDs {

  public static void main(String[] args) {

    Node node0 = new Node(0);
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);

    node0.addConnection(node1);
    node0.addConnection(node4);
    node1.addConnection(node2);
    node1.addConnection(node3);
    node2.addConnection(node1);
    node2.addConnection(node4);
    node3.addConnection(node1);
    node3.addConnection(node5);
    node4.addConnection(node2);
    node5.addConnection(node3);


    // DFS
    int n = 6; //number of vertices
    boolean[] visited = new boolean[n];

    dfs(node0, visited);
  }


  public static void dfs(Node node, boolean[] visited) {
    if (visited[node.value]) {
      return;
    }

    System.out.println("Visiting node: " + node.value);
    visited[node.value] = true;
    for (Node adjNode : node.adjList) {
      dfs(adjNode, visited);
    }

  }



  static class Node {
    int value;
    List<Node> adjList = new ArrayList<>();

    public Node(int value) {
      this.value = value;
    }

    public Node adjList(List<Node> adjList) {
      this.adjList = adjList;
      return this;
    }

    public void addConnection(Node node) {
      this.adjList.add(node);
    }

  }

  class Nodez<T, W> {
    T value;
    List<Pair<Node, W>> adjList;
  }
}
