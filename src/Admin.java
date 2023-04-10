// import java.util.*;

public class Admin {
    private static String adminUsername = "admin";
    private static String adminPass = "admin";

    public static String getAdminUsername() {
        return adminUsername;
    }

    public static String getAdminPass() {
        return adminPass;
    }

    // Method menu untuk admin
    public static void menu() {
        App.clearScreen();
        System.out.println(App.BOLD + "\nSelamat datang, Admin!" + App.NORMAL);
        System.out.println("---------------");
        System.out.println("1. Lihat restaurant");
        System.out.println("2. Tambah restaurant");
        System.out.println("3. Hapus restaurant");
        System.out.println("4. Kembali ke menu Login");
        
        System.out.print("(Mohon masukkan kode angka untuk melanjutkan)\n> ");
        int select = 0;
        do {
            select = Input.getInteger();
            if (select <= 1 && select >= 4) System.out.print("Input invalid. Mohon ulangi\n> ");
        } while (select <= 1 && select >= 4);
        
        switch (select) {
            case 1:
                Data.showRestaurant();
                break;
            case 2:
                Data.addRestaurant();
                break;
            case 3:
                // deleteRestaurant();
                break;
            case 4:
                App.login();
                break;
            default:
                break;
        }

        menu();
    }

}
