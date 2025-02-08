package linkedlist;

import static linkedlist.LinkedListUtil.createLinkedList;
import static linkedlist.LinkedListUtil.iterateListNode;

public class ReverseLinkedList {

  public static void main(String... args) {
    ListNode head = createLinkedList();

    iterateListNode(head);
    System.out.println();
    head = reverse(head);
    iterateListNode(head);
  }

  static ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    ListNode next = null;

    while(curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }

}
