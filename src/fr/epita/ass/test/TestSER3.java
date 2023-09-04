package fr.epita.ass.test;

import fr.epita.ass.datamodel.Passenger;
import fr.epita.ass.DAO.PassengerCSVDAO;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * TestSER3 write the data read from the 'data-training.csv' to a file named 'data_output.csv'
 */
public class TestSER3 {
//    public static void main(String[] args) throws IOException, ParseException {
//        test();
//    }

    /**
     * write formatted data to a data_output csv file.
     * @throws IOException
     * @throws ParseException
     */
    public static void test() throws IOException, ParseException {
        PassengerCSVDAO passengerCSVDAO = new PassengerCSVDAO();
        List<Passenger> ps = passengerCSVDAO.readAll();
        passengerCSVDAO.writeAll(ps);
    }
}
