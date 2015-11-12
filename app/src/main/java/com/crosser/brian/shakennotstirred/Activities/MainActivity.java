package com.crosser.brian.shakennotstirred.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.crosser.brian.shakennotstirred.R;
import com.crosser.brian.shakennotstirred.Models.DrinkRecipeModel;
import com.crosser.brian.shakennotstirred.Models.SearchResultModel;
import com.crosser.brian.shakennotstirred.Services.APIClient;
import com.squareup.picasso.Picasso;

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
    ImageView randomCocktailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomCocktail = (TextView) findViewById(R.id.randomCocktail);
        randomCocktailText = (TextView) findViewById(R.id.randomCocktailText);
        randomCocktailImage = (ImageView) findViewById(R.id.randomCocktailImage);

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
                    public void onNext(SearchResultModel searchResultModel) {
                        DrinkRecipeModel drink = (DrinkRecipeModel) searchResultModel.getSearchResults().get(0);
                        randomCocktailText.setText(drink.drinkName);
                        Picasso.with(getBaseContext()).load(drink.drinkThumb).into(randomCocktailImage);

                    }
                });

    }

}