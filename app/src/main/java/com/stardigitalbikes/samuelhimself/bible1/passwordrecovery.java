package com.stardigitalbikes.samuelhimself.bible1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
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

public class passwordrecovery extends AppCompatActivity {

    private SharedPreferences prefl;
    private String preflogin="preflogin";
    Boolean loginStatus;


    static JSONObject jObjc = null;
    String bikeNumb,fineCash,duraa,timetaken,timeShouldReturn,timeRet;


    private SharedPreferences prefs,prefer;
    private String prefName ="preProfile";
    private String prefName2 ="preBike";

    String serverKey="2y10f2Kkl1GRi5si0AAsgvsgJWyqXsUszC3DuvRLwZZ";
    String gearS;
    static JSONObject jObj = null;
    static String json = "",message;
    int availableBikes;

    private static final String SURNAME_KEY ="Surname";
    private static final String FIRST_NAME_KEY ="First Name";
    private static final String PHONE_NUMBER_KEY ="Phone Number";
    private static final String EMAIL_ADDRESS_KEY ="Email";
    private static final String RESIDENCE_KEY ="Residence";
    private static final String LOGIN_STATUS_KEY ="Login Status";
    private static final String GENDER_KEY ="Gender";
    private static final String LOCATION_KEY ="Location";

    String usersurname,userfirstname,userphonenumb,useremailadd,userresidence,usergender,prefer2;

    EditText ephone,epassword;


    private ProgressBar progBar;
    private TextView text;
    private Handler mHandler = new Handler();
    private int mProgressStatus=0;
    String phoe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordrecovery);

        progBar= (ProgressBar)findViewById(R.id.pbrec);
        pogless();

        Bundle extras=getIntent().getExtras();
        phoe=extras.getString("phone");


//        ephone=(EditText)findViewById(R.id.input_phone_new);
//        epassword=(EditText)findViewById(R.id.input_password_new);


//        Button Bcreate=(Button)findViewById(R.id.createnew);
//
//        Bcreate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent int111=new Intent(passwordrecovery.this,registration.class);
//                startActivity(int111);
//
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

    public void recover(View view){

        progBar.setVisibility(ProgressBar.VISIBLE);
//        String phone =ephone.getText().toString();
        String psword =epassword.getText().toString();

        new passwordrecovery.backgroundrecover(this).execute(psword);
    }

    class backgroundrecover extends AsyncTask<String, Void,String> {
        AlertDialog dialog;
        Context context;
        public backgroundrecover(Context context){
            this.context=context;

        }

        @Override
        protected void onPostExecute(String s) {
            json = s.toString();
//            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            progBar.setVisibility(ProgressBar.INVISIBLE);


            try {
                jObj = new JSONObject(json);
                int  success = jObj.getInt("success");

                switch (success){
                    case 1:
                        Intent int1 =new Intent(getApplicationContext(),Mapsimport1.class);
                        int1.putExtra("bikesin",s);
                        startActivity(int1);
                        break;
                    case 4:
                        Intent int7 =new Intent(getApplicationContext(),Mapsimport1.class);
                        int7.putExtra("bikesin",s);
                        startActivity(int7);
                        break;
                   default:
                        break;
                }
            } catch (JSONException e) {
                Log.e("JSON Parser", "Error creating the json object " + e.toString());
            }
        }

        @Override
        protected String doInBackground(String... voids) {
            String result="";

//            String phonenum=voids[0];
            String pass=voids[1];

            String connstr="http://stardigitalbikes.com/password_rec.php";
//            String connstr="http://192.168.43.113/pdobikephp/password_rec.php";

            try {
                URL url =new URL(connstr);
                HttpURLConnection http =(HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);


                OutputStream ops =http.getOutputStream();
                BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
                String data = URLEncoder.encode("phonenumber","UTF-8")+"="+URLEncoder.encode(phoe,"UTF-8")
                        +"&&"+ URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8")
                        +"&&"+ URLEncoder.encode("serverKey","UTF-8")+"="+URLEncoder.encode(serverKey,"UTF-8");
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

                try {
                    jObj = new JSONObject(json);
                    if(json!=null){
                        int success=jObj.getInt("success");

                        JSONArray userArray=jObj.getJSONArray("user");
                        JSONObject user=userArray.getJSONObject(0);
                        usersurname=user.getString("SN");
                        userfirstname=user.getString("FN");
                        userphonenumb=user.getString("PN");
                        useremailadd=user.getString("EM");
                        userresidence=user.getString("RD");
                        usergender=user.getString("GD");
                        prefer2=user.getString("PL");

                        prefl=getSharedPreferences(preflogin,MODE_PRIVATE);
                        SharedPreferences.Editor editor=prefl.edit();
                        loginStatus=Boolean.TRUE;
                        editor.putBoolean(LOGIN_STATUS_KEY,loginStatus);
                        editor.commit();
                        Log.d("JSONStatus","SAVED LOGIN PREFS SUCCESS");
                        Log.d("WHAT AM SAVING",usersurname+userfirstname+userphonenumb);


                        Log.d("JSONStatus", "JSON RETURNED");
//make SHARED PREFS A METHOD
                            savingToSharedPrefs(usersurname,userfirstname,userphonenumb,useremailadd,userresidence,usergender,prefer2);
                    }else{
                        Log.e("JSON Parser", "RETURNED JSON IS NULL ");
                    }
                } catch (JSONException e) {
                    Log.e("JSON Parser", "Error creating the json object " + e.toString());
                }
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

    public  void savingToSharedPrefs( String Ssurname,String Sfirstname,String Sphonenumb,String Semail,String Sresidence,String Sgender,String Spref){
        //shared prefs#########################################
        prefs=getSharedPreferences(prefName, MODE_PRIVATE);
        SharedPreferences.Editor editor=prefs.edit();

        //---save the values in the EditText view to preferences---
        editor.putString(SURNAME_KEY, Ssurname);
        editor.putString(FIRST_NAME_KEY, Sfirstname);
        editor.putString(PHONE_NUMBER_KEY, Sphonenumb);
        editor.putString(EMAIL_ADDRESS_KEY, Semail);
        editor.putString(RESIDENCE_KEY, Sresidence);
        editor.putString(GENDER_KEY, Sgender);
        editor.putString(LOCATION_KEY, Spref);

        //---saves the values---
        editor.commit();

        Log.d("JSONStatus","saved to prefs successfully");
    }
}
