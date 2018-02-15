//#362
class HitCounter {
	Deque<Long> deque;
	Map<Long, Integer> map;
	long FIVE_MIN = 5 * 60 * 1000;
	int totalCount;
	public HitCounter() {
		deque = new LinkedList<Long>();
		map = new HashMap<Long, Integer>();
		totalCount = 0;
	}

	public void hit(long timestamp) {
    while(!deque.isEmpty() && deque.peekFirst() < timestamp - FIVE_MIN) {
    	long oldestTimestamp = deque.pollFirst();
    	totalCount -= map.get(oldestTimestamp);
    	map.remove(oldestTimestamp);
    }

    if (deque.peekLast() != timestamp) {
    	deque.addLast(timestamp);
    }

    if (!map.containsKey(timestamp)) {
    	map.add(timestamp, 1);
    } else {
    	map.add(timestamp, map.get(timestamp)+1);
    }
	}

	public int getHits(long timestamp) {
		if (timestamp - deque.peekLast() > 5)

	}


}