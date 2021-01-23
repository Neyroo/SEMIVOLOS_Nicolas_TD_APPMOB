package com.example.semivolos_nicolas_formulaire;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result_form extends AppCompatActivity {
    TextView tv_name, tv_first_name, tv_email, tv_checkbox1, tv_checkbox2, tv_checkbox3, tv_rd_btn, tv_info_time;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv_name = findViewById(R.id.text_name);
        tv_first_name = findViewById(R.id.text_first_name);
        tv_email = findViewById(R.id.email_text);
        tv_checkbox1 = findViewById(R.id.checkBox_res);
        tv_checkbox2 = findViewById(R.id.checkBox2_res);
        tv_checkbox3 = findViewById(R.id.checkBox3_res);
        tv_rd_btn = findViewById(R.id.radioButton_res);
        tv_info_time = findViewById(R.id.time_of_play_res);

        Intent resultIntent = getIntent();

        Bundle b = resultIntent.getExtras();

        tv_name.setText("Nom : " + b.getString("EditName"));
        tv_first_name.setText("Prénom : " + b.getString("EditFirstName"));
        tv_email.setText("Email : " + b.getString("TextMail"));
        tv_rd_btn.setText("Sexe : " + b.getString("RadioButton"));
        tv_checkbox1.setText("Langage choisi C++ : " + b.getString("Checkbox_cpp"));
        tv_checkbox2.setText("Langage choisi Java : " + b.getString("Checkbox_java"));
        tv_checkbox3.setText("Langage choisi JavaScript : " + b.getString("Checkbox_js"));
        tv_info_time.setText("Temps de jeu par jour: " + b.getString("TimeOfPlay"));
    }
}