package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.ArrayList;
import java.util.HashSet;

/**
 * Assign is a class to assign value to a variable
 */
public class Assign extends Operation {
    private final String label;
    private final String varName;
    private final String expName;
    private Operation exp;
//    private Variable v;

    /**
     * @param input_ this is the string that the user input to assign eg. Assign assign1 x 10
     * this is the constructor, we store the information in the command string
     */
    public Assign(String input_){
        super(input_);
        label = getinput()[1];
        this.varName = this.getinput()[2];
        this.expName = this.getinput()[3];
    }

    /**
     * @return expression name (for hidding)
     */
    public String getexpName() {
        return this.expName;
    }

    /**
     * @param exp for the expression name, we find the corresponding Operation type with the expression name
     * this function is used to set expression, for hidding
     */
    public void setexp(Operation exp) {
        this.exp = exp;
    }

    @Override
    public void execute(Instrument instrument) {
//        this.v = this.findToBeassigned();

        setexp(Checking.getvalue(this.getexpName()));
        try{
            setHashMap.getVariableMap().get(varName);
        }catch (NullPointerException e){
            System.out.println("Error"+this.getInputString());
            System.out.println(varName +"hasn't been defined. "+this.getInputString());
            System.exit(0);
        }
        if (this.exp.gettype()==Typ.INT) {
            if (((Variable<?>) setHashMap.getVariableMap().get(varName)).getvalue() instanceof Integer){
                setHashMap.getVariableMap().put(varName, new Variable<>(this.exp.getint_value()));
            }else {
                System.out.println("Error: "+this.getInputString());
                System.out.println("Data type conflict.");
                System.exit(0);
            }
        }else if (this.exp.gettype()==Typ.BOOL) {
            if (((Variable<?>) setHashMap.getVariableMap().get(varName)).getvalue() instanceof Boolean){
                setHashMap.getVariableMap().put(varName, new Variable<>(this.exp.getbool_value()));
            }else {
                System.out.println("Error: "+this.getInputString());
                System.out.println("Data type conflict.");
                System.exit(0);
            }
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



