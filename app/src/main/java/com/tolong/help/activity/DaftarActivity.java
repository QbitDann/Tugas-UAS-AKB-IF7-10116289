package com.tolong.help.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tolong.help.presenter.PresenterDaftar;
import com.tolong.help.R;
import com.tolong.help.data.model.User;
import com.tolong.help.view.DaftarView;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7


public class DaftarActivity extends AppCompatActivity implements DaftarView {

    PresenterDaftar presenter;
    EditText editUser, editNama, editPass;
    TextView tvFailed;
    Button btnSignUp;

    @Override
    public void signUpSuccess() {
        Toast.makeText(this, "Berhasil Mendaftar", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void signUpFailed() {
        tvFailed.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        initView();

        presenter = new PresenterDaftar(this, this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void initView() {
        editUser = findViewById(R.id.editUser);
        editNama = findViewById(R.id.editNama);
        editPass = findViewById(R.id.editPass);
        tvFailed = findViewById(R.id.tvFailed);
        btnSignUp = findViewById(R.id.btnSignUp);
    }

    private void signUp() {
        String username = editUser.getText().toString();
        String name = editNama.getText().toString();
        String pass = editPass.getText().toString();

        User user = new User(username, name, pass);

        if (!username.isEmpty()) {
            if (!name.isEmpty()) {
                if (pass.length() >= 8) {

                    presenter.signUp(user);

                } else presenter.setPassError(editPass);
            } else presenter.setError(editNama);
        } else presenter.setError(editUser);
    }
}
