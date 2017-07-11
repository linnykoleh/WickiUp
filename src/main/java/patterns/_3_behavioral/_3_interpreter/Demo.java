package patterns._3_behavioral._3_interpreter;

/**
 * @author LinnykOleh
 */
public class Demo {

    private static Expression buildInterpreterTree(){
        final Expression terminal1 = new TerminalExpression("Lions");
        final Expression terminal2 = new TerminalExpression("Tigers");
        final Expression terminal3 = new TerminalExpression("Bears");

        final Expression alternative1 = new AndExpression(terminal2, terminal3);

        final Expression alternative2 = new OrExpression(terminal1, alternative1);

        return new AndExpression(terminal3, alternative2);
    }

    public static void main(String[] args) {
//        String context = "Lions";
//        String context = "Tigers";
        String context = "Lions Bears";

        final Expression define = buildInterpreterTree();

        System.out.println(context + " is " + define.interpret(context));
    }
}
