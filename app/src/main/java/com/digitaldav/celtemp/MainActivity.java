package com.digitaldav.celtemp;

import android.appwidget.AppWidgetManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{


    private TextView textC;
    private CheckBox checkBox;


    private SensorTemperatura sensor;

    private SensorManager managerS;
    private Sensor sensorT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textC= (TextView)findViewById(R.id.textTemp);
        checkBox = (CheckBox) findViewById(R.id.tipoT);

        sensor = new SensorTemperatura((SensorManager)getSystemService(SENSOR_SERVICE), textC);

        checkBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (((CheckBox) v).isChecked()) {
                    sensor.setCelsius(false);
                }else {
                    sensor.setCelsius(true);
                }
            }
        });

    }

    public float getTemp(){
        return sensor.getTempCelsius();
    }


}
