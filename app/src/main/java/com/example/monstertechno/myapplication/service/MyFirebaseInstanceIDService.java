package com.example.monstertechno.myapplication.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.monstertechno.myapplication.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;
import java.util.Random;

public class MyFirebaseInstanceIDService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if(remoteMessage.getData().isEmpty()) {
            showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
        }else {
            showNotification(remoteMessage.getData());
        }
    }

    private void showNotification(Map<String, String> data) {
        String title = data.get("title").toString();
        String body = data.get("body").toString();
        NotificationManager notificationmanager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "com.example.monstertechno.myapplication.test";

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O) {
            NotificationChannel notificatonChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "Notification",
                    NotificationManager.IMPORTANCE_DEFAULT);

            notificatonChannel.setDescription("MONSTER TECHNO");
            notificatonChannel.enableLights(true);
            notificatonChannel.setLightColor(Color.BLUE);
            //notificatonChannel.setVibrationPattern(new Long[]{0L});
            notificatonChannel.enableLights(true);
            notificationmanager.createNotificationChannel(notificatonChannel);

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,NOTIFICATION_CHANNEL_ID);
            notificationBuilder.setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.drawable.common_full_open_on_phone)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setContentInfo("Info");
            notificationmanager.notify(new Random().nextInt(),notificationBuilder.build());

        }
    }

    private void showNotification(String title, String body) {
        NotificationManager notificationmanager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "com.example.monstertechno.myapplication.test";

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O) {
            NotificationChannel notificatonChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "Notification",
                    NotificationManager.IMPORTANCE_DEFAULT);

            notificatonChannel.setDescription("MONSTER TECHNO");
            notificatonChannel.enableLights(true);
            notificatonChannel.setLightColor(Color.BLUE);
            //notificatonChannel.setVibrationPattern(new Long[]{0L});
            notificatonChannel.enableLights(true);
            notificationmanager.createNotificationChannel(notificatonChannel);

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,NOTIFICATION_CHANNEL_ID);
            notificationBuilder.setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.drawable.common_full_open_on_phone)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setContentInfo("Info");
            notificationmanager.notify(new Random().nextInt(),notificationBuilder.build());

        }
    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);

        Log.d("TOKERNFIREBASE",s);
    }
}
