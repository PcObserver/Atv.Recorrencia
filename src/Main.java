import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Main {
    public static void main(String[] args) {
        String equiation = "T(n-1)^n";
        Object result = calculateRecurrenceSequencePositionValue(equiation, 3, 2);
        System.out.println("Result = "+result);
    }

    private static Object calculateRecurrenceSequencePositionValue(String equation, int n, int n1Value){
        if(n==1) return n1Value;
        String processedEquation = equation.replace("T(n-1)", String.valueOf(calculateRecurrenceSequencePositionValue(equation,
                n-1,n1Value)));
        processedEquation = processedEquation.replace("n", String.valueOf(n));
        processedEquation = replacePowersWithMathPow(processedEquation);
        return resolveEquation(processedEquation);
    }

    private static Object resolveEquation(String processedEquation) {
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine se = sem.getEngineByName("JavaScript");
        try {
            Object r =  se.eval(processedEquation);
            return r;

        }catch (Exception e){
            System.out.println("Error evaluating the equation: "+ e.getMessage());
            return -1;
        }
    }

    private static String replacePowersWithMathPow(String equation) {
        String regex = "(\\d+(\\.\\d+)?|\\.\\d+|\\([^(^)]+\\))\\^(\\d+(\\.\\d+)?|\\.\\d+|\\([^(^)]+\\))";

        String replacement = "Math.pow($1,$3)";
        while (equation.contains("^"))

        {
            equation = equation.replaceAll(regex, replacement);
        }
        return equation;
    }


}