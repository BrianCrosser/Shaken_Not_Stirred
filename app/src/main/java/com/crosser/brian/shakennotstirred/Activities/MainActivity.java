package com.crosser.brian.shakennotstirred.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.crosser.brian.shakennotstirred.R;
import com.crosser.brian.shakennotstirred.Models.DrinkRecipeModel;
import com.crosser.brian.shakennotstirred.Models.SearchResultModel;
import com.crosser.brian.shakennotstirred.Services.APIClient;
import com.squareup.picasso.Picasso;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends Activity {

    ImageButton button1;
    ImageButton button2;
    ImageButton button3;
    ImageButton button4;
    ImageButton button5;
    TextView randomCocktail;
    TextView randomCocktailText;
    ImageButton randomCocktailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomCocktail = (TextView) findViewById(R.id.randomCocktail);
        randomCocktailText = (TextView) findViewById(R.id.randomCocktailText);
        randomCocktailImage = (ImageButton) findViewById(R.id.randomCocktailImage);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/007GoldenEye.ttf");
        randomCocktail.setTypeface(tf,Typeface.BOLD);
        randomCocktailText.setTypeface(tf,Typeface.BOLD);


        button1 = (ImageButton) findViewById(R.id.button1);
        button2 = (ImageButton) findViewById(R.id.button2);
        button3 = (ImageButton) findViewById(R.id.button3);
        button4 = (ImageButton) findViewById(R.id.button4);
        button5 = (ImageButton) findViewById(R.id.button5);

        //transparent buttons
        button1.getBackground().setAlpha(175);
        button2.getBackground().setAlpha(175);
        button3.getBackground().setAlpha(175);
        button4.getBackground().setAlpha(175);
        button5.getBackground().setAlpha(175);
        randomCocktailImage.getBackground().setAlpha(175);

        button5.setImageResource(R.mipmap.ic_bacgreen);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SearchActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BAC_CalculatorActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Inventory.class);
                startActivityForResult(intent, 0);
            }
        });

        APIClient.getRecipeProvider()
                .getRandomDrinkRecipe()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SearchResultModel>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        int i = 0;
                    }

                    @Override
                    public void onNext(final SearchResultModel searchResultModel) {
                        final DrinkRecipeModel drink = searchResultModel.getSearchResults().get(0);
                        randomCocktailText.setText(drink.drinkName);

                        if (drink.drinkThumb == null) {
                            randomCocktailImage.setImageResource(R.mipmap.noimage);
                        } else {
                            Picasso.with(getBaseContext()).load(drink.drinkThumb).into(randomCocktailImage);
                        }

                        randomCocktailImage.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                DrinkRecipeModel value = searchResultModel.getSearchResults().get(0);
                                // selected item
                                String cocktail = value.getDrinkName();
                                String cocktailImage = value.getDrinkThumb();
                                String instructions = value.getInstructions();

                                String ingredient1 = value.getIngredient1();
                                String ingredient2 = value.getIngredient2();
                                String ingredient3 = value.getIngredient3();
                                String ingredient4 = value.getIngredient4();
                                String ingredient5 = value.getIngredient5();
                                String ingredient6 = value.getIngredient6();
                                String ingredient7 = value.getIngredient7();
                                String ingredient8 = value.getIngredient8();
                                String ingredient9 = value.getIngredient9();
                                String ingredient10 = value.getIngredient10();
                                String ingredient11 = value.getIngredient11();
                                String ingredient12 = value.getIngredient12();
                                String ingredient13 = value.getIngredient13();
                                String ingredient14 = value.getIngredient14();
                                String ingredient15 = value.getIngredient15();

                                String measure1 = value.getMeasure1();
                                String measure2 = value.getMeasure2();
                                String measure3 = value.getMeasure3();
                                String measure4 = value.getMeasure4();
                                String measure5 = value.getMeasure5();
                                String measure6 = value.getMeasure6();
                                String measure7 = value.getMeasure7();
                                String measure8 = value.getMeasure8();
                                String measure9 = value.getMeasure9();
                                String measure10 = value.getMeasure10();
                                String measure11 = value.getMeasure11();
                                String measure12 = value.getMeasure12();
                                String measure13 = value.getMeasure13();
                                String measure14 = value.getMeasure14();
                                String measure15 = value.getMeasure15();

                                Intent myIntent = new Intent(getApplicationContext(), CocktailDisplay.class);
                                // sending data to new activity
                                Bundle extras = new Bundle();
                                extras.putString("cocktail-name", cocktail);
                                extras.putString("cocktail-image", cocktailImage);
                                extras.putString("cocktail-instr", instructions);

                                extras.putString("cocktail-ingredient1", ingredient1);
                                extras.putString("cocktail-ingredient2", ingredient2);
                                extras.putString("cocktail-ingredient3", ingredient3);
                                extras.putString("cocktail-ingredient4", ingredient4);
                                extras.putString("cocktail-ingredient5", ingredient5);
                                extras.putString("cocktail-ingredient6", ingredient6);
                                extras.putString("cocktail-ingredient7", ingredient7);
                                extras.putString("cocktail-ingredient8", ingredient8);
                                extras.putString("cocktail-ingredient9", ingredient9);
                                extras.putString("cocktail-ingredient10", ingredient10);
                                extras.putString("cocktail-ingredient11", ingredient11);
                                extras.putString("cocktail-ingredient12", ingredient12);
                                extras.putString("cocktail-ingredient13", ingredient13);
                                extras.putString("cocktail-ingredient14", ingredient14);
                                extras.putString("cocktail-ingredient15", ingredient15);

                                extras.putString("cocktail-measure1", measure1);
                                extras.putString("cocktail-measure2", measure2);
                                extras.putString("cocktail-measure3", measure3);
                                extras.putString("cocktail-measure4", measure4);
                                extras.putString("cocktail-measure5", measure5);
                                extras.putString("cocktail-measure6", measure6);
                                extras.putString("cocktail-measure7", measure7);
                                extras.putString("cocktail-measure8", measure8);
                                extras.putString("cocktail-measure9", measure9);
                                extras.putString("cocktail-measure10", measure10);
                                extras.putString("cocktail-measure11", measure11);
                                extras.putString("cocktail-measure12", measure12);
                                extras.putString("cocktail-measure13", measure13);
                                extras.putString("cocktail-measure14", measure14);
                                extras.putString("cocktail-measure15", measure15);

                                myIntent.putExtras(extras);
                                startActivity(myIntent);

                            }
                        });

                    }
                });


    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        String FILENAME = "CalculatorInfo";
        float bac = -1;
        String bacS="";
        FileInputStream fin = null;
        try {
            fin = openFileInput(FILENAME);
            int c;
            try {
                while( (c = fin.read()) != -1){
                    bacS = bacS + Character.toString((char)c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            bac = 0;
        }

        if(bac == -1 && bacS != "")
            bac = Float.parseFloat(bacS);
        else{
            try {
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(bac < .03)
            button5.setImageResource(R.mipmap.ic_bacgreen);
        else if (bac <= .06 && bac >= .03)
            button5.setImageResource(R.mipmap.ic_bacyellow);
        else if (bac > .06)
            button5.setImageResource(R.mipmap.ic_bac);
    }
}