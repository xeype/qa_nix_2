package com.xeype;

import java.util.Scanner;

public class EndOfLessons {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        byte countOfLessons = 0;

        System.out.println("Enter the number of lessons(1-10): ");

//         Checking the number of lessons (Loops banned by task condition)
//        while(countOfLessons > 10 || countOfLessons <= 0)
            countOfLessons = scanner.nextByte();

        int totalMinutes = countOfLessons * 45 + (countOfLessons / 2) * 5 + ((countOfLessons + 1) / 2 - 1) * 15;
        System.out.println("Lessons end at: " + (totalMinutes / 60 + 9) + " " + (totalMinutes % 60));
    }
}
