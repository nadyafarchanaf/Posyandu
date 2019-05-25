package com.example.nadya.posyandu.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Ibu extends User implements Parcelable {
    String noKK;
    public Ibu() {
    }

    public Ibu(String noKK) {
        this.noKK = noKK;
    }

    public Ibu(int id, String nama, String noKK) {
        super(id, nama);
        this.noKK = noKK;
    }

    public String getNoKK() {
        return noKK;
    }

    public void setNoKK(String noKK) {
        this.noKK = noKK;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.noKK);
        dest.writeInt(this.id);
        dest.writeString(this.nama);
    }

    protected Ibu(Parcel in) {
        this.noKK = in.readString();
        this.id = in.readInt();
        this.nama = in.readString();
    }

    public static final Parcelable.Creator<Ibu> CREATOR = new Parcelable.Creator<Ibu>() {
        @Override
        public Ibu createFromParcel(Parcel source) {
            return new Ibu(source);
        }

        @Override
        public Ibu[] newArray(int size) {
            return new Ibu[size];
        }
    };
}
