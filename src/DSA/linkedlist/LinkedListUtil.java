package DSA.linkedlist;

public class LinkedListUtil {

  public static ListNode createLinkedList() {
    ListNode node = new ListNode(2);
    node.next = new ListNode(1);
    node.next.next = new ListNode(5);
    node.next.next.next = new ListNode(8);
    node.next.next.next.next = new ListNode(3);

    return node;
  }

  public static void iterateListNode(ListNode node) {
    while (node != null) {
      System.out.print(node.val+" ");
      node = node.next;
    }
  }

}
