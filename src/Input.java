import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public static int getInteger() {
        Scanner sc = new Scanner(System.in);
        int num;
        while (true) {
            try {
                num = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Input invalid. Mohon ulangi.\n> ");
                sc.nextLine();
            }
        }

        sc.close();
        return num;
    }

    public static double getDouble() {
        Scanner sc = new Scanner(System.in);
        double num;
        while (true) {
            try {
                num = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Input invalid. Mohon ulangi.\n> ");
                sc.nextLine();
            }
        }

        sc.close();
        return num;
    }

    public static String getPassword() {
        Console console = System.console();
        String password = String.valueOf(console.readPassword());      

        return password;
    }

    public static void main(String[] args) {
        double num = getDouble();
        System.out.println(num);
    }
}

