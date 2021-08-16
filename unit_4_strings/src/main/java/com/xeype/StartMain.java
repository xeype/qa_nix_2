package com.xeype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartMain {

    public static void main(String[] args) {
        byte choiceOfReverse = 1;

        System.out.println("----- START -----");

        while (choiceOfReverse != 0) {
            System.out.print("\nEnter the reverse method!\n"
                    + "1 - Reverse the whole line\n"
                    + "2 - Reverse by substring\n"
                    + "3 - Reverse by indexes\n"
                    + "\n0 - Exit\n\nMethod: ");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            try {
                choiceOfReverse = (byte) Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (choiceOfReverse) {
                case 0: {
                    System.out.println("\n----- END -----");
                }
                break;
                case 1: {
                    String enteredString = "";
                    System.out.println("Enter the string to be reversed: ");
                    try {
                        enteredString = bufferedReader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("\nReversed string: \n" + ReverseMethods.reverse(enteredString));
                }
                break;
                case 2: {
                    String enteredString = "";
                    String subString = "";

                    System.out.println("Enter the string: ");
                    try {
                        enteredString = bufferedReader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Enter the substring to be reversed: ");
                    try {
                        subString = bufferedReader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("\nReversed string: \n" + ReverseMethods.reverseBySubstring(enteredString, subString));
                }
                break;
                case 3: {
                    String enteredString = "";
                    int firstIndex = 0;
                    int lastIndex = 0;

                    System.out.println("Enter the string: ");
                    try {
                        enteredString = bufferedReader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.print("Enter the first index: ");
                    try {
                        firstIndex = Integer.parseInt(bufferedReader.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.print("Enter the last index: ");
                    try {
                        lastIndex = Integer.parseInt(bufferedReader.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("\nReversed string: \n" + ReverseMethods.reverseByIndexes(enteredString, firstIndex, lastIndex));
                }
                break;
                default: {
                    System.out.println("\nPlease enter the correct number of method: ");
                }
            }
        }
    }
}
