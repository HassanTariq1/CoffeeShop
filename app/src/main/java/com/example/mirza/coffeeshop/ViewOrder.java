package com.example.mirza.coffeeshop;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;



public class ViewOrder extends AppCompatActivity {



    ListView list;
    DatabaseReference data;
    List<Order1> orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);


        data = FirebaseDatabase.getInstance().getReference("order");

        orderList = new ArrayList<>();


        list = (ListView) findViewById(R.id.listorder);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {




updatedata();






            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();

        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot ordersnapo: dataSnapshot.getChildren()) {


                    Order1 order= ordersnapo.getValue(Order1.class);

                    orderList.add(order);

                }


                OrderList adap= new OrderList(ViewOrder.this, orderList);
                list.setAdapter(adap);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }



        private void updatedata() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layout = getLayoutInflater();

        final View dialogview = layout.inflate(R.layout.activity_update_order, null);


        builder.setView(dialogview);

        final Button confirme = (Button) dialogview.findViewById(R.id.delbtn);


        builder.setTitle("Delete Order   ");

        final AlertDialog alert = builder.create();
        alert.show();

        confirme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

deleteOrder();

                alert.dismiss();

            }
        });


    }

    private void deleteOrder() {
        DatabaseReference data= FirebaseDatabase.getInstance().getReference("order");

        data.removeValue();
        Toast.makeText(this," Order Delete ",Toast.LENGTH_SHORT).show();



    }


}
