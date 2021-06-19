package com.example.countrycatalog.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.countrycatalog.R;
import com.example.countrycatalog.databaseLokal.entity.AppDatabase;
import com.example.countrycatalog.databaseLokal.entity.DataFavoriteHoliday;

public class DetailedHolidayActivity extends AppCompatActivity {

    private TextView tv_nameHoliday, tv_dateHoliday, tv_countryHoliday;
    private Button btn_AddFavorite;
    private ImageView iv_Back;
    public String setNameHoliday, setDateHoliday, setCountryHoliday;

    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_holiday);

        getSupportActionBar().hide();

        tv_nameHoliday = findViewById(R.id.detailedholiday_tv_nameholiday);
        tv_dateHoliday = findViewById(R.id.detailedholiday_tv_dateholiday);
        tv_countryHoliday = findViewById(R.id.detailedholiday_tv_country);
        iv_Back = findViewById(R.id.detailedholiday_iv_back);
        btn_AddFavorite = findViewById(R.id.detailedholiday_btn_favorite);

        tv_nameHoliday.setText(getIntent().getStringExtra("name_holiday"));
        tv_dateHoliday.setText(getIntent().getStringExtra("date_holiday"));
        tv_countryHoliday.setText(getIntent().getStringExtra("country_holiday"));

        appDatabase = AppDatabase.iniDb(getApplicationContext());

        iv_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_AddFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input();
                Intent submit = new Intent(getApplicationContext(), FavoriteActivity.class);
                startActivity(submit);
            }
        });
    }

    public void input(){
        setNameHoliday = tv_nameHoliday.getText().toString();
        setDateHoliday = tv_dateHoliday.getText().toString();
        setCountryHoliday = tv_countryHoliday.getText().toString();

        final DataFavoriteHoliday dataFavoriteHoliday = new DataFavoriteHoliday();

        dataFavoriteHoliday.setName_holiday(setNameHoliday);
        dataFavoriteHoliday.setDate_holiday(setDateHoliday);
        dataFavoriteHoliday.setName_country(setCountryHoliday);


        new InsertData(appDatabase, dataFavoriteHoliday).execute();
    }

    class InsertData extends AsyncTask<Void, Void, Long> {
        private AppDatabase database;
        private DataFavoriteHoliday dataFavoriteHoliday;

        public InsertData(AppDatabase database, DataFavoriteHoliday dataFavoriteHoliday) {
            this.database = database;
            this.dataFavoriteHoliday = dataFavoriteHoliday;
        }


        @Override
        protected Long doInBackground(Void... voids) {
            return database.dao().insertData(dataFavoriteHoliday);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            Toast.makeText(getApplicationContext(), "sukses ditambahkan", Toast.LENGTH_SHORT).show();

        }

    }
}