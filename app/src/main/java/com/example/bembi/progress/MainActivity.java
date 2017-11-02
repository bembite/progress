package com.example.bembi.progress;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ////////icons
        Typeface font = Typeface.createFromAsset( getAssets(), "fonts/fontawesome-webfont.ttf" );
        Button button_g = (Button)findViewById( R.id.button_graph );
        button_g.setTypeface(font);
        Button button_m = (Button)findViewById( R.id.button_menu );
        button_m.setTypeface(font);
        Button button_s = (Button)findViewById( R.id.button_settings);
        button_s.setTypeface(font);


    }
}
