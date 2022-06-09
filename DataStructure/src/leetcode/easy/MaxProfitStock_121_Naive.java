package leatcode.interview.easy;

public class MaxProfitStock_121_Naive {
	public static void main(String[] args) {
		int prices[] = { 7, 1, 5, 3, 6, 4 };

		int maxProfit = getMaxProfit(prices);
		System.out.println("MaxProfit:-> " + maxProfit);
	}

	private static int getMaxProfit(int[] prices) {
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i; j < prices.length; j++) {
				int currProfit = prices[j] - prices[i];
				if (maxProfit < currProfit) {
					maxProfit = currProfit;
				}
			}
		} //// Current is o{n2) return maxProfit; }
		return maxProfit;
	}
}
