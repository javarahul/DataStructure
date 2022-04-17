package binarysearch;

public class NextGtreatestLetter {

	public static void main(String[] args) {
		char[] letters = { 'c', 'f', 'j' };
		char target = 'z';
		char nextLetter = nextGreatestLetter(letters, target);
		System.out.println("Next letter of " + target + " is:-> " + nextLetter);
	}

	public static char nextGreatestLetter(char[] letters, char target) {
		char nextLetter = letters[0];
		int start = 0;
		int end = letters.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (letters[mid] == target) {
				start = mid + 1;
			} else if (letters[mid] > target) {
				nextLetter = letters[mid];
				end = mid - 1;
			} else if (letters[mid] < target) {
				start = mid + 1;
			}
		}
		return nextLetter;
	}
}
