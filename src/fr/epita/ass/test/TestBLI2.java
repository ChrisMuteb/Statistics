package fr.epita.ass.test;

import fr.epita.ass.DAO.PassengerCSVDAO;
import fr.epita.ass.datamodel.Passenger;
import fr.epita.ass.service.PassengerDataService;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestBLI2 {
    public static void main(String[] args) throws IOException, ParseException {
        test();
    }
    public static void test() throws IOException, ParseException {
        PassengerDataService passengerDataService = new PassengerDataService();

        PassengerCSVDAO passengerCSVDAO = new PassengerCSVDAO();
        List<Passenger> lst = passengerCSVDAO.readAll();
//        List<Passenger> filteredList = passengerDataService.filterSurvived(lst, true);
//        Map<String, Double> ageDistribution = passengerDataService.calculatePClassDistribution2(filteredList);
//
//        System.out.print("{");
//        for(Map.Entry<String, Double> entry: ageDistribution.entrySet()){
//            System.out.print(entry.getKey() + "=" + entry.getValue() + ", ");
//        }
//        System.out.println("}");

        Map<Integer, Passenger> result = passengerDataService.getSurvivedCentroids(lst);
        for(Map.Entry<Integer, Passenger> e: result.entrySet())
            System.out.println("Typical surviving passenger: PClass = " + e.getValue().getPassengerClass() + ", Sex = " + e.getValue().getSex() + ", Age = " + e.getValue().getAge());
    }


}
