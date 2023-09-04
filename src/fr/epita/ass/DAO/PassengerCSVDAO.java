package fr.epita.ass.DAO;

import fr.epita.ass.datamodel.Passenger;
import fr.epita.ass.datamodel.PassengerClass;
import fr.epita.ass.datamodel.Sex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.*;

/**
 * PasengerCSVDAO class reads all line from the file and returns a list of Passenger furthermore, it writes to a file as well.
 */
public class PassengerCSVDAO {

    /**
     * read all lines from the file
     * @return List of Passengers
     * @throws IOException
     * @throws ParseException
     */
    public List<Passenger> readAll() throws IOException, ParseException {
        File csvFile = new File("data-training.csv");
        List<String> lines = null;
        List<Passenger> passengers = new ArrayList<>();

        lines = Files.readAllLines(csvFile.toPath());//read lines and store them in the list passenger.

        for(int i = 1; i < lines.size(); i++){
            String currentLine = lines.get(i);
            List<String> partsForSecondPassenger = Arrays.asList(currentLine.split(";")); // split each line using ';'

            PassengerClass passClass = null;
            Sex sx = null;
            String nm = partsForSecondPassenger.get(0).trim();// get from the list at index 0 the value of the name read then trim the string
            for(PassengerClass pc: PassengerClass.values()){
                if(pc.getpClass().equals(partsForSecondPassenger.get(1).trim()))
                    passClass = pc;
            }

            Double age = 0.0;
            if(!partsForSecondPassenger.get(2).trim().equals(""))
                age = Double.valueOf(partsForSecondPassenger.get(2).trim()); // parse the String into Double

            for(Sex s: Sex.values()) // itterate through enum Sex values
                if(s.getGender().equals(partsForSecondPassenger.get(3).trim()))
                    sx = s;
            Boolean survive = partsForSecondPassenger.get(4).trim().equals("1") ? true : false;
            Passenger passenger = new Passenger(nm, passClass, age, sx, survive);

            passengers.add(passenger);
        }

        // using a functional programming approach to sort the list by age.
        Comparator<Passenger> ageComparator = Comparator.comparingDouble(Passenger::getAge);
        Collections.sort(passengers, ageComparator);

        return passengers;
    }

    /**
     * write to a 'data_output.csv' following this format 'pClass   ;Name   ;Sex    ;Age    ;Survived'
     * @param passengers
     * @throws FileNotFoundException
     */
    public void writeAll(List<Passenger> passengers) throws FileNotFoundException {
        File file = new File("data_output.csv");
        PrintWriter writer = new PrintWriter(file);

        for(Passenger ps: passengers){
            String line = "";
            line += ps.getPassengerClass() + ";";
            line += ps.getName() + ";";
            line += ps.getSex() + ";";
            line += ps.getAge() + ";";
            line += ps.getSurvived();

            writer.println(line);
            System.out.println(line);
        }
        writer.close();
    }
}
