package com.tolong.help.presenter;

import android.content.Context;

import com.tolong.help.data.model.Teman;
import com.tolong.help.data.repo.FriendsRepository;
import com.tolong.help.view.DetailTemanView;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7

public class DetailTemanPresenter {

    private DetailTemanView view;
    private FriendsRepository repo;

    public DetailTemanPresenter(Context context, DetailTemanView view) {
        this.view = view;
        repo = new FriendsRepository(context);
    }

    public void getDetailTeman(Teman fr) {
        view.showDetail(fr);
}
    public void PanggilTeman() {
        view.actionTelp();
    }
    public void sendEmail() {
        view.actionEmail();
    }
    public void linkInstagram() {
        view.actionInstagram();
    }
    public void removeFriend(Teman friend) {
        repo.deleteFriend(friend);
        view.onHapusTeman();
    }
}
