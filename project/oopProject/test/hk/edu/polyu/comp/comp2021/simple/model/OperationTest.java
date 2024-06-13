package hk.edu.polyu.comp.comp2021.simple.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {
    Operation testOP = new Operation("exp1");
    Operation testOP1 = new Operation(Typ.BOOL);
    ArrayList<String> a = new ArrayList<>();
    @Test
    void execute() {
        testOP.execute();
        testOP.execute(new Instrument());
        testOP.printlist(a);
        testOP.debug(new HashSet<>()," ",new Instrument());
    }

    @Test
    void printlist() {
    }
}