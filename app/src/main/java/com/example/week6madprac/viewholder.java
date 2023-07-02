package com.example.week6madprac;

import static android.content.ContentValues.TAG;

import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class viewholder extends RecyclerView.ViewHolder {
    TextView txt;
    TextView txt2;
    ImageView image1;


    public viewholder(View itemView, ArrayList<User> list_objects){
        super(itemView);
        txt = itemView.findViewById(R.id.Name);
        txt2 = itemView.findViewById(R.id.details);
        image1 = itemView.findViewById(R.id.profileIMG);
        image1.setOnClickListener(new View.OnClickListener(){
                                      public void onClick(View v){

                                          Log.v(TAG,"Icon have been clicked");

                                          AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                                          builder.setTitle("Profile");
                                          builder.setMessage("MADness");
                                          builder.setCancelable(true);
                                          builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                                              @Override
                                              public void onClick(DialogInterface dialog, int which) {
                                                  Intent profile = new Intent(itemView.getContext(),MainActivity2.class);
                                                  User user = list_objects.get(getAdapterPosition());
                                                  profile.putExtra("UserID",user);
                                                  itemView.getContext().startActivity(profile);
                                              }
                                          });
                                          builder.setNegativeButton("ClOSE", new DialogInterface.OnClickListener() {
                                              @Override
                                              public void onClick(DialogInterface dialog, int which) {


                                              }
                                          });
                                          AlertDialog alert = builder.create();
                                          alert.show();
                                      }
                                  }
        );

    }

}
