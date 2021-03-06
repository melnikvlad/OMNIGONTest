package com.example.omnigontest.data.model;



public class UIObject {
    public static final int TYPE_RESULT_AND_DATE = 0;
    public static final int TYPE_FIXTURE_AND_DATE = 3;
    public static final int TYPE_FIXTURE = 1;
    public static final int TYPE_RESULT = 2;

    private int type;
    private String date;

    public UIObject(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
