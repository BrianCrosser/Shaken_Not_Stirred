package com.crosser.brian.shakennotstirred.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.crosser.brian.shakennotstirred.R;
import com.crosser.brian.shakennotstirred.Models.DrinkRecipeModel;

public class CocktailDisplay extends Activity {
    TextView cocktailName;
    TextView ingredient;
    ImageView cocktailImage;
    ListView ingredients;

    DrinkRecipeModel recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail_display);

        ingredient = (TextView) findViewById(R.id.ingredient);
        cocktailName = (TextView) findViewById(R.id.cocktailName);
        cocktailImage = (ImageView) findViewById(R.id.cocktailImage);
        ingredients = (ListView) findViewById(R.id.ingredients);

        ingredients.setBackgroundColor(Color.LTGRAY);

        ingredients.getBackground().setAlpha(200);

        // get the intent from which this activity is called.
        Intent intent = getIntent();

        // fetch value from key-value pair and make it visible on TextView.
        String item = intent.getStringExtra("selected-item");

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/007GoldenEye.ttf");
        cocktailName.setTypeface(tf,Typeface.BOLD);
        ingredient.setTypeface(tf,Typeface.BOLD);
        cocktailName.setText(item);

        //Picasso.with(getBaseContext()).load(recipe.drinkThumb).into(cocktailImage);

        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(CocktailDisplay.this, android.R.layout.simple_list_item_1, recipe.getIngredients());
        //ingredients.setAdapter(arrayAdapter);

        //ingredients.setAdapter(new DrinkRecipeListAdapter(DrinkRecipeModel.this, recipe.getIngredients()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cocktail_display, menu);
        return true;
    }

}
