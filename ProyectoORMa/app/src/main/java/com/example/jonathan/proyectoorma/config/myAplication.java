package com.example.jonathan.proyectoorma.config;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;

public class myAplication extends Application  {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
