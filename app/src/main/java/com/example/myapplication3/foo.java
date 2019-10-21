package com.example.myapplication3;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class foo implements Parcelable {
    private List<foo> arrList = new ArrayList<foo>();

    public foo()
    {
        init();
    }
    void init()
    {
        this.a="aa";
        this.arrList= new ArrayList<>();
    }
    public foo(Parcel in) {
        this.a= in.readString();
        }

    public String a;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.a);
        //dest.writeTypedList(arrList);
    }
    /**
     * This field is needed for Android to be able to
     * create new objects, individually or as arrays
     *
     * If you don’t do that, Android framework will through exception
     * Parcelable protocol requires a Parcelable.Creator object called CREATOR
     */
    public static final Parcelable.Creator<foo> CREATOR = new Parcelable.Creator<foo>() {

        public foo createFromParcel(Parcel in) {
            return new foo(in);
        }

        public foo[] newArray(int size) {
            return new foo[size];
        }
    };

}
