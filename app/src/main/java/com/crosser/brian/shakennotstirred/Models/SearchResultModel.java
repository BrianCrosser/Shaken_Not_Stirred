package com.crosser.brian.shakennotstirred.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SearchResultModel {
    @SerializedName("drinks")
    ArrayList<DrinkRecipeModel> searchResults;

    @SerializedName("drinks")
    DrinkRecipeModel cocktailResults;

    public ArrayList<DrinkRecipeModel> getSearchResults(){
        return searchResults;
    }

    public DrinkRecipeModel getCocktailResults(){
        return cocktailResults;
    }

    public void setSearchResults(ArrayList<DrinkRecipeModel> searchResults){
        this.searchResults = searchResults;
    }
}
