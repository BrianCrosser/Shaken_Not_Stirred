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

    DrinkRecipeModel cocktail;

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
                        cocktail = searchResultModel.getCocktailResults();

                    }
                });





        final ArrayList<String> ingredientList = new ArrayList<String>();
        if (!cocktail.getIngredient1().isEmpty() || cocktail.getIngredient1().startsWith(" "))
            ingredientList.add(cocktail.getIngredient1());
        if (!cocktail.getIngredient2().isEmpty() || cocktail.getIngredient2().startsWith(" "))
            ingredientList.add(cocktail.getIngredient2());
        if (!cocktail.getIngredient3().isEmpty() || cocktail.getIngredient3().startsWith(" "))
            ingredientList.add(cocktail.getIngredient3());
        if (!cocktail.getIngredient4().isEmpty() || cocktail.getIngredient4().startsWith(" "))
            ingredientList.add(cocktail.getIngredient4());
        if (!cocktail.getIngredient5().isEmpty() || cocktail.getIngredient5().startsWith(" "))
            ingredientList.add(cocktail.getIngredient5());
        if (!cocktail.getIngredient6().isEmpty() || cocktail.getIngredient6().startsWith(" "))
            ingredientList.add(cocktail.getIngredient6());
        if (!cocktail.getIngredient7().isEmpty() || cocktail.getIngredient7().startsWith(" "))
            ingredientList.add(cocktail.getIngredient7());
        if (!cocktail.getIngredient8().isEmpty() || cocktail.getIngredient8().startsWith(" "))
            ingredientList.add(cocktail.getIngredient8());
        if (!cocktail.getIngredient9().isEmpty() || cocktail.getIngredient9().startsWith(" "))
            ingredientList.add(cocktail.getIngredient9());
        if (!cocktail.getIngredient10().isEmpty() || cocktail.getIngredient10().startsWith(" "))
            ingredientList.add(cocktail.getIngredient10());
        if (!cocktail.getIngredient11().isEmpty() || cocktail.getIngredient11().startsWith(" "))
            ingredientList.add(cocktail.getIngredient11());
        if (!cocktail.getIngredient12().isEmpty() || cocktail.getIngredient12().startsWith(" "))
            ingredientList.add(cocktail.getIngredient12());
        if (!cocktail.getIngredient13().isEmpty() || cocktail.getIngredient13().startsWith(" "))
            ingredientList.add(cocktail.getIngredient13());
        if (!cocktail.getIngredient14().isEmpty() || cocktail.getIngredient14().startsWith(" "))
            ingredientList.add(cocktail.getIngredient14());
        if (!cocktail.getIngredient15().isEmpty() || cocktail.getIngredient15().startsWith(" "))
            ingredientList.add(cocktail.getIngredient15());

        ArrayList<String> measureList = new ArrayList<String>();
        if (!cocktail.getMeasure1().isEmpty() || cocktail.getMeasure1().startsWith(" "))
            measureList.add(cocktail.getMeasure1());
        if (!cocktail.getMeasure2().isEmpty() || cocktail.getMeasure2().startsWith(" "))
            measureList.add(cocktail.getMeasure2());
        if (!cocktail.getMeasure3().isEmpty() || cocktail.getMeasure3().startsWith(" "))
            measureList.add(cocktail.getMeasure3());
        if (!cocktail.getMeasure4().isEmpty() || cocktail.getMeasure4().startsWith(" "))
            measureList.add(cocktail.getMeasure4());
        if (!cocktail.getMeasure5().isEmpty() || cocktail.getMeasure5().startsWith(" "))
            measureList.add(cocktail.getMeasure5());
        if (!cocktail.getMeasure6().isEmpty() || cocktail.getMeasure6().startsWith(" "))
            measureList.add(cocktail.getMeasure6());
        if (!cocktail.getMeasure7().isEmpty() || cocktail.getMeasure7().startsWith(" "))
            measureList.add(cocktail.getMeasure7());
        if (!cocktail.getMeasure8().isEmpty() || cocktail.getMeasure8().startsWith(" "))
            measureList.add(cocktail.getMeasure8());
        if (!cocktail.getMeasure9().isEmpty() || cocktail.getMeasure9().startsWith(" "))
            measureList.add(cocktail.getMeasure9());
        if (!cocktail.getMeasure10().isEmpty() || cocktail.getMeasure10().startsWith(" "))
            measureList.add(cocktail.getMeasure10());
        if (!cocktail.getMeasure11().isEmpty() || cocktail.getMeasure11().startsWith(" "))
            measureList.add(cocktail.getMeasure11());
        if (!cocktail.getMeasure12().isEmpty() || cocktail.getMeasure12().startsWith(" "))
            measureList.add(cocktail.getMeasure12());
        if (!cocktail.getMeasure13().isEmpty() || cocktail.getMeasure13().startsWith(" "))
            measureList.add(cocktail.getMeasure13());
        if (!cocktail.getMeasure14().isEmpty() || cocktail.getMeasure14().startsWith(" "))
            measureList.add(cocktail.getMeasure14());
        if (!cocktail.getMeasure15().isEmpty() || cocktail.getMeasure15().startsWith(" "))
            measureList.add(cocktail.getMeasure15());


        if (cocktail != null) {
            cocktailName.setText(cocktail.getDrinkName());
            instructionString.setText(cocktail.getInstructions());

            if (cocktail.getDrinkThumb() == null) {
                cocktailImage.setImageResource(R.mipmap.noimage);
            } else {
                Picasso.with(getBaseContext()).load(cocktail.getDrinkThumb()).into(cocktailImage);
            }


            CustomArrayAdapter adapter = new CustomArrayAdapter(getBaseContext(), ingredientList, measureList);
            List.setAdapter(adapter);
        }

        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {

                List.getItemAtPosition(position);
                String item = ingredientList.get(position);

                Intent i=new Intent(GeniusDisplay.this, Ingredient.class);
                i.putExtra("Item", item);

                startActivity(i);
                overridePendingTransition(R.anim.animation_fade_in, R.anim.animation_fade_out);
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
