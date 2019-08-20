package com.stardigitalbikes.samuelhimself.bible1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static com.android.volley.VolleyLog.TAG;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG="MyFirebaseMessagingService";

    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "my_notification_channel";

    String tit;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

//            Toast.makeText(getApplicationContext(), remoteMessage.toString(), Toast.LENGTH_LONG).show();
        Log.d("fire", "fireMSG: " + remoteMessage.getFrom());


        Log.d("fire", "fireMSG: " + remoteMessage.getNotification().getBody());

        tit=remoteMessage.getNotification().getTitle();

        createNotificationChannel();
        addNotification(remoteMessage.getNotification().getBody());


    }

    public void createNotificationChannel() {
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

    public void addNotification(String mess) {
        int prio=2;

//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)


        // Create an explicit intent for an Activity in your app
        Intent intent = new Intent(this, Mapsimport1.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.bike1)
                .setContentTitle(tit)
                .setContentText(mess)
                .setPriority(prio)
//                .setSound(R.raw.bbell1)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
        notificationManager.notify(NOTIFICATION_ID, mBuilder.build());


//
    }

}
