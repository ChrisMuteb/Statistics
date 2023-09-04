package fr.epita.ass.datamodel;

public enum PassengerClass {
    FIRST("1st"), SECOND("2nd"), THIRD("3rd");
    String pClass;

    PassengerClass(String pClass) {
        this.pClass = pClass;
    }
    public String getpClass(){
        return pClass;
    }
}
