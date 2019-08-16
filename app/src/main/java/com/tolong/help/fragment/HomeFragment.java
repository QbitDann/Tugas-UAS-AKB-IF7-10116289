package com.tolong.help.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tolong.help.presenter.HomePresenter;
import com.tolong.help.R;
import com.tolong.help.activity.LoginActivity;
import com.tolong.help.data.model.User;
import com.tolong.help.view.HomeView;

import java.util.Objects;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7


public class HomeFragment extends Fragment implements HomeView {

    HomePresenter presenter;
    TextView tvUser;
    Button btnSignOut;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void showUser(User user) {
        String username = user.getNane() + " (" + user.getUsername() +")";
        tvUser.setText(username);
    }

    @Override
    public void onSignOut() {
        Intent i = new Intent(getContext(), LoginActivity.class);
        startActivity(i);
        Toast.makeText(getContext(), "Signed Out", Toast.LENGTH_SHORT).show();
        Objects.requireNonNull(getActivity()).finish();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tvUser = view.findViewById(R.id.tvUser);
        btnSignOut = view.findViewById(R.id.btnSignOut);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter = new HomePresenter(getContext(), this);
        presenter.getUserData(this);

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.signOut();
            }
        });
    }
}
