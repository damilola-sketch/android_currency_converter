package com.aptech.currencyconverter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.aptech.currencyconverter.model.CountryItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //fields
    Button dayButton;
    Spinner firstSpinner, secondSpinner;
    EditText firstValue, secondValue;
    private ArrayList<CountryItem> countryList, toCurrency;
    String selectedCountryName = "";
    String selectedCurrency = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set view to fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //hooks
        dayButton = findViewById(R.id.button);
        firstSpinner = findViewById(R.id.convert_from);
        secondSpinner = findViewById(R.id.convert_to);
        firstValue = findViewById(R.id.first_value);
        secondValue = findViewById(R.id.second_value);

        //change keyboard action button to Action_Done
        firstValue.setImeOptions(EditorInfo.IME_ACTION_DONE);

        //set system date
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE d", Locale.getDefault());
        String date = dateFormat.format(new Date());
        dayButton.setText(date);

        //add items to ArrayList
        initList();


        //set adapter
        CountryAdapter adapter = new CountryAdapter(this, countryList);
        CountryAdapter currencyAdapter = new CountryAdapter(this, toCurrency);

        firstSpinner.setAdapter(adapter);
        secondSpinner.setAdapter(currencyAdapter);

        //set onItemSelectedListener for firstSpinner
        firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //get selected item
                CountryItem clickedItem = (CountryItem) parent.getItemAtPosition(position);
                selectedCountryName = clickedItem.getCountryName();
                firstValue.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //set onItemSelected for secondSpinner
        secondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //get selected item
                CountryItem clickedItem = (CountryItem) parent.getItemAtPosition(position);
                selectedCurrency = clickedItem.getCountryName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //calculate conversion onTextChanged
        firstValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = String.valueOf(s);
                double value;
                double result;

                if(!text.isEmpty()) {
                    //convert value based on firstSpinner and secondSpinner
                    switch (selectedCurrency) {
                        case "USD":
                            //convert to USD
                            switch (selectedCountryName) {
                                case "AUD":
                                    //convert AUD to USD
                                    value = Double.parseDouble(text);
                                    result = value / 1.38;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "BRL":
                                    //convert BRL to USD
                                    value = Double.parseDouble(text);
                                    result = value / 5.35;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "CHF":
                                    //convert CHF to USD
                                    value = Double.parseDouble(text);
                                    result = value / 0.91;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "CNY":
                                    //convert CNY to USD
                                    value = Double.parseDouble(text);
                                    result = value / 6.95;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "EUR":
                                    //convert EUR to USD
                                    value = Double.parseDouble(text);
                                    result = value / 0.84;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "GBP":
                                    //convert GBP to USD
                                    value = Double.parseDouble(text);
                                    result = value / 0.76;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "INR":
                                    //convert INR to USD
                                    value = Double.parseDouble(text);
                                    result = value / 74.96;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "ISK":
                                    //convert ISK to USD
                                    value = Double.parseDouble(text);
                                    result = value / 134.90;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "JPY":
                                    //convert JPY to USD
                                    value = Double.parseDouble(text);
                                    result = value / 105.49;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "KWD":
                                    //convert KWD to USD
                                    value = Double.parseDouble(text);
                                    result = value / 0.31;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "MYR":
                                    //convert MYR to USD
                                    value = Double.parseDouble(text);
                                    result = value / 4.19;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "NGN":
                                    //convert NGN to USD
                                    value = Double.parseDouble(text);
                                    result = value / 388;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);

                                    break;
                                case "NZD":
                                    //convert NZD to USD
                                    value = Double.parseDouble(text);
                                    result = value / 1.50;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "RUB":
                                    //convert RUB to USD
                                    value = Double.parseDouble(text);
                                    result = value / 73.38;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "USD":
                                    //convert USD to USD
                                    value = Double.parseDouble(text);
                                    result = value / 1;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                            }

                            break;
                        case "EUR":
                            //convert to euro
                            switch (selectedCountryName) {
                                case "AUD":
                                    //convert AUD to EUR
                                    value = Double.parseDouble(text);
                                    result = value / 1.64;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "BRL":
                                    //convert BRL to EUR
                                    value = Double.parseDouble(text);
                                    result = value / 6.34;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "CHF":
                                    //convert CHF to EUR
                                    value = Double.parseDouble(text);
                                    result = value / 1.08;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "CNY":
                                    //convert CNY to EUR
                                    value = Double.parseDouble(text);
                                    result = value / 8.26;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "EUR":
                                    //convert EUR to EUR
                                    value = Double.parseDouble(text);
                                    result = value / 1;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "GBP":
                                    //convert GBP to EUR
                                    value = Double.parseDouble(text);
                                    result = value / 0.90;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "INR":
                                    //convert INR to EUR
                                    value = Double.parseDouble(text);
                                    result = value / 88.98;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "ISK":
                                    //convert ISK to EUR
                                    value = Double.parseDouble(text);
                                    result = value / 160.20;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "JPY":
                                    //convert JPY to EUR
                                    value = Double.parseDouble(text);
                                    result = value / 125.24;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "KWD":
                                    //convert KWD to EUR
                                    value = Double.parseDouble(text);
                                    result = value / 0.36;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "MYR":
                                    //convert MYR to EUR
                                    value = Double.parseDouble(text);
                                    result = value / 4.98;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "NGN":
                                    //convert NGN to EUR
                                    value = Double.parseDouble(text);
                                    result = value / 451.80;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);

                                    break;
                                case "NZD":
                                    //convert NZD to EUR
                                    value = Double.parseDouble(text);
                                    result = value / 1.78;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "RUB":
                                    //convert RUB to EUR
                                    value = Double.parseDouble(text);
                                    result = value / 87.09;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "USD":
                                    //convert USD to EUR
                                    value = Double.parseDouble(text);
                                    result = value / 1.19;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                            }

                            break;
                        case "GBP":
                            //convert to GBP
                            switch (selectedCountryName) {
                                case "AUD":
                                    //convert AUD to GBP
                                    value = Double.parseDouble(text);
                                    result = value / 1.82;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);

                                    break;
                                case "BRL":
                                    //convert BRL to GBP
                                    value = Double.parseDouble(text);
                                    result = value / 7.04;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);

                                    break;
                                case "CHF":
                                    //convert CHF to GBP
                                    value = Double.parseDouble(text);
                                    result = value / 1.20;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);

                                    break;
                                case "CNY":
                                    //convert CNY to GBP
                                    value = Double.parseDouble(text);
                                    result = value / 9.14;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);

                                    break;
                                case "EUR":
                                    //convert EUR to GBP
                                    value = Double.parseDouble(text);
                                    result = value / 1.11;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);

                                    break;
                                case "GBP":
                                    //convert GBP to GBP
                                    value = Double.parseDouble(text);
                                    result = value / 1;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);

                                    break;
                                case "INR":
                                    //convert INR to GBP
                                    value = Double.parseDouble(text);
                                    result = value / 98.60;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);

                                    break;
                                case "ISK":
                                    //convert ISK to GBP
                                    value = Double.parseDouble(text);
                                    result = value / 177.44;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);

                                    break;
                                case "JPY":
                                    //convert JPY to GBP
                                    value = Double.parseDouble(text);
                                    result = value / 138.77;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);

                                    break;
                                case "KWD":
                                    //convert KWD to GBP
                                    value = Double.parseDouble(text);
                                    result = value / 0.40;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "MYR":
                                    //convert MYR to GBP
                                    value = Double.parseDouble(text);
                                    result = value / 5.51;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "NGN":
                                    //convert NGN to GBP
                                    value = Double.parseDouble(text);
                                    result = value / 500.45;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);

                                    break;
                                case "NZD":
                                    //convert NZD to GBP
                                    value = Double.parseDouble(text);
                                    result = value / 1.97;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "RUB":
                                    //convert RUB to GBP
                                    value = Double.parseDouble(text);
                                    result = value / 96.50;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                                case "USD":
                                    //convert USD to GBP
                                    value = Double.parseDouble(text);
                                    result = value / 1.32;
                                    text = String.valueOf(result);
                                    secondValue.setText(text);
                                    break;
                            }

                            break;
                    }

                }else{
                    //if text is empty
                    secondValue.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void initList() {
        //initialize countryList array
        countryList = new ArrayList<>();
        // number of countries : 15
        countryList.add(new CountryItem("AUD", R.drawable.australia));
        countryList.add(new CountryItem("BRL", R.drawable.brazil));
        countryList.add(new CountryItem("CHF", R.drawable.switzerland));
        countryList.add(new CountryItem("CNY", R.drawable.china));
        countryList.add(new CountryItem("EUR", R.drawable.euro));
        countryList.add(new CountryItem("GBP", R.drawable.unitedkingdom));
        countryList.add(new CountryItem("INR", R.drawable.india));
        countryList.add(new CountryItem("ISK", R.drawable.iceland));
        countryList.add(new CountryItem("JPY", R.drawable.japan));
        countryList.add(new CountryItem("KWD", R.drawable.kuwait));
        countryList.add(new CountryItem("MYR", R.drawable.malaysia));
        countryList.add(new CountryItem("NGN", R.drawable.nigeria));
        countryList.add(new CountryItem("NZD", R.drawable.newzealand));
        countryList.add(new CountryItem("RUB", R.drawable.russia));
        countryList.add(new CountryItem("USD", R.drawable.unitedstates));

        //initialize toCurrency array
        toCurrency = new ArrayList<>();
        toCurrency.add(new CountryItem("USD", R.drawable.unitedstates));
        toCurrency.add(new CountryItem("EUR", R.drawable.euro));
        toCurrency.add(new CountryItem("GBP", R.drawable.unitedkingdom));
    }

}