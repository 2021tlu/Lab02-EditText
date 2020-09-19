package com.luthomas.lab02_edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Three upper components: edit text (takes name), button, and text view
    // Pressing button gets text from edit text and puts into text view
    EditText nField;
    Button nButton;
    TextView nMessage;

    // Two bottom components: button and text view
    // Pressing button cycles through string array of planets, which is shown on the text field
    Button pButton;
    TextView pMessage;
    Resources res;
    String[] planets;
    int pIndex = 0; // for cycling

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set upper components
        nField = findViewById(R.id.nameField);
        nButton = findViewById(R.id.nameButton);
        nMessage = findViewById(R.id.nameMessage);

        // Set lower components
        pButton = findViewById(R.id.planetButton);
        pMessage = findViewById(R.id.planetMessage);
        res = getResources();
        planets = res.getStringArray(R.array.planets);

        // Button Listeners
        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nMessage.setText("Nice to meet you, " + nField.getText().toString() + "!");
            }
        });
        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pMessage.setText(planets[pIndex]);
                pIndex++;
                if(pIndex==planets.length){
                    pIndex = 0;
                }
            }
        });
    }
}