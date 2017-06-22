package com.zone.hospital.model;

import com.zone.hospital.model.adapter.Entity;

/**
 * Created by zone on 2017/4/13.
 */

public class StringBean extends Entity {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public StringBean(String content) {

        this.content = content;
    }
}
