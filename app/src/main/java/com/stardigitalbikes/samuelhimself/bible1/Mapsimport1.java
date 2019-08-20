package com.stardigitalbikes.samuelhimself.bible1;


import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

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
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


//impooiji


import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class Mapsimport1 extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        LocationListener, GoogleMap.InfoWindowAdapter, GoogleMap.OnInfoWindowClickListener {

//    just want to see this comment am telling you

//    this time i want to see this comment
    private ProgressBar progBar;
    private TextView text;
    private Handler mHandler = new Handler();
    private int mProgressStatus = 0;

    private SharedPreferences prefs, prefer;
    private String prefName = "preProfile";
    private String prefName2 = "preBike";

    String serverKey = "2y10f2Kkl1GRi5si0AAsgvsgJWyqXsUszC3DuvRLwZZ";
    String gearS;
    static JSONObject jObj = null;
    static String json = "", message;
    int availableBikes;

    private static final String SURNAME_KEY = "Surname";
    private static final String FIRST_NAME_KEY = "First Name";
    private static final String PHONE_NUMBER_KEY = "Phone Number";
    private static final String EMAIL_ADDRESS_KEY = "Email";
    private static final String RESIDENCE_KEY = "Residence";
    private static final String DIGITAL_TIME_KEY = "Digital Time";
    private static final String LOCATION_KEY ="Location";


    SharedPreferences prefb;
    private static final String BIKE_NUMBER_KEY = "Bike Number";
    private static final String RENT_BIKE_KEY = "Rent Bike";
    static final int rentPrice1 = 1500, rentPrice2 = 2000;
    int sente, yourTime, gear;
    String usname, ufname, uphone, umail, uresi, udura = "20", upaymeth, uagcode;
    Boolean rentStatus = false;

    private GoogleMap mMap;
    private GoogleApiClient client;
    double latitude, longitude;
    private Location lastlocation;
    private Marker currentLocationmMarker;
    Marker mCurrLocationMarker;
    private LocationRequest locationRequest;
    public static final int REQUEST_LOCATION_CODE = 99;
    private static final String TAG = Mapsimport1.class.getSimpleName();

    String pkafrica, pkcedat, pkcomplex, pkfema, pklibrary, pklivingstone, pklumumba, pkmaingate, pkmarystuart, pkmitchell, pknkrumah, pkuh;
    String pktpark,pknsibambi,pksabiiti,pkdhucu,pklibraryucu,pkpeggynoll,pkwandegenya,pkmaingateucu,pkbtucker;

    static JSONObject jObjc = null;
    static String jsone = "";
    String method,pkucu="2000 bikes",pkmubs="2500 bikes";

    String dura, duration = "20 minutes",ups;
    Dialog myDialog, updialog;



    String ditime;
    String paymentInt,location;
    int checkPm = 0, pmi, pmc = -1, pmd = -1, suckind, succfour, sucki;

    String returntime;

    TextView durationtext;
    SeekBar seekduration;
    int min = 0, max = 7, current = 0;

//    BOTTOM SHEET PRICE

    String ExternalFontPath;
    Typeface FontLoaderTypeface;
    BottomSheetBehavior mBottomSheetBehavior,mbottomSheetBehavior1;
    Button mButton1;
    ImageView downArrow;
    LinearLayout upBar;

    //    getting user location
    private FusedLocationProviderClient clientOruser;

    LatLng zooom;

    BottomSheetBehavior mBottomSheetBehaviour;


//    updates

    ImageView imagev;
    int connection=1;
    String allupdates,todaysmeassage;
    String[] imagenamesarray;

    ProgressBar pb1,pb2,pb3,pb4,pb5,pb6,pb7,pb8,pb9,pb10;
    CardView cd1,cd2,cd3,cd4,cd5,cd6,cd7,cd8,cd9,cd10;

    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "my_notification_channel";

    String notimessage;
    int notinumber;
    int version=0,newVersion;
    TextView reminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapsimport1);


        progBar= (ProgressBar)findViewById(R.id.pbmap);
        pogless();


        reminder=(TextView)findViewById(R.id.reminder1);

        //   Bundle extras=getIntent().getExtras();
//        Toast.makeText(getApplicationContext(),extras.getInt("money"),Toast.LENGTH_LONG).show();
        Bundle extras=getIntent().getExtras();
        String meso=extras.getString("bikesin");
        ups=meso;
        allupdates=meso;
//        String jsons = meso.toString();
        Log.e("POSE", meso);

        prefs=getSharedPreferences(prefName,MODE_PRIVATE);


//        ------------------------------------
////        BOTTOM SHEET PRICE

        View bottomSheet = findViewById(R.id.bottom_sheetid);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

//        TextView buttonShow = findViewById(R.id.expand1);
        LinearLayout buttonShow = findViewById(R.id.expand1);
        downArrow = findViewById(R.id.down_arrow1);
        upBar = findViewById(R.id.up_bar1);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {if(mBottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                downArrow.setVisibility(View.INVISIBLE);
                upBar.setVisibility(View.VISIBLE);
                new Mapsimport1.downloadimage().execute();

            }
            else {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                downArrow.setVisibility(View.VISIBLE);
                upBar.setVisibility(View.INVISIBLE);
            }
            }
        });
        ImageView shareimg=(ImageView)findViewById(R.id.imageshare);
        ImageView supimg=(ImageView)findViewById(R.id.imagesupport);
        ImageView instimg=(ImageView)findViewById(R.id.imageinst);

        shareimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mapsimport1.this, Promotions.class));
            }
        });

        instimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mapsimport1.this, Instructions.class));
            }
        });

        supimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mapsimport1.this, Support.class));
            }
        });

        View bottomSheete = findViewById(R.id.bottom_sheetid);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheete);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);


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

        myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.rent_bike_popup);

        prefs = getSharedPreferences(prefName, MODE_PRIVATE);

        TextView Tdt=(TextView)findViewById(R.id.textdigitaltime3);
        Tdt.append(prefs.getString(DIGITAL_TIME_KEY,"")+ " Hrs");


//        progBar= (ProgressBar)findViewById(R.id.progressBar2);

