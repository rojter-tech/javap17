package com.rojter.java;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	//double[] test = new double[10];
	double[] temp = {-55.0, 10.8, 43.9, 21.0, 67, 40.8, -12.8, -200.8, 40.1, -99.0};
        lowhHghTemp(temp);
    }

    private static void lowhHghTemp(double[] temp) {
        double x = temp[0],y = temp[0], mean = temp[0];
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] > x)  x = temp[i];
            if (temp[i] < y) y = temp[i];
            mean = mean + temp[i];
        }
        mean = mean/temp.length;
        System.out.println("Lägsta värdet är: " + temp[0]);
        System.out.println("Hösta värdet är: " + temp[temp.length-1]);
        System.out.print("Medelvärdet är: ");
        System.out.println(mean);

    }

}
