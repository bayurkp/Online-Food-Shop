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
        
        System.out.print("*(Mohon masukkan kode angka untuk melanjutkan)\n> ");
        int select = 0;
        do {
            select = Input.getInteger();
            if (select <= 1 && select >= 4) {
                System.out.print("Input invalid. Mohon ulangi\n> ");
            }
        } while (select <= 1 && select >= 4);
        
        switch (select) {
            case 1:
                Data.showRestaurant();
                break;
            case 2:
                addRestaurant();
                break;
            case 3:
                removeRestaurant();
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
                    restaurant.addDrink(menuName, menuPrice);
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

    // Method untuk mengahpus data restaurant 
    public static void removeRestaurant() {
        App.clearScreen();
        // Cek apakah data restaurant dimiliki oleh list restaurants 
        if (Data.getRestaurants().size() == 0) {
            System.out.println("Tidak ada restaurant teregistrasi.");
            System.out.print("*(Tekan enter untuk melanjutkan....)");
            Input.getString();
            return;
        }

        // Menampilkan menu hapus restaurant
        System.out.println(App.BOLD + "\nHapus Restaurant" + App.NORMAL);
        System.out.println("---------------");
        System.out.println("1. Tampilkan Restaurant");
        System.out.println("2. Hapus Restaurant");
        System.out.println("0. Kembali");
 
        System.out.print("*(Mohon masukkan kode angka untuk melanjutkan)\n> ");
        int select = 0;
        do {
            select = Input.getInteger();
            if (select < 0 || select > 2) {
                System.out.println("Input invalid. Mohon ulangi\n> ");
            }
        } while (select < 0 || select > 2);

        if (select == 0) {
            return;
        } else if (select == 1) {
            // Menampilkan data restaurant
            Data.showRestaurant();
        } else {
            // Meminta input ID restaurant yang akan dihapus
            App.clearScreen();
            System.out.println(App.BOLD + "\nHapus Restaurant" + App.NORMAL);
            System.out.println("---------------");
            System.out.println("Masukkan ID restaurant untuk menghapus");
            System.out.print("*(0 untuk kembali)\n> ");
            int idRestaurant = 0;
            do {
                idRestaurant = Input.getInteger();
                if (idRestaurant < 0 || idRestaurant > Data.getRestaurants().size()) {
                    System.out.println("Input invalid. Mohon ulangi\n> ");
                }
            } while (idRestaurant < 0 || idRestaurant > Data.getRestaurants().size());

            if (idRestaurant == 0) {
                return;
            }
            
            // Mengonfirmasi hapus data
            System.out.printf(App.BOLD + "Hapus %s-%s\n" + App.NORMAL, Data.getRestaurants().get(idRestaurant - 1).getName(), Data.getRestaurants().get(idRestaurant - 1).getAddress());
            System.out.print("Masukkan 1 untuk hapus dan 0 untuk kembali\n> ");
            int confirm = 0;
            do {
                confirm = Input.getInteger();
                if (confirm != 0 && confirm != 1) {
                    System.out.println("Input invalid. Mohon ulangi\n> ");
                }
            } while (confirm != 0 && confirm != 1);

            if (confirm == 0) {
                return;
            } else {
                Data.removeRestaurant(idRestaurant - 1);
            }
        }
    }
}
