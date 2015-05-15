package com.example.model;

public class ClassMemberData {
    private int memberType;
    private String memberName;
    private int memberImageID;
    private int Viewtype;
    //private int following;


    public ClassMemberData(int memberType, String memberName, int memberImageID, int Viewtype) {
        this.memberType = memberType;
        this.memberName = memberName;
        this.memberImageID = memberImageID;
        this.Viewtype = Viewtype;
    }

    public ClassMemberData(int Viewtype) {
        this.Viewtype = Viewtype;
    }

    public int getViewtype() {
        return Viewtype;
    }

    public void setViewtype(int viewtype) {
        Viewtype = viewtype;
    }

    public int getMemberImageID() {
        return memberImageID;
    }

    public void setMemberImageID(int memberImageID) {
        this.memberImageID = memberImageID;
    }

    public int getMemberType() {
        return memberType;
    }

    public void setMemberType(int memberType) {
        this.memberType = memberType;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}

