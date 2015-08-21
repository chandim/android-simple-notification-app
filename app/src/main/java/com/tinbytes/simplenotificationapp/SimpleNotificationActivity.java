/*
 * Copyright 2015 Tinbytes Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tinbytes.simplenotificationapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class SimpleNotificationActivity extends AppCompatActivity {
  private static final int NOTIFY_ID = 100;
  private NotificationManager notificationManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple_notification);

    findViewById(R.id.bTextNotification).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        showTextNotification();
      }
    });
    findViewById(R.id.bVibrateNotification).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        showVibrateNotification();
      }
    });
    findViewById(R.id.bLedNotification).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        showLedNotification();
      }
    });
    findViewById(R.id.bExpandNotification).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        showExpandNotification();
      }
    });
    findViewById(R.id.bSoundNotification).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        showSoundNotification();
      }
    });
    findViewById(R.id.bClearNotifications).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        clearNotifications();
      }
    });

    notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
  }

  private Intent getNotificationIntent() {
    Intent intent = new Intent(this, SimpleNotificationActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
    return intent;
  }

  private void showTextNotification() {
    Notification notification = new NotificationCompat.Builder(this)
        .setContentIntent(PendingIntent.getActivity(this, 0, getNotificationIntent(), 0))
        .setSmallIcon(R.mipmap.ic_launcher)
        .setTicker("Text Notification Received")
        .setContentTitle("Hi there!")
        .setContentText("This is even more text.")
        .setWhen(System.currentTimeMillis())
        .setAutoCancel(true)
        .build();

    notificationManager.notify(NOTIFY_ID, notification);
  }

  private void showVibrateNotification() {
    Notification notification = new NotificationCompat.Builder(this)
        .setContentIntent(PendingIntent.getActivity(this, 0, getNotificationIntent(), 0))
        .setSmallIcon(R.mipmap.ic_launcher)
        .setTicker("Vibrate Notification Received")
        .setContentTitle("Hi there!")
        .setContentText("This is even more text.")
        .setWhen(System.currentTimeMillis())
        .setAutoCancel(true)
        .setVibrate(new long[]{0, 200, 200, 600, 600})
        .build();

    notificationManager.notify(NOTIFY_ID, notification);
  }

  private void showLedNotification() {
    Notification notification = new NotificationCompat.Builder(this)
        .setContentIntent(PendingIntent.getActivity(this, 0, getNotificationIntent(), 0))
        .setSmallIcon(R.mipmap.ic_launcher)
        .setTicker("LED Notification Received")
        .setContentTitle("Hi there!")
        .setContentText("This is even more text.")
        .setWhen(System.currentTimeMillis())
        .setAutoCancel(true)
        .setLights(Color.GREEN, 1000, 1000)
        .build();

    notificationManager.notify(NOTIFY_ID, notification);
  }

  private void showExpandNotification() {
    Notification notification = new NotificationCompat.Builder(this)
        .setContentIntent(PendingIntent.getActivity(this, 0, getNotificationIntent(), 0))
        .setSmallIcon(R.mipmap.ic_launcher)
        .setTicker("Expand Notification Received")
        .setContentTitle("Hi there!")
        .setContentText("This is even more text.")
        .setWhen(System.currentTimeMillis())
        .setAutoCancel(true)
        .setStyle(new NotificationCompat.BigTextStyle().bigText(
            "This is a really long message that is used for expanded notifications in the status bar"))
        .build();

    notificationManager.notify(NOTIFY_ID, notification);
  }

  private void showSoundNotification() {
    Notification notification = new NotificationCompat.Builder(this)
        .setContentIntent(PendingIntent.getActivity(this, 0, getNotificationIntent(), 0))
        .setSmallIcon(R.mipmap.ic_launcher)
        .setTicker("Sound Notification Received")
        .setContentTitle("Hi there!")
        .setContentText("This is even more text.")
        .setWhen(System.currentTimeMillis())
        .setAutoCancel(true)
        .setSound(Uri.parse("android.resource://com.tinbytes.simplenotificationapp/" + R.raw.notification), AudioManager.STREAM_NOTIFICATION)
        .build();

    notificationManager.notify(NOTIFY_ID, notification);
  }

  private void clearNotifications() {
    notificationManager.cancelAll();
  }
}
