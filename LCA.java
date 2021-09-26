
import java.util.ArrayList;
import java.util.List;

class Node {
	int data;
	Node left, right;

	Node(int value) {
		data = value;
		left = right = null;
	}
}

public class LCA {

	Node root;
	private List<Integer> path1 = new ArrayList<>();
	private List<Integer> path2 = new ArrayList<>();

	int findLCA(int a, int b) {
		path1.clear();
		path2.clear();
		return findLowestCommonAncestor(root, a, b);
	}

	private int findLowestCommonAncestor(Node root, int a, int b) {
		int i;
		if (!findPath(root, a, path1) || !findPath(root, b, path2)) {

			if(path1.size()==0)
			{
				System.out.println("First number is missing");
			}
			else if (path2.size()== 0)
			{
				System.out.println("Second number is missing");
			}
			return -1;
		}

		for (i = 0; i < path1.size() && i < path2.size(); i++) {
			if (!path1.get(i).equals(path2.get(i)))
				return path1.get(i-1);
		}
		return path1.get(i-1);
	}

	private boolean findPath(Node root, int val, List<Integer> path)
	{
		if (root == null) {
			return false;
		}

		path.add(root.data);

		if (root.data == val) {
			return true;
		}

		if (root.left != null && findPath(root.left, val, path)) {
			return true;
		}

		if (root.right != null && findPath(root.right, val, path)) {
			return true;
		}

		path.remove(path.size()-1);
		return false;
	}

	public static void main(String[] args) {

		LCA bt = new LCA();
		bt.root = new Node(1);
		bt.root.right = new Node(2);
		bt.root.left = new Node(3);
		bt.root.right.right = new Node(4);
		bt.root.right.left = new Node(5);
		bt.root.left.right = new Node(6);
		bt.root.left.left = new Node(7);

		System.out.println("LCA of 4 and 5 is " + bt.findLCA(4,5));
		System.out.println("LCA of 6 and 7 is " + bt.findLCA(6,7));
		System.out.println("LCA of 2 and 4 is " + bt.findLCA(2,4));
		System.out.println("LCA of 7 and 5 is " + bt.findLCA(7,5));
		System.out.println("LCA of 7 and 9 is " + bt.findLCA(7,9));
		

	}
}
