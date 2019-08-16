package com.tolong.help.view;

import com.tolong.help.data.model.User;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7


public interface HomeView {
    void showUser(User user);
    void onSignOut();
}
