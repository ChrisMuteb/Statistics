package fr.epita.ass.datamodel;

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
