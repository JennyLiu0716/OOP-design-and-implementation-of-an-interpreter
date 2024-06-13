package hk.edu.polyu.comp.comp2021.simple.model;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 */
public class Program  {
//    public String label;

    private final String program_name;
    private final ArrayList<String> list = new ArrayList<>();
    private static final HashSet<String> breakpoints = new HashSet<>();

    private final String program;
    private final String inputString;
    private static final Instrument instrument = new Instrument();


    /**
     * @param input_ user input command
     */
    public Program(String input_){
//        label = this.getinput()[1];
        this.program_name = input_.split(" ")[2];
        this.program = input_.split(" ")[1];
        this.inputString = input_;
    }

    /**
     * @param lab statement name
     * @param pos position eg.before,after
     * @param expName expression name
     */
    public void addinstrument(String lab, String pos, String expName){


        if (!(pos.equals("after")||pos.equals("before"))){
            System.out.println("invalid position: "+pos);
        }else{
            instrument.setInstrument(lab,pos,expName);
        }
    }

    /**
     * @param s the statement name of the breakpoint
     */
    public void setbreakpoint(String s){

        if (breakpoints.contains(s)){
            breakpoints.remove(s);
        }
        else breakpoints.add(s);


    }


    /**
     * debug function
     */
    public void debug(){
        setHashMap.getVariableMap().clear();
        instrument.checkBefore(program_name);
        Checking.debugStatement(program_name,breakpoints,program,instrument);
        instrument.checkAfter(program_name);
    }

    /**
     * execute function
     */
    public void execute(){
        setHashMap.getVariableMap().clear();
        instrument.checkBefore(program_name);
        Checking.executeStatement(program_name, instrument);
        instrument.checkAfter(program_name);

    }

    /**
     * the function to print the list of statements
     */
    public void printList() {
        Checking.listStatement(this.list,this.program_name);
        list.add(this.inputString);
        for (String s : list) {
            System.out.println(s);
        }

    }

    /**
     * @param path the path to store the program
     */
    public void store(String path) {
        this.list.clear();
        Checking.listStatement(this.list,this.program_name);
        list.add(this.inputString);

        BufferedWriter writer = null;
        File file = new File(path);
        // create a new file if the file doesn't exist
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // write the data into the file
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false), StandardCharsets.UTF_8));
            for (String s : list) {
                writer.write(s);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}