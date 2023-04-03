import java.util.Scanner;

public class App {
    private static String adminUsername = "admin";
    private static String adminPass = "admin";
    private static String custUsername = "customer";
    private static String custPass = "customer";
    
    public static void login() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Username > ");
        String username = sc.nextLine();
        System.out.print("Password > ");
        String password = Input.getPassword();

        System.out.println(password);
        if (username.equals(adminUsername) && password.equals(adminPass)) {
            adminMenu();
        } else if (username.equals(custUsername) && password.equals(custPass)) {
            custMenu();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            login();
        }

        sc.close();
    }

    public static void custMenu() {
        System.out.println("Selamat datang kembali, Customer!");
    }

    public static void adminMenu() {
        System.out.println("Selamat datang kembali, Admin!");
    }


    public static void main(String[] args) {
        login();
    }
}
