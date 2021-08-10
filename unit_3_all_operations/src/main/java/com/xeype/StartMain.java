package com.xeype;

import java.util.Scanner;

public class StartMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- START -----\n");
        System.out.printf("Hello! Enter a number of task!\n1 - Sum of digits in the string\n2 - Amount of letters in the string\n3 - End time of lessons\n0 - Exit\nYour choice: %n");
        byte taskNumber = 1;
        while (taskNumber != 0) {
            taskNumber = scanner.nextByte();
            switch (taskNumber) {
                case 0: {
                    System.out.println("\n----- END -----");
                }
                break;
                case 1: {
                    new SumDigitsFromString().run();
                    System.out.println("\nEnter a number of task: ");
                }
                break;
                case 2: {
                    new AmountLettersFromString().run();
                    System.out.println("\nEnter a number of task: ");
                }
                break;
                case 3: {
                    new EndOfLessons().run();
                    System.out.println("\nEnter a number of task: ");
                }
                break;
                default: {
                    System.out.println("\nPlease enter the correct number of task: ");
                }
            }
        }
    }
}