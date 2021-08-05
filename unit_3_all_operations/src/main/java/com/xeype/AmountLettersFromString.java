package com.xeype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmountLettersFromString {
    public void run() {
        System.out.println("Please enter the string: ");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = "";
        try {
            inputString = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String lettersOnly = inputString.replaceAll("[^A-Za-zА-Яа-яЁё]", "");
        System.out.println("Entered string = " + inputString);
        char[] letters = lettersOnly.toCharArray();

        char temp;
        int count = 0;
        int length = letters.length - count;

        for(int i = 0; i < length;) {
            temp = letters[i];
            for(int j = 0; j < length; j++) {
                if(temp == letters[j]) {
                    count++;
                }
            }

            // Cyrillic/Latin check
            if (Character.UnicodeBlock.of(temp).equals(Character.UnicodeBlock.BASIC_LATIN)) {
                System.out.println("Amount of " + temp + " [LAT] " + " = " + count);
            } else if (Character.UnicodeBlock.of(temp).equals(Character.UnicodeBlock.CYRILLIC)) {
                System.out.println("Amount of " + temp + " [CYR] " + " = " + count);
            }

            // Removing counted letters from a string
            lettersOnly = lettersOnly.replaceAll(Character.toString(temp), "");
            letters = lettersOnly.toCharArray();
            length -= count;
            count = 0;
        }
    }
}