package com.stardigitalbikes.samuelhimself.bible1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Events extends AppCompatActivity {

    Button Bhom, Bmore,Bsafe;

    ImageView imagev;
    int max,connection=1;
    static JSONObject jObjc = null;
    String allupdates;
    String[] imagenamesarray;
    BottomSheetBehavior mBottomSheetBehavior,mbottomSheetBehavior1;
    Button mButton1;

    ProgressBar pb1,pb2,pb3,pb4,pb5,pb6,pb7,pb8,pb9,pb10;
    CardView cd1,cd2,cd3,cd4,cd5,cd6,cd7,cd8,cd9,cd10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

//        CARD VIEW
        cd1=(CardView)findViewById(R.id.card1);
        cd2=(CardView)findViewById(R.id.card2);
        cd3=(CardView)findViewById(R.id.card3);
        cd4=(CardView)findViewById(R.id.card4);
        cd5=(CardView)findViewById(R.id.card5);
        cd6=(CardView)findViewById(R.id.card6);
        cd7=(CardView)findViewById(R.id.card7);
        cd8=(CardView)findViewById(R.id.card8);
        cd9=(CardView)findViewById(R.id.card9);
        cd10=(CardView)findViewById(R.id.card10);

        cd2.setVisibility(View.GONE);
        cd3.setVisibility(View.GONE);
        cd4.setVisibility(View.GONE);
        cd5.setVisibility(View.GONE);
        cd6.setVisibility(View.GONE);
        cd7.setVisibility(View.GONE);
        cd8.setVisibility(View.GONE);
        cd9.setVisibility(View.GONE);
        cd10.setVisibility(View.GONE);

        Bundle extras=getIntent().getExtras();
         allupdates=extras.getString("updates");
//        String jsons = meso.toString();
        Log.e("POSE", allupdates);

        //  -------------toolbar---------
        Toolbar toolbar =findViewById(R.id.eventstoolbar);
        setSupportActionBar(toolbar);


//        View bottomSheet = findViewById(R.id.bottom_sheet1);
//        mbottomSheetBehavior1 = BottomSheetBehavior.from(bottomSheet);
//
//        mButton1 = (Button) findViewById(R.id.button_1);
//        mButton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(mbottomSheetBehavior1.getState() != BottomSheetBehavior.STATE_EXPANDED) {
//                    mbottomSheetBehavior1.setState(BottomSheetBehavior.STATE_EXPANDED);
//                    mButton1.setText("collapsed");
//                }
//                else {
//                    mbottomSheetBehavior1.setState(BottomSheetBehavior.STATE_COLLAPSED);
//                    mButton1.setText("collapsed");
//                }
//            }
//        });


//        Events.downloadimage.execute();
        new Events.downloadimage().execute();

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

    public int imgviewname(int number){
//        String name="R.id.iupdate"+number;
        int name=0;// =R.id.iupdat;//+number;

        switch (number){
            case 1:
                name =R.id.iupdate1;
                pb1 =findViewById(R.id.progress_bar_1);
                pb1.setVisibility(ProgressBar.INVISIBLE);
                break;
            case 2:
                name =R.id.iupdate2;
                cd2.setVisibility(View.VISIBLE);
                pb2 =findViewById(R.id.progress_bar_2);
                pb2.setVisibility(ProgressBar.INVISIBLE);
                break;
            case 3:
                name =R.id.iupdate3;
                cd3.setVisibility(View.VISIBLE);
                pb3 =findViewById(R.id.progress_bar_3);
                pb3.setVisibility(ProgressBar.INVISIBLE);
                break;
            case 4:
                name =R.id.iupdate4;
                cd4.setVisibility(View.VISIBLE);
                pb4 =findViewById(R.id.progress_bar_4);
                pb4.setVisibility(ProgressBar.INVISIBLE);
                break;
            case 5:
                name =R.id.iupdate5;
                cd5.setVisibility(View.VISIBLE);
                pb5 =findViewById(R.id.progress_bar_5);
                pb5.setVisibility(ProgressBar.INVISIBLE);
                break;
            case 6:
                name =R.id.iupdate6;
                cd6.setVisibility(View.VISIBLE);
                pb6 =findViewById(R.id.progress_bar_6);
                pb6.setVisibility(ProgressBar.INVISIBLE);
                break;
            case 7:
                name =R.id.iupdate7;
                cd7.setVisibility(View.VISIBLE);
                pb7 =findViewById(R.id.progress_bar_7);
                pb7.setVisibility(ProgressBar.INVISIBLE);
                break;
            case 8:
                name =R.id.iupdate8;
                cd8.setVisibility(View.VISIBLE);
                pb8 =findViewById(R.id.progress_bar_8);
                pb8.setVisibility(ProgressBar.INVISIBLE);
                break;
            case 9:
                name =R.id.iupdate9;
                cd9.setVisibility(View.VISIBLE);
                pb9 =findViewById(R.id.progress_bar_9);
                pb9.setVisibility(ProgressBar.INVISIBLE);
                break;
            case 10:
                name =R.id.iupdate10;
                cd10.setVisibility(View.VISIBLE);
                pb10 =findViewById(R.id.progress_bar_10);
                pb10.setVisibility(ProgressBar.INVISIBLE);
                break;
        }

        return name;
    }

    class downloadimage extends AsyncTask<Void, Void,ArrayList> {
        Bitmap image;
        String name;
//        int ceiling;
//        public downloadimage(int ceiling){
//            this.ceiling=ceiling;
//        }

        @Override
        protected void onPostExecute(ArrayList bitmaps) {
//            super.onPostExecute(bitmaps);

//            if(bitmap!=null){
//                imageToUpload.setImageBitmap(bitmap);
//            }
            int position, imname;
            Bitmap bit;

            if (connection==1) {
                for (int i = 1; i <= max; i++) {
                    position = i - 1;
                    imname = imgviewname(i);
                    imagev = findViewById(imname);
                    bit = (Bitmap) bitmaps.get(position);
                    imagev.setImageBitmap(bit);
                }
            }else {
                Toast.makeText(getApplicationContext(), "Connection failed, please reload", Toast.LENGTH_SHORT).show();

            }
            }

        @Override
        protected  ArrayList<Bitmap> doInBackground(Void... params) {
//            IN NEED A FOR LOOP
//            ARRAY OF BITMAPS

//            String result="",SERVER_ADDRESS="http://192.168.43.113/pdobikephp/pictures/";
            String result="",SERVER_ADDRESS="http://stardigitalbikes.com/pictures/";

            ArrayList<Bitmap> bitmapArray=new ArrayList<Bitmap>();

            try {
                jObjc = new JSONObject(allupdates);

                JSONArray userArray=jObjc.getJSONArray("user");
                JSONObject user=userArray.getJSONObject(0);
                max=user.getInt("UT");

            } catch (JSONException e) {
                e.printStackTrace();
                Log.d("ASD", e.toString());

            }

            if (max>0){
                imagenamesarray=new String[max];

            for (int i=1;i<=max;i++){
                try {
                    jObjc = new JSONObject(allupdates);

                    JSONArray userArray=jObjc.getJSONArray("user");
                    JSONObject user=userArray.getJSONObject(0);
                    name=user.getString(String.valueOf(i));

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("ASD", e.toString());

                }

                String url = SERVER_ADDRESS + name;
                Bitmap itembit;

                try {
                    URLConnection connection = new URL(url).openConnection();
                    connection.setConnectTimeout(1000 * 30);
                    connection.setReadTimeout(1000 * 30);

                    itembit=BitmapFactory.decodeStream((InputStream) connection.getContent(), null, null);
                    bitmapArray.add(itembit);//ADD BITMAP TO ARRAY

                } catch (Exception e) {
                    Log.d("ASD", e.toString());
                    connection=0;
                    result = e.getMessage();
                    return null;
                }
            }
        }
            return bitmapArray;
        }


    }

}
