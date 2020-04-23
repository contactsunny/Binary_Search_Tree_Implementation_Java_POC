package com.contactsunny.poc.binary_search_tree_implementation_poc;

import com.contactsunny.poc.binary_search_tree_implementation_poc.binarysearchtree.BinarySearchTree;
import com.contactsunny.poc.binary_search_tree_implementation_poc.binarysearchtree.Node;

public class App {

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree(new Node(100));

        binarySearchTree.add(binarySearchTree.getRootNode(), new Node(200));
        binarySearchTree.add(binarySearchTree.getRootNode(), new Node(20));
        binarySearchTree.add(binarySearchTree.getRootNode(), new Node(50));

        String result = BinarySearchTree.traverseInOrder(binarySearchTree.getRootNode(), new StringBuilder());
        System.out.println(result);
    }
}
