package com.example.mirza.coffeeshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Capucinno extends AppCompatActivity {

    Button fbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capucinno);


        fbtn= (Button) findViewById(R.id.corde);

        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i= new Intent(Capucinno.this,Order.class);
                startActivity(i);



            }
        });
    }
}
