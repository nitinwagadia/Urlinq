package com.example.model;

public class NotificationRecyclerData {
    private int imageId;
    private String notificationContent;
    private int notificationtype;
    private String notificationTime;
    private boolean isNew;


    public NotificationRecyclerData(int imageId, String notificationContent, int notificationtype, String notificationTime, boolean isNew) {
        this.imageId = imageId;
        this.notificationContent = notificationContent;
        this.notificationtype = notificationtype;
        this.notificationTime = notificationTime;
        this.isNew = isNew;
    }


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getNotificationContent() {
        return notificationContent;
    }

    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent;
    }

    public int getNotificationtype() {
        return notificationtype;
    }

    public void setNotificationtype(int notificationtype) {
        this.notificationtype = notificationtype;
    }


    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }
}
