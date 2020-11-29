package com.nayyab.Sajid.Chapters.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class ParentDataItem implements Serializable {
    // TODO: 10/27/2020 images ...
    private int parentImages;
    private String parentName;
    private ArrayList<ChildDataItem> childDataItems;

    public ParentDataItem(int parentImages, String parentName, ArrayList<ChildDataItem> childDataItems) {
        this.parentImages = parentImages;
        this.parentName = parentName;
        this.childDataItems = childDataItems;
    }

    public int getParentImages() {
        return parentImages;
    }

    public void setParentImages(int parentImages) {
        this.parentImages = parentImages;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public ArrayList<ChildDataItem> getChildDataItems() {
        return childDataItems;
    }

    public void setChildDataItems(ArrayList<ChildDataItem> childDataItems) {
        this.childDataItems = childDataItems;

    }
}