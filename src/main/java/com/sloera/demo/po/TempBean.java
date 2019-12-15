package com.sloera.demo.po;

import java.io.Serializable;

public class TempBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String bsNum;
    private String item;

    public String getBsNum() {
        return bsNum;
    }

    public void setBsNum(String bsNum) {
        this.bsNum = bsNum;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
