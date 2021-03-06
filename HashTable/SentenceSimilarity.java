//#734
class SentenceSimilarity {
	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
	  if (worsd1.length != words2.length) return false;
	  Map<String, Set<String>> map = new HashMap<>();
	  //add both p[0] & p[1] as key into map to make sure they both exist 
	  for (String[] p : pairs) {
	  	Set<String> s1 = map.getOrDefault(p[0], new HashSet<>());
	  	s1.add(p[1]);
	  	map.put(p[0], s1);
	  	Set<String> s2 = map.getOrDefault(p[1], new HashSet<>());
	  	s2.add(p[0]);
	  	map.put(p[1], s2);
	  }
	  for (int i = 0; i < words1.length; i++) {
	  	if (words1[i].equals(words2[i])) continue;
	  	if (map.containsKey(words1[i]) && map.get(words1[i]).contains(words2[i])) continue;
	  	else return false;
	  }
	  return true;
	
	}
}