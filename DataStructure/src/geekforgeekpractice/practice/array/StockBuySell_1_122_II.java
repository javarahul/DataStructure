package geeksforgeeks.practice.array;

public class StockBuySell_1_122_II {

	public static void main(String[] args) {
//		int price[] = { 1, 5, 3, 8, 12 };
		int price[] = {7,1,5,3,6,4};
		int maxProfit = getMaxProfit(price, 0, price.length - 1);
		System.out.println("Max Profit is: " + maxProfit);
	}

	public static int getMaxProfit(int price[], int start, int end) {
		if (start >= end) {
			return 0;
		}
		int maxProfit = 0;
		for (int i = start; i < end; i++) {
			for (int j = i + 1; j <= end; j++) {
				if (price[j] > price[i]) {
					int currProfit = price[j] - price[i] + getMaxProfit(price, start, i - 1)
							+ getMaxProfit(price, j + 1, end);

					if (maxProfit < currProfit) {
						maxProfit = currProfit;
					}
				}
			}
		}
		return maxProfit;
	}
}
