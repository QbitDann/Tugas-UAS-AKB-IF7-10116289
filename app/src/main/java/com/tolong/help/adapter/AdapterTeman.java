package com.tolong.help.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tolong.help.activity.DetailTemanFriendActivity;
import com.tolong.help.R;
import com.tolong.help.data.model.Teman;

import java.util.ArrayList;
import java.util.Random;

// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7

public class AdapterTeman extends RecyclerView.Adapter<AdapterTeman.ViewHolder>  {

    private ArrayList<Teman> teman;
    private Context context;

    public AdapterTeman(ArrayList<Teman> teman, Context context) {
        this.teman = teman;
        this.context = context;
    }

    public void setData(ArrayList<Teman> items) {
        this.teman = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_friends, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        int[] ava = {R.drawable.ava1, R.drawable.ava2, R.drawable.ava3, R.drawable.ava4, R.drawable.ava5};
        Random ran = new Random();
        int j = ran.nextInt(ava.length);

        viewHolder.avatar.setImageResource(ava[j]);
        viewHolder.textNama.setText(teman.get(i).getName());
        viewHolder.textNIM.setText(teman.get(i).getNim());

        final Teman item = teman.get(i);
        final int pos = i;
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DetailTemanFriendActivity.class);
                i.putExtra("friend", item);
                i.putExtra("position", pos);
                context.startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return teman.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView textNama, textNIM;

        ViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            textNama = itemView.findViewById(R.id.textNama);
            textNIM = itemView.findViewById(R.id.textNIM);
        }
    }

}
