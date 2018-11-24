package com.example.maximembabele.test_room.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;

@Entity
public class Countries {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "country_name")
    public String countryName;

    public int population;

    @Override
    public String toString() {
        return countryName +":"+population;
    }
}