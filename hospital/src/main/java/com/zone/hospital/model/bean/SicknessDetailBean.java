package com.zone.hospital.model.bean;

/**
 * Created by zone on 2017/4/13.
 */

public class SicknessDetailBean {

    private String sickness;
    private String general;
    private String apartment;
    private String description;

    public SicknessDetailBean(String sickness, String general, String apartment, String description) {
        this.sickness = sickness;
        this.general = general;
        this.apartment = apartment;
        this.description = description;
    }

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
