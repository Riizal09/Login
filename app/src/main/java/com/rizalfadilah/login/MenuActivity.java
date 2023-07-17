package com.rizalfadilah.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button _mahasiswa, _tampilForebutton, _tampilCuacaButton, _tampilImplisit;
    private Intent _tampilintent, _tampilForexintent, _tampilCuacaIntent, _ImplisitIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initTampilMahasiswaButton();
        initTampilForexButton();
        initTampilCuacaButton();
        inittampilImplisit();}
    private void initTampilMahasiswaButton(){

        _mahasiswa = (Button) findViewById(R.id.mahasiswa);
        _mahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _tampilintent = new Intent(getApplicationContext(), TampilMahasiswaActivity.class);
                startActivity(_tampilintent);

            }
        });}

    private void initTampilForexButton()
    {
        _tampilForebutton = (Button) findViewById(R.id.tampilForexButton);

        _tampilForebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tampilForexintent=new Intent(getApplicationContext(), ForexMainActivity.class);
                startActivity(_tampilForexintent);
            }
        });
    }
    private void initTampilCuacaButton(){
        _tampilCuacaButton = findViewById(R.id.tampilCuacaButton);
        _tampilCuacaButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                _tampilCuacaIntent = new Intent(getApplicationContext(), CuacaMainActivity.class);
            }
        });
    }
    private void inittampilImplisit()
    {
        _tampilImplisit = (Button) findViewById(R.id.tampilImplisit);

        _tampilImplisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _ImplisitIntent=new Intent(getApplicationContext(), ImplisitIntentMainActivity.class);
                startActivity(_ImplisitIntent);
            }
        });
    }
}