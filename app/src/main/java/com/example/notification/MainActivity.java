package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
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


        CharSequence textTitle = "Anónimo";
        CharSequence textContent = "Sufriendo del triunfo";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, id)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle(textTitle)
                .setContentText(textContent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);





        notificationManager.notify(402, builder.build());


    }
}