package com.crosser.brian.shakennotstirred.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.crosser.brian.shakennotstirred.Models.DrinkRecipeModel;
import com.crosser.brian.shakennotstirred.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CocktailDisplay extends Activity {
    TextView cocktailName;
    TextView ingredient;
    TextView instructionString;
    ImageView cocktailImage;
    ListView List;
    private ProgressBar spinner;
    DrinkRecipeModel recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail_display);

        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);
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

        String cocktail_Name = extras.getString("cocktail-name");
        String cocktail_Image = extras.getString("cocktail-image");
        String cocktail_instr = extras.getString("cocktail-instr");

        String cocktail_ingredient1 = extras.getString("cocktail-ingredient1");
        String cocktail_ingredient2 = extras.getString("cocktail-ingredient2");
        String cocktail_ingredient3 = extras.getString("cocktail-ingredient3");
        String cocktail_ingredient4 = extras.getString("cocktail-ingredient4");
        String cocktail_ingredient5 = extras.getString("cocktail-ingredient5");
        String cocktail_ingredient6 = extras.getString("cocktail-ingredient6");
        String cocktail_ingredient7 = extras.getString("cocktail-ingredient7");
        String cocktail_ingredient8 = extras.getString("cocktail-ingredient8");
        String cocktail_ingredient9 = extras.getString("cocktail-ingredient9");
        String cocktail_ingredient10 = extras.getString("cocktail-ingredient10");
        String cocktail_ingredient11 = extras.getString("cocktail-ingredient11");
        String cocktail_ingredient12 = extras.getString("cocktail-ingredient12");
        String cocktail_ingredient13 = extras.getString("cocktail-ingredient13");
        String cocktail_ingredient14 = extras.getString("cocktail-ingredient14");
        String cocktail_ingredient15 = extras.getString("cocktail-ingredient15");

        String cocktail_measure1 = extras.getString("cocktail-measure1");
        String cocktail_measure2 = extras.getString("cocktail-measure2");
        String cocktail_measure3 = extras.getString("cocktail-measure3");
        String cocktail_measure4 = extras.getString("cocktail-measure4");
        String cocktail_measure5 = extras.getString("cocktail-measure5");
        String cocktail_measure6 = extras.getString("cocktail-measure6");
        String cocktail_measure7 = extras.getString("cocktail-measure7");
        String cocktail_measure8 = extras.getString("cocktail-measure8");
        String cocktail_measure9 = extras.getString("cocktail-measure9");
        String cocktail_measure10 = extras.getString("cocktail-measure10");
        String cocktail_measure11 = extras.getString("cocktail-measure11");
        String cocktail_measure12 = extras.getString("cocktail-measure12");
        String cocktail_measure13 = extras.getString("cocktail-measure13");
        String cocktail_measure14 = extras.getString("cocktail-measure14");
        String cocktail_measure15 = extras.getString("cocktail-measure15");

        final ArrayList<String> ingredientList = new ArrayList<String>();
        if (!cocktail_ingredient1.isEmpty() || cocktail_ingredient1.startsWith(" "))
            ingredientList.add(cocktail_ingredient1);
        if (!cocktail_ingredient2.isEmpty() || cocktail_ingredient2.startsWith(" "))
            ingredientList.add(cocktail_ingredient2);
        if (!cocktail_ingredient3.isEmpty() || cocktail_ingredient3.startsWith(" "))
            ingredientList.add(cocktail_ingredient3);
        if (!cocktail_ingredient4.isEmpty() || cocktail_ingredient4.startsWith(" "))
            ingredientList.add(cocktail_ingredient4);
        if (!cocktail_ingredient5.isEmpty() || cocktail_ingredient5.startsWith(" "))
            ingredientList.add(cocktail_ingredient5);
        if (!cocktail_ingredient6.isEmpty() || cocktail_ingredient6.startsWith(" "))
            ingredientList.add(cocktail_ingredient6);
        if (!cocktail_ingredient7.isEmpty() || cocktail_ingredient7.startsWith(" "))
            ingredientList.add(cocktail_ingredient7);
        if (!cocktail_ingredient8.isEmpty() || cocktail_ingredient8.startsWith(" "))
            ingredientList.add(cocktail_ingredient8);
        if (!cocktail_ingredient9.isEmpty() || cocktail_ingredient9.startsWith(" "))
            ingredientList.add(cocktail_ingredient9);
        if (!cocktail_ingredient10.isEmpty() || cocktail_ingredient10.startsWith(" "))
            ingredientList.add(cocktail_ingredient10);
        if (!cocktail_ingredient11.isEmpty() || cocktail_ingredient11.startsWith(" "))
            ingredientList.add(cocktail_ingredient11);
        if (!cocktail_ingredient12.isEmpty() || cocktail_ingredient12.startsWith(" "))
            ingredientList.add(cocktail_ingredient12);
        if (!cocktail_ingredient13.isEmpty() || cocktail_ingredient13.startsWith(" "))
            ingredientList.add(cocktail_ingredient13);
        if (!cocktail_ingredient14.isEmpty() || cocktail_ingredient14.startsWith(" "))
            ingredientList.add(cocktail_ingredient14);
        if (!cocktail_ingredient15.isEmpty() || cocktail_ingredient15.startsWith(" "))
            ingredientList.add(cocktail_ingredient15);

        ArrayList<String> measureList = new ArrayList<String>();
        if (!cocktail_measure1.isEmpty() || cocktail_measure1.startsWith(" "))
            measureList.add(cocktail_measure1);
        if (!cocktail_measure2.isEmpty() || cocktail_measure2.startsWith(" "))
            measureList.add(cocktail_measure2);
        if (!cocktail_measure3.isEmpty() || cocktail_measure3.startsWith(" "))
            measureList.add(cocktail_measure3);
        if (!cocktail_measure4.isEmpty() || cocktail_measure4.startsWith(" "))
            measureList.add(cocktail_measure4);
        if (!cocktail_measure5.isEmpty() || cocktail_measure5.startsWith(" "))
            measureList.add(cocktail_measure5);
        if (!cocktail_measure6.isEmpty() || cocktail_measure6.startsWith(" "))
            measureList.add(cocktail_measure6);
        if (!cocktail_measure7.isEmpty() || cocktail_measure7.startsWith(" "))
            measureList.add(cocktail_measure7);
        if (!cocktail_measure8.isEmpty() || cocktail_measure8.startsWith(" "))
            measureList.add(cocktail_measure8);
        if (!cocktail_measure9.isEmpty() || cocktail_measure9.startsWith(" "))
            measureList.add(cocktail_measure9);
        if (!cocktail_measure10.isEmpty() || cocktail_measure10.startsWith(" "))
            measureList.add(cocktail_measure10);
        if (!cocktail_measure11.isEmpty() || cocktail_measure11.startsWith(" "))
            measureList.add(cocktail_measure11);
        if (!cocktail_measure12.isEmpty() || cocktail_measure12.startsWith(" "))
            measureList.add(cocktail_measure12);
        if (!cocktail_measure13.isEmpty() || cocktail_measure13.startsWith(" "))
            measureList.add(cocktail_measure13);
        if (!cocktail_measure14.isEmpty() || cocktail_measure14.startsWith(" "))
            measureList.add(cocktail_measure14);
        if (!cocktail_measure15.isEmpty() || cocktail_measure15.startsWith(" "))
            measureList.add(cocktail_measure15);


        if (cocktailName != null) {
            cocktailName.setText(cocktail_Name);
            instructionString.setText(cocktail_instr);

            if (cocktail_Image == null) {
                cocktailImage.setImageResource(R.mipmap.noimage);
            } else {
                Picasso.with(getBaseContext()).load(cocktail_Image).into(cocktailImage);
            }

            CustomArrayAdapter adapter = new CustomArrayAdapter(getBaseContext(), ingredientList, measureList);
            List.setAdapter(adapter);
        }

        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
                spinner.setVisibility(View.VISIBLE);
                List.getItemAtPosition(position);
                String item = ingredientList.get(position);

                Intent i=new Intent(CocktailDisplay.this, Ingredient.class);
                i.putExtra("Item", item);

                startActivity(i);
                overridePendingTransition(R.anim.animation_fade_in, R.anim.animation_fade_out);
            }
        });
        spinner.setVisibility(View.GONE);
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
