package hk.edu.polyu.comp.comp2021.simple.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputProcessingTest {

    @Test
    void vardefChecking() {
        InputProcessing.vardefChecking("vardef vardef1 int x 10 20");
        InputProcessing.vardefChecking("vardef vardefsfsdfsdfs int x 10");
        InputProcessing.vardefChecking("vardef vardef1 bool x 1");
        InputProcessing.vardefChecking("vardef vardef1 int x 10");
        InputProcessing.vardefChecking("vardef vardef1 int x 10");

    }

    @Test
    void binexprChecking() {
        InputProcessing.binexprChecking("binexpr binexpr1 x 10");
        InputProcessing.binexprChecking("binexpr safsdfdsfs x + 4");
        InputProcessing.binexprChecking("binexpr binexpr1 x { 2");
        InputProcessing.binexprChecking("binexpr binexpr1 1 && true");
        InputProcessing.binexprChecking("binexpr binexpr1 true && false");
        InputProcessing.binexprChecking("binexpr binexpr1 true && false");
        InputProcessing.binexprChecking("binexpr binexpr2 true + false");
        InputProcessing.binexprChecking("binexpr binexpr2 1 + 3");
        InputProcessing.binexprChecking("binexpr binexpr2 1 + 3");
        InputProcessing.binexprChecking("binexpr binexpr3 1 + 3");
        InputProcessing.binexprChecking("binexpr binexpr3 1 + 3");
        InputProcessing.binexprChecking("binexpr binexpr3 1 || true");



    }

    @Test
    void unexprChecking() {
        InputProcessing.unexprChecking("unexpr binexpr3 1 || true");
        InputProcessing.unexprChecking("unexpr unexpr ! true");
        InputProcessing.unexprChecking("unexpr unexpr @ true");
        InputProcessing.unexprChecking("unexpr unexpr ! 23");
        InputProcessing.unexprChecking("unexpr unexpr - true");
        InputProcessing.unexprChecking("unexpr unexpr ! true");
        InputProcessing.unexprChecking("unexpr unexpr ! true");
    }

    @Test
    void assignChecking() {
        InputProcessing.assignChecking("assign");
        InputProcessing.assignChecking("assign sasdgshagdhs x y");
        InputProcessing.assignChecking("assign assign1 2 s");
        InputProcessing.assignChecking("assign assign1 x y");
        InputProcessing.assignChecking("assign assign1 x dfsffffffffffffdfss");
        InputProcessing.assignChecking("assign assign1 x y");


    }

    @Test
    void printChecking() {
        InputProcessing.printChecking("print print1");
        InputProcessing.printChecking("print printdsdfsds1 1");
        InputProcessing.printChecking("print print1 dskjfsdkfsdkjfdsks");
        InputProcessing.printChecking("print print1 1");
        InputProcessing.printChecking("print print1 1");
    }

    @Test
    void skipChecking() {
        InputProcessing.skipChecking("skip ");
        InputProcessing.skipChecking("skip dsajhdagsjghaghd");
        InputProcessing.skipChecking("skip skip1");
        InputProcessing.skipChecking("skip skip1");


    }

    @Test
    void blockChecking() {
    }

    @Test
    void ifChecking() {
        InputProcessing.ifChecking("if");
        InputProcessing.ifChecking("if sdadsdsdsdssdsa block1 block2 block3");
        InputProcessing.ifChecking("if if1 block1 dasdddddddddddddddd block3");
        InputProcessing.ifChecking("if if1 block1 block2 sadddddddddddddddddddddddd");
        InputProcessing.ifChecking("if if1 sdaaaaaaaaa block2 block3");
        InputProcessing.ifChecking("if if1 block1 block2 block3");
        InputProcessing.ifChecking("if if1 block1 block2 block3");


    }

    @Test
    void whileChecking() {
        InputProcessing.whileChecking("while");
    }

    @Test
    void programChecking() {
    }

    @Test
    void executeChecking() {
        InputProcessing.executeChecking("execute");
        InputProcessing.executeChecking("execute sdsad");
    }

    @Test
    void listChecking() {
        InputProcessing.listChecking("list");
        InputProcessing.listChecking("list sdads");

    }

    @Test
    void storeChecking() {
        InputProcessing.storeChecking("store");
        InputProcessing.storeChecking("store store1 sdsa");
    }

    @Test
    void loadChecking() {
        InputProcessing.loadChecking("load");

    }

    @Test
    void quitChecking() {
        InputProcessing.quitChecking("quit s");

    }

    @Test
    void togglebreakpointChecking() {
        InputProcessing.togglebreakpointChecking("togglebreakpoint");
        InputProcessing.togglebreakpointChecking("togglebreakpoint program1 if1");

    }

    @Test
    void debugChecking() {
        InputProcessing.debugChecking("debug");
        InputProcessing.debugChecking("debug program1");
    }

    @Test
    void instrumentChecking() {
        InputProcessing.instrumentChecking("instrument");
        InputProcessing.instrumentChecking("instrument block1 program1 before 5");
    }
}