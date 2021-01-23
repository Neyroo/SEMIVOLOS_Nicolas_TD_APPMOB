package com.example.semivolos_nicolas_formulaire;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    EditText edit_name, edit_first_name, edit_time_play;
    TextView date_text, text_email, info_time;
    CheckBox cpp, java, js;
    RadioGroup radioGroup;
    RadioButton femme, homme, selectButtonRadio;
    Button btn_reset, btn_submit, btn_home;
    String email_gen, name, first_name = "";
    int number_play_time = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assignation références

        // EditText
        edit_name = findViewById(R.id.edit_name);
        edit_name.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        edit_first_name = findViewById(R.id.edit_first_name);
        edit_first_name.setInputType(Keyboard.KEYCODE_SHIFT);
        edit_time_play = findViewById(R.id.nb_hour);

        // TextView
        date_text = findViewById(R.id.date_text);
        text_email = findViewById(R.id.text_email);
        info_time = findViewById(R.id.info_time);

        // CheckBox
        cpp = findViewById(R.id.checkBox);
        java = findViewById(R.id.checkBox2);
        js = findViewById(R.id.checkBox3);

        // RadioGroup
        radioGroup = findViewById(R.id.radioGroup);

        // RadioButton
        femme = findViewById(R.id.radioButtonF);
        femme.toggle();
        homme = findViewById(R.id.radioButtonH);

        // Button
        btn_reset = findViewById(R.id.button_reset);
        btn_submit = findViewById(R.id.button_submit);
        btn_home = findViewById(R.id.button_home);

        setEdit_name(edit_name);
        setEdit_first_name(edit_first_name);
        setRadioButton(name);
        setEdit_time_play(edit_time_play);

        Intent intentToHome = new Intent(getApplicationContext(), Home.class);

        setBtn_reset(btn_reset);
        setBtn_submit(btn_submit);
        setBtn_home(btn_home, intentToHome);


        Date today = Calendar.getInstance().getTime();//getting date
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy"); // formating according to my need
        String date = formatter.format(today);
        date_text.setText(date);
    }

    public void setEdit_name(EditText edit_name) {
        edit_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                name = s.toString();
                setEmail_gen(email_gen);
            }
        });
    }

    public void setEdit_first_name(EditText edit_first_name) {
        edit_first_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                first_name = s.toString();
                setEmail_gen(email_gen);
            }
        });
    }

    public void setRadioButton(String name) {
        int selectId = radioGroup.getCheckedRadioButtonId();
        selectButtonRadio = (RadioButton) findViewById(selectId);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectButtonRadio = (RadioButton) findViewById(checkedId);
                Toast.makeText(getApplicationContext(), "Bonjour " + String.valueOf
                        (selectButtonRadio.getText().toString()) + edit_name.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setEdit_time_play(EditText edit_time_play) {
        edit_time_play.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @SuppressLint("SetTextI18n")
            @Override
            public void afterTextChanged(Editable s) {
                number_play_time = Integer.parseInt(s.toString());
                if (number_play_time < 2) {
                    info_time.setText("Votre temps de jeu est correct : " + String.valueOf(number_play_time * 7) + "h par semaine");
                    info_time.setTextColor(getColor(R.color.dark_green));
                    Toast.makeText(getApplicationContext(), info_time.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                if (number_play_time == 2) {
                    info_time.setText("Faites attention à votre temps de jeu : " + String.valueOf(number_play_time * 7) + "h par semaine");
                    info_time.setTextColor(getColor(R.color.orange));
                }
                if (number_play_time > 2) {
                    info_time.setText("Vous êtes addict : " + String.valueOf(number_play_time * 7) + "h par semaine");
                    info_time.setTextColor(getColor(R.color.red));
                }
            }
        });
    }

    public void setEmail_gen(String email_gen) {
        email_gen = edit_name.getText().toString().toLowerCase() + "." + edit_first_name.getText().toString().toLowerCase() + "@ludus-academie.com";
        text_email.setText(email_gen);
    }

    public void setBtn_submit(Button btn_submit) {
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Envoyer les résultats sur la prochaine activité
                Intent resultIntent = new Intent(MainActivity.this, Result_form.class);

                Bundle b = new Bundle();

                b.putString("EditName", edit_name.getText().toString());
                b.putString("EditFirstName", edit_first_name.getText().toString());
                b.putString("TextMail", text_email.getText().toString());
                b.putString("RadioButton", selectButtonRadio.getText().toString());
                b.putString("Checkbox_cpp", String.valueOf(cpp.isChecked()));
                b.putString("Checkbox_java", String.valueOf(java.isChecked()));
                b.putString("Checkbox_js", String.valueOf(js.isChecked()));
                b.putString("TimeOfPlay", String.valueOf(number_play_time));


                resultIntent.putExtras(b);
                startActivity(resultIntent);

            }
        });
    }

    public void setBtn_reset(Button btn_reset) {
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_name.setText("");
                edit_first_name.setText("");
                if (cpp.isChecked()) {
                    cpp.toggle();
                }
                if (java.isChecked()) {
                    java.toggle();
                }
                if (js.isChecked()) {
                    js.toggle();
                }
                edit_time_play.setText("0");
            }
        });
    }

    public void setBtn_home(Button btn_home, Intent intentToHome) {
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentToHome);
            }
        });
    }
}