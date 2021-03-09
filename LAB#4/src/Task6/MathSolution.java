package Task6;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Scanner;

public class MathSolution {
    private static String[] func1Names = new String[] {"abs", "acos", "asin", "atan", "ceil", "cos", "exp", "floor", "log", "random",
            "round", "sin", "sqrt", "tan"};
    private static String[] func2Names = new String[] {"atan2", "max", "min", "pow"};
    public static void main(String[] args) throws Exception {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        engine.put("pi", Math.PI);
        engine.put("e", Math.E);
        for( String func : func1Names )
            engine.eval(String.format("function %1$s(x){return Math.%1$s(x);}", func));
        for( String func : func2Names )
            engine.eval(String.format("function %1$s(x,y){return Math.%1$s(x,y);}", func));
        System.out.println("Enter a mathematical expression: ");
        String str = new Scanner(System.in).next();
        System.out.print("str = "+engine.eval(str));
    }
}
