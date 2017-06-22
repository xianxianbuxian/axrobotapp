package com.zone.hospital.model.bean;


import com.zone.hospital.model.adapter.Entity;

/**
 * Created by john on 2016/11/4.
 */
public class StuDirBean extends Entity {
    private String title;

    public StuDirBean(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
