package fr.epita.ass.test;

import fr.epita.ass.DAO.PassengerCSVDAO;
import fr.epita.ass.datamodel.Passenger;
import fr.epita.ass.service.PassengerDataService;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * TestBLI1
 */
public class TestBLI1 {
//    public static void main(String[] args) throws IOException, ParseException {
//        test();
//    }

    /**
     * displays the data filtered, then the average, followed by the distribution
     * @throws IOException
     * @throws ParseException
     */
    public static void test() throws IOException, ParseException {
        PassengerDataService passengerDataService = new PassengerDataService();

        PassengerCSVDAO passengerCSVDAO = new PassengerCSVDAO();
        List<Passenger> lst = passengerCSVDAO.readAll();
        List<Passenger> filteredList = passengerDataService.filterSurvived(lst, true); // call to the filterSurvived on the persengers list
        filteredList.stream().forEach(System.out::println);
        System.out.println("Avg of the filtered list: " + passengerDataService.averageAge(filteredList)); // call the average function
        Map<String, Double> ageDistribution = passengerDataService.calculateAgeDistribution(filteredList); // get the distribution

        System.out.print("{");
        for(Map.Entry<String, Double> entry: ageDistribution.entrySet()){ // convert the map into an entrySet so that i can obtain their key and values
            System.out.print(entry.getKey() + "=" + entry.getValue() + ", ");
        }
        System.out.println("}");
    }
}
