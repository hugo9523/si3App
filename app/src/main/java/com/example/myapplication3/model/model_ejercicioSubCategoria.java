package com.example.myapplication3.model;

import android.os.Parcel;
import android.os.Parcelable;

public class model_ejercicioSubCategoria implements Parcelable {
    public String nombre_ejercicio,descripcion;
    public int idImagen;
    public model_ejercicioSubCategoria(String nombre_ejercicio,String descripcion, int idImagen)
    {
        this.nombre_ejercicio=nombre_ejercicio;
        this.descripcion= descripcion;
        this.idImagen=idImagen;
    }
    protected model_ejercicioSubCategoria(Parcel in) {
        nombre_ejercicio = in.readString();
        descripcion = in.readString();
        idImagen = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre_ejercicio);
        dest.writeString(descripcion);
        dest.writeInt(idImagen);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<model_ejercicioSubCategoria> CREATOR = new Creator<model_ejercicioSubCategoria>() {
        @Override
        public model_ejercicioSubCategoria createFromParcel(Parcel in) {
            return new model_ejercicioSubCategoria(in);
        }

        @Override
        public model_ejercicioSubCategoria[] newArray(int size) {
            return new model_ejercicioSubCategoria[size];
        }
    };
}
