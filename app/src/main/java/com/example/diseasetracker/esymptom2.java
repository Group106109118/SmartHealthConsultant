package com.example.diseasetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class esymptom2 extends AppCompatActivity implements ValueEventListener, View.OnClickListener {
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference=firebaseDatabase.getReference();

    private DatabaseReference firstDatabase2=databaseReference.child("uvesymptom1");
    private DatabaseReference firstDatabase3=databaseReference.child("drysymptom1");
    private DatabaseReference firstDatabase4=databaseReference.child("catsymptom1");
    private DatabaseReference firstDatabase5=databaseReference.child("ectsymptom1");
    private CheckBox s1,s2,s3,s4,s5;
    private Button done1,SignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("esymptom2");
        setContentView(R.layout.activity_esymptom2);
        SignOut=findViewById(R.id.out);
        SignOut.setOnClickListener(this);


        s2=findViewById(R.id.cosymptom2);
        s3=findViewById(R.id.cosymptom3);
        s4=findViewById(R.id.cosymptom4);
        s5=findViewById(R.id.cosymptom5);
        done1=findViewById(R.id.done1);
        done1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(s2.isChecked()){
            if(v.getId()==R.id.done1)
            {

                Intent intent = new Intent(esymptom2.this, esymptom3.class);
                startActivity(intent);

            }}
        if(s3.isChecked()){
            if(v.getId()==R.id.done1)
            {

                Intent intent = new Intent(esymptom2.this, esymptom3.class);
                startActivity(intent);

            }
        }
        if(s4.isChecked()){
            if(v.getId()==R.id.done1)
            {

                Intent intent = new Intent(esymptom2.this, esymptom3.class);
                startActivity(intent);

            }
        }
        if(s5.isChecked()){
            if(v.getId()==R.id.done1)
            {

                Intent intent = new Intent(esymptom2.this, esymptom3.class);
                startActivity(intent);

            }
        }


        else if(v.getId()==R.id.out)
        {
            Intent intent=new Intent(esymptom2.this,LoginActivity.class);
            startActivity(intent);
        }


    }


    public void onDataChange(DataSnapshot dataSnapshot)
    {
        if(dataSnapshot.getValue(String.class)!=null){
            String key=dataSnapshot.getKey();

            if(key.equals("uvesymptom1")) {
                String first = dataSnapshot.getValue(String.class);
                s2.setText(first);
            }
            if(key.equals("drysymptom1")) {
                String first = dataSnapshot.getValue(String.class);
                s3.setText(first);
            }
            if(key.equals("catsymptom1")) {
                String first = dataSnapshot.getValue(String.class);
                s4.setText(first);
            }if(key.equals("ectsymptom1")) {
                String first = dataSnapshot.getValue(String.class);
                s5.setText(first);
            }

        }
    }

    public void onCancelled(DatabaseError databaseError)
    {


    }
    protected void onStart(){
        super.onStart();

        firstDatabase2.addValueEventListener(this);
        firstDatabase3.addValueEventListener(this);
        firstDatabase4.addValueEventListener(this);
        firstDatabase5.addValueEventListener(this);

    }
}
