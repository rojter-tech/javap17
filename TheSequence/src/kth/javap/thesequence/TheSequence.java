/**
 * Skapad av dreuter 2017-01-25.
 * Daniel Reuter - 19880322-0758
 */
package kth.javap.thesequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Skapad av dreuter 2017-01-25.
 * Daniel Reuter - 19880322-0758
 */
public class TheSequence {

    public static void main(String[] args) throws IOException {
        // Talfoljden fran Kattis
        runTalfoljden();
    }

    private static void runTalfoljden() throws IOException {
        // Kor programmet
        int entVal[] = enterValue();
        int[] iterList = getIterList(entVal[0],entVal[1]);
        printIterList(iterList);
    }

    private static int[] enterValue() throws IOException {
        /*
        Returnerar tva inmatade heltal dar input 1 < input 2
        formatet for input ska vara "input 1 mellanslag input 2",
        exempelvis "7 19"
        */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strNums = reader.readLine().split("\\s");
        int num[] = {Integer.parseInt(strNums[0]),Integer.parseInt(strNums[1])};

        return num;
    }

    private static int[] getIterList(int x, int y) {
        /*
        Skriver ut antalet iterationer fran startvardet
        x till startvardet y i Talfoljds-algoritmen
        */
        int[] iterArray = new int[y-x+1];
        int arrayIndex = 0;
        for (int i = x; i < y+1; i++) {
            iterArray[arrayIndex] = getIter(i);
            arrayIndex++;
        }
        return iterArray;
    }

    private static int getIter(int a) {
        /*
        Beraknar antalet iterationer for ett givet postitivt heltal
        0 <= a <= 1000 att slutligen na vardet 1
        */
        if (a == 0) { // Om startvardet ar 0, som ar ett jamnt tal, sa blir nasta tal i talserien ocksa 0
            return a;
        } else if (a == 1) { // Om startvardet ar 1 sa ar det klart
            return a;
        }

        int i = 0;
        while (a != 1) {
            i++;
            a = getNextDig(a);
        }

        return i;
    }

    private static int getNextDig(int a) {
        /*
        Returnerar nasta tal i en talserie givet att:
        Om det ar ett jamnt tal a(n) sa blir nasta varde
        a(n+1) = a(n)/2
        annars
        a(n+1) = a(n)*3 + 1
        */
        int checkEven = a % 2;
        if (checkEven == 0) {
            a = a / 2;
        }else {
            a = a * 3 + 1;
        }

        return a;
    }

    private static void printIterList(int[] Array) {
        // Skriver ut samtliga element i en heltalslista
        for (int i : Array) {
            System.out.println(i);
        }
    }

}