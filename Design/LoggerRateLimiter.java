//#359
//Only updates the timestamp when a message is printed
class LoggerRateLimiter {
  Map<String, Integer> map;
  public Logger() {
    this.map = new HashMap<>();
  }
  public boolean shouldPrintMessage(int timestamp, String message) {
    if (!map.containsKey(message)) {
      map.put(message, timestamp);
      return true;
    } else {
      if (timestamp - map.get(message) < 10) {
        return false;
      } else {
        map.put(message, timestamp);
        return true;
      }
    }
  }
}
