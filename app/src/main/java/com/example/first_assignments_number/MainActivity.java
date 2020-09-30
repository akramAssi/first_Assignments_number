package com.example.first_assignments_number;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    private TextView number;
    private LinearLayout palindrome_background;
    private LinearLayout prime_background;
    private LinearLayout twisted_background;
    private ImageView palindrome_view;
    private ImageView prime_view;
    private ImageView twisted_view;
    private RelativeLayout abouts;


    private AnimatedVectorDrawable versionGreaterThen_23;
    private AnimatedVectorDrawableCompat versionLessThan_24;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        palindrome_background = findViewById(R.id.palindrome_background);
        prime_background = findViewById(R.id.prime_background);
        twisted_background = findViewById(R.id.twisted_background);
        palindrome_view = findViewById(R.id.palindrome_view);
        prime_view = findViewById(R.id.prime_view);
        twisted_view = findViewById(R.id.twisted_view);
        number = (EditText)findViewById(R.id.number);
        abouts = findViewById(R.id.about);


        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(number.getText().toString().isEmpty())
                {
                    palindrome_background.setBackgroundResource(0);
                    prime_background.setBackgroundResource(0);
                    twisted_background.setBackgroundResource(0);
                    palindrome_view.setImageResource(R.drawable.no_value);
                    prime_view.setImageResource(R.drawable.no_value);
                    twisted_view.setImageResource(R.drawable.no_value);
                } else  {


                    twisted_background.setBackgroundResource(R.drawable.correct_circle);

                    twisted_view.setImageResource(R.drawable.avd_done);

                    if(isPalindrome(number.getText().toString()))
                    {
                        palindrome_background.setBackgroundResource(R.drawable.correct_circle);
                        palindrome_view.setImageResource(R.drawable.avd_done);
                    }
                    else
                    {
                        palindrome_background.setBackgroundResource(R.drawable.incorrect_circle);
                        palindrome_view.setImageResource(R.drawable.avd_false);
                    }
                    startAnimated(palindrome_view);

                    if(isPrime(number.getText().toString()))
                    {
                        prime_background.setBackgroundResource(R.drawable.correct_circle);
                        prime_view.setImageResource(R.drawable.avd_done);
                    }
                    else
                    {
                        prime_background.setBackgroundResource(R.drawable.incorrect_circle);
                        prime_view.setImageResource(R.drawable.avd_false);
                    }
                    startAnimated(prime_view);

                    if(isTwisted(number.getText().toString()))
                    {
                        twisted_background.setBackgroundResource(R.drawable.correct_circle);
                        twisted_view.setImageResource(R.drawable.avd_done);
                    }
                    else
                    {
                        twisted_background.setBackgroundResource(R.drawable.incorrect_circle);
                        twisted_view.setImageResource(R.drawable.avd_false);
                    }
                    startAnimated(twisted_view);


                }
            }
        });
        abouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this , about.class);
                startActivity(intent);
            }
        });

        ActionBar bar =getSupportActionBar();
//        bar.setHomeButtonEnabled(true);
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setHomeAsUpIndicator(R.drawable.ic_home);




    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    private void startAnimated(ImageView view)
    {
        Drawable ddo = view.getDrawable();
        if (ddo instanceof AnimatedVectorDrawableCompat) {
            versionLessThan_24 = (AnimatedVectorDrawableCompat) ddo;
            versionLessThan_24.start();
        } else if (ddo instanceof AnimatedVectorDrawable) {
            versionGreaterThen_23 = (AnimatedVectorDrawable) ddo;
            versionGreaterThen_23.start();
        }///end else if
    }

    private boolean isPalindrome(String string)
    {
        StringBuilder sb=new StringBuilder(string);
        sb.reverse();

        return string.equals(sb.toString());
    }

    private boolean isPrime(String string)
    {
        long num = Long.parseLong(string);
        if (num < 2)
            return false;


        for(int i=2 ; i < num ; i++){

            if ( num % i == 0 )
                return false;

        }
            return true;
    }

    private boolean isTwisted(String string)
    {
        StringBuilder sb=new StringBuilder(string);
        sb.reverse();
        return (isPrime(sb.toString()) && isPrime(string));
    }



}