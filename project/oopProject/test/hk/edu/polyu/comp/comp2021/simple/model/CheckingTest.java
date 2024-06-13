package hk.edu.polyu.comp.comp2021.simple.model;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CheckingTest {
    String debug1 = "debug1";
    HashSet<String> breakpoint1 = new HashSet<>();

    Instrument instrument = new Instrument();


    @Test
    void isNumeric() {
        boolean a = Checking.isNumeric(null);
    }

    @Test
    void isBoolean() {
        boolean b = Checking.isBoolean(" ");
    }

    @Test
    void debugStatement() {

    }

    @Test
    void listExpression() {
    }
}