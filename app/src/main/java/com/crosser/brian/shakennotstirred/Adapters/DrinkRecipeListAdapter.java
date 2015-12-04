package com.crosser.brian.shakennotstirred.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.crosser.brian.shakennotstirred.R;
import com.crosser.brian.shakennotstirred.Models.DrinkRecipeModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class DrinkRecipeListAdapter extends ArrayAdapter<DrinkRecipeModel>{
    public DrinkRecipeListAdapter (Context context, ArrayList<DrinkRecipeModel> recipes) {
        super(context, 0, recipes);
    }

    public DrinkRecipeListAdapter(Context context, int resource, List<DrinkRecipeModel> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.recipe_item, null);
        }

        DrinkRecipeModel recipe = getItem(position);

        if (recipe != null) {
            TextView nameText = (TextView) v.findViewById(R.id.nameText);
            TextView ingredient1 = (TextView) v.findViewById(R.id.ingredient1);
            TextView ingredient2 = (TextView) v.findViewById(R.id.ingredient2);
            ImageView icon = (ImageView) v.findViewById(R.id.cocktailThumb);

            if (icon != null) {
                if (recipe.drinkThumb == null) {
                    icon.setImageResource(R.mipmap.noimage);
                    icon.setImageAlpha(175);
                } else {
                    Picasso.with(getContext()).load(recipe.drinkThumb).into(icon);
                    icon.setImageAlpha(175);
                }
            }
            if (nameText != null) {
                nameText.setText(recipe.getDrinkName());
                ingredient1.setText(recipe.getIngredient1());
                ingredient2.setText(recipe.getIngredient2());
            }
        }
        return v;

    }
}

