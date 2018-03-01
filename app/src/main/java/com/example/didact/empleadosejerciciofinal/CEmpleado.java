package com.example.didact.empleadosejerciciofinal;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DIDACT on 27/02/2018.
 */

public class CEmpleado implements Parcelable {

    String dni;
    String nombre;
    String oficio;

    public CEmpleado(String dni, String nombre, String oficio) {
        this.dni = dni;
        this.nombre = nombre;
        this.oficio = oficio;
    }

    public CEmpleado() {
    }

    public static final Creator <CEmpleado> CREATOR = new Creator <CEmpleado>() {
        @Override
        public CEmpleado createFromParcel(Parcel in) {
            return new CEmpleado(in);
        }

        @Override
        public CEmpleado[] newArray(int size) {
            return new CEmpleado[size];
        }
    };



    public CEmpleado(Parcel p) {
        readFromParcel(p);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dni);
        parcel.writeString(this.nombre);
        parcel.writeString(this.oficio);
    }


    private void readFromParcel(Parcel p) {

        this.nombre = p.readString();
        this.oficio = p.readString();
        this.dni = p.readString();


    }

}
