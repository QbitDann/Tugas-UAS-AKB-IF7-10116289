package com.tolong.help.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.tolong.help.preference.UserPreference;
import com.tolong.help.R;
import com.tolong.help.data.model.Teman;
import com.tolong.help.data.model.DataTeman;
import com.tolong.help.data.repo.FriendsRepository;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7

public class SplashActivity extends AppCompatActivity {

    FriendsRepository repo;
    UserPreference prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        repo = new FriendsRepository(this);
        prefs = new UserPreference(this);

        Boolean isFirstRun = prefs.isFirstRun();
        if (isFirstRun) {
            Teman teman;
            for (String[] aData : DataTeman.initFriendsData) {
                teman = new Teman(aData[0], aData[1], aData[2], aData[3], aData[4], aData[5]);
                repo.insertFriend(teman);
            }

            prefs.setFirstRun(false);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        },2000);
    }
}
