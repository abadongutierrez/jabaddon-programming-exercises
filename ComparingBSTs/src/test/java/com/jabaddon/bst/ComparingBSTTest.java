package com.jabaddon.bst;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rgutierrez on 8/19/14.
 */
public class ComparingBSTTest {

    @Test
    public void test_treesWithNullRoots_shouldBeEqual() {
        BSTComparator bstc = new BSTComparator();
        assertThat(bstc.compare(null, null), is(true));
    }

    @Test
    public void test_treesWithSameRootInstanceNode_shouldBeEqual() {
        BSTComparator bstc = new BSTComparator();
        Node root = new Node(1);
        assertThat(bstc.compare(root, root), is(true));
    }

    @Test
    public void test_treesWithSameValueRootNode_shouldBeEqual() {
        BSTComparator bstc = new BSTComparator();
        Node nodeA = new Node(1);
        Node nodeB = new Node(1);
        assertThat(bstc.compare(nodeA, nodeB), is(true));
    }

    @Test
    public void test_treesWithDifferentValueRootNodes_shouldBeDifferent() {
        BSTComparator bstc = new BSTComparator();
        Node nodeA = new Node(1);
        Node nodeB = new Node(2);
        assertThat(bstc.compare(nodeA, nodeB), is(false));
    }

    @Test
    public void test_treesWithStructure_shouldBeDifferent() {
        BSTComparator bstc = new BSTComparator();
        Node nodeA = new Node(1);
        Node nodeB = new Node(1);
        nodeB.setLeft(new Node(3));
        nodeA.setLeft(new Node(2));
        assertThat(bstc.compare(nodeA, nodeB), is(false));
    }

    @Test
    public void test_treesWithSameStructure_shouldBeEqual2() {
        BSTComparator bstc = new BSTComparator();
        Node nodeA = new Node(1);
        Node nodeB = new Node(1);
        nodeB.setLeft(new Node(3));
        nodeA.setLeft(new Node(3));
        assertThat(bstc.compare(nodeA, nodeB), is(true));
    }

    @Test
    public void test_treesWithStructure_shouldBeDifferent3() {
        BSTComparator bstc = new BSTComparator();
        Node nodeA = new Node(1);
        Node nodeB = new Node(1);
        nodeB.setLeft(new Node(3));
        nodeB.setRight(new Node(5));
        nodeA.setLeft(new Node(3));
        nodeA.setRight(new Node(4));
        assertThat(bstc.compare(nodeA, nodeB), is(false));
    }

    @Test
    public void test_treesWithStructure_shouldBeDifferent4() {
        BSTComparator bstc = new BSTComparator();
        Node nodeA = new Node(1);
        Node nodeB = new Node(1);
        nodeB.setLeft(new Node(3));
        nodeB.setRight(new Node(5));
        nodeA.setLeft(new Node(3));
        nodeA.setRight(new Node(5));
        assertThat(bstc.compare(nodeA, nodeB), is(true));
    }
}
