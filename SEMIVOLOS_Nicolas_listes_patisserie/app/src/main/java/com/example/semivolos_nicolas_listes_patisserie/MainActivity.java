package com.example.semivolos_nicolas_listes_patisserie;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private EditText search;
    private String[] monDataset;
    private TypedArray mPrixSet;
    private Drawable[] mDrawables;
    private String[] mDetail;
    private ArrayList<Patisserie> patisseries;
    private final String EXTRA_ITEM = "item";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_SEMIVOLOS_Nicolas_listes_patisserie);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        patisseries = new ArrayList<>();
        init(patisseries);

        recyclerView = (RecyclerView)findViewById(R.id.liste);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new rec_adapter(patisseries,getApplicationContext());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(),"Patisserie choisie : "+(monDataset[position]).toString(),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,ItemContent.class);
                intent.putExtra(EXTRA_ITEM,patisseries.get(position));
                startActivity(intent);
            }
        }));


        search = (EditText)findViewById(R.id.recherche);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filtrer();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void init(ArrayList<Patisserie> patisseries) {
        monDataset = getResources().getStringArray(R.array.nom_patisserie);
        mPrixSet = getResources().obtainTypedArray(R.array.prix_patisserie);
        mDetail = getResources().getStringArray(R.array.detail_patisserie);

        Drawable[] drawables = {
                getDrawable(getResources().getIdentifier("black_forest","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("cookie","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("crepe","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("croissant","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("donut","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("eclair","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("macarons","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("muffin","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("palmier","drawable",getPackageName())),
        };

        for (int i = 0; i < monDataset.length ; i++) {
            Patisserie patisserie = new Patisserie(i,mPrixSet.getFloat(i,0),drawables[i],monDataset[i],mDetail[i]);
            patisseries.add(patisserie);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void filtrer() {
        String editSearch = search.getText().toString().toLowerCase();
        ArrayList<Patisserie> newList = new ArrayList<Patisserie>();
        for (int i = 0; i < patisseries.size(); i++) {
            Patisserie patisserie = patisseries.get(i);
            if (patisserie.getName().toLowerCase().startsWith(editSearch)) {
                newList.add(patisserie);
            }
        }
        recyclerView.setAdapter(null);
        if (newList.size() == 0) {
            Drawable empty = getDrawable(getResources().getIdentifier("vide","drawable",getPackageName()));
            Patisserie error = new Patisserie(0,0,empty,"Aucune référence trouvée","");
            newList.add(error);
        }

        recyclerView.setAdapter(new rec_adapter(newList,getApplicationContext()));
    }
}