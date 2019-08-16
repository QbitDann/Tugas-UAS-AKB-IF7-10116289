package com.tolong.help.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.tolong.help.data.model.Teman;
import com.tolong.help.data.model.User;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7

@Database(entities = {Teman.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TemanDao temanDao();
    public abstract UserDao userDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
