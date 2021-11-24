package com.valkyrie.game;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;


import com.badlogic.gdx.backends.android.AndroidApplication;


@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AndroidApplication {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, AndroidLauncher.class));

        SplashActivity.this.finish();

    }




}
