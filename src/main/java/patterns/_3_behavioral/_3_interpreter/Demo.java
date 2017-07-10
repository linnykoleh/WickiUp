package patterns._3_behavioral._3_interpreter;

/**
 * @author LinnykOleh
 */
public class Demo {

    private static Expression buildInterpreterTree(){
        Expression expression = new TerminalExpression("Lions");
        return expression;
    }

    public static void main(String[] args) {
        String context = "Lions";
        final Expression define = buildInterpreterTree();

        System.out.println(context + " is " + define.interpret(context));
    }
}
