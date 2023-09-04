package fr.epita.ass.test;

import fr.epita.ass.datamodel.Passenger;

/**
 * Class TestDM02 creates an instance of Passenger producing the following output
 * "Passenger [name="Abbing, Mr Anthony", survived="true"]"
 */
public class TestDM02 {

//    public static void main(String[] args) {
//        test();
//    }
    public static void test() {
        Passenger passenger = new Passenger("Abbing, Mr Anthony", true);
        System.out.println(passenger);
    }
}
