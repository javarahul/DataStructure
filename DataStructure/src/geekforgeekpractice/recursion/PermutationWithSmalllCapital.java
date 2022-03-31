public class PermutationWithSmalllCapital {

	public static void main(String[] args) {
		String[] array = { "a", "b" };
		solution(array, "", 0);
	}

	private static void solution(String[] input, String output, int index) {
		if (index == input.length) {
			System.out.println(output);
			return;
		}

		String op1 = output + input[index];
		String ch = input[index];
		String op2 = output + Character.toUpperCase(ch.charAt(0));
		index = index + 1;
		solution(input, op1, index);
		solution(input, op2, index);
	}
}
