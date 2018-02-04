//#518
//dp[i][j] -> the number of combinations that can make up amount j by using first i types of coins
//1.do not use the i th coin, only use the the first i-1 coins to make up amount j, we have dp[i-1][j] ways
//2.use the i th coin, since there's unlimited usage for same coin, we need to know how many ways to make up
//  amount j - coins[i] by using first i coins (including i th) --> dp[i][j-coins[i]] 
class CoinChangeII {

	//2-D
	//edge case: amount = 0 && coins =[] -> return 1
	//           amount != 0 && coins =[] -> return 0
	public int coinChangeII(int amount, int[] coins) {
		int[][] dp = new int[coins.length+1][amount+1];
		dp[0][0] = 1;
		for (int i = 1; i < coins.length+1; i++) {
			dp[i][0] = 1;
			for (int j = 1; j < amount+1; j++) {
				dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
			}
		}
		return dp[coins.length][amount];
	}

  //1-D
  //since dp[i][j] only relies on dp[i-1][j] and dp[i][j-coins[i]], the 2-D can be changed to 1-D
  public int coinChangeII_1D(int amount, int[] coins) {
  	if (coins == null || coins.length == 0) {
  		return 0;
  	}
  	int[] dp = new int[amount+1];
  	dp[0] = 1;
  	for (int coin : coins) {
  		for(int i = coin; i <= amaount; i++) {
  			dp[i] += dp[i-coin];
  		}
  	}
  	return dp[amount];
  }
}