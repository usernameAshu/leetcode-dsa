package linkedlist;

import static linkedlist.LinkedListUtil.*;

public class SortLinkedList {

  public static void main(String[] args) {
    ListNode head = createLinkedList();

    iterateListNode(head);
    System.out.println();
    ListNode newHead = sort(head);
    iterateListNode(newHead);
  }

  static ListNode sort(ListNode head) {

    if(head == null || head.next == null) {
      return head;
    }

    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = head;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    //now fast has reached at end
    //slow is at mid
    //prev is previous of slow
    if (prev != null) {
      prev.next = null; // cut off 1st half of the list
    }
    ListNode head1 = sort(head);
    ListNode head2 = sort(slow);
    return merge(head1, head2);
  }

  static ListNode merge(ListNode head1, ListNode head2) {
    ListNode ansHead = new ListNode(-1);
    ListNode ansTail = ansHead;

    while (head1 != null && head2 != null) {
      if(head1.val < head2.val) {
          ansTail.next = new ListNode(head1.val);
          head1 = head1.next;

      } else {
          ansTail.next = new ListNode(head2.val);
          head2 = head2.next;
      }
      ansTail = ansTail.next;
    }

    while (head1 != null) {
      ansTail.next = new ListNode(head1.val);
      head1 = head1.next;
      ansTail = ansTail.next;
    }

    while (head2 != null) {
      ansTail.next = new ListNode(head2.val);
      head2 = head2.next;
      ansTail = ansTail.next;
    }

    return ansHead.next;
  }

}
