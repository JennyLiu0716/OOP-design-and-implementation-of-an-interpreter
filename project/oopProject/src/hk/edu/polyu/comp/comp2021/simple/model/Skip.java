package hk.edu.polyu.comp.comp2021.simple.model;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 */
public class Skip extends Operation{
    private final String label;

    /**
     * @param input_ user command input
     */
    public Skip(String input_){
        super(input_);
        label = getinput()[1];
    }
    @Override
    public void execute(Instrument instrument){


    }
    @Override
    public void debug(HashSet<String> set, String program, Instrument instrument){
        execute(instrument);
    }
    @Override
    public void printlist(ArrayList<String> list) {

        if (!list.contains(this.getInputString())) {
//        	System.out.println(this.getInputString());
            list.add(this.getInputString());
        }
    }

}
