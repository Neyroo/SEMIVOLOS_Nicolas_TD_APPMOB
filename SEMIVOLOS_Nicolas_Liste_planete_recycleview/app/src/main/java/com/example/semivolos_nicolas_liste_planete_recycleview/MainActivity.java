package com.example.semivolos_nicolas_liste_planete_recycleview;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] Data = {"Mercure","Venus","Mars","Jupiter","Saturne","Uranus","Neptune"};
    private String[] Distance = {"92","42","78","628","1277","2719","4347"};

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_SEMIVOLOS_Nicolas_Liste_planete_recycleview);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable[] mDrawables = {
                getDrawable(getResources().getIdentifier("mercury","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("venus","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("mars","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("jupiter","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("saturn","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("uranus","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("neptune","drawable",getPackageName()))
        };

        recyclerView = (RecyclerView)findViewById(R.id.activity_main);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new rec_adapter(Data,Distance,mDrawables);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(),"Planete choisie : "+(Data[position]).toString(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,ItemContent.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        }));
    }
}