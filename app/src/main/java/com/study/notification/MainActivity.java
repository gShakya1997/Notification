package com.study.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private Button btn1, btn2;
    private int id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel createChannel = new CreateChannel(this);
        createChannel.createChannel();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification2();
            }
        });
    }

    private void displayNotification() {
        Notification notification = new NotificationCompat.Builder
                (this, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_add_alert_black_24dp)
                .setContentTitle("First message")
                .setContentText("First message body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

            notificationManagerCompat.notify(id, notification);
            id++;
    }

    private void displayNotification2() {
        Notification notification = new NotificationCompat.Builder
                (this, CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle("Second message")
                .setContentText("Second message body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(id, notification);
        id++;
    }
}
