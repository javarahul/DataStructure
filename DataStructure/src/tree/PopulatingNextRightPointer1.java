package tree;

import java.util.LinkedList;

public class PopulatingNextRightPointer1 {

	public static void main(String[] args) {
		LinkNode root = initializeTree();

		System.out.println("Preorder Traversal of the BST:-> ");
		LinkNode tempRoot = root;
		printPreorder(tempRoot);
		System.out.println();

		populatenextPointer(root);

		display(root);

	}

	private static void display(LinkNode root) {
		  // Let us check the values of next pointers 
        int a = root.next != null ?  
                          root.next.val : -1; 
        int b = root.left.next != null ?  
                          root.left.next.val : -1; 
        int c = root.right.next != null ? 
                            root.right.next.val : -1; 
        int d = root.left.left.next != null ? 
                        root.left.left.next.val : -1; 
        int e = root.right.right.next != null ?  
                        root.right.right.next.val : -1; 
           
        // Now lets print the values 
        System.out.println("Following are populated next pointers in "
                + " the tree(-1 is printed if there is no next)"); 
        System.out.println("next of " + root.val + " is " + a); 
        System.out.println("next of " + root.left.val + " is " + b); 
        System.out.println("next of " + root.right.val + " is " + c); 
        System.out.println("next of " + root.left.left.val +  
                                                              " is " + d); 
        System.out.println("next of " + root.right.right.val +  
                                                              " is " + e); 		
	}

	private static void populatenextPointer(LinkNode root) {
		if (root == null) {
			return;
		}

		LinkedList<LinkNode> nodesList = new LinkedList<>();
		LinkedList<Integer> levelList = new LinkedList<>();

		nodesList.offer(root);
		levelList.offer(1);

		while (!nodesList.isEmpty()) {
			LinkNode currHead = nodesList.poll();
			int currLevel = levelList.poll();

			if (levelList.isEmpty()) {
				currHead.next = null;
			} else if (levelList.peek() > currLevel) {
				currHead.next = null;
			} else {
				currHead.next = nodesList.peek();
			}

			if (currHead.left != null) {
				nodesList.offer(currHead.left);
				levelList.offer(currLevel + 1);
			}

			if (currHead.right != null) {
				nodesList.offer(currHead.right);
				levelList.offer(currLevel + 1);
			}
		}
	}

	private static LinkNode initializeTree() {
		LinkNode root = new LinkNode(10);
		root.left = new LinkNode(20);
		root.right = new LinkNode(30);
		root.left.left = new LinkNode(40);
		root.left.right = new LinkNode(50);
		root.right.left = new LinkNode(60);
		root.right.right = new LinkNode(70);

		return root;
	}

	private static void printPreorder(LinkNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}
}

class LinkNode {
	int val;
	LinkNode left;
	LinkNode right;
	LinkNode next;

	public LinkNode(int val) {
		this.val = val;
		left = null;
		right = null;
		next = null;
	}
}