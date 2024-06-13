package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * this class is a class for minor checking (numeric, boolean, resultChecking)
 * also, some bridge function to connect the whole project
 * also, some type change, such as String name of operation -> corresponding Operation
 */
public class Checking {

    /**
     * the calculation result should not be smaller than -99999, so we define the constant
     */
    public static final int INTHIGH = 99999;
    /**
     * the calculation result should not be larger than 99999, so we define the constant
     */
    public static final int INTLOW = -99999;

    /**
     * @param strNum the expression string
     * @return check whether it is numeric, if yes, return true
     */
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
            if (d< INTLOW||d> INTHIGH){
                return false;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * @param strbool the expression string
     * @return check whether it is bool, if yes, return true
     */
    public static boolean isBoolean(String strbool) {
        return strbool.equals("true") || strbool.equals("false");
    }

    /**
     * @param result number in process
     * @return whether it is valid
     */
    public static int resultChecking(int result){
        if (result < INTLOW) result = INTLOW;
        if (result > INTHIGH) result = INTHIGH;
        return result;
    }

    /**
     * @param expName expression string of the expression reference
     * @return check whether it is a expression or variable or number or boolean, then return an Operation correspond to the value
     */
    public static Operation getvalue(String expName) {
        Operation exp = null;
        if (setHashMap.getExpressionMap().containsKey(expName)) {
            if (((Operation) setHashMap.getExpressionMap().get(expName)).getLabel().equals("binexpr")) {
                ((binaryExp) setHashMap.getExpressionMap().get(expName)).execute();
            }
            else {
                ((unaryExp) setHashMap.getExpressionMap().get(expName)).execute();
            }
            exp = (Operation) setHashMap.getExpressionMap().get(expName);
        }else if (setHashMap.getVariableMap().containsKey(expName)) {
            if (((Variable<?>) setHashMap.getVariableMap().get(expName)).getvalue() instanceof Integer) {
                exp = new Operation(((Variable<Integer>) setHashMap.getVariableMap().get(expName)).getvalue());
                exp.set_type(Typ.INT);
            }else  {
                exp = new Operation(((Variable<Boolean>) setHashMap.getVariableMap().get(expName)).getvalue());
                exp.set_type(Typ.BOOL);
            }
        }else if (Checking.isNumeric(expName)) {
            exp = new Operation(Integer.parseInt(expName));
        }else if (Checking.isBoolean(expName)) {
            exp = new Operation(Boolean.parseBoolean(expName));
        }else {
            System.out.println("This expression is invalid:"+expName);
            System.exit(0);
        }
        return exp;
    }

    /**
     * @param name the statement to be executed
     * @param instrument the instrument corresponding to a certain program
     */
    public static void executeStatement(String name,Instrument instrument) {
        try{
            setHashMap.getStatementMap().get(name);
        }catch (NullPointerException e){
            System.out.println("This statement is not defined:"+name);
            System.exit(0);
        }
        switch (((Operation) setHashMap.getStatementMap().get(name)).getLabel()) {
            case "vardef" -> ((varDef) setHashMap.getStatementMap().get(name)).execute(instrument);
            case "assign" -> ((Assign) setHashMap.getStatementMap().get(name)).execute(instrument);
            case "print" -> ((Print) setHashMap.getStatementMap().get(name)).execute(instrument);
            case "skip" -> ((Skip) setHashMap.getStatementMap().get(name)).execute(instrument);
            case "block" -> ((Block) setHashMap.getStatementMap().get(name)).execute(instrument);
            case "if" -> ((IfElse) setHashMap.getStatementMap().get(name)).execute(instrument);
            case "while" -> ((While) setHashMap.getStatementMap().get(name)).execute(instrument);
        }
    }

    /**
     * @param name statement name , which need to be debugged next
     * @param set hashset containing togglebreakpoint
     * @param program program name
     * @param instrument instrument class for instrument storage
     */
    public static void debugStatement(String name, HashSet<String> set,String program,Instrument instrument) {
//		System.out.println(((Operation) setHashMap.getStatementMap().get(name)).getLabel());
        if (set.contains(name)){

//            while(!inputlist[0].equals("debug")){
            boolean repeat = true;
            while(repeat){
                System.out.print('>');
                Scanner scanner = new Scanner(System.in);
                String com= scanner.nextLine();
                String[] inputlist = com.split(" ");
                switch (inputlist[0]){
                    case "togglebreakpoint" -> InputProcessing.togglebreakpointChecking(com);
                    case "inspect" -> {
                        if (inputlist.length != 3) {
                            System.out.println("Invalid command:" + com);
                        } else if (!inputlist[1].equals(program)){
                            System.out.println("Error: "+com);
                            System.out.println("Not current debugging program: "+inputlist[1]);
                        } else if (setHashMap.getVariableMap().containsKey(inputlist[2])) {
                            if (((Variable<?>) setHashMap.getVariableMap().get(inputlist[2])).getvalue() instanceof Integer) {
                                System.out.println("<"+((Variable<Integer>) setHashMap.getVariableMap().get(inputlist[2])).getvalue()+">");
                            }else{
                                System.out.println("<"+((Variable<Boolean>) setHashMap.getVariableMap().get(inputlist[2])).getvalue()+">");
                            }
                        }else {
                            System.out.println("Error: "+com);
                            System.out.println("Variable hasn't defined:"+inputlist[2]);
                        }
                    }case "debug" ->{
                        if (inputlist.length != 2) {
                            System.out.println("Invalid command:" + com);
                        } else if (!inputlist[1].equals(program)){
                            System.out.println("Error: "+com);
                            System.out.println("Not current debugging program: "+inputlist[1]);
                        } else {
                            repeat = false;
                        }
                    }
                }
            }
        }
        try{
            setHashMap.getStatementMap().get(name);
        }catch (NullPointerException e){
            System.out.println("This statement is not defined:"+name);
            System.exit(0);
        }
        switch (((Operation) setHashMap.getStatementMap().get(name)).getLabel()) {
            case "vardef" -> ((varDef) setHashMap.getStatementMap().get(name)).debug(set, program, instrument);
            case "assign" -> ((Assign) setHashMap.getStatementMap().get(name)).debug(set, program, instrument);
            case "print" -> ((Print) setHashMap.getStatementMap().get(name)).debug(set, program, instrument);
            case "skip" -> ((Skip) setHashMap.getStatementMap().get(name)).debug(set, program, instrument);
            case "block" -> ((Block) setHashMap.getStatementMap().get(name)).debug(set, program, instrument);
            case "if" -> ((IfElse) setHashMap.getStatementMap().get(name)).debug(set, program, instrument);
            case "while" -> ((While) setHashMap.getStatementMap().get(name)).debug(set, program, instrument);
        }
    }

    /**
     * @param list the list to store all the commands
     * @param expName the expression name whose expression to be stored in the list
     */
    public static void listExpression(ArrayList<String> list,String expName) {
        if (setHashMap.getExpressionMap().containsKey(expName)) {
            if (((Operation) setHashMap.getExpressionMap().get(expName)).getLabel().equals("binexpr")) {
                ((binaryExp) setHashMap.getExpressionMap().get(expName)).printlist(list);
            }
            else ((unaryExp) setHashMap.getExpressionMap().get(expName)).printlist(list);
        }
        //don't need don't print

    }

    /**
     * @param list the list to store all the commands
     * @param sName the statement name whose expression to be stored in the list
     */
    public static void listStatement(ArrayList<String> list,String sName) {
        if (setHashMap.getStatementMap().containsKey(sName)){
            switch (((Operation) setHashMap.getStatementMap().get(sName)).getLabel()) {
                case "vardef" -> ((varDef) setHashMap.getStatementMap().get(sName)).printlist(list);
                case "assign" -> ((Assign) setHashMap.getStatementMap().get(sName)).printlist(list);
                case "print" -> ((Print) setHashMap.getStatementMap().get(sName)).printlist(list);
                case "skip" -> ((Skip) setHashMap.getStatementMap().get(sName)).printlist(list);
                case "block" -> ((Block) setHashMap.getStatementMap().get(sName)).printlist(list);
                case "if" -> ((IfElse) setHashMap.getStatementMap().get(sName)).printlist(list);
                case "while" -> ((While) setHashMap.getStatementMap().get(sName)).printlist(list);
            }
        }//don't need don't print
    }
    private static final ArrayList<String> name = new ArrayList<>(
            Arrays.asList("int", "bool", "true", "false", "vardef", "binexpr",
                    "unexpr", "assign", "print", "skip", "block", "if", "while", "program", "execute",
                    "list", "store", "load", "quit", "debug", "togglebreakpoint", "inspect", "instrument"));

    /**
     * @param s string of name
     * @return whether the name is valid
     */
    public static boolean NameChecking(String s){
        if (s.length()>8) return false;
        if (!((s.charAt(0)>='a'&&s.charAt(0)<='z')||(s.charAt(0)>='A'&&s.charAt(0)<='Z'))) return false;
        for(int i=1;i<s.length();i++){
            if (!((s.charAt(0)>='a'&&s.charAt(0)<='z')||(s.charAt(0)>='A'&&s.charAt(0)<='Z')||(s.charAt(i)>='0'&&s.charAt(i)<='9'))) return false;
        }
        return !name.contains(s);
    }

}

