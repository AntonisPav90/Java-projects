// AVLTree.java
// demonstrates AVL Binary Search Tree
// Recursive Implementation
// Compile with: C> javac AVLTree.java
// to run this program: C>java AVLApp
import java.io.*;
import java.util.*;               // for Stack class
////////////////////////////////////////////////////////////////
class Node {
    public int key;              // data item (key)
    public Object data;           // data item
    public Node leftChild;         // this node's left child
    public Node rightChild;        // this node's right child
    public boolean deleted;        // "deleted" mark
    public long height;            // holds the node's height

    public Node(int _key, Object _data) {
        key = _key; data = _data;
        deleted = false; height = 0;
    }

    public void displayNode() {    // display itself
        System.out.print("{" + key);
        System.out.print(", ");
        System.out.print(data + "} ");
    }
}  // end class Node
////////////////////////////////////////////////////////////////
class AVLTree {
    private Node root;             // first node of tree
// -------------------------------------------------------------
    public AVLTree() {             // constructor
        root = null;            // no nodes in tree yet
    }
// -------------------------------------------------------------
    public static long getHeight(Node aNode) {
        if (aNode == null) return (-1);
        else return (aNode.height);
    }
// -------------------------------------------------------------
    private Node rotateWithLeftChild(Node K2) {

        Node K1 = K2.leftChild;

        K2.leftChild = K1.rightChild;

        K1.rightChild = K2;

        if (getHeight(K2.leftChild) > getHeight(K2.rightChild))
            K2.height = getHeight(K2.leftChild) + 1;
        else K2.height = getHeight(K2.rightChild) + 1;

        if (getHeight(K1.leftChild) > getHeight(K1.rightChild))
            K1.height = getHeight(K1.leftChild) + 1;
        else K1.height = getHeight(K1.rightChild) + 1;

        return K1;
    }
// -------------------------------------------------------------
    private Node rotateWithRightChild(Node K1) {

        Node K2 = K1.rightChild;

        K1.rightChild = K2.leftChild;

        K2.leftChild = K1;

        if (getHeight(K1.leftChild) > getHeight(K1.rightChild))
            K1.height = getHeight(K1.leftChild) + 1;
          else K1.height = getHeight(K1.rightChild) + 1;

        if (getHeight(K2.leftChild) > getHeight(K2.rightChild))
            K2.height = getHeight(K2.leftChild) + 1;
        else K2.height = getHeight(K2.rightChild) + 1;

        return K2;
    }
// -------------------------------------------------------------
    private Node doubleRotateWithLeftChild(Node K2) {

      K2.leftChild = rotateWithRightChild(K2.leftChild);

      return(rotateWithLeftChild(K2));
    }
// -------------------------------------------------------------
    private Node doubleRotateWithRightChild(Node K1) {

        K1.rightChild = rotateWithLeftChild(K1.rightChild);

        return(rotateWithRightChild(K1));
    }
// -------------------------------------------------------------
    /*** Private Recursive Method for finding a Node with given key ***/
    private Node findNode(int key, Node rNode) {
        if (rNode == null) return(null); // tree is empty
        else {
            if (key < rNode.key)        // search in left subtree
                return(findNode(key,rNode.leftChild));
            else if (key > rNode.key)   // search in right subtree
                return(findNode(key, rNode.rightChild));
            else return(rNode);           // found!
        }
    }

// -------------------------------------------------------------
    public Object find(int key) {  // find node data with given key
        Node found = findNode(key,root);  // Search for key in tree
        if (found != null)                // If node found ...
            if (found.deleted == false)   // and not marked deleted
                return(found.data);            // return it
        return(null);                     // else return null
  }
// -------------------------------------------------------------

  // Lazy Deletion
    public boolean delete(int key) {
        Node found = findNode(key,root); // Search for key in tree
        if (found != null) {             // If found ...
            found.deleted = true;        // mark it deleted
            return(true);
        } else return(false);            // else not found
    }
// -------------------------------------------------------------

