package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class VerticalOrderTraversal1 {

	public static void main(String[] args) {
		Node root = initializeTree();

		List<List<Integer>> result = verticalOrder(root);

		System.out.println("List after Vertcal order traversal:-> " + result);
	}
	private static Node initializeTree() {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.left.left = new Node(70);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.left.left.right = new Node(80);

		return root;
	}
	public static List<List<Integer>> verticalOrder(Node root) {
	    TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
	    helper(root, map);
	    List<List<Integer>> result = new ArrayList<>();
	    result.addAll(map.values());
	    return result;
	}
	 
	private static void helper(Node t, TreeMap<Integer, ArrayList<Integer>> map) {
	    if (t == null) {
	        return;
	    }
	 
	    LinkedList<Node> q1 = new LinkedList<>();
	    LinkedList<Integer> q2 = new LinkedList<>();
	    q1.offer(t);
	    q2.offer(0);
	 
	    while (!q1.isEmpty()) {
	        Node node = q1.poll();
	        int order = q2.poll();
	 
	        //add to map
	        ArrayList<Integer> list = map.get(order);
	        if (list == null) {
	            list = new ArrayList<>();
	            map.put(order, list);
	        }
	        list.add(node.val);
	 
	        if (node.left != null) {
	            q1.offer(node.left);
	            q2.offer(order - 1);
	        }
	 
	        if (node.right != null) {
	            q1.offer(node.right);
	            q2.offer(order + 1);
	        }
	    }
	}
}
