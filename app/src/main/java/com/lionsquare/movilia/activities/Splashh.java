package com.lionsquare.movilia.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.lionsquare.movilia.R;

import java.util.Timer;
import java.util.TimerTask;

public class Splashh extends AppCompatActivity {

    TextView texto;
    private long splashRetraso = 4000;
    protected static final int TIMER_RUNTIME = 4000;
    protected boolean mbActive;
    protected ProgressBar aProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splashh);
        Fresco.initialize(this);//se incia fresco

        texto = (TextView) findViewById(R.id.textView2);
        texto.setText("MOVILIA");
        aProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent NuevoLayout;
                NuevoLayout = new Intent(Splashh.this, MainActivity.class);
                startActivity(NuevoLayout);
                Splashh.this.finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, splashRetraso);

        final Thread timerThread = new Thread() {
            public void run() {
                mbActive = true;
                try {
                    int waited = 0;
                    while (mbActive && (waited < TIMER_RUNTIME)) {
                        sleep(200);
                        if (mbActive) {
                            waited += 200;
                            updateProgress(waited);
                        }
                    }
                } catch (InterruptedException e) {

                } finally {
                    onContinue();
                }
            }
        };
        timerThread.start();


    }

    private void updateProgress(final int timePassed) {
        if (null != aProgressBar) {
            final int progress = aProgressBar.getMax() * timePassed / TIMER_RUNTIME;
            aProgressBar.setProgress(progress);
        }
    }


    private void onContinue() {

        Log.d("mensaje final barra", "sus barra cargando");
    }


}


