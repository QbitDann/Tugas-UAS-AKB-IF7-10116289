package com.tolong.help.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tolong.help.data.model.User;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void addUser(User... users);

    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    LiveData<User> login(String username, String password);
}
