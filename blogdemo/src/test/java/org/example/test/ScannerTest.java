package org.example.test;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n+1; i++) {
            int next = scanner.nextInt();
            System.out.println(next);
        }
    }
}
