package com.xeype;

/*
 ToDo
 Replace ready-made solutions with user input
 Add remaining methods
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MathTest {

    MathSet mathSet;

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice;

        try {
            mainMenu();
            choice = reader.readLine();
            createMathSet(choice);
        } catch (IOException e) {
            System.out.println("Something wrong: " + e.getMessage());
        }
    }

    private void mainMenu() {
        System.out.println("1 - Default constructor");
        System.out.println("2 - Constructor with capacity");
        System.out.println("3 - Constructor with array of numbers");
        System.out.println("4 - Constructor with array of arrays");
        System.out.println("5 - Constructor with MathSet object");
        System.out.println("6 - Constructor with MathSet objects");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

    private void createMathSet(String choice) {
        switch (choice) {
            case "1":
                mathSet = new MathSet();
                System.out.println("MathSet object has been created: ");
                System.out.println(mathSet.toString());
                addMenu();
                break;
            case "2":
                mathSet = new MathSet(7);
                System.out.println("MathSet object has been created with capacity = 7: ");
                System.out.println(mathSet.toString());
                addMenu();
                break;
            case "3":
                mathSet = new MathSet(new Number[]{0, 4, 2, 3, 1, 5});
                System.out.println("MathSet object has been created with array of numbers {0, 4, 2, 3, 1, 5}");
                System.out.println(mathSet.toString());
                addMenu();
                break;
            case "4":
                mathSet = new MathSet(new Number[]{0, 4, 2, 3, 1}, new Number[]{6, 5, 8, 7});
                System.out.println("MathSet object has been created with two arrays: {0, 4, 2, 3, 1} and {6, 5, 8, 7}");
                System.out.println(mathSet.toString());
                addMenu();
                break;
            case "5":
                MathSet mathSet1 = new MathSet(new Number[]{0, 4, 2, 3, 1});
                mathSet = new MathSet(mathSet1);
                System.out.println("MathSet object has been created with MathSet object (numbers=[0, 4, 2, 3, 1],"
                        + "capacity = 5, current_capacity = 5)");
                System.out.println(mathSet.toString());
                addMenu();
                break;
            case "6":
                MathSet mathSet2 = new MathSet(new Number[]{0, 4, 2, 3, 1});
                MathSet mathSet3 = new MathSet(new Number[]{6, 5, 8, 7});

                mathSet = new MathSet(mathSet2, mathSet3);

                System.out.println("MathSet object has been created with two MathSet objects: "
                        + "(numbers=[0, 4, 2, 3, 1], size = 5, current_capacity = 5) and"
                        + "(numbers=[6, 5, 8, 7], size = 4, current_capacity = 4)");
                System.out.println(mathSet.toString());
                addMenu();
                break;
            case "0":
                System.exit(1);
                break;
            default: {
                System.out.println("Please choose the correct action: ");
                mainMenu();
            }
        }
    }

    private void addMenu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1 - Add number to MathSet");
        System.out.println("2 - Add array of numbers to MathSet");
        System.out.println("3 - Join MathSet's");
        System.out.println("4 - Interception MathSet's");
        System.out.println("5 - Sort MathSet's");
        System.out.println("6 - Back to menu");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        String addChoice;
        try {
            while ((addChoice = reader.readLine()) != null) {
                addNumber(addChoice);
            }
        } catch (IOException e) {
            System.out.println("Something wrong:  = " + e.getMessage());
        }
    }

    private void addNumber(String addChoice) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int addNumber;
        String temp;
        switch (addChoice) {
            case "1":
                System.out.print("Please enter the number to add: ");
                addNumber = Integer.parseInt(reader.readLine());

                mathSet.add(addNumber);
                System.out.println("Updated MathSet: ");
                System.out.println(mathSet.toString());

                addMenu();
                break;
            case "2":
                System.out.println("MathSet before adding numbers: ");
                System.out.println(mathSet.toString());

                System.out.print("Please enter the array of numbers separated by a space: ");
                temp = reader.readLine();
                String[] split = temp.split(" ");
                for (String string : split) {
                    addNumber = Integer.parseInt(string);
                    mathSet.add(addNumber);
                }

                System.out.println("MathSet after adding numbers: ");
                System.out.println(mathSet.toString());
                addMenu();
                break;
            case "3":
                joinMenu();
                break;
            case "4":
                intersectionMenu();
                break;
            case "5":
                sortMenu();
                break;
            case "6":
                addMenu();
                break;
            case "0":
                System.exit(1);
                break;
            default: {
                System.out.print("Please choose the correct action: ");
            }
        }
    }

    private void joinMenu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1 - Join another MathSet to the current");
        System.out.println("2 - Join an array of MathSets to the current");
        System.out.println("3 - Add numbers menu");
        System.out.println("4 - Intersection menu");
        System.out.println("5 - Sorting menu");
        System.out.println("6 - Main menu");
        System.out.println("0 - Exit");
        System.out.println("Your choice: ");
        String joinChoice;
        try {
            while ((joinChoice = reader.readLine()) != null) {
                joinMathSet(joinChoice);
            }
        } catch (IOException e) {
            System.out.println("Something wrong: " + e.getMessage());
        }
    }

    private void joinMathSet(String joinChoice) {
        switch (joinChoice) {
            case "1":
                MathSet temp = new MathSet(new Number[]{34, 43, 18});

                System.out.println("MathSet before adding MathSet (numbers=[34, 43, 18], capacity = 3, current_capacity = 3");
                System.out.println(mathSet.toString());

                mathSet.join(temp);

                System.out.println("MathSet after adding MathSet: ");
                System.out.println(mathSet.toString());
                joinMenu();
                break;
            case "2":
                MathSet temp2 = new MathSet(new Number[]{31, 13, 4, 0});
                MathSet temp3 = new MathSet(new Number[]{139, 15, 8});

                System.out.println("MathSet before adding MathSet's: " +
                        "(numbers=[31, 13, 4, 0], capacity = 4, current_capacity = 4)" +
                        "(numbers=[139, 15, 8], capacity = 3, current_capacity = 3)");
                System.out.println(mathSet.toString());

                mathSet.join(temp2);
                mathSet.join(temp3);

                System.out.println("MathSet after adding MathSet's: ");
                System.out.println(mathSet.toString());
                joinMenu();
                break;
            case "3":
                addMenu();
                break;
            case "4":
                intersectionMenu();
                break;
            case "5":
                sortMenu();
                break;
            case "6":
                mainMenu();
                break;
            case "0":
                System.exit(1);
                break;
            default: {
                System.out.println("Please choose the correct action: ");
                joinMenu();
            }
        }
    }

    private void intersectionMenu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1 - intersection current MathSet with another MathSet");
        System.out.println("2 - intersection current MathSet with an array of MathSets");
        System.out.println("3 - Join menu");
        System.out.println("4 - Sort menu");
        System.out.println("5 - Main menu");
        System.out.println("0 - Exit");
        String intersectionChoice;
        try {
            while ((intersectionChoice = reader.readLine()) != null) {
                intersectionMathSet(intersectionChoice);
            }
        } catch (IOException e) {
            System.out.println("Something wrong: " + e.getMessage());
        }
    }

    private void intersectionMathSet(String intersectionChoice) {
        switch (intersectionChoice) {
            case "1":
                MathSet temp = new MathSet(new Number[]{13, 33, 2});

                System.out.println("MathSet before intersection with a MathSet (numbers=[13, 33, 2], size = 3, current_capacity = 3):");
                System.out.println(mathSet.toString());

                mathSet.intersection(temp);

                System.out.println("Updated MathSet: ");
                System.out.println(mathSet.toString());
                intersectionMenu();
                break;
            case "2":
                MathSet temp2 = new MathSet(new Number[]{18, 22, 3, 12});
                MathSet temp3 = new MathSet(new Number[]{13, 5, 132});

                System.out.println("MathSet before intersection with a MathSet (numbers=[18, 22, 3, 12], size=3, current_capacity=3) " +
                        "and (numbers=[13, 5, 132], size=3, current_capacity=3):");
                System.out.println(mathSet.toString() + "\n");

                mathSet.intersection(temp2, temp3);

                System.out.println("Update MathSet: ");
                System.out.println(mathSet.toString());
                intersectionMenu();
                break;
            case "3":
                joinMenu();
                break;
            case "4":
                sortMenu();
                break;
            case "5":
                mainMenu();
                break;
            case "0":
                System.exit(1);
            default: {
                System.out.println("Please choose the correct action: ");
                intersectionMenu();
            }
        }
    }

    private void sortMenu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1 - Sort MathSet by Descending");
        System.out.println("2 - Sort the spacing of MathSet by Descending");
        System.out.println("3 - Sort MathSet by descending starting from a chosen Number value");
        System.out.println("4 - Sort MathSet by Ascending");
        System.out.println("5 - Sort the spacing of MathSet by ascending");
        System.out.println("6 - Sort MathSet by ascending starting from a chosen Number value");
        System.out.println("7 - Main menu");
        System.out.println("0 - Exit");
        System.out.println("Your choice: ");
        String sortChoice;
        try {
            while ((sortChoice = reader.readLine()) != null) {
                sortMathSet(sortChoice);
            }
        } catch (IOException e) {
            System.out.println("Something wrong: " + e.getMessage());
        }
    }

    private void sortMathSet(String sortChoice) {
        switch (sortChoice) {
            case "1":
                mathSet = new MathSet(new Number[]{13, 2, 44, 9, 111, 434, 6, 3});
                System.out.println("MathSet before sorting by descending: ");
                System.out.println(mathSet.toString());

                mathSet.sortDesc();

                System.out.println("MathSet after sorting by descending: ");
                System.out.println(mathSet.toString());
                sortMenu();
                break;
            case "2":
                mathSet = new MathSet(new Number[]{13, 2, 44, 9, 111, 434, 6, 3});
                System.out.println("MathSet before sorting by descending in the range [2-6]: ");
                System.out.println(mathSet.toString());

                mathSet.sortDesc(2, 6);

                System.out.println("MathSet after sorting by descending in the range [2-6]: ");
                System.out.println(mathSet.toString());
                sortMenu();
                break;
            case "3":
                mathSet = new MathSet(new Number[]{13, 2, 44, 9, 111, 434, 6, 3});
                System.out.println("MathSet before sorting by descending starting from '9':");
                System.out.println(mathSet.toString());

                mathSet.sortDesc(9);

                System.out.println("MathSet after sorting by descending starting from '9': ");
                System.out.println(mathSet.toString());
                sortMenu();
                break;
            case "4":
                mathSet = new MathSet(new Number[]{13, 2, 44, 9, 111, 434, 6, 3});
                System.out.println("MathSet before sorting by ascending: ");
                System.out.println(mathSet.toString());

                mathSet.sortAsc();

                System.out.println("MathSet after sorting by ascending: ");
                System.out.println(mathSet.toString());
                sortMenu();
                break;
            case "5":
                mathSet = new MathSet(new Number[]{13, 2, 44, 9, 111, 434, 6, 3});
                System.out.println("MathSet before sorting by descending in the range [2-6]");
                System.out.println(mathSet.toString());

                mathSet.sortAsc(2, 6);

                System.out.println("MathSet after sorting by ascending in the range [2-6]");
                System.out.println(mathSet.toString());
                sortMenu();
                break;
            case "6":
                mathSet = new MathSet(new Number[]{13, 2, 44, 9, 111, 434, 6, 3});
                System.out.println("MathSet before sorting by ascending starting from '9':");
                System.out.println(mathSet.toString());

                mathSet.sortAsc(9);

                System.out.println("MathSet before sorting by ascending starting from '9':");
                System.out.println(mathSet.toString());
                sortMenu();
                break;
            case "7":
                mainMenu();
                break;
            case "0":
                System.exit(1);
                break;
            default:
                System.out.println("Please choose the correct action: ");
                sortMenu();
        }
    }
}
