package com.example.omnigontest.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


import com.example.omnigontest.data.model.fixture.beans.Fixture;
import com.example.omnigontest.utils.Constants;

@Database(entities = {Fixture.class}, version = 1)
public abstract class MyDB extends RoomDatabase {

    private static MyDB sInstance;

    public abstract MyDao getDao();

    public static MyDB getDB(Context context) {
        if (sInstance == null) {
            synchronized (MyDao.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            MyDB.class,
                            Constants.DB_NAME).build();
                }
            }
        }
        return sInstance;
    }
}
