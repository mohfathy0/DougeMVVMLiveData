package com.example.dougemvvmlivedata.ActivityWithSnapshot;


public enum QueryFields {

    myName("charName"),
    myTitle("charTitle"),
    myID("id");

    private String field;

    QueryFields(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
