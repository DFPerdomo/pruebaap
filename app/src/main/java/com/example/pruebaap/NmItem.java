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

    public NmItem(@NonNull String date, String hour, String city) {
        this.Date = Date;
        this.Hour = Hour;
        this.City = City;
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
}