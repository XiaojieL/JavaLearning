//#234
/*
Use two pointers to get to the middle element,
reverse the second half,
compare the first half and reversed second half
*/

class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		//when node count is odd, move slow to the next one
		//thus the second half is shorter
		if (fast != null) {
			slow = slow.next;
		}
		slow = reverse(slow);
		fast = head;
		while (slow != null && fast != null) {
			if (slow.val == fast.val) {
        slow = slow.next;
        fast = fast.next;
			} else {
				return false;
			}
		}
		return true;
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}