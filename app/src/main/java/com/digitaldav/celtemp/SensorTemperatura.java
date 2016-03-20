package com.digitaldav.celtemp;

import android.app.Activity;
import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;




public class SensorTemperatura implements SensorEventListener {

    private SensorManager managerS;
    private Sensor sensorT;

    private TextView texto;

    private float temperatura;

    private boolean celsius;

    public SensorTemperatura(SensorManager t, TextView texto){

        this.texto = texto;

        managerS = t;

        sensorT = managerS.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        managerS.registerListener(this, sensorT, SensorManager.SENSOR_DELAY_NORMAL);

        if(sensorT == null){
            texto.setText("No hay sensor de temperatura");
        }

        celsius = true;

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        temperatura = event.values[0];
        if(celsius){
            texto.setText("Temperatura: " + String.format("%.2f", temperatura) + " ºC");
        }else{
            texto.setText("Temperatura: " + String.format("%.2f", temperatura*9/5+32) + " F");
        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public float getTempCelsius(){
        return temperatura;
    }

    public float getTempFa(){
        return temperatura*9/5+32;
    }

    public void setCelsius(boolean b){
        celsius = b;
        if(celsius){
            texto.setText("Temperatura: " + String.format("%.2f", temperatura) + " ºC");
        }else{
            texto.setText("Temperatura: " + String.format("%.2f", temperatura*9/5+32) + " ºF");
        }
    }
}
