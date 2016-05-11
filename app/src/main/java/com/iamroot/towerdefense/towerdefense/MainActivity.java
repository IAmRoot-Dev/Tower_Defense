package com.iamroot.towerdefense.towerdefense;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    public void playMenu(View view) {
        Intent intent = new Intent(MainActivity.this, PlayMenu.class);
        startActivity(intent);
    }
    public void storeMenu(View view) {
        Intent intent = new Intent(MainActivity.this, StoreMenu.class);
        startActivity(intent);
    }
    public void settingsMenu(View view) {
        Intent intent = new Intent(MainActivity.this, SettingsMenu.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
