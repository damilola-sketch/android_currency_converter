package com.aptech.currencyconverter.model;

public class CountryItem {
    //Data Objects
    private String countryName;
    private int countryFlag;

    //constructor to set data objects
    public CountryItem(String countryName, int countryFlag){
        this.countryName = countryName;
        this.countryFlag = countryFlag;
    }

    //getter
    public String getCountryName(){
        return countryName;
    }

    public int getCountryFlag(){
        return countryFlag;
    }
}
