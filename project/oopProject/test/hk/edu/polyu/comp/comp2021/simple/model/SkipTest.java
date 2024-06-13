package hk.edu.polyu.comp.comp2021.simple.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static hk.edu.polyu.comp.comp2021.simple.model.InputProcessing.quitChecking;
import static org.junit.jupiter.api.Assertions.*;

class SkipTest {

    String skipTest_String_Test = "skip skip1";
    String[] skipTest_List_Test = skipTest_String_Test.split(" ");

    String vardefTest_String_SkipTest = "vardef vardef1 int x 10";
    String[] vardefTest_List_SkipTest = vardefTest_String_SkipTest.split(" ");

    Instrument instrument = new Instrument();
    HashSet<String> hashset = new HashSet<>();
    String str = "";

    @Test
    void execute() {
        setHashMap.getExpressionMap().clear();
        setHashMap.getVariableMap().clear();
        setHashMap.getProgramMap().clear();
        setHashMap.getStatementMap().clear();

        //skip: continue to execute the next command
        setHashMap.getStatementMap().put(skipTest_List_Test[1], new Skip(skipTest_String_Test));
        ((Skip) setHashMap.getStatementMap().get("skip1")).execute(instrument);

        setHashMap.getStatementMap().put(vardefTest_List_SkipTest[1], new varDef(vardefTest_String_SkipTest));
        ((varDef) setHashMap.getStatementMap().get("vardef1")).execute(instrument);

        ((Skip) setHashMap.getStatementMap().get("skip1")).debug(hashset, str , instrument);
    }
}