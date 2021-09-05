package com.xeype.service;

import com.xeype.entity.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ObjectReporter {

    public void start() {
        ObjectImpl objectImpl = new ObjectImpl();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter the planet: "
                    + "\n1 - Mercury"
                    + "\n2 - Venus"
                    + "\n3 - Earth"
                    + "\n4 - Mars"
                    + "\n5 - Jupyter"
                    + "\n6 - Saturn"
                    + "\n7 - Uranus"
                    + "\n8 - Neptune"
                    + "\n9 - Sun"
                    + "\n10 - Moon"
                    + "\n0 - Exit"
                    + "\nYour choice: ");

            try {
                String choice = reader.readLine();
                switch (choice) {
                    case "1":
                        BaseObject mercury = new Mercury();
                        System.out.println(objectImpl.getAcceleration(mercury.getRadius(), mercury.getWeight()));
                        break;
                    case "2":
                        BaseObject venus = new Venus();
                        System.out.println(objectImpl.getAcceleration(venus.getRadius(), venus.getWeight()));
                        break;
                    case "3":
                        BaseObject earth = new Earth();
                        System.out.println(objectImpl.getAcceleration(earth.getRadius(), earth.getWeight()));
                        break;
                    case "4":
                        BaseObject mars = new Mars();
                        System.out.println(objectImpl.getAcceleration(mars.getRadius(), mars.getWeight()));
                        break;
                    case "5":
                        BaseObject jupyter = new Jupyter();
                        System.out.println(objectImpl.getAcceleration(jupyter.getRadius(), jupyter.getWeight()));
                        break;
                    case "6":
                        BaseObject saturn = new Saturn();
                        System.out.println(objectImpl.getAcceleration(saturn.getRadius(), saturn.getWeight()));
                        break;
                    case "7":
                        BaseObject uranus = new Uranus();
                        System.out.println(objectImpl.getAcceleration(uranus.getRadius(), uranus.getWeight()));
                        break;
                    case "8":
                        BaseObject neptune = new Neptune();
                        System.out.println(objectImpl.getAcceleration(neptune.getRadius(), neptune.getWeight()));
                        break;
                    case "9":
                        BaseObject sun = new Sun();
                        System.out.println(objectImpl.getAcceleration(sun.getRadius(), sun.getWeight()));
                        break;
                    case "10":
                        BaseObject moon = new Moon();
                        System.out.println(objectImpl.getAcceleration(moon.getRadius(), moon.getWeight()));
                        break;
                    case "0":
                        System.exit(0);
                    default:
                        System.out.println("Enter the correct planet!");
                }
                System.out.println("----------");
            } catch (IOException e) {
                System.out.println("error = " + e.getMessage());
            }
        }
    }
}
