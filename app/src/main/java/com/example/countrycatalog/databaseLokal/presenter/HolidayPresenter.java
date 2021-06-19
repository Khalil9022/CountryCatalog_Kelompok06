package com.example.countrycatalog.databaseLokal.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.countrycatalog.databaseLokal.contact.HolidayContact;
import com.example.countrycatalog.databaseLokal.entity.AppDatabase;
import com.example.countrycatalog.databaseLokal.entity.DataFavoriteHoliday;

public class HolidayPresenter implements HolidayContact.datapresenter {

    HolidayContact.view view;
    HolidayContact.hapus hapus;

    public HolidayPresenter(HolidayContact.view view) {
        this.view = view;
    }

    public HolidayPresenter(HolidayContact.hapus hapus) {
        this.hapus = hapus;
    }

    class EditData extends AsyncTask<Void, Void, Integer> {
        private AppDatabase database;
        private DataFavoriteHoliday dataFavoriteHoliday;
        public EditData(AppDatabase database, DataFavoriteHoliday dataFavoriteHoliday) {
            this.database = database;
            this.dataFavoriteHoliday = dataFavoriteHoliday;
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return database.dao().updateData(dataFavoriteHoliday);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("integer db", "onPostExecute: " + integer);
            view.sukses();
        }
    }

    @Override
    public void editData(String contact_nameHoliday, String contact_dateHoliday, String contact_CountryHoliday, int id, AppDatabase database) {
        final DataFavoriteHoliday dataFavoriteHoliday = new DataFavoriteHoliday();
        dataFavoriteHoliday.setName_holiday(contact_nameHoliday);
        dataFavoriteHoliday.setDate_holiday(contact_dateHoliday);
        dataFavoriteHoliday.setName_country(contact_CountryHoliday);
        dataFavoriteHoliday.setId(id);
        new EditData(database, dataFavoriteHoliday).execute();
    }

    class DeleteData extends AsyncTask<Void, Void, Void>{
        private AppDatabase database;
        private DataFavoriteHoliday dataFavoriteHoliday;
        Context context;
        public DeleteData(AppDatabase database, DataFavoriteHoliday dataFavoriteHoliday) {
            this.database = database;
            this.dataFavoriteHoliday = dataFavoriteHoliday;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            database.dao().deleteData(dataFavoriteHoliday);
            return  null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            hapus.sukses();
        }

    }

    @Override
    public void deleteData(DataFavoriteHoliday dataFavoriteHoliday, AppDatabase database) {
        new DeleteData(database,dataFavoriteHoliday).execute();
    }
}
