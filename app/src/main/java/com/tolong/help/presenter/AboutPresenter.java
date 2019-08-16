package com.tolong.help.presenter;

import com.tolong.help.view.AboutView;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7

public class AboutPresenter {

    private AboutView view;

    public AboutPresenter(AboutView view) {
        this.view = view;
    }

    public void selectionView(int tab) {
        if (tab == 0) {
            view.showApp();
        } else {
            view.showCreator();
        }
    }
}
