package com.aptech.currencyconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aptech.currencyconverter.model.CountryItem;

import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter<CountryItem> {

    //constructor to get context and list of items
    public CountryAdapter(Context ct, ArrayList<CountryItem> countryList){
        super(ct, 0, countryList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    //initialize views
    private View initView(int position, View convertView, ViewGroup parent){
        //recycle convert view
        if(convertView == null){
            //inflate custom spinner layout
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.style_spinner, parent,  false);

        }
        //hooks
        ImageView countryFlag = convertView.findViewById(R.id.country_flag);
        TextView countryName = convertView.findViewById(R.id.text_country);

        CountryItem currentItem = getItem(position);

        //if currentItem is available
        if(currentItem != null){

            countryFlag.setImageResource(currentItem.getCountryFlag());
            countryName.setText(currentItem.getCountryName());
        }

        return convertView;
    }

}
