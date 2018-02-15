//#346
class MovingAverage {
	private Queue<Integer> queue;
	private double sum = 0.0;
	private int size;

	public MovingAverage(int size) {
		//remember to initialize the queue to avoid null pointer exception later
		queue = new LinkedList<Integer>();
		this.size = size;
	}

	public double next(int val) {
		if (queue.size() == size) {
			sum -= queue.pop();
		}
		queue.add(val);
		sum += val;
		return sum / queue.size();
	}
}