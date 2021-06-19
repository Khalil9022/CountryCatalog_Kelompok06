package com.example.countrycatalog.databaseLokal.contact;

import android.view.View;

import com.example.countrycatalog.databaseLokal.entity.AppDatabase;
import com.example.countrycatalog.databaseLokal.entity.DataFavoriteHoliday;

import java.util.List;

public interface HolidayContact {

    interface view extends View.OnClickListener{
        void resetForm();
        void sukses();
        void editData(DataFavoriteHoliday item);
    }
    interface datapresenter{
        void editData(String contact_nameHoliday, String contact_dateHoliday, String contact_CountryHoliday, int id, AppDatabase database);
        void deleteData(DataFavoriteHoliday dataFavoriteHoliday, AppDatabase database);
    }
    interface Cetak extends View.OnClickListener{
        void getData(List<DataFavoriteHoliday> list);
    }
    interface hapus{
        // void resetForm();
        void sukses();
        void deleteData(DataFavoriteHoliday item);
    }
}
