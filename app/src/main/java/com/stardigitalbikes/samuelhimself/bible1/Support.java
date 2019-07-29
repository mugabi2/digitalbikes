package com.stardigitalbikes.samuelhimself.bible1;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

public class Support extends AppCompatActivity {

    Button Bhom,Bmore,Bcall,Bmail,Bsafe;
    BottomSheetBehavior mBottomSheetBehaviour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);


        Bcall= findViewById(R.id.callhelp);
        Bcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 =new Intent(Intent.ACTION_DIAL);
                int1.setData(Uri.parse("tel:0704975898"));
                startActivity(int1);
                Log.d("DIAL","CLICKED CALLING-------------");
            }
        });

        //        ------------------------------------
////        BOTTOM SHEET PRICE

//        View nestedScrollView=(View)findViewById(R.id.bottom_sheetid);
//        mBottomSheetBehaviour=BottomSheetBehavior.from(nestedScrollView);



//send mail*******************************
        Bhom=findViewById(R.id.sendemail);
        Bhom.setText(Html.fromHtml("<a href=\"mailto:samuelmugabi2@gmail.com\">Send Feedback</a>"));
        Bhom.setMovementMethod(LinkMovementMethod.getInstance());

        //  -------------toolbar---------
        Toolbar toolbar =findViewById(R.id.supporttoolbar);
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
                finish();

        }
        return super.onOptionsItemSelected(item);
    }


}
