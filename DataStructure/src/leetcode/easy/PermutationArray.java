import java.util.ArrayList;
import java.util.List;

public class PermutationArray {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3 };
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		permute(array, result, 0);

		System.out.println(result);
	}

	private static void permute(int[] array, List<List<Integer>> result, int index) {
		if (index == array.length - 1) {
			List<Integer>arrayList = new ArrayList<Integer>();
			for (int i = 0; i<array.length;i++) {
				arrayList.add(array[i]);
			}
			result.add(arrayList);
			return;
		}

		for (int i = index; i < array.length; i++) {
			swap(i, index, array);
			permute(array, result, index + 1);
			swap(i, index, array);
		}
	}

	private static void swap(int i, int index, int[] array) {
		int temp = array[i];
		array[i] = array[index];
		array[index] = temp;
	}
}
