import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine se = sem.getEngineByName("JavaScript");
        String equiation = "2^2";
        Object result = resolveEquation(equiation, 2, 2);
        System.out.println("Result = "+result);
    }

    private static Object resolveEquation(String equation, int n, int n1Value){
        if(n==1) return n1Value;
        String processedEquation = equation.replace("T(n-1)", String.valueOf(resolveEquation(equation,
                n-1,n1Value)));
        System.out.println(processedEquation);
        processedEquation = replacePowersWithMathPow(processedEquation);
        System.out.println(processedEquation);
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine se = sem.getEngineByName("JavaScript");
        try {
            Object r =  se.eval(processedEquation);
            System.out.println(r);
            return r;

        }catch (Exception e){
            System.out.println("Error evaluating the equation: "+ e.getMessage());
            return -1;
        }
    }
    private static String replacePowersWithMathPow(String equation) {
        String regex = "(\\d+(\\.\\d+)?|\\([^(^)]+\\))\\^(\\d+(\\.\\d+)?|\\.\\d+|\\([^(^)]+\\))";
        String replacement = "Math.pow($1, $3)";
        while (equation.matches("." + regex + "."))

        {
            equation = equation.replaceAll(regex, replacement);
        }
        return equation;
    }


}