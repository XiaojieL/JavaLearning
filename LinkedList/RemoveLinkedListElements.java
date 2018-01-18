//#203
class RemoveLinkedListElements {
  //iterative
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode curr = head;
		while (curr != null) {
			//if curr.val equals val, delete curr, which means making prev.next point
			//to curr.next, which will pass curr
			//ATTN: even we make prev.next pointing to curr.next, we still do not know 
			//if this curr.next.val equals to val or not, so DO NOT move prev at this step
			if (curr.val == val) {
				prev.next = curr.next;
			} else {
				//only when curr.val doesn't equal to val, move prev
				prev = prev.next;
			}
			curr = curr.next;
    }
    return dummy.next;
	}

}