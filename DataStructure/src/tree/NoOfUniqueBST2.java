package tree;

import java.util.Scanner;

public class NoOfUniqueBST2 {
		public static void main(String[] args) {
			System.out.println("Enter number till which we need to make BST:-> ");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();

			int noOfBST = numOfTrees(n);
			System.out.println("No of BST:-> " + noOfBST);
		}

		private static void preOrder(Node node) {
			if (node == null) {
				return;
			}
			System.out.print(node.val + " ");
			preOrder(node.left);
			preOrder(node.right);
		}

		private static int numOfTrees(int n) {
			int count[] = new int[n + 1];
			count[0] = 1;
			count[1] = 1;
			for (int i = 2; i <= n; i++) {
				for (int j = 0; j <= i - 1; j++) {
					count[i] = count[i] + count[j] * count[i - j - 1];
				}
			}

			return count[n];
		}
	}
