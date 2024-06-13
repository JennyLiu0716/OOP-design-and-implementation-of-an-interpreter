package hk.edu.polyu.comp.comp2021.simple.model;

import java.util.ArrayList;

/**
 * Instrument is class to store information for instrument
 */
public class Instrument {
    private static final ArrayList<String> instrumentStat = new ArrayList<>(); // which statement to be instrumented
    private static final ArrayList<String> instrumentVal = new ArrayList<>();  // instrument which value
    private static final ArrayList<String> instrumentPos = new ArrayList<>(); // before or after

    /**
     * constructor
     */
    Instrument(){

    }

    /**
     * @param stat statement string
     * @param pos position string
     * @param val expression string
     */
    public void setInstrument(String stat, String pos, String val){

        //input all instrument, allow multiple statements for one
        instrumentStat.add(stat);
        instrumentVal.add(val);
        instrumentPos.add(pos);
    }

    /**
     * @param program_name to specify which program is corresponds to
     */
    public void checkBefore(String program_name){
        if (setHashMap.getStatementMap().containsKey(program_name)) { // if statement exists
            for (int i = 0; i < instrumentPos.size(); i++) {
                if (program_name.equals(instrumentStat.get(i))) // if statement is intrumented
                    if (instrumentPos.get(i).equals("before")) {
                        Operation exp = Checking.getvalue(instrumentVal.get(i));
                        if (exp.gettype()==Typ.INT) {

                            System.out.println("{"+exp.getint_value()+"}");
                        }else  {
                            System.out.println("{"+exp.getbool_value()+"}");
                        }
                    }
            }
        }
    }

    /**
     * @param program_name to specify which program is corresponds to
     */
    public void checkAfter(String program_name){
        if (setHashMap.getStatementMap().containsKey(program_name)) {
            for (int i = 0; i < instrumentPos.size(); i++) {
                if (program_name.equals(instrumentStat.get(i)))
                    if (instrumentPos.get(i).equals("after")) {
                        Operation exp = Checking.getvalue(instrumentVal.get(i));
                        if (exp.gettype()==Typ.INT) {
                            System.out.println("{"+exp.getint_value()+"}");
                        }else  {
                            System.out.println("{"+exp.getbool_value()+"}");
                        }
                    }
            }
        }
    }
}