//        pogless();
        Toolbar toolbar=findViewById(R.id.mapsimporttoolbar);
        setSupportActionBar(toolbar);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        isNetworkConnected();
        if(client ==null){
            client = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API).build();
            client.connect();
        }


        usname=prefs.getString(SURNAME_KEY,"");
        ufname=prefs.getString(FIRST_NAME_KEY,"");
        uphone=prefs.getString(PHONE_NUMBER_KEY,"");
        umail=prefs.getString(EMAIL_ADDRESS_KEY,"");
        uresi=prefs.getString(RESIDENCE_KEY,"");
        location=prefs.getString(LOCATION_KEY,"");


//        udura=extras.getString("Duration");
//        upaymeth=extras.getString("Paymethod");

//        TextView Tprice=(TextView)findViewById(R.id.textViewpriceM);
//        Tprice.append(sente+" UGX");

//        TextView Tdurat=(TextView)findViewById(R.id.textViewdurationM);
//        Tdurat.append(udura);

        try {
            jObjc = new JSONObject(meso);
            succfour=jObjc.getInt("success");

            JSONArray userArray=jObjc.getJSONArray("user");
            JSONObject user=userArray.getJSONObject(0);
            pkafrica=user.getString("AF");
            pkcedat=user.getString("CD");
            pkcomplex=user.getString("IT");
            pkfema=user.getString("FM");
            pklibrary=user.getString("LB");
            pklivingstone=user.getString("LV");
            pklumumba=user.getString("LM");
            pkmaingate=user.getString("MG");
            pkmarystuart=user.getString("MS");
            pkmitchell=user.getString("MT");
            pknkrumah=user.getString("NK");
            pkuh=user.getString("UH");
            ditime=user.getString("DT");

            pktpark=user.getString("TP");
            pknsibambi=user.getString("NSI");
            pksabiiti=user.getString("SAB");
            pkdhucu=user.getString("DHU");
            pklibraryucu=user.getString("LBU");
            pkpeggynoll=user.getString("PNL");
            pkwandegenya=user.getString("WA");
            pkmaingateucu=user.getString("MGU");
            pkbtucker=user.getString("BT");
            todaysmeassage=user.getString("message");
            notinumber=user.getInt("NTN");
            notimessage=user.getString("NOTI");
            newVersion=user.getInt("VERS");

//            location=user.getString("PL");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.e("NTN MSG", notimessage);
        reminder.setVisibility(ProgressBar.VISIBLE);
        reminder.append(notimessage);

//        hss
//        BLOCKCHAIN oblock=new BLOCKCHAIN();
//        String nome="sam", samhash=oblock.MD5(nome);
//        Toast.makeText(getApplicationContext(), samhash, Toast.LENGTH_LONG).show();

//        NOTIFICATION IFF
            if(notinumber==0) {
//            Toast.makeText(getApplicationContext(), todaysmeassage, Toast.LENGTH_LONG).show();
        }else if(notinumber==1){
//        notification
            createNotificationChannel();
// Starts the notification below
            addNotification();
//            Toast.makeText(getApplicationContext(), todaysmeassage, Toast.LENGTH_LONG).show();
        }else if(notinumber==2&&version!=newVersion){
//            UPDATE OPTIONAL d88
                updialog = new Dialog(this);
                updialog.setContentView(R.layout.update_popup);

                showupdatePopup();
            }else   if(notinumber==3&&version!=newVersion){
//            UPDATE COMPULSURY
                updialog = new Dialog(this);
                updialog.setContentView(R.layout.update_popup);

                showupdatePopup();
            }


        switch (location){
            case "MUK":
//                zooom= new LatLng(0.331604, 32.zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz568423);
//                Toast.makeText(getApplicationContext(),"Makerere University",Toast.LENGTH_LONG).show();
                break;
            case "MUBS":
                zooom= new LatLng(0.111111, 20.568423);
//                Toast.makeText(getApplicationContext(),"Makerere Business School",Toast.LENGTH_LONG).show();
                break;
            case "UCU":
                zooom= new LatLng(0.355084, 32.740389);
//                Toast.makeText(getApplicationContext(),"Uganda Christian University",Toast.LENGTH_LONG).show();
                break;
        }

//        tool bar
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//
//        Menu m = menu.getMenu();
//        for (int i=0;i<m.size();i++) {
//            MenuItem mi = m.getItem(i);
//
//            SubMenu subMenu = mi.getSubMenu();
//            if (subMenu!=null && subMenu.size() >0 ) {
//                for (int j=0; j <subMenu.size();j++) {
//                    MenuItem subMenuItem = subMenu.getItem(j);
////                    applyFontToMenuItem(subMenuItem);
//                }
//            }
//            applyFontToMenuItem(mi);
//        }

//        WHETHER RENTED OR NOT

        if (succfour==4){
//            RENTED

            try {
                jObjc = new JSONObject(meso);
                JSONArray userArray=jObjc.getJSONArray("user");
                JSONObject user=userArray.getJSONObject(0);
                returntime=user.getString("TSR");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            reminder.setVisibility(ProgressBar.VISIBLE);
            reminder.append("Please select an agent and return bike by "+returntime);
        }else{

        }

//        save users digital tinme
        prefs=getSharedPreferences(prefName, MODE_PRIVATE);
        SharedPreferences.Editor editor=prefs.edit();
        editor.putString(DIGITAL_TIME_KEY, ditime);
        editor.commit();

//        String somet="some thing s";
//        TextView tdigit=findViewById(R.id.textditime2);
//        tdigit.append(somet);
    }

    //    creat notification channel

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void addNotification() {
        int prio=2;

//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)


        // Create an explicit intent for an Activity in your app
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_home11)
                .setContentTitle("Digital Bikes")
                .setContentText(notimessage)
                .setPriority(prio)
//                .setSound(R.raw.bbell1)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
        notificationManager.notify(NOTIFICATION_ID, mBuilder.build());


//
    }

    // Creates and displays a notification
//    private void addNotification() {
//        int prio=2;
//
////        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
//
//
//        // Create an explicit intent for an Activity in your app
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
//
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
////                .setSmallIcon(R.drawable.ic_home11)
//
////                .setSmallIcon(R.mipmap.gpicon1_round)
//                .setContentTitle("Digital Bikes")
//                .setContentText(notimessage)
//                .setPriority(prio)
////                .setSound(R.raw.bbell1)
//                .setContentIntent(pendingIntent)
//                .setAutoCancel(true);
//
//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
//
//// notificationId is a unique int for each notification that you must define
//        notificationManager.notify(NOTIFICATION_ID, mBuilder.build());
//
//
////
//    }



//    private void requestPermission(){
//        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION},1);
//    }


