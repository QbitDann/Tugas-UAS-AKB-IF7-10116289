package com.tolong.help.presenter;

import android.content.Context;
import android.widget.EditText;

import com.tolong.help.data.model.Teman;
import com.tolong.help.data.repo.FriendsRepository;
import com.tolong.help.view.CRUDTemanView;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7

public class CRUDTemanPresenter {

    private FriendsRepository repo;
    private CRUDTemanView view;

    public CRUDTemanPresenter(Context context, CRUDTemanView view) {
        this.view = view;
        repo = new FriendsRepository(context);
    }

    public void isEdit(int type) {
        if (type == 1) {
            view.showData();
        }
    }

    public void addFriend(Teman friend) {
        try {
            repo.insertFriend(friend);
            view.onFriendAdded();
        } catch (Exception ex) {
            view.showFailed("Failed to add friend, NIM "+friend.getNim()+" already used");
        }
    }

    public void updateFriend(Teman friend) {
        try {
            repo.updateFriend(friend);
            view.onFriendUpdated(friend);
        } catch (Exception ex) {
            view.showFailed("Failed to update friend, NIM "+friend.getNim()+" already used");
        }
    }

    public void setError(EditText et) {
        view.showError(et);
    }
}
