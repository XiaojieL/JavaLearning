//#86
class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		//A node is created first, each pointer points to that node
		//Use two pointers to keep track of nodes whose value >= x or < x
	  ListNode h1 = new ListNode(0);
	  ListNode h2 = new ListNode(0);
	  ListNode curr1 = h1;
	  ListNode curr2 = h2;
	  while (head != null) {
	  	if (head.val < x) {
	  		curr1.next = head;
	  		curr1 = head;
	  	} else {
	  		curr2.next = head;
	  		curr2 = head;
	  	}
	  	head = head.next;
	  }
	  //Since curr2 keeps track of nodes >= x, needs to set last one's next to null
	  curr2.next = null;
	  curr1.next = h2.next;
	  return h1.next;
	}
}