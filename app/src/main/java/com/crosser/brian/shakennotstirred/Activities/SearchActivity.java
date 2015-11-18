package com.crosser.brian.shakennotstirred.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.crosser.brian.shakennotstirred.R;
import com.crosser.brian.shakennotstirred.Adapters.DrinkRecipeListAdapter;
import com.crosser.brian.shakennotstirred.Models.DrinkRecipeModel;
import com.crosser.brian.shakennotstirred.Models.SearchResultModel;
import com.crosser.brian.shakennotstirred.Services.APIClient;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchActivity extends Activity {

    private ListView ListView1;
    private Button searchButton;
    private EditText searchInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ListView1 = (ListView) findViewById(R.id.ListView1);
        searchButton = (Button) findViewById(R.id.searchButton);
        searchInput = (EditText) findViewById(R.id.searchInput);

        searchInput.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        ListView1.setBackgroundColor(Color.LTGRAY);

        searchInput.getBackground().setAlpha(200);
        searchButton.getBackground().setAlpha(200);
        ListView1.getBackground().setAlpha(200);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIClient.getRecipeProvider()
                        .getDrinkRecipesByIngredient(searchInput.getText().toString())
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
                                ListView1.setAdapter(new DrinkRecipeListAdapter(SearchActivity.this, searchResultModel.getSearchResults()));

                            }
                        });
            }
        });

        ListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {

                DrinkRecipeModel value = (DrinkRecipeModel) ListView1.getItemAtPosition(position);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
