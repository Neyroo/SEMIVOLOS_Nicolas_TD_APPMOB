package com.example.semivolos_nicolas_listes_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Androidversion> androidList = new ArrayList<Androidversion>();

        initList(androidList);

        AndroidAdapter adapter = new AndroidAdapter(this,R.layout.perso,androidList);
        final ListView list = (ListView) findViewById(R.id.MyList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Androidversion selectedItem = (Androidversion)adapter.getItemAtPosition(position);
                //On affiche dans le log la valeur de l'item cliqué
                Log.v("ListPersonnalisée", "Element selectionné : " + selectedItem.getVersionName());
                //On affiche dans un toast la valeur de l'objet cliqué
                Toast.makeText(getApplicationContext(), "Nom de la version : " + selectedItem.getVersionName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Initialisation de toute les versions d'android
    private void initList(ArrayList<Androidversion> androidList) {
        Androidversion version0 = new Androidversion();
        version0.setVersionName("G1");
        version0.setVersionNumber("1.0");
        androidList.add(version0);
        Androidversion version = new Androidversion();
        version.setVersionName("CupCake");
        version.setVersionNumber("1.5");
        androidList.add(version);
        Androidversion version2 = new Androidversion();
        version2.setVersionName("Eclair");
        version2.setVersionNumber("2.0");
        androidList.add(version2);
        Androidversion version3 = new Androidversion();
        version3.setVersionName("Froyo");
        version3.setVersionNumber("2.2");
        androidList.add(version3);
        Androidversion version4 = new Androidversion();
        version4.setVersionName("Gingerbread");
        version4.setVersionNumber("2.3");
        androidList.add(version4);
        Androidversion version5 = new Androidversion();
        version5.setVersionName("Honeycomb");
        version5.setVersionNumber("3.0");
        androidList.add(version5);
        Androidversion version6 = new Androidversion();
        version6.setVersionName("Ice cream sandwich");
        version6.setVersionNumber("4.0");
        androidList.add(version6);
        Androidversion version7 = new Androidversion();
        version7.setVersionName("Jelly Bean");
        version7.setVersionNumber("4.1");
        androidList.add(version7);
        Androidversion version8 = new Androidversion();
        version8.setVersionName("KitKat");
        version8.setVersionNumber("4.4");
        androidList.add(version8);
        Androidversion version9 = new Androidversion();
        version9.setVersionName("Lollipop");
        version9.setVersionNumber("5.0");
        androidList.add(version9);
        Androidversion version10 = new Androidversion();
        version10.setVersionName("Marshmallow");
        version10.setVersionNumber("6.0");
        androidList.add(version10);
        Androidversion version11 = new Androidversion();
        version11.setVersionName("Nougat");
        version11.setVersionNumber("7.0");
        androidList.add(version11);
        Androidversion version12 = new Androidversion();
        version12.setVersionName("Oreo");
        version12.setVersionNumber("8.0");
        androidList.add(version12);
        Androidversion version13 = new Androidversion();
        version13.setVersionName("Pie");
        version13.setVersionNumber("9.0");
        androidList.add(version13);
        Androidversion version14 = new Androidversion();
        version14.setVersionName("Q");
        version14.setVersionNumber("10.0");
        androidList.add(version14);
    }
}