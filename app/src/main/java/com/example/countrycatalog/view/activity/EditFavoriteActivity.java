package com.example.countrycatalog.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.countrycatalog.R;
import com.example.countrycatalog.adapter.FavoriteHolidayAdapter;
import com.example.countrycatalog.databaseLokal.contact.HolidayContact;
import com.example.countrycatalog.databaseLokal.entity.AppDatabase;
import com.example.countrycatalog.databaseLokal.entity.DataFavoriteHoliday;
import com.example.countrycatalog.databaseLokal.presenter.HolidayPresenter;

public class EditFavoriteActivity extends AppCompatActivity implements HolidayContact.view {

    private AppDatabase appDatabase;
    private HolidayPresenter holidayPresenter;
    private FavoriteHolidayAdapter favoriteHolidayAdapter;
    private EditText et_nameHoliday, et_dateHoliday, et_countryHoliday ;
    private Button btn_edit;
    private String setNameHoliday, setDateHoliday, setCountryHoliday;
    private boolean edit = false;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_favorite);

        getSupportActionBar().hide();

        et_nameHoliday = findViewById(R.id.editfavorite_et_nameHoliday);
        et_dateHoliday = findViewById(R.id.editfavorite_et_dateHoliday);
        et_countryHoliday = findViewById(R.id.editfavorite_et_countryHoliday);

        btn_edit = findViewById(R.id.editfavorite_btn_edit);
        holidayPresenter = new HolidayPresenter(this);
        appDatabase = AppDatabase.iniDb(getApplicationContext());

        setNameHoliday = getIntent().getStringExtra("namaHoliday");
        setDateHoliday = getIntent().getStringExtra("dateHoliday");
        setCountryHoliday = getIntent().getStringExtra("countryHoliday");

        id = getIntent().getIntExtra("id", 99);

        et_nameHoliday.setText(setNameHoliday);
        et_dateHoliday.setText(setDateHoliday);
        et_countryHoliday.setText(setCountryHoliday);

        btn_edit.setOnClickListener(this);
    }

    @Override
    public void resetForm() {
        et_nameHoliday.setText("");
        et_dateHoliday.setText("");
        et_countryHoliday.setText("");
        btn_edit.setText("EDIT");
    }

    @Override
    public void sukses() {
        Toast.makeText(getApplicationContext(), "sukses", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), FavoriteActivity.class));
    }

    @Override
    public void editData(DataFavoriteHoliday item) {
        et_nameHoliday.setText(item.getName_holiday());
        et_dateHoliday.setText(item.getDate_holiday());
        et_countryHoliday.setText(item.getName_country());

        edit = true;
        btn_edit.setText("Update");
    }

    @Override
    public void onClick(View v) {
        String NameHoliday, DateHoliday, CountryHoliday;
        NameHoliday = et_nameHoliday.getText().toString();
        DateHoliday = et_dateHoliday.getText().toString();
        CountryHoliday = et_countryHoliday.getText().toString();
        if(v ==  btn_edit){
            if(NameHoliday.equals("") || DateHoliday.equals("") || CountryHoliday.equals("")) {
                Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show();
            } else {

                holidayPresenter.editData(NameHoliday,DateHoliday,CountryHoliday, id, appDatabase);
                edit = false;
            }
            resetForm();
        }
    }
}