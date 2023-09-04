package fr.epita.ass.test;

import fr.epita.ass.datamodel.Passenger;
import fr.epita.ass.datamodel.PassengerClass;
import fr.epita.ass.datamodel.Sex;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class TestSER1 {


    public static void main(String[] args) throws IOException {

        test();

    }

    public static void test() {
        File csvFile = new File("data-training.csv");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(csvFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String secondLine = lines.get(1);
        List<String> partsForSecondPassenger = Arrays.asList(secondLine.split(";"));
        String nm = partsForSecondPassenger.get(0).trim();

        PassengerClass passClass = null;
        for(PassengerClass pc: PassengerClass.values()){
            if(pc.getpClass().equals(partsForSecondPassenger.get(1).trim()))
                passClass = pc;
        }
//         = PassengerClass.valueOf(partsForSecondPassenger.get(1));
        Double age = Double.valueOf(partsForSecondPassenger.get(2));

        Sex sx = null;
        for(Sex s: Sex.values())
            if(s.getGender().equals(partsForSecondPassenger.get(3).trim()))
                sx = s;

        Boolean survive = partsForSecondPassenger.get(4).trim().equals("1") ? true : false;

        Passenger passenger = new Passenger(nm, passClass, age, sx, survive);
        System.out.println(passenger);
//        System.out.println(passClass.getpClass() + " " + age + " " + sx.getGender());
    }
}
