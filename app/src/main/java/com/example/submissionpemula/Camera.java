package com.example.submissionpemula;

import android.os.Parcel;
import android.os.Parcelable;

public class Camera implements Parcelable {
    private String name, type, price, desc, photo;

    /* method parcelable */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.type);
        dest.writeString(this.price);
        dest.writeString(this.desc);
        dest.writeString(this.photo);
    }

    public Camera() {
    }

    protected Camera(Parcel in) {
        this.name = in.readString();
        this.type = in.readString();
        this.price = in.readString();
        this.desc = in.readString();
        this.photo = in.readString();
    }

    public static final Parcelable.Creator<Camera> CREATOR = new Parcelable.Creator<Camera>() {
        @Override
        public Camera createFromParcel(Parcel source) {
            return new Camera(source);
        }

        @Override
        public Camera[] newArray(int size) {
            return new Camera[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
