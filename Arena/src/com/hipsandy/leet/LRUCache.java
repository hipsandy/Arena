package src.com.hipsandy.leet;

import java.util.*;

public class LRUCache {

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    assert (cache.get(1) == 1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    assert (cache.get(2) == -1);       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    assert (cache.get(1) == -1);       // returns -1 (not found)
    assert (cache.get(3) ==3);       // returns 3
    cache.get(4);
  }

  int capacity;
  Deque<Integer> usageTracker; //TODO: Try using a LinkedHashSet instead
  Map<Integer, Integer> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    usageTracker = new ArrayDeque<>(capacity);
    map = new HashMap<>();
  }

  public int get(int key) {
    int result = map.containsKey(key) ? map.get(key) : -1;
    if (result != -1) {
      usageTracker.removeFirstOccurrence(key);
      usageTracker.push(key);
    }
    return result;
  }

  public void put(int key, int value) {
    usageTracker.removeFirstOccurrence(key);
    if (usageTracker.size() == capacity) {
      // remove the least used item
      Integer lruKey = usageTracker.pollLast();
      map.remove(lruKey);
    }
    usageTracker.push(key);
    map.put(key, value);
  }

}

class LRUWithLinkedHashSet {

  int capacity;
  HashSet<Integer> usageTracker; //TODO: Try using a LinkedHashSet instead
  Map<Integer, Integer> map;

  public LRUWithLinkedHashSet(int capacity) {
    this.capacity = capacity;
    usageTracker = new LinkedHashSet<>(capacity);
    map = new HashMap<>();
  }

  public int get(int key) {
    int result = map.containsKey(key) ? map.get(key) : -1;
    if (result != -1) {
      usageTracker.remove(key);
      usageTracker.add(key);
    }
    return result;
  }

  public void put(int key, int value) {
    usageTracker.remove(key);
    if (usageTracker.size() == capacity) {
      // remove the least used item - THIS IS CHALLENGING when using LinkedHashSet - as there is no available method to remove
      // the last element in the LinkedHashSet
//      Integer lruKey = usageTracker.remove(usageTracker.con);
//      map.remove(lruKey);
    }
    usageTracker.add(key);
    map.put(key, value);
  }

}
