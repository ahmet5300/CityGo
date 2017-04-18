package com.example.a25ahm.citygo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  But1 (View v){
        if (v.getId() == R.id.button1)
        {
            Intent b1 = new Intent(MainActivity.this,BezienswaardighedenDisplay.class);
            startActivity(b1);

        }
    }

    public void  but2 (View v){
        if (v.getId() == R.id.button2)
        {
            Intent b2 = new Intent(MainActivity.this,RestaurantsDisplay.class);
            startActivity(b2);

        }
    }

    public void  but3 (View v){
        if (v.getId() == R.id.button3)
        {
            Intent b3 = new Intent(MainActivity.this,CafesDisplay.class);
            startActivity(b3);

        }
    }

    public void  but4 (View v){
        if (v.getId() == R.id.button4)
        {
            Intent b4 = new Intent(MainActivity.this,MuseaDisplay.class);
            startActivity(b4);

        }
    }
}
