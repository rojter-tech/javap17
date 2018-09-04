package com.codingame.horse;
import java.util.*;

/**
 * Created by dreut on 2017-01-29.
 */
public class Solution {

    public static void main(String args[]) {
        int [] horseStrength = readInput();
        int[] diff = compareStrength(horseStrength);
        int closeHorse = findMin(diff);
        System.out.println(closeHorse);
    }

    private static int[] readInput() {
        String inputString = "3\n9\n5\n8";
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] horseStrength = new int[n];
        for (int i = 0; i < n; i++) {
            horseStrength[i] = in.nextInt();
        }
        return horseStrength;
    }

    private static int[] compareStrength(int[] horseStrength) {
        int[] diff = new int[horseStrength.length - 1];
        Arrays.sort(horseStrength);
        for (int i = 0; i < (horseStrength.length - 1); i++) {
            diff[i] = horseStrength[i+1] - horseStrength[i];
        }
        return diff;
    }

    private static int findMin(int[] diff) {
        Arrays.sort(diff);
        return diff[0];
    }

}
