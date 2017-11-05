package com.example.bembi.progress;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

        findViewById(R.id.button_menu).setOnClickListener(this);
        findViewById(R.id.button_graph).setOnClickListener(this);
        findViewById(R.id.button_settings).setOnClickListener(this);




    }
    public void onClick(View v) {
        if(v==findViewById(R.id.button_menu)) {
            Log.d("Debug", "menu_button");
            Intent mainIntent = new Intent(MainActivity.this,Categories.class);
            MainActivity.this.startActivity(mainIntent);
            MainActivity.this.finish();
        }
        if(v==findViewById(R.id.button_graph)) {
            Log.d("Debug", "button_graph");
        }
        if(v==findViewById(R.id.button_settings)) {
            Log.d("Debug", "button_settings");
        }

    }
}
