package com.rojter.java;

public class DiscreteMath {

    private static void countdown(int n) {
        if (n == 0) {
            System.out.println("Blastoff!");
        } else {
            System.out.println(n);
            countdown(n - 1);
        }
    }

    private static void countup(int n) {
        if (n == 0) {
            System.out.println("Blastoff!");
        } else {
            countup(n - 1);
            System.out.println(n);
        }
    }

    private static void displayBinary(int value) {
        if (value > 0) {
            displayBinary(value / 2);
            System.out.print(value % 2);
        }
    }

    private static void displayPos(int value, int posBase) {
        if (value > 0) {
            displayPos(value / posBase, posBase);
            System.out.print(value % posBase);
        }
    }

    private static int a(int n) {
        if (n == 0)
            return 1;
        else
            return 2*a(n-1) + 1;
    }

    private static int fibo(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibo(n-1) + fibo(n-2);
    }

    private static int sumrec(int n, int k) {
        if (n < k)
            return 0;
        else
            return sumrec(n - 1, k);
    }


    public static void main(String[] args) {
        // det har ska tydligen vara ett program
        System.out.println("Hej Diskret Matte");
        System.out.println("Fibonacci kan dra:");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibo(i) + ", ");
        }
        System.out.print("...");
    }

}
