package com.valkyrie.game;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Toast;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;


public class AndroidLauncher extends AndroidApplication {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Toast.makeText(AndroidLauncher.this,
				"Your Message", Toast.LENGTH_LONG).show();
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new valkyrie(), config);


	}




}
