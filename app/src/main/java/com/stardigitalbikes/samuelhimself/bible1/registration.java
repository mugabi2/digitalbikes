package com.stardigitalbikes.samuelhimself.bible1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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
import java.util.HashMap;
import java.util.Map;

import static com.stardigitalbikes.samuelhimself.bible1.R.id.radio_female;

public class registration extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ProgressBar progBar;
    private TextView text;
    private Handler mHandler = new Handler();
    private int mProgressStatus=0;

    private SharedPreferences prefer;
    private String prefName2 ="preBike";
    String thecode="0",send;

    String serverKey="2y10f2Kkl1GRi5si0AAsgvsgJWyqXsUszC3DuvRLwZZ";
    private static final String SURNAME_KEY ="Surname";
    private static final String FIRST_NAME_KEY ="First Name";
    private static final String PHONE_NUMBER_KEY ="Phone Number";
    private static final String EMAIL_ADDRESS_KEY ="Email";
    private static final String RESIDENCE_KEY ="Residence";
    private static final String GENDER_KEY ="Gender";
    private static final String LOCATION_KEY ="Location";
    private static final String LOGIN_STATUS_KEY ="Login Status";

    private SharedPreferences prefs,prefl;
    private String prefName ="preProfile";
    private String preflogin="preflogin";
    static JSONObject jObj = null;
    static String json = "";
    String usersurname,userfirstname,userphonenumb,useremailadd,userresidence,usergender,message,preferred,prefer2;
    Boolean loginStatus;
    static JSONObject jObjc = null;

    Dialog shareDialog, tacDialog;



    String sex="M",mesg,all,msg;
    EditText esname,efname,ephone,eemail,epassword,eresi,esharecode;
    Button Bsignup,Bcontinueshare;
    int suckinda,sucks;

    //    SPINNER
    private Spinner spinner;
    private static final String[] paths = {"MUK"};//, "MUBS", "UCU"};

    CheckBox checkBoxer;
    int tac=0;

    EditText epromocode;
    String promotion;
    ProgressBar pogba;

    private SmoothProgressBar pogback;
    int one=1,two=2,three=3,four=4,five=5;
    private Interpolator mCurrentInterpolator;

    // under this activity we need to create a listener that will keep checking if the user is verified or not
    com.stardigitalbikes.samuelhimself.bible1.Permissions permit=new com.stardigitalbikes.samuelhimself.bible1.Permissions();

    private Handler handler;
    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {


            if (permit.isUserVerified(registration.this)) {
                finish();
//                startActivity(new Intent(registration.this, Instructions.class));
                Toast.makeText(registration.this, "Verification succeeded ", Toast.LENGTH_SHORT).show();
                Log.d("sxs", "verifying click ");

                // stop handler from updating
                handler.removeCallbacks(runnable);
            }

            handler.postDelayed(runnable, 1000); // keep checking after every one second
        }
    };

    String sname;
    String fname;
    String phone;
    //            String email = eemail.getText().toString();
    String psword;
    String resid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        pogba=findViewById(R.id.pogba5);
        tacDialog = new Dialog(this);
        tacDialog.setContentView(R.layout.terms_and_conditions);

        pogback=tacDialog.findViewById(R.id.pogback5);

        mCurrentInterpolator = new FastOutSlowInInterpolator();

        pogback.setSmoothProgressDrawableSpeed(one);
        pogback.setSmoothProgressDrawableProgressiveStartSpeed(one);
        pogback.setSmoothProgressDrawableProgressiveStopSpeed(one);
        pogback.setSmoothProgressDrawableSectionsCount(five);
        pogback.setSmoothProgressDrawableInterpolator(mCurrentInterpolator);
        pogback.setSmoothProgressDrawableColors(getResources().getIntArray(R.array.dbcolorspock));
//        pogback.setSmoothProgressDrawableMirrorMode(true);
//        pogback.setSmoothProgressDrawableSeparatorLength(dpToPx(mSeparatorLength));
//        STATUS BAR
        if(Build.VERSION.SDK_INT >=21){
            Window window=this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.darkdarkTurq));
        }

        preferred="MUK";

        epromocode=findViewById(R.id.pcodeif);

