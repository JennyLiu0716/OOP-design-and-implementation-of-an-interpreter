package hk.edu.polyu.comp.comp2021.simple.model;

import static hk.edu.polyu.comp.comp2021.simple.model.InputProcessing.quitChecking;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class BlockTest {

    String vardefTest_String_BlockTest = "vardef vardef1 int x 0";
    String[] vardefTest_List_BlockTest = vardefTest_String_BlockTest.split(" ");

    String binexprTest_String_BlockTest1 = "binexpr exp1 x % 2";
    String[] binexprTest_List_BlockTest1 = binexprTest_String_BlockTest1.split(" ");

    String binexprTest_String_BlockTest2 = "binexpr exp2 exp1 == 0";
    String[] binexprTest_List_BlockTest2 = binexprTest_String_BlockTest2.split(" ");

    String printTest_String_BlockTest = "print print1 x";
    String[] printTest_List_BlockTest = printTest_String_BlockTest.split(" ");

    String skipTest_String_BlockTest = "skip skip1";
    String[] skipTest_List_BlockTest = skipTest_String_BlockTest.split(" ");

    String ifelseTest_String_BlockTest = "if if1 exp2 print1 skip1";
    String[] ifelseTest_List_BlockTest = ifelseTest_String_BlockTest.split(" ");

    String binexprTest_String_BlockTest3 = "binexpr exp3 x + 1";
    String[] binexprTest_List_BlockTest3 = binexprTest_String_BlockTest3.split(" ");

    String assignTest_String_BlockTest = "assign assign1 x exp3";
    String[] assignTest_List_BlockTest = assignTest_String_BlockTest.split(" ");

    String blockTest_String_BlockTest = "block block1 if1 assign1";
    String[] blockTest_List_BlockTest = blockTest_String_BlockTest.split(" ");

    String blockTest_String_BlockTest2 = "block block2 if1 assign1 vardef6";
    String[] blockTest_List_BlockTest2 = blockTest_String_BlockTest2.split(" ");

    Instrument instrument = new Instrument();

    @Test
    void execute() {
        setHashMap.getExpressionMap().clear();
        setHashMap.getVariableMap().clear();
        setHashMap.getProgramMap().clear();
        setHashMap.getStatementMap().clear();

        //set x = 0
        setHashMap.getStatementMap().put(vardefTest_List_BlockTest[1], new varDef(vardefTest_String_BlockTest));
        ((varDef) setHashMap.getStatementMap().get("vardef1")).execute(instrument);

        // exp1 x % 2 = 2
        setHashMap.getExpressionMap().put(binexprTest_List_BlockTest1[1], new binaryExp(binexprTest_String_BlockTest1));
        ((binaryExp) setHashMap.getExpressionMap().get("exp1")).execute();

        //exp2 exp1 == 0
        setHashMap.getExpressionMap().put(binexprTest_List_BlockTest2[1], new binaryExp(binexprTest_String_BlockTest2));
        ((binaryExp) setHashMap.getExpressionMap().get("exp2")).execute();

        //print
        setHashMap.getStatementMap().put(printTest_List_BlockTest[1], new Print(printTest_String_BlockTest));
        //((Print) setHashMap.getStatementMap().get("print1")).execute();

        //skip
        setHashMap.getStatementMap().put(skipTest_List_BlockTest[1], new Skip(skipTest_String_BlockTest));
        ((Skip) setHashMap.getStatementMap().get("skip1")).execute(instrument);

        //if
        setHashMap.getStatementMap().put(ifelseTest_List_BlockTest[1], new IfElse(ifelseTest_String_BlockTest));
        //((IfElse) setHashMap.getStatementMap().get("if1")).execute();

        //exp3 x + 1
        setHashMap.getExpressionMap().put(binexprTest_List_BlockTest3[1], new binaryExp(binexprTest_String_BlockTest3));
        ((binaryExp) setHashMap.getExpressionMap().get("exp3")).execute();

        //assign
        setHashMap.getStatementMap().put(assignTest_List_BlockTest[1], new Assign(assignTest_String_BlockTest));
        ((Assign) setHashMap.getStatementMap().get("assign1")).execute(instrument);

        //block : the input is saved in the block 1, the execution will be tested in other function
        setHashMap.getStatementMap().put(blockTest_List_BlockTest[1], new Block(blockTest_String_BlockTest));
        ((Block) setHashMap.getStatementMap().get("block1")).execute(instrument);
        //assertEquals((( (Block) setHashMap.getStatementMap().get("block1")).getInputString()),("block block1 if1 assign1"));

        setHashMap.getStatementMap().put(blockTest_List_BlockTest2[1], new Block(blockTest_String_BlockTest2));
        //((Block) setHashMap.getStatementMap().get("block2")).execute(instrument);

    }
}