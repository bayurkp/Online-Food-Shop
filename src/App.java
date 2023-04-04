import java.util.*;

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

    public static void adminMenu() {
        System.out.println("Selamat datang kembali, Admin!");
        System.out.println("1. Lihat restaurant");
        System.out.println("2. Tambah restaurant");
        System.out.println("3. Hapus restaurant");
        System.out.println("4. Kembali ke menu Login");
        
        System.out.print("(Mohon masukkan kode angka untuk melanjutkan)\n> ");
        // int menu = Input.getInteger();
    }

    public static void custMenu() {
        System.out.println("Selamat datang kembali, Customer!");
        System.out.println("1. Lihat restaurant");
        System.out.println("2. Buat pesanan");
        System.out.println("3. Lihat pesanan");
        System.out.println("4. Kembali ke menu Login");
        
        System.out.print("(Mohon masukkan kode angka untuk melanjutkan)\n> ");
        // int menu = Input.getInteger();
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Beverly", "Jakarta");
        restaurant.addFood("Ayam Bakar", "10000");
        restaurant.addFood("Gurami Goreng", "20000");

        System.out.println(restaurant.getFoods().get(0).get(0));
    }
}
