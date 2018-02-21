//#415
class AddStrings {
  public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    int sum = 0;
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    while (i >= 0 && j >=0) {
      sum = (num1.charAt(i) -'0'+ num2.charAt(j) - '0' + carry) % 10;
      carry = (num1.charAt(i) -'0'+ num2.charAt(j) - '0' + carry) / 10;
      sb.append(sum);
      i--;
      j--;
    }
    while (i >= 0) {
      sum = (num1.charAt(i) - '0' + carry) % 10;
      carry = (num1.charAt(i) -'0'+ carry) / 10;
      sb.append(sum);
      i--;
    }
    while (j >= 0) {
      sum = (num2.charAt(j) -'0' + carry) % 10;
      carry = (num2.charAt(j) -'0'+ carry) / 10;
      sb.append(sum);
      j--;
    }
    if (carry > 0) sb.append(carry);
    return sb.reverse().toString();        
  }
}
