package hk.edu.polyu.comp.comp2021.simple.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnaryOperatorTest {

    @Test
    void calculateBool() {
        //calculateBool();
        Operation op = new Operation(false);
        UnaryOperator.MINUS.calculateBool(op);
    }

    @Test
    void testToString() {
        UnaryOperator.MINUS.toString();
    }

    @Test
    void fromString() {
        UnaryOperator.fromString("+");
        //fromString();
    }
}