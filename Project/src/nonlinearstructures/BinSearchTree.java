package nonlinearstructures;

import dataobjects.*;
import binaryobjects.*;
import linearstructures.CircQueue;
import linearnode.*;

import javax.swing.*;

public class BinSearchTree {
    private BNode root;
    private String display = "";

    public BinSearchTree() {
        root = null;
    }

    //Methods
    private void insert(BNode parent, BNode newNode) {

        if (parent == null) {
            root = newNode;
        } else {
            String newObj = (newNode.obj.getKey());
            String check = (parent.obj.getKey());
            int compare = newObj.compareToIgnoreCase(check);
            if (compare < 0) {
                if (parent.left == null)
                    parent.left = newNode;
                else
                    insert(parent.left, newNode);
            } else {
                if (parent.right == null)
                    parent.right = newNode;
                else
                    insert(parent.right, newNode);
            }
        }
    }

    private void insertBST(AnyClass newObj) {
        Employee obj1 = (Employee) newObj;
        BNode newNode = new BNode(obj1);

        insert(root, newNode);
    }

    private void inorder(BNode parent) {
        if (parent != null) {
            inorder(parent.left);
            display += (parent.obj.getData() + "----------------------\n");
            inorder(parent.right);
        }
    }

    public void inorderBST() {
        inorder(root);
        if (!display.equals("")) {
            JOptionPane.showMessageDialog(null, display);
            display = "";
        } else {
            JOptionPane.showMessageDialog(null, "The BST is Empty", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private BNode searchBST(BNode root, String key) {
        if (root == null)
            return null;
        else if (root.obj.getKey().toLowerCase().equals(key))
            return root;
        else if (key.compareTo(root.obj.getKey().toLowerCase()) < 0)
            return searchBST(root.left, key);
        else
            return searchBST(root.right, key);
    }

    public AnyClass searchStringBST(String keyString) {
        BNode node;
        String key1 = keyString.toLowerCase();
        node = searchBST(root, key1);
        if (node == null)
            return null;
        else
            return node.obj;
    }

    public void populateBST(CircQueue queue) {
        root = null;
        if (queue.isFull || queue.rear.next != queue.front) {
            Node temp = queue.front;
            do {
                insertBST(temp.obj);
                temp = temp.next;
            } while (temp != queue.rear.next);
            inorderBST();
        } else {
            JOptionPane.showMessageDialog(null, "Queue is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}