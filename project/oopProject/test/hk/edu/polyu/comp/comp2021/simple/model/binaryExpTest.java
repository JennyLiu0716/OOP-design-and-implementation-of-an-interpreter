package hk.edu.polyu.comp.comp2021.simple.model;

import static hk.edu.polyu.comp.comp2021.simple.model.InputProcessing.quitChecking;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


class binaryExpTest {

    String vardefTest_String_BinaryExpTest = "vardef vardef1 int x 10";
    String[] vardefTest_List_BinaryExpTest = vardefTest_String_BinaryExpTest.split(" ");


    String binexprTest_String_1 = "binexpr exp1 x % 2";
    String[] binexprTest_List_1 = binexprTest_String_1.split(" ");

    String binexprTest_String_2 = "binexpr exp2 x + 2";
    String[] binexprTest_List_2 = binexprTest_String_2.split(" ");

    String binexprTest_String_3 = "binexpr exp3 12 - x";
    String[] binexprTest_List_3 = binexprTest_String_3.split(" ");

    String binexprTest_String_4 = "binexpr exp4 x * 3";
    String[] binexprTest_List_4 = binexprTest_String_4.split(" ");

    String binexprTest_String_5 = "binexpr exp5 x / 8";
    String[] binexprTest_List_5 = binexprTest_String_5.split(" ");

    String binexprTest_String_6 = "binexpr exp6 x > 8";
    String[] binexprTest_List_6 = binexprTest_String_6.split(" ");

    String binexprTest_String_7 = "binexpr exp7 x < 8";
    String[] binexprTest_List_7 = binexprTest_String_7.split(" ");

    String binexprTest_String_8 = "binexpr exp8 x <= 8";
    String[] binexprTest_List_8 = binexprTest_String_8.split(" ");

    String binexprTest_String_9 = "binexpr exp9 6 >= 4";
    String[] binexprTest_List_9 = binexprTest_String_9.split(" ");

    String binexprTest_String_10 = "binexpr exp10 x == 10";
    String[] binexprTest_List_10 = binexprTest_String_10.split(" ");

    String binexprTest_String_11 = "binexpr exp11 x != 10";
    String[] binexprTest_List_11 = binexprTest_String_11.split(" ");

    String binexprTest_String_12 = "binexpr exp12 true && false";
    String[] binexprTest_List_12 = binexprTest_String_12.split(" ");

    String binexprTest_String_13 = "binexpr exp13 true || false";
    String[] binexprTest_List_13 = binexprTest_String_13.split(" ");

    String binexprTest_String_14 = "binexpr exp14 true == true";
    String[] binexprTest_List_14 = binexprTest_String_14.split(" ");

    String binexprTest_String_15 = "binexpr exp15 true != false";
    String[] binexprTest_List_15 = binexprTest_String_15.split(" ");

    String binexprTest_String_16 = "binexpr exp15 true ] false";
    String[] binexprTest_List_16 = binexprTest_String_16.split(" ");

    Instrument instrument = new Instrument();

