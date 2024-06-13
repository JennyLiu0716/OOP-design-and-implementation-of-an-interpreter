package hk.edu.polyu.comp.comp2021.simple.model;


import java.io.*;
import java.nio.charset.StandardCharsets;

import static hk.edu.polyu.comp.comp2021.simple.model.InputProcessing.*;

/**
 * class to load program
 */
public class LoadProgram {
    private final String path;
    private final String programName;

    /**
     * @param input_ user command input
     */
    public LoadProgram(String input_){
        String[] input = input_.split(" ");
        path = input[1];
        programName = input[2];
    }

    /**
     * load function to read the file and load into project
     */
    public void Load(){
        BufferedReader reader = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(this.path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            reader = new BufferedReader(inputStreamReader);
            String com;
            while ((com = reader.readLine()) != null) {
                String[] inputlist = com.split(" ");
//            	System.out.println(com);
                switch (inputlist[0]) {
                    case "vardef" -> vardefChecking(com);
                    case "binexpr" -> binexprChecking(com);
                    case "unexpr" -> unexprChecking(com);
                    case "assign" -> assignChecking(com);
                    case "print" -> printChecking(com);
                    case "skip" -> skipChecking(com);
                    case "block" -> blockChecking(com);
                    case "if" -> ifChecking(com);
                    case "while" -> whileChecking(com);
                    case "program"-> {
                        com = inputlist[0] + " " + programName + " " + inputlist[2];
                        programChecking(com);
                    }

                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

