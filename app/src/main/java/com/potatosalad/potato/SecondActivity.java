package com.potatosalad.potato;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by kitchu on 4/10/2016.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        intent.getBooleanArrayExtra()

        setContentView(R.layout.second_main);
    }
}
