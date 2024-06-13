package hk.edu.polyu.comp.comp2021.simple.model;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import java.lang.System;

import java.security.AccessControlException;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashSet;

import static hk.edu.polyu.comp.comp2021.simple.model.InputProcessing.quitChecking;
import static hk.edu.polyu.comp.comp2021.simple.model.InputProcessing.vardefChecking;
//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;



class varDefTest {


    //Define the input
    String vardefTest_String_1 = "vardef vardef1 int x 10";
    String vardefTest_String_2 = "vardef vardef2 bool y true";
    String vardefTest_String_3 = "vardef vardef3 int x 20";

    String vardefTest_String_4 = "vardef vardef4 boolean x true";

    String vardefTest_String_5 = "vardef vardef5 int 1 5";

    String vardefTest_String_6 = "vardef vardef6 int / 8";
    String vardefTest_String_7 = "vardef vardef7 int x 0";
    String vardefTest_String_8 = "vardef vardef8 int x true";




    //    private ArrayList<String> list = new ArrayList<>();
    Instrument instrument = new Instrument();
    HashSet<String> hashset = new HashSet<>();
    String str = "";

    @org.junit.jupiter.api.Test
    void execute() {
        setHashMap.getExpressionMap().clear();
        setHashMap.getVariableMap().clear();
        setHashMap.getProgramMap().clear();
        setHashMap.getStatementMap().clear();
        vardefChecking(vardefTest_String_1);
        vardefChecking(vardefTest_String_2);
        vardefChecking(vardefTest_String_3);
        vardefChecking(vardefTest_String_4);
        vardefChecking(vardefTest_String_5);
        vardefChecking(vardefTest_String_6);
        vardefChecking(vardefTest_String_7);
        vardefChecking(vardefTest_String_8);

        ((varDef) setHashMap.getStatementMap().get("vardef1")).execute(instrument);
        //((varDef) setHashMap.getStatementMap().get("vardef7")).execute(instrument);

        //((varDef) setHashMap.getStatementMap().get("vardef7")).execute(instrument);

        //assertExits

//        SystemLambda.catchSystemExit(()->{
//            ((varDef) setHashMap.getStatementMap().get("vardef7")).execute(instrument);
//        });


        // ((varDef) setHashMap.getStatementMap().get("vardef8")).execute(instrument);

        //setHashMap.getStatementMap().put(vardefTest_List_6[1], new varDef(vardefTest_String_6));
        ((varDef) setHashMap.getStatementMap().get("vardef1")).get_IntValue();
        ((varDef) setHashMap.getStatementMap().get("vardef2")).get_BoolValue();
        ((varDef) setHashMap.getStatementMap().get("vardef2")).get_VarName();
        ((varDef) setHashMap.getStatementMap().get("vardef2")).gettype();
        ((varDef) setHashMap.getStatementMap().get("vardef2")).debug(hashset, str , instrument);
    }


}