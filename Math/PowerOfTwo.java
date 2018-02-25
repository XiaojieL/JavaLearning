//#231
class PowerOfTwo {
	//iterative O(log n)
	public boolean isPowerOfTwo(int n) {
		if (n <= 0) return false;
		while (n % 2 == 0) {
			n = n / 2;
		}
		return n == 1;
	}

	//recursive O(log n)
	public boolean isPowerOfTwo(int n) {
		if (n <= 0) return false;
		return n == 1 || (n % 2 == 0 && isPowerOfTwo(n/2));
	}
}