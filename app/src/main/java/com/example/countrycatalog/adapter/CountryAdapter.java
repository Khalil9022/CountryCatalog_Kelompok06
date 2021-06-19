package com.example.countrycatalog.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.countrycatalog.R;
import com.example.countrycatalog.model.country.CountriesItem;
import com.example.countrycatalog.view.activity.DetailedCountryActivity;
import com.example.countrycatalog.view.activity.DetailedHolidayActivity;
import com.example.countrycatalog.view.activity.ProfileActivity;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private ArrayList<CountriesItem> countriesItems = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<CountriesItem> items){
        countriesItems.clear();
        countriesItems.addAll(items);
        notifyDataSetChanged();
    }

    public CountryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(countriesItems.get(position)
                .getFlag())
                .into(holder.ivThumbnail);

        holder.tvCountry.setText(countriesItems.get(position).getName());

        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailedCountryActivity.class);

                intent.putExtra("name_country", countriesItems.get(position).getName());
                intent.putExtra("flag_country", countriesItems.get(position).getFlag());

                int number = position;
                intent.putExtra("id_Country", number);
                context.startActivities(new Intent[]{intent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return countriesItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumbnail;
        TextView tvCountry;
        CardView cvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivThumbnail = itemView.findViewById(R.id.itemlist_iv_thumbnail);
            tvCountry = itemView.findViewById(R.id.itemlist_tv_namecountry);
            cvItem = itemView.findViewById(R.id.itemlist_cv_item);
        }
    }
}
