package com.example.maximembabele.test_room.model;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "User")
public class UserGreen {

    @Property(nameInDb = "uid")
    @Id(autoincrement = true)
    public Long uid;

    @Property(nameInDb = "first_name")
    public String firstName;

    @Property(nameInDb = "last_name")
    public String lastName;

    @Keep
    public UserGreen(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Generated(hash = 1969559154)
    public UserGreen() {
    }

    @Generated(hash = 1055449702)
    public UserGreen(Long uid, String firstName, String lastName) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return uid + ": " + firstName + " " + lastName;
    }

    public Long getUid() {
        return this.uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}