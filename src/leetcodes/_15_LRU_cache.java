package leetcodes;

import java.util.HashMap;
import java.util.Map;

public class _15_LRU_cache {

  /**
   * How LRU cache works: https://www.youtube.com/watch?v=z9bJUPxzFOw
   * How Doubly linked list works: https://www.youtube.com/watch?v=JxIC0XeTl4Y
   * @param args
   */

  public static void main(String[] args) {
    //Your LRUCache object will be instantiated and called as such:
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {2=2, 1=1}
    lRUCache.get(1);    // return 1 cache is {1=1, 2=2}
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    lRUCache.get(2);    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.get(1);    // return -1 (not found)
    lRUCache.get(3);    // return 3
    lRUCache.get(4);    // return 4LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    lRUCache.get(1);    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    lRUCache.get(2);    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.get(1);    // return -1 (not found)
    lRUCache.get(3);    // return 3
    lRUCache.get(4);    // return 4
  }
}


class LRUCache {

  Map<Integer, Node> map;
  int capacity;
  Node head = new Node(-1, -1);
  Node tail = new Node(-1, -1);

  public LRUCache(int _capacity) {
    this.capacity = _capacity;
    head.next = tail;
    tail.prev = head;
    map = new HashMap<>();
  }

  public int get(int key) {
    Node node = map.get(key);
    if (node != null) {
      delete(node);
      insert(node);
      return node.val;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      node.val = value;
      delete(node);
      insert(node);
    } else {
      if (map.size() == capacity) {
        //delete the LRU node
        Node lru = tail.prev;
        delete(lru);
      }
      Node node = new Node(key, value);
      map.put(key, node);
      insert(node);
    }
  }

  public void delete(Node node) {
    map.remove(node.key);
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  //Insertion always happen after head
  public void insert(Node node) {
    map.put(node.key, node);
    Node next = head.next;
    head.next = node;
    node.prev = head;
    node.next = next;
    next.prev = node;
  }

  public void printList() {
    Node curr = head;
    curr = curr.next;
    while (curr != tail) {
      System.out.println("{ key:" + curr.key + "val:" + curr.val + "}");
    }
  }

  static class Node {

    Node prev;
    Node next;
    int key, val;

    Node(int key_, int val_) {
      this.key = key_;
      this.val = val_;
    }

    @Override
    public String toString() {
      return "Node{" +
          "val=" + val +
          ", key=" + key +
          ", next=" + next +
          '}';
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new
 * LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */