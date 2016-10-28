package com.example.g6vqu4.a04_layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class KovetkezoActivity extends AppCompatActivity {

    TextView textView, textView6;
    RatingBar ratingBar;
    EditText editText;
    ListView listView;
    ArrayAdapter<String> listViewAdapter;
    ArrayList<String> listItems=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kovetkezo);

        //Start of the spinner part
        textView = (TextView)findViewById(R.id.textView);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View v,
                                       int pos, long id) {
                // An item was selected. You can retrieve the selected item using
                // parent.getItemAtPosition(pos)
                textView.setText(parent.getItemAtPosition(pos).toString());
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        } );
        //End of the spinner part

        //Start of the rating bar
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        textView6 = (TextView) findViewById(R.id.textView6);

        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {

                textView6.setText(String.valueOf(rating));

            }
        });
        //End of the rating bar

        editText = (EditText)findViewById(R.id.editText);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
        listView = (ListView)findViewById(R.id.listView);
        listViewAdapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                listItems.remove(position);
                listViewAdapter.notifyDataSetChanged();
            }
        });
        /*listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    public void vissza(View view) {
        Intent startIntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(startIntent);
    }

    public void addToList(View view) {
        String addString = editText.getText().toString();
        listItems.add(addString);
        listViewAdapter.notifyDataSetChanged();
        editText.setText("");

    }
}



/*
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class KovetkezoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kovetkezo);
    }
}
*/