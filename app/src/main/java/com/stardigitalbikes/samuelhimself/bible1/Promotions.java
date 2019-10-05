package com.stardigitalbikes.samuelhimself.bible1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class Promotions extends AppCompatActivity {

    Button Bhom,Bmore,Bshare;
    TextView Tdigitaltime;

    private SharedPreferences prefs,prefer;
    private String prefName ="preProfile";
    private String prefName2 ="preBike";

    String serverKey="2y10f2Kkl1GRi5si0AAsgvsgJWyqXsUszC3DuvRLwZZ";
    String gencode;
    static JSONObject jObj = null;
    static String json = "",message;
    int availableBikes;

    private static final String SURNAME_KEY ="Surname";
    private static final String FIRST_NAME_KEY ="First Name";
    private static final String PHONE_NUMBER_KEY ="Phone Number";
    private static final String EMAIL_ADDRESS_KEY ="Email";
    private static final String RESIDENCE_KEY ="Residence";
    private static final String DIGITAL_TIME_KEY ="Digital Time";
    private static final String GENDER_KEY ="Gender";

    TextView tcode;
    Button bsharegen;

    static JSONObject jObjc = null;

    int daynight=0,sucki;
    String msgs;


    private ProgressBar progBar;
    private TextView text;
    private Handler mHandler = new Handler();
    private int mProgressStatus=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotions);

//        STATUS BAR
        if(Build.VERSION.SDK_INT >=21){
            Window window=this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.darkdarkTurq));
        }

        progBar= (ProgressBar)findViewById(R.id.pbshare);
        pogless();

        tcode=(TextView)findViewById(R.id.sharectext);
        bsharegen=(Button)findViewById(R.id.sharegen);


//        prefs = getSharedPreferences(prefName, MODE_PRIVATE);

//        Tdigitaltime=(TextView)findViewById(R.id.textdigitaltime);
//        Tdigitaltime.append(prefs.getString(RESIDENCE_KEY,""));

        //  -------------toolbar---------
        Toolbar toolbar =findViewById(R.id.promotionstoolbar);
        setSupportActionBar(toolbar);

//
//        Bhom= findViewById(R.id.hm12);
//        Bhom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent int1 =new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(int1);
//            }
//        });
//
//
//
//        Bmore= findViewById(R.id.more12);
//        Bmore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent int1 =new Intent(getApplicationContext(),More.class);
//                startActivity(int1);
//            }
//        });

