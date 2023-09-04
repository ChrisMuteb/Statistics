package fr.epita.ass.launcher;

import fr.epita.ass.test.*;

import java.io.IOException;
import java.text.ParseException;

/**
 * Entrypoint  of the program
 */
public class Launcher {
    public static void main(String[] args) throws IOException, ParseException {

        TestDM02.test();
        TestSER1.test();
        TestSER2.test();
        TestSER3.test();
        TestBLI1.test();
        TestBLI2.test();
    }
}
