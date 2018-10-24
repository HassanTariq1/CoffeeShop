package com.example.mirza.coffeeshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IceTurtle extends AppCompatActivity {
    Button fbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ice_turtle);

        fbtn= (Button) findViewById(R.id.corde);

        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i= new Intent(IceTurtle.this,Order.class);
                startActivity(i);



            }
        });
    }
}