//    private void applyFontToMenuItem(MenuItem mi) {
//        Typeface font = Typeface.createFromAsset(getAssets(), "helvetica_roman.otf");
//        SpannableString mNewTitle = new SpannableString(mi.getTitle());
//        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        mi.setTitle(mNewTitle);
//    }

    public void bottomthings(View view){
        //        BOTTOM SHEET PRICE

//        TextView buttonShow = findViewById(R.id.expand1);
        downArrow = findViewById(R.id.down_arrow1);
        upBar = findViewById(R.id.up_bar1);

        if(mBottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                downArrow.setVisibility(View.INVISIBLE);
                upBar.setVisibility(View.VISIBLE);
            }
            else {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                downArrow.setVisibility(View.VISIBLE);
                upBar.setVisibility(View.INVISIBLE);
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.fresh_menu, menu);
        return true;
    }
    public void TACwebsite(View view){
        Intent browserIntent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://stardigitalbikes.com/terms_and_conditions.php"));
        startActivity(browserIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (item.getItemId()){
            case R.id.action_profile:
                startActivity(new Intent(Mapsimport1.this, Profile.class));
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
                startActivity(new Intent(Mapsimport1.this, SafetyTips.class));
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

    public  void goToPrice(View view){
        Button bproc=myDialog.findViewById(R.id.go_to_pickup_button);

//        ANIMATION
        Animation animation= AnimationUtils.loadAnimation(Mapsimport1.this,R.anim.bounce);
        bproc.startAnimation(animation);


        if (pmc==0) {//REQUEST DIGITAL TIME FROME HERE
            if(ditime.equals("00:00")&& pmc>0){
                Toast.makeText(getApplicationContext(), "You do not have digital time to spend", Toast.LENGTH_SHORT).show();
            }else{
                progBar.setVisibility(ProgressBar.VISIBLE);
                new backgroundrequest(Mapsimport1.this).execute(usname, ufname, uphone, umail, uresi, udura, paymentInt, uagcode);
                    Toast.makeText(getApplicationContext(), "requesting.......", Toast.LENGTH_LONG).show();
                    Log.d("JSONStatus", "requestING");
            }
        }else if (pmc>0){
//            if payment is digital time reequest directly
            progBar.setVisibility(ProgressBar.VISIBLE);
            new backgroundprice(Mapsimport1.this).execute();
            Toast.makeText(getApplicationContext(), "requesting.....", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "check the buttons...", Toast.LENGTH_LONG).show();
        }
    }

    public void onRadioButtonClickedPayment(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_cash12:
                if (checked){
//                    payment="cash";
                    paymentInt="1";
                    checkPm++;
                    pmc++;
                    pmd=0;
                    Log.d("checkStatus", "cash: "+pmc+"dtime: "+pmd);
                }
                break;
            case R.id.radio_digitime12:
                if (checked){
//                    payment="DT";
                    paymentInt="2";
                    checkPm++;
                    pmd++;
                    pmc=0;
                    Log.d("checkStatus", "cash: "+pmc+"dtime: "+pmd);

//                    Toast.makeText(getApplicationContext(), "Not yet available Coming soon", Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }

    public void pogless() {

        new Thread(new Runnable() {
            public void run() {
                final int presentage=0;
                while (mProgressStatus < 100) {
                    mProgressStatus += 5;
                    if(mProgressStatus==100){
                        mProgressStatus=0;
                    }
                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
//                            progBar.setProgress(mProgressStatus);
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode)
        {
            case REQUEST_LOCATION_CODE:
                if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    if(ContextCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) !=  PackageManager.PERMISSION_GRANTED)
                    {
                        if(client == null)
                        {
                            bulidGoogleApiClient();
                        }
//                        mMap.setMyLocationEnabled(true);
                    }
                }
                else
                {
                    Toast.makeText(this,"Permission Denied" , Toast.LENGTH_LONG).show();
                }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setInfoWindowAdapter(this);
        mMap.setOnInfoWindowClickListener(this);
        final List<MarkerOptions> markers = new ArrayList<>();

//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            bulidGoogleApiClient();
//            mMap.setMyLocationEnabled(true);
//        }

        LatLng africa = new LatLng(0.337912, 32.568790);
        MarkerOptions af = new MarkerOptions().position(africa).title("Africa").snippet(pkafrica)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
        switch (pkafrica){
            case "0 bikes":
                mMap.addMarker(af);
                break;
            default:
                if (location.equals("MUK")&&
                        !(pkafrica.equals("0 bikes"))){
                    mMap.addMarker(af).showInfoWindow();
                }
                break;
        }
        markers.add(af);

        LatLng cedat = new LatLng(0.335882, 32.564807);
        MarkerOptions cd = new MarkerOptions().position(cedat).title("CEDAT").snippet(pkcedat)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
        switch (pkcedat){
            case "0 bikes":
                mMap.addMarker(cd);
                break;
            default:
                if (location.equals("MUK")&&
                        !(pkcedat.equals("0 bikes"))){
                    mMap.addMarker(cd).showInfoWindow();
                }
                break;
        }
        markers.add(cd);

        LatLng complex = new LatLng(0.329849, 32.570160);
        MarkerOptions it = new MarkerOptions().position(complex).title("Complex").snippet(pkcomplex)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
        switch (pkcomplex){
            case "0 bikes":
                mMap.addMarker(it);
                break;
            default:
                if (location.equals("MUK")&&
                        !(pkcomplex.equals("0 bikes"))){
                    mMap.addMarker(it).showInfoWindow();
                }
                break;
        }
        markers.add(it);

        LatLng fema = new LatLng(0.335345, 32.568673);
        MarkerOptions fm = new MarkerOptions().position(fema).title("FEMA").snippet(pkfema)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
        switch (pkfema){
            case "0 bikes":
                mMap.addMarker(fm);
                break;
            default:
                if (location.equals("MUK")&&
                        !(pkfema.equals("0 bikes"))){
                    mMap.addMarker(fm).showInfoWindow();
                }
                break;
        }
        markers.add(fm);

        LatLng library = new LatLng(0.334936, 32.568000);
        MarkerOptions lb = new MarkerOptions().position(library).title("Library").snippet(pklibrary)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
        switch (pklibrary){
            case "0 bikes":
                mMap.addMarker(lb);
                break;
            default:
                if (location.equals("MUK")&&
                        !(pklibrary.equals("0 bikes"))){
                    mMap.addMarker(lb).showInfoWindow();
                }
                break;
        }
        markers.add(lb);
//zzzzzzzzzzzzzzzoooooooooooooooooooommmmmmmmmmmmmmmmmmmmmmm
//       THESE(ZOOM VARIABLES) WILL BE TURNED INTO VARIABLES E.G FREEDOM
//        USE THE LOCATION OF THE USER TO DETERMINE
//                  1***WHERE TO ZOOM IN
//                  2***WHICH MARKER TO OPEN WITH
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(0.331604, 32.568423),15));


        LatLng livingstone = new LatLng(0.338686, 32.567718);
        MarkerOptions lv = new MarkerOptions().position(livingstone).title("Livingstone").snippet(pklivingstone)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
        switch (pklivingstone){
            case "0 bikes":
                mMap.addMarker(lv);
                break;
            default:
                if (location.equals("MUK")&&
                        !(pklivingstone.equals("0 bikes"))){
                    mMap.addMarker(lv).showInfoWindow();
                }
                break;
        }
        markers.add(lv);

        LatLng lumumba = new LatLng(0.331717, 32.566073);
        MarkerOptions lm = new MarkerOptions().position(lumumba).title("Lumumba").snippet(pklumumba)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
        switch (pklumumba){
            case "0 bikes":
                mMap.addMarker(lm);
                break;
            default:
                if (location.equals("MUK")&&
                        !(pklumumba.equals("0 bikes"))){
                    mMap.addMarker(lm).showInfoWindow();
                }
                break;
        }
        markers.add(lm);

        LatLng maingate = new LatLng(0.329760, 32.570937);
        MarkerOptions mg = new MarkerOptions().position(maingate).title("Main Gate").snippet(pkmaingate)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
        switch (pkmaingate){
            case "0 bikes":
                mMap.addMarker(mg);
                break;
            default:
                if (location.equals("MUK")&&
                        !(pkmaingate.equals("0 bikes"))){
                    mMap.addMarker(mg).showInfoWindow();
                }
                break;
        }
        markers.add(mg);

        LatLng marystuart = new LatLng(0.330985, 32.566668);
        MarkerOptions ms = new MarkerOptions().position(marystuart).title("Marystuart").snippet(pkmarystuart)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
        switch (pkmarystuart){
            case "0 bikes":
                mMap.addMarker(ms);
                break;
                default:
                    if (location.equals("MUK")&&
                            !(pkmarystuart.equals("0 bikes"))){
                    mMap.addMarker(ms).showInfoWindow();
                    }
                    break;
        }
        markers.add(ms);

        LatLng mitchell = new LatLng(0.333740, 32.570495);
        MarkerOptions mt = new MarkerOptions().position(mitchell).title("Mitchell").snippet(pkmitchell)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
        switch (pkmitchell){
            case "0 bikes":
                mMap.addMarker(mt);
                break;
            default:
                if (location.equals("MUK")&&
                        !(pkmitchell.equals("0 bikes"))){
                    mMap.addMarker(mt).showInfoWindow();
                }
                break;
        }
        markers.add(mt);

        LatLng nkrumah = new LatLng(0.336454, 32.569008);
        MarkerOptions nk = new MarkerOptions().position(nkrumah).title("Nkrumah").snippet(pknkrumah)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
        switch (pknkrumah){
            case "0 bikes":
                mMap.addMarker(nk);
                break;
            default:
                if (location.equals("MUK")&&
                        !(pknkrumah.equals("0 bikes"))){
                    mMap.addMarker(nk).showInfoWindow();
                }
                break;
        }
        markers.add(nk);

        LatLng uh = new LatLng(0.332969, 32.572506);
        MarkerOptions u = new MarkerOptions().position(uh).title("University Hall").snippet(pkuh)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
        switch (pkuh){
            case "0 bikes":
                mMap.addMarker(u);
                break;
            default:
                if (location.equals("MUK")&&
                        !(pkuh.equals("0 bikes"))){
                    mMap.addMarker(u).showInfoWindow();
                }
                break;
        }
        markers.add(u);

////        MUBS
//        LatLng mubs = new LatLng(0.111111, 20.568423);
//        MarkerOptions mbs = new MarkerOptions().position(mubs).title("MUBS").snippet(pkmubs)
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
//        switch (pkmubs){
//            case "0 bikes":
//                mMap.addMarker(mbs);
//                break;
//            default:
//                if (//location.equals("MUBS")&&
//                        !(pkmubs.equals("0 bikes"))){
//                    mMap.addMarker(mbs).showInfoWindow();
//                }
//                break;
//        }
//        markers.add(mbs);

//UCU
//        LatLng tecp =new LatLng(0.351707, 32.738754);
//        MarkerOptions tp = new MarkerOptions().position(tecp).title("Tech Park").snippet(pktpark)
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
//        switch (pktpark){
//            case "0 bikes":
//                mMap.addMarker(tp);
//                break;
//            default:
//                if (//location.equals("UCU")&&
//                        !(pktpark.equals("0 bikes"))){
//                    mMap.addMarker(tp).showInfoWindow();
//                }
//                break;
//        }
//        markers.add(tp);
//
//        LatLng ns =new LatLng(0.352226, 32.740383);
//        MarkerOptions nsi = new MarkerOptions().position(ns).title("Nsibambi").snippet(pknsibambi)
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
//        switch (pknsibambi){
//            case "0 bikes":
//                mMap.addMarker(nsi);
//                break;
//            default:
//                if (//location.equals("UCU")&&
//                        !(pknsibambi.equals("0 bikes"))){
//                    mMap.addMarker(nsi).showInfoWindow();
//                }
//                break;
//        }
//        markers.add(nsi);
//
//        LatLng sab =new LatLng(0.353058, 32.740449);
//        MarkerOptions sb = new MarkerOptions().position(sab).title("Sabiiti").snippet(pksabiiti)
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
//        switch (pksabiiti){
//            case "0 bikes":
//                mMap.addMarker(sb);
//                break;
//            default:
//                if (//location.equals("UCU")&&
//                        !(pksabiiti.equals("0 bikes"))){
//                    mMap.addMarker(sb).showInfoWindow();
//                }
//                break;
//        }
//        markers.add(sb);
//
//        LatLng dhucu =new LatLng(0.353763, 32.740129);
//        MarkerOptions dhu = new MarkerOptions().position(dhucu).title("Dinning Hall").snippet(pkdhucu)
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
//        switch (pkdhucu){
//            case "0 bikes":
//                mMap.addMarker(dhu);
//                break;
//            default:
//                if (//location.equals("UCU")&&
//                        !(pkdhucu.equals("0 bikes"))){
//                    mMap.addMarker(dhu).showInfoWindow();
//                }
//                break;
//        }
//        markers.add(dhu);
//
//        LatLng lbucu =new LatLng(0.355084, 32.740389);
//        MarkerOptions lbu = new MarkerOptions().position(lbucu).title("Library").snippet(pklibraryucu)
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
//        switch (pklibraryucu){
//            case "0 bikes":
//                mMap.addMarker(lbu);
//                break;
//            default:
//                if (//location.equals("UCU")&&
//                        !(pklibraryucu.equals("0 bikes"))){
//                    mMap.addMarker(lbu).showInfoWindow();
//                }
//                break;
//        }
//        markers.add(lbu);
//
//        LatLng pnol =new LatLng(0.355605, 32.741194);
//        MarkerOptions pn = new MarkerOptions().position(pnol).title("Peggy Noll").snippet(pkpeggynoll)
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
//        switch (pkpeggynoll){
//            case "0 bikes":
//                mMap.addMarker(pn);
//                break;
//            default:
//                if (//location.equals("UCU")&&
//                        !(pkpeggynoll.equals("0 bikes"))){
//                    mMap.addMarker(pn).showInfoWindow();
//                }
//                break;
//        }
//        markers.add(pn);
//
//        LatLng wand =new LatLng(0.358371, 32.740854);
//        MarkerOptions wd = new MarkerOptions().position(wand).title("Wandegeya").snippet(pkwandegenya)
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
//        switch (pkwandegenya){
//            case "0 bikes":
//                mMap.addMarker(wd);
//                break;
//            default:
//                if (//location.equals("UCU")&&
//                        !(pkwandegenya.equals("0 bikes"))){
//                    mMap.addMarker(wd).showInfoWindow();
//                }
//                break;
//        }
//        markers.add(wd);
//
//        LatLng mgucu =new LatLng(0.355243, 32.739315);
//        MarkerOptions mgu = new MarkerOptions().position(mgucu).title("Main Gate").snippet(pkmaingateucu)
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
//        switch (pkmaingateucu){
//            case "0 bikes":
//                mMap.addMarker(mgu);
//                break;
//            default:
//                if (//location.equals("UCU")&&
//                        !(pkmaingateucu.equals("0 bikes"))){
//                    mMap.addMarker(mgu).showInfoWindow();
//                }
//                break;
//        }
//        markers.add(mgu);
//
//        LatLng btuck =new LatLng(0.357406, 32.742002);
//        MarkerOptions bta = new MarkerOptions().position(btuck).title("Bishop Tucker").snippet(pkbtucker)
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconnew1));
//        switch (pkbtucker){
//            case "0 bikes":
//                mMap.addMarker(bta);
//                break;
//            default:
//                if (//location.equals("UCU")&&
//                        !(pkbtucker.equals("0 bikes"))){
//                    mMap.addMarker(bta).showInfoWindow();
//                }
//                break;
//        }
//        markers.add(bta);



        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
//                Intent intent = new Intent(Mapsimport1.this, Price.class);
//                intent.putExtra("marker", marker.getTitle());
//                startActivity(intent);
                String selected=marker.getTitle();

                switch (selected){
                    case "Africa":
                        if (pkafrica.equals("0 bikes")){}else if (pkafrica.equals("Agent Available")){availableBikes=2;}else {availableBikes=1;}
                        uagcode="1";
                        break;
                    case "CEDAT":
                        if (pkcedat.equals("0 bikes")){}else if (pkcedat.equals("Agent Available")){availableBikes=2;}else {availableBikes=1;}
                        uagcode="2";
                        break;
                    case "Complex":
                        if (pkcomplex.equals("0 bikes")){}else if (pkcomplex.equals("Agent Available")){availableBikes=2;}else {availableBikes=1;}
                        uagcode="3";
                        break;
                    case "FEMA":
                        if (pkfema.equals("0 bikes")){}else if (pkfema.equals("Agent Available")){availableBikes=2;}else {availableBikes=1;}
                        uagcode="4";
                        break;
                    case "Library":
                        if (pklibrary.equals("0 bikes")){}else if (pklibrary.equals("Agent Available")){availableBikes=2;}else {availableBikes=1;}
                        uagcode="5";
                        break;
                    case "Livingstone":
                        if (pklivingstone.equals("0 bikes")){}else if (pklivingstone.equals("Agent Available")){availableBikes=2;}else {availableBikes=1;}
                        uagcode="6";
                        break;
                    case "Lumumba":
                        if (pklumumba.equals("0 bikes")){}else if (pklumumba.equals("Agent Available")){availableBikes=2;}else {availableBikes=1;}
                        uagcode="7";
                        break;
                    case "Main Gate":
                        if (pkmaingate.equals("0 bikes")){}else if (pkmaingate.equals("Agent Available")){availableBikes=2;}else {availableBikes=1;}
                        uagcode="8";
                        break;
                    case "Marystuart":
                        if (pkmarystuart.equals("0 bikes")){}else if (pkmarystuart.equals("Agent Available")){availableBikes=2;}else {availableBikes=1;}
                        uagcode="9";
                        break;
                    case "Mitchell":
                        if (pkmitchell.equals("0 bikes")){}else if (pkmitchell.equals("Agent Available")){availableBikes=2;}else {availableBikes=1;}
                        uagcode="10";
                        break;
                    case "Nkrumah":
                        if (pknkrumah.equals("0 bikes")){}else if (pknkrumah.equals("Agent Available")){availableBikes=2;}else {availableBikes=1;}
                        uagcode="11";
                        break;
                    case "University Hall":
                        if (pkuh.equals("0 bikes")){}else if (pkuh.equals("Agent Available")){availableBikes=2;}else {availableBikes=1;}
                        uagcode="12";
                        break;
                }

                if(availableBikes==1) {
                    showPopup();
//                    new backgroundrequest(Mapsimport1.this).execute(usname, ufname, uphone, umail, uresi, udura, upaymeth, uagcode);
//                    ProgressBar pb =findViewById(R.id.progressBar2);
//                    pb.setVisibility(ProgressBar.VISIBLE);
//                    Toast.makeText(getApplicationContext(), "requesting.......", Toast.LENGTH_SHORT).show();
//                    Log.d("JSONStatus", "requestING");
                }else if(availableBikes==2){
//                    REQUESZT BIKE RETURN
                    progBar.setVisibility(ProgressBar.VISIBLE);
                    Toast.makeText(getApplicationContext(), "requesting.....", Toast.LENGTH_LONG).show();
                returnBike(uagcode);
                }else {
                    Toast.makeText(getApplicationContext(), "no bikes available at "+selected, Toast.LENGTH_SHORT).show();}
            }
        });

//        ApplicationService applicationService = new ApplicationService(Mapsimport1.this);
//        final Location newlocation = applicationService.getLocation(LocationManager.NETWORK_PROVIDER);
//        if (newlocation != null && isNetworkConnected()) {
//
//            double latitude = newlocation.getLatitude();
//            double longitude = newlocation.getLongitude();
//            final LatLng latLng = new LatLng(latitude, longitude);
//            if (mCurrLocationMarker != null) {
//                mCurrLocationMarker.setPosition(latLng);
//            } else {
//
//            }



//            Button findparkspot = findViewById(R.id.findbikepoint);
//            findparkspot.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    try {
//                        float mindist = 0;
//                        int pos = 0;
//                        for (int i = 0; i < markers.size(); i++) {
//                            Double slatlng1 = markers.get(i).getPosition().latitude;
//                            Double slatlng2 = markers.get(i).getPosition().longitude;
//                            LatLng lat = new LatLng(slatlng1, slatlng2);
//
//                            float[] distance = new float[1];
//
//                            Location.distanceBetween(newlocation.getLatitude(), newlocation.getLongitude(), slatlng1, slatlng2, distance);
//                            if (i == 0)
//                                mindist = distance[0];
//                            else if (mindist > distance[0]) {
//                                mindist = distance[0];
//                                pos = i;
//                            }
//                        }
//
//                        Toast.makeText(Mapsimport1.this, "Closest Parking Spot: " + markers.get(pos).getTitle(), Toast.LENGTH_LONG).show();
//                        CameraPosition myPosition = new CameraPosition.Builder()
//                                .target(markers.get(pos).getPosition()).zoom(14).bearing(90).tilt(30).build();
//                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(myPosition));
//
//                        String url = getDirectionsUrl(latLng, markers.get(pos).getPosition());
//                        DownloadTask downloadTask = new DownloadTask();
//
//                        // Start downloading json data from Google Directions API
//                        downloadTask.execute(url);
//
//                    } catch (Exception e) {
//
//                    }
//                }
//            });
//        }

    }

    class backgroundrequest extends AsyncTask<String, Void,String> {
        AlertDialog dialog;
        Context context;
        public backgroundrequest(Context context){
            this.context=context;

        }

        @Override
        protected void onPreExecute() {
            dialog= new AlertDialog.Builder(context).create();
            dialog.setTitle("Bike renting status");
        }

        @Override
        protected void onPostExecute(String s) {
            json = s.toString();
            prefb=getSharedPreferences(prefName2,MODE_PRIVATE);
//            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();

            progBar.setVisibility(ProgressBar.INVISIBLE);

            try {
                jObj = new JSONObject(json);
                  int  success = jObj.getInt("success");

                switch (success){
                    case 0:
                        break;
                    case 4:
                        Intent int1 =new Intent(getApplicationContext(),Mapsimport1.class);
                        int1.putExtra("bikesin",s);
                        startActivity(int1);
                        break;
                    case 2:
                        Intent int2 =new Intent(getApplicationContext(),fine.class);
                        int2.putExtra("fines",s);
                        startActivity(int2);
                        break;
                    case 3:
                        Intent int3 =new Intent(getApplicationContext(),finalRegistration.class);
                        startActivity(int3);
                        break;
                }
            } catch (JSONException e) {
                Log.e("JSON Parser", "Error creating the json object " + e.toString());
            }
        }

        @Override
        protected String doInBackground(String... voids) {
            String result="";
            String sname =voids[0];
            String fname= voids[1];
            String phonenum=voids[2];
            String mail=voids[3];
            String residence=voids[4];
            String durat=voids[5];
            String payM=voids[6];
            String acode=voids[7];
//            String geary1=voids[8];


            String connstr="http://stardigitalbikes.com/bike_request_pdo.php";
//            String connstr="http://192.168.43.113/pdobikephp/bike_request_pdo.php";
            try {
                URL url =new URL(connstr);
                HttpURLConnection http =(HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);


                OutputStream ops =http.getOutputStream();
                BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
                String data = URLEncoder.encode("surname","UTF-8")+"="+URLEncoder.encode(sname,"UTF-8")
                        +"&&"+ URLEncoder.encode("firstname","UTF-8")+"="+URLEncoder.encode(fname,"UTF-8")
                        +"&&"+ URLEncoder.encode("phonenumber","UTF-8")+"="+URLEncoder.encode(phonenum,"UTF-8")
                        +"&&"+ URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(mail,"UTF-8")
                        +"&&"+ URLEncoder.encode("residence","UTF-8")+"="+URLEncoder.encode(residence,"UTF-8")
                        +"&&"+ URLEncoder.encode("duration","UTF-8")+"="+URLEncoder.encode(udura,"UTF-8")
//                        +"&&"+ URLEncoder.encode("durationInt","UTF-8")+"="+URLEncoder.encode(dura,"UTF-8")
                        +"&&"+ URLEncoder.encode("payment_method","UTF-8")+"="+URLEncoder.encode(payM,"UTF-8")
//                        +"&&"+ URLEncoder.encode("gear","UTF-8")+"="+URLEncoder.encode(geary1,"UTF-8")
                        +"&&"+ URLEncoder.encode("agent_code","UTF-8")+"="+URLEncoder.encode(acode,"UTF-8")
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
                        rentStatus=false;
                        prefb=getSharedPreferences(prefName2,MODE_PRIVATE);
                        SharedPreferences.Editor editor=prefb.edit();
                        editor.putBoolean(RENT_BIKE_KEY,rentStatus);
                        editor.commit();
                        Log.e("JSON Parser", "RETURNED JSON IS NULL ");
                        message=jObj.getString("message");
                    }
                } catch (JSONException e) {
                    rentStatus=false;
                    prefb=getSharedPreferences(prefName2,MODE_PRIVATE);
                    SharedPreferences.Editor editor=prefb.edit();
                    editor.putBoolean(RENT_BIKE_KEY,rentStatus);
                    editor.commit();
                    Log.e("JSON Parser", "Error creating the json object " + e.toString());

                }
//##################################################################33
                http.disconnect();
                return result;

            } catch (MalformedURLException e) {
                rentStatus=false;
                prefb=getSharedPreferences(prefName2,MODE_PRIVATE);
                SharedPreferences.Editor editor=prefb.edit();
                editor.putBoolean(RENT_BIKE_KEY,rentStatus);
                editor.commit();
                Log.d("JSON Exception",e.toString());
                result =e.getMessage();
            } catch (ProtocolException e) {
                rentStatus=false;
                prefb=getSharedPreferences(prefName2,MODE_PRIVATE);
                SharedPreferences.Editor editor=prefb.edit();
                editor.putBoolean(RENT_BIKE_KEY,rentStatus);
                editor.commit();
                Log.d("JSON Exception",e.toString());
                result =e.getMessage();
            } catch (IOException e) {
                rentStatus=false;
                prefb=getSharedPreferences(prefName2,MODE_PRIVATE);
                SharedPreferences.Editor editor=prefb.edit();
                editor.putBoolean(RENT_BIKE_KEY,rentStatus);
                editor.commit();
                Log.d("JSON Exception",e.toString());
                result =e.getMessage();
            }

            return result;
        }
    }

    private void bulidGoogleApiClient() {
        client = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
        client.connect();
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        // test for connection
        if (cm.getActiveNetworkInfo() != null
                && cm.getActiveNetworkInfo().isAvailable()
                && cm.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            Log.v(TAG, "Internet Connection Not Present");
            return false;
        }
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {
        client.connect();

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
//d89
    public void showupdatePopup() {
        Button cancel,updatelink;
        TextView upmsg;

        upmsg=updialog.findViewById(R.id.upmsgtext);
        upmsg.setText("New version availabe, please update");

        cancel=updialog.findViewById(R.id.cancelbuttonuppopup);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updialog.dismiss();
            }
        });

        updatelink=updialog.findViewById(R.id.updatebuttonpopup);
        updatelink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=com.stardigitalbikes.samuelhimself.bible1"));
                startActivity(browserIntent);
            }
        });

        updialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        updialog.setCancelable(false);

        if(notinumber==2){
//            UPDATE OPTIONAL
            updialog.setCancelable(true);
        }else   if(notinumber==3){
//            UPDATE COMPULSURY
            cancel.setVisibility(View.INVISIBLE);
            updialog.setCancelable(false);
        }

        updialog.show();
    }

    public void showPopup() {
        ImageView closePopup;
        closePopup =(ImageView) myDialog.findViewById(R.id.close_popup);
        closePopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        RadioButton radi=(RadioButton)myDialog.findViewById(R.id.radio_digitime12);
        radi.setText("Digital Time("+ditime+")");

        durationtext =(TextView)myDialog.findViewById(R.id.duration1);
        seekduration =(SeekBar)myDialog.findViewById(R.id.seekbar1);

        seekduration.setMax(max-min);
        seekduration.setProgress(current-min);
        duration="20 minutes";
        durationtext.setText(duration);

        seekduration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                current=progress+min;

                switch (current){
                    case 0:
                        udura="20";
                        duration="20 minutes";
                        durationtext.setText(duration);
                        break;
                    case 1:
                        udura="1";
                        duration="1 hour";
                        durationtext.setText(duration);
                        break;
                    case 2:
                        udura="2";
                        duration="2 hours";
                        durationtext.setText(duration);
                        break;
                    case 3:
                        udura="3";
                        duration="3 hours";
                        durationtext.setText(duration);
                        break;
                    case 4:
                        udura="4";
                        duration="4 hours";
                        durationtext.setText(duration);
                        break;
                    case 5:
                        udura="5";
                        duration="5 hours";
                        durationtext.setText(duration);
                        break;
                    case 6:
                        udura="6";
                        duration="Half day";
                        durationtext.setText(duration);
                        break;
                    case 7:
                        udura="12";
                        duration="Full day";
                        durationtext.setText(duration);
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        myDialog.show();
    }

    class backgroundprice extends AsyncTask<String, Void,String> {

        AlertDialog dialog;
        Context context;
        public backgroundprice(Context context){
            this.context=context;
        }

        @Override
        protected void onPreExecute() {
//            dialog= new AlertDialog.Builder(context).create();
//            dialog.setTitle("login status");
        }

        @Override
        protected void onPostExecute(String s) {
//            dialog.setMessage(s);
//            dialog.show();
//            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
//            Toast.makeText(getApplicationContext(),"cash: "+pmc+"dt: "+pmd,Toast.LENGTH_LONG).show();

            progBar.setVisibility(ProgressBar.INVISIBLE);

            try {
                jObjc = new JSONObject(s);
                suckind=jObjc.getInt("success");

            } catch (JSONException e) {
                e.printStackTrace();
            }
            switch (suckind) {
                case 0:
                    Toast.makeText(getApplicationContext(),"Not connected!",Toast.LENGTH_LONG).show();
                    break;
                case 1:
                Intent intent = new Intent(Mapsimport1.this, Price1.class);
                intent.putExtra("all", s);
                intent.putExtra("duration", udura);
                intent.putExtra("agent", uagcode);
                startActivity(intent);
                break;
                case 2:
                    Intent int3 =new Intent(getApplicationContext(),fine.class);
                    int3.putExtra("fines",s);
                    startActivity(int3);
                    break;
                case 3:
                    Intent int2 = new Intent(Mapsimport1.this, finalRegistration.class);
                    startActivity(int2);
                    break;
            }
        }

        @Override
        protected String doInBackground(String... voids) {
            String result="";
            String geary;

//            String acode=voids[0];


            String connstr="http://stardigitalbikes.com/price_pdo.php";
//            String connstr="http://192.168.43.113/pdobikephp/price_pdo.php";

            try {
                URL url =new URL(connstr);
                HttpURLConnection http =(HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);

                OutputStream ops =http.getOutputStream();
                BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
                String data = URLEncoder.encode("serverKey","UTF-8")+"="+URLEncoder.encode(serverKey,"UTF-8")
                        +"&&"+ URLEncoder.encode("duration","UTF-8")+"="+URLEncoder.encode(udura,"UTF-8")
                        +"&&"+ URLEncoder.encode("durationstring","UTF-8")+"="+URLEncoder.encode(duration,"UTF-8")
                        +"&&"+ URLEncoder.encode("phonenumber","UTF-8")+"="+URLEncoder.encode(uphone,"UTF-8")
                        +"&&"+ URLEncoder.encode("agent_code","UTF-8")+"="+URLEncoder.encode(uagcode,"UTF-8");

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

    public void returnBike(String Acodey){

//        ProgressBar pb =findViewById(R.id.progressBar5);
//        pb.setVisibility(ProgressBar.VISIBLE);
        new Mapsimport1.backgroundReturn(this).execute(Acodey);
        Toast.makeText(getApplicationContext(), "Requesting....", Toast.LENGTH_SHORT).show();
        Log.d("Request status","GOOD INPUT am gonna make the request");

    }

    class backgroundReturn extends AsyncTask<String, Void,String> {
        AlertDialog dialog;
        Context context;

        public backgroundReturn(Context context){
            this.context=context;
        }

        @Override
        protected void onPreExecute() {
            dialog= new AlertDialog.Builder(context).create();
            dialog.setTitle("Bike return status");
        }

        @Override
        protected void onPostExecute(String s) {
            String jjon = s.toString();
            prefb=getSharedPreferences(prefName2,MODE_PRIVATE);
//            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();

            Log.d("JSON RETUTN",s);

            try {
                jObjc = new JSONObject(s);
                sucki=jObjc.getInt("success");

            } catch (JSONException e) {
                e.printStackTrace();
            }
            switch (sucki) {
                case 0:
                    Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                    break;
                case 1:
                    Intent int11 = new Intent(Mapsimport1.this, Mapsimport1.class);
                    int11.putExtra("bikesin", s);
                    startActivity(int11);
                    break;
                case 2:
                    Intent int22 =new Intent(getApplicationContext(),fine.class);
                    int22.putExtra("fines",s);
                    startActivity(int22);
                    break;
                case 3:
                    Intent int33 = new Intent(Mapsimport1.this, finalRegistration.class);
                    startActivity(int33);
                    break;
            }

        }
        public void onBackPressed(){
            moveTaskToBack(true);
        }
        @Override
        protected String doInBackground(String... voids) {
            String result="";
            String AgCode =voids[0];

            String connstr="http://stardigitalbikes.com/bike_return_pdo.php";
//            String connstr="http://192.168.43.113/pdobikephp/bike_return_pdo.php";


            prefb=getSharedPreferences(prefName2,MODE_PRIVATE);
            String bikey=prefb.getString(BIKE_NUMBER_KEY,"");
            SharedPreferences.Editor editor=prefb.edit();

            prefer=getSharedPreferences(prefName,MODE_PRIVATE);
            String Usurname=prefer.getString(SURNAME_KEY,""),
            Ufirstname=prefer.getString(FIRST_NAME_KEY,""),
            Uphone=prefer.getString(PHONE_NUMBER_KEY,""),
            Uemail=prefer.getString(EMAIL_ADDRESS_KEY,""),
            Uresidence=prefer.getString(RESIDENCE_KEY,"");


            try {
                URL url =new URL(connstr);
                HttpURLConnection http =(HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);


                OutputStream ops =http.getOutputStream();
                BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
                String data = URLEncoder.encode("agent_code","UTF-8")+"="+URLEncoder.encode(AgCode,"UTF-8")
                        +"&&"+ URLEncoder.encode("surname","UTF-8")+"="+URLEncoder.encode(Usurname,"UTF-8")
                        +"&&"+ URLEncoder.encode("firstname","UTF-8")+"="+URLEncoder.encode(Ufirstname,"UTF-8")
                        +"&&"+ URLEncoder.encode("phonenumber","UTF-8")+"="+URLEncoder.encode(Uphone,"UTF-8")
                        +"&&"+ URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(Uemail,"UTF-8")
                        +"&&"+ URLEncoder.encode("bikenumber","UTF-8")+"="+URLEncoder.encode(bikey,"UTF-8")
                        +"&&"+ URLEncoder.encode("residence","UTF-8")+"="+URLEncoder.encode(Uresidence,"UTF-8")
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

                        Log.d("JSONStatus", "JSON RETURNED");

                        if(success==1){
                            editor.clear().commit();
                            rentStatus=false;
                            editor.putBoolean(RENT_BIKE_KEY,rentStatus);
                            message=jObj.getString("message");
                            editor.commit();

                        }else{
                            rentStatus=true;
                            editor.putBoolean(RENT_BIKE_KEY,rentStatus);
                            editor.commit();
                            Log.d("JSONStatus","Login failure");
                            message=jObj.getString("message");
                            Log.d("JSONStatus",message);
                        }
                    }else{
                        rentStatus=true;
                        editor.putBoolean(RENT_BIKE_KEY,rentStatus);
                        editor.commit();
                        Log.e("JSON Parser", "RETURNED JSON IS NULL ");
                    }
                } catch (JSONException e) {
                    rentStatus=true;
                    editor.putBoolean(RENT_BIKE_KEY,rentStatus);
                    editor.commit();
                    Log.e("JSON Parser", "Error creating the json object " + e.toString());
                }
//##################################################################33
                http.disconnect();
                return result;

            } catch (MalformedURLException e) {
                rentStatus=true;
                editor.putBoolean(RENT_BIKE_KEY,rentStatus);
                editor.commit();
                Log.d("JSON Exception",e.toString());
                result =e.getMessage();
            } catch (ProtocolException e) {
                rentStatus=true;
                editor.putBoolean(RENT_BIKE_KEY,rentStatus);
                editor.commit();
                Log.d("JSON Exception",e.toString());
                result =e.getMessage();
            } catch (IOException e) {
                rentStatus=true;
                editor.putBoolean(RENT_BIKE_KEY,rentStatus);
                editor.commit();
                Log.d("JSON Exception",e.toString());
                result =e.getMessage();
            }

            return result;
        }


    }

    public void onBackPressed(){
        moveTaskToBack(true);
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

//            GETTING THE MAXIMUM NUMBER OF UPDATES
            try {
                jObjc = new JSONObject(allupdates);

                JSONArray userArray=jObjc.getJSONArray("user");
                JSONObject user=userArray.getJSONObject(0);
                max=user.getInt("UT");
                Log.d("UPDATES", "in the array");


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
                        Log.d("UPDATES", "FOR THE UPDATES");

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

                        itembit= BitmapFactory.decodeStream((InputStream) connection.getContent(), null, null);
                        bitmapArray.add(itembit);//ADD BITMAP TO ARRAY

                        Log.d("UPDATES", "CONNECTION");

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
