package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void generarNotificacion(View view) {


        Intent notifyIntent = new Intent(this,NotificationActivity.class);

        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent notifyPendingIntend = PendingIntent.getActivity(this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        String id = "id_canal_01";

        CharSequence nombre = "Nombre del canal";

        String descripcion = "Descripcion del canal";

        int importancia = NotificationManager.IMPORTANCE_DEFAULT;

        NotificationChannel notificationChannel = new NotificationChannel(id,nombre,importancia);

        notificationChannel.setDescription(descripcion);

        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(Color.RED);

        notificationChannel.enableVibration(true);
        notificationChannel.setVibrationPattern(new long[]{500});

        notificationManager.createNotificationChannel(notificationChannel);


        CharSequence textTitle = "Su reserva está a punto de empezar";
        CharSequence textContent = "Pulse aqui para revisar la informacion";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, id)
                .setSmallIcon(R.drawable.notification_icon)
                .setColor(500058)
                .setContentTitle(textTitle)
                .setContentText(textContent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(notifyPendingIntend)
                .setAutoCancel(true);





        notificationManager.notify(402, builder.build());


    }
}