package com.example.cm.resturant;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    public void call(View view) {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:01200070321"));
        startActivity(intent);
    }

    public void sms(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:01200070321"));
        startActivity(intent);
    }

    public void mail(View view) {
        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL,"engmohamedanwer321@gmail.com");
            startActivity(intent);
        }catch (Exception e)
        {
            Toast.makeText(getBaseContext(),"This Device Not Support Mail Services",Toast.LENGTH_LONG).show();
        }

    }

    public void web(View view) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.facebook.com/mohamed.anwer.56"));
        startActivity(intent);
    }
}
