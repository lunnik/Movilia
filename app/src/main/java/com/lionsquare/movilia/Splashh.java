package com.lionsquare.movilia;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Timer;
import java.util.TimerTask;

public class Splashh extends AppCompatActivity {

         TextView texto;
         private long splashRetraso=4000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splashh);

        texto=(TextView) findViewById(R.id.textView2);
        texto.setText("MOVILIA");

          TimerTask task= new TimerTask() {
              @Override
              public void run() {
                  Intent NuevoLayout;
                  NuevoLayout= new Intent(Splashh.this, MainActivity.class);
                  startActivity(NuevoLayout);
                  Splashh.this.finish();
              }
          };

          Timer timer= new Timer();
        timer.schedule(task, splashRetraso);
        }



    }


