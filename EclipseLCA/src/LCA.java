import java.util.ArrayList;
import java.util.List;
class Node {
	int data;
	Node left, right;
	ArrayList<Node> ancestors;
	Node(int value) {
		data = value;
		left = right = null;
		ancestors = null ;
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

	public void addNodeToDAG(Node val)
	{
		val.ancestors = new ArrayList <Node>();		
		val.ancestors.add(val); 
	}

	public void connectNodeToAncestors(Node a, Node b) 
	{
		for (int i = 0; i < b.ancestors.size(); i++) 
		{
			if(!a.ancestors.contains(b.ancestors.get(i))) 
			{	
				a.ancestors.add(b.ancestors.get(i)); 
			}
		}

	}

	public int findLCADAG(Node a, Node b) 
	{
		if(a != null && b != null)
			{
				for(int i = 0 ; i < a.ancestors.size() ; i ++)
				{
					for (int j = 0 ; j < b.ancestors.size () ; j++)
					{
						if(a.ancestors.get(i) == b.ancestors.get(j))
						{
							return a.ancestors.get(i).data;
						}
					}
				}
			}
		return -1;
	}
}

