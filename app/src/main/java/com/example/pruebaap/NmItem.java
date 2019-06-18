package com.example.pruebaap;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

//Create an Entity NmItem which is mapped to a table in the database
//with id, task and timestamp fields
@Entity
public class NmItem {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private String Date;
    private String Hour;
    private String City;
    private String Flag1;
    private String Flag2;

    public NmItem(@NonNull String date, String hour, String city, String flag1, String flag2) {
        this.Date = Date;
        this.Hour = Hour;
        this.City = City;
        this.Flag1 = flag1;
        this.Flag2 = flag2;
    }

    @NonNull
    public String getDate() {

        return Date;
    }

    public void setDate(@NonNull String Date) {

        this.Date = Date;
    }

    public String getHour() {

        return Hour;
    }

    public void setHour(String Hour) {

        this.Hour = Hour;
    }

    public String getCity() {

        return City;
    }

    public void setCity(String City) {

        this.City = City;
    }

    public String getFlag1() {
        return Flag1;
    }

    public void setFlag1(String flag1) {
        Flag1 = flag1;
    }

    public String getFlag2() {
        return Flag2;
    }

    public void setFlag2(String flag2) {
        Flag2 = flag2;
    }
}