package com.tolong.help.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import com.tolong.help.data.model.Teman;
import com.tolong.help.data.repo.FriendsRepository;
import com.tolong.help.view.TemanView;

import java.util.List;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7

public class TemanPresenter {

    private FriendsRepository repo;
    private TemanView view;
    private LiveData<List<Teman>> allFriends;

    public TemanPresenter(Context context, TemanView view) {
        this.view = view;
        repo = new FriendsRepository(context);
        allFriends = repo.getAllFriends();
    }

    public void setFriendsList(LifecycleOwner owner) {
        allFriends.observe(owner, new Observer<List<Teman>>() {
            @Override
            public void onChanged(@Nullable List<Teman> teman) {
                view.showFriendsList(teman);
            }
        });
    }
}
