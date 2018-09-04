package com.codingame.temperature;

import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        runTemperatures();
    }

    private static void runTemperatures() {
        int [] inputTemp = inputTemp();
        boolean checkNeg = checkIfNegOnly(inputTemp);
        if (checkNeg) {
            int test = findClosestToZero(inputTemp);
            System.out.println(test);
        } else {
            int test = Math.abs(findClosestToZero(inputTemp));
            System.out.println(test);
        }
    }


    private static int[] inputTemp() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        int[] intTemp = new int[n];
        if (n == 0) {
            in.close();
        }else {
            in.nextLine();
            String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526
            Scanner search = new Scanner(temps);
            for (int i = 0; i < n; i++) {
                intTemp[i] = search.nextInt();
            }
        }
        return intTemp;
    }

    private static int findClosestToZero(int[] intTemp) {
        if (intTemp.length == 0) {
            return 0;
        } else {

            int ref;
            int nearestToZero = intTemp[0];
            for (int i : intTemp) {
                ref = i * i;
                if (ref <= (nearestToZero * nearestToZero)) {
                    nearestToZero = i;
                }
            }

            return nearestToZero;
        }

    }

    private static boolean checkIfNegOnly(int[] inputTemp) {
        Integer tempElement;
        boolean stateElement = false;
        for (int i : inputTemp) {
            tempElement = i;
            if (tempElement < 0) {
                stateElement = true;
            } else {
                return stateElement;
            }
        }
        return stateElement;
    }
}