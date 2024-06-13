package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.ArrayList;
import java.util.HashSet;

/**
 *if else class to storage if statement
 */
public class IfElse extends Operation {
    private final String label;
    private final String condition;
    private final String trueStatement;
    private final String falseStatement;

    /**
     * @param input_ input string command
     */
    public IfElse(String input_){
        super(input_);
        this.condition = this.getinput()[2];
        this.trueStatement = this.getinput()[3];
        this.falseStatement = this.getinput()[4];
        label = this.getinput()[1];
    }


    @Override
    public void execute(Instrument instrument){
        if (Checking.getvalue(condition).gettype()==Typ.BOOL){
            if (Checking.getvalue(condition).getbool_value()) {
                instrument.checkBefore(trueStatement);
                Checking.executeStatement(trueStatement,instrument);
                instrument.checkAfter(trueStatement);
            }else  {
                instrument.checkBefore(falseStatement);
                Checking.executeStatement(falseStatement,instrument);
                instrument.checkAfter(falseStatement);
            }
        }else {
            System.out.println("Error: "+this.getInputString());
            System.out.println("condition is not bool value");
            System.exit(0);
        }

    }
    @Override
    public void debug(HashSet<String> set, String program, Instrument instrument){
        if (Checking.getvalue(condition).gettype()==Typ.BOOL){
            if (Checking.getvalue(condition).getbool_value()) {
                instrument.checkBefore(trueStatement);
                Checking.debugStatement(trueStatement,set,program,instrument);
                instrument.checkAfter(trueStatement);
            }else if (!Checking.getvalue(condition).getbool_value()) {
                instrument.checkBefore(falseStatement);
                Checking.debugStatement(falseStatement,set,program,instrument);
                instrument.checkAfter(falseStatement);
            }
        }else {
            System.out.println("Error: "+this.getInputString());
            System.out.println("condition is not bool value");
            System.exit(0);
        }

    }
    @Override
    public void printlist(ArrayList<String> list) {
        Checking.listExpression(list, this.condition);
        Checking.listStatement(list, this.trueStatement);
        Checking.listStatement(list, this.falseStatement);

        if (!list.contains(this.getInputString())) {
//        	System.out.println(this.getInputString());
            list.add(this.getInputString());
        }
    }

}