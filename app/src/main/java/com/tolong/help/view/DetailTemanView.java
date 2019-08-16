package com.tolong.help.view;

import com.tolong.help.data.model.Teman;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7

public interface DetailTemanView {
    void showDetail(Teman fr);
    void actionTelp();
    void actionEmail();
    void actionInstagram();
    void onHapusTeman();
}
