class MinimumWindowSubstring {
  public String minWindow(String s, String t) {
    if (s == null || t == null) return null;
    Map<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int counter = map.size();
    int start = 0;
    int e = 0;
    int len = Integer.MAX_VALUE;
    String ans = "";
    while (e < s.length()) {
      //when map contains char at end, reduce the count of this char in the Map
      //each time when a char from the map's count == 0, reduce the counter size by 1
      if (map.containsKey(s.charAt(e))) {
          map.put(s.charAt(e), map.get(s.charAt(e))-1);
          if (map.get(s.charAt(e)) == 0) counter--;
      }
      //keep end pointer moving, it will always be one bigger after processing
      //thus, when counter reaches 0, only need to get substring(start, end)
      //no need to plus one
      e++;
      while (counter == 0) {
        if (e - start < len) {
          len = e -start;
          ans = s.substring(start, e);
        }

        if (map.containsKey(s.charAt(start))) {
          map.put(s.charAt(start), map.get(s.charAt(start))+1);
          if (map.get(s.charAt(start)) > 0) counter++;
        }
        start++;
      }
    }
    return ans;
  }
}
