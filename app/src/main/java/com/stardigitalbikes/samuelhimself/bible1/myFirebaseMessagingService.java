package com.stardigitalbikes.samuelhimself.bible1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class myFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG="MyFirebaseMessagingService";

    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "my_notification_channel";

    String tit;

    @Override
    public void onNewToken(String s) {
        Log.e("NEW_TOKEN", s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

//            Toast.makeText(getApplicationContext(), remoteMessage.toString(), Toast.LENGTH_LONG).show();
        Log.d("fire", "fireMSG: " + remoteMessage.getFrom());


        Log.d("fire", "fireMSG: " + remoteMessage.getNotification().getBody());

        tit=remoteMessage.getNotification().getTitle();

        createNotificationChannel();
        addNotification(remoteMessage.getNotification().getBody());


    }
    public myFirebaseMessagingService() {
    }

//    @Override
//    public IBinder onBind(Intent intent) {
//        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
//    }

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
