package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 */
public class While extends Operation{

    private Operation statement;
    private final String expName;
    private final String statementName;

    /**
     * @param input_ user input command
     */
    public While(String input_) {
        super(input_);
//        label = getinput()[1];
        this.expName = getinput()[2];
        this.statementName = getinput()[3];

    }

    /**
     * @return get the statement name
     */
    public String getStatementName() {
        return this.statementName;
    }

    @Override
    public void execute(Instrument instrument) {
//    	setExp(Checking.getvalue(expName));
        if (Checking.getvalue(expName).gettype()==Typ.BOOL){
            while (Checking.getvalue(expName).getbool_value()) {
                instrument.checkBefore(this.getStatementName());
                Checking.executeStatement(this.getStatementName(),instrument);
                instrument.checkAfter(this.getStatementName());
            }
        }else {
            System.out.println("Error: "+this.getInputString());
            System.out.println("condition is not bool value");
            System.exit(0);
        }

    }
    @Override
    public void debug(HashSet<String> set, String program, Instrument instrument){
        if (Checking.getvalue(expName).gettype()==Typ.BOOL){
            while (Checking.getvalue(expName).getbool_value()) {
                instrument.checkBefore(this.getStatementName());
                Checking.debugStatement(this.getStatementName(),set,program,instrument);
                instrument.checkAfter(this.getStatementName());
            }
        }else {
            System.out.println("Error: "+this.getInputString());
            System.out.println("condition is not bool value");
            System.exit(0);
        }

    }
    @Override
    public void printlist(ArrayList<String> list) {
        Checking.listExpression(list, this.expName);
        Checking.listStatement(list, this.statementName);

        if (!list.contains(this.getInputString())) {
//        	System.out.println(this.getInputString());
            list.add(this.getInputString());
        }
    }
}


