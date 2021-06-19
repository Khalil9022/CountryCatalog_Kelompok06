package com.example.countrycatalog.databaseLokal.entity;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataFavoriteHolidayDAO {
    @Insert
        //fungsi insert
    long insertData(DataFavoriteHoliday dataFavoriteHoliday); //nantinya dia akan ambil dari kelas data sekolah

    @Query("Select * from favoriteholidaydb") //untuk memanggil seluruh data yg ada di db
    List<DataFavoriteHoliday> getData(); //si db itu ngambil datanya dari list yang ada di data sekolah

    @Update
        //fungsi edit data
    int updateData(DataFavoriteHoliday item);

    @Delete
        //fungsi hapus data
    void deleteData(DataFavoriteHoliday item);
}
