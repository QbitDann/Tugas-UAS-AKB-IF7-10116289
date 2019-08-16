package com.tolong.help.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tolong.help.presenter.CRUDTemanPresenter;
import com.tolong.help.R;
import com.tolong.help.data.model.Teman;
import com.tolong.help.view.CRUDTemanView;

import java.util.Objects;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7

public class CRUDTemanActivity extends AppCompatActivity implements CRUDTemanView {

    Toolbar toolbar;
    TextView tvTitle;
    EditText editNama, etNIM, etClass, etPhone, etEmail, etIG;
    CRUDTemanPresenter presenter;
    int type;

    @Override
    public void showData() {
        tvTitle.setText(getResources().getString(R.string.edit_friend));

        Teman f = getIntent().getParcelableExtra("friend");
        editNama.setText(f.getName());
        etNIM.setText(f.getNim());
        etClass.setText(f.getClass_());
        etPhone.setText(f.getPhone());
        etEmail.setText(f.getEmail());
        etIG.setText(f.getIg());
    }

    @Override
    public void onFriendAdded() {
        Toast.makeText(this, "Friend Added", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onFriendUpdated(Teman friend) {
        Intent i = new Intent();
        i.putExtra("newData", friend);
        setResult(Activity.RESULT_OK, i);

        Toast.makeText(this, "Friend Updated", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void showError(EditText et) {
        et.requestFocus();
        et.setError("Please Fill This Box !");
    }

    @Override
    public void showFailed(String msg) {
        Snackbar.make(etNIM, msg, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_teman);
        initView();
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        type = getIntent().getIntExtra("type", 0);

        presenter = new CRUDTemanPresenter(this, this);
        presenter.isEdit(type);
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbarAddFriends);
        tvTitle = findViewById(R.id.tvTitle);
        editNama = findViewById(R.id.editNama);
        etNIM = findViewById(R.id.etNIM);
        etClass = findViewById(R.id.etClass);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etIG = findViewById(R.id.etIG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_done, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

            case R.id.nav_done:
                Teman friend = new Teman(
                        editNama.getText().toString(),
                        etNIM.getText().toString(),
                        etClass.getText().toString(),
                        etPhone.getText().toString(),
                        etEmail.getText().toString(),
                        etIG.getText().toString()
                );

                if (!editNama.getText().toString().isEmpty()) {
                    if (!etNIM.getText().toString().isEmpty()) {
                        if (!etClass.getText().toString().isEmpty()) {

                            if (type == 0) presenter.addFriend(friend);
                            else presenter.updateFriend(friend);

                        } else presenter.setError(etClass);
                    } else presenter.setError(etNIM);
                } else presenter.setError(editNama);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
