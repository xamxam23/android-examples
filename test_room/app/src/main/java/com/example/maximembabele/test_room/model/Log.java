package com.example.maximembabele.test_room.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Log {
    public String Entry;

    @Generated(hash = 586466996)
    public Log(String Entry) {
        this.Entry = Entry;
    }

    @Generated(hash = 1364647056)
    public Log() {
    }

    public String getEntry() {
        return this.Entry;
    }

    public void setEntry(String Entry) {
        this.Entry = Entry;
    }
}
