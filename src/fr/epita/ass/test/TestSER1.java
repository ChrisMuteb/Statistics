package fr.epita.ass.test;

import fr.epita.ass.datamodel.Passenger;
import fr.epita.ass.datamodel.PassengerClass;
import fr.epita.ass.datamodel.Sex;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

/**
 * TestSER1 reads all the lines from the file and display the 2nd line
 */
public class TestSER1 {
//    public static void main(String[] args) throws IOException {
//
//        test();
//
//    }
    public static void test() {
        File csvFile = new File("data-training.csv");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(csvFile.toPath());// read all lines from the file and store them inside a list called lines
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String secondLine = lines.get(1);
        List<String> partsForSecondPassenger = Arrays.asList(secondLine.split(";"));
        String nm = partsForSecondPassenger.get(0).trim();// store the name from the second line read from the file into nm variable

        PassengerClass passClass = null;
        for(PassengerClass pc: PassengerClass.values()){ // iterate through all the enum PassengerClass values
            if(pc.getpClass().equals(partsForSecondPassenger.get(1).trim())) // compare if the read PassengerClass value equals to any of the values from the enum
                passClass = pc;
        }

        Double age = Double.valueOf(partsForSecondPassenger.get(2));

        Sex sx = null;
        for(Sex s: Sex.values()) // iterate through all the enum Sex values
            if(s.getGender().equals(partsForSecondPassenger.get(3).trim()))
                sx = s;

        Boolean survive = partsForSecondPassenger.get(4).trim().equals("1") ? true : false;

        Passenger passenger = new Passenger(nm, passClass, age, sx, survive);
        System.out.println(passenger);
//        System.out.println(passClass.getpClass() + " " + age + " " + sx.getGender());
    }
}
