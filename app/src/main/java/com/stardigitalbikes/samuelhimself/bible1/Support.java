package com.stardigitalbikes.samuelhimself.bible1;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
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

public class Support extends AppCompatActivity {

    Button Bhom,Bmore,Bcall,Bmail,Bsafe;
    BottomSheetBehavior mBottomSheetBehaviour;

//  rating
    Dialog ratdialog;
    //    FEEDBACK
    private RatingBar ratingBar;
    private int stars;
    Button sendFeed;
    EditText feedMsg;
    String feedbackmsg;

    static JSONObject jObj = null;
    static String json = "", message;

    String usname, ufname, uphone, umail, uresi, udura = "20", upaymeth, uagcode;

    private SharedPreferences prefs, prefer;
    private String prefName = "preProfile";
    private String prefName2 = "preBike";

    private static final String SURNAME_KEY = "Surname";
    private static final String FIRST_NAME_KEY = "First Name";
    private static final String PHONE_NUMBER_KEY = "Phone Number";
    private static final String EMAIL_ADDRESS_KEY = "Email";
    private static final String RESIDENCE_KEY = "Residence";
    private static final String DIGITAL_TIME_KEY = "Digital Time";
    private static final String LOCATION_KEY ="Location";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        prefs = getSharedPreferences(prefName, MODE_PRIVATE);

        usname=prefs.getString(SURNAME_KEY,"");
        ufname=prefs.getString(FIRST_NAME_KEY,"");
        uphone=prefs.getString(PHONE_NUMBER_KEY,"");
        umail=prefs.getString(EMAIL_ADDRESS_KEY,"");
        uresi=prefs.getString(RESIDENCE_KEY,"");
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

    //$
    public void showFeedback(){
        //feedback
        ImageView cancel;
        Button sendfeed;

        cancel=ratdialog.findViewById(R.id.close_popupf);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratdialog.dismiss();
            }
        });

        ratingBar = ratdialog.findViewById(R.id.rating);
        sendFeed=ratdialog.findViewById(R.id.send_feedback);
        feedMsg=ratdialog.findViewById(R.id.feedtext);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                stars = (int)ratingBar.getRating();
            }
        });
//    sendfeed=ratdialog.findViewById(R.id.send_feedback);
//    sendfeed.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            feedbackmsg = feedMsg.getText().toString();
//            Toast.makeText(getApplicationContext(),feedbackmsg,Toast.LENGTH_SHORT).show();
//            new Mapsimport1.backgroundfeedback(Mapsimport1.this).execute();
//        }
//    });

        ratdialog.show();
    }

//    $
    class backgroundfeedback extends AsyncTask<String, Void,String> {
        Context context;
        public backgroundfeedback(Context context){
            this.context=context;
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                jObj = new JSONObject(s);
                if(json!=null){
                    int success=jObj.getInt("success");
                    String feedThanks=jObj.getString("message");
                    Toast.makeText(getApplicationContext(),feedThanks,Toast.LENGTH_SHORT).show();

                    Log.d("JSONStatus", "JSON RETURNED");
                }else{
                    Log.e("JSON Parser", "RETURNED JSON IS NULL ");
                }
            } catch (JSONException e) {
                Log.e("JSON Parser", "Error creating the json object " + e.toString());
            }
            ratdialog.dismiss();
        }

        @Override
        protected String doInBackground(String... voids) {
            String result="";

            String connstr="http://stardigitalbikes.com/feedback.php";
//            String connstr="http://192.168.43.113/pdobikephp/fines_clear_pdo.php";
            try {
                URL url =new URL(connstr);
                HttpURLConnection http =(HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);


//                Log.d("PHONE NUMBER ISSH"," "+phonenum+" "+extrat+" "+bikeNumb+" "+fineCash);
                String str=String.valueOf(stars);
                OutputStream ops =http.getOutputStream();
                BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
                String data = URLEncoder.encode("surname","UTF-8")+"="+URLEncoder.encode(usname,"UTF-8")
                        +"&&"+ URLEncoder.encode("firstname","UTF-8")+"="+URLEncoder.encode(ufname,"UTF-8")
                        +"&&"+ URLEncoder.encode("phonenumber","UTF-8")+"="+URLEncoder.encode(uphone,"UTF-8")
                        +"&&"+ URLEncoder.encode("stars","UTF-8")+"="+URLEncoder.encode(str,"UTF-8")
                        +"&&"+ URLEncoder.encode("comment","UTF-8")+"="+URLEncoder.encode(feedbackmsg,"UTF-8");
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

//                        if(success==1){
//                            rentStatus=true;
//                            JSONArray userArray=jObj.getJSONArray("user");
//                            JSONObject user=userArray.getJSONObject(0);
//                            String bike=user.getString("BN");
//                            prefb=getSharedPreferences(prefName2,MODE_PRIVATE);
//                            SharedPreferences.Editor editor=prefb.edit();
//                            editor.putBoolean(RENT_BIKE_KEY,rentStatus);
//                            editor.putString(BIKE_NUMBER_KEY,bike);
//                            editor.commit();
//
//                        }else{
//                            rentStatus=false;
//                            prefb=getSharedPreferences(prefName2,MODE_PRIVATE);
//                            SharedPreferences.Editor editor=prefb.edit();
//                            editor.putBoolean(RENT_BIKE_KEY,rentStatus);
//                            editor.commit();
//                            Log.d("JSONStatus","Login failure");
//                            message=jObj.getString("message");
//                            Log.d("JSONStatus",message);
//                        }

                    }else{
                        Log.e("JSON Parser", "RETURNED JSON IS NULL ");
                        message=jObj.getString("message");
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

}
