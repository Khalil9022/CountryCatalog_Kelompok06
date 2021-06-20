package com.example.countrycatalog.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.countrycatalog.R;

public class DetailedCountryActivity extends AppCompatActivity {

    private TextView tv_nameCountry,tv_codeCountry;
    private ImageView iv_flagCountry,iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_country);

        getSupportActionBar().hide();

        tv_nameCountry = findViewById(R.id.detailedcountry_tv_nameCountry);
        tv_codeCountry = findViewById(R.id.detailedcountry_tv_codeCountry);
        iv_flagCountry = findViewById(R.id.detailedcountry_iv_countryFlag);
        iv_back = findViewById(R.id.detailedcountry_iv_back);

//        Bundle forNumber = getIntent().getExtras();
//        int number = forNumber.getInt("id_country");
//        String sNumber = String.valueOf(number);
//
//        tv_number.setText(sNumber);
        tv_nameCountry.setText(getIntent().getStringExtra("name_country"));
        tv_codeCountry.setText(getIntent().getStringExtra("code_country"));
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("flag_country")).into(iv_flagCountry);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}