//        checkBoxer=findViewById(R.id.check);
//        checkBoxer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("check", "cheque "+tac);
////                Toast.makeText(getApplicationContext(),"check "+tac,Toast.LENGTH_SHORT).show();
//                if(checkBoxer.isChecked()){
//                    tac=1;
//                }else{
//                    tac=0;
//                }
//            }
//        });

        Button bsinu=findViewById(R.id.signup);
//        ANIMATION
        Animation animation= AnimationUtils.loadAnimation(registration.this,R.anim.blink_anim);
        bsinu.startAnimation(animation);

        //^^^^^^^^^^^^^^^^^^^^^^
//        spinner = (Spinner)findViewById(R.id.spinner);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(registration.this,
//                android.R.layout.simple_spinner_item,paths);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);


//66666^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

        shareDialog = new Dialog(this);
        shareDialog.setContentView(R.layout.share_code);

//        pogless();

        esname=(EditText)findViewById(R.id.sname);
        efname=(EditText)findViewById(R.id.fname);
        ephone=(EditText)findViewById(R.id.phonenum);
//        eemail=(EditText)findViewById(R.id.Eemail);
        epassword=(EditText)findViewById(R.id.Ppassword);
        eresi=(EditText)findViewById(R.id.resi);
        Bsignup=(Button)findViewById(R.id.signup);


    }
    private void verifyPhoneNumber(final String phoneNumber) {
        String url = "https://stardigitalbikes.com/africasTalking/smsverification.php";

        pogback.setVisibility(View.VISIBLE);
        pogba.setVisibility(View.VISIBLE);
//        final ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Sending verification code...");
//        Log.d("sms", "Sending verification code... ");
//        progressDialog.setCancelable(false);
//        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                progressDialog.dismiss();
                Log.d("sxs", "response");

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                progressDialog.dismiss();
                finish();
                Toast.makeText(registration.this, "network error!", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                params.put("phone", phoneNumber);

                return params;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (permit.isUserVerified(registration.this)) {
            if (handler != null) {
                handler.removeCallbacks(runnable);
            }
            finish();
            startActivity(new Intent(this, Instructions.class));
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
//        handler.removeCallbacks(runnable);
    }

    public void showtac() {
        Button tacb,proceed;
        TextView upmsg;

        tacb=tacDialog.findViewById(R.id.tacpop);
        tacb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://stardigitalbikes.com/terms_and_conditions.php"));
                startActivity(browserIntent);

            }
        });

//        proceed=tacDialog.findViewById(R.id.proceedpop);
//        proceed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tacDialog.dismiss();
//            }
//        });

        tacDialog.setCancelable(true);

        tacDialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                preferred="MUK";
//                Toast.makeText(getApplicationContext(),"MUK",Toast.LENGTH_SHORT).show();

                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                preferred="MUBS";
//                Toast.makeText(getApplicationContext(),"MUBS",Toast.LENGTH_SHORT).show();

                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                preferred="UCU";