    @Test
    void execute() {
        setHashMap.getExpressionMap().clear();
        setHashMap.getVariableMap().clear();
        setHashMap.getProgramMap().clear();
        setHashMap.getStatementMap().clear();

        //Set x = 10
        setHashMap.getStatementMap().put(vardefTest_List_BinaryExpTest[1], new varDef(vardefTest_String_BinaryExpTest));
        ((varDef) setHashMap.getStatementMap().get("vardef1")).execute(instrument);

        //integer x = 10
        //Test % : x % 2 = 0
        setHashMap.getExpressionMap().put( binexprTest_List_1[1], new binaryExp(binexprTest_String_1));
        ((binaryExp) setHashMap.getExpressionMap().get("exp1")).execute();
        assertEquals(( (binaryExp) setHashMap.getExpressionMap().get("exp1")).getint_value(),(0));

        //Test + : x + 2 = 12
        setHashMap.getExpressionMap().put( binexprTest_List_2[1], new binaryExp(binexprTest_String_2));
        ((binaryExp) setHashMap.getExpressionMap().get("exp2")).execute();
        assertEquals(( (binaryExp) setHashMap.getExpressionMap().get("exp2")).getint_value(),(12));

        //Test - : 12 - x = 2
        setHashMap.getExpressionMap().put( binexprTest_List_3[1], new binaryExp(binexprTest_String_3));
        ((binaryExp) setHashMap.getExpressionMap().get("exp3")).execute();
        assertEquals(( (binaryExp) setHashMap.getExpressionMap().get("exp3")).getint_value(),(2));

        //Test * : x * 3 = 30
        setHashMap.getExpressionMap().put( binexprTest_List_4[1], new binaryExp(binexprTest_String_4));
        ((binaryExp) setHashMap.getExpressionMap().get("exp4")).execute();
        assertEquals(( (binaryExp) setHashMap.getExpressionMap().get("exp4")).getint_value(),(30));

        //Test / : x / 8 = 1
        setHashMap.getExpressionMap().put( binexprTest_List_5[1], new binaryExp(binexprTest_String_5));
        ((binaryExp) setHashMap.getExpressionMap().get("exp5")).execute();
        assertEquals(( (binaryExp) setHashMap.getExpressionMap().get("exp5")).getint_value(),(1));

        //Test > : x > 8 is true
        setHashMap.getExpressionMap().put( binexprTest_List_6[1], new binaryExp(binexprTest_String_6));
        ((binaryExp) setHashMap.getExpressionMap().get("exp6")).execute();
        assertTrue(( (binaryExp) setHashMap.getExpressionMap().get("exp6")).getbool_value());

        //Test < :x < 8 is false
        setHashMap.getExpressionMap().put( binexprTest_List_7[1], new binaryExp(binexprTest_String_7));
        ((binaryExp) setHashMap.getExpressionMap().get("exp7")).execute();
        assertFalse(( (binaryExp) setHashMap.getExpressionMap().get("exp7")).getbool_value());

        //Test <= : x <= 8 is false
        setHashMap.getExpressionMap().put( binexprTest_List_8[1], new binaryExp(binexprTest_String_8));
        ((binaryExp) setHashMap.getExpressionMap().get("exp8")).execute();
        assertFalse(( (binaryExp) setHashMap.getExpressionMap().get("exp8")).getbool_value());

        //Test >= : 6 >= 4 is true
        setHashMap.getExpressionMap().put( binexprTest_List_9[1], new binaryExp(binexprTest_String_9));
        ((binaryExp) setHashMap.getExpressionMap().get("exp9")).execute();
        assertTrue(( (binaryExp) setHashMap.getExpressionMap().get("exp9")).getbool_value());

        //Test == : x == 10 is true
        setHashMap.getExpressionMap().put( binexprTest_List_10[1], new binaryExp(binexprTest_String_10));
        ((binaryExp) setHashMap.getExpressionMap().get("exp10")).execute();
        assertTrue(( (binaryExp) setHashMap.getExpressionMap().get("exp10")).getbool_value());

        //Test != : x != 10 is false
        setHashMap.getExpressionMap().put( binexprTest_List_11[1], new binaryExp(binexprTest_String_11));
        ((binaryExp) setHashMap.getExpressionMap().get("exp11")).execute();
        assertFalse(( (binaryExp) setHashMap.getExpressionMap().get("exp11")).getbool_value());


        //Test bool && : true && false is false
        setHashMap.getExpressionMap().put( binexprTest_List_12[1], new binaryExp(binexprTest_String_12));
        ((binaryExp) setHashMap.getExpressionMap().get("exp12")).execute();
        assertFalse(( (binaryExp) setHashMap.getExpressionMap().get("exp12")).getbool_value());


        //Test bool || : true || false is true
        setHashMap.getExpressionMap().put( binexprTest_List_13[1], new binaryExp(binexprTest_String_13));
        ((binaryExp) setHashMap.getExpressionMap().get("exp13")).execute();
        assertTrue(( (binaryExp) setHashMap.getExpressionMap().get("exp13")).getbool_value());


        //Test bool == : true == true is true
        setHashMap.getExpressionMap().put( binexprTest_List_14[1], new binaryExp(binexprTest_String_14));
        ((binaryExp) setHashMap.getExpressionMap().get("exp14")).execute();
        assertTrue(( (binaryExp) setHashMap.getExpressionMap().get("exp14")).getbool_value());

        //Test bool != : true != false is true
        setHashMap.getExpressionMap().put( binexprTest_List_15[1], new binaryExp(binexprTest_String_15));
        ((binaryExp) setHashMap.getExpressionMap().get("exp15")).execute();
        assertTrue(( (binaryExp) setHashMap.getExpressionMap().get("exp15")).getbool_value());

        //Wrong Input: using symbol which cannot be calculated
        setHashMap.getExpressionMap().put( binexprTest_List_16[1], new binaryExp(binexprTest_String_16));


    }


}