package com.ljw.vo;



public class MediaConfEntity extends MediaConf {
    private Integer rateType;
    private String rateTypeDesc;
    private String ves;

    public Integer getRateType() {
        return rateType;
    }

    public void setRateType(Integer rateType) {
        this.rateType = rateType;
    }

    public String getRateTypeDesc() {
        return rateTypeDesc;
    }

    public void setRateTypeDesc(String rateTypeDesc) {
        this.rateTypeDesc = rateTypeDesc;
    }

    public String getVes() {
        return ves;
    }

    public void setVes(String ves) {
        this.ves = ves;
    }

}
