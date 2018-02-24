//#346
class MovingAverageFromDataStream {
  Queue<Integer> queue;
  double currSum;
  int maxSize;
  /** Initialize your data structure here. */
  public MovingAverage(int size) {
      this.queue = new LinkedList<>();
      this.maxSize = size;
      this.currSum = 0.0;
  }

  public double next(int val) {
      if (queue.size() < maxSize) {
        queue.add(val);
        currSum += val;
      } else {
        currSum -= queue.poll();
        queue.add(val);
        currSum += val;
      }
      return currSum / queue.size();
  }
}
