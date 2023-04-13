import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    // Instansiasi objek Scanner untuk input
    private static final Scanner sc = new Scanner(System.in);

    // Method untuk menerima input bertipe data integer dari -Integer.MAX_VALUE
    // sampai +Integer.MAX_VALUE
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

    // Method untuk menerima input bertipe data integer dari batas minimal dari
    // argumen sampai batas maksimal dari argumen
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

    // Method untuk menerima input bertipe data double dari -Double.MAX_VALUE
    // sampai +Double.MAX_VALUE
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

    // Method untuk menerima input bertipe data double dari batas minimal dari
    // argumen sampai batas maksimal dari argumen
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

    // Method untuk input password
    public static String getPassword() {
        Console console = System.console();
        String password = String.valueOf(console.readPassword());

        return password;
    }

    // Method untuk input tipe data string
    public static String getString() {
        String text;
        while (true) {
            text = sc.nextLine();
            if (text != null && text.length() != 0) {
                break;
            } else {
                System.out.print("Input invalid. Mohon ulangi.\n> ");
            }
        }
        return text;
    }

    // Method untuk input string apapun (digunakan untuk menahan program sampai user
    // menginputkan sesuatu)
    public static void getAnyKey() {
        sc.nextLine();
    }
}
