package kth.javap.enigma;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by dreut on 2017-01-29.
 */
public class Enigma {
    public static void main(String[] args) {
        //Huvudprogrammet
        runEnigma();
    }

    public static void runEnigma() {
        int[] possiblePos;
        char[][] cryptoClearCharArray = readInput();
        if (cryptoClearCharArray[1].length > cryptoClearCharArray[0].length) System.out.println("-1");
        else {
            possiblePos = compareCharEnigmaStyle(cryptoClearCharArray);
            printPos(possiblePos);
        }
    }

    private static char[][] readInput() {
        //String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaa\narmadillo";
        Scanner in = new Scanner(System.in);
        char[][] cryptoClearCharArray = new char[2][];
        //cryptoClearCharArray[0] = in.next().toCharArray();
        for (int i = 0; i < 2; i++) cryptoClearCharArray[i] = in.next().toCharArray();
        return cryptoClearCharArray;
    }

    private static int[] compareCharEnigmaStyle(char[][] cryptoClearCharArray) {

        boolean compareChar = false;
        int cryptoClearPos = cryptoClearCharArray[0].length - cryptoClearCharArray[1].length + 1;
        int[] possiblePos = new int[cryptoClearPos];
        for (int i=0, j=0, k=0, p=0; i < cryptoClearPos; i++) {
            k = i;
            for (j = 0; j < cryptoClearCharArray[1].length; j++) {
                compareChar = cryptoClearCharArray[0][k] == cryptoClearCharArray[1][j];
                k++;
                if (compareChar) break;
            }
            if (!compareChar) {possiblePos[p] = i+1; p++;}
        }

        return possiblePos;
    }

    public static void printPos(int[] possiblePos) {
        int arraySum = IntStream.of(possiblePos).sum();
        int p = 0;
        if (arraySum > 0) {
            for (int posElement : possiblePos) {
                p++;
                if (posElement == 0) break;
                if (possiblePos[p] != 0) System.out.print(posElement + " ");
                else System.out.println(posElement);

            }
        } else System.out.println("-1");
    }

}
