package com.jabaddon.bst;

/**
 * Created by rgutierrez on 8/19/14.
 */
public class Node {
    private Node rightNode;
    private Node leftNode;
    private final int value;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Node node = (Node) o;

        if (value != node.value) {
            return false;
        }

        return true;
    }

    public Node getLeft() {
        return this.leftNode;
    }

    public Node getRight() {
        return this.rightNode;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public boolean rightNotNull() {
        return this.rightNode != null;
    }

    public void setLeft(Node node) {
        this.leftNode = node;
    }

    public void setRight(Node node) {
        this.rightNode = node;
    }

    public boolean leftNotNull() {
        return this.leftNode != null;
    }

    public int value() {
        return this.value;
    }
}
