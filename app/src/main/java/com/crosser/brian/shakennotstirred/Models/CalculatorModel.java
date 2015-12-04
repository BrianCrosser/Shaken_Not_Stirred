package com.crosser.brian.shakennotstirred.Models;

import java.util.Date;
import java.util.Objects;

/**
 * Created by Brian on 10/23/2015.
 */
public class CalculatorModel {

    public int weight;
    private Date beginTime = new Date();
    public double man = .73;
    public double woman = .66;
    public int shots;
    public int beers;
    public int wine;
    public final double beerABV = .045;
    public final double shotABV = .37;
    public final double wineABV = .116;


    public void CalculatorModel(){
        shots = 0;
        beers = 0;
        wine = 0;
    }


    public void setWeight(String inputWeight)
    {
        weight = Integer.parseInt(inputWeight);
    }

    public void startTimer()
    {
        beginTime = new Date();
    }

    public void startTime(int hour, int minute) {beginTime.setHours(hour); beginTime.setMinutes(minute);}

    public double getGender(String gender)
    {
        if(Objects.equals(gender, "Male"))
            return man;
        else
            return woman;
    }

    public double getConsumptionTime()
    {
        Date currentTime = new Date();
        double currTime = currentTime.getTime() - beginTime.getTime();
        currTime = ((((((currTime / 1000) % 60) / 60) % 60) / 60) % 24);
        return currTime;
    }

    public double totalConsumed()
    {
        return ((shots * 1.5) * shotABV) + ((wine * 6) * wineABV) + ((beers * 16.9) * beerABV);
    }

    public double getBAC(String gender)
    {
        double t = getConsumptionTime();
        double bac = (totalConsumed() * 5.15 / weight * getGender(gender)) - .015 * t;
        if(bac < 0)
            return 0;
        return bac;
    }

    public int getShotCount() { return shots; }

    public int getBeerCount()
    {
        return beers;
    }

    public int getWineCount()
    {
        return wine;
    }

    public void addShot() {
        shots += 1;
    }

    public void addWine() { wine += 1; }

    public void addBeer() {
        beers += 1;
    }

    public void subShot() {
        if (shots > 0)
            shots -= 1;
    }

    public void subWine() {
        if (wine > 0)
            wine -= 1;
    }

    public void subBeer() {
        if (beers > 0)
            beers -= 1;
    }

    public void setShot(int newShot) {shots = newShot;}

    public void setBeer(int newBeer) {beers = newBeer;}

    public void setWine(int newWine) {wine = newWine;}
}