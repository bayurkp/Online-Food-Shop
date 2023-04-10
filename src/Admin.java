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
                addRestaurant();
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

        // Method untuk menambahkan data restaurant
    public static void addRestaurant() {
        App.clearScreen();
        System.out.println(App.BOLD + "\nTambah Restaurant" + App.NORMAL);
        System.out.println("---------------");

        System.out.print("Masukkan nama restaurant\n> ");
        String restaurantName = Input.getString();
        restaurantName = App.capitalizeWord(restaurantName);

        System.out.print("Masukkan alamat restaurant\n> ");
        String restaurantAddress = Input.getString();
        restaurantAddress = App.capitalizeWord(restaurantAddress);
        App.clearScreen();

        Restaurant restaurant = new Restaurant(restaurantName, restaurantAddress);
        int select = 0;
        int confirm = 0;
        do {
            App.clearScreen();
            System.out.printf(App.BOLD + "Restaurant %s - %s\n" + App.NORMAL, restaurantName, restaurantAddress);
            System.out.println("---------------");
            System.out.println("1. Makanan");
            System.out.println("2. Minuman");
            System.out.print("*(Mohon masukkan kode angka untuk melanjutkan)\n> ");
            do {
                select = Input.getInteger();
                if (select != 1 && select != 2) {
                    System.out.print("Input invalid. Mohon ulangi\n> ");
                }
            } while (select != 1 && select != 2);
            
            System.out.print("Masukkan nama menu\n> ");
            String menuName = Input.getString();
            menuName = App.capitalizeWord(menuName);

            System.out.print("Masukkan harga menu (Rp)\n> ");
            String menuPrice = Double.toString(Input.getDouble());

            switch (select) {
                case 1:
                    restaurant.addFood(menuName, menuPrice);
                    break;
                case 2:
                    restaurant.addDrinks(menuName, menuPrice);
                    break;
                default:
                    System.out.print("Input invalid. Mohon ulangi\n> ");
            }

            System.out.print("Apakah Anda ingin menambah menu lainnya?\n*(1 untuk melanjutkan dan 0 untuk tidak)\n> ");
            do {
                confirm = Input.getInteger();
                if (confirm != 1 && confirm != 0) {
                    System.out.print("Input invalid. Mohon ulangi\n> ");
                }
            } while (confirm != 1 && confirm != 0);
        } while (confirm != 0);
        
        Data.addRestaurants(restaurant);
    }

}
