package com.crosser.brian.shakennotstirred.Providers;

import com.crosser.brian.shakennotstirred.Models.ProductResultModel;
import com.crosser.brian.shakennotstirred.Models.StoreResultModel;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;


public interface SupermarketProvider {

    // /api.asmx/StoresByZip?APIKEY=APIKEY&ZipCode=95130
    @GET("/api.asmx/StoresByZip")
    Observable<StoreResultModel> getStoreSearchResults(@Query("APIKEY") String key,
                                                        @Query("ZipCode") String zip);

    // /api.asmx/COMMERCIAL_SearchForItem?APIKEY=APIKEY&StoreId=123456&ItemName=Apple
    @GET("/api.asmx/COMMERCIAL_SearchForItem")
    Observable<ProductResultModel> getItemSearchResults(@Query("APIKEY") String key,
                                                      @Query("StoreId") String storeid,
                                                      @Query("ItemName") String item);

}