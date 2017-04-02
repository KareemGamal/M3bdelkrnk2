package com.magdsoft.m3bdelkrnk;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class gallery extends AppCompatActivity {
int drawable [] = { R.drawable.p2 ,R.drawable.p3 ,R.drawable.p6 ,R.drawable.p1 ,R.drawable.p7 ,  R.drawable.p10 , R.drawable.p11 ,R.drawable.p12 , R.drawable.p13 ,R.drawable.p14   };

    ImageView iv;
    int positionn=(RecyclerView_dAdapter.po);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Gallery simpleGallery = (Gallery) findViewById(R.id.gg); // get the reference of Gallery
        iv = (ImageView) findViewById(R.id.iv); // get the reference of ImageView
       ImageAdapter customGalleryAdapter = new ImageAdapter(this, drawable); // initialize the adapter
        simpleGallery.setAdapter(customGalleryAdapter); // set the adapter
        simpleGallery.setSpacing(10);
        simpleGallery.setSelection(positionn);

    }


    public class ImageAdapter extends BaseAdapter{

        Context c ;
        int background[];

        public ImageAdapter(Context c , int [] images)
        {
            background=images;
            this.c=c;
        }

        @Override
        public int getCount() {
            return drawable.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            ImageView imageView = new ImageView(c);
            imageView.setImageResource(drawable[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER);

            return imageView;
        }
    }
}
