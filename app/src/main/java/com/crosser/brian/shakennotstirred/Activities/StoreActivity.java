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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.crosser.brian.shakennotstirred.Adapters.StoreListAdapter;
import com.crosser.brian.shakennotstirred.AppDefines;
import com.crosser.brian.shakennotstirred.Models.StoreModel;
import com.crosser.brian.shakennotstirred.Models.StoreResultModel;
import com.crosser.brian.shakennotstirred.R;
import com.crosser.brian.shakennotstirred.Services.SupermarketAPIClient;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class StoreActivity extends Activity {
    TextView storeText;
    TextView ingredientDisplay;
    Button zipButton;
    EditText enterZIP;
    ListView storeList;
    private ProgressBar spinner;
    String item;

    StoreModel storeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient);

        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);
        storeText = (TextView) findViewById(R.id.storeText);
        ingredientDisplay = (TextView) findViewById(R.id.ingredientDisplay);
        zipButton = (Button) findViewById(R.id.zipButton);
        enterZIP = (EditText) findViewById(R.id.enterZIP);
        storeList = (ListView) findViewById(R.id.storeList);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/007GoldenEye.ttf");
        storeText.setTypeface(tf, Typeface.BOLD);
        ingredientDisplay.setTypeface(tf, Typeface.BOLD);
        storeList.setBackgroundColor(Color.LTGRAY);
        enterZIP.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        enterZIP.getBackground().setAlpha(200);
        zipButton.getBackground().setAlpha(200);
        storeList.getBackground().setAlpha(200);

        ingredientDisplay.setText(item);

        zipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);
                SupermarketAPIClient.getSupermarketProvider()
                        .getStoreSearchResults(AppDefines.SUPERMARKET_API_KEY, enterZIP.getText().toString())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<StoreResultModel>() {

                            @Override
                            public void onCompleted() {
                                spinner.setVisibility(View.GONE);
                            }

                            @Override
                            public void onError(Throwable e) {
                                int i = 0;
                            }

                            @Override
                            public void onNext(StoreResultModel storeResultModel) {
                                storeList.setAdapter(new StoreListAdapter(StoreActivity.this, storeResultModel.getSearchStoresResults()));
                                //getSuperMarketData(storeModel.getStoreID());
                                spinner.setVisibility(View.GONE);

                            }
                        });
            }
        });

        storeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
                spinner.setVisibility(View.VISIBLE);
                StoreModel value = (StoreModel) storeList.getItemAtPosition(position);
                // selected item
                String storeName = value.getStorename();
                String storeAddress = value.getAddress();
                String storeCity = value.getCity();
                String storeState = value.getState();
                String storeZip = value.getZip();
                String storePhone = value.getPhone();
                String storeID = value.getStoreId();

                Intent myIntent = new Intent(getApplicationContext(), StoreProduct2.class);
                // sending data to new activity
                Bundle extras = new Bundle();
                extras.putString("store-name", storeName);
                extras.putString("store-address", storeAddress);
                extras.putString("store-city", storeCity);
                extras.putString("store-state", storeState);
                extras.putString("store-zip", storeZip);
                extras.putString("store-phone", storePhone);
                extras.putString("store-id", storeID);

                myIntent.putExtras(extras);
                startActivity(myIntent);
                overridePendingTransition(R.anim.animation_left_in, R.anim.animation_left_out);
                ProgressDialog progress = new ProgressDialog(StoreActivity.this);
                progress.setTitle("Loading");
                progress.setMessage("Wait while loading...");
                progress.show();
                // To dismiss the dialog
                progress.dismiss();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_store, menu);
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


