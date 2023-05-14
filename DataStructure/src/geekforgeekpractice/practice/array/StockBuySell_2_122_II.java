package geeksforgeeks.practice.array;

public class StockBuySell_2_122_II {

	public static void main(String[] args) {
//		int price[] = { 1, 5, 3, 8, 12 };
		int price[] = { 7, 1, 5, 3, 6, 4 };
		int maxProfit = getMaxProfit(price);
		System.out.println("Max Profit is: " + maxProfit);
	}

	public static int getMaxProfit(int price[]) {
		int maxProfit = 0;
		for (int i = 1; i < price.length; i++) {
			if (price[i] > price[i - 1]) {
				maxProfit += price[i] - price[i - 1];
			}
		}
		return maxProfit;
	}
}
