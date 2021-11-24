package com.valkyrie.game;


import android.os.Bundle;
import android.widget.Button;


import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;


public class StartGame extends AndroidApplication {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);
        button = findViewById(R.id.button);
        button.setOnClickListener(v -> openNewActivity());


    }

    private void openNewActivity() {

        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        initialize(new valkyrie(), config);

    }


}