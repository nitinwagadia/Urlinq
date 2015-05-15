package com.example.model;

/**
 * Created by nitin on 3/9/15.
 */
public class ClassFeedRecyclerData {
    private int imageId;
    private String textTitle1 = "";
    private String textTitle2 = "";
    private String textTitle3 = "";
    private String textTitle4 = "";
    private String contents = "";


    public ClassFeedRecyclerData(int imageId, String textTitle1, String textTitle2, String textTitle3, String textTitle4, String contents) {
        this.imageId = imageId;
        this.textTitle1 = textTitle1;
        this.textTitle2 = textTitle2;
        this.textTitle3 = textTitle3;
        this.textTitle4 = textTitle4;
        this.contents = contents;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTextTitle1() {
        return textTitle1;
    }

    public void setTextTitle1(String textTitle1) {
        this.textTitle1 = textTitle1;
    }

    public String getTextTitle2() {
        return textTitle2;
    }

    public void setTextTitle2(String textTitle2) {
        this.textTitle2 = textTitle2;
    }

    public String getTextTitle3() {
        return textTitle3;
    }

    public void setTextTitle3(String textTitle3) {
        this.textTitle3 = textTitle3;
    }

    public String getTextTitle4() {
        return textTitle4;
    }

    public void setTextTitle4(String textTitle4) {
        this.textTitle4 = textTitle4;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
