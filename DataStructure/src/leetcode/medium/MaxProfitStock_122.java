package leatcode.interview.easy;

public class MaxProfitStock_122 {

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int maxProfit = maxProfit(prices);
		System.out.println(maxProfit);
	}

	public static int maxProfit(int[] prices) {
		int buyingDate = 0;
		int sellingDate = 0;
		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] >= prices[i - 1]) {
				sellingDate++;
			} else {
				maxProfit += prices[sellingDate] - prices[buyingDate];
				buyingDate = sellingDate = i;
			}
		}
		maxProfit += prices[sellingDate] - prices[buyingDate];

		return maxProfit;
	}
}
