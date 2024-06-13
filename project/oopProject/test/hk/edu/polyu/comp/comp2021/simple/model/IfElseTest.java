package hk.edu.polyu.comp.comp2021.simple.model;


import org.junit.jupiter.api.Test;

import static hk.edu.polyu.comp.comp2021.simple.model.InputProcessing.quitChecking;
import static org.junit.jupiter.api.Assertions.*;

class IfElseTest {


    String vardefTest_String_IfElseTest = "vardef vardef1 int x 10";
    String[] vardefTest_List_IfElseTest = vardefTest_String_IfElseTest.split(" ");

    String binexprTest_String_IfElseTest1 = "binexpr exp1 x * 2";
    String[] binexprTest_List_IfElseTest1 = binexprTest_String_IfElseTest1.split(" ");

    String unaryTest_String_IfElseTest2 = "unexpr exp2 ~ exp1";
    String[] unaryTest_List_IfElseTest2 = unaryTest_String_IfElseTest2.split(" ");

    String assignTest_String_IfElseTest = "assign assign1 x exp2";
    String[] assignTest_List_IfElseTest = assignTest_String_IfElseTest.split(" ");

    String printTest_String_IfElseTest = "print print1 exp2";
    String[] printTest_List_IfElseTest = printTest_String_IfElseTest.split(" ");

    String skipTest_String_IfElseTest = "skip skip1";
    String[] skipTest_List_IfElseTest = skipTest_String_IfElseTest.split(" ");

    String blockTest_String_IfElseTest = "block block1 assign1 skip1";
    String[] blockTest_List_IfElseTest = blockTest_String_IfElseTest.split(" ");


    String vardefTest_String_IfElseTest2 = "vardef vardef2 bool y false";
    String[] vardefTest_List_IfElseTest2 = vardefTest_String_IfElseTest2.split(" ");

    String ifelseTest_String_Test = "if if1 y block1 print1";
    String[] ifelseTest_List_Test = ifelseTest_String_Test.split(" ");

    Instrument instrument = new Instrument();

    @Test
    void execute() {
        setHashMap.getExpressionMap().clear();
        setHashMap.getVariableMap().clear();
        setHashMap.getProgramMap().clear();
        setHashMap.getStatementMap().clear();


        //set x = 10
        setHashMap.getStatementMap().put(vardefTest_List_IfElseTest[1], new varDef(vardefTest_String_IfElseTest));
        ((varDef) setHashMap.getStatementMap().get("vardef1")).execute(instrument);

        // exp1 x * 2 = 20
        setHashMap.getExpressionMap().put(binexprTest_List_IfElseTest1[1], new binaryExp(binexprTest_String_IfElseTest1));
        ((binaryExp) setHashMap.getExpressionMap().get("exp1")).execute();

        //exp2 ~ exp1 to -20
        setHashMap.getExpressionMap().put(unaryTest_List_IfElseTest2[1], new unaryExp(unaryTest_String_IfElseTest2));
        ((unaryExp) setHashMap.getExpressionMap().get("exp2")).execute();


        //assign x = -20
        setHashMap.getStatementMap().put(assignTest_List_IfElseTest[1], new Assign(assignTest_String_IfElseTest));
        //((Assign) setHashMap.getStatementMap().get("assign1")).execute();

        //saved print
        setHashMap.getStatementMap().put(printTest_List_IfElseTest[1], new Print(printTest_String_IfElseTest));
        //((Print) setHashMap.getStatementMap().get("print1")).execute();

        //skip
        setHashMap.getStatementMap().put(skipTest_List_IfElseTest[1], new Skip(skipTest_String_IfElseTest));
        //((Skip) setHashMap.getStatementMap().get("skip1")).execute();

        //block1 assign1 skip1
        setHashMap.getStatementMap().put(blockTest_List_IfElseTest[1], new Block(blockTest_String_IfElseTest));
        //((Block) setHashMap.getStatementMap().get("block1")).execute();

        //define boolean y = false
        setHashMap.getStatementMap().put(vardefTest_List_IfElseTest2[1], new varDef(vardefTest_String_IfElseTest2));
        ((varDef) setHashMap.getStatementMap().get("vardef2")).execute(instrument);

        //Test IfElse
        // the condition is false since y == false, so the print1 will be executed
        //and get [-20]
        setHashMap.getStatementMap().put(ifelseTest_List_Test[1], new IfElse(ifelseTest_String_Test));
        ((IfElse) setHashMap.getStatementMap().get("if1")).execute(instrument);

        //Other Function Check
        Operation IE = new Operation(1);
//        ((IfElse) setHashMap.getStatementMap().get("if1")).setCondition(IE);
//        ((IfElse) setHashMap.getStatementMap().get("if1")).settrue(IE);
//        ((IfElse) setHashMap.getStatementMap().get("if1")).setfalse(IE);
//        ((IfElse) setHashMap.getStatementMap().get("if1")).getCondition();
//        ((IfElse) setHashMap.getStatementMap().get("if1")).gettrue();
//        ((IfElse) setHashMap.getStatementMap().get("if1")).getfalse();

    }
}