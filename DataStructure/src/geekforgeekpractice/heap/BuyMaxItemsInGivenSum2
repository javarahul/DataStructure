package geeksforgeeks.heap;

import java.util.PriorityQueue;

public class BuyMaxItemsInGivenSum2 {

	public static void main(String[] args) {
		int cost[] = new int[] { 1, 12, 5, 111, 200 };
		int sum = 10;
		int result = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < cost.length; i++) {
			pq.add(cost[i]);
		}

		for (int i = 0; i < cost.length; i++) {
			if (pq.peek() <= sum) {
				sum -= pq.poll();
				result++;
			} else {
				break;
			}
		}
		System.out.println(result);
	}
}
