package fr.epita.ass.test;

import fr.epita.ass.DAO.PassengerCSVDAO;

import java.io.IOException;
import java.text.ParseException;

/**
 * TestSER2 class having a test function reading data from the file
 */
public class TestSER2 {
//    public static void main(String[] args) throws IOException, ParseException {
//        test();
//    }
    public static void test() throws IOException, ParseException {
        PassengerCSVDAO ps = new PassengerCSVDAO();

        /**
         * using functional programming the statement below print out all the data read from the file
         */
        ps.readAll().stream().forEach(System.out::println);
    }
}
