package com.contactsunny.poc.binary_search_tree_implementation_poc.binarysearchtree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;

    @Before
    public void before() {
        binarySearchTree = new BinarySearchTree(new Node(10));
    }

    private void addAllNodes() {
        binarySearchTree.add(binarySearchTree.getRootNode(), new Node(15));
        binarySearchTree.add(binarySearchTree.getRootNode(), new Node(7));
        binarySearchTree.add(binarySearchTree.getRootNode(), new Node(5));
        binarySearchTree.add(binarySearchTree.getRootNode(), new Node(8));
        binarySearchTree.add(binarySearchTree.getRootNode(), new Node(12));
        binarySearchTree.add(binarySearchTree.getRootNode(), new Node(18));
    }

    @Test
    public void test_rootNodeIsAdded_atBeginning() {
        String result = BinarySearchTree.traverseInOrder(binarySearchTree.getRootNode(), new StringBuilder());
        assertEquals("10 ", result);
    }

    @Test
    public void test_nodeIsAddedToRightSubTree_whenValueGreaterThanRootNode() {
        binarySearchTree.add(binarySearchTree.getRootNode(), new Node(15));
        String result = BinarySearchTree.traverseInOrder(binarySearchTree.getRootNode(), new StringBuilder());
        assertEquals("10 15 ", result);
    }

    @Test
    public void test_nodeIsAddedToLeftSubTree_whenValueLessThanRootNode() {
        binarySearchTree.add(binarySearchTree.getRootNode(), new Node(7));
        String result = BinarySearchTree.traverseInOrder(binarySearchTree.getRootNode(), new StringBuilder());
        assertEquals("7 10 ", result);
    }

    @Test
    public void test_shouldHave3Nodes_afterFirstLevelOfAdditions() {
        binarySearchTree.add(binarySearchTree.getRootNode(), new Node(15));
        binarySearchTree.add(binarySearchTree.getRootNode(), new Node(7));
        String result = BinarySearchTree.traverseInOrder(binarySearchTree.getRootNode(), new StringBuilder());
        assertEquals("7 10 15 ", result);
    }

    @Test
    public void test_shouldHaveExpectedOutputForInOrderTraversal_afterAddingAllNodes() {
        addAllNodes();
        String result = BinarySearchTree.traverseInOrder(binarySearchTree.getRootNode(), new StringBuilder());
        assertEquals("5 7 8 10 12 15 18 ", result);
    }

    @Test
    public void test_shouldHaveExpectedOutputForPreOrderTraversal_afterAddingAllNodes() {
        addAllNodes();
        String result = BinarySearchTree.traversePreOrder(binarySearchTree.getRootNode(), new StringBuilder());
        assertEquals("10 7 5 8 15 12 18 ", result);
    }

    @Test
    public void test_shouldHaveExpectedOutputForPostOrderTraversal_afterAddingAllNodes() {
        addAllNodes();
        String result = BinarySearchTree.traversePostOrder(binarySearchTree.getRootNode(), new StringBuilder());
        assertEquals("5 8 7 12 18 15 10 ", result);
    }
}
