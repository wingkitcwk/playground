package com.potatosalad.potato;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    LinearLayout mLl;
    TextView mTxtContent;
    Button mBtnChanger;
    private SensorEventListener mSensorListener;
    private MainActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        // alt enter imports
        mLl = (LinearLayout) findViewById(R.id.activity_main);

        mTxtContent = (TextView) findViewById(R.id.content);

        // bind ui views
        mBtnChanger = (Button) findViewById(R.id.button_title_changer);
        mBtnChanger.setText("hello");
        mBtnChanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("main", "button pressed");
                mTxtContent.setText("" + Math.random());
                mLl.setBackgroundColor(Color.argb(255, 0, 0, (int) (255 * Math.random())));
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);

            }
        });


        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                Log.d("main", event.values[0] + " " + event.values[1] + " " + event.values[2]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };



    }

    @Override
    protected void onResume() {
        super.onResume();
        mLl.setBackgroundColor(Color.argb(255, 0, 255, 0));
        Log.d("main", "the app is resumed");
        mSensorManager.registerListener(mSensorListener, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mSensorListener);

        Log.d("main", "the app is sleeping");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
