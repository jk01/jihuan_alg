package com.algorithm.tree.construct;

import java.util.Stack;

public class Tree {
    //表示根的Node变量；
    private Node root; // 树的根结点

    // -------------------------------------------------------------
    public Tree() // constructor
    {
        root = null;
    }

    // -------------------------------------------------------------
    /**
     * 插入一个元素，从根节点开始比较，比跟节点大，放在右，
     * 如果右边存在，则新插入的需要和右边对象比较，依此类推；
     * 比跟节点小同样处理方法。
     * 可以采用递归与非递归的方式实现
     */
    //递归实现二叉树的创建
    public void insert(Node newNode,Node rootNode){
        if(root==null){
            root=newNode;
        }else{
            if(newNode.key < rootNode.key){
                if(rootNode.leftChild==null){
                    rootNode.leftChild=newNode;
                }else{
                    insert(newNode,rootNode.leftChild);
                }
            }else{
                if(rootNode.rightChild==null){
                    rootNode.rightChild=newNode;
                }else{
                    insert(newNode,rootNode.rightChild);
                }//end else 3
            }//end else 2
        }//end else 1
    }// end insert
    //非递归的方式实现
    public void insert(int id, double dd)
    {
        //创建新节点
        Node newNode = new Node();
        newNode.key = id; //插入数据
        newNode.value = dd;
        if (root == null)
        { //创建根节点
            root = newNode;
        }
        else
        {
            Node current = root; // start at root
            Node parent;
            while (true)
            {
                parent = current;
                //插在左节点,从根节点开始，不断向下层节点移动；
                if (id < current.key)
                {
                    //current对象是不断变化的；
                    current = current.leftChild;
                    //如果当前对象左节点为空，
                    //否则表示下面有节点，继续运行while直到满足条件；
                    if (current == null)
                    { //插在左节点，父节点的引用（句柄）指向左节点对象；
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else
                {
                    current = current.rightChild;
                    if (current == null) // if end of the line
                    { //插在左节点，父节点的引用（句柄）指向右节点对象；
                        parent.rightChild = newNode;
                        return;
                    }
                }
            } // end while
        } // end else not root
    } // end insert()


    // -------------------------------------------------------------
    /*
     * 就是用java代码实现了二叉树运行机制；
     */
    public Node find(int key) // find node with given key
    { // (assumes non-empty tree)
        Node current = root; // start at root
        while (current.key != key) // while no match,
        {
            if (key < current.key) // go left?
            {
                current = current.leftChild;
            }
            else
            {
                // or go right?
                current = current.rightChild;
            }
            if (current == null) // if no child,
            {
                return null; // didn't find it
            }
        }
        return current; // found it
    } // end find()

    // -------------------------------------------------------------
    /*
     * 删除节点运行机制，
     */
    public boolean delete(int key) // delete node with given key
    { // (assumes non-empty list)
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.key != key) // search for node
        {
            parent = current;
            if (key < current.key) // go left?
            {
                isLeftChild = true;
                current = current.leftChild;
            }
            else
            // or go right?
            {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) // end of the line,
            {
                return false; // didn't find it
            }
        }// end while
        // found node to delete

        // if no children, simply delete it
        if (current.leftChild == null && current.rightChild == null)
        {
            if (current == root) // if root,
            {
                root = null; // tree is empty
            }
            else if (isLeftChild)
            {
                parent.leftChild = null; // disconnect
            }
            else
            { // from parent
                parent.rightChild = null;
            }
        }

        // if no right child, replace with left subtree
        else if (current.rightChild == null)
        {
            if (current == root)
            {
                root = current.leftChild;
            }
            else if (isLeftChild)
            {
                parent.leftChild = current.leftChild;
            }
            else
            {
                parent.rightChild = current.leftChild;
            }
        }
        // if no left child, replace with right subtree
        else if (current.leftChild == null)
        {
            if (current == root)
            {
                root = current.rightChild;
            }
            else if (isLeftChild)
            {
                parent.leftChild = current.rightChild;
            }
            else
            {
                parent.rightChild = current.rightChild;
            }
        }
        else
        // two children, so replace with inorder successor
        {
            // get successor of node to delete (current)
            Node successor = getSuccessor(current);

            // connect parent of current to successor instead
            if (current == root)
            {
                root = successor;
            }
            else if (isLeftChild)
            {
                parent.leftChild = successor;
            }
            else
            {
                parent.rightChild = successor;
            }
            // connect successor to current's left child
            successor.leftChild = current.leftChild;
        } // end else two children
        // (successor cannot have a left child)
        return true; // success
    } // end delete()

    // -------------------------------------------------------------

    // returns node with next-highest value after delNode
    // goes to right child, then right child's left descendents
    private Node getSuccessor(Node delNode)
    {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild; // go to right child
        while (current != null) // until no more
        { // left children,
            successorParent = successor;
            successor = current;
            current = current.leftChild; // go to left child
        }
        // if successor not
        if (successor != delNode.rightChild) // right child,
        { // make connections
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    // --------------------------------------------------------

    public void traverse(int traverseType)
    {
        switch (traverseType)
        {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    // -------------------------------------------------------------
    private void preOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            System.out.print(localRoot.key + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    // -------------------------------------------------------------
    private void inOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.key + " ");
            inOrder(localRoot.rightChild);
        }
    }

    // -------------------------------------------------------------
    private void postOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.key + " ");
        }
    }

    // -------------------------------------------------------------
    public void displayTree()
    {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (isRowEmpty == false)
        {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (globalStack.isEmpty() == false)
            {
                Node temp = (Node) globalStack.pop();
                if (temp != null)
                {
                    System.out.print(temp.key);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            } // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        } // end while isRowEmpty is false
        System.out.println("......................................................");
    } // end displayTree()
    // -------------------------------------------------------------
}