//                Toast.makeText(getApplicationContext(),"UCU",Toast.LENGTH_SHORT).show();

                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }


    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radio_male:
                if (checked){
                    sex="M";
                }
                break;
            case radio_female:
                if (checked){
                    sex="F";
                }
                break;
        }
    }
    public void popme(View view) {
//        $#
        showtac();
    }
        public void TACwebsite(View view){
        Intent browserIntent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://stardigitalbikes.com/terms_and_conditions.php"));
        startActivity(browserIntent);
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

    public void regMe(View view){
        String phonel =ephone.getText().toString();
        int plen =phonel.length();

        if (plen==9) {
             sname = esname.getText().toString();
             fname = efname.getText().toString();
             phone = ephone.getText().toString();
//             email = eemail.getText().toString();
             psword = epassword.getText().toString();
             resid = eresi.getText().toString();


            //Checking if all fields have been filled
            if (!sname.isEmpty() && !fname.isEmpty() && !phone.isEmpty() && !psword.isEmpty() && !resid.isEmpty()) {
//                if (tac==1) {
//PROMO WAS HERE
                String pcode=epromocode.getText().toString();
//                    thecode=scode;
//////////////
                if(!pcode.isEmpty()){
//      PROMO CODE???????
                    promotion="1";
                    thecode=pcode;
//                        new registration.backgroundsharecode(registration.this).execute();
                    new backgroundregistration(registration.this).execute(sname, fname, phone, psword, resid, sex);
                    Log.d("sxs", "with promo");
                }else {
                    promotion="0";
                    new backgroundregistration(registration.this).execute(sname, fname, phone, psword, resid, sex);
                    Log.d("sxs", "REGITSTRATION without code");
                }
//                String atphone="0"+phone;
//                Log.d("sxs", atphone);
//                verifyPhoneNumber(atphone);
//                    ProgressBar pb = findViewById(R.id.progressBar4);
//                    pb.setVisibility(ProgressBar.VISIBLE);
//                    new backgroundregistration(this).execute(sname, fname, phone, email, psword, resid, sex);
//                    Log.d("Request status", "GOOD INPUT am gonna make the request");
//                }else{
//                    Toast.makeText(getApplicationContext(), "Please check Terms and Conditions", Toast.LENGTH_SHORT).show();
//                }
            } else {
                Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Check length of your phone number", Toast.LENGTH_LONG).show();
        }
    }
    //##################BACK GROUND CLASSS$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$444444444
    class backgroundregistration extends AsyncTask<String, Void,String> {

        AlertDialog dialog;
        Context context;
        public backgroundregistration(Context context){
            this.context=context;
        }

        @Override
        protected void onPreExecute() {
            pogback.setVisibility(View.VISIBLE);
            pogba.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            prefl=getSharedPreferences(preflogin, MODE_PRIVATE);
//            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();

            pogback.setVisibility(View.INVISIBLE);
            pogba.setVisibility(View.INVISIBLE);
            Log.d("SHREE",s);
            try {
                jObjc = new JSONObject(s);
                suckinda=jObjc.getInt("success");
//                mesg=jObjc.getString("message");

            } catch (JSONException e) {
                e.printStackTrace();
            }
            switch (suckinda) {
                case 0:
//                    Toast.makeText(getApplicationContext(),mesg,Toast.LENGTH_LONG).show();
                    Log.d("SHARE CODE", "000000");

                    break;
                case 1:
                    SharedPreferences.Editor editor=prefl.edit();
                    loginStatus=Boolean.TRUE;
                    editor.putBoolean(LOGIN_STATUS_KEY,loginStatus);
                    editor.commit();
                    all=s;
                    Intent int111=new Intent(registration.this,Mapsimport1.class);
                    int111.putExtra("bikesin",all);
                    startActivity(int111);
                    finish();
                    Log.d("SHARE CODE", "1111111");

                    break;
            }
//            Log.d("SHARE CODE", " "+mesg);
        }

        @Override
        protected String doInBackground(String... voids) {
            Log.d("SEX SEX SEX ", sex);

            String result="";
            String sname =voids[0];
            String  fname= voids[1];
            String phonenum=voids[2];
            String pass=voids[3];
            String residence=voids[4];
            String sex=voids[5];
//            String mail=voids[3];

//45
            String connstr="http://stardigitalbikes.com/user_sign_up_pdo.php";
//            String connstr="http://192.168.43.113/pdobikephp/user_sign_up_pdo.php";

            try {
                URL url =new URL(connstr);
                HttpURLConnection http =(HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);

                Log.d("SEND",sname+phonenum+' '+promotion+" "+thecode);

                OutputStream ops =http.getOutputStream();
                BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
                String data = URLEncoder.encode("surname","UTF-8")+"="+URLEncoder.encode(sname,"UTF-8")
                        +"&&"+ URLEncoder.encode("firstname","UTF-8")+"="+URLEncoder.encode(fname,"UTF-8")
                        +"&&"+ URLEncoder.encode("phonenumber","UTF-8")+"="+URLEncoder.encode(phonenum,"UTF-8")
//                        +"&&"+ URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(mail,"UTF-8")
                        +"&&"+ URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8")
                        +"&&"+ URLEncoder.encode("residence","UTF-8")+"="+URLEncoder.encode(residence,"UTF-8")
                        +"&&"+ URLEncoder.encode("gender","UTF-8")+"="+URLEncoder.encode(sex,"UTF-8")
                        +"&&"+ URLEncoder.encode("preferredlocation","UTF-8")+"="+URLEncoder.encode(preferred,"UTF-8")
                        +"&&"+ URLEncoder.encode("serverKey","UTF-8")+"="+URLEncoder.encode(serverKey,"UTF-8")
                        +"&&"+ URLEncoder.encode("promotion","UTF-8")+"="+URLEncoder.encode(promotion,"UTF-8")
                        +"&&"+ URLEncoder.encode("code","UTF-8")+"="+URLEncoder.encode(thecode,"UTF-8");
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

                        Log.d("JSONStatus", "JSON RETURNED");

                        if(success==1){
                            JSONArray userArray=jObj.getJSONArray("user");
                            JSONObject user=userArray.getJSONObject(0);
                            usersurname=user.getString("SN");
                            userfirstname=user.getString("FN");
                            userphonenumb=user.getString("PN");
//                            useremailadd=user.getString("EM");
                            userresidence=user.getString("RD");
                            usergender=user.getString("GD");
                            prefer2=user.getString("PL");

//                            prefl=getSharedPreferences(preflogin,MODE_PRIVATE);
//                            SharedPreferences.Editor editor=prefl.edit();
//                            loginStatus=Boolean.TRUE;
//                            editor.putBoolean(LOGIN_STATUS_KEY,loginStatus);
//                            editor.commit();
                            Log.d("JSONStatus","Login success");



//make SHARED PREFS A METHOD

                            savingToSharedPrefs(usersurname,userfirstname,userphonenumb,userresidence,usergender,prefer2);


                        }else{
//                            prefl=getSharedPreferences(preflogin,MODE_PRIVATE);
//                            SharedPreferences.Editor editor=prefl.edit();
//                            loginStatus=Boolean.FALSE;
//                            editor.putBoolean(LOGIN_STATUS_KEY,loginStatus);
//                            editor.commit();
                            Log.d("JSONStatus","Login failure");
                            message=jObj.getString("message");
                            Log.d("JSONStatus",message);
                        }
                    }else{
//                        prefl=getSharedPreferences(preflogin,MODE_PRIVATE);
//                        SharedPreferences.Editor editor=prefl.edit();
//                        loginStatus=Boolean.FALSE;
//                        editor.putBoolean(LOGIN_STATUS_KEY,loginStatus);
//                        editor.commit();
                        Log.e("JSON Parser", "RETURNED JSON IS NULL ");
                    }
                } catch (JSONException e) {
//                    prefl=getSharedPreferences(preflogin,MODE_PRIVATE);
//                    SharedPreferences.Editor editor=prefl.edit();
//                    loginStatus=Boolean.FALSE;
//                    editor.putBoolean(LOGIN_STATUS_KEY,loginStatus);
//                    editor.commit();
                    Log.e("JSON Parser", "Error creating the json object " + e.toString());
                }
//##################################################################33
                http.disconnect();
                return result;

            } catch (MalformedURLException e) {
//                prefl=getSharedPreferences(preflogin,MODE_PRIVATE);
//                SharedPreferences.Editor editor=prefl.edit();
//                loginStatus=Boolean.FALSE;
//                editor.putBoolean(LOGIN_STATUS_KEY,loginStatus);
//                editor.commit();
                Log.d("JSON Exception",e.toString());
                result =e.getMessage();
            } catch (ProtocolException e) {
//                prefl=getSharedPreferences(preflogin,MODE_PRIVATE);
//                SharedPreferences.Editor editor=prefl.edit();
//                loginStatus=Boolean.FALSE;
//                editor.putBoolean(LOGIN_STATUS_KEY,loginStatus);
//                editor.commit();
                Log.d("JSON Exception",e.toString());
                result =e.getMessage();
            } catch (IOException e) {
//                prefl=getSharedPreferences(preflogin,MODE_PRIVATE);
//                SharedPreferences.Editor editor=prefl.edit();
//                loginStatus=Boolean.FALSE;
//                editor.putBoolean(LOGIN_STATUS_KEY,loginStatus);
//                editor.commit();
                Log.d("JSON Exception",e.toString());
                result =e.getMessage();
            }

            return result;
        }

    }

    public  void savingToSharedPrefs( String Ssurname,String Sfirstname,String Sphonenumb,String Sresidence,String Sgender,String Spref){
        //shared prefs#########################################
        prefs=getSharedPreferences(prefName, MODE_PRIVATE);
        SharedPreferences.Editor editor=prefs.edit();

        //---save the values in the EditText view to preferences---
        editor.putString(SURNAME_KEY, Ssurname);
        editor.putString(FIRST_NAME_KEY, Sfirstname);
        editor.putString(PHONE_NUMBER_KEY, Sphonenumb);
        editor.putString(RESIDENCE_KEY, Sresidence);
        editor.putString(GENDER_KEY, Sgender);
        editor.putString(LOCATION_KEY, Spref);

        //---saves the values---
        editor.commit();

        Log.d("JSONStatus","saved to prefs successfully");
    }

    public void logMeIn(View view){
        Intent intent= new Intent(this,LOGIN.class);
        startActivity(intent);
    }

    public void sharing(){
        new registration.backgroundsharecode(registration.this).execute();
    }

    public void showshare() {

//        shareDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        esharecode=shareDialog.findViewById(R.id.sharecode111);
        shareDialog.setCancelable(false);
        Bcontinueshare=shareDialog.findViewById(R.id.continueshare);
        Bcontinueshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String scode=esharecode.getText().toString();
                thecode=scode;
//////////////
                if(!scode.isEmpty()){
                    sharing();
                    Log.d("Request status","INPUT PRESENT;;;CONTINUE");
//                    Toast.makeText(getApplicationContext(),all,Toast.LENGTH_LONG).show();

                }else {
//                    Toast.makeText(getApplicationContext(),all,Toast.LENGTH_LONG).show();
                    Intent int111=new Intent(registration.this,Mapsimport1.class);
                    int111.putExtra("bikesin",all);
                    startActivity(int111);
                    finish();
                    Log.d("Request status","THIS IS INCASE THERE IS NO INPUT");
                }

            }
        });
        shareDialog.show();
    }

    class backgroundsharecode extends AsyncTask<String, Void,String> {
        AlertDialog dialog;
        Context context;

        public backgroundsharecode(Context context){
            this.context=context;
        }

        @Override
        protected void onPostExecute(String s) {
            String jjon = s.toString();
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();

            try {
                jObjc = new JSONObject(s);
                sucks=jObjc.getInt("success");
                msg=jObjc.getString("success");

            } catch (JSONException e) {
                e.printStackTrace();
            }
            switch (sucks) {
                case 1://CALL THE INTENT OF MAPSIMPORT
//                    Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                    Intent int111=new Intent(registration.this,Mapsimport1.class);
                    int111.putExtra("bikesin",s);
                    startActivity(int111);
                    finish();
                    break;
                default:
                    Toast.makeText(getApplicationContext(),"Try again",Toast.LENGTH_LONG).show();
                    break;
            }

        }

        @Override
        protected String doInBackground(String... voids) {
            String result="";
//            String AgCode =voids[0];1212

            String connst="http://stardigitalbikes.com/share_code_get.php";

//            String connst="http://stardigitalbikes.com/share_code_get.php";
//            String connst="http://192.168.43.113/pdobikephp/share_code_get.php";


            prefer=getSharedPreferences(prefName,MODE_PRIVATE);
            String Usurname=prefer.getString(SURNAME_KEY,""),
                    Ufirstname=prefer.getString(FIRST_NAME_KEY,""),
                    Uphone=prefer.getString(PHONE_NUMBER_KEY,""),
                    Uresidence=prefer.getString(RESIDENCE_KEY,"");
            String Ugender=prefer.getString(GENDER_KEY,"");

            try {
                URL url =new URL(connst);
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
                        +"&&"+ URLEncoder.encode("code","UTF-8")+"="+URLEncoder.encode(thecode,"UTF-8")
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
                Log.d("JSON Exception 1",e.toString());
                result =e.getMessage();
            } catch (ProtocolException e) {
                Log.d("JSON Exception 2",e.toString());
                result =e.getMessage();
            } catch (IOException e) {
                Log.d("JSON Exception 3",e.toString());
                result =e.getMessage();
            }

            return result;
        }
    }

    public void checkboxed(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        Toast.makeText(getApplicationContext(),"touch touch touch",Toast.LENGTH_SHORT).show();
//        !!!
        if (checked){
            Toast.makeText(getApplicationContext(),"check",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"Please check terms and conditions",Toast.LENGTH_SHORT).show();
        }
    }


}
