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

    public static void menu() {
        System.out.println("Selamat datang kembali, Customer!");
        System.out.println("1. Lihat restaurant");
        System.out.println("2. Buat pesanan");
        System.out.println("3. Lihat pesanan");
        System.out.println("4. Kembali ke menu Login");
        
        System.out.print("(Mohon masukkan kode angka untuk melanjutkan)\n> ");
        int select = 0;
        do {
            select = Input.getInteger();
            if (select <= 1 && select >= 4) System.out.print("Input invalid. Mohon ulangi\n> ");
        } while (select <= 1 && select >= 4);
        
        switch (select) {
            case 1:
                // showRestaurant();
                break;
            case 2:
                // addOrder();
                break;
            case 3:
                // showOrder();
                break;
            case 4:
                App.login();
                break;
        }
    }
}
