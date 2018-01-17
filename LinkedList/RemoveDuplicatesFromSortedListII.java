//#82
class RemoveDuplicatesFromSortedListII{
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode curr = head;
		while (curr != null) {
			//as long as current node's value equals its next node's value,
			//move curr pointer to the next one
			//the curr pointer will stop at the last node that has duplicate value
			//eg. 1->1->1->2, curr will be moved to the third 1
			while (curr.next != null && curr.val == curr.next.val) {
				curr = curr.next;
			}
			//if prev.next is curr, which means curr has not been moved, curr is not 
			//duplicates, move prev to prev's next, which is curr
			if (prev.next == curr) {
				prev = prev.next;
			} else {
				//if prev.next is not curr, which means curr has been moved, curr is 
				//pointing to the last duplicate node, prev.next should point to curr's
				//next;
				//ATTENTION: prev.next = curr.next, do not move prev here since we do not
				//know if curr.next has duplicates in later nodes
				prev.next = curr.next;
			}
			//always remember to move curr pointer!!!
			curr = curr.next;
		}
		return dummy.next;
	}
}