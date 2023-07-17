package com.rizalfadilah.login;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImplisitIntentMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implisit_intent_main);
    }

    public void tampilTelepon(View view) {
        Intent teleponIntent = new Intent(Intent.ACTION_DIAL);
        startActivity(teleponIntent);
    }

    public void tampilSMS(View view) {
        Intent smsIntent = new Intent(Intent.ACTION_MAIN);
        smsIntent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        startActivity(smsIntent);
    }

    public void tampilKalender(View view) {
        Intent kalenderIntent = new Intent(Intent.ACTION_MAIN);
        kalenderIntent.addCategory(Intent.CATEGORY_APP_CALENDAR);
        startActivity(kalenderIntent);
    }

    public void tampilBrowser(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_MAIN);
        browserIntent.addCategory(Intent.CATEGORY_APP_BROWSER);
        startActivity(browserIntent);
    }

    public void tampilKalkulator(View view) {
        ArrayList<HashMap<String,Object>> items =new ArrayList<HashMap<String,Object>>();
        final PackageManager pm = getPackageManager();
        List<PackageInfo> packs= pm.getInstalledPackages(0);

        for (PackageInfo pi : packs)
        {
            String packageName = pi.packageName.toString();
            String packageName_lowerCase = packageName.toLowerCase();
            if (packageName_lowerCase.contains("calcul"))
            {
                HashMap<String, Object> map = new HashMap<String, Object>();

                map.put("appName", pi.applicationInfo.loadLabel(pm));
                map.put("packageName", pi.packageName);

                items.add(map);
            }
        }

        int item_size = items.size();

        if (item_size >= 1)
        {
            String packageName = (String) items.get(0).get("packageName");
            Intent i = pm.getLaunchIntentForPackage(packageName);

            if (i != null)
            {
                startActivity(i);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Tidak ditemukan aplikasi kalkulator", Toast.LENGTH_SHORT);

            }
        }
        try {
            Intent kalkulatorIntent = new Intent(Intent.ACTION_MAIN);
            kalkulatorIntent.addCategory(Intent.CATEGORY_APP_CALCULATOR);

            ComponentName cn = new ComponentName("com.android.calculator2", "com.android.calculator2.Calculator");
            kalkulatorIntent.setComponent(cn);

            startActivity(kalkulatorIntent);
        } catch (ActivityNotFoundException anfe) {
            Toast.makeText(getApplicationContext(), "Aplikasi tidak ditemukan", Toast.LENGTH_LONG).show();
        }
    }

    public void tampilKontak(View view) {
        Intent kontakIntent = new Intent(Intent.ACTION_MAIN);
        kontakIntent.addCategory(Intent.CATEGORY_APP_CONTACTS);
        startActivity(kontakIntent);
    }

    public void tampilGaleri(View view) {
        Intent galeriIntent = new Intent(Intent.ACTION_MAIN);
        galeriIntent.addCategory(Intent.CATEGORY_APP_GALLERY);
        startActivity(galeriIntent);
    }

    public void tampilWifi(View view) {
        Intent wifiIntent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        startActivity(wifiIntent);
    }

    public void tampilSound(View view) {
        Intent soundIntent = new Intent(Settings.ACTION_SOUND_SETTINGS);
        startActivity(soundIntent);
    }

    public void tampilAirplane(View view) {
        Intent airplaneIntent = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
        startActivity(airplaneIntent);
    }

    public void tampilAplikasi(View view) {
        Intent aplikasiIntent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
        startActivity(aplikasiIntent);
    }

    public void tampilBluetooth(View view) {
        Intent bluetoothIntent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        startActivity(bluetoothIntent);
    }
}