package leatcode.interview.easy;

public class MaxProfitStock_121 {
	public static void main(String[] args) {
		int prices[] = { 7, 1, 5, 3, 6, 4 };

		int maxProfit = getMaxProfit(prices);
		System.out.println("MaxProfit:-> " + maxProfit);
	}

	private static int getMaxProfit(int[] prices) {
		int maxProfit = 0;
		int left = 0;
		int right = 1;
		while (right < prices.length) {
			if (prices[right] > prices[left]) {
				int profit = prices[right] - prices[left];
				maxProfit = Math.max(maxProfit, profit);
			} else {
				left = right;
			}
			right++;
		}
		return maxProfit;
	}
}
