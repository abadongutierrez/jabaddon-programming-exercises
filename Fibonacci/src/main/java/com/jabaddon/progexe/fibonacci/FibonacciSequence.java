package com.jabaddon.progexe.fibonacci;

/**
 * Created by rgutierrez on 8/28/14.
 */
public class FibonacciSequence {
    private final int _seedValue2;
    private final int _seedValue1;

    public FibonacciSequence(int seedValue1, int seedValue2) {
        _seedValue1 = seedValue1;
        _seedValue2 = seedValue2;
    }

    public int getSeedValue1() {
        return _seedValue1;
    }

    public int getSeedValue2() {
        return _seedValue2;
    }

    public int numberAt(int index) {
        if (index == 0) return getSeedValue1();
        if (index == 1) return getSeedValue2();

        int aux = index - 1;
        int value = 0;
        int prev1 = getSeedValue1();
        int prev2 = getSeedValue2();
        for (int i = 0; i < aux; ++i) {
            value = prev1 + prev2;
            prev1 = prev2;
            prev2 = value;
        }
        return value;
    }
}
