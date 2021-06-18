package com.example.countrycatalog.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.countrycatalog.R;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etUsername, etEmail, etCountry;
    Button btnSave, btnCancel;
    ImageView ivBack;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "my_pref";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_COUNTRY = "country";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        getSupportActionBar().hide();

        etUsername = findViewById(R.id.et_username);
        etEmail = findViewById(R.id.et_email);
        etCountry = findViewById(R.id.et_country);
        btnSave = findViewById(R.id.btn_save);
        btnCancel = findViewById(R.id.btn_cancel);
        ivBack = findViewById(R.id.editprofile_iv_back);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String sUsername = sharedPreferences.getString(KEY_USERNAME,null);
        String sEmail = sharedPreferences.getString(KEY_EMAIL,null);
        String sCountry = sharedPreferences.getString(KEY_COUNTRY,null);

        if (sUsername != null || sEmail != null || sCountry != null){
            etUsername.setText(sUsername);
            etEmail.setText(sEmail);
            etCountry.setText(sCountry);
        }

        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_USERNAME,etUsername.getText().toString());
                editor.putString(KEY_EMAIL,etEmail.getText().toString());
                editor.putString(KEY_COUNTRY,etCountry.getText().toString());
                Toast.makeText(getApplicationContext(),"Profile berhasil di Edit!",Toast.LENGTH_SHORT).show();
                editor.apply();
                finish();
                break;

            case R.id.btn_cancel:
                finish();
                break;

            case R.id.editprofile_iv_back:
                Intent intent = new Intent(EditProfileActivity.this, ProfileActivity.class);
                startActivity(intent);
                break;
        }
    }
}