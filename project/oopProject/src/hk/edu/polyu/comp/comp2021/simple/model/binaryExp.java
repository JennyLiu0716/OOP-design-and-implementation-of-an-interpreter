package hk.edu.polyu.comp.comp2021.simple.model;


import java.util.ArrayList;

/**
 * this is the class for binexpr command processing
 */
//value
public class binaryExp extends Operation {

    private final BinaryOperator binaryOperator;


    private final String Leftname;
    private final String Rightname;

    /**
     * @param input_ this is the user input command for the constructor
     */
    public binaryExp(String input_) {
        super(input_);
        this.binaryOperator = BinaryOperator.fromString(this.getinput()[3]);
        this.Leftname = this.getinput()[2];
        this.Rightname = this.getinput()[4];
    }


    @Override
    public void execute() {

        Operation left = Checking.getvalue(Leftname);
        Operation right = Checking.getvalue(Rightname);
        Typ left_type = left.gettype();
        Typ right_type = right.gettype();
        Typ type;
        if (left_type == Typ.INT) {
            if (right_type == Typ.INT){
                if (getinput()[3].equals("+") || getinput()[3].equals("-") || getinput()[3].equals("*") || getinput()[3].equals("/") || getinput()[3].equals("%")) {
                    super.set_intValue(binaryOperator.calculate(left, right));
                    type = Typ.INT;
                    super.set_type(Typ.INT);
                } else if (getinput()[3].equals(">") || getinput()[3].equals("<") || getinput()[3].equals(">=") ||
                        getinput()[3].equals("<=") || getinput()[3].equals("==") || getinput()[3].equals("!=")) {
                    super.set_boolValue(binaryOperator.bool_calculate(left, right));
                    type = Typ.BOOL;
                    super.set_type(Typ.BOOL);

                }else {
                    System.out.println("Error"+this.getInputString());
                    System.out.println("Invalid operator:"+this.getInputString());
                    System.exit(0);
                }
            }else {
                System.out.println("Error"+this.getInputString());
                System.out.println("Not corresponding data type for 2 expressions: "+this.getInputString());
                System.exit(0);
            }

        } else if (left_type == Typ.BOOL) {
            if (right_type ==Typ.BOOL){
                if (this.getinput()[3].equals("&&") || getinput()[3].equals("||") || getinput()[3].equals("==")|| getinput()[3].equals("!=") ){
                    super.set_boolValue(binaryOperator.bool_check(left, right));
                    type = Typ.BOOL;
                    super.set_type(Typ.BOOL);
                }else {

                    System.out.println("Invalid operator:"+this.getInputString());
                    System.exit(0);
                }

            }else {
                System.out.println("Not corresponding data type for 2 expressions: "+this.getInputString());
                System.exit(0);

            }

//          this.set_boolValue(binaryOperator.bool_check(left, right));
        }
//      System.out.println(this.getbool_value());

    }


    @Override
    public void printlist(ArrayList<String> list) {
        Checking.listExpression(list, this.Leftname);
        Checking.listExpression(list, this.Rightname);

        if (!list.contains(this.getInputString())) {
//    	System.out.println(this.getInputString());
            list.add(this.getInputString());
        }
    }


}