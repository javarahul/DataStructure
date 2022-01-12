package hashing;

import java.util.HashMap;
import java.util.Map;

public class FrequencyArray {
	public static void main(String[] args) {
		int arr[] = { 15, 12, 13, 12, 13, 13, 18 };
		printFreq(arr);
	}

	private static void printFreq(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
