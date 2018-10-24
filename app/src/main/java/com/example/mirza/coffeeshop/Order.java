package com.example.mirza.coffeeshop;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Order extends AppCompatActivity {
    EditText table,quan,name,pname;

  Button confirm;
    DatabaseReference data;
    NotificationManager manager;
    NotificationCompat.Builder build;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        table=(EditText)findViewById(R.id.tblno);
        quan=(EditText)findViewById(R.id.quantity);
        name =(EditText)findViewById(R.id.price);
        pname=(EditText)findViewById(R.id.prodname);
        confirm=(Button)findViewById(R.id.CONFIRM);



        data= FirebaseDatabase.getInstance().getReference("order");











     confirm.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

             Intent i= new Intent(Order.this, ViewOrder.class);
             startActivity(i);



                addorder();


build= (NotificationCompat.Builder) new NotificationCompat.Builder(Order.this)
        .setSmallIcon(R.drawable.imag)
        .setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.imag ))
        .setContentTitle("Order Replaced")
        .setContentText("Check the details");
             manager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
             manager.notify(1,build.build());

         }
     });



    }

    private void addorder(){

        String tab= table.getText().toString().trim();
        String qua=quan.getText().toString().trim();
        String nam= name.getText().toString().trim();
        String pnam= pname.getText().toString().trim();

if(!TextUtils.isEmpty(tab)){

    String id =data.push().getKey();
    Order1 or=new Order1(tab, nam, qua, pnam);
data.child(id).setValue(or);
    Toast.makeText(this,"Order Confirmed ", Toast.LENGTH_SHORT).show();
}else {

    Toast.makeText(this," App Crash", Toast.LENGTH_SHORT).show();

}

    }



}
