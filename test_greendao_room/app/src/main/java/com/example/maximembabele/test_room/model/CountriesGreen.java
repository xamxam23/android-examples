package com.example.maximembabele.test_room.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "Countries")
public class CountriesGreen {

    @Property(nameInDb = "country_name")
    public String countryName;

    @Property(nameInDb = "population")
    public int population;

    @Generated(hash = 475124199)
    public CountriesGreen(String countryName, int population) {
        this.countryName = countryName;
        this.population = population;
    }

    public CountriesGreen() {
    }

    @Override
    public String toString() {
        return countryName +":"+population;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}