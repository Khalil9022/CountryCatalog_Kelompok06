package com.example.countrycatalog.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countrycatalog.R;
import com.example.countrycatalog.databaseLokal.contact.HolidayContact;
import com.example.countrycatalog.databaseLokal.entity.DataFavoriteHoliday;
import com.example.countrycatalog.view.activity.EditFavoriteActivity;

import java.util.List;

public class FavoriteHolidayAdapter extends RecyclerView.Adapter<FavoriteHolidayAdapter.ViewHolder>{

    Context context;
    List<DataFavoriteHoliday> list;
    HolidayContact.hapus view;

    public FavoriteHolidayAdapter(Context context, List<DataFavoriteHoliday> list, HolidayContact.hapus view) {
        this.context = context;
        this.list = list;
        this.view = view;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_favorite, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataFavoriteHoliday dataFavoriteHoliday = list.get(position);
        holder.tv_nameHoliday.setText(dataFavoriteHoliday.getName_holiday());
        holder.tv_dateHoliday.setText(dataFavoriteHoliday.getDate_holiday());
        holder.tv_countryHoliday.setText(dataFavoriteHoliday.getName_country());

        holder.btn_hapusHoliday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.deleteData(dataFavoriteHoliday);
            }
        });

        holder.btn_editHoliday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditFavoriteActivity.class);
                intent.putExtra("namaHoliday", dataFavoriteHoliday.getName_holiday());
                intent.putExtra("dateHoliday", dataFavoriteHoliday.getDate_holiday());
                intent.putExtra("countryHoliday", dataFavoriteHoliday.getName_country());
                intent.putExtra("id", dataFavoriteHoliday.getId());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nameHoliday, tv_dateHoliday, tv_countryHoliday;
        Button btn_hapusHoliday,btn_editHoliday;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_nameHoliday = itemView.findViewById(R.id.itemfavorite_tv_nameholiday);
            tv_dateHoliday = itemView.findViewById(R.id.itemfavorite_tv_dateholiday);
            tv_countryHoliday = itemView.findViewById(R.id.itemfavorite_tv_country);

            btn_editHoliday = itemView.findViewById(R.id.itemfavorite_btn_edit);
            btn_hapusHoliday = itemView.findViewById(R.id.itemfavorite_btn_hapus);
        }
    }
}
