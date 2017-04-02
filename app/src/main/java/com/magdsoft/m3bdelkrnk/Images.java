package com.magdsoft.m3bdelkrnk;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;



public class Images extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView_dAdapter recyclerView_dAdapter;
    public List<List_Item> listItems;
    ConstraintLayout cs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        Button Back = (Button)findViewById(R.id.back_button2);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

         cs = (ConstraintLayout)findViewById(R.id.activity_images);
         clockwise(cs);


        MobileAds.initialize(Images.this , "ca-app-pub-2706569992906314~7597149382");
        AdView mAdView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        listItems = new ArrayList<>();


        listItems.add(new List_Item("طريق الكباش", R.drawable.p2));
        listItems.add(new List_Item("طريق الكباش", R.drawable.p3));
        listItems.add(new List_Item("معبد الكرنك", R.drawable.p6));
        listItems.add(new List_Item("البحيرة المقدسة", R.drawable.p1));
        listItems.add(new List_Item("بهو الاعمدة", R.drawable.p7));
        listItems.add(new List_Item("جدار معبد الكرنك", R.drawable.p10));
        listItems.add(new List_Item("طريق الكباش", R.drawable.p11));
        listItems.add(new List_Item("بهو الاعمدة", R.drawable.p12));
        listItems.add(new List_Item("مقصورة المركب المقدسة", R.drawable.p13));
        listItems.add(new List_Item("معبد الكرنك", R.drawable.p14));


        recyclerView_dAdapter = new RecyclerView_dAdapter(listItems, this);
        recyclerView.setAdapter(recyclerView_dAdapter);





    }

    public void clockwise(View view){
        android.view.animation.Animation animation= AnimationUtils.loadAnimation(Images.this,R.anim.kk);
        cs.startAnimation(animation);

    }


    @Override
    public void onBackPressed() {
            finish();
    }
}
