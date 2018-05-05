package com.gabriel.gacalculator.BirthdayAssignmnet;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.gabriel.gacalculator.BirthdayAssignmnet.Model.BirthdayUser;

import java.util.List;


@Dao
public interface UserBirthdayDao {
    @Query("Select * From birthdayUser")
    List<BirthdayUser> getAllBirthdaysUsers();

    @Insert
    void insertAll(BirthdayUser... birthdayUsers);
}
