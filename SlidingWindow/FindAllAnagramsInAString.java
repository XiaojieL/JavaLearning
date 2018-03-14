class FindAllAnagramsInAString {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    int len = p.length();
    int start = 0;
    int end = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (char c : p.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0)+1);
    }
    int counter = map.size();
    while (end < s.length()) {
      char endC = s.charAt(end);
      if (map.containsKey(endC)) {
        map.put(endC, map.get(endC) - 1);
        if (map.get(endC) == 0) counter--;
      }
      end++;
      while (counter == 0) {
        if (end-start == len) res.add(start);
        char startC = s.charAt(start);
        if (map.containsKey(startC)) {
          map.put(startC, map.get(startC)+1);
          if (map.get(startC) > 0) counter++;
        }
        start++;
      }
    }
    return res;
  }
}
