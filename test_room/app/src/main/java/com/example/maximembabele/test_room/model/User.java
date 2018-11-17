package com.example.maximembabele.test_room.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    public User(){}
    public User(String first, String last) {
        firstName = first;
        lastName = last;
    }

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @Override
    public String toString() {
        return uid + ": " + firstName + " " + lastName;
    }

    @Ignore
    public Bitmap picture;
}