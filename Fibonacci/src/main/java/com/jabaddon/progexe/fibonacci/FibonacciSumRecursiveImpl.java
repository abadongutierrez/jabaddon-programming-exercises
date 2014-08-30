package com.jabaddon.progexe.fibonacci;

public class FibonacciSumRecursiveImpl implements FibonnacciSum {
    @Override
    public int sum(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return sum(number - 1) + sum(number - 2);
    }
}
