package com.crosser.brian.shakennotstirred.Adapters;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

//import com.crosser.brian.shakennotstirred.Models.IngredientListModel;

//import com.crosser.brian.shakennotstirred.Activities.Message;
import com.crosser.brian.shakennotstirred.R;

import java.util.ArrayList;

/**
 * Created by Lisa on 11/14/15.
 */
public class InventoryListAdapter {
    InventoryDatabaseHelper helper;
    Context context;
    int layoutResourceId;

    public InventoryListAdapter(Context context){
        helper = new InventoryDatabaseHelper(context);
    }
    public long insertData (String ingredient){

        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryDatabaseHelper.NAME, ingredient);
        long id = db.insert(InventoryDatabaseHelper.TABLE_NAME, null, contentValues);
        return id;

    }


    public ArrayList<String> getAllIngredients(){

        SQLiteDatabase db = helper.getWritableDatabase();

        //select _id,Name from IVENTORY
        String[] columns = {InventoryDatabaseHelper.UID, InventoryDatabaseHelper.NAME};
        String orderBy = InventoryDatabaseHelper.NAME;
        Cursor cursor= db.query(InventoryDatabaseHelper.TABLE_NAME, columns, null,null, null,null,orderBy);
        //ArrayList<IngredientListModel> ingredientsAndIds = new ArrayList<IngredientListModel>();
        ArrayList<String> ingredients = new ArrayList<String>();

        while(cursor.moveToNext()){
            String ingredient = cursor.getString(1);
            String id = cursor.getString(0);
            //IngredientListModel adding = new IngredientListModel();
            //adding.id = id.toString();
            //adding.ingredient = ingredient.toString();
            //ingredientsAndIds.add(adding);
            ingredients.add(ingredient.toString());
        }
        //db.execSQL(InventoryDatabaseHelper.DROP_TABLE);
        return ingredients;

    }





//    public ArrayList<IngredientListModel> getAllIngredients(){
//
//        SQLiteDatabase db = helper.getWritableDatabase();
//
//        //select _id,Name from IVENTORY
//        String[] columns = {InventoryDatabaseHelper.UID, InventoryDatabaseHelper.NAME};
//        Cursor cursor= db.query(InventoryDatabaseHelper.TABLE_NAME, columns, null,null, null,null,null);
//        ArrayList<IngredientListModel> ingredientsAndIds = new ArrayList<IngredientListModel>();
//        while(cursor.moveToNext()){
//            String ingredient = cursor.getString(1);
//            String id = cursor.getString(0);
//            IngredientListModel adding = new IngredientListModel();
//            adding.id = id.toString();
//            adding.ingredient = ingredient.toString();
//            ingredientsAndIds.add(adding);
//        }
//        return ingredientsAndIds;
//
//    }





    //public ArrayList<String> getAllIngredients(){
    //public String getAllIngredients(){
    public Object[] getAllIngredients2(){

        SQLiteDatabase db = helper.getWritableDatabase();

        //select _id,Name from IVENTORY
        String[] columns = {InventoryDatabaseHelper.UID, InventoryDatabaseHelper.NAME};
        Cursor cursor= db.query(InventoryDatabaseHelper.TABLE_NAME, columns, null,null, null,null,null);
        //StringBuffer buffer = new StringBuffer();
        //buffer.append("Ingredients: \n");
        ArrayList<String> ingredientArray = new ArrayList<String>();
        ArrayList<String> ingredientIds = new ArrayList<String>();
        while(cursor.moveToNext()){
            String ingredient = cursor.getString(1);
            String id = cursor.getString(0);
            //buffer.append( ingredient + " " + id+ "\n");
            ingredientIds.add(id.toString());
            ingredientArray.add(ingredient.toString());
        }
        //return buffer.toString();
        return new Object[]{ingredientIds,ingredientArray};

    }

    public Integer deleteIngredient(String ingredientID) {

        SQLiteDatabase db = helper.getWritableDatabase();
        String TABLE_NAME = InventoryDatabaseHelper.TABLE_NAME;
        String NAME = InventoryDatabaseHelper.NAME;
        //String[] ary = new String[] {ingredientID};
        //return db.delete(TABLE_NAME, "_id = ?", ary);
        return db.delete(TABLE_NAME, NAME + "= ?",
                new String[] {ingredientID});

    }

    static class InventoryDatabaseHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "InventoryDatabase";
        private static final String TABLE_NAME = "CABINET";
        private static final int  DATABASE_VERSION = 1;
        private static final String UID = "_id";
        private static final String NAME ="Ingredient";
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME
                + " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME+" VARCHAR(255) UNIQUE);";
        private static final String DROP_TABLE= "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        private static final String DELETE_ITEM = "DELETE FROM " + TABLE_NAME + " WHERE _id = " + UID + ";" ;
        //??????
        private Context context;

        public InventoryDatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // CREATE TABLE INVENTORY (_id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(255));

            db.execSQL(CREATE_TABLE);

        }

        @Override
        public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
            //
            db.execSQL(DROP_TABLE);
            //db.execSQL(DELETE_ITEM);
            onCreate(db);
        }

    }

}
