import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);
    public static int getInteger() {
        int num;
        while (true) {
            try {
                num = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Input invalid. Mohon ulangi.\n> ");
                sc.nextLine();
            }
        }
        return num;
    }

    public static int getInteger(int min, int max) {
        int num;
        while (true) {
            try {
                num = sc.nextInt();
                sc.nextLine();
                if (num >= min && num <= max) {
                    break;
                } else {
                    System.out.print("Input invalid. Mohon ulangi.\n> ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Input invalid. Mohon ulangi.\n> ");
                sc.nextLine();
            }
        }
        return num;
    }

    public static double getDouble() {
        double num;
        while (true) {
            try {
                num = sc.nextDouble();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Input invalid. Mohon ulangi.\n> ");
                sc.nextLine();
            }
        }
        return num;
    }

    public static double getDouble(double min, double max) {
        double num;
        while (true) {
            try {
                num = sc.nextDouble();
                sc.nextLine();
                if (num >= min && num <= max) {
                    break;
                } else {
                    System.out.print("Input invalid. Mohon ulangi.\n> ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Input invalid. Mohon ulangi.\n> ");
                sc.nextLine();
            }
        }
        return num;
    }

    public static String getPassword() {
        Console console = System.console();
        String password = String.valueOf(console.readPassword());      

        return password;
    }

    public static String getString() {
        String text = sc.nextLine();
        return text;
    }

    public static void main(String[] args) {
        double num = getDouble(0, 1);
        System.out.println(num);
    }
}

