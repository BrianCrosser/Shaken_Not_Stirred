package com.crosser.brian.shakennotstirred.Providers;

import com.crosser.brian.shakennotstirred.Models.SearchResultModel;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Lisa on 10/28/15.
 */
public interface IDrinkRecipeProvider {
    //search by name of cocktail
    @GET("/api/json/v1/1/search.php")
    Observable<SearchResultModel> getDrinkRecipesByIngredient (@Query("s") String ingredient);

    @GET("/api/json/v1/1/filter.php")
    Observable<SearchResultModel> getDrinkRecipesByIngredient2 (@Query("i") String ingredient);

    @GET("/api/json/v1/1/lookup.php")
    Observable<SearchResultModel> getDrinkRecipesById (@Query("i") Integer ingredient);

    @GET("api/json/v1/1/random.php")
    Observable<SearchResultModel> getRandomDrinkRecipe();

}