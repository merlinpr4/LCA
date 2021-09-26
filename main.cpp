#include <iostream>
#include <vector>
using namespace std;

struct Node
{
    int data;
    struct Node *left, *right;
};

Node * newNode(int val)
{
    Node *node = new Node;
    node->data = val;
    node->left = node->right = nullptr;
    return node;
}

bool findPath(Node *root, vector<int> &path, int val){
    if (root == nullptr){
        return false;
    }
    path.push_back(root->data);

    if (root->data == val){
        return true;
    }

    if  (root->left && findPath(root->left, path, val)){
        return true;
    }

    if  (root->right && findPath(root->right, path, val)){
        return true;
    }

    path.pop_back();
    return false;
}

int findLCA(Node *root, int a, int b)
{
    vector<int> path1, path2;
    if ( !findPath(root, path1, a) || !findPath(root, path2, b)){
        if(path1.empty())
        {
            cout << "First number is missing" << :: endl;
        }
        else if (path2.empty()) {
            cout << "Second number is missing" << :: endl;
        }
        return -1;
    }

    int i;
    for (i = 0; i < path1.size() && i < path2.size() ; i++)
        if (path1[i] != path2[i]) {
            return path1[i - 1];
        }
    return path1[i-1];
}

int main()
{
    Node * root = newNode(1);
    root->right = newNode(2);
    root->left = newNode(3);
    root->right->right = newNode(4);
    root->right->left = newNode(5);
    root->left->right = newNode(6);
    root->left->left = newNode(7);

    cout << "LCA of 4 and 5 is " << findLCA(root, 4, 5) << :: endl;
    cout << "LCA of 6 and 7 is " << findLCA(root, 6, 7) << :: endl;
    cout << "LCA of 2 and 4 is " << findLCA(root, 2, 4) << :: endl;
    cout << "LCA of 7 and 5 is " << findLCA(root, 7, 5) << :: endl;
    cout << "LCA of 7 and 9 is " << findLCA(root, 7, 9) ;
    return 0;
}

