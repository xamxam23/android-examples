package com.m6world.test_dagger2tut.model

import android.util.Log

import javax.inject.Inject

class Boldy @Inject constructor() {
    init {
        Log.d("x-", "construct Boldy " + hashCode())
    }
}
