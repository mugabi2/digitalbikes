package com.stardigitalbikes.samuelhimself.bible1;

import android.content.Intent;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Instructions extends AppCompatActivity {


    Button Bhom,Bmore,Bsafe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

//        STATUS BAR
        if(Build.VERSION.SDK_INT >=21){
            Window window=this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.darkdarkTurq));
        }

//
//        Bhom= findViewById(R.id.hm9);
//        Bhom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent int1 =new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(int1);
//                finish();
//            }
//        });
//
//
//        Bmore= findViewById(R.id.more9);
//        Bmore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent int1 =new Intent(getApplicationContext(),More.class);
//                startActivity(int1);
//                finish();
//            }
//        });
//        Bsafe= findViewById(R.id.safety3);
//        Bsafe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent int1 =new Intent(getApplicationContext(),SafetyTips.class);
//                startActivity(int1);
//                finish();
//            }
//        });
        //  -------------toolbar---------
        Toolbar toolbar =findViewById(R.id.insttoolbar);
        setSupportActionBar(toolbar);


        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


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
                finish();

        }
        return super.onOptionsItemSelected(item);
    }
}
