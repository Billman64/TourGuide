package com.example.bill.tourguide;

public class Site {

    private String mName;
    private String mDescription;
    private String mLocation;
    private int mImageResource;

    private final int NO_IMAGE_RESOURCE = -1;

    public Site(String name, String description, String location){
        mName = name;
        mDescription = description;
        mLocation = location;
        mImageResource = NO_IMAGE_RESOURCE;
    }

    // 2nd constructor for POJO's with images
    public Site(String name, String description, String location, int imageResource){
        mName = name;
        mDescription = description;
        mLocation = location;
        mImageResource = imageResource;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public void setImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public boolean hasImage() { return mImageResource != NO_IMAGE_RESOURCE;}
}
