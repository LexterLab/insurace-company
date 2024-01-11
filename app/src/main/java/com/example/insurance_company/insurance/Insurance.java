package com.example.insurance_company.insurance;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Insurance implements Parcelable {
    private String name;
    private double price;
    private boolean active;
    private double reparation;

    public Insurance(String name, double price, boolean active, double reparation) {
        this.name = name;
        this.price = price;
        this.active = active;
        this.reparation = reparation;
    }

    public Insurance() {
    }

    protected Insurance(Parcel in) {
        name = in.readString();
        price = in.readDouble();
        active = in.readByte() != 0;
        reparation = in.readDouble();
    }

    public static final Creator<Insurance> CREATOR = new Creator<Insurance>() {
        @Override
        public Insurance createFromParcel(Parcel in) {
            return new Insurance(in);
        }

        @Override
        public Insurance[] newArray(int size) {
            return new Insurance[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getReparation() {
        return reparation;
    }

    public void setReparation(double reparation) {
        this.reparation = reparation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeDouble(price);
        parcel.writeByte((byte) (active ? 1 : 0));
        parcel.writeDouble(reparation);
    }
}
