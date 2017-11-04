package com.example.cm.resturant;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static com.example.cm.resturant.R.layout.mydata;

public class NachosDip extends AppCompatActivity {
    CheckBox c1,c2,c3,c4,c5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nachos_dip);
        c1 = (CheckBox) findViewById(R.id.box11);
        c2 = (CheckBox) findViewById(R.id.box12);
        c3 = (CheckBox) findViewById(R.id.box13);
        c4 = (CheckBox) findViewById(R.id.box14);
        c5 = (CheckBox) findViewById(R.id.box15);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.order,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        if(id==R.id.order)
        {
            add();
        }

        return super.onOptionsItemSelected(item);
    }
    String s2;
    double d2;
    public void add() {
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<Double> arr2 = new ArrayList<>();
        String s="";
        double d=0.0;

        if(c1.isChecked())
        {
            arr2.add(34.99);
            arr.add("Spectra Dip / ");


        }else
        {
            arr.remove("Spectra Dip / ");
            arr2.remove(34.99);

        }

        if(c2.isChecked())
        {
            arr.add("Calamari Dip / ");
            arr2.add(49.99);

        }else
        {
            arr.remove("Calamari Dip / ");
            arr2.remove(49.99);

        }

        if(c3.isChecked())
        {
            arr.add("Chicken Dip / ");
            arr2.add(48.99);
        }else
        {
            arr.remove("Chicken Dip / ");
            arr2.remove(48.99);

        }

        if(c4.isChecked())
        {
            arr2.add(47.99);
            arr.add("Chicken Red Sauce Dip / ");

        }else
        {
            arr.remove("Chicken Red Sauce Dip / ");
            arr2.remove(47.99);
        }

        if(c5.isChecked())
        {
            arr.add("Beef Dip / ");
            arr2.add(49.80);
        }else
        {
            arr.remove("Beef Dip / ");
            arr2.remove(49.80);

        }

        for (int i = 0; i <arr.size() ; i++) {
            s+=arr.get(i);
        }
        s2=s;

        for (int i = 0; i <arr2.size() ; i++) {
            d=d+Double.valueOf(arr2.get(i));
        }
        d2=d;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("the meals and price");
        builder.setMessage("meals are { " + s +" }\n"+"the price is { "+String.valueOf(d)+" }");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void order_request(View view) {
        final String z1,z2;
        final AlertDialog alertDialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(mydata);
        alertDialog = builder.create();
        alertDialog.show();
        final EditText name= (EditText) alertDialog.findViewById(R.id.tv1);
        final EditText phone=(EditText) alertDialog.findViewById(R.id.tv2);
        final EditText address=(EditText) alertDialog.findViewById(R.id.tv3);
        TextView textView1 = (TextView) alertDialog.findViewById(R.id.tvfoods) ;
        TextView textView2 = (TextView) alertDialog.findViewById(R.id.tvprice) ;
        Button button = (Button) alertDialog.findViewById(R.id.but) ;
        textView1.setText(s2);
        textView2.setText(String.valueOf(d2));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String   z1 = name.getText().toString();
                String z2 = phone.getText().toString();
                String z3 = address.getText().toString();
                if(!z1.equals("") && !z2.equals("") && !z3.equals("") && !s2.equals("") && !String.valueOf(d2).equals(""))
                {
                    send(s2,String.valueOf(d2),z1,z2,z3);
                    Toast.makeText(getBaseContext(), "Successful Operation ", Toast.LENGTH_LONG).show();
                }
                alertDialog.dismiss();

            }
        });

    }

    String temp_key,name;
    public void send(String food,String price,String name,String phone,String address) {
        DatabaseReference root =   root = FirebaseDatabase.getInstance().getReference().getRoot();
        Map<String, Object> map = new HashMap<String, Object>();
        temp_key = root.push().getKey();
        root.updateChildren(map);
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int min = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        DatabaseReference message_root = root.child(temp_key);
        Map<String, Object> map2 = new HashMap<String, Object>();

        map2.put("a_food",food);
        map2.put("b_price", price);
        map2.put("c_name", name);
        map2.put("d_phone", phone);
        map2.put("e_address", address);

        message_root.updateChildren(map2);
    }
}
