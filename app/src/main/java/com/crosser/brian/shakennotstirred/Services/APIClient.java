package com.crosser.brian.shakennotstirred.Services;

import com.crosser.brian.shakennotstirred.AppDefines;
import com.crosser.brian.shakennotstirred.Providers.IDrinkRecipeProvider;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class APIClient {
    private static com.crosser.brian.shakennotstirred.Providers.IDrinkRecipeProvider drinkRecipeProvider;

    public static IDrinkRecipeProvider getRecipeProvider() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppDefines.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        drinkRecipeProvider = retrofit.create(IDrinkRecipeProvider.class);

        return drinkRecipeProvider;
    }
}

