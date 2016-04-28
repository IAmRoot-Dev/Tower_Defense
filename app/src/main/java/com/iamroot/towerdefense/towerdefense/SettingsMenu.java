package com.iamroot.towerdefense.towerdefense;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SettingsMenu extends AppCompatActivity {
    public void guideMain(View view)
    {
        Intent intent = new Intent(SettingsMenu.this, GuideMain.class);
        startActivity(intent);
    }
    public void aboutMain(View view)
    {
        Intent intent = new Intent(SettingsMenu.this, AboutMain.class);
        startActivity(intent);
    }
    public void termsMain(View view) {
        Intent intent = new Intent(SettingsMenu.this, TermsMain.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_menu);
    }
}
