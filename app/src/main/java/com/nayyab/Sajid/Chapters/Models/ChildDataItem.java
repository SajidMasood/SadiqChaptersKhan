package com.nayyab.Sajid.Chapters.Models;

import java.io.Serializable;

public class ChildDataItem implements Serializable {

    private String childName;

    public ChildDataItem(String childName) {
        this.childName = childName;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }
}
