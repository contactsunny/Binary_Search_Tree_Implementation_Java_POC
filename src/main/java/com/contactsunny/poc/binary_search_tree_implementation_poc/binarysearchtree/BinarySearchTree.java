package com.contactsunny.poc.binary_search_tree_implementation_poc.binarysearchtree;

public class BinarySearchTree {

    private final Node rootNode;

    public BinarySearchTree(Node root) {
        rootNode = root;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public void add(Node rootNode, Node node) {
        if (rootNode == null) {
            rootNode = node;
        } else if (rootNode.getValue() < node.getValue()) {
            if (rootNode.getRight() != null) {
                add(rootNode.getRight(), node);
            } else {
                rootNode.setRight(node);
            }
        } else if (rootNode.getValue() > node.getValue()) {
            if (rootNode.getLeft() != null) {
                add(rootNode.getLeft(), node);
            } else {
                rootNode.setLeft(node);
            }
        }
    }

    public void delete(Node rootNode, int valueToSearch) {
        Node nodeToDelete = search(rootNode, valueToSearch);

        if (nodeToDelete == null) {
            // There's no node with the given value.
            System.out.println("Node not found!");
        } else if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() == null) {
            // Node has no children, so just remove reference of its parent.
            Node parentNode = getParentNode(rootNode, valueToSearch);
            if (parentNode != null) {
                if (parentNode.getRight().getValue() == valueToSearch) {
                    parentNode.setRight(null);
                } else if (parentNode.getLeft().getValue() == valueToSearch) {
                    parentNode.setLeft(null);
                }
            }
        } else if (nodeToDelete.getLeft() == null) {
            // Only right children is present. So link parent node's right to current node's right.
            Node parentNode = getParentNode(rootNode, valueToSearch);
            if (parentNode != null) {
                parentNode.setRight(nodeToDelete.getRight());
            }
        } else if (nodeToDelete.getRight() == null) {
            // Only left children is present. So link parent node's left to current node's left.
            Node parentNode = getParentNode(rootNode, valueToSearch);
            if (parentNode != null) {
                parentNode.setLeft(nodeToDelete.getRight());
            }
        } else {
            // Both right and left children are present. So need to get the successor of the node.
            Node parentNode = getParentNode(rootNode, valueToSearch);
            Node successorNode = getSuccessorNode(nodeToDelete.getRight());

            if (parentNode.getRight().getValue() == valueToSearch) {
                parentNode.setRight(successorNode);
                delete(rootNode, successorNode.getValue());
            } else if (parentNode.getLeft().getValue() == valueToSearch) {
                parentNode.setLeft(successorNode);
                delete(rootNode, successorNode.getValue());
            }
        }
    }

    private Node getSuccessorNode(Node node) {
        if (node.getLeft() == null) {
            return node;
        } else {
            return getSuccessorNode(node.getLeft());
        }
    }

    public Node search(Node rootNode, int valueToSearch) {
        if (rootNode == null) {
            return null;
        } else if (rootNode.getValue() == valueToSearch) {
            return rootNode;
        } else if (rootNode.getValue() < valueToSearch) {
            if (rootNode.getRight() != null) {
                return search(rootNode.getRight(), valueToSearch);
            } else {
                return null;
            }
        } else if (rootNode.getValue() > valueToSearch) {
            if (rootNode.getLeft() != null) {
                return search(rootNode.getLeft(), valueToSearch);
            } else {
                return null;
            }
        }

        return null;
    }

    public Node getParentNode(Node rootNode, int valueToSearch) {
        if (rootNode == null) {
            return null;
        } else if (rootNode.getValue() == valueToSearch) {
            return rootNode;
        } else if (rootNode.getValue() < valueToSearch) {
            if (rootNode.getRight() != null) {
                if (rootNode.getRight().getValue() == valueToSearch) {
                    return rootNode.getRight();
                } else {
                    return getParentNode(rootNode.getRight(), valueToSearch);
                }
            } else {
                return null;
            }
        } else if (rootNode.getValue() > valueToSearch) {
            if (rootNode.getLeft() != null) {
                if (rootNode.getLeft().getValue() == valueToSearch) {
                    return rootNode.getLeft();
                } else {
                    return getParentNode(rootNode.getLeft(), valueToSearch);
                }
            } else {
                return null;
            }
        }

        return null;
    }

    public static String traverseInOrder(Node node, StringBuilder stringBuilder) {

        if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
        }

        if (node.getLeft() != null) {
            traverseInOrder(node.getLeft(), stringBuilder);
        }

        stringBuilder.append(node.getValue()).append(" ");

        if (node.getRight() != null) {
            traverseInOrder(node.getRight(), stringBuilder);
        }

        return stringBuilder.toString();
    }

    public static String traversePreOrder(Node node, StringBuilder stringBuilder) {

        if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
        }

        stringBuilder.append(node.getValue()).append(" ");

        if (node.getLeft() != null) {
            traversePreOrder(node.getLeft(), stringBuilder);
        }

        if (node.getRight() != null) {
            traversePreOrder(node.getRight(), stringBuilder);
        }

        return stringBuilder.toString();
    }

    public static String traversePostOrder(Node node, StringBuilder stringBuilder) {

        if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
        }

        if (node.getLeft() != null) {
            traversePostOrder(node.getLeft(), stringBuilder);
        }

        if (node.getRight() != null) {
            traversePostOrder(node.getRight(), stringBuilder);
        }

        stringBuilder.append(node.getValue()).append(" ");

        return stringBuilder.toString();
    }
}
