//#760
class FindAnagramMappings {
	public int[] anagramMappings(int[] A, int[] B) {
		int[] res = new int[A.length];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < B.length; i++) {
			map.put(B[i], i);
		}
		for (int j = 0; j < A.length; j++) {
			res[j] = map.get(A[j]);
		}
		return res;
	}
}