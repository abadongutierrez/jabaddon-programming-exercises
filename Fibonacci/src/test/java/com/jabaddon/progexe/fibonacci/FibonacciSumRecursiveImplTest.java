package com.jabaddon.progexe.fibonacci;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FibonacciSumRecursiveImplTest {

    @Test
    public void sum_shouldBeZero_forZero() {
        FibonacciSumRecursiveImpl fibo = new FibonacciSumRecursiveImpl();
        assertThat(fibo.sum(0), is(0));
    }

    @Test
    public void sum_shouldBeOne_forOne() {
        FibonacciSumRecursiveImpl fibo = new FibonacciSumRecursiveImpl();
        assertThat(fibo.sum(1), is(1));
    }

    @Test
    public void sum_shouldBeThree_forTwo() {
        FibonacciSumRecursiveImpl fibo = new FibonacciSumRecursiveImpl();
        assertThat(fibo.sum(2), is(3));
    }
}