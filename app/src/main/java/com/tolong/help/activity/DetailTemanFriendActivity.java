package com.tolong.help.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tolong.help.presenter.DetailTemanPresenter;
import com.tolong.help.R;
import com.tolong.help.data.model.Teman;
import com.tolong.help.view.DetailTemanView;

import java.util.Objects;
import java.util.Random;


// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7

public class DetailTemanFriendActivity extends AppCompatActivity implements DetailTemanView, View.OnClickListener {

    Toolbar toolbar;
    ImageView avatar;
    TextView textNama, textNIM, textKelas, textTelp, textEmail, textInstagram;
    DetailTemanPresenter presenter;
    Teman teman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_detail);
        initView();
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        presenter = new DetailTemanPresenter(this, this);
        teman = getIntent().getParcelableExtra("friend");
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbarDetail);
        avatar = findViewById(R.id.imgFriendAva);
        textNama = findViewById(R.id.textNamaTeman);
        textNIM = findViewById(R.id.textNIMTeman);
        textKelas = findViewById(R.id.textKelasTeman);
        textTelp = findViewById(R.id.tvFriendPhone);
        textEmail = findViewById(R.id.tvFriendEmail);
        textInstagram = findViewById(R.id.tvFriendIg);
    }

    private String data(String value) {
        String newValue = "N/A";
        if (!value.isEmpty()) newValue = value;

        return newValue;
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getDetailTeman(teman);
    }

    @Override
    public void showDetail(Teman fr) {
        int[] ava = {R.drawable.ava1, R.drawable.ava2, R.drawable.ava3, R.drawable.ava4, R.drawable.ava5};
        Random ran = new Random();
        int i = ran.nextInt(ava.length);

        avatar.setImageResource(ava[i]);

        textNama.setText(teman.getName());
        textNIM.setText(teman.getNim());
        textKelas.setText(teman.getClass_());

        textTelp.setText(data(teman.getPhone()));
        textEmail.setText(data(teman.getEmail()));
        textInstagram.setText(data(teman.getIg()));
    }

    @Override
    public void actionEmail() {
        if (!teman.getEmail().isEmpty()) {
            Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + teman.getEmail()));
            startActivity(i);
        }
    }


    @Override
    public void actionTelp() {
        if (!teman.getPhone().isEmpty()) {
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", teman.getPhone(), null));
            startActivity(i);
        }
    }


    @Override
    public void actionInstagram() {
        if (!teman.getIg().isEmpty()) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/" + teman.getIg().replace("@", "")));
            startActivity(i);
        }
    }

    @Override
    public void onHapusTeman() {
        Toast.makeText(this, "Teman DIHAPUS", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.noTelp:
                presenter.PanggilTeman();
                break;
            case R.id.lytEmail:
                presenter.sendEmail();
                break;
            case R.id.lytIg:
                presenter.linkInstagram();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.nav_delete:
                presenter.removeFriend(teman);
                break;
            case R.id.nav_edit:
                Intent i = new Intent(DetailTemanFriendActivity.this, CRUDTemanActivity.class);
                i.putExtra("type", 1);
                i.putExtra("friend", teman);
                startActivityForResult(i, 1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                teman = data.getParcelableExtra("newData");
            }
        }
    }
}
