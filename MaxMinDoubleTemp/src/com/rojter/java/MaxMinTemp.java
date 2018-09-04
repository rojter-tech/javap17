package com.rojter.java;

import java.math.BigDecimal;
import java.util.Arrays;


/**
 * Created by Daniel Reuter on 2017-02-12. This code is not you business, so give it back!
 */
public class MaxMinTemp {
    public static void main(String[] args) {
        double[] tempRand = getTemp();								// Hamta temperaturer, lagra i en double[] eftersom getTemp returnerar double[]
        System.out.println("Samtliga temperaturer: ");				// Printa dem
        System.out.println(Arrays.toString(tempRand) + "\n");
        calcTemp(tempRand);											// Stoppa in dem i double[] format som parameter till calcTemp-metoden
    }

    private static double[] getTemp() {								// Private eftersom metoden endast endast ar till for den lokala klassen, double[] eftersom den ska returnera en double[]
        double[] tempRand = new double[100];							// Skapa en array med n stycken tomma element (valj sjalv hur manga)
        BigDecimal bd = new BigDecimal(0);							// Initiera ett nytt BigDecimal-objekt for trunkering av avrundningsfel
        for (int i = 0; i < tempRand.length; i++) {					// Satt upp en loop for att lagga in element i arrayen (har funkar inte foreach)
            bd = BigDecimal.valueOf(-273+373*Math.random());		// Anvand Bigdecimal-objektet for att lagra n st randomvarden mellan -273.00 och 100.00
            bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);			// Anvand BigDecimal-objektet for att lagra randomvardena korrekt avrundade med 2 decimaler
            tempRand[i] = bd.doubleValue();							// Lagra double-vardet av BigDecimal objektet
        }
        return tempRand;											// Returnerar double[] arrayen
    }

    private static void calcTemp(double[] temp) {					// Private av samma anledning som ovan, void eftersom den inte ska returnera nagot, double[] parameter eftersom det ar av samma typ som listan av temperaturer genererade av getTemp metoden
        double min = temp[0], max = temp[0], mean = 0;				// Initiera ett minsta, storsta och medelvarde for databehandling ()
        for (double e:temp) {										// Deklarera en foreach eftersom endast informationshamtning ska ske varje element
            if (e > max) max = e;									// Om nagot varde ar storre en senaste lagrade max, omlagra
            if (e < min) min = e;									// -      ||       - mindre -        ||      - min, omlagra
            mean = mean + e;										// Summera samtliga element i temp
        }
        mean = mean/temp.length;									// Berakna medelvardet
        BigDecimal bd = new BigDecimal(mean);						// Gor om till BigDecimal-objekt med samma varde
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);				// Avrunda korrekt med 2 decimaler
        mean = bd.doubleValue();									// Konvertera tillbaka till double
        System.out.println("Maxtemperaturen ar: " + max);			// Printa shittet
        System.out.println("Mintemperaturen ar: " + min);
        System.out.println("Medeltemperaturen ar: " + mean);
    }

}