package com.xeype;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SumDigitsFromString {

    public void run() {
        System.out.println("Please enter the string: ");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = "";
        try {
            inputString = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String numbersOnly = inputString.replaceAll("[^0-9]", "");

        int[] numbers = new int[numbersOnly.length()];
        int sum = 0;

        for (int i = 0; i < numbersOnly.length(); i++) {
            numbers[i] = numbersOnly.charAt(i) - '0';
            sum += numbers[i];
        }

        System.out.println("Sum of digits in the string = " + sum);
    }
}