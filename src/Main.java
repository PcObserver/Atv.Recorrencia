public class Main {
    static PositionCalculator positionCalculator = new PositionCalculator();
    static TUI tui = new TUI();
    public static void main(String[] args) {
        int option = tui.menu();
        while (option!=0){
            Object result = 0;
            if(option == 1){
                String equiation =  tui.getStringFromUser("Insira a equação, na forma fechada:");
                int n = tui.getIntegerFromUser("Insira a posição desejada:");
                result = positionCalculator.findValueWithExplicitFormula(equiation, n);
            }else if(option == 2){
                String equation =  tui.getStringFromUser("Insira a equação, usanto T(n-1) como o termo anterior. (Ex: T(n-1) +7):");
                int n = tui.getIntegerFromUser("Insira a posição desejada:");
                int firstPositionValue = tui.getIntegerFromUser("Insira o valor da posição inicial da sequência: ");
                result = positionCalculator.findValueWithRecursiveFormula(equation, n, firstPositionValue);
            }
            System.out.println("Resultado = "+result);

            option = tui.menu();
        }

    }



}