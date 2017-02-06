package com.example.rohit.sizebook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Rohit on 2017-02-06.
 */

public class EditOrDelete extends MainActivity{
    private int x;
    private String name;
    private String date;
    private String neck;
    private String bust;
    private String waist;
    private String hip;
    private String chest;
    private String inseam;
    private String comment;

    private EditText name1;
    private EditText date1;
    private EditText neck1;
    private EditText bust1;
    private EditText waist1;
    private EditText hip1;
    private EditText chest1;
    private EditText inseam1;
    private EditText comment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.edit_or_delete);
        //http://stackoverflow.com/questions/7074097/how-to-pass-integer-from-one-activity-to-another
        x = intent.getIntExtra("position",0);
        //http://stackoverflow.com/questions/3920602/get-specific-arraylist-item
        final Person current = MainActivity.peopleList.get(x);
        name = current.getName();
        date = current.getDate();
        neck = current.getNeck();
        bust = current.getBust();
        waist = current.getWaist();
        hip = current.getHip();
        chest = current.getChest();
        inseam = current.getInseam();
        comment = current.getComment();

        name1 = (EditText) findViewById(R.id.name1);
        date1 = (EditText) findViewById(R.id.date1);
        neck1 = (EditText) findViewById(R.id.neck1);
        bust1 = (EditText) findViewById(R.id.bust1);
        waist1 = (EditText) findViewById(R.id.waist1);
        hip1 = (EditText) findViewById(R.id.hip1);
        chest1 = (EditText) findViewById(R.id.chest1);
        inseam1 = (EditText) findViewById(R.id.inseam1);
        comment1 = (EditText) findViewById(R.id.comment1);

        name1.setText(name);
        date1.setText(date);
        neck1.setText(neck);
        bust1.setText(bust);
        waist1.setText(waist);
        hip1.setText(hip);
        chest1.setText(chest);
        inseam1.setText(inseam);
        comment1.setText(comment);

        final Button deleteButton = (Button) findViewById(R.id.DeleteButton1);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.peopleList.remove(x);
                saveInFile();
                MainActivity.adapter.notifyDataSetChanged();
                finish();
            }
        });
        final Button doneButton1 = (Button) findViewById(R.id.DoneButton1);

        doneButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1 = (EditText) findViewById(R.id.name1);
                if (name1.getText().toString().equals("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "Enter a name!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    current.setName(name1.getText().toString());
                    date1 = (EditText) findViewById(R.id.date1);
                    current.setDate(date1.getText().toString());
                    neck1 = (EditText) findViewById(R.id.neck1);
                    current.setNeck(neck1.getText().toString());
                    bust1 = (EditText) findViewById(R.id.bust1);
                    current.setBust(bust1.getText().toString());
                    waist1 = (EditText) findViewById(R.id.waist1);
                    current.setWaist(waist1.getText().toString());
                    hip1 = (EditText) findViewById(R.id.hip1);
                    current.setHip(hip1.getText().toString());
                    chest1 = (EditText) findViewById(R.id.chest1);
                    current.setChest(chest1.getText().toString());
                    inseam1 = (EditText) findViewById(R.id.inseam1);
                    current.setInseam(inseam1.getText().toString());
                    comment1 = (EditText) findViewById(R.id.comment1);
                    current.setComment(comment1.getText().toString());
                    MainActivity.peopleList.set(x,current);
                    saveInFile();
                    MainActivity.adapter.notifyDataSetChanged();
                    finish();

                }
            }


    });
}

}
