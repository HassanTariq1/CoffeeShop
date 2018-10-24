package com.example.mirza.coffeeshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TurtleMachia extends AppCompatActivity {
    Button fbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turtle_machia);


        fbtn= (Button) findViewById(R.id.corde);

        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i= new Intent(TurtleMachia.this,Order.class);
                startActivity(i);



            }
        });
    }
}
