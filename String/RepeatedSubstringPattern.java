//#459
class RepeatedSubstringPattern {
  public boolean repeatedSubstringPattern(String s) {
    int totalLen = s.length();
    int subLen = totalLen / 2;
    for (int i = subLen; i >= 1; i--) {
      if (totalLen % i == 0) {
        int count = totalLen / i;
        String sub = s.substring(0, i);
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (start < count) {
          sb.append(sub);
          start++;
        }
        if (sb.toString().equals(s)) return true;
      }
    }
    return false;
  }
}
