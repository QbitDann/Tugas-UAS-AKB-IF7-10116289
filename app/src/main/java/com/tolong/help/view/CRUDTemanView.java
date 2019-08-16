package com.tolong.help.view;

import android.widget.EditText;

import com.tolong.help.data.model.Teman;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7

public interface CRUDTemanView {
    void showData();
    void onFriendAdded();
    void onFriendUpdated(Teman friend);
    void showError(EditText et);
    void showFailed(String msg);
}
