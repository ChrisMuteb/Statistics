package fr.epita.ass.datamodel;

public class Passenger {
    private String name;
    private PassengerClass passengerClass;
    private Double age;
    private Sex sex;
    private Boolean survived;

    public Passenger(String name, PassengerClass passengerClass, Double age, Sex sex, Boolean survived) {
        this.name = name;
        this.passengerClass = passengerClass;
        this.age = age;
        this.sex = sex;
        this.survived = survived;
    }

    public Passenger(String name, Boolean survived) {
        this.name = name;
        this.survived = survived;
    }

    public Double getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public PassengerClass getPassengerClass() {
        return passengerClass;
    }

    public Sex getSex() {
        return sex;
    }

    public Boolean getSurvived() {
        return survived;
    }

    @Override
    public String toString() {
        return "Passenger [" +
                "name=\"" + name + "\"" +
                "pClass=" + passengerClass + " " +
                ", survived=\"" + survived +
                "\"]";
    }
}
