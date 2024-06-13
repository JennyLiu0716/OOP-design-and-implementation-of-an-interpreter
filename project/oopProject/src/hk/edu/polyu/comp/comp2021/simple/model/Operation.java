package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.ArrayList;
import java.util.HashSet;


/**
 * a superclass for inheritance
 */
//
public class Operation {

    private int int_value;
    private String label;
    private boolean bool_value;
    private String inputString;
    private Typ type;
    private String[] input;

    /**
     * @param input_ user command input
     */
    public Operation (String input_){
        this.inputString = input_;
        input = input_.split(" ");
        this.label = input[0];
    }

    /**
     * @return the statement lab
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * @param type constructor for Typ type parameter
     */
    public Operation (Typ type) {
        this.type = type;
    }

    /**
     * @param a constructor for int type parameter
     */
    public Operation (int a) {
        this.set_intValue(a);
        this.set_type(Typ.INT);
    }

    /**
     * @param b constructor for boolean type parameter
     */
    public Operation (boolean b) {
        this.set_boolValue(b);
        this.set_type(Typ.BOOL);
    }

    /**
     * @return user input
     */
    public String[] getinput() {
        return this.input;
    }

    /**
     * @return the type bool or int
     */
    public Typ gettype() {
        return this.type;
    }

    /**
     * @param type Typ type to set the type
     */
    public void set_type(Typ type) {
        this.type = type;
    }

    /**
     * the function to be overrided
     */
    public void execute() {}

    /**
     * @return int value of the expression
     */
    public int getint_value(){
        return int_value;
    }

    /**
     * @return bool value of the expression
     */
    public boolean getbool_value() {
        return bool_value;
    }

    /**
     * @param a int value, set int value to the expression
     */
    public void set_intValue(int a) {
        this.int_value = a;
    }

    /**
     * @param b bool value, set bool value to the expression
     */
    public void set_boolValue(boolean b) {
        this.bool_value = b;
    }

    /**
     * @return user input string
     */
    public String getInputString() {
        return this.inputString;
    }

    /**
     * @param list the list to store the command
     */
public void printlist(ArrayList<String> list) {
    }

    /**
     * @param instrument the instrument object to store information
     */
public void execute(Instrument instrument){}

    /**
     * @param set hashset containing togglebreakpoint
     * @param program program string name
     * @param instrument instrument object to store information
     */
    public void debug(HashSet<String> set, String program, Instrument instrument){
        execute(instrument);
    }

}