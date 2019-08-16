package com.tolong.help.presenter;

import android.content.Context;
import android.widget.EditText;

import com.tolong.help.data.model.User;
import com.tolong.help.data.repo.UserRepository;
import com.tolong.help.view.DaftarView;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7
public class PresenterDaftar {

    private DaftarView view;
    private UserRepository repo;

    public PresenterDaftar(Context context, DaftarView view) {
        this.view = view;
        repo = new UserRepository(context);
    }

    public void signUp(User user) {
        try {
            repo.insertUser(user);
            view.signUpSuccess();
        } catch (Exception ex) {
            view.signUpFailed();
        }
    }

    public void setError(EditText editText) {
        editText.requestFocus();
        editText.setError("Please fill this box !");
    }

    public void setPassError(EditText editText) {
        editText.requestFocus();
        editText.setError("Password length minimal 8 character !");
    }
}
