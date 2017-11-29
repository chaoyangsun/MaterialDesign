package com.yangge.test;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by charming-yin on 2017/9/22.
 */

public class ImageBean implements Parcelable {
    private String name;
    private int iamgeId;

    public ImageBean(String image, int imageId) {
        this.name = image;
        this.iamgeId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIamgeId() {
        return iamgeId;
    }

    public void setIamgeId(int iamgeId) {
        this.iamgeId = iamgeId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.iamgeId);
    }

    protected ImageBean(Parcel in) {
        this.name = in.readString();
        this.iamgeId = in.readInt();
    }

    public static final Parcelable.Creator<ImageBean> CREATOR = new Parcelable.Creator<ImageBean>() {
        @Override
        public ImageBean createFromParcel(Parcel source) {
            return new ImageBean(source);
        }

        @Override
        public ImageBean[] newArray(int size) {
            return new ImageBean[size];
        }
    };
}
