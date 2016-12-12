package com.tutorials.hp.jsonrecyclerviewmdetail.m_UI;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tutorials.hp.jsonrecyclerviewmdetail.DetailActivity;
import com.tutorials.hp.jsonrecyclerviewmdetail.R;
import com.tutorials.hp.jsonrecyclerviewmdetail.m_Model.User;

import java.util.ArrayList;

/**
 * Created by Oclemy on 7/21/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    ArrayList<User> users;

    public MyAdapter(Context c, ArrayList<User> users) {
        this.c = c;
        this.users = users;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        User user= users.get(position);

        final String name=user.getName();
        final String email=user.getEmail();
        final String username=user.getUsername();

        //BIND
        holder.nameTxt.setText(name);
        holder.emailTxt.setText(email);
        holder.usernameTxt.setText(username);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                openDetailActivity(name,email,username);
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    ////open activity
    private void openDetailActivity(String...details)
    {
        Intent i=new Intent(c,DetailActivity.class);
        i.putExtra("NAME_KEY",details[0]);
        i.putExtra("EMAIL_KEY",details[1]);
        i.putExtra("USERNAME_KEY",details[2]);

        c.startActivity(i);

    }

}
