package com.example.semivolos_nicolas_liste_de_sport;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //On associe le view a son instance
        ListView maListe = (ListView) findViewById(R.id.maliste);

        //Objet ressources
        Resources res = getResources();

        //Tableau des chaînes de caractères provenant du tableau défini dans strings.xml
        String[] MesValeurs = res.getStringArray(R.array.montableau);

        //On remplit l’adaptateur
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MesValeurs);

        //On lie les données à la liste
        maListe.setAdapter(adapter);

        Class[] classes = {Basketball.class, Football.class, Handball.class, Natation.class, BmxRace.class};

        //Quand on clique sur un élément de la liste
        maListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //On affiche un toast de l'index de l'objet cliqué ainsi que sa valeur
                Toast.makeText(getApplicationContext(), MesValeurs[position] + ", index = " + position, Toast.LENGTH_SHORT).show();
                //Puis on affichera la page correspondante à l'item cliqué
                if (MesValeurs[position].equals((String) maListe.getItemAtPosition(position))) {
                    Intent intent = new Intent(getApplicationContext(), classes[position]);
                    startActivity(intent);
                }
            }
        });

    }
}