package com.crosser.brian.shakennotstirred.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.crosser.brian.shakennotstirred.Models.SupermarketModel;
import com.crosser.brian.shakennotstirred.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends ArrayAdapter<SupermarketModel> {
    public ProductListAdapter (Context context, ArrayList<SupermarketModel> stores) {
        super(context, 0, stores);
    }

    public ProductListAdapter(Context context, int resource, List<SupermarketModel> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.product_list_item, null);
        }

        SupermarketModel product = getItem(position);

        if (product != null) {
            ImageView productImage = (ImageView) v.findViewById(R.id.productImage);
            TextView productName = (TextView) v.findViewById(R.id.productName);
            TextView productPrice = (TextView) v.findViewById(R.id.productPrice);
            TextView productAisle = (TextView) v.findViewById(R.id.productAisle);

            if (productImage != null) {
                Picasso.with(getContext()).load(product.itemImage).into(productImage);
                productImage.setImageAlpha(175);
            }
            if (productName != null) {
                productName.setText(product.getItemName());
                productPrice.setText("$" + product.getPricing());
                productAisle.setText(product.getAisleNumber());
            }
        }
        return v;

    }
}