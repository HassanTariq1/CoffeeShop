package com.example.mirza.coffeeshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ForInfo extends AppCompatActivity {

    EditText natxt, tbtxt;
    Button btnin;
DatabaseReference datab;
ListView listitem;

List<ForInfo1> infolist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_info);

datab= FirebaseDatabase.getInstance().getReference("Table no");



        natxt= (EditText) findViewById(R.id.natxt);

        tbtxt=(EditText) findViewById(R.id.tbtxt);

        btnin= (Button) findViewById(R.id.btnin);
infolist= new ArrayList<>();
listitem= (ListView)findViewById(R.id.lsititm);
        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


addInfo();



            }
        });




listitem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


        Intent ij= new Intent(ForInfo.this, CoffeeTypes.class);

                  startActivityForResult(ij, 0);
    }
});







    }



    @Override
    protected void onStart() {

        super.onStart();

        datab.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot info : dataSnapshot.getChildren()){
infolist.clear();
                    ForInfo1 info1= info.getValue(ForInfo1.class);

infolist.add(info1);

                }
                InfoList adap= new InfoList(ForInfo.this, infolist);
                listitem.setAdapter(adap);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private  void addInfo(){
        String name= natxt.getText().toString().trim();
        String tblno= tbtxt.getText().toString().trim();

if(!TextUtils.isEmpty(tblno)){

String id=datab.push().getKey();

    ForInfo1 in= new ForInfo1(name, tblno);
    datab.child(id).setValue(in);

    Toast.makeText(this," to enter",Toast.LENGTH_SHORT).show();


}else{

    Toast.makeText(this,"need to enter",Toast.LENGTH_SHORT).show();
}

    }

}
