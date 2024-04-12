import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class PositionCalculator {
    ScriptEngineManager sem = new ScriptEngineManager();
    ScriptEngine se = sem.getEngineByName("JavaScript");
    public Object findValueWithRecursiveFormula(String equation, int n, int n1Value){
        if(n==1) return n1Value;
        String processedEquation = equation.replace("T(n-1)", String.valueOf(findValueWithRecursiveFormula(equation,
                n-1,n1Value)));
        processedEquation = processedEquation.replace("n", String.valueOf(n));
        processedEquation = replacePowersWithMathPow(processedEquation);
        return resolveEquation(processedEquation);
    }

    public  Object findValueWithExplicitFormula(String equation, int n){
        String processedEquation = equation.replace("n", String.valueOf(n));
        processedEquation = replacePowersWithMathPow(processedEquation);

        return resolveEquation(processedEquation);
    }

    private  Object resolveEquation(String processedEquation) {

        try {
            Object r =  se.eval(processedEquation);
            System.out.println(r);
            return r;

        }catch (Exception e){
            System.out.println("Error evaluating the equation: "+ e.getMessage());
            return -1;
        }
    }

    private  String replacePowersWithMathPow(String equation) {
        String regex = "(\\d+(\\.\\d+)?|\\.\\d+|\\([^(^)]+\\)|.+\\))\\^(\\d+(\\.\\d+)?|\\.\\d+|\\([^(^)]+\\))";

        String replacement = "Math.pow($1,$3)";
        while (equation.contains("^"))

        {
            equation = equation.replaceAll(regex, replacement);
        }
        return equation;
    }

}
