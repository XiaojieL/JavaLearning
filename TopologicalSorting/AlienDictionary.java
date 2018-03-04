class AlienDictionary {
	public String alienOrder(String[] words) {
		//track relationship among chars, when char a comes before char b
		//key: a -> value: <b>
		Map<Character, Set<Character>> charMap = new HashMap<>();
		//track each char's indegree
		Map<Character, Integer> indegreeMap = new HashMap<>();

		for (String s : words) {
			for (char c : s.toCharArray()) {
				//put every char into the indegree map with indegree value as 0
				indegreeMap.put(c, 0);
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String s1 = words[i];
			String s2 = words[i+1];
			//only check char until shorter string's len
			int minLen = Math.min(s1.length(), s2.length());
			for (int j = 0; j < minLen; j++) {
				char c1 = s1.charAt(j);
				char c2 = s2.charAt(j);
				//when chars at same positions are different, it means char from the first string
				//comes before char from the seconde one
				//eg. s1 = wrt s2 = wrf, t comes before f
				if (c1 != c2) {
	        charMap.putIfAbsent(c1, new HashSet<>());
	        if (!charMap.get(c1).contains(c2)) {
	            charMap.get(c1).add(c2);
	            indegreeMap.put(c2, indegreeMap.get(c2) + 1);
	        }
	        //break from the loop when already having a diff
	        break;
	      }
			}
		}

		Queue<Character> queue = new LinkedList<>();
		for (char charC : indegreeMap.keySet()) {
			if (indegreeMap.get(charC) == 0) {
				queue.add(charC);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			char curr = queue.poll();
			sb.append(curr);
			if (map.containsKey(curr)) {
			for (char subC : charMap.get(curr)) {
				indegreeMap.put(subC, indegreeMap.get(subC) - 1);
				if (indegreeMap.get(subC) == 0) {
					queue.add(subC);
				}
			}				
			}
		}

		//reasons why need to check result length:
		//the original words might contain cycle
		//eg: wa, wb, wc, waf
		if (sb.toString.length != indegreeMap.size()) return "";
		return sb.toString();
	}
}