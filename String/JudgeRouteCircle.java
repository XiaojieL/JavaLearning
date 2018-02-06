//#657
class JudgeRouteCircle {
  public boolean judgeCircle(String moves) {
    if (moves == null || moves.length() == 0) {
      return true;
    }
    int up = 0;
    int right = 0;
    for (int i = 0; i < moves.length(); i++) {
      if (moves.charAt(i) == 'U') {
         up++;
       }
       if (moves.charAt(i) == 'D') {
         up--;
       }
       if (moves.charAt(i) == 'R') {
         right++;
       }
       if (moves.charAt(i) == 'L') {
         right--;
       }
    }
    return up == 0 && right == 0;

  }
}
