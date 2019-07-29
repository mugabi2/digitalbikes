package com.stardigitalbikes.samuelhimself.bible1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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



public class passwordrecovery3 extends AppCompatActivity {
    static JSONObject jObjc = null;
    String serverKey="2y10f2Kkl1GRi5si0AAsgvsgJWyqXsUszC3DuvRLwZZ";
    static JSONObject jObj = null;
    static String json = "",message,emaill;
    EditText photext,cotex;

    private ProgressBar progBar;
    Button proceed;
    int suxes;
    String mesg,code,phone;

    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordrecovery3);

        Bundle extras=getIntent().getExtras();
        email=extras.getString("email");

        photext=findViewById(R.id.recphone1);
        cotex=findViewById(R.id.reccode1);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone =photext.getText().toString();
                code =cotex.getText().toString();
                new passwordrecovery3.backgroundrecover(passwordrecovery3.this).execute();

            }
        });

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
                if(json!=null){
                    suxes=jObj.getInt("success");
                    mesg=jObj.getString("message");

                    Log.d("JSONStatus","SAVED LOGIN PREFS SUCCESS");

                }else{
                    Log.e("JSON Parser", "RETURNED JSON IS NULL ");
                }
            } catch (JSONException e) {
                Log.e("JSON Parser", "Error creating the json object " + e.toString());
            }
            if(suxes==1){
                Toast.makeText(getApplicationContext(),mesg,Toast.LENGTH_LONG).show();
                Intent intr=new Intent(passwordrecovery3.this,passwordrecovery.class);
                intr.putExtra("phonenumber",phone);
                startActivity(intr);

            }else{
                Toast.makeText(getApplicationContext(),mesg,Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        protected String doInBackground(String... voids) {
            String result="";

            String phonenum=voids[0];
            String pass=voids[1];

            String connstr="http://stardigitalbikes.com/password_rec3.php";
//            String connstr="http://192.168.43.113/pdobikephp/password_rec3.php";

            try {
                URL url =new URL(connstr);
                HttpURLConnection http =(HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);


                OutputStream ops =http.getOutputStream();
                BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
                String data = URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")
                        +"&&"+ URLEncoder.encode("phonenumber","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")
                        +"&&"+ URLEncoder.encode("code","UTF-8")+"="+URLEncoder.encode(code,"UTF-8");

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
