package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * the Block class for block storage
 */
public class Block extends Operation {
    private final String label;
    private final List<String> list = new ArrayList<>();

    /**
     * @param input_ user input command string
     */
    public Block(String input_){
        super(input_);
        label = this.getinput()[1];
        for (int i = 2,j=0; i<this.getinput().length;i++,j++){
            list.add(getinput()[i]);
        }
    }
    //x=100 exp1 = 2000 exp2 = -2000 x = -2000 40000

    @Override
    public void execute(Instrument instrument){
        for (String s : list) {
//        	System.out.println(list.get(i));

            instrument.checkBefore(s);
            Checking.executeStatement(s, instrument);
            instrument.checkAfter(s);

        }

    }
    @Override
    public void debug(HashSet<String> set, String program, Instrument instrument){
        for (String s : list) {
//        	System.out.println(list.get(i));
            instrument.checkBefore(s);
            Checking.debugStatement(s, set, program, instrument);
            instrument.checkAfter(s);
        }
    }
    @Override
    public void printlist(ArrayList<String> newlist) {
        for (String s : this.list) {
            Checking.listStatement(newlist, s);
        }
//    	System.out.println(!list.contains(this.getInputString()));
        if (!newlist.contains(this.getInputString())) {
//        	System.out.println(this.getInputString());
            newlist.add(this.getInputString());
        }
    }
}
