public class BinarySearch {

	public static void main(String[] args) {
		int array[] = { 2, 4, 8, 10, 11, 12, 14, 17, 19, 20 };
		System.out.println("Eanter a number which you want to search:-> ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int index = binarySearch(array, num);
		if (index > -1) {
			System.out.println(num + " present in index:-> " + index);
		} else {
			System.out.println(num + " not present");
		}
	}

	private static int binarySearch(int[] array, int num) {
		int start = 0;
		int end = array.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (num < array[mid]) {
				end = mid - 1;
			} else if (num > array[mid]) {
				start = mid + 1;
			} else if (num == array[mid]) {
				return mid;
			}
		}
		return -1;
	}
}
