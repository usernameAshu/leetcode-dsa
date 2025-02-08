package exams;

import java.util.Deque;
import java.util.LinkedList;

public class TestAS {

  static Deque<Integer> deque = new LinkedList<>();
  static int size = 5;

  public static void main(String[] args) {
    //cache size 5
    //LRU policy
    //if c empty -> add


        // head-> {1,2,3,4,5}
        // 6 -> {1,2,3,4, }  ->5
        // {6,1,2,3,4}
    //deque , enqueing
    //if deque size if full, evict the tail (pollLast())
    //enqueue

  }
  //el = Map<Integer, Object>
   public static void addCache(int el) {
      if(deque.size() == 5) {
        //overflow
        deque.pollLast(); //evict last used el
        deque.offerFirst(el);
      } else {
        deque.offerFirst(el);
      }
   }
   public Deque<Integer> viewCache() {
     return deque;
   }

   public static void emptyCache() {
      while(!deque.isEmpty()) {
        deque.pollLast();
      }
      size = 0;
   }
}
