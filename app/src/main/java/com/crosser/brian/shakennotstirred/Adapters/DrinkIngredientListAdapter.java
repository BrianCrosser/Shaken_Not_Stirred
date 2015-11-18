package com.crosser.brian.shakennotstirred.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.crosser.brian.shakennotstirred.Models.DrinkRecipeModel;
import com.crosser.brian.shakennotstirred.R;

import java.util.ArrayList;
import java.util.List;


public class DrinkIngredientListAdapter extends ArrayAdapter<DrinkRecipeModel> {
    public DrinkIngredientListAdapter(Context context, ArrayList<DrinkRecipeModel> recipes) {
        super(context, 0, recipes);
    }

    public DrinkIngredientListAdapter(Context context, int resource, List<DrinkRecipeModel> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.ingredient_item, null);
        }

        DrinkRecipeModel recipe = getItem(position);

        if (recipe != null) {
            TextView ingredient = (TextView) v.findViewById(R.id.ingredient);
            TextView measure = (TextView) v.findViewById(R.id.measure);

            if (ingredient != null) {
                ingredient.setText(recipe.getIngredient1());
                ingredient.setText(recipe.getIngredient2());
                ingredient.setText(recipe.getIngredient3());
                ingredient.setText(recipe.getIngredient4());
                ingredient.setText(recipe.getIngredient5());
                ingredient.setText(recipe.getIngredient6());
                ingredient.setText(recipe.getIngredient7());
                ingredient.setText(recipe.getIngredient8());
                ingredient.setText(recipe.getIngredient9());
                ingredient.setText(recipe.getIngredient10());
                ingredient.setText(recipe.getIngredient11());
                ingredient.setText(recipe.getIngredient12());
                ingredient.setText(recipe.getIngredient13());
                ingredient.setText(recipe.getIngredient14());
                ingredient.setText(recipe.getIngredient15());
            }
            if (measure != null) {
                measure.setText(recipe.getMeasure1());
                measure.setText(recipe.getMeasure2());
                measure.setText(recipe.getMeasure3());
                measure.setText(recipe.getMeasure4());
                measure.setText(recipe.getMeasure5());
                measure.setText(recipe.getMeasure6());
                measure.setText(recipe.getMeasure7());
                measure.setText(recipe.getMeasure8());
                measure.setText(recipe.getMeasure9());
                measure.setText(recipe.getMeasure10());
                measure.setText(recipe.getMeasure11());
                measure.setText(recipe.getMeasure12());
                measure.setText(recipe.getMeasure13());
                measure.setText(recipe.getMeasure14());
                measure.setText(recipe.getMeasure15());
            }

        }
        return v;
    }
}

