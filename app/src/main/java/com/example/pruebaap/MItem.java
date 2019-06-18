package com.example.pruebaap;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

//Create an Entity NmItem which is mapped to a table in the database
//with id, task and timestamp fields
@Entity
public class MItem {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    String Date;
    String Score;
    int Flag12;
    int Flag22;

    public MItem(@NonNull String date, String score, int flag12, int flag22) {
        this.Date = Date;
        this.Score = Score;
        this.Flag12 = Flag12;
        this.Flag22 = Flag22;
    }

    @NonNull
    public String getDate() {

        return Date;
    }

    public void setDate(@NonNull String Date) {

        this.Date = Date;
    }

    public String getScore() {

        return Score;
    }

    public int getFlag12() {

        return Flag12;
    }

    public void setFlag12(int flag12) {

        Flag12 = flag12;
    }

    public int getFlag22()

    {
        return Flag22;
    }

    public void setFlag22(int flag22)
    {
        Flag22 = flag22;
    }
}