package linkedlist;

public class DoublyLinkedList {

  static DoubleNode head = new DoubleNode();
  static DoubleNode tail = new DoubleNode();
  static int size = 0;

  public static void main(String[] args) {
    head.val = 10;
    DoubleNode next = new DoubleNode(11);
    head.next = next;
    next.prev = head;
    DoubleNode next2 = new DoubleNode(12);
    next.next = next2;
    next2.prev = next;
    tail = next2;
    size = 3;

    printDoubleLinkedList();
    insertNode(new DoubleNode(20));
    insertNode(new DoubleNode(30));
    insertHead(new DoubleNode(5));
    insertNode(3, new DoubleNode(99));
    printDoubleLinkedList();
    System.out.println("Size of list:" + size);
    deleteNodeAt(3);
    printDoubleLinkedList();
    System.out.println("Size of list:" + size);


  }

  public static void deleteNodeAt(int position) {
    if(position < 1 || position > size+1) {
      System.out.println("Invalid positon!");
      return;
    }
    if(position == 1) {
      //deletehead
      deletehead();
      return;
    }
    if(position == size) {
      //deleteTail
      deleteTail();
      return;
    }

    DoubleNode curr = head;
    while(position > 1) {
      curr = curr.next;
      position--;
    }
    DoubleNode prev = curr.prev;
    DoubleNode next = curr.next;
    //connect prev with next
    prev.next = next;
    next.prev = prev;
    size--;

  }

  public static boolean deletehead() {
    if(head != null) {
      head = head.next;
      size--;
      return true;
    }
      System.out.println("List empty");
      return false;
  }

  public static boolean deleteTail() {
    if(tail != null) {
      tail = tail.prev;
      size--;
      return true;
    }
      System.out.println("List empty");
      return false;
  }

  public static void insertNode(DoubleNode node) {
    insertTail(node);
  }

  public static void insertNode(int position, DoubleNode node) {
    if (position == 1) {
      insertHead(node);
      return;
    }
    if (position == size + 1) {
      insertTail(node);
      return;
    }
    DoubleNode prev;
    DoubleNode next = head;
    //1 based indexing
    while (position > 1) {
      next = next.next;
      position--;
    }
    prev = next.prev;
    //insertion
    prev.next = node;
    node.prev = prev;
    node.next = next;
    next.prev = node;
    size++;
  }

  public static void insertHead(DoubleNode node) {
    DoubleNode temp = head;
    node.next = temp;
    temp.prev = node;
    head = node;
    size++;
  }

  public static void insertTail(DoubleNode node) {
    DoubleNode temp = tail;
    node.prev = temp;
    temp.next = node;
    tail = node;
    size++;
  }

  public static void printDoubleLinkedList() {
    DoubleNode curr = head;
    while (curr != null) {
      if (curr.next == null) {
        System.out.print(curr.val);
      } else {
        System.out.print(curr.val + "->");
      }
      curr = curr.next;
    }
    System.out.println();
  }

  public static void printDoubleLinkedList_Reverse() {
    DoubleNode curr = tail;
    while (curr != null) {
      if (curr.prev == null) {
        System.out.print(curr.val);
      } else {
        System.out.print(curr.val + "->");
      }
      curr = curr.prev;
    }
    System.out.println();
  }


}
