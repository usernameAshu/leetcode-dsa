package linkedlist;

public class DoubleNode {

  public DoubleNode prev;
  public int val;
  public DoubleNode next;

  DoubleNode() {
  }

  DoubleNode(int val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return "Node{" + "val=" + val + " next=" + next + "}";
  }
}
