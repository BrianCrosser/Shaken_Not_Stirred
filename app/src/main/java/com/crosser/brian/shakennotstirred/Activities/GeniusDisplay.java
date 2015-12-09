package com.crosser.brian.shakennotstirred.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.crosser.brian.shakennotstirred.Models.DrinkRecipeModel;
import com.crosser.brian.shakennotstirred.Models.SearchResultModel;
import com.crosser.brian.shakennotstirred.R;
import com.crosser.brian.shakennotstirred.Services.APIClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GeniusDisplay extends AppCompatActivity {
    TextView cocktailName;
    TextView ingredient;
    TextView instructionString;
    ImageView cocktailImage;
    ListView List;

    ArrayList<DrinkRecipeModel> cocktail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genius_display);

        ingredient = (TextView) findViewById(R.id.ingredientText);
        cocktailName = (TextView) findViewById(R.id.cocktailName);
        cocktailImage = (ImageView) findViewById(R.id.cocktailImage);
        instructionString = (TextView) findViewById(R.id.instructionString);
        List = (ListView) findViewById(R.id.ingredientList);

        List.setBackgroundColor(Color.WHITE);
        List.getBackground().setAlpha(175);
        instructionString.setMovementMethod(new ScrollingMovementMethod());

        // get the intent from which this activity is called.
        Intent intent = getIntent();
        final Bundle extras = intent.getExtras();
        // fetch value from key-value pair and make it visible on TextView.

        Integer cocktail_ID = extras.getInt("cocktail-name");

        APIClient.getRecipeProvider()
                .getDrinkRecipesById(cocktail_ID)
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
                        cocktail = new ArrayList<DrinkRecipeModel>();
                        cocktail = searchResultModel.getSearchResults();

                        final ArrayList<String> ingredientList = new ArrayList<String>();
                        if (!cocktail.get(0).getIngredient1().isEmpty() || cocktail.get(0).getIngredient1().startsWith(" "))
                            ingredientList.add(cocktail.get(0).getIngredient1());
                        if (!cocktail.get(0).getIngredient2().isEmpty() || cocktail.get(0).getIngredient2().startsWith(" "))
                            ingredientList.add(cocktail.get(0).getIngredient2());
                        if (!cocktail.get(0).getIngredient3().isEmpty() || cocktail.get(0).getIngredient3().startsWith(" "))
                            ingredientList.add(cocktail.get(0).getIngredient3());
                        if (!cocktail.get(0).getIngredient4().isEmpty() || cocktail.get(0).getIngredient4().startsWith(" "))
                            ingredientList.add(cocktail.get(0).getIngredient4());
                        if (!cocktail.get(0).getIngredient5().isEmpty() || cocktail.get(0).getIngredient5().startsWith(" "))
                            ingredientList.add(cocktail.get(0).getIngredient5());
                        if (!cocktail.get(0).getIngredient6().isEmpty() || cocktail.get(0).getIngredient6().startsWith(" "))
                            ingredientList.add(cocktail.get(0).getIngredient6());
                        if (!cocktail.get(0).getIngredient7().isEmpty() || cocktail.get(0).getIngredient7().startsWith(" "))
                            ingredientList.add(cocktail.get(0).getIngredient7());
                        if (!cocktail.get(0).getIngredient8().isEmpty() || cocktail.get(0).getIngredient8().startsWith(" "))
                            ingredientList.add(cocktail.get(0).getIngredient8());
                        if (!cocktail.get(0).getIngredient9().isEmpty() || cocktail.get(0).getIngredient9().startsWith(" "))
                            ingredientList.add(cocktail.get(0).getIngredient9());
                        if (!cocktail.get(0).getIngredient10().isEmpty() || cocktail.get(0).getIngredient10().startsWith(" "))
                            ingredientList.add(cocktail.get(0).getIngredient10());
                        if (!cocktail.get(0).getIngredient11().isEmpty() || cocktail.get(0).getIngredient11().startsWith(" "))
                            ingredientList.add(cocktail.get(0).getIngredient11());
                        if (!cocktail.get(0).getIngredient12().isEmpty() || cocktail.get(0).getIngredient12().startsWith(" "))
                            ingredientList.add(cocktail.get(0).getIngredient12());
                        if (!cocktail.get(0).getIngredient13().isEmpty() || cocktail.get(0).getIngredient13().startsWith(" "))
                            ingredientList.add(cocktail.get(0).getIngredient13());
                        if (!cocktail.get(0).getIngredient14().isEmpty() || cocktail.get(0).getIngredient14().startsWith(" "))
                            ingredientList.add(cocktail.get(0).getIngredient14());
                        if (!cocktail.get(0).getIngredient15().isEmpty() || cocktail.get(0).getIngredient15().startsWith(" "))
                            ingredientList.add(cocktail.get(0).getIngredient15());

                        ArrayList<String> measureList = new ArrayList<String>();
                        if (!cocktail.get(0).getMeasure1().isEmpty() || cocktail.get(0).getMeasure1().startsWith(" "))
                            measureList.add(cocktail.get(0).getMeasure1());
                        if (!cocktail.get(0).getMeasure2().isEmpty() || cocktail.get(0).getMeasure2().startsWith(" "))
                            measureList.add(cocktail.get(0).getMeasure2());
                        if (!cocktail.get(0).getMeasure3().isEmpty() || cocktail.get(0).getMeasure3().startsWith(" "))
                            measureList.add(cocktail.get(0).getMeasure3());
                        if (!cocktail.get(0).getMeasure4().isEmpty() || cocktail.get(0).getMeasure4().startsWith(" "))
                            measureList.add(cocktail.get(0).getMeasure4());
                        if (!cocktail.get(0).getMeasure5().isEmpty() || cocktail.get(0).getMeasure5().startsWith(" "))
                            measureList.add(cocktail.get(0).getMeasure5());
                        if (!cocktail.get(0).getMeasure6().isEmpty() || cocktail.get(0).getMeasure6().startsWith(" "))
                            measureList.add(cocktail.get(0).getMeasure6());
                        if (!cocktail.get(0).getMeasure7().isEmpty() || cocktail.get(0).getMeasure7().startsWith(" "))
                            measureList.add(cocktail.get(0).getMeasure7());
                        if (!cocktail.get(0).getMeasure8().isEmpty() || cocktail.get(0).getMeasure8().startsWith(" "))
                            measureList.add(cocktail.get(0).getMeasure8());
                        if (!cocktail.get(0).getMeasure9().isEmpty() || cocktail.get(0).getMeasure9().startsWith(" "))
                            measureList.add(cocktail.get(0).getMeasure9());
                        if (!cocktail.get(0).getMeasure10().isEmpty() || cocktail.get(0).getMeasure10().startsWith(" "))
                            measureList.add(cocktail.get(0).getMeasure10());
                        if (!cocktail.get(0).getMeasure11().isEmpty() || cocktail.get(0).getMeasure11().startsWith(" "))
                            measureList.add(cocktail.get(0).getMeasure11());
                        if (!cocktail.get(0).getMeasure12().isEmpty() || cocktail.get(0).getMeasure12().startsWith(" "))
                            measureList.add(cocktail.get(0).getMeasure12());
                        if (!cocktail.get(0).getMeasure13().isEmpty() || cocktail.get(0).getMeasure13().startsWith(" "))
                            measureList.add(cocktail.get(0).getMeasure13());
                        if (!cocktail.get(0).getMeasure14().isEmpty() || cocktail.get(0).getMeasure14().startsWith(" "))
                            measureList.add(cocktail.get(0).getMeasure14());
                        if (!cocktail.get(0).getMeasure15().isEmpty() || cocktail.get(0).getMeasure15().startsWith(" "))
                            measureList.add(cocktail.get(0).getMeasure15());


                        if (cocktail != null) {
                            cocktailName.setText(cocktail.get(0).getDrinkName());
                            instructionString.setText(cocktail.get(0).getInstructions());

                            if (cocktail.get(0).getDrinkThumb() == null) {
                                cocktailImage.setImageResource(R.mipmap.noimage);
                            } else {
                                Picasso.with(getBaseContext()).load(cocktail.get(0).getDrinkThumb()).into(cocktailImage);
                            }

                            CustomArrayAdapter adapter = new CustomArrayAdapter(getBaseContext(), ingredientList, measureList);
                            List.setAdapter(adapter);
                        }

                        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {

                                List.getItemAtPosition(position);
                                String item = ingredientList.get(position);

                                Intent i = new Intent(GeniusDisplay.this, Ingredient.class);
                                i.putExtra("Item", item);

                                startActivity(i);
                                overridePendingTransition(R.anim.animation_fade_in, R.anim.animation_fade_out);
                            }
                        });
                    }
                });
    }
                    public class CustomArrayAdapter extends BaseAdapter {
                        Context context;
                        private ArrayList<String> words1;
                        private ArrayList<String> words2;

                        public CustomArrayAdapter(Context context, ArrayList<String> words1, ArrayList<String> words2) {
                            this.words1 = words1;
                            this.words2 = words2;
                            this.context = context;
                        }

                        public View getView(int position, View convertView, ViewGroup parent) {

                            View v = convertView;

                            if (v == null) {
                                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                v = inflater.inflate(R.layout.ingredient_item, null);
                            }

                            String a = (String) getItem(position);
                            String b = (String) getItem(position);

                            TextView tv1 = (TextView) v.findViewById(R.id.ingredient);
                            TextView tv2 = (TextView) v.findViewById(R.id.measure);

                            tv1.setText(words1.get(position));
                            tv2.setText(words2.get(position));

                            return v;
                        }

                        @Override
                        public int getCount() {
                            // TODO Auto-generated method stub
                            return words1.size();
                        }

                        @Override
                        public Object getItem(int position) {
                            if (position >= words1.size())
                                return words2.get(position);
                            return words1.get(position);
                        }

                        @Override
                        public long getItemId(int position) {
                            // TODO Auto-generated method stub
                            return position;
                        }
                    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cocktail_display, menu);
        return true;
    }

}

