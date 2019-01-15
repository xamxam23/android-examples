package com.m6world.test_dagger2tut.model;

import javax.inject.Inject;

public class Stringer implements IStringer {
    IMath math;

    @Inject public Stringer(IMath math) {
        this.math = math;
    }

    public int randomMath(int a, int b) {
        return 2 * (math.add(a, b) + math.mul(a, b));
    }
}