package com.tolong.help.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.tolong.help.data.model.Teman;

import java.util.List;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7

@Dao
public interface TemanDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void addFriend(Teman... teman);

    @Delete
    void deleteFriend(Teman... teman);

    @Update
    void updateFriend(Teman... teman);

    @Query("SELECT * FROM teman ORDER BY nim")
    LiveData<List<Teman>> getAll();
}
