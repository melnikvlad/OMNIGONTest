package com.example.omnigontest.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.omnigontest.data.model.fixture.beans.Fixture;
import com.example.omnigontest.utils.Constants;

import java.util.List;


@Dao
public interface MyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Fixture entity);

    @Query("SELECT * FROM " + Constants.TABLE_NAME)
    List<Fixture> getAllFixtures();

    @Query("DELETE FROM " + Constants.TABLE_NAME)
    int clear();
}