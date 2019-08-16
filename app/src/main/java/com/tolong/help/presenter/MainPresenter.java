package com.tolong.help.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.tolong.help.preference.UserPreference;
import com.tolong.help.view.MainView;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7

public class MainPresenter {

    private MainView view;
    private UserPreference prefs;

    public MainPresenter(Context context, MainView view) {
        this.view = view;
        prefs = new UserPreference(context);
    }

    public void isLogin() {
        if (prefs.userLogin() == null) view.toLogin();
    }

    public void addView() {
        view.addView();
    }

    public void changeView(Fragment fragment) {
        view.showView(fragment);
    }
}
