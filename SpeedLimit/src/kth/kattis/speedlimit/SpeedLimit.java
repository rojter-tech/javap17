package kth.kattis.speedlimit;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dreut on 2017-01-29.
 */
public class SpeedLimit {

    public static void main(String[] args) {
        String[] stringInput = collectInput();
        int[] intVehicleData = convertInput(stringInput);
        analyseInput(intVehicleData);
    }

    private static String[] collectInput() {
        Scanner input = new Scanner(System.in);
        String stringInput = "";
        int n = 0; int i = 0;
        while (n != -1) {
            n = input.nextInt();
            if (n != -1) {
                stringInput = stringInput + " " + n;
                i++;
            }
        }
        input.close();
        String[] stringInputArray = new String[2];
        stringInputArray[0] = stringInput;
        stringInputArray[1] = String.valueOf(i);
        return stringInputArray;
    }

    private static int[] convertInput(String[] stringInput) {
        String stringVehicleData = stringInput[0];
        int[] intVehicleData = new int[Integer.valueOf(stringInput[1])];
        Scanner in = new Scanner(stringVehicleData);

        int n = intVehicleData.length;
        for (int i = 0; i < n; i++) {
            intVehicleData[i] = in.nextInt();
        }
        in.close();
        return intVehicleData;
    }

    private static void analyseInput(int[] intVehicleData) {
        int j = 0;
        for (int i = 0; i < intVehicleData.length; i += (intVehicleData[i] * 2 + 1)) {
            j++;
        }
        int[] dataSetNumber = new int[j]; j = 0;
        for (int i = 0; i < intVehicleData.length; i += (intVehicleData[i] * 2 + 1)) {
            dataSetNumber[j] = intVehicleData[i];
            j++;
        }

        j = 0;
        int setcounter;
        for (int k:dataSetNumber) {
            setcounter = 0;
            int[] tempSetData = new int[k*2];
            for (int i = 1 + j; i < k*2+1 + j; i++) {
                tempSetData[setcounter] = intVehicleData[i];
                setcounter++;
            }
            int result = 0;
            for (int s = 0; s < tempSetData.length; s+=2) {
                if (s == 0) result += tempSetData[s]*tempSetData[s+1];
                else result += tempSetData[s]*(tempSetData[s+1] - tempSetData[s-1]);
            }
            System.out.println(result + " miles");

            j += k*2+1;
        }
    }

}