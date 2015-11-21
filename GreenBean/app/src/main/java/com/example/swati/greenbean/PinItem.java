package com.example.swati.greenbean;

/**
 * Created by Swati on 21-11-2015.
 */
public class PinItem {
    private String mCategory, mTitle, mDescription, mImage;
    private int mValue;
    PinItem(){

    }
    PinItem(PinItem p){
        mCategory=p.mCategory;
        mTitle=p.mTitle;
        mValue=p.mValue;
        mDescription=p.mDescription;
    }
    String getmCategory(){return mCategory;}
    String getmTitle(){return mTitle;}
    String getmDescription(){return mDescription;}
    String getmImage(){return mImage;}
    int getmValue(){return mValue;}

    void setmCategory(String mCategory){this.mCategory=mCategory;}
    void setmTitle(String mTitle){this.mTitle=mTitle;}
    void setmDescription(String mDescription){this.mDescription=mDescription;}
    void setmImage(String mImage){this.mImage=mImage;}
    void setmValue(int mValue){this.mValue=mValue;}
}
