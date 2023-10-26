package Stack;

import java.util.Stack;

// Note: It is not the complete code for Arithmetic Expression Evaluation
// Doesn't support 2 digit numbers, only supports + and * and so on


// Two Stack Algorithm my Dijkstra
public class ArithmeticExpressionEvaluationUsingStack {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> values = new Stack<Double>();

        if (args.length == 0) {
            return;
        }

        String expression = args[0];
        int i = 0;

        while (i < expression.length()) {
            char s = expression.charAt(i);
            if (s == '(') {
            } else if (s == '+')
                ops.push("+");
            else if (s == '*')
                ops.push("*");
            else if (s == ')') {
                String op = ops.pop();
                if (op.equals("+"))
                    values.push(values.pop() + values.pop());
                else if (op.equals("*"))
                    values.push(values.pop() * values.pop());
            } else {
                String stringVal = String.valueOf(s);
                values.push(Double.parseDouble(stringVal));

            }
            i++;
        }
        System.out.println(values.pop());
    }

}
