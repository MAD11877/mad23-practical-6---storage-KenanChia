package com.example.week6madprac;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.v(TAG, "on Create!!");
        TextView UserID= findViewById(R.id.UserID);
        Intent ReceiveID= getIntent();
        User user =(User) ReceiveID.getSerializableExtra("UserID");
        UserID.setText(user.getName());
        Button follow = findViewById(R.id.Follow);
        if(user.followed == false){
            follow.setText("Follow");
        }
        else{
            follow.setText("Unfollow");
        }
        DBHandler DB = new DBHandler(this, null,null,1);
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.followed == false){
                    follow.setText("UnFollow");
                    user.followed=true;
                    DB.updateUser(user);

                }
                else
                {
                    user.followed=false;
                    follow.setText("Follow");
                    DB.updateUser(user);
                }
            }
        });
    }

}