package com.example.a25ahm.citygo;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

@CoordinatorLayout.DefaultBehavior(FloatingActionButton.Behavior.class)
public class MainActivity extends AppCompatActivity {

    private final int REQ_CODE_SPEECH_INPUT = 100;
    private TextView txtSpeechInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSpeak = (Button) findViewById(R.id.btnSpeak);
        txtSpeechInput = (TextView) findViewById(R.id.textView);

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });


    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ArrayList<String> Museacomments = new ArrayList<>(Arrays.asList("start musea", "musea", "museum"));
       ArrayList<String> Bezienswaardighedencomments = new ArrayList<>(Arrays.asList("Bezienswaardigheid", "bezien", "beziens"));
        ArrayList<String> Restaurantsdisplay = new ArrayList<>(Arrays.asList("Restaurant", "Restaur", "Res"));
        ArrayList<String> cafescomment = new ArrayList<>(Arrays.asList("cafe", "cafes"));
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {


                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtSpeechInput.setText(result.get(0));


                    if (Museacomments.contains(result.get(0))) {
                        but4(findViewById(R.id.button4));
                    }
                    if (Bezienswaardighedencomments.contains(result.get(0))) {
                        But1(findViewById(R.id.button1));
                    }

                    if (Restaurantsdisplay.contains(result.get(0))) {
                        but2(findViewById(R.id.button2));
                    }

                    if (cafescomment.contains(result.get(0))) {
                       but3(findViewById(R.id.button3));
                    }

                }

            }
            break;
        }

    }


    public void But1(View v) {
        if (v.getId() == R.id.button1) {
            Intent b1 = new Intent(MainActivity.this, BezienswaardighedenDisplay.class);
            startActivity(b1);

        }
    }

    public void but2(View v) {
        if (v.getId() == R.id.button2) {
            Intent b2 = new Intent(MainActivity.this, RestaurantsDisplay.class);
            startActivity(b2);

        }
    }

    public void but3(View v) {
        if (v.getId() == R.id.button3) {
            Intent b3 = new Intent(MainActivity.this, CafesDisplay.class);
            startActivity(b3);

        }
    }

    public void but4(View v) {
        if (v.getId() == R.id.button4) {
            Intent b4 = new Intent(MainActivity.this, MuseaDisplay.class);
            startActivity(b4);

        }
    }


}
