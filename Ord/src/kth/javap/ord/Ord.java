package kth.javap.ord;

/**
 * Created by dreut on 2017-01-25.
 */

import java.util.Scanner;

public class Ord {

    public static void main(String[] args) {
        readInList();
    }

    private static void readInList() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print(input.next("\\w+"));
        }
    }

}