public class SortAnArray {

	public static void main(String[] args) {
		int array[] = { 1, 5, 0, 2 };
		LinkedList<Integer> arrayItem = new LinkedList<>();
		for (int a : array) {
			arrayItem.add(a);
		}
		sort(arrayItem);
		System.out.println(arrayItem);
	}

	private static void sort(LinkedList<Integer> array) {
		if (array.size() == 1) {
			return;
		}

		int lastItem = array.peekLast();
		array.pollLast();
		sort(array);
		insert(array, lastItem);
	}

	private static void insert(LinkedList<Integer> array, int lastItem) {
		if (array.size() == 0|| array.peekLast()<=lastItem) {
			array.addLast(lastItem);;
			return;
		}
		
		int val = array.peekLast();
		array.pollLast();
		insert(array, lastItem);
		array.addLast(val);
	}

}
