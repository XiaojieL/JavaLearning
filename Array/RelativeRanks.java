//#506
class RelativeRanks {
	public String[] findRelativeRanks(int[] nums) {
		String[] res = new String[nums.length];

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		Arrays.sort(nums);

        for (int j = nums.length - 1; j >= 0; j--) {
            int ranking = nums.length - j;
            int oldPos = map.get(nums[j]);
            if (ranking == 1) res[oldPos] = "Gold Medal";
            else if (ranking == 2) res[oldPos] = "Silver Medal";
            else if (ranking == 3) res[oldPos] = "Bronze Medal";
            else res[oldPos] = String.valueOf(ranking);
        }

	
		return res;
	}
}