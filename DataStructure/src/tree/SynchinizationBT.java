package tree;

import java.util.LinkedList;

public class SynchinizationBT {

	public static void main(String[] args) {
		String preOrderStr = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		System.out.println("Elements in PreOrder:-> " + preOrderStr);
		System.out.println();

		boolean isSynchronized = getValidSynchronization(preOrderStr);

		System.out.println("Tree is synchronized: " + isSynchronized);
	}

	private static boolean getValidSynchronization(String preOrderStr) {
		LinkedList<String> list = new LinkedList<>();
		String[] arr = preOrderStr.split(",");

		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);

			while (list.size() >= 3 && list.get(list.size() - 1).equals("#") && list.get(list.size() - 2).equals("#")
					&& !list.get(list.size() - 3).equals("#")) {
				list.remove(list.size() - 1);
				list.remove(list.size() - 1);
				list.remove(list.size() - 1);

				list.add("#");
			}
		}

		if (list.size() == 1 && list.get(0).equals("#")) {
			return true;
		}

		return false;
	}
}
