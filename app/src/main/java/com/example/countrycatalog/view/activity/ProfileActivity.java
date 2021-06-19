package com.example.countrycatalog.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.countrycatalog.R;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvUsername, tvEmail, tvCountry;
    Button btnEdit, btnLogout;
    ImageView ivBack,ivFavorite;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "my_pref";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_COUNTRY = "country";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().hide();

        tvUsername = findViewById(R.id.tv_username);
        tvEmail = findViewById(R.id.tv_email);
        tvCountry = findViewById(R.id.tv_country);

        btnEdit = findViewById(R.id.btn_edit);
        btnLogout = findViewById(R.id.btn_logout);

        ivBack = findViewById(R.id.profile_iv_back);
        ivFavorite = findViewById(R.id.profile_iv_favorite);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        retrieveData();

        btnEdit.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        ivFavorite.setOnClickListener(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        retrieveData();
    }

    @SuppressLint("SetTextI18n")
    private void retrieveData(){
        String sUsername = sharedPreferences.getString(KEY_USERNAME,null);
        String sEmail = sharedPreferences.getString(KEY_EMAIL,null);
        String sPhone = sharedPreferences.getString(KEY_COUNTRY,null);

        tvUsername.setText(sUsername);
        tvEmail.setText(": " + sEmail);
        tvCountry.setText(": " + sPhone);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btn_edit:
                intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_logout:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                intent = new Intent(ProfileActivity.this, MainActivity.class);
                Objects.requireNonNull(this).finish();
                Objects.requireNonNull(ProfileActivity.this).startActivity(intent);
                Toast.makeText(this.getApplicationContext(),"Telah Berhasil Logout",Toast.LENGTH_SHORT).show();
                break;

            case R.id.profile_iv_back:
                intent = new Intent(ProfileActivity.this, ContentActivity.class);
                startActivity(intent);
                break;

            case R.id.profile_iv_favorite:
                intent = new Intent(ProfileActivity.this, FavoriteActivity.class);
                startActivity(intent);
                break;
        }
    }
}