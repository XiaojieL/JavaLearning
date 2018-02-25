//#400
/*
1-9: len: 1, count: 9, startNum = 1;
10-99: len: 2, count: 90, startNum = 10;
when n > len * count, it means the target startNum is out of the current len & count bucket
eg, if n = 188, n > 1*9, target startNum is not within 1-9
n -= 1*9 ---> n = 179
len += 1 ---> len = 2
count *= 10 ---> count = 90
startNum *= 10 ---> startNum = 10

179 < 2 * 90 --> target should be within 10-99
start += (n-1) / len ==> currently n already subtracted all nums from the previous bucket
												 meaning it is the counting from 1 from the startNum, since we start
												 from 10 (100, 1000...), startNum += (n-1) / len
												 eg. if starting n = 11, 11 - 1*9 = 2, startNum = 10 + (2-1)/2 = 10

*/
class NthDigit {
	public int findNthDigit(int n) {
		int len = 1;
		int count = 9;
		int startNum = 1;
		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			startNum *= 10;
		}
		startNum += (n-1) / len;
		String s = String.valueOf(startNum);
		int res = Character.getNumericValue(s.charAt((n-1)%len));
		return res;
	}
}