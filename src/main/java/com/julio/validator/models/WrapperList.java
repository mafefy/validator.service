package com.julio.validator.models;

import java.util.List;

public class WrapperList {

    private List<? extends Object> myList;

    public List<? extends Object> getMyList() {
        return myList;
    }

    public void setMyList(List<? extends Object> myList) {
        this.myList = myList;
    }
}
