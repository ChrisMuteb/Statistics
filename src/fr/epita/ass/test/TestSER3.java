package fr.epita.ass.test;

import fr.epita.ass.datamodel.Passenger;
import fr.epita.ass.DAO.PassengerCSVDAO;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class TestSER3 {


    public static void main(String[] args) throws IOException, ParseException {
        test();
    }

    public static void test() throws IOException, ParseException {
        PassengerCSVDAO passengerCSVDAO = new PassengerCSVDAO();
        List<Passenger> ps = passengerCSVDAO.readAll();
        passengerCSVDAO.writeAll(ps);
    }
}
