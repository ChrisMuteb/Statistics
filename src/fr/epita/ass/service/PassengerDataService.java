package fr.epita.ass.service;

import fr.epita.ass.datamodel.Passenger;
import fr.epita.ass.datamodel.PassengerClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PassengerDataService {
    public List<Passenger> filterSurvived(List<Passenger> passengers, Boolean survived){
        List<Passenger> ps = new ArrayList<>();
        for(Passenger p: passengers){
            if(p.getSurvived().equals(survived))
                ps.add(p);
        }
        return ps;
    }

    public int averageAge(List<Passenger> passengers){
        int avg = 0;
        for(Passenger p: passengers)
            if(!p.getAge().equals(null))
                avg += p.getAge();
        return avg / passengers.size();
    }

    public Map<String, Double> calculateAgeDistribution(List<Passenger> passengers){
        // Step 1: Create a map to store the age distribution
        Map<String, Double> ageDistribution = new HashMap<>();

        // Step 2: Iterate through the passengers
        for(Passenger ps: passengers){
            Double age = ps.getAge();
            ageDistribution.put(Double.toString(age), ageDistribution.getOrDefault(Double.toString(age), 0.0) + 1.0);
        }
        // Step 3: get total passenger number
        int totalPassengers = passengers.size();

        // Calculate percentages and update the distribution map
        for(Map.Entry<String, Double> entry: ageDistribution.entrySet()){
            Double percentage = (entry.getValue() / totalPassengers) * 100.0;
            ageDistribution.put(entry.getKey(), percentage );
        }
        return ageDistribution;
    }

    public Map<String, Double> calculatePClassDistribution2(List<Passenger> passengers){
        // total count
        int totalCount = passengers.size();

        // store distribution
        Map<String, Double> pClassDistribution = new HashMap<>();

        // Iterate through the list
        for(Passenger ps: passengers){
            if(pClassDistribution.containsKey(ps.getPassengerClass().getpClass()))
                pClassDistribution.put(ps.getPassengerClass().getpClass(), pClassDistribution.get(ps.getPassengerClass().getpClass())+1);

            else
                pClassDistribution.put(ps.getPassengerClass().getpClass(), 1.0);
        }

        // calculate percentage for each pClass
        for(Map.Entry<String, Double> e: pClassDistribution.entrySet()){
            double percentage = (e.getValue() / totalCount) * 100;
            e.setValue(percentage);
        }
        return pClassDistribution;
    }

    public void weightedMean(List<Passenger> passengers, Boolean survived){
        // get a list of passengers
        List<Passenger> pass = filterSurvived(passengers, survived);


    }

    public double weightedAgeMean(List<Passenger> passengers){
        double totalAgeSum = 0.0;
        int totalCount = 0;

        // calculate sum of ages and total count for the group
        for(Passenger ps: passengers){
            Double age = ps.getAge();
            if(age != null){
                totalAgeSum += age;
                totalCount++;
            }
        }
        return (totalCount > 0) ? (totalAgeSum / totalCount) : 0.0;
    }

    // Helper method to get survived centroids
    public static Map<Integer, Passenger> getSurvivedCentroids(List<Passenger> passengers) {
        Map<Integer, Passenger> survivedCentroids = new HashMap<>();

        // Filter passengers by survival status
        List<Passenger> survivedPassengers = passengers.stream()
                .filter(Passenger::getSurvived)
                .collect(Collectors.toList());

        List<Passenger> notSurvivedPassengers = passengers.stream()
                .filter(passenger -> !passenger.getSurvived())
                .collect(Collectors.toList());

        // Calculate centroids for survived and not survived groups
        Passenger survivedCentroid = calculateCentroid(survivedPassengers);
        Passenger notSurvivedCentroid = calculateCentroid(notSurvivedPassengers);

        survivedCentroids.put(1, survivedCentroid);
        survivedCentroids.put(0, notSurvivedCentroid);

        return survivedCentroids;
    }

    // Helper method to calculate centroids
    private static Map<Boolean, Passenger> calculateCentroids(List<Passenger> passengers) {
        Map<Boolean, Passenger> centroids = new HashMap<>();

        // Group passengers by survival status
        Map<Boolean, List<Passenger>> groupedPassengers = passengers.stream()
                .collect(Collectors.groupingBy(Passenger::getSurvived));

        // Calculate centroids for each group
        for (Map.Entry<Boolean, List<Passenger>> entry : groupedPassengers.entrySet()) {
            Boolean survivalStatus = entry.getKey();
            List<Passenger> groupPassengers = entry.getValue();

            double ageSum = 0.0;
            int totalCount = groupPassengers.size();

            // Calculate the sum of ages
            for (Passenger passenger : groupPassengers) {
                ageSum += passenger.getAge();
            }

            // Calculate the weighted mean of Age
            double ageWeightedMean = ageSum / totalCount;

            // Select a representative passenger for PClass and Sex
            Passenger representativePassenger = groupPassengers.get(0);

            // Create a centroid for the group
            Passenger centroid = new Passenger(
                    "Centroid",
                    representativePassenger.getPassengerClass(),
                    ageWeightedMean,
                    representativePassenger.getSex(),
                    survivalStatus
            );

            centroids.put(survivalStatus, centroid);
        }

        return centroids;
    }

    // Helper method to calculate a centroid for a group of passengers
    private static Passenger calculateCentroid(List<Passenger> passengers) {
        double ageSum = passengers.stream().mapToDouble(Passenger::getAge).sum();
        int totalCount = passengers.size();

        double ageWeightedMean = ageSum / totalCount;

        // Select a representative passenger for PClass and Sex
        Passenger representativePassenger = passengers.get(0);

        return new Passenger(
                "Centroid",
                representativePassenger.getPassengerClass(),
                ageWeightedMean,
                representativePassenger.getSex(),
                true // We assume this is for survived group
        );
    }

    // determine the weight of any PassengerClass
    private double weight(List<Passenger> passengers, String ps){
        double result = 0.0;
        long total = passengers.size();

        long value = passengers.stream().filter(p -> p.getPassengerClass().getpClass().equals(ps)).count();
        result = (double)value / total;

        return result;
    }

    // determine the mean of any PassengerClass
    public static Map<PassengerClass, Double> calculateMeanPClass(List<Passenger> passengers) {
        Map<PassengerClass, Long> classCounts = passengers.stream()
                .collect(Collectors.groupingBy(Passenger::getPassengerClass, Collectors.counting()));

        Map<PassengerClass, Double> meanPClass = new HashMap<>();
        long totalPassengers = passengers.size();

        for (Map.Entry<PassengerClass, Long> entry : classCounts.entrySet()) {
            PassengerClass pClass = entry.getKey();
            long count = entry.getValue();
            double mean = (double) count / totalPassengers;
            meanPClass.put(pClass, mean);
        }

        return meanPClass;
    }


}