    private Node insertNode(Node newNode, Node rNode) {

        if(rNode==null)         // no node in root
            rNode = newNode;
        else {                  // root occupied   

            if (newNode.key < rNode.key) {    // insert left

                rNode.leftChild = insertNode(newNode, rNode.leftChild);

                if (getHeight(rNode.leftChild)-getHeight(rNode.rightChild)==2) {

                    // Was it an insertion in rNode.leftChild ?
                    if (newNode.key < rNode.leftChild.key)
                        rNode = rotateWithLeftChild(rNode);
                    else // it was an insertion in rNode.rightChild
                        rNode = doubleRotateWithLeftChild(rNode);
                }

            } else if (newNode.key > rNode.key) { // insert right

                rNode.rightChild=insertNode(newNode, rNode.rightChild);

                if (getHeight(rNode.rightChild)-getHeight(rNode.leftChild)==2) {
                    // Was it an insertion in rNode.rightChild ?
                    if (newNode.key > rNode.rightChild.key)
                        rNode = rotateWithRightChild(rNode);
                    else // it was an insertion in rNode.leftChild
                        rNode = doubleRotateWithRightChild(rNode);
                }

            } else if (rNode.deleted) {           // undelete it
                rNode.deleted = false;
                rNode.data = newNode.data;
            }
        }

        if (getHeight(rNode.leftChild) > getHeight(rNode.rightChild))
            rNode.height = getHeight(rNode.leftChild) + 1;
        else rNode.height = getHeight(rNode.rightChild) + 1;

        return(rNode);
    }
// -------------------------------------------------------------
    public void insert(int key, Object data) {
        Node newNode = new Node(key, data);      // make new node
        root = insertNode(newNode, root);     // insert node in tree
    }
// -------------------------------------------------------------
    private void preOrder(Node localRoot) {
        if(localRoot != null) {
            if (!localRoot.deleted) // If not marked deleted
                System.out.print(localRoot.key + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    public void preOrder() {preOrder(root);}
// -------------------------------------------------------------
    private void inOrder(Node localRoot) {
        if(localRoot != null) {
            inOrder(localRoot.leftChild);
            if (!localRoot.deleted) // If not marked deleted
                System.out.print(localRoot.key + " ");
            inOrder(localRoot.rightChild);
        }
    }

    public void inOrder() {inOrder(root);}
// -------------------------------------------------------------
    private void postOrder(Node localRoot) {
        if(localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            if (!localRoot.deleted) // If not marked deleted
                System.out.print(localRoot.key + " ");
        }
    }

    public void postOrder() {postOrder(root);}
// -------------------------------------------------------------
}  // end class AVLTree
////////////////////////////////////////////////////////////////
class AVLApp {

    public static void AVLSortPrint(int[] a) {
        AVLTree tree = new AVLTree();
        for(int i = 0; i < a.length; i++)
            tree.insert(a[i],null);
        tree.inOrder();
    }

    public static void main(String[] args) {
      int value;
      AVLTree theTree = new AVLTree();

      theTree.insert(50, 1.5);
      theTree.insert(25, 1.2);
      theTree.insert(75, 1.7);
      theTree.insert(12, 1.5);
      theTree.insert(37, 1.2);
      theTree.insert(43, 1.7);
      theTree.insert(30, 1.5);
      theTree.insert(33, 1.2);
      theTree.insert(87, 1.7);
      theTree.insert(93, 1.5);
      theTree.insert(97, 1.5);

      System.out.print("- InOrder: ");
      theTree.inOrder(); System.out.println("");
      System.out.print("- PostOrder: ");
      theTree.postOrder(); System.out.println("");
      System.out.print("- PreOrder: ");
      theTree.preOrder(); System.out.println("");
  }  // end main()
}  // end class AVLApp
////////////////////////////////////////////////////////////////
