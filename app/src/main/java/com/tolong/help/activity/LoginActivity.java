package com.tolong.help.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tolong.help.presenter.LoginPresenter;
import com.tolong.help.R;
import com.tolong.help.view.LoginView;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7


public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    LoginPresenter presenter;
    EditText editUser, editPass;
    TextView tvWrong;
    Button btnLogin, btnSignUp;

    @Override
    public void loginSuccess() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void loginFail() {
        tvWrong.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        presenter = new LoginPresenter(this, this);
        btnLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin) login();
        else if (v.getId() == R.id.btnSignUp) {
            Intent i = new Intent(this, DaftarActivity.class);
            startActivity(i);
        }
    }

    private void initView() {
        editUser = findViewById(R.id.editUser);
        editPass = findViewById(R.id.editPass);
        tvWrong = findViewById(R.id.textGagal);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
    }

    private void login() {
        if (!editUser.getText().toString().isEmpty()) {
            if (!editPass.getText().toString().isEmpty()){

                presenter.login(this, editUser.getText().toString(), editPass.getText().toString());

            } else presenter.setError(editPass);
        } else presenter.setError(editUser);
    }
}
