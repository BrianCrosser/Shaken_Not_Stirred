package com.crosser.brian.shakennotstirred.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.crosser.brian.shakennotstirred.Models.StoreModel;
import com.crosser.brian.shakennotstirred.R;

import java.util.ArrayList;
import java.util.List;



public class StoreListAdapter extends ArrayAdapter<StoreModel> {
    public StoreListAdapter (Context context, ArrayList<StoreModel> stores) {
        super(context, 0, stores);
    }

    public StoreListAdapter(Context context, int resource, List<StoreModel> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.store_item, null);
        }

        StoreModel store = getItem(position);

        if (store != null) {
            TextView storeName = (TextView) v.findViewById(R.id.storeName);
            TextView storeCity = (TextView) v.findViewById(R.id.storeCity);
            TextView storeAddress = (TextView) v.findViewById(R.id.storeAddress);
            TextView storeState = (TextView) v.findViewById(R.id.storeState);

            if (storeName != null) {
                storeName.setText(store.getStorename());
            }
            if (storeName != null) {
                storeAddress.setText(store.getAddress());
            }
            if (storeCity != null) {
                storeCity.setText(store.getCity());
            }
            if (storeCity != null) {
                storeState.setText(store.getState());
            }
        }
        return v;

    }
}

