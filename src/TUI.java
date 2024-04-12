import java.util.Scanner;

public class TUI {
    private static final Scanner scanner = new Scanner(System.in);


    public int menu(){
        int option = 0;
        System.out.println("Escolha um tipo de fórmula:");
        System.out.println("1 -> Forma Fechada.");
        System.out.println("2 -> Forma Recurciva.");
        System.out.println("0 -> Encerrar programa.");
        option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }



    public String getStringFromUser(String label) {
        System.out.println(label);
        return scanner.nextLine();
    }

    public int getIntegerFromUser(String label) {
        System.out.println(label);
        int response = scanner.nextInt();
        scanner.nextLine();
        return response;
    }
}