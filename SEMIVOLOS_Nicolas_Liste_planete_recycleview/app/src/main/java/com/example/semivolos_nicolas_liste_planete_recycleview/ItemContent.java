package com.example.semivolos_nicolas_liste_planete_recycleview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemContent extends AppCompatActivity {

    TextView nameTxt;
    TextView distTxt;
    ImageView img;
    TextView contentTxt;
    private String[] Data = {"Mercure","Venus","Mars","Jupiter","Saturne","Uranus","Neptune"};
    private String[] Distance = {"92","42","78","628","1277","2719","4347"};
    private String[] Content;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_SEMIVOLOS_Nicolas_Liste_planete_recycleview);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_content);

        Drawable[] mDrawables = {
                getDrawable(getResources().getIdentifier("mercury","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("venus","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("mars","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("jupiter","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("saturn","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("uranus","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("neptune","drawable",getPackageName()))
        };

        Content = getResources().getStringArray(R.array.planetDetails);

        nameTxt = (TextView)findViewById(R.id.nameDetail);
        distTxt = (TextView)findViewById(R.id.distDetail);
        img = (ImageView)findViewById(R.id.imgDetail);
        contentTxt = (TextView)findViewById(R.id.contentDetail);

        Intent intent = getIntent();
        int pos = intent.getIntExtra("position",0);
        String name = Data[pos];
        String dist = "Distance moy : "+Distance[pos]+" millions kms";

        nameTxt.setText(name);
        distTxt.setText(dist);
        img.setImageDrawable(mDrawables[pos]);

        contentTxt.setText(Content[pos]);
    }
}