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
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This is the first screen the user sees when they log in. By default the user can see a list of views representing
 * the name of a person. Upon clicking on the name button, the system calls a new activity showing the attributes
 * that the user has entered for that person. The "file.sav" allows us to save the application state even when the
 * emulator is exited. <br>
 *     <p>
 *         @see #loadFromFile()
 *         @see #saveInFile()
 *     </p>
 *
 *  @version 1.0.1
 *  @author Rohit Vinnakota
 *  @since 1.0.0
 */
public class MainActivity extends Activity {

    public static ArrayList<Person> peopleList; //arraylist of people objects
    public static final String FILENAME = "file.sav";
    public static ArrayAdapter<Person> adapter; //adapter
    public ListView oldPeople; //reference to listview object(list of people seen on screen
    private int position;
    public TextView count1;

    @Override
    /**
     * Creates an oldPeople Listview to populate the home screen and a TextView object
     * that changes the layout whenever a new object is added/deleted
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFromFile();
        oldPeople = (ListView) findViewById(R.id.oldPeople);
        int size = peopleList.size();
        TextView count1 = (TextView) findViewById(R.id.id01);
        count1.setText("Number of people: "+ size);
        adapter = new ArrayAdapter<Person>(this, R.layout.list_item, peopleList);
        oldPeople.setAdapter(adapter);
        oldPeople.setOnItemClickListener(
                // https://www.youtube.com/watch?v=A-_hKWMA7mk
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent edit = new Intent(getApplicationContext(), EditOrDelete.class);
                        edit.putExtra("position",position);
                        startActivity(edit);
                    }
                }

        );

    }

    @Override
    protected void onStart(){
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<Person>(this,R.layout.list_item,peopleList);
        oldPeople.setAdapter(adapter);
    }

    //http://stackoverflow.com/questions/3053761/reload-activity-in-android
    protected void onResume() {
        super.onResume();
        this.onCreate(null);
    }

    public void createNew(View view){
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }


    public void loadFromFile(){
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            // Taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            // 2017-01-26 17:53:59
            peopleList = gson.fromJson(in, new TypeToken<ArrayList<Person>>() {
            }.getType());
            fis.close();
        } catch (FileNotFoundException e) {
            peopleList = new ArrayList<Person>();
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }
    public void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();

            gson.toJson(peopleList, out);

            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
