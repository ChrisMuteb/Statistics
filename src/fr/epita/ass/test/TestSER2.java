package fr.epita.ass.test;

import fr.epita.ass.DAO.PassengerCSVDAO;

import java.io.IOException;
import java.text.ParseException;

public class TestSER2 {
    public static void main(String[] args) throws IOException, ParseException {
        test();
    }
    public static void test() throws IOException, ParseException {
        PassengerCSVDAO ps = new PassengerCSVDAO();

        ps.readAll().stream().forEach(System.out::println);
    }
}
