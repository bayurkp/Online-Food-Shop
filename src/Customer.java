// import java.util.*;

public class Customer {
    private static String custUsername = "customer";
    private static String custPass = "customer";
    
    public static String getCustUsername() {
        return custUsername;
    }

    public static String getCustPass() {
        return custPass;
    }

    // Method menu untuk customer
    public static void menu() {
        App.clearScreen();
        System.out.println(App.BOLD + "\nSelamat datang, Customer!" + App.NORMAL);
        System.out.println("---------------");
        System.out.println("1. Lihat restaurant");
        System.out.println("2. Buat pesanan");
        System.out.println("3. Lihat pesanan");
        System.out.println("0. Kembali ke menu Login");
        
        System.out.print("(Mohon masukkan kode angka untuk melanjutkan)\n> ");
        int select = Input.getInteger(0, 3);
        
        switch (select) {
            case 1:
                Data.showRestaurant();
                break;
            case 2:
                // addOrder();
                break;
            case 3:
                // showOrder();
                break;
            case 0:
                App.login();
                break;
        }
    }

    public static void addOrder() {
        
    }

    public static void main(String[] args) {
        menu();
    }
}
