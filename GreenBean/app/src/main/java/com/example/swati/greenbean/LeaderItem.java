package com.example.swati.greenbean;

/**
 * Created by Swati on 22-11-2015.
 */
public class LeaderItem {
    private String mName, mEmail;
    private int mPoints,mRank;
    LeaderItem(){}
    void setmName(String mName){this.mName=mName;}
    void setmEmail(String mEmail){this.mEmail=mEmail;}
    void setmPoints(int mPoints){this.mPoints=mPoints;}
    void setmRank(int mRank){this.mRank=mRank;}
    String getmName(){return mName;}
    String getmEmail(){return mEmail;}
    int getmPoints(){return  mPoints;}
    int getmRank(){return mRank;}
}
