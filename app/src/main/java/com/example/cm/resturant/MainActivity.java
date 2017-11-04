package com.example.cm.resturant;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "press contact if you need contact with us", Snackbar.LENGTH_LONG)
                        .setAction("Contact", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getApplicationContext(),contact.class);
                                startActivity(intent);

                            }
                        }).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.manger) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(R.layout.manger_page);
            AlertDialog alertDialog  = builder.create();
            alertDialog.show();
            final EditText editText = (EditText) alertDialog.findViewById(R.id.password);
            Button button = (Button) alertDialog.findViewById(R.id.btn_pass);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = editText.getText().toString();
                    if(s.equals("12345"))
                    {
                        Intent i = new Intent(getApplicationContext(),manger.class);
                        startActivity(i);
                    }else
                    {
                        Toast.makeText(MainActivity.this, "The Password is incorrect ", Toast.LENGTH_SHORT).show();
                    }

                }
            });
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

       if (id == R.id.Soup) {
           Intent intent = new Intent(this,soup.class);
            startActivity(intent);
        } else if( id == R.id.Starters)
       {
           Intent intent = new Intent(this,Starters.class);
           startActivity(intent);
       }else if( id == R.id.NachosDip)
       {
           Intent intent = new Intent(this,NachosDip.class);
           startActivity(intent);
       }else if( id == R.id.SideDishes)
       {
           Intent intent = new Intent(this,SideDishes.class);
           startActivity(intent);
       }else if( id == R.id.Salads)
       {
           Intent intent = new Intent(this,Salads.class);
           startActivity(intent);
       }else if( id == R.id.NachosSalads)
       {
           Intent intent = new Intent(this,NachosSalads.class);
           startActivity(intent);
       }else if( id == R.id.Cannelloni)
       {
           Intent intent = new Intent(this,Cannelloni.class);
           startActivity(intent);
       }else if( id == R.id.Lasagne)
       {
           Intent intent = new Intent(this,Lasagne.class);
           startActivity(intent);
       }else if( id == R.id.Pasta)
       {
           Intent intent = new Intent(this,Pasta.class);
           startActivity(intent);
       }else if( id == R.id.ChickenChineseNoodles)
       {
           Intent intent = new Intent(this,ChickenChineseNoodles.class);
           startActivity(intent);
       }else if( id == R.id.Burgers)
       {
           Intent intent = new Intent(this,Burgers.class);
           startActivity(intent);
       }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





}
