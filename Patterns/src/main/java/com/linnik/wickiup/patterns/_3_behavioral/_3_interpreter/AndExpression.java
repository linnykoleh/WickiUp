package com.linnik.wickiup.patterns._3_behavioral._3_interpreter;

/**
 * @author LinnykOleh
 */
public class AndExpression implements Expression {

    private Expression expression1;
    private Expression expression2;

    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) && expression2.interpret(context);
    }
}
