package hk.edu.polyu.comp.comp2021.simple.model;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static hk.edu.polyu.comp.comp2021.simple.model.InputProcessing.*;
import static org.junit.jupiter.api.Assertions.*;

class AssignTest {

    Instrument instrument = new Instrument();
    HashSet<String> hashset = new HashSet<>();
    String str = "";


    @Test
    void execute() {
        setHashMap.getExpressionMap().clear();
        setHashMap.getVariableMap().clear();
        setHashMap.getProgramMap().clear();
        setHashMap.getStatementMap().clear();

        vardefChecking("vardef vardef1 int x 10");

        assignChecking("assign assign1 x 1000");
        vardefChecking("vardef vardef2 bool y false");

        assignChecking("assign assign2 y true");
        //assignChecking(AssignTest_String3);
        assignChecking("assign assign4 y 49");



    }
//    @Test
//    void getexpName() {
//    }
//
//    @Test
//    void setexp() {
//    }
//
//    @Test
//    void execute() {
//    }
//
//    @Test
//    void debug() {
//    }
//
//    @Test
//    void printlist() {
//    }

}