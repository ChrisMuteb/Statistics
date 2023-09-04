package fr.epita.ass.datamodel;

/**
 * Enum Sex having male and female as values
 */
public enum Sex {
    MALE("male"), FEMALE("female");
    private String gender;

    Sex(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
