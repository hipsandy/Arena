package src.com.hipsandy.effJava3;

import java.util.function.DoubleBinaryOperator;

public class MyLambdas {

    public static void main(String[] args) {

        System.out.println("Sum: " + Operation.PLUS.apply(3, 4));


    }


    public enum Operation {
        PLUS ("+", (x, y) -> x + y);

        private final String symbol;
        private final DoubleBinaryOperator op;


        Operation(String symbol, DoubleBinaryOperator op) {
            this.symbol = symbol;
            this.op = op;
        }

        public double apply(double x, double y) {
            return op.applyAsDouble(x, y);
        }
    }

}
