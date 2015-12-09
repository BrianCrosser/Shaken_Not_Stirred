package com.crosser.brian.shakennotstirred.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.crosser.brian.shakennotstirred.Adapters.DrinkRecipeListAdapter;
import com.crosser.brian.shakennotstirred.Models.DrinkRecipeModel;
import com.crosser.brian.shakennotstirred.Models.SearchResultModel;
import com.crosser.brian.shakennotstirred.R;
import com.crosser.brian.shakennotstirred.Services.APIClient;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GeniusActivity extends AppCompatActivity {

    String ingredient1 = "Tequila";
    String ingredient2 = "Triple Sec";
    String ingredient3 = "Lime Juice";

    ArrayList <DrinkRecipeModel> firstSearchList;
    ArrayList <DrinkRecipeModel> secondSearchList;
    ArrayList <DrinkRecipeModel> thirdSearchList;

    ArrayList <DrinkRecipeModel> fourthSearchList;
    ArrayList <DrinkRecipeModel> finalSearchList;

    Button geniusButton;
    ListView geniusList;
    TextView geniusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genius);

        geniusButton = (Button) findViewById(R.id.geniusButton);
        geniusList = (ListView) findViewById(R.id.geniusList);
        geniusText = (TextView) findViewById(R.id.geniusText);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/007GoldenEye.ttf");
        geniusText.setTypeface(tf);

        geniusList.setBackgroundColor(Color.LTGRAY);
        geniusButton.getBackground().setAlpha(200);
        geniusList.getBackground().setAlpha(200);

        geniusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIClient.getRecipeProvider()
                        .getDrinkRecipesByIngredient2(ingredient1)
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

                            }

                            @Override
                            public void onError(Throwable e) {
                                int i = 0;
                            }

                            @Override
                            public void onNext(SearchResultModel searchResultModel) {
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

                            }

                            @Override
                            public void onError(Throwable e) {
                                int i = 0;
                            }

                            @Override
                            public void onNext(SearchResultModel searchResultModel) {
                                thirdSearchList = searchResultModel.getSearchResults();
                                finalSearchList = new ArrayList<DrinkRecipeModel>();
                                for (int i = 0; i < fourthSearchList.size(); i++) {
                                    for (int j = 0; j < thirdSearchList.size(); j++) {
                                        if (fourthSearchList.get(i).getDrinkId() == (thirdSearchList.get(j).getDrinkId())) {
                                            finalSearchList.add(thirdSearchList.get(j));
                                        }
                                    }
                                }
                                geniusList.setAdapter(new DrinkRecipeListAdapter(GeniusActivity.this, finalSearchList));
                            }
                        });
            }
        });

        geniusList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {

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

            }
        });

    }

}
