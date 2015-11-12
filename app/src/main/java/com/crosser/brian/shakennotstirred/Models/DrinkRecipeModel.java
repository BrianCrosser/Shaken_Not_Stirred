package com.crosser.brian.shakennotstirred.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DrinkRecipeModel {
    @SerializedName("idDrink")
    public int drinkId;

    @SerializedName("strDrink")
    public String drinkName;

    @SerializedName("categories")
    public String drinkCategories;

    @SerializedName("strDrinkThumb")
    public String drinkThumb;

    @SerializedName("ingredients")
    public ArrayList<String> ingredients;


//    private boolean isAlcoholic;
//    private String instructions;
//    //private URI thumb;

//    private String[] ingredientMeasurements;


    public int getDrinkId() {
        return drinkId;
    }

    public String getDrinkName(){
        return drinkName;
    }

    public String getDrinkCategories(){
        return drinkCategories;
    }

    public String getDrinkThumb(){
        return drinkThumb;
    }

    public ArrayList<String> getIngredients() { return ingredients; }


    public void setDrinkId(int drinkId) { this.drinkId = drinkId; }

    public void setDrinkName(String drinkName) { this.drinkName = drinkName; }

    public void setDrinkCategories(String drinkCategories) {
        this.drinkCategories = drinkCategories;
    }

    public void setDrinkThumb(String drinkThumb) {
        this.drinkThumb = drinkThumb;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }
}