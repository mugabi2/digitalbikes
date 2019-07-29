package com.stardigitalbikes.samuelhimself.bible1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class GoPremium extends AppCompatActivity {


    Button Bhom,Bmore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_premium);

        Bhom= findViewById(R.id.hm7);
        Bhom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(int1);
            }
        });


        Bmore= findViewById(R.id.more7);
        Bmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 =new Intent(getApplicationContext(),More.class);
                startActivity(int1);
            }
        });

        //  -------------toolbar---------
        Toolbar toolbar =findViewById(R.id.gopremiumtoolbar);
        setSupportActionBar(toolbar);


    }

    //*******************MENU****************8
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.user_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.usermenu:
                Intent int1 =new Intent(getApplicationContext(),Profile.class);
                startActivity(int1);

        }
        return super.onOptionsItemSelected(item);
    }
}
