// https://www.glassdoor.com/Interview/You-are-given-a-phone-keypad-1-2-3-4-5-6-7-8-9-x-0-x-and-a-Knight-from-a-game-of-chess-write-a-program-that-given-two-in-QTN_1908856.htm
class NumCombination {
	Map<Integer, Set<Integer>> map = new HashMap<>();
	Set<Integer> s1 = new HashSet<>();
	s1.add(6, 8);
	map.put(1, s1);
	...

	int[] arr = new int[10];

	int totalCount(int k, int n) {
		if (k == 1) return 1;
		if (n == 5) return -1;
		int res = 0;
		
		for (int each : map.get(n)) {
			arr[each]++;
			res += totalCount(k-1, each);
		}
		return res;
	}
}