package com.stardigitalbikes.samuelhimself.bible1;

import android.content.Intent;
import android.os.Handler;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RetryPolicy;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%55

import android.app.ProgressDialog;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

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

    // under this activity we need to create a listener that will keep checking if the user is verified or not
    com.stardigitalbikes.samuelhimself.bible1.Permissions permit=new com.stardigitalbikes.samuelhimself.bible1.Permissions();

    private Handler handler;
    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {


            if (permit.isUserVerified(Events.this)) {
                finish();
                startActivity(new Intent(Events.this, Instructions.class));
                Toast.makeText(Events.this, "Verification succeeded ", Toast.LENGTH_SHORT).show();

                // stop handler from updating
                handler.removeCallbacks(runnable);
            }

            handler.postDelayed(runnable, 1000); // keep checking after every one second
        }
    };
    EditText phoneNumber;
    String pnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        //  -------------toolbar---------
        Toolbar toolbar =findViewById(R.id.eventstoolbar);
        setSupportActionBar(toolbar);

        phoneNumber = findViewById(R.id.phonenumber55);
        Button sendNumber = (Button) findViewById(R.id.sendnumberat);


        handler = new Handler();
        handler.postDelayed(runnable, 1000);

        runnable.run();

        if (permit.isUserVerified(Events.this)) {
            finish();
            if (handler != null) {
                handler.removeCallbacks(runnable);
            }
            startActivity(new Intent(this, Instructions.class));
        }

        pnumber = "0774645196";// phoneNumber.getText().toString();
        sendNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("sxs", "verifying click "+pnumber);
                verifyPhoneNumber(pnumber);
//        Toast.makeText(getApplicationContext(),pnumber,Toast.LENGTH_SHORT).show();
            }
        });


    }


    private void verifyPhoneNumber(final String phoneNumber) {
        String url = "https://stardigitalbikes.com/africasTalking/smsverification.php";

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sending verification code...");
        Log.d("sms", "Sending verification code... ");
        progressDialog.setCancelable(false);
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                Log.d("sms", "response");

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                finish();
                Toast.makeText(Events.this, "network error!", Toast.LENGTH_SHORT).show();
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


        if (permit.isUserVerified(Events.this)) {
            if (handler != null) {
                handler.removeCallbacks(runnable);
            }
            finish();
            startActivity(new Intent(this, Instructions.class));
        }
    }
    int CONNECTION_TIME_OUT;
    public class MyRetryPolicyWithoutRetry implements RetryPolicy
    {
        @Override
        public int getCurrentTimeout()
        {
            return CONNECTION_TIME_OUT; /*200000*/
        }

        @Override
        public int getCurrentRetryCount()
        {
            return 0;
        }

        @Override
        public void retry(VolleyError error) throws VolleyError
        {
            throw(error);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
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
