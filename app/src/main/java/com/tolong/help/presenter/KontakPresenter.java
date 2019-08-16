package com.tolong.help.presenter;

import com.tolong.help.view.KontakView;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7

public class KontakPresenter {

    private KontakView view;

    public KontakPresenter(KontakView view) {
        this.view = view;
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

    public void openTwitter() {
        view.actionTwitter();
    }
}
