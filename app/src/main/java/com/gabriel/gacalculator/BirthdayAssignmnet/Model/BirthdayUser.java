package com.gabriel.gacalculator.BirthdayAssignmnet.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class BirthdayUser {

    @PrimaryKey (autoGenerate = true)
    public int id;

    @ColumnInfo (name = "epochtimeDate")
    public long epochtimeDate;

    @ColumnInfo (name = "name")
    public String name;

    @ColumnInfo (name = "comment")
    public String comment;

    public BirthdayUser(long epochtimeDate, String name, String comment) {
        this.epochtimeDate = epochtimeDate;
        this.name = name;
        this.comment = comment;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getEpochtimeDate() {
        return epochtimeDate;
    }

    public void setEpochtimeDate(long epochtimeDate) {
        this.epochtimeDate = epochtimeDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

