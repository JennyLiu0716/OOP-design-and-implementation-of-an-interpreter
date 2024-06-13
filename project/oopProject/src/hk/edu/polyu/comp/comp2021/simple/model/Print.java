package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.ArrayList;
import java.util.HashSet;

/**
 * print class to store print statement
 */
public class Print extends Operation {
    //    private String label;
    private Operation exp;
    private final String expName;
    private final String label;

    /**
     * @param input_ user command input
     */
    public Print(String input_){
        super(input_);
        label = getinput()[1];
        expName = getinput()[2];
    }

    private String getexpName(){
        return this.expName;
    }

    /**
     * @param exp set the operation corresponding to expression name
     */
    public void setexp(Operation exp) {
        this.exp = exp;
    }

    @Override
    public void execute(Instrument instrument){
        setexp(Checking.getvalue(this.getexpName()));
        if (this.exp.gettype()==Typ.INT) {

            System.out.println("["+this.exp.getint_value()+"]");
        }else {
            System.out.println("["+this.exp.getbool_value()+"]");
        }

    }
    @Override
    public void debug(HashSet<String> set, String program, Instrument instrument){
        execute(instrument);
    }
    @Override
    public void printlist(ArrayList<String> list) {
        Checking.listExpression(list, this.expName);

        if (!list.contains(this.getInputString())) {
//        	System.out.println(this.getInputString());
            list.add(this.getInputString());
        }
    }

}


