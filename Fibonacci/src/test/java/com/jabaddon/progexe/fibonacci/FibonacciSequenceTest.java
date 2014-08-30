package com.jabaddon.progexe.fibonacci;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FibonacciSequenceTest {

    @Test
    public void create() {
        FibonacciSequence fs = new FibonacciSequence(0, 1);
        assertThat(fs.getSeedValue1(), is(0));
        assertThat(fs.getSeedValue2(), is(1));
    }

    @Test
    public void numberAtIndex() {
        FibonacciSequence fs = new FibonacciSequence(0, 1);
        assertThat(fs.numberAt(0), is(0));
        assertThat(fs.numberAt(1), is(1));
        assertThat(fs.numberAt(2), is(1));
        assertThat(fs.numberAt(3), is(2));
        assertThat(fs.numberAt(4), is(3));
        assertThat(fs.numberAt(5), is(5));
        assertThat(fs.numberAt(10), is(55));
    }
}