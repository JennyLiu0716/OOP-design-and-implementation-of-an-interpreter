package hk.edu.polyu.comp.comp2021.simple.model;


/**
 * unary operator enum
 */
public enum UnaryOperator {
    /**
     * element PLUS corresponds to #
     */
    PLUS("#"),
    /**
     * element MINUS corresponds to ~
     */
 MINUS("~"),
    /**
     * element NOT corresponds to !
     */
NOT("!");
    private final String symbol;

    UnaryOperator(String symbol){
        this.symbol=symbol;
    }

    /**
     * @param op operator
     * @return calculation result (for int type)
     */
    public int calculateInt(Operation op) {
        int result = 0;
        switch (this) {
            case PLUS -> {
                result = op.getint_value();
                result = Checking.resultChecking(result);
            }
            case MINUS -> {
                result = -op.getint_value();
                result = Checking.resultChecking(result);
            }
        }
        return result;
    }

    /**
     * @param op operator
     * @return calculation result for bool type
     */
    public boolean calculateBool(Operation op) {
        return  !op.getbool_value();
    }

    /**
     * @return the symbol of the object
     */
    public String getSymbol(){
        return this.symbol;
    }



    /**
     * @param symbol string symbol
     * @return the corresponding enum element
     */
    public static UnaryOperator fromString(String symbol){
        for(UnaryOperator operator: UnaryOperator.values()){
            if(operator.getSymbol().equals(symbol)){
                return operator;
            }
        }
        return null;
    }
}
