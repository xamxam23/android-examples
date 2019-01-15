package com.m6world.test_dagger2tut.model;

import android.support.annotation.NonNull;
import android.util.Log;

public class SomeMath implements IMath {
    public SomeMath(){
        Log.d("x-", "constructor SomeMath." + hashCode());
    }
    @NonNull @Override public String toString() {
        return "SomeMath";
    }

    @Override public int add(int a, int b) {
        Log.d("x-add", this.hashCode() + ":" + a + " + " + b + " = " + (a + b));
        return a + b;
    }

    @Override public int mul(int a, int b) {
        Log.d("x-add", this.hashCode() + ":" + a + " * " + b + " = " + (a * b));
        return a * b;
    }
}