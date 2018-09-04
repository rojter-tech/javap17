package kth.javap.ord;

import java.util.Scanner;

public class TestOrd {

    public static void main(String[] args) {
        readInList();
    }

    private static void readInList() {
        Scanner input = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        while (input.hasNextLine()){
            builder.append(input.next("\\w+"));
        }
        System.out.print(builder.toString());
    }

}