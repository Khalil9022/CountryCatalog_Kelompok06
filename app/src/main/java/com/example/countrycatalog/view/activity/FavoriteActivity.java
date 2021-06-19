package com.example.countrycatalog.view.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.countrycatalog.R;
import com.example.countrycatalog.adapter.FavoriteHolidayAdapter;
import com.example.countrycatalog.databaseLokal.contact.HolidayContact;
import com.example.countrycatalog.databaseLokal.entity.AppDatabase;
import com.example.countrycatalog.databaseLokal.entity.DataFavoriteHoliday;
import com.example.countrycatalog.databaseLokal.presenter.HolidayPresenter;

import java.util.List;

public class FavoriteActivity extends AppCompatActivity implements HolidayContact.hapus {

    private AppDatabase appDatabase;
    private FavoriteHolidayAdapter favoriteHolidayAdapter;
    private HolidayPresenter holidayPresenter;
    View view;
    RecyclerView recyclerView;
    ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        getSupportActionBar().hide();

        holidayPresenter = new HolidayPresenter(this);
        recyclerView = findViewById(R.id.favoriteholiday_rv_main);
        iv_back = findViewById(R.id.favorite_iv_back);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        appDatabase = AppDatabase.iniDb(getApplicationContext());

        readData(appDatabase);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoriteActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void readData(AppDatabase appDatabase) {
        List list;
        list = appDatabase.dao().getData();
        //view.getData(list);
        favoriteHolidayAdapter = new FavoriteHolidayAdapter(getApplicationContext(), list, this);
        recyclerView.setAdapter(favoriteHolidayAdapter);
    }

    @Override
    public void sukses() {
        Toast.makeText(getApplicationContext(), "Data Berhasil di hapus", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), FavoriteActivity.class));
    }

    @Override
    public void deleteData(DataFavoriteHoliday item) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Menghapus Data")
                .setMessage("Anda yakin ingin menghapus data ini?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // resetForm();
                        holidayPresenter.deleteData(item, appDatabase);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}