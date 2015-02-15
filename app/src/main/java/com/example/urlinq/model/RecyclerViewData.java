package com.example.urlinq.model;

public class RecyclerViewData {
    private int imageId;
    private String header;
    private String middleString;
    private String notificationString = "0";
    private boolean isNotificationVisible = false;

    public RecyclerViewData(int imageId, String middleString,
                            String notificationString, boolean isNotificationVisible) {
        this.imageId = imageId;
        this.middleString = middleString;
        this.notificationString = notificationString;
        this.isNotificationVisible = isNotificationVisible;
        this.header = null;
    }

    public RecyclerViewData(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setNotificationVisible(boolean isNotificationVisible) {
        this.isNotificationVisible = isNotificationVisible;
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
