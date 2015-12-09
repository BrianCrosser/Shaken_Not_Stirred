package com.crosser.brian.shakennotstirred.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.crosser.brian.shakennotstirred.Adapters.InventoryListAdapter;
import com.crosser.brian.shakennotstirred.R;

import java.util.ArrayList;

//import com.crosser.brian.shakennotstirred.Models.IngredientListModel;

public class Inventory extends Activity {

    TextView header;
    private boolean result;
    private ProgressBar spinner;
    //private String[] values = {"Whiskey", "test", "hi","Wine"};
    //AutoCompleteTextView txtView;

    // ListView cabinetView = (ListView) findViewById(R.id.cabinetView);
    //private EditText newIngredient;
    AutoCompleteTextView newIngredient;
    String[] ingredientArray;
    private InventoryListAdapter InventoryDatabaseHelper;
    private ListView cabinetView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);

        //start editing here
        //newIngredient=(EditText) findViewById(R.id.newIngredient);
        newIngredient = (AutoCompleteTextView) findViewById(R.id.newIngredient);
        ingredientArray = getResources().getStringArray(R.array.ingredients_array);
        ArrayAdapter<String> ingredientAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ingredientArray);
        newIngredient.setAdapter(ingredientAdapter);
        //newIngredient.setDropDownHeight(500);


        InventoryDatabaseHelper = new InventoryListAdapter(this);

        header = (TextView) findViewById(R.id.header);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/007GoldenEye.ttf");

        header.setTypeface(tf);

        cabinetView =(ListView) findViewById(R.id.cabinetView);
        // formatting
        cabinetView.setBackgroundColor(Color.LTGRAY);
        cabinetView.getBackground().setAlpha(200);
        newIngredient.setBackgroundColor(Color.LTGRAY);
        newIngredient.getBackground().setAlpha(200);


        ArrayList<String> data = InventoryDatabaseHelper.getAllIngredients();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                data);
        cabinetView.setAdapter(adapter);


        cabinetView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //cabinetView.setOnItemLongClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String ingredient = Integer.toString(position);
                String ingredient = ((TextView)view).getText().toString();
                //call alert dialog
                // if retult == yes
                // deleteIngredient(text);
                // else {continue}
                //if (toDelete(view)) { deleteIngredient(ingredient); }
                boolean value = toDelete(view, ingredient);
                // if (value) { deleteIngredient(ingredient); }


            }
        });


    }

    public void addIngredient(View view){

        //http://developer.android.com/guide/topics/ui/controls/text.html
        // autocomplete


        String ingredient = newIngredient.getText().toString();
        long id = InventoryDatabaseHelper.insertData(ingredient);
        if (id<0){
           // Message.message(this, "Error: Do not add ingredients already in your cabinet!");

        }
        else {
            // Message.message(this,"successful");

            newIngredient.setText("");
            cabinetView =(ListView) findViewById(R.id.cabinetView);
            cabinetView.setBackgroundColor(Color.LTGRAY);
            cabinetView.getBackground().setAlpha(200);
            ArrayList<String> data = InventoryDatabaseHelper.getAllIngredients();
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    data);
            cabinetView.setAdapter(adapter);

        }

    }


//    private doOnTrueResult() {
//        result = true;
//        //do something
//    }
//
//    private doOnFalseResult() {
//        result = false;
//        //do something else
//    }

    public void showConfirmationBox(String messageToShow, final Context context, final String ingredient) {
        //final String ingredient = ingredient;
        // prepare the alert box
        AlertDialog.Builder alertbox = new AlertDialog.Builder(context);

        // set the message to display
        alertbox.setMessage(messageToShow);

        // set a positive/yes button and create a listener
        alertbox.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                        // Message.message(this, "yes");
                        deleteIngredient(ingredient);
                    }
                });

        // set a negative/no button and create a listener
        alertbox.setNegativeButton("No", new DialogInterface.OnClickListener() {

            // do something when the button is clicked
            public void onClick(DialogInterface arg0, int arg1) {

                // doOnFalseResult();
            }
        });

        // display box
        alertbox.show();
    }


    public boolean toDelete (View view, String ingredient) {
        showConfirmationBox("Are you sure want to remove all the " + ingredient + " in your cabinet?", this, ingredient);
        return false;
    }

    public void deleteIngredient (String ingredient) {
        // delete ingredient from listview AND DB
        int id = 0;
        Integer ingredientsDeleted = InventoryDatabaseHelper.deleteIngredient(ingredient);
        //String del = Integer.toString(ingredientsDeleted);
        //Message.message(this, del);

        newIngredient.setText("");
        cabinetView =(ListView) findViewById(R.id.cabinetView);
        cabinetView.setBackgroundColor(Color.LTGRAY);
        cabinetView.getBackground().setAlpha(200);
        ArrayList<String> data = InventoryDatabaseHelper.getAllIngredients();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                data);
        cabinetView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inventory, menu);
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
    @Override
    public void onBackPressed() {
        spinner.setVisibility(View.GONE);
        super.onBackPressed();
    }
}