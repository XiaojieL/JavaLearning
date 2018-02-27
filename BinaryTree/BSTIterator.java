//#173
public class BSTIterator {
		Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
    	stack = new Stack<>();
    	TreeNode node = root;
    	while (node != null) {
    		stack.push(node);
    		if (node.left != null) {
    			node = node.left;
    		} else { //must have else break condition, otherwise while loop is stuck at node itself
    			break;
    		}
    	}
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    		TreeNode node = stack.pop();
    		TreeNode curr = node;
    		if (curr.right != null) {
    			curr = curr.right;
    			while (curr != null) {
    				stack.push(curr);
    				if (curr.left != null) {
    					curr = curr.left;
    				} else {
    					break;
    				}
    			}
    		}
    		return node.val;
    }
}