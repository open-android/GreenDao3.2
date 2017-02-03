package com.heima.greendao.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by lidongzhi on 2017/2/3.
 */

@Entity
public class Student {

    @Id
    private long id;
    private String name;

    @Generated(hash = 1556870573)
    public Student() {
    }

    @Generated(hash = 1314737876)
    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}