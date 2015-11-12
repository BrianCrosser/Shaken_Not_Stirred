package com.crosser.brian.shakennotstirred.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SearchResultModel {
    @SerializedName("drinks")
    ArrayList<DrinkRecipeModel> searchResults;

    public ArrayList<DrinkRecipeModel> getSearchResults(){
        return searchResults;
    }

    public void setSearchResults(ArrayList<DrinkRecipeModel> searchResults){
        this.searchResults = searchResults;
    }
}
