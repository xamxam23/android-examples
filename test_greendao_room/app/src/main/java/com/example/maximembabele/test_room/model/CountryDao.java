package com.example.maximembabele.test_room.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CountryDao {
    @Query("SELECT * FROM Countries")
    List<Countries> getAll();

    @Insert
    void insertAll(Countries... people);
}