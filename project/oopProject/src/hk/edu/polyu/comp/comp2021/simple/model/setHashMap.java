package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.HashMap;

/**
 *
 */
public class setHashMap {
    private static final HashMap<String, Operation> statements = new HashMap<>();
    private static final HashMap<String, Variable> variables = new HashMap<>();
    private static final HashMap<String, Operation> expressions = new HashMap<>();
    private static final HashMap<String, Program> programs = new HashMap<>();


    /**
     * @return the hashmap for statements
     */
    public static HashMap getStatementMap() {
        return statements;
    }

    /**
     * @return the hashmap for programs
     */
    public static HashMap getProgramMap() {
        return programs;
    }

    /**
     * @return the hashmap for expressions
     */
    public static HashMap getExpressionMap() {
        return expressions;
    }

    /**
     * @return the hash map for variables
     */
    //not used
    public static HashMap getVariableMap() {
        return variables;
    }



}
