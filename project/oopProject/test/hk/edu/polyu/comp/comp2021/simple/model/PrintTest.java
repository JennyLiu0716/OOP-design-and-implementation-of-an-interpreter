package hk.edu.polyu.comp.comp2021.simple.model;



import org.junit.jupiter.api.Test;

import static hk.edu.polyu.comp.comp2021.simple.model.InputProcessing.quitChecking;
import static org.junit.jupiter.api.Assertions.*;

class PrintTest {

    String vardefTest_String_printTest = "vardef vardef1 int x 10";
    String[] vardefTest_List_printTest = vardefTest_String_printTest.split(" ");


    String printTest_String_Test = "print print1 x";
    String[] printTest_List_Test = printTest_String_Test.split(" ");

    String vardefTest_String_printTest2 = "binexpr binexpr1 3 + 4";
    String[] vardefTest_List_printTest2 = vardefTest_String_printTest2.split(" ");

    String printTest_String_Test2 = "print print2 binexpr2";
    String[] printTest_List_Test2 = printTest_String_Test2.split(" ");



    Instrument instrument = new Instrument();

    @Test
    void execute() {
        setHashMap.getExpressionMap().clear();
        setHashMap.getVariableMap().clear();
        setHashMap.getProgramMap().clear();
        setHashMap.getStatementMap().clear();

        //Test the Value of x is 10

        setHashMap.getStatementMap().put(vardefTest_List_printTest[1], new varDef(vardefTest_String_printTest));
        ((varDef) setHashMap.getStatementMap().get("vardef1")).execute(instrument);

        //print x: [10]
        setHashMap.getStatementMap().put(printTest_List_Test[1], new Print(printTest_String_Test));
        ((Print) setHashMap.getStatementMap().get("print1")).execute(instrument);

        InputProcessing.vardefChecking("vardef vardef2 bool y true");
        ((varDef) setHashMap.getStatementMap().get("vardef2")).execute(instrument);

        InputProcessing.printChecking("print print3 y");

        ((Print) setHashMap.getStatementMap().get("print3")).execute(instrument);



    }

}