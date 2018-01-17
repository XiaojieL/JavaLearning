//#237, the given node is not the tail node
class DeleteNode {
	public void deleteNode(ListNode node) {
	  node.val = node.next.val;
	  node.next = node.next.next;
	}
}