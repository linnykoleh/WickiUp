package com.linnik.wickiup.patterns._3_behavioral._3_interpreter;

import java.util.StringTokenizer;

/**
 * @author LinnykOleh
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        final StringTokenizer st = new StringTokenizer(context);
        while(st.hasMoreElements()){
            String test = st.nextToken();
            if (test.equals(data)) {
                return true;
            }
        }
        return false;
    }
}
