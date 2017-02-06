package com.example.rohit.sizebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by Rohit on 2017-02-05.
 * This activity provides the user with fields to input their values into
 * The fields are restricted to certain parameters
 */

public class CreateActivity extends MainActivity {
    /**
     * Extends the main activity class to directly use the save and load from file methods
     * Certain variables were made public for easy access and to write directly to filename.dat
     *
     */

    private ArrayList<Person> peopleList;
    private static final String FILENAME = "file.sav";
    private ArrayAdapter<Person> adapter;
    private EditText date;
    private EditText neck;
    private EditText bust;
    private EditText waist;
    private EditText hip;
    private EditText chest;
    private EditText inseam;
    private EditText comment;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_main);
        Intent intent = getIntent();
        final Button doneButton = (Button) findViewById(R.id.DoneButton);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ed = (EditText) findViewById(R.id.name);
                String name = ed.getText().toString();
                if (name.equals("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "Enter a name!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    /*
                    * Else create a new person and populate the tables. I restrict user input
                    * through the xml files
                    * */
                    Person p = new Person(name);
                    p.setName(name);
                    date = (EditText) findViewById(R.id.date);
                    p.setDate(date.getText().toString());
                    neck = (EditText) findViewById(R.id.neck);
                    p.setNeck((neck.getText().toString()));
                    bust = (EditText) findViewById(R.id.bust);
                    p.setBust((bust.getText().toString()));
                    chest = (EditText) findViewById(R.id.chest);
                    p.setChest((chest.getText().toString()));
                    waist = (EditText) findViewById(R.id.waist);
                    p.setWaist((waist.getText().toString()));
                    hip = (EditText) findViewById(R.id.hip);
                    p.setHip((hip.getText().toString()));
                    inseam = (EditText) findViewById(R.id.inseam);
                    p.setInseam((inseam.getText().toString()));
                    comment = (EditText) findViewById(R.id.comment);
                    p.setComment(comment.getText().toString());
                    MainActivity.peopleList.add(p);
                    saveInFile();
                    finish();
                }
            }
        });

    }
}


