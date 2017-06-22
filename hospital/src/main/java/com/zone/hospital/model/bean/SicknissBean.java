package com.zone.hospital.model.bean;

import com.zone.hospital.model.adapter.Entity;

import java.io.Serializable;

/**
 * Created by zone on 2017/4/12.
 */

public class SicknissBean extends Entity implements Serializable{
    private String sickniss;
    private String[] question1={""};
    private String[] question2={""};
    private String[] question3={""};
    private String[] diaSickniss={""};

    public SicknissBean(String sickniss, String[] question1, String[] question2, String[] question3, String[] diaSickniss) {
        this.sickniss = sickniss;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.diaSickniss = diaSickniss;
    }

    public String getSickniss() {
        return sickniss;
    }

    public void setSickniss(String sickniss) {
        this.sickniss = sickniss;
    }

    public String[] getQuestion1() {
        return question1;
    }

    public void setQuestion1(String[] question1) {
        this.question1 = question1;
    }

    public String[] getQuestion2() {
        return question2;
    }

    public void setQuestion2(String[] question2) {
        this.question2 = question2;
    }

    public String[] getQuestion3() {
        return question3;
    }

    public void setQuestion3(String[] question3) {
        this.question3 = question3;
    }

    public String[] getDiaSickniss() {
        return diaSickniss;
    }

    public void setDiaSickniss(String[] diaSickniss) {
        this.diaSickniss = diaSickniss;
    }
}
