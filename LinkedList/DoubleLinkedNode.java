class DoubleLinkedNode {
  int val;
  DoubleLinkedNode prev, next;
  DoubleLinkedNode(int val) {
    this.val = val;
    this.prev = this.next = null;
  }
}

public DoubleLinkedNode reverse(DoubleLinkedNode head) {
  DoubleLinkedNode curr = null;
  while (head != null) {
    curr = head;
    //move head pointer to the next one
    head = curr.next;
    //reverse
    curr.next = curr.prev;
    curr.prev = head;
  }
  //curr is pointing to the old last non-null item, which should be the new
  //first non-null item as new head
  return curr;
}