//        Bshare= findViewById(R.id.sharebutton);
//        Bshare.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent int1 =new Intent(Intent.ACTION_SEND);
//                int1.setType("text/plain");
//                String shareBody ="your body here";
//                int1.putExtra(Intent.EXTRA_SUBJECT,shareBody);
//                int1.putExtra(Intent.EXTRA_TEXT,shareBody);
//                startActivity(Intent.createChooser(int1, "Share using"));
//            }
//        });



    }


    public void pogless() {

        new Thread(new Runnable() {
            public void run() {
                final int presentage=0;
                while (mProgressStatus < 100) {
                    mProgressStatus += 10;
                    if(mProgressStatus==100){
                        mProgressStatus=0;
                    }
                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            progBar.setProgress(mProgressStatus);
//                            text.setText(""+mProgressStatus+"%");
                        }
                    });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    //*******************MENU****************8
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
//            case R.id.usermenu:
//                Intent int1 =new Intent(getApplicationContext(),Profile.class);
//                startActivity(int1);

            case R.id.action_profile:
                startActivity(new Intent(Promotions.this, Profile.class));
                break;
//            case R.id.action_tutorial:
//                startActivity(new Intent(Mapsimport1.this, Instructions.class));
////                startActivity(new Intent(Mapsimport1.this, LOGIN2.class));
////                Intent inty =new Intent(Mapsimport1.this,Events.class);
////                inty.putExtra("updates",ups);
////                startActivity(inty);
//
//                break;
            case R.id.action_safetytips:
                startActivity(new Intent(Promotions.this, SafetyTips.class));
                break;
//            case R.id.action_support:
//                startActivity(new Intent(Mapsimport1.this, Support.class));
//                break;
//            case R.id.action_events:
//                Intent inty =new Intent(Mapsimport1.this,Events.class);
//                inty.putExtra("updates",ups);
//                startActivity(inty);
//                break;
            case R.id.action_termsandconds:
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://stardigitalbikes.com/terms_and_conditions.php"));
                startActivity(browserIntent);

                break;
//            case R.id.action_share:
//                startActivity(new Intent(Mapsimport1.this, Promotions.class));
//                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public  void sharegen(View view){
        Button bshare=(Button)findViewById(R.id.sharegen);

//        ANIMATION
        Animation animation= AnimationUtils.loadAnimation(Promotions.this,R.anim.bounce);
        bshare.startAnimation(animation);

        if(daynight==0){//GENERATE CODE
            progBar.setVisibility(ProgressBar.VISIBLE);
            new Promotions.backgroundCodegen(this).execute();
        }else{//SHARE CODE
//            progBar.setVisibility(ProgressBar.VISIBLE);
            Intent int1 =new Intent(Intent.ACTION_SEND);
            int1.setType("text/plain");
            String shareBody ="https://play.google.com/store/apps/details?id=com.stardigitalbikes.samuelhimself.bible1" +
                    " Follow the link above to download digital bikes and input code:"+gencode+" to earn 20 minutes Digital time";
//            String shareBody =getResources().getString(R.string.mylink)+gencode;
            int1.putExtra(Intent.EXTRA_SUBJECT,shareBody);
            int1.putExtra(Intent.EXTRA_TEXT,shareBody);
            startActivity(Intent.createChooser(int1, "Share using"));

        }

    }
    class backgroundCodegen extends AsyncTask<String, Void,String> {
        AlertDialog dialog;
        Context context;

        public backgroundCodegen(Context context){
            this.context=context;
        }

        @Override
        protected void onPostExecute(String s) {
            String jjon = s.toString();
//            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            progBar.setVisibility(ProgressBar.INVISIBLE);

            try {
                jObjc = new JSONObject(s);
                sucki=jObjc.getInt("success");
                msgs=jObjc.getString("success");
                gencode=jObjc.getString("SC");

            } catch (JSONException e) {
                e.printStackTrace();
            }
            switch (sucki) {
                case 0:
                    Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                    break;
                case 1:
                    daynight++;
                    tcode.setText(gencode);
                    bsharegen.setText("Share Code");
                    break;
                default:
                        Toast.makeText(getApplicationContext(),"Try again",Toast.LENGTH_LONG).show();
                        break;
            }

        }
        public void onBackPressed(){
            moveTaskToBack(true);
        }
        @Override
        protected String doInBackground(String... voids) {
            String result="";
//            String AgCode =voids[0];

            String connstr="http://stardigitalbikes.com/share_code_pdo.php";
//            String connstr="http://192.168.43.113/pdobikephp/share_code_pdo.php";


            prefer=getSharedPreferences(prefName,MODE_PRIVATE);
            String Usurname=prefer.getString(SURNAME_KEY,""),
                    Ufirstname=prefer.getString(FIRST_NAME_KEY,""),
                    Uphone=prefer.getString(PHONE_NUMBER_KEY,""),
                    Uemail=prefer.getString(EMAIL_ADDRESS_KEY,""),
                    Uresidence=prefer.getString(RESIDENCE_KEY,"");
            String Ugender=prefer.getString(GENDER_KEY,"");


            try {
                URL url =new URL(connstr);
                HttpURLConnection http =(HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);


                OutputStream ops =http.getOutputStream();
                BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
                String data =URLEncoder.encode("surname","UTF-8")+"="+URLEncoder.encode(Usurname,"UTF-8")
                        +"&&"+ URLEncoder.encode("firstname","UTF-8")+"="+URLEncoder.encode(Ufirstname,"UTF-8")
                        +"&&"+ URLEncoder.encode("phonenumber","UTF-8")+"="+URLEncoder.encode(Uphone,"UTF-8")
                        +"&&"+ URLEncoder.encode("gender","UTF-8")+"="+URLEncoder.encode(Ugender,"UTF-8")
                        +"&&"+ URLEncoder.encode("residence","UTF-8")+"="+URLEncoder.encode(Uresidence,"UTF-8");
                writer.write(data);
                writer.flush();
                writer.close();
                ops.close();
                Log.d("JSON Exception","DONE SENDING");

                InputStream ips =http.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));
                String line ="";
                while ((line=reader.readLine()) !=null){
                    result +=line;

                }
//#######INTRODICING THE READING OOF THE RETURNED JSON
                ips.close();
                reader.close();
                json = result.toString();

//##################################################################33
                http.disconnect();
                return result;

            } catch (MalformedURLException e) {
                Log.d("JSON Exception",e.toString());
                result =e.getMessage();
            } catch (ProtocolException e) {
                Log.d("JSON Exception",e.toString());
                result =e.getMessage();
            } catch (IOException e) {
                Log.d("JSON Exception",e.toString());
                result =e.getMessage();
            }

            return result;
        }


    }


}
