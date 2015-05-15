package com.example.model;

public class RecyclerViewData {
    private int imageId;
    private String header;
    private String middleString;
    private String notificationString = "0";
    private boolean isNotificationVisible = false;
    private int type = 0;

    public RecyclerViewData(int imageId, String middleString,
                            String notificationString, boolean isNotificationVisible, int type) {
        this.imageId = imageId;
        this.middleString = middleString;
        this.notificationString = notificationString;
        this.isNotificationVisible = isNotificationVisible;
        //Added type
        this.type = type;
        this.header = null;

    }


    public RecyclerViewData(String header) {
        this.header = header;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isNotificationVisible() {
        return isNotificationVisible;
    }

    public void setNotificationVisible(boolean isNotificationVisible) {
        this.isNotificationVisible = isNotificationVisible;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getNotificationString() {
        return notificationString;
    }

    public void setNotificationString(String notificationString) {
        this.notificationString = notificationString;
    }

    public Boolean getIsNotificationVisible() {
        return isNotificationVisible;
    }

    public void setIsNotificationVisible(Boolean isNotificationVisible) {
        this.isNotificationVisible = isNotificationVisible;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getMiddleString() {
        return middleString;
    }

    public void setMiddleString(String middleString) {
        this.middleString = middleString;
    }

}
