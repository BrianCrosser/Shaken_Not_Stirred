package com.crosser.brian.shakennotstirred.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.crosser.brian.shakennotstirred.R;
import com.crosser.brian.shakennotstirred.Models.CalculatorModel;

import java.util.Calendar;
import java.util.Date;

public class BAC_CalculatorActivity extends Activity {

    public Spinner genderSpinner;
    public EditText WeightEdit;
    public Button weightbutton;
    public Button addShotButton;
    public Button subShotButton;
    public Button addWineButton;
    public Button subWineButton;
    public Button addBeerButton;
    public Button subBeerButton;
    public Button calculateButton;
    public Button setButton;
    public TextView textView9;
    public TextView textView10;
    public TextView textView11;
    public TextView textView12;
    public TimePicker timePicker;
    private TextView tvDisplayTime;
    private TimePicker timePicker1;
    private Button btnChangeTime;

    public String weight;
    public String gender;
    public String shots;
    public String beers;
    public String wine;
    public int hour;
    public int minute;

    static final int TIME_DIALOG_ID = 999;

    CalculatorModel calculatorModel;
    public static final String BAC_Info = "BAC_Info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bac_calculator);

        genderSpinner = (Spinner) findViewById(R.id.spinner);
        WeightEdit = (EditText) findViewById(R.id.WeightEdit);
        weightbutton = (Button) findViewById(R.id.weightButton);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView11 = (TextView) findViewById(R.id.textView11);
        textView12 = (TextView) findViewById(R.id.textView12);
        addShotButton = (Button) findViewById(R.id.button6);
        subShotButton = (Button) findViewById(R.id.button7);
        addWineButton = (Button) findViewById(R.id.button9);
        subWineButton = (Button) findViewById(R.id.button8);
        addBeerButton = (Button) findViewById(R.id.button11);
        subBeerButton = (Button) findViewById(R.id.button10);
        calculateButton = (Button) findViewById(R.id.button);
        setButton = (Button) findViewById(R.id.btnChangeTime);
        timePicker = (TimePicker) findViewById(R.id.timePicker1);

        calculatorModel = new CalculatorModel();

        setCurrentTimeOnView();
        addListenerOnButton();

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genders_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        genderSpinner.setAdapter(adapter);
        calculatorModel.getGender(genderSpinner.getSelectedItem().toString());

//        // Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
//                R.array.weights_array, android.R.layout.simple_spinner_item);
//        // Specify the layout to use when the list of choices appears
//        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Apply the adapter to the spinner
//
//
//        //weightSpinner.setAdapter(adapter1);
//        //calculatorModel.setWeight(weightSpinner.getSelectedItem().toString());

        weightbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight = WeightEdit.getText().toString();
                calculatorModel.setWeight(weight);
            }
        });


        addShotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adds 1 to the counter
                calculatorModel.addShot();
                shots = String.valueOf(calculatorModel.getShotCount());
                textView9.setText(shots);
            }
        });

        subShotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Subtracts 1 from the counter
                calculatorModel.subShot();
                shots = String.valueOf(calculatorModel.getShotCount());
                textView9.setText(shots);
            }
        });

        addWineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorModel.addWine();
                wine = String.valueOf(calculatorModel.getWineCount());
                textView10.setText(wine);
            }
        });

        subWineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorModel.subWine();
                wine = String.valueOf(calculatorModel.getWineCount());
                textView10.setText(wine);
            }
        });

        addBeerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorModel.addBeer();
                beers = String.valueOf(calculatorModel.getBeerCount());
                textView11.setText(beers);
            }
        });

        subBeerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorModel.subBeer();
                beers = String.valueOf(calculatorModel.getBeerCount());
                textView11.setText(beers);
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView12.setText(String.valueOf(calculatorModel.getBAC(String.valueOf(calculatorModel.getGender(genderSpinner.getSelectedItem().toString())))));
            }
        });

//        setButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                hour = timePicker.getCurrentHour();
//                minute = timePicker.getCurrentMinute();
//                calculatorModel.startTime(hour, minute);
//            }
//        });
    }

    @Override
    public void onStart() {
        super.onStart();  // Always call the superclass method first
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bac_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first
        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences info = getPreferences(MODE_PRIVATE); //getSharedPreferences(BAC_Info, 0);
        SharedPreferences.Editor editor = info.edit();
        editor.putString("weight", weight);
        editor.putString("shots", shots);
        editor.putString("beers", beers);
        editor.putString("wine", wine);
        editor.putInt("hour", hour);
        editor.putInt("minute", minute);
        editor.putString("gender", gender);

        // Commit the edits!
        editor.commit();
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first

        // Restore preferences
        SharedPreferences info = getPreferences(MODE_PRIVATE);
        weight = info.getString("weight", "0");
        calculatorModel.setWeight(weight);
        WeightEdit.setText(weight);

        shots = info.getString("shots", "0");

        beers = info.getString("beers", "0");

        wine = info.getString("wine", "0");

        hour = info.getInt("hour", 0);
        timePicker1.setCurrentHour(hour);

        minute = info.getInt("minute", 0);
        timePicker1.setCurrentMinute(minute);

        gender = info.getString("gender", "Female");
        genderSpinner.setSelection(0);

    }

    // display current time
    public void setCurrentTimeOnView() {

        tvDisplayTime = (TextView) findViewById(R.id.tvTime);
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);

        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        // set current time into textview
        tvDisplayTime.setText(
                new StringBuilder().append(pad(hour))
                        .append(":").append(pad(minute)));

        // set current time into timepicker
        timePicker1.setCurrentHour(hour);
        timePicker1.setCurrentMinute(minute);

    }

    public void addListenerOnButton() {

        btnChangeTime = (Button) findViewById(R.id.btnChangeTime);
       btnChangeTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                showDialog(TIME_DIALOG_ID);

            }

        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                // set time picker as current time
                return new TimePickerDialog(this,
                        timePickerListener, hour, minute,false);

        }
        return null;
    }

    private TimePickerDialog.OnTimeSetListener timePickerListener =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int selectedHour,
                                      int selectedMinute) {
                    hour = selectedHour;
                    minute = selectedMinute;
                    calculatorModel.startTime(hour, minute);

                    // set current time into textview
                    tvDisplayTime.setText(new StringBuilder().append(pad(hour))
                            .append(":").append(pad(minute)));

                    // set current time into timepicker
                    timePicker1.setCurrentHour(hour);
                    timePicker1.setCurrentMinute(minute);

                }
            };

    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return " " + String.valueOf(c);
    }
}