//#155
class MinStack {
		private Stack<Integer> numStack;
		private Stack<Integer> minNumStack;
	    /** initialize your data structure here. */
    public MinStack() {
        numStack = new Stack<>();
        minNumStack = new Stack<>();
    }
    
    public void push(int x) {
				numStack.push(x);
				if (minNumStack.isEmpty() || x <= minNumStack.peek()) {
					minNumStack.push(x);
				}
    }
    
    public void pop() {
    	  int x = numStack.pop();
        if (x == minNumStack.peek()) {
        	minNumStack.pop();
        }
    }
    
    public int top() {
        return numStack.peek();
    }
    
    public int getMin() {
        return minNumStack.peek();
    }
}