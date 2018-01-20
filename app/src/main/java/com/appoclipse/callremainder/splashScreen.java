package com.appoclipse.callremainder;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class splashScreen extends AppCompatActivity {

    TextView appname, tag;
    ImageView applogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Switching to full screen mode
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        final ProgressBar bar = (ProgressBar) findViewById(R.id.loading);

        //Animation
        appname = findViewById(R.id.appname);
        applogo = findViewById(R.id.logo);
        tag = findViewById(R.id.tag);
        appname.animate().alpha(0f).setDuration(1000);
        applogo.animate().alpha(0f).setDuration(1000);
        tag.animate().alpha(1f).setDuration(2000);

        //Switching to Main Activity
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(getApplicationContext(), CallRemainderActivity.class);
                startActivity(i);
                finish();
            }
        },2500);
    }
}
