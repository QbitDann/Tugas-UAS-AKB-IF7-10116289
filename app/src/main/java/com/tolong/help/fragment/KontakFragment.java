package com.tolong.help.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.tolong.help.presenter.KontakPresenter;
import com.tolong.help.R;
import com.tolong.help.view.KontakView;


// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7


public class KontakFragment extends Fragment implements KontakView, View.OnClickListener {

    RelativeLayout noTelp, lytEmail, lytIG, lytTwitter;
    KontakPresenter presenter;

    public KontakFragment() {
        // Required empty public constructor
    }

    public static KontakFragment newInstance() {
        return new KontakFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kontak, container, false);

        noTelp = view.findViewById(R.id.noTelp);
        lytEmail = view.findViewById(R.id.lytEmail);
        lytIG = view.findViewById(R.id.lytIg);
        lytTwitter = view.findViewById(R.id.lytTwitter);

        noTelp.setOnClickListener(this);
        lytEmail.setOnClickListener(this);
        lytIG.setOnClickListener(this);
        lytTwitter.setOnClickListener(this);

        presenter = new KontakPresenter(this);

        return view;
    }

    @Override
    public void actionTelp() {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel","6281313873670", null));
        startActivity(i);
    }

    @Override
    public void actionEmail() {
        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:luthfialfarizi98@gmail.com"));
        startActivity(i);
    }

    @Override
    public void actionInstagram() {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/luthfi_alfariz"));
        startActivity(i);
    }

    @Override
    public void actionTwitter() {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/luthfi_alfariz"));
        startActivity(i);
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
            case R.id.lytTwitter:
                presenter.openTwitter();
                break;
        }
    }
}
