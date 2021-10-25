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
		assertEquals("LCA of 5 and 4 is 2",2, bt.findLCA(5,4));

		/*Diagram Test LCA
		 *					 (1)
		 *				    /  \
		 *				   /	\				  
		 *			   (3)       (2)
		 *			  /   \		  /  \
		 * 			(7)  (6)     (5) (4)	   
		 * 	
		 * 
		 * */

	}

@@ -47,4 +59,130 @@ public void testNonExistentTree() {
		assertEquals("LCA of 5 and 1 is -1 (not existent)",-1, bt.findLCA(5,1));
	}

	@Test
	public void testLCASmallTree() {
		LCA bt = new LCA();
		bt.root = new Node(1);
		bt.root.right = new Node(2);
		bt.root.left = new Node(3);

		assertEquals("LCA of 1 and 2 is 1",1, bt.findLCA(1,2));
		assertEquals("LCA of 1 and 3 is 1",1, bt.findLCA(1,3));
		assertEquals("LCA of 2 and 3 is 1",1, bt.findLCA(2,3));
		assertEquals("LCA of 7 and 5 is 1",-1, bt.findLCA(7,5));

	}

	@Test
	public void testLCABigTree() {
		LCA bt = new LCA();
		bt.root = new Node(1);
		bt.root.right = new Node(2);
		bt.root.left = new Node(3);
		bt.root.right.right = new Node(4);
		bt.root.right.left = new Node(5);
		bt.root.left.right = new Node(6);
		bt.root.left.left = new Node(7);
		bt.root.right.right.right = new Node(8);
		bt.root.right.right.left = new Node(9);
		bt.root.left.left.right = new Node(10);
		bt.root.left.left.left = new Node (11);
		bt.root.right.left.right = new Node (12);
		bt.root.right.left.left = new Node (13);
		bt.root.left.right.right = new Node (14);
		bt.root.left.right.left = new Node (15);

		assertEquals("LCA of 1 and 2 is 1",1, bt.findLCA(1,2));
		assertEquals("LCA of 1 and 3 is 1",1, bt.findLCA(1,3));
		assertEquals("LCA of 9 and 6 is 1",1, bt.findLCA(2,3));
		assertEquals("LCA of 9 and 8 is 4",4, bt.findLCA(9,8));
		assertEquals("LCA of 11 and 10 is 7",7, bt.findLCA(11,10));
		assertEquals("LCA of 14 and 15 is 6",6, bt.findLCA(14,15));
		assertEquals("LCA of 7 and 6 is 3",3, bt.findLCA(7,6));
		assertEquals("LCA of 12 and 13 is 5",5, bt.findLCA(13,12));

		/*Diagram Test LCA Big Tree
		 *					   (1)
		 *				      /    \
		 *				  /				\	  
		 *			   (3)               (2)
		 *			  /   \		        /    \
		 * 			(7)     (6)      (5)      (4)	   
		 * 			/\      / \       /\      /\
		 *      (11) (10) (15)(14)  (13)(12) (9)(8)
		 * 
		 * 
		 * 
		 * */
	}

	@Test
	public void testLCARightLeaning() {
		LCA bt = new LCA();
		bt.root = new Node(1);
		bt.root.right = new Node(2);
		bt.root.left = new Node(3);
		bt.root.right.right = new Node(4);
		bt.root.right.right.right = new Node (5);
		bt.root.right.right.right.right = new Node(6);
		bt.root.right.right.right.right.right = new Node (7);

		assertEquals("LCA of 1 and 2 is 1",1, bt.findLCA(1,2));
		assertEquals("LCA of 2 and 4 is 2",2, bt.findLCA(2,4));
		assertEquals("LCA of 2 and 3 is 1",1, bt.findLCA(2,3));
		assertEquals("LCA of 4 and 5 is 5",4, bt.findLCA(4,5));
		assertEquals("LCA of 2 and 5 is 2",2, bt.findLCA(2,5));
		assertEquals("LCA of 6 and 7 is 6",6, bt.findLCA(6,7));

		/*Diagram Test LCA Right Leaning Tree
		 *					   (1)
		 *				      /    \
		 *				  /			   \	  
		 *			   (3)               (2)
		 *			     		            \
		 * 						            (4)	   
		 * 						      	      \
		 *      				  			   (5) 
		 *                                       \
		 * 										  (6)
		 * 										   \
		 * 										   (7)
		 * */
	}

	@Test
	public void testLCALeftLeaning() {
		LCA bt = new LCA();
		bt.root = new Node(1);
		bt.root.right = new Node(2);
		bt.root.left = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.left.left = new Node(5);
		bt.root.left.left.left.left = new Node(6);
		bt.root.left.left.left.left.left = new Node(7);
		assertEquals("LCA of 1 and 2 is 1",1, bt.findLCA(1,2));
		assertEquals("LCA of 3 and 4 is 3",3, bt.findLCA(3,4));
		assertEquals("LCA of 2 and 3 is 1",1, bt.findLCA(2,3));
		assertEquals("LCA of 4 and 5 is 5",4, bt.findLCA(4,5));
		assertEquals("LCA of 3 and 5 is 3",3, bt.findLCA(3,5));

		/*Diagram Test LCA Left Leaning Tree
		 *					   (1)
		 *				      /    \
		 *				  /			   \	  
		 *			   (3)               (2)
		 *			    /
		 *			( 4)
		 *			/
		 *		(5)
		 *		/
		 *	(6)
		 *	/
		 *(7)		         
		 * */



	}

}