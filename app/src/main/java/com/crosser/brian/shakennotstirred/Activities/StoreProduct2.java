package com.crosser.brian.shakennotstirred.Activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class StoreProduct2 extends Activity {

    TextView supermarketName;
    TextView supermarketPhone;
    TextView supermarketArea;
    TextView supermarketItem;
    ListView supermarketList;
    EditText item;
    Button itemEnter;
    private ProgressBar spinner;

    StoreModel storeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_product2);

        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);
        supermarketName = (TextView) findViewById(R.id.supermarketName);
        supermarketPhone = (TextView) findViewById(R.id.supermarketPhone);
        supermarketArea = (TextView) findViewById(R.id.supermarketArea);
        supermarketList = (ListView) findViewById(R.id.supermarketList);

        supermarketItem = (TextView) findViewById(R.id.supermarketItem);
        item = (EditText) findViewById(R.id.searchItem);
        itemEnter = (Button) findViewById(R.id.itemButton);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/007GoldenEye.ttf");
//        supermarketPhone.setTypeface(tf);
//        supermarketArea.setTypeface(tf);
//        supermarketName.setTypeface(tf);

        item.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        item.getBackground().setAlpha(200);
        itemEnter.getBackground().setAlpha(200);

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
        final String store_id = extras.getString("store-id");

        String store_area = store_address + " " + store_city + ", " + store_state + " " + store_zip;

        if (store_name != null) {
            supermarketName.setText(store_name);
            supermarketPhone.setText(store_phone);
            supermarketArea.setText(store_area);
        }

        itemEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);
                ProgressDialog progress = new ProgressDialog(StoreProduct2.this);
                progress.setTitle("Loading");
                progress.setMessage("Wait while loading...");
                progress.show();
                // To dismiss the dialog
                progress.dismiss();
                getSuperMarketData(store_id, item.getText().toString());
            }
        });
    }

    private void getSuperMarketData(String storeid, String item) {
        SupermarketAPIClient.getSupermarketProvider()
                .getItemSearchResults(AppDefines.SUPERMARKET_API_KEY, storeid, item)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ProductResultModel>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        int i = 0;
                    }

                    @Override
                    public void onNext(ProductResultModel productResultModel) {
                        supermarketList.setAdapter(new ProductListAdapter(StoreProduct2.this, productResultModel.getSearchItemResults()));
                    }
                });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_storeproduct2, menu);
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


