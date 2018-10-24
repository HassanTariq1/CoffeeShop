package com.example.mirza.coffeeshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CoffeeTypes extends AppCompatActivity {
    ListView list;
    int[] coffee= new int[]{R.drawable.frap, R.drawable.turtle,R.drawable.turkish , R.drawable.kopi, R.drawable.ice,R.drawable.capicino, R.drawable.vream, };

    String [] names= new String[]{"Frap","Turtle Machiato","Turkish Coffee","Kopi Turbik","Ice Turtle Machiato", "Cappucinno","Cold Coffee"  };

    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_types);


        adapter= new CustomAdapter(getApplicationContext(),coffee, names);
         list=(ListView)findViewById(R.id.listview);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==0) {

                    Intent in= new Intent(CoffeeTypes.this,Frap.class);
                    startActivityForResult(in,0);

                    Toast.makeText(getApplicationContext(), names[i] + "", Toast.LENGTH_SHORT).show();
                }

                if(i==1){
                    Intent in= new Intent(CoffeeTypes.this,TurtleMachia.class);
                    startActivityForResult(in,0);

                    Toast.makeText(getApplicationContext(), names[i] + "", Toast.LENGTH_SHORT).show();

                }
                if(i==2){
                    Intent in= new Intent(CoffeeTypes.this,Turkish.class);
                    startActivityForResult(in,0);

                    Toast.makeText(getApplicationContext(), names[i] + "", Toast.LENGTH_SHORT).show();

                }
                if(i==3){
                    Intent in= new Intent(CoffeeTypes.this,Kopiturbik.class);
                    startActivityForResult(in,0);

                    Toast.makeText(getApplicationContext(), names[i] + "", Toast.LENGTH_SHORT).show();

                }
                if(i==4){
                    Intent in= new Intent(CoffeeTypes.this,IceTurtle.class);
                    startActivityForResult(in,0);

                    Toast.makeText(getApplicationContext(), names[i] + "", Toast.LENGTH_SHORT).show();

                }
                if(i==5){
                    Intent in= new Intent(CoffeeTypes.this,Capucinno.class);
                    startActivityForResult(in,0);

                    Toast.makeText(getApplicationContext(), names[i] + "", Toast.LENGTH_SHORT).show();

                }
                if(i==6) {
                    Intent in = new Intent(CoffeeTypes.this, ColdCoffee.class);
                    startActivityForResult(in, 0);

                    Toast.makeText(getApplicationContext(), names[i] + "", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
}
