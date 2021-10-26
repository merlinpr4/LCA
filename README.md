# LCA
Lowest Common Ancestor in Java and Python done in two different IDE (Eclipse and PyCharm). <br/>
Java implementation works for BST (Binary Search Tree) and DAG (Directed Acyclic Graph ).

- *Familiar language :* Java
- *New language :* Python 

Unit testing done with Junit testing for Java implementation. (JUnit 4 test ). (100% code coverage achieved). <br/>
Unit testing done with unittest for Python implementation. (100 % code coverage achieved).

### Note:
https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/ was used to help write LCA bst code implementations however all test code was written by me.<br/>
The current LCA.java and LCATest files contain code that works for both bst and dag cases .<br/>
I have decided to leave my original binary search tree LCA implementation with its associated tests in java files as it works perfectly for this case.<br/>
The DAG implementation written in the DAG branch which builts on the node class in the original implementation can also be used to construct a bst and I have written tests to demonstrate this.<br/>
I have then writen extensive tests for DAG LCA to verify it works and get 100 % code coverage in eclipse .<br/>


When I originally merged the DAG branch into main the changes didnt seem to happen properly as it seemed like main already contained the edits.<br/>
As the huge point of this excercise was to teach us about branching and merging I reuploaded my original LCA and LCATest  which only contained the bst versions into main. Than I tried merging my branch which contained DAG implementations of LCA which all worked succefully this time.<br/>
Commits of interest have also been commented on. <br/>
I realise that my actions would look quite messy and confusing without explanation however by doing this action and trying out merging a second time I was able to learn more about dealing with merge conflicts etc which I feel was the main objective of this excersie.


## How to Run:

### Eclipse Java:
1. Create a new project in eclipse. 
2. Create a new class LCA and use my LCA java implementation code.
3. Create a Junit Test case (https://www.softwaretestinghelp.com/junit-tests-examples/) follow this link if help is needed and try my LCAtest cases.
4. Run the LCATest file to see the tests run.
1. Run coverage as Junit test to see 100% code coverage.

### PyCharm Python (a free Jetbrains license is available for students):
1. Create a new project in pycharm named LCA.
1. Implement my LCA python code in LCA.py file.
1. Left click on find_LCA select go to then Test and let Pycharm autogenerate the test using unitest then use my test_LCA code .
1. Implement my LCA unittest and run to see tests work
1. Click run python tests in test_LCA.py with Coverage to see 100 % code coverage. 






