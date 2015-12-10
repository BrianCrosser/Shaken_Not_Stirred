package com.crosser.brian.shakennotstirred.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.crosser.brian.shakennotstirred.Adapters.DrinkRecipeListAdapter;
import com.crosser.brian.shakennotstirred.Adapters.InventoryListAdapter;
import com.crosser.brian.shakennotstirred.Models.DrinkRecipeModel;
import com.crosser.brian.shakennotstirred.Models.SearchResultModel;
import com.crosser.brian.shakennotstirred.R;
import com.crosser.brian.shakennotstirred.Services.APIClient;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GeniusActivity extends Activity {

    String ingredient1;
    String ingredient2;
    String ingredient3;
    String[] ingredientArray;
    TextView header;
    private InventoryListAdapter InventoryDatabaseHelper;
    private ListView cabinetView;
    Integer ingredientNumber = 1;

    ArrayList <DrinkRecipeModel> firstSearchList;
    ArrayList <DrinkRecipeModel> secondSearchList;
    ArrayList <DrinkRecipeModel> thirdSearchList;

    ArrayList <DrinkRecipeModel> fourthSearchList;
    ArrayList <DrinkRecipeModel> finalSearchList;

    Button geniusButton;
    Button resetButton;
    ListView geniusList;
    TextView geniusText;
    TextView ingredientFirst;
    TextView ingredientSecond;
    TextView ingredientThird;
    TextView noDrinks;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genius);

        ingredientFirst = (TextView) findViewById(R.id.ingredient1);
        ingredientSecond = (TextView) findViewById(R.id.ingredient2);
        ingredientThird = (TextView) findViewById(R.id.ingredient3);
        noDrinks = (TextView) findViewById(R.id.noDrinks);

        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);

        InventoryDatabaseHelper = new InventoryListAdapter(this);
        header = (TextView) findViewById(R.id.header);

        cabinetView =(ListView) findViewById(R.id.cabinetView);
        // formatting
        cabinetView.setBackgroundColor(Color.LTGRAY);
        cabinetView.getBackground().setAlpha(200);

        final ArrayList<String> data = InventoryDatabaseHelper.getAllIngredients();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                data);
        cabinetView.setAdapter(adapter);

        cabinetView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //cabinetView.setOnItemLongClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                spinner.setVisibility(View.VISIBLE);
                if (ingredientNumber == 1) {
                    ingredient1 = data.get(position);
                    spinner.setVisibility(View.GONE);
                    ingredientFirst.setText("Ingredient 1: " + ingredient1);
                } else if (ingredientNumber == 2) {
                    ingredient2 = data.get(position);
                    spinner.setVisibility(View.GONE);
                    ingredientSecond.setText("Ingredient 2: " + ingredient2);
                } else {
                    ingredient3 = data.get(position);
                    ingredientNumber = 0;
                    spinner.setVisibility(View.GONE);
                    ingredientThird.setText("Ingredient 3: " + ingredient3);
                }
                ingredientNumber++;
            }
        });


        geniusButton = (Button) findViewById(R.id.geniusButton);
        geniusList = (ListView) findViewById(R.id.geniusList);
        geniusText = (TextView) findViewById(R.id.geniusText);
        resetButton = (Button) findViewById(R.id.resetButton);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/007GoldenEye.ttf");
        //geniusText.setTypeface(tf);
        geniusText.setTypeface(tf, Typeface.BOLD);
        geniusList.setBackgroundColor(Color.LTGRAY);
        geniusButton.getBackground().setAlpha(200);
        resetButton.getBackground().setAlpha(200);
        geniusList.getBackground().setAlpha(200);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), GeniusActivity.class);
                finish();
                startActivityForResult(intent, 0);
                overridePendingTransition(R.anim.animation_left_in, R.anim.animation_left_out);
                spinner.setVisibility(View.VISIBLE);
                ;
            }
        });

        geniusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cabinetView.setVisibility(View.INVISIBLE);
                spinner.setVisibility(View.VISIBLE);
                if(ingredient3 != null){
                    APIClient.getRecipeProvider()
                            .getDrinkRecipesByIngredient2(ingredient1)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Subscriber<SearchResultModel>() {

                                @Override
                                public void onCompleted() {
                                    spinner.setVisibility(View.GONE);
                                }

                                @Override
                                public void onError(Throwable e) {
                                    int i = 0;
                                }

                                @Override
                                public void onNext(SearchResultModel searchResultModel) {
                                    spinner.setVisibility(View.GONE);
                                    firstSearchList = searchResultModel.getSearchResults();
                                }
                    });
                    APIClient.getRecipeProvider()
                            .getDrinkRecipesByIngredient2(ingredient2)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Subscriber<SearchResultModel>() {

                                @Override
                                public void onCompleted() {
                                    spinner.setVisibility(View.GONE);
                                }

                                @Override
                                public void onError(Throwable e) {
                                    int i = 0;
                                }

                                @Override
                                public void onNext(SearchResultModel searchResultModel) {
                                    spinner.setVisibility(View.GONE);
                                    secondSearchList = searchResultModel.getSearchResults();
                                /*
                                for (DrinkRecipeModel drinkRecipeModel : firstSearchList) {
                                    if (secondSearchList.equals(firstSearchList)) {
                                        fourthSearchList.add(drinkRecipeModel);
                                    }
                                }
                                */
                                    fourthSearchList = new ArrayList<DrinkRecipeModel>();
                                    for (int i = 0; i < firstSearchList.size(); i++) {
                                        for (int j = 0; j < secondSearchList.size(); j++) {
                                            if (firstSearchList.get(i).getDrinkId() == (secondSearchList.get(j).getDrinkId())) {
                                                fourthSearchList.add(secondSearchList.get(j));
                                            }
                                        }
                                    }

                                }
                    });

                    APIClient.getRecipeProvider()
                            .getDrinkRecipesByIngredient2(ingredient3)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Subscriber<SearchResultModel>() {

                                @Override
                                public void onCompleted() {
                                    spinner.setVisibility(View.GONE);
                                }

                                @Override
                                public void onError(Throwable e) {
                                    int i = 0;
                                }

                                @Override
                                public void onNext(SearchResultModel searchResultModel) {
                                    spinner.setVisibility(View.GONE);
                                    thirdSearchList = searchResultModel.getSearchResults();
                                    finalSearchList = new ArrayList<DrinkRecipeModel>();
                                    for (int i = 0; i < fourthSearchList.size(); i++) {
                                        for (int j = 0; j < thirdSearchList.size(); j++) {
                                            if (fourthSearchList.get(i).getDrinkId() == (thirdSearchList.get(j).getDrinkId())) {
                                                finalSearchList.add(thirdSearchList.get(j));
                                            }
                                        }
                                    }
                                    if (finalSearchList.isEmpty())
                                        noDrinks.setVisibility(View.VISIBLE);
                                    else
                                        geniusList.setAdapter(new DrinkRecipeListAdapter(GeniusActivity.this, finalSearchList));
                                    spinner.setVisibility(View.GONE);
                                }
                            });
                }
                else{
                    APIClient.getRecipeProvider()
                            .getDrinkRecipesByIngredient2(ingredient1)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Subscriber<SearchResultModel>() {

                                @Override
                                public void onCompleted() {
                                    spinner.setVisibility(View.GONE);
                                }

                                @Override
                                public void onError(Throwable e) {
                                    int i = 0;
                                }

                                @Override
                                public void onNext(SearchResultModel searchResultModel) {
                                    spinner.setVisibility(View.GONE);
                                    firstSearchList = searchResultModel.getSearchResults();
                                }
                            });
                    APIClient.getRecipeProvider()
                            .getDrinkRecipesByIngredient2(ingredient2)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Subscriber<SearchResultModel>() {

                                @Override
                                public void onCompleted() {
                                    spinner.setVisibility(View.GONE);
                                }

                                @Override
                                public void onError(Throwable e) {
                                    int i = 0;
                                }

                                @Override
                                public void onNext(SearchResultModel searchResultModel) {
                                    spinner.setVisibility(View.GONE);
                                    secondSearchList = searchResultModel.getSearchResults();
                                      fourthSearchList = new ArrayList<DrinkRecipeModel>();
                                    for (int i = 0; i < firstSearchList.size(); i++) {
                                        for (int j = 0; j < secondSearchList.size(); j++) {
                                            if (firstSearchList.get(i).getDrinkId() == (secondSearchList.get(j).getDrinkId())) {
                                                fourthSearchList.add(secondSearchList.get(j));
                                            }
                                        }
                                    }
                                    if (fourthSearchList.isEmpty())
                                        noDrinks.setVisibility(View.VISIBLE);
                                    else
                                        geniusList.setAdapter(new DrinkRecipeListAdapter(GeniusActivity.this, fourthSearchList));
                                    spinner.setVisibility(View.GONE);
                                }
                            });
                }
            }
        });

        geniusList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
                spinner.setVisibility(View.VISIBLE);

                DrinkRecipeModel value = (DrinkRecipeModel) geniusList.getItemAtPosition(position);
                // selected item
                Integer cocktail = value.getDrinkId();

                Intent myIntent = new Intent(getApplicationContext(), GeniusDisplay.class);
                // sending data to new activity
                Bundle extras = new Bundle();
                extras.putInt("cocktail-name", cocktail);

                myIntent.putExtras(extras);
                startActivity(myIntent);
                overridePendingTransition(R.anim.animation_left_in, R.anim.animation_left_out);
                spinner.setVisibility(View.GONE);
            }
        });

    }
    @Override
    public void onBackPressed() {
        spinner.setVisibility(View.GONE);
        super.onBackPressed();
    }
    @Override
    public void onResume() {
        spinner.setVisibility(View.GONE);
        super.onResume();
    }
}
