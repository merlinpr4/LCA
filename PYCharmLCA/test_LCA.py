from unittest import TestCase

from LCA import Node, findLCA


class Test(TestCase):
    def test_find_lca(self):
        root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        root.left.left = Node(4)
        root.left.right = Node(5)
        root.right.left = Node(6)
        root.right.right = Node(7)
        self.assertEqual(findLCA(root,4,5),2,"LCA of 4 and 5 is 2")
        self.assertEqual(findLCA(root, 6, 7), 3, "LCA of 6 and 7 is 3")
        self.assertEqual(findLCA(root, 2, 4), 2, "LCA of 2 and 4 is 2")
        self.assertEqual(findLCA(root, 7, 5), 1, "LCA of 7 and 5 is 1")

    def test_nonexistent_node(self):
        root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        self.assertEqual(findLCA(root, 1, 5), -1, "LCA of 1 and 5 is -1")
        self.assertEqual(findLCA(root, 4, 5), -1, "LCA of 4 and 5 is -1")

