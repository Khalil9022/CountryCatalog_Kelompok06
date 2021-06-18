package com.example.countrycatalog.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countrycatalog.R;
import com.example.countrycatalog.model.country.CountriesItem;
import com.example.countrycatalog.model.holiday.HolidaysItem;
import com.example.countrycatalog.view.activity.ProfileActivity;

import java.util.ArrayList;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.ViewHolder>{

    private ArrayList<HolidaysItem> holidaysItems = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<HolidaysItem> items){
        holidaysItems.clear();
        holidaysItems.addAll(items);
        notifyDataSetChanged();
    }

    public HolidayAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_holiday,parent,false);
        return new HolidayAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNameHoliday.setText(holidaysItems.get(position).getName());
        holder.tvDateHoliday.setText(holidaysItems.get(position).getDate());
        holder.tvCountryHoliday.setText(holidaysItems.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        return holidaysItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNameHoliday,tvDateHoliday,tvCountryHoliday;
        CardView cvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameHoliday = itemView.findViewById(R.id.itemholiday_tv_nameholiday);
            tvDateHoliday = itemView.findViewById(R.id.itemholiday_tv_dateholiday);
            tvCountryHoliday = itemView.findViewById(R.id.itemholiday_tv_country);
            cvItem = itemView.findViewById(R.id.itemholiday_cv_item);
        }
    }
}
