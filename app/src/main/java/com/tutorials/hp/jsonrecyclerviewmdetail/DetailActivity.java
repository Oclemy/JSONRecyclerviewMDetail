package com.tutorials.hp.jsonrecyclerviewmdetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView nameTxt,emailTxt, usernameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nameTxt = (TextView) findViewById(R.id.nameDetailTxt);
        emailTxt= (TextView) findViewById(R.id.emailDetailTxt);
        usernameTxt = (TextView) findViewById(R.id.usernameDetailTxt);

        //GET INTENT
        Intent i=this.getIntent();

        //RECEIVE DATA
        String name=i.getExtras().getString("NAME_KEY");
        String email=i.getExtras().getString("EMAIL_KEY");
        String username=i.getExtras().getString("USERNAME_KEY");

        //BIND DATA
        nameTxt.setText(name);
        emailTxt.setText(email);
        usernameTxt.setText(username);



    }
}
