package com.stardigitalbikes.samuelhimself.bible1;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;

public class Credit extends AppCompatActivity {


    Button Bhom,Bmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        Context context=this;
//        ProgressBar mProgressBar=findViewById(R.id.castor);



//        mProgressBar.setSmoothProgressDrawableBackgroundDrawable(
//                SmoothProgressBarUtils.generateDrawableWithColors(
//                        getResources().getIntArray(R.array.pocket_background_colors),
//                        ((SmoothProgressDrawable) mProgressBar.getIndeterminateDrawable()).getStrokeWidth()));

//        mProgressBar.setIndeterminateDrawable(new SmoothProgressDrawable.Builder(context)
//                .color(0xff0000)
//                .interpolator(new DecelerateInterpolator())
//                .sectionsCount(4)
//                .separatorLength(8)         //You should use Resources#getDimensionPixelSize
//                .strokeWidth(8f)            //You should use Resources#getDimension
//                .speed(2f)                 //2 times faster
//                .progressiveStartSpeed(2)
//                .progressiveStopSpeed(3.4f)
//                .reversed(false)
//                .mirrorMode(false)
//                .progressiveStart(true)
//                .progressiveStopEndedListener(mListener) //called when the stop animation is over
//                .build());

//        mProgressBar.progressiveStart();

        Toolbar toolbar =findViewById(R.id.credittoolbar);
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
