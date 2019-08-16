package com.tolong.help.data.repo;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.tolong.help.data.model.Teman;
import com.tolong.help.data.db.AppDatabase;
import com.tolong.help.data.db.TemanDao;

import java.util.List;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7


public class FriendsRepository {
    private TemanDao temanDao;
    private LiveData<List<Teman>> friendsList;

    public FriendsRepository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        temanDao = db.temanDao();
        friendsList = temanDao.getAll();
    }

    public LiveData<List<Teman>> getAllFriends() {
        return friendsList;
    }

    public void insertFriend(Teman teman) {
        new insertAsync(temanDao).execute(teman);
    }

    public void updateFriend(Teman teman) {
        new updateAsync(temanDao).execute(teman);
    }

    public void deleteFriend(Teman teman) {
        new deleteAsync(temanDao).execute(teman);
    }

    private static class insertAsync extends AsyncTask<Teman, Void, Void> {
        private TemanDao temanDao;

        insertAsync(TemanDao temanDao) {
            this.temanDao = temanDao;
        }

        @Override
        protected Void doInBackground(Teman... teman) {
            temanDao.addFriend(teman);
            return null;
        }
    }

    private static class updateAsync extends AsyncTask<Teman, Void, Void> {
        private TemanDao temanDao;

        updateAsync(TemanDao temanDao) {
            this.temanDao = temanDao;
        }

        @Override
        protected Void doInBackground(Teman... teman) {
            temanDao.updateFriend(teman);
            return null;
        }
    }

    private static class deleteAsync extends AsyncTask<Teman, Void, Void> {
        private TemanDao temanDao;

        deleteAsync(TemanDao temanDao) {
            this.temanDao = temanDao;
        }

        @Override
        protected Void doInBackground(Teman... teman) {
            temanDao.deleteFriend(teman);
            return null;
        }
    }
}
