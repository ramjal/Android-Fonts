package com.example.fonts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner fontSpinner, sizeSpinner;
    private TextView txtHello, txtHello2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHello = findViewById(R.id.txtHello);
        txtHello2 = findViewById(R.id.txtHello2);
        fontSpinner = findViewById(R.id.spinnerFont);
        sizeSpinner = findViewById(R.id.spinnerSize);

        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, sizeSpinner.getSelectedItem() + " Selected", Toast.LENGTH_SHORT).show();
                txtHello.setTextSize(Float.parseFloat(sizeSpinner.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        fontSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, fontSpinner.getSelectedItem() + " Selected", Toast.LENGTH_SHORT).show();
                switch (fontSpinner.getSelectedItem().toString()) {
                    case "Bold":
                        txtHello2.setTypeface(txtHello2.getTypeface(), Typeface.BOLD);
                        break;
                    case "Italic":
                        txtHello2.setTypeface(txtHello2.getTypeface(), Typeface.ITALIC);
                        break;
                    case "Bold Italic":
                        txtHello2.setTypeface(txtHello2.getTypeface(), Typeface.BOLD_ITALIC);
                        break;
                    default:
                        txtHello2.setTypeface(Typeface.create(txtHello2.getTypeface(), Typeface.NORMAL));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}