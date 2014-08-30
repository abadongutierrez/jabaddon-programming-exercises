package com.jabaddon.bst;

/**
 * Created by rgutierrez on 8/19/14.
 */
public class BSTComparator {
    private boolean equals;

    public boolean compare(Node nodeA, Node nodeB) {
        internalCompare(nodeA, nodeB);
        return equals;
    }

    private void internalCompare(Node na, Node nb) {
        if (na == null && nb == null) {
            equals = true;
            return;
        }
        else {
            if (na != null) {
                equals = na.equals(nb);
            }
            else {
                equals = nb.equals(na);
            }

            if (!equals) return;
        }
        System.out.println(String.format("na(%d), nb(%d)", getValueOrNull(na), getValueOrNull(nb)));
        internalCompare(getLeftOrNull(na), getLeftOrNull(nb));
        if (!equals) return;
        internalCompare(getRightOrNull(na), getRightOrNull(nb));
    }

    private Integer getValueOrNull(Node na) {
        return na == null ? null : na.value();
    }

    private Node getRightOrNull(Node na) {
        return na == null ? null : na.getRight();
    }

    private Node getLeftOrNull(Node na) {
        return na == null ? null : na.getLeft();
    }
}
