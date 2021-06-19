package com.example.countrycatalog.databaseLokal.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favoriteholidaydb")
public class DataFavoriteHoliday {
    @NonNull
    @PrimaryKey(autoGenerate = true) //menandakan primary key yaitu id
    @ColumnInfo(name = "id") //info buat atribut dalam database
    private int id; // tipe data dari masing masin gatributnya

    @ColumnInfo(name = "name_holiday")
    private String name_holiday;

    @ColumnInfo(name = "date_holiday")
    private String date_holiday;

    @ColumnInfo(name = "name_country")
    private String name_country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_holiday() {
        return name_holiday;
    }

    public void setName_holiday(String name_holiday) {
        this.name_holiday = name_holiday;
    }

    public String getDate_holiday() {
        return date_holiday;
    }

    public void setDate_holiday(String date_holiday) {
        this.date_holiday = date_holiday;
    }

    public String getName_country() {
        return name_country;
    }

    public void setName_country(String name_country) {
        this.name_country = name_country;
    }
}
