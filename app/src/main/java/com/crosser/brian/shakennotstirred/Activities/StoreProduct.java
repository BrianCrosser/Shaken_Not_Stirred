package com.crosser.brian.shakennotstirred.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.crosser.brian.shakennotstirred.Adapters.ProductListAdapter;
import com.crosser.brian.shakennotstirred.AppDefines;
import com.crosser.brian.shakennotstirred.Models.ProductResultModel;
import com.crosser.brian.shakennotstirred.Models.StoreModel;
import com.crosser.brian.shakennotstirred.R;
import com.crosser.brian.shakennotstirred.Services.SupermarketAPIClient;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class StoreProduct extends Activity {

    TextView supermarketName;
    TextView supermarketPhone;
    TextView supermarketArea;
    TextView supermarketItem;
    ListView supermarketList;
    private ProgressBar spinner;
    StoreModel storeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_product);

        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);
        supermarketName = (TextView) findViewById(R.id.supermarketName);
        supermarketPhone = (TextView) findViewById(R.id.supermarketPhone);
        supermarketArea = (TextView) findViewById(R.id.supermarketArea);
        supermarketList = (ListView) findViewById(R.id.supermarketList);
        supermarketItem = (TextView) findViewById(R.id.supermarketItem);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/007GoldenEye.ttf");

        supermarketName.setTypeface(tf);
        supermarketPhone.setTypeface(tf);
        supermarketArea.setTypeface(tf);
        supermarketItem.setTypeface(tf);


        // get the intent from which this activity is called.
        Intent intent = getIntent();
        final Bundle extras = intent.getExtras();
        // fetch value from key-value pair and make it visible on TextView.
        String store_name = extras.getString("store-name");
        String store_address = extras.getString("store-address");
        String store_city = extras.getString("store-city");
        String store_state = extras.getString("store-state");
        String store_zip = extras.getString("store-zip");
        String store_phone = extras.getString("store-phone");
        String store_id = extras.getString("store-id");
        String item = extras.getString("item");
        String store_area = store_address + " " + store_city + ", " + store_state + " " + store_zip;

        if (store_name != null) {
            supermarketName.setText(store_name);
            supermarketPhone.setText(store_phone);
            supermarketArea.setText(store_area);
            supermarketItem.setText(item);
            getSuperMarketData(store_id, item);

        }
    }

    private void getSuperMarketData(String storeid, String item) {
        SupermarketAPIClient.getSupermarketProvider()
                .getItemSearchResults(AppDefines.SUPERMARKET_API_KEY, storeid, item)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ProductResultModel>() {

                    @Override
                    public void onCompleted() {
                        spinner.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        int i = 0;
                    }

                    @Override
                    public void onNext(ProductResultModel productResultModel) {
                        supermarketList.setAdapter(new ProductListAdapter(StoreProduct.this, productResultModel.getSearchItemResults()));
                        spinner.setVisibility(View.GONE);
                    }
                });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_storeproduct, menu);
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


