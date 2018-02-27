//#422
class ValidWordSquare {
  public boolean validWordSquare(List<String> words) {
    if (words.size() == 0 || words == null) return true;
    for (int i = 0; i < words.size(); i++) {
      for (int j = 0; j < words.get(i).length(); j++) {
        //to make usre words.get(j).charAt(i) is safe (won't throw null pointer exception)
        //check if words.get(j).length() is smaller than i, if so, cannot get words.get(j).charAt(i)
        //ATTN, this check should come first than the char comparison check
        if (j >= words.size() || words.get(j).length() <= i ||
        words.get(i).charAt(j) != words.get(j).charAt(i)) {
          return false;
        }
      }
    }
    return true;
  }
}
