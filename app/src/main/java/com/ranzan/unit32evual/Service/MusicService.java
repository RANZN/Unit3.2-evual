package com.ranzan.unit32evual.Service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.ranzan.unit32evual.Api.ResultsItem;

import java.io.IOException;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private ResultsItem resultsItem = null;


    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            showNotificationAndStartForeGround();
        } else {
            startForeground(1, new Notification());
        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getExtras() != null) {
            if (intent.getIntExtra("play", 0) == 1)
                resultsItem = (ResultsItem) intent.getSerializableExtra("data");

        }
        try {

            if (intent.getIntExtra("play", 0) == 1) {
                mediaPlayer.setDataSource(resultsItem.getPreviewUrl());
                mediaPlayer.prepare();
                mediaPlayer.start();

            } else if (intent.getIntExtra("play", 0) == 2) {
                if (mediaPlayer.isPlaying())
                    mediaPlayer.pause();
            } else if (intent.getIntExtra("play", 0) == 3) {
                if (mediaPlayer.isPlaying())
                    mediaPlayer.stop();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private void showNotificationAndStartForeGround() {
        String NOTIFICATION_CHANNEL_ID = "lloyd";
        String channelName = "Background Service";
        NotificationChannel chan = new NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_NONE);
        chan.setLightColor(Color.BLUE);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.createNotificationChannel(chan);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        Notification notification = notificationBuilder.setOngoing(true)
                .setContentTitle("Title")
                .setContentText("Hey music is playing")
                .setContentTitle("title")
                .setPriority(NotificationManager.IMPORTANCE_MIN)
                .setCategory(Notification.CATEGORY_SERVICE)
                .build();
        startForeground(2, notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}