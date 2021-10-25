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
		assertEquals("LCA of 12 and 13 is 5",5, bt.findLCA(12,13));

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
		assertEquals("LCA of 7 and 3 is 1",1, bt.findLCA(7,3));
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
		 *				  /			  \	  
		 *			   (3)            (2)
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

	@Test
	public void testEmptyDAG() {
		LCA DAG = new LCA();
		assertEquals("LCA of an empty DAG is -1 (non-existent) ",-1, DAG.findLCADAG(null, null));
	}

	@Test
	public void testDAGNull() {
		LCA DAG = new LCA();
		Node one = new Node(1);
		Node two = new Node(2);

		DAG.addNodeToDAG(one);
		DAG.addNodeToDAG(two);
		DAG.connectNodeToAncestors(two, one);

		assertEquals("LCA of null and null node is -1 (non existant)",-1, DAG.findLCADAG(null, null));
		assertEquals("LCA of 1 and null node is -1 (non existant)",-1, DAG.findLCADAG(one, null));
		assertEquals("LCA of 1 and null node is -1 (non existant)",-1, DAG.findLCADAG(null, one));

	}

	@Test
	public void testDAGThreeNode() {
		LCA DAG = new LCA();

		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);


		DAG.addNodeToDAG(one);
		DAG.addNodeToDAG(two);
		DAG.addNodeToDAG(three);

		DAG.connectNodeToAncestors(two, one);
		DAG.connectNodeToAncestors(three, one);

		assertEquals("LCA of 2 and 3 is 1",1, DAG.findLCADAG(two, three));
	}

	@Test
	public void testNoAncestor() {
		LCA DAG = new LCA();
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);

		DAG.addNodeToDAG(one);
		DAG.addNodeToDAG(two);
		DAG.addNodeToDAG(three);
		DAG.addNodeToDAG(four);
		DAG.addNodeToDAG(five);

		DAG.connectNodeToAncestors(two, one);
		DAG.connectNodeToAncestors(five, four);
		DAG.connectNodeToAncestors(three, four);

		assertEquals("LCA of 2 and 4 is -1(non existant",-1, DAG.findLCADAG(two, four));
		assertEquals("LCA of 1 and 5 is -1(non existant",-1, DAG.findLCADAG(one, five));
		assertEquals("LCA of 2 and 3 is -1(non existant",-1, DAG.findLCADAG(two, three));
	}

	@Test
	public void testUsingDAGForBST() {
		LCA DAG = new LCA();
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);

		DAG.addNodeToDAG(one);
		DAG.addNodeToDAG(two);
		DAG.addNodeToDAG(three);
		DAG.addNodeToDAG(four);
		DAG.addNodeToDAG(five);
		DAG.addNodeToDAG(six);
		DAG.addNodeToDAG(seven);
		
		DAG.connectNodeToAncestors(two, one);
		DAG.connectNodeToAncestors(three, one);
		DAG.connectNodeToAncestors(four, two);
		DAG.connectNodeToAncestors(five, two);
		DAG.connectNodeToAncestors(seven, three);
		DAG.connectNodeToAncestors(six, three);


		assertEquals("LCA of 4 and 5 is 2",2, DAG.findLCADAG(four,five));
		assertEquals("LCA of 6 and 7 is 3",3, DAG.findLCADAG(six,seven));
		assertEquals("LCA of 2 and 4 is 2",2, DAG.findLCADAG(two,four));
		assertEquals("LCA of 7 and 5 is 1",1, DAG.findLCADAG(seven,five));
		assertEquals("LCA of 5 and 4 is 2",2, DAG.findLCADAG(five,four));
		
		/*Diagram for DAG
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

	@Test
	public void testDAG() {
		LCA DAG = new LCA();
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);

		DAG.addNodeToDAG(one);
		DAG.addNodeToDAG(two);
		DAG.addNodeToDAG(three);
		DAG.addNodeToDAG(four);
		DAG.addNodeToDAG(five);
		DAG.addNodeToDAG(six);
		DAG.addNodeToDAG(seven);

		DAG.connectNodeToAncestors(three, one);
		DAG.connectNodeToAncestors(two, one);
		DAG.connectNodeToAncestors(two, four);
		DAG.connectNodeToAncestors(five, four);
		DAG.connectNodeToAncestors(six, five);
		DAG.connectNodeToAncestors(seven, six);


		assertEquals("LCA of 3 and 2 is 1",1, DAG.findLCADAG(three, two));
		assertEquals("LCA of 5 and 2 is 4",4, DAG.findLCADAG(two, five));
		assertEquals("LCA of 2 and 6 is 2",4, DAG.findLCADAG(two, six));
		assertEquals("LCA of 2 and 7 is 2",4, DAG.findLCADAG(seven, two));
		assertEquals("LCA of 6 and 7 is 6",6, DAG.findLCADAG(seven, six));
		assertEquals("LCA of 3 and 3 is 3",3, DAG.findLCADAG(three, three));

	}

	@Test
	public void testDAGManyNodes() {
		LCA DAG = new LCA();
		Node zero = new Node (0);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);

		DAG.addNodeToDAG(zero);
		DAG.addNodeToDAG(one);
		DAG.addNodeToDAG(two);
		DAG.addNodeToDAG(three);
		DAG.addNodeToDAG(four);
		DAG.addNodeToDAG(five);
		DAG.addNodeToDAG(six);
		DAG.addNodeToDAG(seven);
		DAG.addNodeToDAG(eight);
		DAG.addNodeToDAG(nine);

		DAG.connectNodeToAncestors(two, one);
		DAG.connectNodeToAncestors(three, one);
		DAG.connectNodeToAncestors(four, two);
		DAG.connectNodeToAncestors(five, two);
		DAG.connectNodeToAncestors(four, three);
		DAG.connectNodeToAncestors(nine, three);
		DAG.connectNodeToAncestors(six, four);
		DAG.connectNodeToAncestors(seven, four);
		DAG.connectNodeToAncestors(eight, seven);

		assertEquals("LCA of 5 and 7 is 2",2, DAG.findLCADAG(five, seven));
		assertEquals("LCA of 7 and 5 is 2",2, DAG.findLCADAG(seven, five));
		assertEquals("LCA of 5 and 4 is 2",2, DAG.findLCADAG(five, four));
		assertEquals("LCA of 8 and 7 is 7",7, DAG.findLCADAG(eight, seven));
		assertEquals("LCA of 6 and 7 is 2",4, DAG.findLCADAG(six, seven));
		assertEquals("LCA of 5 and 2 is 5",2, DAG.findLCADAG(five, two));
		assertEquals("LCA of 3 and 3 is 3",3, DAG.findLCADAG(three, three));
		assertEquals("LCA of 1 and 9 is 1",1, DAG.findLCADAG(one, nine));
		assertEquals("LCA of 9 and 4 is 3",3, DAG.findLCADAG(nine, four));
		

	}

}