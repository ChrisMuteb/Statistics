package fr.epita.ass.test;

import fr.epita.ass.datamodel.Passenger;

public class TestDM02 {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Passenger passenger = new Passenger("Abbing, Mr Anthony", true);
        System.out.println(passenger);
    }
}
