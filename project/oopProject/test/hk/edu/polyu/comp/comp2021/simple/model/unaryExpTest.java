package hk.edu.polyu.comp.comp2021.simple.model;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static hk.edu.polyu.comp.comp2021.simple.model.InputProcessing.quitChecking;
import static org.junit.jupiter.api.Assertions.*;

class unaryExpTest {

    String vardefTest_String_unaryExpTest = "vardef vardef1 int x 10";

    // ~ x is equal to negative x, for example, x = 10, ~ x = -10
    String unaryTest_String1 = "unexpr exp1 ~ x";


    String unaryTest_String2 = "unexpr exp2 # 10";



    String unaryTest_String3 = "unexpr exp3 ! true";


    Instrument instrument = new Instrument();


    @Test
    void execute() {
        setHashMap.getExpressionMap().clear();
        setHashMap.getVariableMap().clear();
        setHashMap.getProgramMap().clear();
        setHashMap.getStatementMap().clear();
        // x is an integer 10
        InputProcessing.vardefChecking(vardefTest_String_unaryExpTest);

        // ~x : -10
        InputProcessing.unexprChecking(unaryTest_String1);
        //((UnaryOperator) setHashMap.getExpressionMap().get("exp2")).execute(instrument);


        // # x:
        InputProcessing.unexprChecking(unaryTest_String2);

        // ! true is false
        InputProcessing.unexprChecking(unaryTest_String3);

        ArrayList<String> list_Una = new ArrayList<>();

        ((unaryExp) setHashMap.getExpressionMap().get("exp2")).execute();
        ((unaryExp) setHashMap.getExpressionMap().get("exp3")).execute();
        ((unaryExp) setHashMap.getExpressionMap().get("exp3")).printlist(list_Una);



    }
}