class DesignCompressedStringIterator {
  List<Character> charList = new ArrayList<>();
  List<Integer> countList = new ArrayList<>();
  int pointer = 0;

  public StringIterator(String compressedString) {
    int i = 0;
    while (i < compressedString.length()) {
      int index = 0;
      if (Character.isLetter(compressedString.charAt(i))) {
        charList.add(compressedString.charAt(i));
        i++;
        index = i;
      }
      while (i < compressedString.length() && !Character.isLetter(compressedString.charAt(i))) {
        i++;
      }
      countList.add(Integer.valueOf(compressedString.substring(index, i)));
    }
  }

  public char next() {
    if (!hasNext()) return ' ';
    char c = charList.get(pointer);
    countList.set(pointer, countList.get(pointer)-1);
    if (countList.get(pointer) == 0) pointer++;
    return c;
  }

  public boolean hasNext() {
    return pointer < charList.size();
  }
}
