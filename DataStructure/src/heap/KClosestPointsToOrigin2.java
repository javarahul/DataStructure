package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin2 {

	class Pair {
		int first;
		int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public static void main(String[] args) {
		Integer points[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };

		int k = 2;

		kClosetPoint(points, k);
	}

	private static void kClosetPoint(Integer[][] points, int k) {
		PriorityQueue<Pair> maxHeap = new PriorityQueue<KClosestPointsToOrigin2.Pair>(new Comparator<>() {

			@Override
			public int compare(Pair p1, Pair p2) {
				int x1 = p1.first * p1.first;
				int y1 = p1.second * p1.second;
				int x2 = p2.first * p2.first;
				int y2 = p2.second * p2.second;
				return -((x1 + y1) - (x2 + y2));
			}
		});

		for (int i = 0; i < points.length; i++) {
			maxHeap.add(new KClosestPointsToOrigin2().new Pair(points[i][0], points[i][1]));
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}

		int[][] ans = new int[maxHeap.size()][2];
		int i = 0;

		while (maxHeap.size() > 0) {
			System.out.println(maxHeap.peek().first + ", " + maxHeap.peek().second);
			maxHeap.poll();
		}

	}
}
