package com.example.g6vqu4.a04_layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    TextView textView2, textView3, textView4, textView5;
    CheckBox checkBox;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Start of the toogle button part
        toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        textView2 = (TextView)findViewById(R.id.textView2);
        toggleButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                if(toggleButton.isChecked()){
                    textView2.setText("Be");
                }else{
                    textView2.setText("Ki");
                }
            }
        });
        //End of the toogle button part

        //Start of the checkbox part
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        textView3 = (TextView)findViewById(R.id.textView3);
        checkBox.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                if(checkBox.isChecked()){
                    textView3.setText("Bepipálva");
                }else{
                    textView3.setText("Kipipálva");
                }
            }
        });
        //End of the checkbox part

        textView4 = (TextView)findViewById(R.id.textView4);
        //Start of the seek bar part
        seekBar = (SeekBar) findViewById(R.id.seekBar2);
        textView5 = (TextView)findViewById(R.id.textView5);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                textView5.setText(progress + "/" + seekBar.getMax());
                Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView5.setText(progress + "/" + seekBar.getMax());
                Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        });
        //End of the seek bar part

    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked){
                    textView4.setText("radioButton1");
                }
                break;
            case R.id.radioButton2:
                if (checked){
                    textView4.setText("radioButton2");
                }
                break;
            case R.id.radioButton3:
                if (checked){
                    textView4.setText("radioButton3");
                }
                break;
        }
    }

    public void kovetkezo(View view) {
        Intent startIntent = new Intent(getApplicationContext(),KovetkezoActivity.class);
        startActivity(startIntent);
    }

}
