package com.gabriel.gacalculator.BirthdayAssignmnet;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.gabriel.gacalculator.BirthdayAssignmnet.Model.BirthdayUser;


@Database(entities = {BirthdayUser.class}, version = 1)
public abstract class BirthdayDatabase extends RoomDatabase {
    public abstract UserBirthdayDao userBirthdayDao();
}
