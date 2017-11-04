package com.example.cm.resturant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Iterator;

public class manger extends AppCompatActivity {
    DatabaseReference root =   root = FirebaseDatabase.getInstance().getReference().getRoot();
    ArrayList<data> data;
    Adapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manger);
        data = new ArrayList<>();
       // data.add(new data("wwww","ddddd","ffff","rrrr","rrrffdd"));
        listView = (ListView) findViewById(R.id.lv_of_showorders);
        adapter = new Adapter(this,R.layout.showorders,data);
        listView.setAdapter(adapter);
        root.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Add(dataSnapshot);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Add(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private String food, price,name,phone,address;

    private void Add(DataSnapshot dataSnapshot) {

        Iterator i = dataSnapshot.getChildren().iterator();
        while (i.hasNext()) {

            food = (String) ((DataSnapshot) i.next()).getValue();
            price = (String) ((DataSnapshot) i.next()).getValue();
            name = (String) ((DataSnapshot) i.next()).getValue();
            phone = (String) ((DataSnapshot) i.next()).getValue();
            address = (String) ((DataSnapshot) i.next()).getValue();

            data.add(new data(food,price,name,phone,address));
            adapter.notifyDataSetChanged();
            listView.setSelection(data.size());
        }


    }
}
