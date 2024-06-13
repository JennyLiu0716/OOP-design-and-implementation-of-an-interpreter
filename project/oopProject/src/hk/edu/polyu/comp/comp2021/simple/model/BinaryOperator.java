package hk.edu.polyu.comp.comp2021.simple.model;


/**
 * this is an enum for binary operator and corresponding calculation method
 */
public enum BinaryOperator {
    /**
     * ADD is an enum element whose value is "+"
     */
    ADD("+"),
    /**
     * SUB is an enum element whose value is "-"
     */
 SUB("-"),
    /**
     * MUL is an enum element whose value is "*"
     */
 MUL("*"),
    /**
     * DIV is an enum element whose value is "/"
     */
 DIV("/"),
    /**
     * GREATER is an enum element whose value is ">"
     */
    GREATER(">"),
    /**
     * GREATER_OR_EQUAL is an enum element whose value is ">="
     */
GREATER_OR_EQUAL(">="),
    /**
     * LESS is an enum element whose value is "<"
     */
LESS("<"),
    /**
     * LESS_OR_EQUAL is an enum element whose value is "<="
     */
LESS_OR_EQUAL("<="),
    /**
     * EQUAL is an enum element whose value is "=="
     */
    EQUAL("=="),
    /**
     * NOT_EQUAL is an enum element whose value is "!="
     */
NOT_EQUAL("!="),
    /**
     * REMAINDER is an enum element whose value is "%"
     */
REMAINDER("%"),

    /**
     * AND is an enum element whose value is "&&"
     */
    AND ("&&"),
    /**
     * OR is an enum element whose value is "||"
     */
 OR("||");

    private final String symbol;

    BinaryOperator(String symbol){
        this.symbol=symbol;
    }


    //int to int

    /**
     * @param left the left operation
     * @param right the right operation
     * @return return the int value
     * this function is particular for number and number and result number calculation
     */
    public int calculate(Operation left, Operation right){
        int result = 0;
        switch (this){
            case ADD:
                result = left.getint_value() + right.getint_value();
                result = Checking.resultChecking(result);
                break;
            case SUB:
                result = left.getint_value() - right.getint_value();
                result = Checking.resultChecking(result);
                break;
            case MUL:
                result = left.getint_value() * right.getint_value();
                result = Checking.resultChecking(result);
                break;
            case DIV:
                if (right.getint_value() != 0) {
                    result = left.getint_value() / right.getint_value();
                    result = Checking.resultChecking(result);
                }else {
                    System.out.println("Invalid equation: divided by 0."+left.getint_value()+" "+this.getSymbol()+" "+right.getint_value());
                    System.exit(0);
                }
                break;
            case REMAINDER:
                if (right.getint_value() != 0) {
                    result = left.getint_value() % right.getint_value();
                    result = Checking.resultChecking(result);
                }else {
                    System.out.println("Invalid equation: divided by 0."+left.getint_value()+" "+this.getSymbol()+" "+right.getint_value());
                    System.exit(0);
                }
                break;

        }

        return result;
    }

    /**
     * @param left left operation
     * @param right right operation
     * @return return the boolean value for the result
     * this function is particular for bool and bool result bool
     */
    //boolean to boolean
    public boolean bool_check(Operation left, Operation right){

        return switch (this) {
            case AND -> left.getbool_value() && right.getbool_value();
            case OR -> left.getbool_value() || right.getbool_value();
            case EQUAL -> left.getbool_value() == right.getbool_value();
            case NOT_EQUAL -> left.getbool_value() != right.getbool_value();
            default -> true;
        };
    }

    /**
     * @param left left operation
     * @param right right operation
     * @return boolean value for result
     * this method is particular for int and int result boolean
     */

    public boolean bool_calculate(Operation left, Operation right){

        return switch (this) {
            case GREATER -> left.getint_value() > right.getint_value();
            case GREATER_OR_EQUAL -> left.getint_value() >= right.getint_value();
            case LESS -> left.getint_value() < right.getint_value();
            case LESS_OR_EQUAL -> left.getint_value() <= right.getint_value();
            case EQUAL -> left.getint_value() == right.getint_value();
            case NOT_EQUAL -> left.getint_value() != right.getint_value();
            default -> true;
        };
    }

    /**
     * @return return the symbol of the equation
     */
    public String getSymbol(){
        return this.symbol;
    }


    /**
     * @param symbol the string format of symbol
     * @return get the corresponding element in enum
     */
    public static BinaryOperator fromString(String symbol){
        for(BinaryOperator operator: BinaryOperator.values()){
            if(operator.getSymbol().equals(symbol)){
                return operator;
            }
        }
        return null;
    }
}

