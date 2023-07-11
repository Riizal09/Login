package com.rizalfadilah.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button _mahasiswa;
    private Intent _tampilintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initTampilMahasiswaButton();}
    private void initTampilMahasiswaButton(){

        _mahasiswa = (Button) findViewById(R.id.mahasiswa);
        _mahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _tampilintent = new Intent(getApplicationContext(), TampilMahasiswaActivity.class);
                startActivity(_tampilintent);

            }
        });}
}