package com.tolong.help.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tolong.help.presenter.TemanPresenter;
import com.tolong.help.R;
import com.tolong.help.activity.CRUDTemanActivity;
import com.tolong.help.adapter.AdapterTeman;
import com.tolong.help.data.model.Teman;
import com.tolong.help.view.TemanView;

import java.util.ArrayList;
import java.util.List;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7

public class TemanFragment extends Fragment implements TemanView, View.OnClickListener {

    AdapterTeman adapter;
    ArrayList<Teman> teman;
    static TemanPresenter presenter;
    RecyclerView rvFriends;
    FloatingActionButton fab;

    public TemanFragment() {
        // Required empty public constructor
    }

    @Override
    public void showFriendsList(List<Teman> teman) {
        this.teman.clear();
        this.teman.addAll(teman);
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teman, container, false);
        rvFriends = view.findViewById(R.id.rvFriends);
        fab = view.findViewById(R.id.fabAddFriends);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        teman = new ArrayList<>();
        adapter = new AdapterTeman(teman, getActivity());
        rvFriends.setHasFixedSize(true);
        rvFriends.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFriends.setAdapter(adapter);

        presenter = new TemanPresenter(getContext(),this);
        presenter.setFriendsList(this);

        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fabAddFriends) {
            Intent i = new Intent(getContext(), CRUDTemanActivity.class);
            i.putExtra("type", 0);
            startActivity(i);
        }
    }
}
