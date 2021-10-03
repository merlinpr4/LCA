import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.junit.Test;

@RunWith(JUnit4.class)
public class LCATest {

	@Test
	public void testLCA() {
		LCA bt = new LCA();
		bt.root = new Node(1);
		bt.root.right = new Node(2);
		bt.root.left = new Node(3);
		bt.root.right.right = new Node(4);
		bt.root.right.left = new Node(5);
		bt.root.left.right = new Node(6);
		bt.root.left.left = new Node(7);
		
		assertEquals("LCA of 4 and 5 is 2",2, bt.findLCA(4,5));
		assertEquals("LCA of 6 and 7 is 3",3, bt.findLCA(6,7));
		assertEquals("LCA of 2 and 4 is 2",2, bt.findLCA(2,4));
		assertEquals("LCA of 7 and 5 is 1",1, bt.findLCA(7,5));

	}
	
	@Test
	public void testNonExistentNode() {
		LCA bt = new LCA();
		bt.root = new Node(1);
		bt.root.right = new Node(2);
		bt.root.left = new Node(3);
		
		assertEquals("LCA of 1 and 5 is -1 (not existent)",-1, bt.findLCA(1,5));
		
		assertEquals("LCA of 5 and 2 is -1 (not existent)",-1, bt.findLCA(5,2));
	}
	
	@Test
	public void testNonExistentTree() {
		LCA bt = new LCA();
	
		assertEquals("LCA of 2 and 3 is -1 (not existent)",-1, bt.findLCA(2,3));
		
		assertEquals("LCA of 5 and 1 is -1 (not existent)",-1, bt.findLCA(5,1));
	}
	
}
