package com.hermanowicz.badmintonschool;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        setView();
        delayAndGoToMainActivity();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        goToMainActivity();
    }

    private void initView() {
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        logo = findViewById(R.id.logo);
    }

    private void setView() {
        logo.animate().translationY(80).setDuration(1800);
    }

    private void goToMainActivity() {
        Intent i = new Intent(SplashScreenActivity.this, MainActivity.class); startActivity(i);
        finish();
    }

    private void delayAndGoToMainActivity() {
        new Handler().postDelayed(() -> {
            finish();
            goToMainActivity();
        }, 1800);
    }
}