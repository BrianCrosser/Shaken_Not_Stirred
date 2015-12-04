package com.crosser.brian.shakennotstirred.Services;

import com.crosser.brian.shakennotstirred.AppDefines;
import com.crosser.brian.shakennotstirred.Providers.SupermarketProvider;

import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.SimpleXmlConverterFactory;

public class SupermarketAPIClient {
    // A static instance iof the SupermarketProvider is created to use as a singleton
    public static com.crosser.brian.shakennotstirred.Providers.SupermarketProvider supermarketProvider;

    // A public method is created to expose the singleton and grant access to it's public methods
    public static SupermarketProvider getSupermarketProvider() {
        // A new Retrofit object is created

        // JSON parse
        /*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppDefines.SUPERMARKET_API_URL) // a base api URL is provided
                .addConverterFactory(GsonConverterFactory.create()) // a deserializer is specified
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // we associate rdxAndroid to handle the callback
                .build();
        */
        // XML parse
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppDefines.SUPERMARKET_API_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        // a concrete implementation of the SupermarketProvider interfaces is dynamically created by the Retrofit
        // object
        supermarketProvider = retrofit.create(SupermarketProvider.class);

        return supermarketProvider;
    }


}