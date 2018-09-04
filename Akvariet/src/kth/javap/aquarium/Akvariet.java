package kth.javap.aquarium;

import java.util.Locale;
import java.util.Scanner;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Akvariet {

    public static void main(String[] args)  {
        //Huvudprogrammet
        runAquarium();
    }

    private static void runAquarium() {
        Double[][] pointsDouble = readInput();
        double fishDist = calcDist(pointsDouble);
        System.out.format("%.2f%n",fishDist);
    }

    private static Double[][] readInput()  {
        Scanner input = new Scanner(System.in).useLocale(Locale.ENGLISH);
        int numPoints = input.nextByte();

        Double[][] pointsDouble = new Double[numPoints][];
        Double[] coordDoubleArray = new Double[3];
        for (int i = 0; i < numPoints; i++) {
            for (int j = 0; j < 3; j++) {
                coordDoubleArray[j] = input.nextDouble();
            }
            pointsDouble[i] = coordDoubleArray.clone();
        }
        input.reset();
        input.close();
        return pointsDouble;
    }

    private static double calcDist(Double[][] pointsDouble) {
        // Beraknar den sammanlagda distansen mellan alla punkter
        double fishDist = 0d;
        Double[][] twoPointDouble = new Double[2][];
        int k = 0;
        for (int j = 0; j < pointsDouble.length - 1; j++) {
            for (int i = j; i < j+2; i++) {
                twoPointDouble[k] = pointsDouble[i].clone();
                k++;
            }
            k = 0;
            fishDist += distPoints(twoPointDouble);
        }
        return fishDist;
    }

    private static double distPoints(Double[][] twoPointDouble) {
        // Distans mellan tva punkter
        double twoPointDist;
        twoPointDist = sqrt(
            pow(twoPointDouble[0][0]-twoPointDouble[1][0],2) +
            pow(twoPointDouble[0][1]-twoPointDouble[1][1],2) +
            pow(twoPointDouble[0][2]-twoPointDouble[1][2],2)
        );
        return twoPointDist;
    }

}