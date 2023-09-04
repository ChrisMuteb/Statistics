package fr.epita.ass.datamodel;

/**
 *  PassengerClass enum has 1st, 2nd & 3rd as values
 */
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
