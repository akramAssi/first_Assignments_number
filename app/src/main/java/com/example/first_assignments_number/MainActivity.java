package com.example.first_assignments_number;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView done;
    AnimatedVectorDrawable d1;
    AnimatedVectorDrawableCompat d2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        done = findViewById(R.id.cor1);
        Drawable ddo = done.getDrawable();

        if (ddo instanceof AnimatedVectorDrawableCompat) {
            d2 = (AnimatedVectorDrawableCompat) ddo;
            d2.start();
            System.out.println("d2");
        } else if (ddo instanceof AnimatedVectorDrawable) {
            d1 = (AnimatedVectorDrawable) ddo;
            d1.start();
            System.out.println("d1");

        }
    }

}