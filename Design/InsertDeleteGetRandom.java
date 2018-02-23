//380
class RandomizedSet {
		private Map<Integer, Integer> keyMap;
		private Map<Integer, Integer> valueMap;
		int count;
    

    /** Initialize your data structure here. */
    public RandomizedSet() {
    	keyMap = new HashMap<>();
    	valueMap = new HashMap<>();
    	count = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
      if (keyMap.containsKey(val)) {
      	return false;
      } else {
      	keyMap.put(val, count);
      	valueMap.put(count, val);
      	count = keyMap.size();
      	return true;
      }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
      if (!keyMap.containsKey(val)) {
      	return false;
      } else {
      	int valCount = keyMap.get(val);
      	keyMap.remove(val);
      	if (valCount != valueMap.size()-1) {
      		valueMap.put(valCount, valueMap.get(valueMap.size()-1));
      		keyMap.put(valueMap.get(valueMap.size()-1), valCount);
      		valueMap.remove(valueMap.size()-1);
      	} else {
      		valueMap.remove(valCount);
      	}
      	count = keyMap.size();
      	return true;
      }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	Random random = new Random();
    	int n = random.nextInt(keyMap.size());
    	return valueMap.get(n);
        
    }
}