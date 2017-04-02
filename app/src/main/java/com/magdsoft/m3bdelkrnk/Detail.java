package com.magdsoft.m3bdelkrnk;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Detail extends AppCompatActivity {

    ExpandableListAdapter listAdapter , listAdapter_Teach;
    ExpandableListView expListView , teachEx;

    List<String> listDataHeader , listDataHeader_Teach;
    HashMap<String, List<String>> listDataChild , listDataChild_Teach;

    ConstraintLayout cs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        cs = (ConstraintLayout)findViewById(R.id.activity_detail);
        clockwise(cs);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.history);
        teachEx = (ExpandableListView) findViewById(R.id.teach);

        // preparing list data
        prepareListDataForHistory();
        prepareListDataForTeach();

        // preparing list Adapters
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        listAdapter_Teach = new ExpandableListAdapter(this, listDataHeader_Teach, listDataChild_Teach);


        expListView.setAdapter(listAdapter);
        teachEx.setAdapter(listAdapter_Teach);


        Toolbar toolbarTop = (Toolbar) findViewById(R.id.toolbar_top_child1);
        TextView mTitle = (TextView) toolbarTop.findViewById(R.id.toolbar_title_child1);

        //Admob
        MobileAds.initialize(Detail.this , "ca-app-pub-2706569992906314~7597149382");
        AdView mAdView = (AdView) findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        Intent i = getIntent();
        String barname=i.getStringExtra("barName");
        mTitle.setText(barname);
        if(barname.equals("تاريخ معبد الكرنك"))
        {
            expListView.setAlpha(1);
            teachEx.getLayoutParams().width=1;
            teachEx.getLayoutParams().height=1;
        }
        else if (barname.equals("شرح سياحي لمعبد الكرنك"))
        {
            teachEx.setAlpha(1);
            expListView.getLayoutParams().width=1;
            expListView.getLayoutParams().height=1;
        }

/////////Back Button
        Button back =(Button)findViewById(R.id.back_button1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
/////////////////////

    }

    @Override
    public void onBackPressed() {
        finish();
    }


    private void prepareListDataForHistory() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add(getString(R.string.section1));
        listDataHeader.add(getString(R.string.section2));
        listDataHeader.add(getString(R.string.section3));

        // Adding child data
        List<String> SectionOne = new ArrayList<String>();
        SectionOne.add(getString(R.string.section1_subject));


        List<String> SectionTwo = new ArrayList<String>();
        SectionTwo.add(getString(R.string.section2_subject));


        List<String> SectionThree = new ArrayList<String>();
        SectionThree.add(getString(R.string.section3_subject1));
        SectionThree.add(getString(R.string.section3_subject2));
        SectionThree.add(getString(R.string.section3_subject3));
        SectionThree.add(getString(R.string.section3_subject4));
        SectionThree.add(getString(R.string.section3_subject5));
        SectionThree.add(getString(R.string.section3_subject6));
        SectionThree.add(getString(R.string.section3_subject7));
        SectionThree.add(getString(R.string.section3_subject8));
        SectionThree.add(getString(R.string.section3_subject9));
        SectionThree.add(getString(R.string.section3_subject10));
        SectionThree.add(getString(R.string.section3_subject11));
        SectionThree.add(getString(R.string.section3_subject12));


        listDataChild.put(listDataHeader.get(0), SectionOne); // Header, Child data
        listDataChild.put(listDataHeader.get(1), SectionTwo);
        listDataChild.put(listDataHeader.get(2), SectionThree);
    }



    private void prepareListDataForTeach() {
        listDataHeader_Teach = new ArrayList<String>();
        listDataChild_Teach = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader_Teach.add(getString(R.string.Teach_section1));
        listDataHeader_Teach.add(getString(R.string.Teach_section2));
        listDataHeader_Teach.add(getString(R.string.Teach_section3));
        listDataHeader_Teach.add(getString(R.string.Teach_section4));
        listDataHeader_Teach.add(getString(R.string.Teach_section5));
        listDataHeader_Teach.add(getString(R.string.Teach_section6));
        listDataHeader_Teach.add(getString(R.string.Teach_section7));
        listDataHeader_Teach.add(getString(R.string.Teach_section8));

        // Adding child data
        List<String> SectionOne = new ArrayList<String>();
        SectionOne.add(getString(R.string.Teach_sectrion1_subject));


        List<String> SectionTwo = new ArrayList<String>();
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject1));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject2));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject3));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject4));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject5));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject6));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject7));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject8));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject9));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject10));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject11));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject12));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject13));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject14));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject15));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject16));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject17));
        SectionTwo.add(getString(R.string.Teach_sectrion2_subject18));



        List<String> SectionThree = new ArrayList<String>();
        SectionThree.add(getString(R.string.Teach_sectrion3_subject));

        List<String> SectionFour= new ArrayList<String>();
        SectionFour.add(getString(R.string.Teach_sectrion4_subject));


        List<String> SectionFive = new ArrayList<String>();
        SectionFive.add(getString(R.string.Teach_sectrion5_subject));

        List<String> SectionSix = new ArrayList<String>();
        SectionSix.add(getString(R.string.Teach_sectrion6_subject));

        List<String> SectionSeven = new ArrayList<String>();
        SectionSeven.add(getString(R.string.Teach_sectrion7_subject));

        List<String> SectionEight = new ArrayList<String>();
        SectionEight.add(getString(R.string.Teach_sectrion8_Subject));





        listDataChild_Teach.put(listDataHeader_Teach.get(0), SectionOne); // Header, Child data
        listDataChild_Teach.put(listDataHeader_Teach.get(1), SectionTwo);
        listDataChild_Teach.put(listDataHeader_Teach.get(2), SectionThree);
        listDataChild_Teach.put(listDataHeader_Teach.get(3), SectionFour);
        listDataChild_Teach.put(listDataHeader_Teach.get(4), SectionFive);
        listDataChild_Teach.put(listDataHeader_Teach.get(5), SectionSix);
        listDataChild_Teach.put(listDataHeader_Teach.get(6), SectionSeven);
        listDataChild_Teach.put(listDataHeader_Teach.get(7), SectionEight);
    }


    public void clockwise(View view){
        android.view.animation.Animation animation= AnimationUtils.loadAnimation(Detail.this,R.anim.kk);
        cs.startAnimation(animation);

    }


}
