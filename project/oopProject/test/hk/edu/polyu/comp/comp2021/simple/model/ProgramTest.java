package hk.edu.polyu.comp.comp2021.simple.model;

import org.junit.jupiter.api.Test;

import static hk.edu.polyu.comp.comp2021.simple.model.InputProcessing.*;
import static hk.edu.polyu.comp.comp2021.simple.model.InputProcessing.instrumentChecking;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    //vardef vardef int x 0
    //binexpr exp1 x % 2
    //binexpr exp2 exp1 == 0
    //print print1 x
    //skip skip1
    //if if1 exp2 print1 skip1
    //binexpr exp3 x + 1
    //assign assign1 x exp3
    //block block1 if1 assign1
    //binexpr exp4 x <= 10
    //while while1 exp4 block1
    //block block2 vardef1 while1
    //program printeven block2
    //execute printeven


    //block block2 vardef1 exp5 while1

    //program printeven block2
    //execute printeven

    //unary printlist
    String unaryTest_String_ProgramTest = "unexpr exp5 ~ x";


    String Program_String_Test1 = "program program1 exp5";


    //Program Execute

    //store program1 d:\prog1.simple
    //Example: load d:\prog1.simple program1


    String Store_String_Test = "store printeven c:\\prog1.simple";


    //debug togglebreakpoint inspect and instrument
    String togglebreakpoint_String_Test1 = "togglebreakpoint printeven if1";

    String debug_String_Test1 = "debug printeven";

    String inspect_String_Test1 = "inspect printeven x";

    String debug_String_Test2 = "debug printeven";

    String togglebreakpoint_String_Test2 = "togglebreakpoint printeven if1";

    String debug_String_Test3 = "debug printeven";
    String Store_String_Test1 = "store printeven d:\\prog5.simple";
    String load_String_Test1 = "load d:\\prog3.simple printeven";
    String load_String_Test2 = "load d:\\prog5.simple printeven";


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
        vardefChecking("vardef vardef3 bool t true");
        vardefChecking("vardef vardef2 bool z false");
        binexprChecking("binexpr exp1 x % 2");
        binexprChecking("binexpr exp2 exp1 == 0");
        unexprChecking("unexpr exp5 ! true");
        printChecking("print print1 x");
        printChecking("print print5 exp5");
        skipChecking("skip skip1");
        ifChecking("if if1 exp2 print1 skip1");
        binexprChecking("binexpr exp3 x + 1");
        assignChecking("assign assign1 x exp3");
        assignChecking("assign assign2 z t");
        blockChecking("block block1 if1 assign1 print5");
        binexprChecking("binexpr exp4 x <= 10");
        whileChecking("while while1 exp4 block1");
        blockChecking("block block2 vardef1 while1 vardef3 vardef2 assign2");
        programChecking("program printeven block2");
        instrumentChecking("instrument printeven block1 before 5");
        instrumentChecking("instrument printeven block1 before true");
        instrumentChecking("instrument printeven block1 after 5");
        instrumentChecking("instrument printeven block1 after true");
        instrumentChecking("instrument printeven block1 lala true");

        executeChecking("execute printeven");

        listChecking("list printeven");

        debugChecking(debug_String_Test1);
        togglebreakpointChecking(togglebreakpoint_String_Test1);

        togglebreakpointChecking(togglebreakpoint_String_Test1);
        storeChecking(Store_String_Test1);
        storeChecking("store printeven j:\\simple.simple");
        loadChecking(load_String_Test1);
        loadChecking(load_String_Test2);









        /*
        setHashMap.getProgramMap().put(Program_List_Test1[1], new Program(Program_String_Test1));
        ((Program) setHashMap.getProgramMap().get("program1")).execute();
        setHashMap.getExpressionMap().put(unaryTest_List_ProgramTest[1], new unaryExp(unaryTest_String_ProgramTest));
        ((unaryExp) setHashMap.getExpressionMap().get("exp5")).execute();
        ((Program) setHashMap.getProgramMap().get(unaryTest_List_ProgramTest[1])).printList();
*/

        //debug

//
//        ((Program) setHashMap.getProgramMap().get(togglebreakpoint_List_Test1[1])).setbreakpoint(togglebreakpoint_List_Test1[2]);
//        ;


//        ((Program) setHashMap.getProgramMap().get(debug_List_Test2[1])).debug();
//
//        ((Program) setHashMap.getProgramMap().get(togglebreakpoint_List_Test2[1])).setbreakpoint(togglebreakpoint_List_Test2[2]);
//        ;

//        ((Program) setHashMap.getProgramMap().get(debug_List_Test3[1])).debug();



//        ((Program) setHashMap.getProgramMap().get("printeven")).debug();
//        ((Program) setHashMap.getProgramMap().get("printeven")).debug();






    }


}

