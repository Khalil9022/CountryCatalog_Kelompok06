package com.example.countrycatalog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countrycatalog.R;
import com.example.countrycatalog.model.country.CountriesItem;

import java.util.ArrayList;

public class SubdivisionAdapter extends RecyclerView.Adapter<SubdivisionAdapter.ViewHolder> {

    private ArrayList<CountriesItem> countriesItems = new ArrayList<>();
    Context context;

    public void setData(ArrayList<CountriesItem> items){
        countriesItems.clear();
        countriesItems.addAll(items);
        notifyDataSetChanged();
    }

    public SubdivisionAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subdivision,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int number = Integer.parseInt((String) holder.tv_number.getText());

        holder.tv_nameSubdivision.setText(countriesItems.get(number).getSubdivisions().get(position).getName());
        holder.tv_codeSubdivision.setText(countriesItems.get(number).getSubdivisions().get(position).getCode());
    }

    @Override
    public int getItemCount() {
        return countriesItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nameSubdivision,tv_codeSubdivision,tv_number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_nameSubdivision = itemView.findViewById(R.id.itemsubdivision_tv_nameSubdivision);
            tv_codeSubdivision = itemView.findViewById(R.id.itemsubdivision_tv_codeSubdivision);
            tv_number = itemView.findViewById(R.id.itemsubdivision_tv_number);
        }
    }
}
